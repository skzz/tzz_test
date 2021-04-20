package netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class EchoInClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private ChannelFuture  channelFuture;
    //客户端连接服务器成功后被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接服务器，开始发送数据……");
        byte[] req = "你好啊，请给我发送现在的时间（客户端）".getBytes();
        ByteBuf  firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
        channelFuture = ctx.writeAndFlush(firstMessage);
    }
    //•	从服务器接收到数据后调用

    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        System.out.println("client 读取server数据..");
        //服务端返回消息后
        ByteBuf buf = byteBuf;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("服务端数据为 :" + body);
        channelFuture.addListener(ChannelFutureListener.CLOSE);//关闭和服务端的连接通道，接着会出发通道的关闭，然后回继续执行sync后面的代码，因为对应的通道为连接通道
    }

    //•	发生异常时被调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exceptionCaught..");
        // 释放资源
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }

    /**
     * 这三个Listener对象定义了对Channel处理时常用的操作，如果符合需求，可以直接使用。
     *     ChannelFutureListener CLOSE = (future) --> {
     *         future.channel().close();   //操作完成时关闭Channel
     *     };
     *
     *     ChannelFutureListener CLOSE_ON_FAILURE = (future) --> {
     *         if (!future.isSuccess()) {
     *             future.channel().close();   // 操作失败时关闭Channel
     *         }
     *     };
     *
     *     ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE = (future) --> {
     *         if (!future.isSuccess()) {
     *             // 操作失败时触发一个ExceptionCaught事件
     *             future.channel().pipeline().fireExceptionCaught(future.cause());
     *         }
     *     };
     */
}

