package com.cmz;

/**
 * @author cmz
 * @date 2022/11/30
 * @Description
 */
public class Calculator {

    public static void main(String[] args) {

        String expression = "30*(6+2*6)";
        //创建两个栈,数栈,符号栈
        ArrayStack opStack = new ArrayStack(5);
        ArrayStack numStack = new ArrayStack(5);
        //定义相关变量
        int index = 0;
        char ch;  //遍历表达式,每个字符的暂存
        int num1; //参与计算的值1
        int num2; //参与计算的值2
        int res;  //计算结果
        int op;   //参与计算的符号
        String keepNum = "";

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch的类型,做相应处理
            if (opStack.isOp(ch)) { //如果是运算符
                //判断当前的符号栈是否为空
                if (!opStack.isEmpty()) {
                    //不带括号版本
                    //如果符号栈中有操作符,就进行比较,如果当前的操作符的优先级小于或等于栈中的操作符,就需要从栈中pop出两个数,
                    //再从符号栈中pop出一个符号,进行运算,将得到结果,入数栈,然后将当前的操作符入数栈

                    //带括号版本
                    //这里需要判断是否此时的栈顶是否为左括号，如果是左括号不进入此循环
                    //我们设定的左括号是优先级大于加减乘除，所以当发现下一个进栈的符号的优先级比此时的栈顶的左括号优先级小的时候，
                    //应该让符号直接进栈，不进行弹出左符号的运算（左括号弹出来运算是不行的）
                    if (opStack.priority(ch) <= opStack.priority(opStack.peek()) && opStack.peek() != '(') {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        op = opStack.pop();
                        res = numStack.cal(num1, num2, op);
                        //把运算结果入数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        opStack.push(ch);
                    }
                    /**
                     * 进行右括号的判断。匹配左括号
                     * 当发现进入的是右括号时就优先进行括号内的计算
                     */
                    else if (ch == ')') {
                        opStack.push(ch);
                        //再把右括号弹出
                        opStack.pop();
                        //弹出右括号后开始进行括号内运算
                        while (true) {
                            //右括号
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            op = opStack.pop();
                            res = numStack.cal(num1, num2, op);
                            //把运算的结果如数栈
                            numStack.push(res);
                            //当运算到栈顶符号为左括号时候，就弹出栈顶元素左括号，结束循环
                            if (opStack.peek() == '(') {
                                opStack.pop();
                                break;
                            }
                        }
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符或者栈中操作符为(,就直接入符号栈
                        opStack.push(ch);
                    }
                }

                else {
                    //如果为空直接入栈
                    opStack.push(ch);
                }
            } else { //如果是数,直接入数栈
                //numStack.push(ch - 48);
                //分析思路
                //1.当处理多位数时,不能发现是一个数就即刻入栈,因为可能是多位数
                //2.在处理数时,需要向expression的表达式的index后再看一位,如果是数就进行扫描,如果是符号就入栈
                //3.因此定义一个字符串进行拼接
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断像一个字符是不是数字,如果是数字,就继续扫描,是运算符,则入栈
                    if (opStack.isOp(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

            //当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号,并运行
        while (!opStack.isEmpty()) {
            //如果符号栈为空,则计算到最后的结果,数栈中只有一个数字[结果]
            num1 = numStack.pop();
            num2 = numStack.pop();
            op = opStack.pop();
            res = numStack.cal(num1, num2, op);
            //把运算结果入数栈
            numStack.push(res);
        }
        System.out.printf("该表达式%s的运算结果为%d", expression, numStack.pop());


        }


    }

