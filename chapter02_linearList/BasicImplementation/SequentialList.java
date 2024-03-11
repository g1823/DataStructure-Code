package chapter02_linearList.BasicImplementation;


/**
 * @Package chapter02
 * @Date 2024/1/10 20:53
 * @Author gaojie
 * @description: 线性表的实现：顺序表
 */
public class SequentialList<T> implements MyList<T> {
    // 顺序表的最大存储数量
    private static final int MAXSIZE = 100;
    // 数据存储数组
    private final Object[] data = new Object[MAXSIZE];
    // 当前最后一个元素的坐标
    private int last;

    public SequentialList() {
        this.last = -1;
    }


    @Override
    public int indexOf(Object o) {
        if (last == -1) {
            System.out.println("顺序表为空");
            return -1;
        }
        if (o == null) { // 元素为空则寻找顺序表中是否有空元素
            for (int i = 0; i < last; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else { // 元素不为空则通过equals()方法判断两个元素是否相同。
            for (int i = 0; i < last; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        // 找不到返回-1
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index > last || index < 0) {
            System.out.println("index参数不合法");
            return null;
        }
        return (T) data[index];
    }

    @Override
    public void add(int index, T value) {
        // 待插入位置index小于0、大于last时说明参数不合法，last+1 等于MAXSIZE时说明顺序表已满
        if (index < 0 || (index > last && last >= 0) || ++this.last == MAXSIZE) {
            System.out.println("index不合法或顺序表已满");
            return;
        }
        // 从后往前依次赋值
        for (int i = last; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
    }

    @Override
    public void add(T value) {
        // last+1等于MAXSIZE说明顺序表已经满了
        if (++this.last == MAXSIZE) {
            System.out.println("顺序表已满");
            return;
        }
        data[last] = value;
    }

    @Override
    public void delete(int index) {
        // index小于0、index大于last说明参数不合法，last减一后小于0说明顺序表为空，不能删除
        if (index < 0 || index > this.last || --last < 0) {
            System.out.println("index参数错误或顺序表为空");
            return;
        }
        for (int i = index; i <= last; i++) {
            data[i] = data[i + 1];
        }
    }

    @Override
    public int size() {
        return last + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.last; i++) {
            sb.append(data[i]).append(",");
        }
        sb.append(data[last]).append("]");
        return sb.toString();
    }
}
