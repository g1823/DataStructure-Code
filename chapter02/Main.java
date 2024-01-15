package chapter02;


/**
 * @Package chapter02
 * @Date 2024/1/11 22:08
 * @Author gaojie
 * @description: 参数线性表相关的代码
 */
public class Main {
    public static void main(String[] args) {
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
        System.out.println("长度" + sequentialList.size());
        System.out.println("下标1的元素值：" + sequentialList.get(1));
        System.out.println(sequentialList);

        MyList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.size());
    }
}
