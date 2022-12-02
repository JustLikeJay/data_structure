package com.cmz;

/**
 * @author cmz
 * @date 2022/12/1
 * @Description
 */
public class Operation {
    public static int ADD = 1;
    public static int SUB = 1;
    public static int MUL = 2;
    public static int DIV = 2;

    public static int getVal(String op){
        int res = 0;
        switch (op){
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
