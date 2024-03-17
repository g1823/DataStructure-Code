package chapter02_linearList.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Package chapter02_linearList.stack
 * @Date 2024/2/26 21:46
 * @Author gaojie
 * @description: 由中缀表达式转化为后缀表达式
 */
public class PostfixExpression {

    // 存储运算符优先级
    public static final Map<String, Integer> operatorPriority = new HashMap<String, Integer>() {
        {
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
        }
    };

    /**
     * 计算中缀表达式的值
     *
     * @param infixExpArray 中缀表达式
     * @return 计算结果
     */
    public static double execute(String[] infixExpArray) {
        String[] postfixExp = getPostfixExp(infixExpArray);
        Stack<Double> stack = new Stack<>();
        for (String exp : postfixExp) {
            if (isNumber(exp)) {
                stack.push(Double.parseDouble(exp));
            } else {
                Double rightNum = stack.pop();
                Double leftNum = stack.pop();
                switch (exp) {
                    case "+":
                        stack.push(leftNum + rightNum);
                        break;
                    case "-":
                        stack.push(leftNum - rightNum);
                        break;
                    case "*":
                        stack.push(leftNum * rightNum);
                        break;
                    case "/":
                        stack.push(leftNum / rightNum);
                        break;
                }
            }
        }
        return stack.pop();
    }


    /**
     * 将传入的中缀表达式转化为后缀表达式
     * <p>
     * 整体流程：
     * *  1.从左到右进行遍历。
     * *  2.遇到操作数，直接加入到后缀表达式当中。
     * *  3.遇到界限符。遇到“(”直接入栈，遇到“)”则依次弹出栈内运算符并加入后缀表达式，直到弹出“(” 为止，注意:“(” 不加入后缀表达式。
     * *  4.遇到运算符。依次弹出栈中优先级高于或等于当前运算符的所有运算符，并加入后缀表达式，若碰到“(”或栈空则停止。之后再把当前运算符入栈。
     * * 主要思路：
     * *  遇到一个运算符号，因为有优先级的存在，需要知道下一个运算符号才能知道当前运算符能否直接运算，或着说遇到一个运算符就可以知道上一个运算符是否可以执行
     * 即：遇到一个运算符时，将栈中优先级大于等于该运算符的运算符全部出栈，加入后缀表达式（这样就保证了运算符的优先级）
     *
     * @param infixExpArray 中缀表达式
     * @return 转化成的后缀表达式
     */
    public static String[] getPostfixExp(String[] infixExpArray) {

        String[] result = new String[(int) Arrays.stream(infixExpArray).filter(s -> !("(".equals(s) || ")".equals(s))).count()];
        Stack<String> stack = new Stack<>();
        int index = 0;
        // 从左到右遍历中缀表达式
        for (String s : infixExpArray) {
            if (isNumber(s)) {
                // 如果是数字，直接加到后缀表达式中
                result[index++] = s;
            } else if ("(".equals(s)) {
                // 如果是“(”，则直接入栈
                stack.push(s);
            } else if (")".equals(s)) {
                // 如果是“)”，则依次弹出栈内的所有运算符，直到遇到"("
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    result[index++] = stack.pop();
                }
                stack.pop();
            } else {
                // 如果是运算符,依次弹出栈中优先级高于或等于当前运算符的所有运算符，并加入后缀表达式
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    String peek = stack.peek();
                    if (operatorPriority.get(peek) >= operatorPriority.get(s)) {
                        result[index++] = stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(s);
            }
        }
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }

    /**
     * 判断一个字符串是不是数字
     *
     * @param s 待判断字符串
     * @return 是否为数字
     */
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
