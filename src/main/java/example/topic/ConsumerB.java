package example.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import constant.MqNameConstant;
import support.MqFactory;
import util.TimeUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/28 16:51
 */
public class ConsumerB {

    public static void main(String[] args) throws Exception {
        // 队列名称
        String queName = MqNameConstant.TOPIC_QUEUE_B;
        // 交换机名称
        String excName = MqNameConstant.TOPIC_EXCHANGE;
        // 获取频道
        Channel channel = MqFactory.getChannel();
        // 声明队列
        channel.queueDeclare(queName, true, false, false, null);
        // 声明交换机
        channel.exchangeDeclare(excName, BuiltinExchangeType.TOPIC, true, false, null);
        // 将队列绑定到交换机上
        channel.queueBind(queName, excName, MqNameConstant.TOPIC_KEY_B);
        // 消费回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(TimeUtil.logNow() + " [-] ConsumerB '" + message + "'");
        };
        // 消费注册
        channel.basicConsume(queName, true, deliverCallback, consumerTag -> {
        });
    }
}




