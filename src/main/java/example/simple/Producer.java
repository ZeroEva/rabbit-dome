package example.simple;

import com.rabbitmq.client.Channel;
import constant.MqNameConstant;
import support.MqFactory;
import util.TimeUtil;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/28 16:51
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        // 队列名称
        String queName = MqNameConstant.SIMPLE_QUEUE;
        // 获取频道
        Channel channel = MqFactory.getChannel();
        // 声明队列
        channel.queueDeclare(queName, false, false, false, null);
        // 发送消息
        String message = "Hello World!";
        channel.basicPublish("", queName, null, message.getBytes());
        System.out.println(TimeUtil.logNow() + " [+] Producer '" + message + "'");
    }

}
