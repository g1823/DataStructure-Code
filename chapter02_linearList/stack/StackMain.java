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
    }
}
