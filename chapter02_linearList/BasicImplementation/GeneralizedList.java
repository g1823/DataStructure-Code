package chapter02_linearList.BasicImplementation;

/**
 * @Package chapter02
 * @Date 2024/1/16 21:33
 * @Author gaojie
 * @description: 广义表的数据结构，对表的操作不做实现
 */
public class GeneralizedList<T> {
    // 广义表内只存储第一个结点
    GNode<T> head;

    static class GNode<T> {
        int tag;  // 标志域：0表示结点是单元素，1表示结点是广义表

        GNode<T> next;    // 指向后继结点

        // 数据区域要么为另一个广义表，要么为具体数据
        T data;   // 单元素数据域
        GeneralizedList<T> subList; // 指向子表的引用

        public GNode(int tag, T data) {
            this.tag = tag;
            // 如果 tag = 0 说明数据区域为 具体数据，直接赋值，否则为另一个广义表
            if (tag == 0) {
                this.data = data;
            } else {
                this.subList = new GeneralizedList<>();
            }
            this.next = null;
        }
    }

    public GeneralizedList(){
        this.head = null;
    }

}
