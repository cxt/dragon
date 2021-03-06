package com.cxt.client;

import com.cxt.codec.RpcDecoder;
import com.cxt.codec.RpcEncoder;
import com.cxt.rpc.model.RpcRequest;
import com.cxt.rpc.model.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author Administrator
 * @date   2018/3/29
 */
public class RpcClient extends SimpleChannelInboundHandler<RpcResponse>{
    private Logger LOGGER = LoggerFactory.getLogger(RpcClient.class);
    private final String host;
    private final Integer port;
    private RpcResponse response;

    public RpcClient(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponse msg) throws Exception {
        this.response = msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("clien catch a exception",cause);
        ctx.close();
    }

    public RpcResponse send(RpcRequest request) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new RpcEncoder(RpcRequest.class))
                                    .addLast(new RpcDecoder(RpcDecoder.class))
                                    .addLast(RpcClient.this);
                        }
                    });

            bootstrap.option(ChannelOption.TCP_NODELAY,true);
            ChannelFuture future = bootstrap.connect(host, port).sync();
            Channel channel = future.channel();
            channel.writeAndFlush(request).sync();
            channel.closeFuture().sync();

            return response;
        }finally {
            group.shutdownGracefully();
        }
    }
}
