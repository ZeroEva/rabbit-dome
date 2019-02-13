package example.rounting;

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
        String excName = MqNameConstant.ROUTING_EXCHANGE;
        // 路由键
        String info = MqNameConstant.ROUTING_KEY_INFO;
        String warning = MqNameConstant.ROUTING_KEY_WARNING;
        String error = MqNameConstant.ROUTING_KEY_ERROR;

        // 获取频道
        Channel channel = MqFactory.getChannel();
        // 发送消息
        for (int i = 1; i <= 10; i++) {
            String msg = "这是第 [" + i + "] 次产物";
            channel.basicPublish(excName, info, null, msg.getBytes());
            System.out.println(TimeUtil.logNow() + " [+] Producer '" + msg + "'");
            //ThreadUtil.sleep(500);
        }
    }

}
