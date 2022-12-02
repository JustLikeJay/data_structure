package com.cmz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author cmz
 * @date 2022/11/30
 * @Description
 */
public class PolandNotation {

    public static void main(String[] args) {

        //先定义一个逆波兰表达式
        //为了方便,逆波兰表达式的数字和符号用空格分割
        //String suffixExpression = "3 4 + 5 * 6 -";
        //List<String> list = getListString(suffixExpression);
        //System.out.println(list);
        //int res = calculate(list);
        //System.out.println(res);

        //中缀表达式转后缀表达式并完成计算
        String expression = "(3+5)*6+4";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> suffixExpressionList = toSuffixExpressionList(infixExpressionList);
        int res = calculate(suffixExpressionList);
        System.out.printf("%s的运算结果为%d",expression,res);

    }

    //将一个逆波兰表达式,依次将数据和运算符,放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }

    //将一个中缀表达式,依序存储在一个List中
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int index = 0; //遍历整个ls
        String str; //多位数拼接
        char c; //每遍历到一个字符,就放入c
        while (true){
            if (index > s.length() - 1){
                break;
            }
            else {
                c = s.charAt(index);
                if (c < 48 || c > 57){
                    ls.add(c + "");
                    index++;
                }
                else {
                    str = ""; //置空
                    while(index < s.length() && s.charAt(index) >= 48 && s.charAt(index) <= 57){
                        str+=s.charAt(index);
                        index++;
                    }
                    ls.add(str);
                }
            }
        }
        return ls;
    }

    //中缀表达式转换成后缀表达式
    public static List<String> toSuffixExpressionList(List<String> list){
        Stack<String> opStack = new Stack<>();
        List<String> resList = new ArrayList<>();

        for (String ele : list) {
            if (ele.matches("\\d+")){
                resList.add(ele);
            }
            else if (ele.equals("(")){
                opStack.push(ele);
            }
            else if (ele.equals(")")){
                String temp = opStack.pop();
                while (true){
                    if (temp.equals("(")){
                        break;
                    }
                    else {
                        resList.add(temp);
                        temp = opStack.pop();
                    }
                }
            }
            //当ele的优先级小于等于opStack的栈顶运算符,将opStack的运算符弹出并加入resList中
            //其中 +- 为1, */为2 , ( ) 为 0
            else {
                while (opStack.size() != 0 && Operation.getVal(opStack.peek()) > Operation.getVal(ele)){
                    resList.add(opStack.pop());
                }
                //还需要将ele压入栈
                opStack.push(ele);
            }
        }
        //将opStack的剩余运算符依次弹出加入resList
        while (opStack.size() != 0){
            resList.add(opStack.pop());
        }

        return resList;
    }



    //逆波兰表达式的计算
    /**
     * 1.从左至右扫描,将3和4压入堆栈
     * 2.遇到+运算符,因此弹出4和3,计算出4+3的值,得到7,在将7入栈
     * 3.将5入栈
     * 4.接下来是*运算符,弹出5和7,计算出 7*5 = 35,将35入栈
     * 5.将6入栈
     * 6.最后是-运算符,计算出35-6的值 即29
     */
    public static int calculate(List<String> ls){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String ele : ls) {
            //这里使用正则表达式来取出数
            if (ele.matches("\\d+")){ //匹配的是多位数
                //入栈
                stack.push(ele);
            }else {
                //pop出两个数,并运算,再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                if (ele.equals("+")){
                    res = num1 + num2;
                }else if (ele.equals("-")){
                    res = num1 - num2;
                }else if (ele.equals("*")){
                    res = num1 * num2;
                }else if (ele.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //返回栈中的最后一个数字,即结果
        return Integer.parseInt(stack.pop());
    }
}
