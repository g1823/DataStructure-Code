package chapter02_linearList.stack;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/3/17 21:09
 * @Author gaojie
 * @description: 堆栈的接口，规定堆栈应该实现的方法以及模板
 */
public interface MyStack<T> {

    /**
     * 判断一个栈内元素是否到达最大容量，即栈已满
     *
     * @return 栈内元素是否已满
     */
    public boolean isFull();

    /**
     * 向栈中推入一个元素
     *
     * @param item 带入栈元素
     */
    public void push(T item);

    /**
     * 判断一个栈是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty();

    /**
     * 取出栈顶元素
     *
     * @return 栈顶的元素
     */
    T pop();

    /**
     * 查看栈顶的元素，但不取出
     *
     * @return 栈顶元素
     */
    T peek();
}
