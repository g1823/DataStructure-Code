package chapter02;

/**
 * @Package chapter02
 * @Date 2024/1/14 17:40
 * @Author gaojie
 * @description: 线性表的接口，规定线性表应该实现的方法以及模板
 */
public interface MyList<T> {
    /**
     * 获取一个元素在线性表中第一次出现的位置
     * @param o 待比较元素
     * @return 返回该元素在线性表中第一次出现的位置，无则返回-1
     */
    int indexOf(Object o);

    /**
     * 获取线性表第index位置的元素
     * @param index 线性表第几号元素
     * @return 线性表第index号元素的值
     */
    T get(int index);

    /**
     * 在第index元素位置插入一个新的元素value，剩余元素后移
     * @param index 待插入位置
     * @param value 插入元素的值
     */
    void add(int index,T value);

    /**
     * 插入一个元素，默认放在顺序表最后的位置
     * @param value 待插入的值
     */
    void add(T value);

    /**
     * 删除index号元素
     * @param index 待删除元素的位置
     */
    void delete(int index);

    /**
     * 获取当前线性表的元素个数
     * @return 线性表内元素个数
     */
    int size();
}
