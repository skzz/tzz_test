package netty;



import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import java.util.Date;

public class EchoInServerHandler extends ChannelInboundHandlerAdapter {
    /**
     *ChannelHandlerContext pipeline 中handle共享的
     * 客户端请求读取方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("server 读取数据……");
        //读取数据
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        //序列化
        String body = new String(req, "UTF-8");
        System.out.println("接收客户端数据:" + body);
        //向客户端写数据
        System.out.println("server向client发送数据" + body);
        String currentTime = new Date(System.currentTimeMillis()).toString();
        //bytes转byteBuff
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //然后从byteBuff中写入通道,但是这个write动作也是异步，不是及时执行得。
        ChannelFuture channelFuture = ctx.writeAndFlush(resp); //刷新后才将数据发出到SocketChannel
        channelFuture.addListener(ChannelFutureListener.CLOSE); //关闭跟客户端的连接通道
        //所以可能下面得代码会先执行
        // System.out.println("通道写入");
    }

    /**
     * 读取数据完毕走的方法
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server 读取数据完毕..");
    }

    /**
     * 异常捕获处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        //停止往下进行handle
        ctx.close();
    }


}
