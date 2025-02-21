package jboss.demo03;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by Bob on 2016/4/12.
 */
public class TimeServerHandler extends SimpleChannelHandler {

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent cse) {
    Channel ch = cse.getChannel();

    ChannelBuffer time = ChannelBuffers.buffer(4);
    time.writeInt((int) (System.currentTimeMillis() / 1000));

    ChannelFuture f = ch.write(time);

    f.addListener(new ChannelFutureListener() {
      @Override
      public void operationComplete(ChannelFuture future) {
        Channel ch = future.getChannel();
        ch.close();
      }
    });
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    e.getCause().printStackTrace();
    e.getChannel().close();
  }
}