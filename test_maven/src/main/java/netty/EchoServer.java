package netty;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * netty服务端 它包含业务逻辑，决定当有一个请求连接或接收数据时该做什么
 */
public class EchoServer {
    /**
     * 线程组
     */
    private EventLoopGroup eventLoopGroup;

    /**
     * 绑定端口
     */
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    /**
     * 执行方法
     */
    public void start() throws InterruptedException {

        try {


            //创建引导类：端口绑定,启动NETTY服务
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //创建NioEventLoopGroup 线程组来处理事件，如接受新连接、接收数据、写数据等等 包括boss,worker
            eventLoopGroup  = new NioEventLoopGroup();
            //指定通道类型为NioServerSocketChannel，设置InetSocketAddress让服务器监听某个端口已等待客户端连接，并配置线程组
            serverBootstrap.group(eventLoopGroup).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress("localhost",port)).childHandler(new ChannelInitializer<Channel>() {
                //设置childHandler执行所有的连接请求
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new EchoInServerHandler());
                }
            });
            // 线程同步阻塞等待服务器绑定到指定端口
            ChannelFuture channelFuture  = serverBootstrap.bind().sync();
            //成功绑定到端口之后,给channel增加一个 管道关闭的监听器并同步阻塞,直到channel关闭,线程才会往下执行,结束进程。
            channelFuture.channel().closeFuture().sync();

        }finally {
            //优雅的关机
            eventLoopGroup.shutdownGracefully().sync();
        }

    }

    /**
     * 启动方法
     */
    public static void main(String[] args) throws InterruptedException {
        EchoServer echoServer = new EchoServer(8899);
        echoServer.start();
    }

    /**
     *     public Promise<V> sync() throws InterruptedException {
     *         await();
     *         rethrowIfFailed();  // 异步操作失败抛出异常
     *         return this;
     *     }
     *
     *    Future类
     *         // 异步操作完成且正常终止
     *     boolean isSuccess();
     *     // 异步操作是否可以取消
     *     boolean isCancellable();
     *     // 异步操作失败的原因
     *     Throwable cause();
     *     // 添加一个监听者，异步操作完成时回调，类比javascript的回调函数
     *     Future<V> addListener(GenericFutureListener<? extends Future<? super V>> listener);
     *     Future<V> removeListener(GenericFutureListener<? extends Future<? super V>> listener);
     *     // 阻塞直到异步操作完成
     *     Future<V> await() throws InterruptedException;
     *     // 同上，但异步操作失败时抛出异常
     *     Future<V> sync() throws InterruptedException;
     *     // 非阻塞地返回异步结果，如果尚未完成返回null
     *     V getNow();
     */


}

