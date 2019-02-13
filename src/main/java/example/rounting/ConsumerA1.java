package example.rounting;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import constant.MqNameConstant;
import support.MqFactory;
import util.ThreadUtil;
import util.TimeUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/28 16:51
 */
public class ConsumerA1 {

    public static void main(String[] args) throws Exception {
        // 队列名称
        String queName = MqNameConstant.ROUTING_QUEUE_A;
        // 交换机名称
        String excName = MqNameConstant.ROUTING_EXCHANGE;
        // 路由键
        String key1 = MqNameConstant.ROUTING_KEY_INFO;
        String key3 = MqNameConstant.ROUTING_KEY_ERROR;
        // 获取频道
        Channel channel = MqFactory.getChannel();
        // 声明队列
        channel.queueDeclare(queName, true, false, false, null);
        // 声明交换机
        channel.exchangeDeclare(excName, BuiltinExchangeType.DIRECT, true, false, null);
        // 将队列绑定到交换机上
        channel.queueBind(queName, excName, key1);
        channel.queueBind(queName, excName, key3);
        // 声明自己的消费能力
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        // 消费回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(TimeUtil.logNow() + " [-] ConsumerA1 '" + message + "'");
            ThreadUtil.sleep(1000);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        // 消费注册
        //是否开启自动应答，自动应答可能导致数据丢失
        boolean autoAck = false;
        channel.basicConsume(queName, autoAck, deliverCallback, consumerTag -> {
        });
    }
}




