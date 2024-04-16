package chapter02_linearList.stack;

import chapter02_linearList.BasicImplementation.LinkedList;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/4/15 20:40
 * @Author gaojie
 * @description: 堆栈的链式实现
 */
@SuppressWarnings("all")
public class LinkedStack<T> implements MyStack<T> {

    /**
     * 指向第一个节点
     */
    private Node firstNode;

    /**
     * 链表长度
     */
    private int size = 0;

    static class Node {
        Object data;
        LinkedStack.Node next;
    }

    public LinkedStack() {
        this.firstNode = null;
    }


    @Override
    public boolean isFull() {
        // 因为链式实现，不会存在满的情况，直接返回false
        return false;
    }

    @Override
    public void push(T item) {
        Node node = new Node();
        node.data = item;
        node.next = this.firstNode;
        this.firstNode = node;
        ++this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T pop() {
        if (this.size == 0) {
            System.out.println("栈为空");
            return null;
        } else {
            Node node = this.firstNode;
            this.firstNode = node.next;
            --this.size;
            return (T) node.data;
        }
    }

    @Override
    public T peek() {
        if (this.size == 0) {
            System.out.println("栈为空");
            return null;
        } else {
            return (T) this.firstNode;
        }
    }
}
