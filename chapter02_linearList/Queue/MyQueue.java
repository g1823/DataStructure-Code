package chapter02_linearList.Queue;

/**
 * @Package chapter02_linearList.Queue
 * @Date 2024/4/16 20:58
 * @Author gaojie
 * @description: 队列接口，规定队列应该实现的方法
 */
public interface MyQueue<T> {

    /**
     * 判断队列是否已满
     *
     * @return 队列是否已满
     */
    boolean isFull();

    /**
     * 像队列中插入一个元素
     * @param item 待插入元素
     */
    void add(T item);

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 取出队列头的元素
     * @return 队列头部元素
     */
    T delete();
}
