package chapter02_linearList.stack;

import java.util.Arrays;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/2/26 22:28
 * @Author gaojie
 * @description: TODO
 */
public class StackMain {
    public static void main(String[] args) {
        String[] data = new String[]{"9", "+", "(", "3", "-", "1", ")", "*", "3", "+", "10", "/", "2"};
        String[] result = PostfixExpression.getPostfixExp(data);
        System.out.println("后缀表达式为：");
        Arrays.stream(result).forEach(s -> System.out.print(s + " "));
        System.out.println("\n执行结果为：");
        System.out.println(PostfixExpression.execute(data));

        System.out.println("--------------堆栈线性实现测试--------------");
        // 堆栈线性实现测试
        SequentialStack<Integer> sequentialStack = new SequentialStack<>(3);
        if (sequentialStack.isEmpty()) {
            System.out.println("栈为空");
        }
        sequentialStack.push(1);
        if (sequentialStack.isFull()) {
            System.out.println("栈已满");
        } else {
            System.out.println("栈还未满");
        }
        sequentialStack.push(2);
        sequentialStack.push(3);
        sequentialStack.push(4);
        System.out.println(sequentialStack.peek());
        System.out.println(sequentialStack.pop());
        System.out.println(sequentialStack.pop());
        System.out.println(sequentialStack.pop());
        System.out.println(sequentialStack.pop());
    }
}
