package chapter02_linearList.BasicImplementation;

/**
 * @Package chapter02
 * @Date 2024/1/15 22:22
 * @Author gaojie
 * @description: 线性表的实现：链表
 */
public class LinkedList<T> implements MyList<T> {
    Node firstNode = null;

    static class Node {
        Object data;
        Node next = null;
    }

    LinkedList() {
    }

    @Override
    public int indexOf(Object o) {
        if (firstNode == null) {
            return -1;
        }
        Node tempNode = firstNode;
        int index = -1;
        do {
            if (o.equals(tempNode.data)) {
                return ++index;
            }
            ++index;
            tempNode = tempNode.next;
        } while (tempNode.next != null);
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Node temNode = getNode(index);
        if (temNode == null) {
            return null;
        } else {
            return (T) temNode.data;
        }
    }

    /**
     * 获取index下标的元素结点Node
     *
     * @param index 待获取位置下标
     * @return 该下标的值Node，没有该下标的值时返回null。
     */
    private Node getNode(int index) {
        if (index < 0) {
            return null;
        }
        int i = 0;
        Node temNode = firstNode;
        do {
            if (i == index) {
                return temNode;
            }
            ++i;
            temNode = temNode.next;
        }
        while (temNode.next != null);
        if (i == index) {
            return temNode;
        }
        return null;
    }

    @Override
    public void add(int index, T value) {
        // 创建新的结点
        Node dataNode = new Node();
        dataNode.data = value;
        // 插入位置为第一个结点
        if (index == 0) {
            dataNode.next = firstNode;
            firstNode = dataNode;
            return;
        }
        // 获取待插入结点的上一个结点
        Node temNode = getNode(index - 1);
        if (temNode != null) { // 插入
            dataNode.next = temNode.next;
            temNode.next = dataNode;
        } else {
            System.out.println("index参数错误");
        }
    }

    @Override
    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node();
            firstNode.data = value;
        } else {
            Node temNode = firstNode;
            while (temNode.next != null) {
                temNode = temNode.next;
            }
            temNode.next = new Node();
            temNode.next.data = value;
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            firstNode = firstNode.next;
        }
        Node temNode = getNode(index - 1);
        if (temNode == null || temNode.next == null) {
            return;
        }
        temNode.next = temNode.next.next;
    }

    @Override
    public int size() {
        if (firstNode == null) {
            return 0;
        }
        int count = 1;
        Node temNode = firstNode;
        while (temNode.next != null) {
            ++count;
            temNode = temNode.next;
        }
        return count;
    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temNode = firstNode;
        while (temNode.next != null) {
            sb.append(temNode.data).append(",");
            temNode = temNode.next;
        }
        sb.append(temNode.data).append("]");
        return sb.toString();
    }
}
