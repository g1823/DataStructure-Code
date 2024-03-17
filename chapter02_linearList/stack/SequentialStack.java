package chapter02_linearList.stack;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/3/17 21:09
 * @Author gaojie
 * @description: 堆栈的顺序实现
 */
@SuppressWarnings("all")
public class SequentialStack<T> implements MyStack<T> {

    int top = -1;

    Object[] data;

    int maxSize = -1;

    /**
     * 创建一个最大容量为maxSize的空栈
     *
     * @param maxSize 最大容量
     */
    public SequentialStack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public void push(T item) {
        if (top == maxSize - 1) {
            System.out.println("栈已满");
        } else {
            data[++top] = item;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T pop() {
        if (this.top == -1) {
            System.out.println("栈为空");
            return null;
        } else {
            return (T) data[top--];
        }
    }

    @Override
    public T peek() {
        if (this.top == -1) {
            System.out.println("栈为空");
            return null;
        } else {
            return (T) data[top];
        }
    }
}
