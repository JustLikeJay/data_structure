package com.cmz.sparsearray;

import java.io.IOException;

/**
 * @author cmz
 * @date 2022/11/11
 * @Description
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组
        //0代表没有棋子,1代表黑子 2代表白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始二维数组:");
        for (int [] row : chessArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //原始二维数组转化为稀疏数组
        int sum = 0;
        for (int [] row : chessArr){
            for (int data : row){
                if (data != 0){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        //稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 1;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }

        System.out.println("转化后的稀疏数组:");

        for (int []row : sparseArray){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //稀疏数组的硬盘存取
        IOStream.saveToFile(sparseArray);
        int[][] file = IOStream.readFile();
        System.out.println("硬盘还原稀疏数组为:");
        for(int []row : file){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //将稀疏数组 -> 恢复成原始的二维数组
        /**
         * 1.先读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
         * 2.在读取稀疏数组后几行的数据,并赋值给原始的二维数组
         */

        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sparseArray[0][2] ; i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }


        System.out.println("还原后的稀疏数组:");
        for (int [] row : chessArray2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
