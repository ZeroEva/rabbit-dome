package constant;

/**
 * @author 郝雪峰 E-mail:xuefeng.hao@ambow.com
 * @version V1.0
 * @date 创建时间：2019/1/25 9:52
 */
public class MqNameConstant {

    /**
     * SIMPLE_QUEUE: 简单队列
     * WORK_QUEUE: 工作队列
     * WORK_QUEUE_DURABLE: 可持久化的工作队列
     * SUBSCRIBE_EXCHANGE: 订阅/发布 交换机
     * SUBSCRIBE_QUEUE_A: 订阅/发布 队列 A
     * SUBSCRIBE_QUEUE_B: 订阅/发布 队列 B
     * ROUTING_EXCHANGE: 路由 交换机
     * ROUTING_QUEUE_A: 路由 队列 A
     * ROUTING_QUEUE_B: 路由 队列 B
     */
    public static final String SIMPLE_QUEUE = "SIMPLE";
    public static final String WORK_QUEUE = "WORK";
    public static final String WORK_QUEUE_DURABLE = "WORK_DURABLE";

    public static final String SUBSCRIBE_EXCHANGE = "SUBSCRIBE_EXCHANGE";
    public static final String SUBSCRIBE_QUEUE_A = "SUBSCRIBE_A";
    public static final String SUBSCRIBE_QUEUE_B = "SUBSCRIBE_B";

    public static final String ROUTING_EXCHANGE = "ROUTING_EXCHANGE";
    public static final String ROUTING_QUEUE_A = "ROUTING_A";
    public static final String ROUTING_QUEUE_B = "ROUTING_B";
    public static final String ROUTING_KEY_INFO = "INFO";
    public static final String ROUTING_KEY_ERROR = "ERROR";
    public static final String ROUTING_KEY_WARNING = "WARNING";

    public static final String TOPIC_EXCHANGE = "TOPIC_EXCHANGE";
    public static final String TOPIC_QUEUE_A = "TOPIC_A";
    public static final String TOPIC_QUEUE_B = "TOPIC_B";
    public static final String TOPIC_QUEUE_INFO = "TOPIC_INFO";
    public static final String TOPIC_QUEUE_ERROR = "TOPIC_ERROR";
    public static final String TOPIC_KEY_A = "A.#";
    public static final String TOPIC_KEY_B = "B.#";
    public static final String TOPIC_KEY_INFO = "#.INFO";
    public static final String TOPIC_KEY_ERROR = "#.ERROR";

    private MqNameConstant() {
    }

}
