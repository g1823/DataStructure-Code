package chapter02_linearList.BasicImplementation;

/**
 * @Package chapter02
 * @Date 2024/1/16 22:10
 * @Author gaojie
 * @description: 多重链表：十字链表的数据结构，对链表的操作不做实现
 */
public class CrossLinkedList {
    Node[] rowHeads; // 每一行的头节点
    Node[] colHeads; // 每一列的头节点
    int rows;
    int cols;
    static class Node {
        int row;
        int col;
        int value;
        Node right; // 指向同一行的下一个非零元素
        Node down;  // 指向同一列的下一个非零元素

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.right = null;
            this.down = null;
        }
    }

}
