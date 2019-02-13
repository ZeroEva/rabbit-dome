package example.topic;

import com.rabbitmq.client.BuiltinExchangeType;
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
        // 交换机名称
        String excName = MqNameConstant.TOPIC_EXCHANGE;
        // 路由键
        String A_INFO = "A.INFO";
        String A_ERROR = "A.ERROR";
        String B_INFO = "B.INFO";
        String B_ERROR = "B.ERROR";

        String key = A_INFO;
        // 获取频道
        Channel channel = MqFactory.getChannel();
        // 声明交换机
        channel.exchangeDeclare(excName, BuiltinExchangeType.TOPIC, true, false, null);
        // 发送消息
        for (int i = 1; i <= 10; i++) {
            String msg = "这是第 [" + i + "] 次产物, 级别: " + key;
            channel.basicPublish(excName, key, null, msg.getBytes());
            System.out.println(TimeUtil.logNow() + " [+] Producer '" + msg + "'");
            //ThreadUtil.sleep(500);
        }
    }

}
