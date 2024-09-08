package chapter02_linearList.Queue;

import chapter02_linearList.stack.MyStack;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/4/16 20:25
 * @Author gaojie
 * @description: 队列的顺序实现
 */
@SuppressWarnings("all")
public class SequentialQueue<T> implements MyQueue<T> {

    // 数据存储数组
    Object[] data = null;

    // 头
    int head = 0;

    // 尾
    int tail = 0;

    // 当前数组内元素个数
    int size = 0;

    public SequentialQueue(int maxSize) {
        data = new Object[maxSize];
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void add(T item) {
        if (++size == data.length) {
            System.out.println("队列已满");
        } else {
            tail = ++tail % (data.length - 1);
            data[tail] = item;
        }
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T delete() {
        if (size == 0) {
            System.out.println("队列为空");
            return null;
        } else {
            size--;
            T result = (T) data[head];
            head = (head + 1) % (data.length - 1);
            return result;
        }
    }
}
