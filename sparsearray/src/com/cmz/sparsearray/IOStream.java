package com.cmz.sparsearray;

import java.io.*;

/**
 * @author cmz
 * @date 2022/11/11
 * @Description
 *  稀疏数组的存取
 */
public class IOStream {

    public static void saveToFile(int [][] sparseArray) throws IOException {

        File file = new File("D:\\sparseArray.data");
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < sparseArray.length; i++) {
            fileWriter.write(sparseArray[i][0] + "\t" + sparseArray[i][1] + "\t" + sparseArray[i][2]);
            fileWriter.write(System.getProperty("line.separator")); //获取当前系统所需的换行符 \r,\n
        }
        fileWriter.close();
    }

    public static int[][] readFile() throws IOException {
        int[][] sparseArray = null;
        File file = new File("D:\\sparseArray.data");
        FileReader fileReader = new FileReader(file);
        //创建字符读取缓冲流
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String readLine = null;
        int count = 0;
        while ((readLine = bufferedReader.readLine()) != null){
            String[] tempStr = readLine.split("\t"); //根据给定的正则表达式的匹配拆分此字符串
            //判断数组是否创建,未创建的话就创建
            if (sparseArray == null){
                sparseArray = new int[Integer.parseInt(tempStr[2]) + 1][3];
            }
            sparseArray[count][0] = Integer.parseInt(tempStr[0]);
            sparseArray[count][1] = Integer.parseInt(tempStr[1]);
            sparseArray[count][2] = Integer.parseInt(tempStr[2]);
            count++;
        }
        fileReader.close();
        return sparseArray;
    }
}
