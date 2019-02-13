package support;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import constant.MqConfigConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/25 9:53
 */
public class MqFactory {

    private MqFactory() {
    }

    private static ConnectionFactory factory;
    private static Connection connection;
    private static Channel channel;

    public static ConnectionFactory getFactory() {
        if (factory == null) {
            factory = new ConnectionFactory();
            factory.setHost(MqConfigConstant.HOST);
            factory.setPort(MqConfigConstant.PORT);
            factory.setVirtualHost(MqConfigConstant.VIRTUAL_HOST);
            factory.setUsername(MqConfigConstant.USERNAME);
            factory.setPassword(MqConfigConstant.PASSWORD);
        }
        return factory;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = getFactory().newConnection();
            } catch (IOException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Channel getChannel() {
        if (channel == null) {
            try {
                return getConnection().createChannel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return channel;
    }

}
