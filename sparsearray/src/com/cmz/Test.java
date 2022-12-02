package com.cmz;

import java.util.Arrays;

/**
 * @author cmz
 * @date 2022/11/13
 * @Description
 */
public class Test {



    int gsd(int x,int y)
    {
        int[] count = new int[6];
        count[0]++;
        int q=x;
        int r=y;
        count[1]++;
        while(q!=r)
        {
            count[2]++;
            if (q>r) {
                count[4]++;
                q = q - r;
            }
            else {
                count[5]++;
                r = r + q;
            }
        }
        count[3]++;
        for (int i = 0; i < count.length; i++) {
            System.out.println("count[" + i + "] is" + count[i]);
        }
        return q;
    }


}
