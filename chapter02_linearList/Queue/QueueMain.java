package chapter02_linearList.Queue;

/**
 * @Package chapter02_linearList.Queue
 * @Date 2024/4/17 11:51
 * @Author gaojie
 * @description: 线性结构测试
 */
public class QueueMain {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new SequentialQueue<>(3);
        System.out.println(myQueue.isEmpty());
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println(myQueue.delete());
        myQueue.add(4);
        System.out.println(myQueue.delete());
        System.out.println(myQueue.delete());
        System.out.println(myQueue.delete());
    }
}
