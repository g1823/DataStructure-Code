package chapter02;


/**
 * @Package chapter02
 * @Date 2024/1/11 22:08
 * @Author gaojie
 * @description: 参数线性表相关的代码
 */
public class Main {
    public static void main(String[] args) {
        testSequentialList();
        testLinkedList();
    }

    public static void testSequentialList() {
        MyList<Integer> sequentialList = new SequentialList<>();
        sequentialList.add(1);
        sequentialList.add(2);
        sequentialList.add(4);
        System.out.println("4所属的下标" + sequentialList.indexOf(4));
        System.out.println("长度" + sequentialList.size());
        System.out.println(sequentialList);
        sequentialList.add(2, 3);
        System.out.println("长度" + sequentialList.size());
        System.out.println(sequentialList);
        sequentialList.delete(4);
        System.out.println("4所属的下标" + sequentialList.indexOf(4));
        System.out.println("顺序表的长度" + sequentialList.size());
        System.out.println("下标1的元素值：" + sequentialList.get(1));
        System.out.println(sequentialList);
    }

    public static void testLinkedList() {
        MyList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList);
        linkedList.add(0, 0);
        linkedList.add(3);
        System.out.println(linkedList);
        linkedList.delete(2);
        System.out.println(linkedList);
        System.out.println("下标0的值：" + linkedList.get(0));
        System.out.println("下标1的值为：" + linkedList.indexOf(1));
        System.out.println("链表的长度：" + linkedList.size());
    }
}
