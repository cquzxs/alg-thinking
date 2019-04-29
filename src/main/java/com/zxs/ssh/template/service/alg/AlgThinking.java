package com.zxs.ssh.template.service.alg;

/**
 * Project Name:alg-thinking
 * File Name:AlgThinking
 * Package Name:com.zxs.ssh.template.service.alg
 * Date:2019/4/29
 * Author:zengxueshan
 * Description:5大算法思想
 * Copyright (c) 2019, 重庆云凯科技有限公司 All Rights Reserved.
 */


public class AlgThinking {
    public static void main(String[] args) {
        divideAndConquer();
    }
    /**
     * #1 分治法
     * 实例：#1 二分查找；#2 归并排序；#3 快速排序；#4 循环赛；#5 汉诺塔
     */
    private static void divideAndConquer() {
        System.out.println( arrayToString(roundRobin(8)) );
    }

    /**
     * 循环赛日程
     * 若有8个选手进行循环赛，选手编号1-8，共需比赛7天，int[][]->int[8][8]
     *
     * @param n 共有n个选手进行循环赛
     * @return 循环赛日程
     */
    private static int[][] roundRobin(int n) {
        if( n<=2 ){
            return new int[][]{{1,2},{2,1}};
        }
        //n一定要是2的k次方，如果不是，将它补齐
        int k = 1;
        while( Math.pow(2,k)<n ){
            k++;
        }
        n = (int)Math.pow(2,k);
        int[][] result = new int[n][n];
        roundRobinHelp(result,0,n-1,0,n-1,1);
        return result;
    }
    private static void roundRobinHelp(int[][] a, int xStartIndex, int xEndIndex, int yStartIndex, int yEndIndex, int baseValue){
        //切成4分 并赋值 中间索引 = (xStartIndex+xEndIndex)/2
        //左上 1
        for (int i = yStartIndex; i <= (yStartIndex+yEndIndex)/2; i++) {
            for (int j = xStartIndex; j <= (xStartIndex+xEndIndex)/2; j++) {
                a[i][j] = i+1;
            }
        }
        //左下 2
        for (int i = (yStartIndex+yEndIndex)/2+1; i <= yEndIndex; i++) {
            for (int j = xStartIndex; j <= (xStartIndex+xEndIndex)/2; j++) {
                a[i][j] = i+1;
            }
        }
        //右上 2
        for (int i = yStartIndex; i <= (yStartIndex+yEndIndex)/2; i++) {
            for (int j = (xStartIndex+xEndIndex)/2+1; j <= xEndIndex; j++) {
                a[i][j] = i+(xEndIndex-xStartIndex+1)/2+1;
            }
        }
        //右下 1
        for (int i = (yStartIndex+yEndIndex)/2+1; i <= yEndIndex; i++) {
            for (int j = (xStartIndex+xEndIndex)/2+1; j <= xEndIndex; j++) {
                a[i][j] = i-(xEndIndex-xStartIndex+1)/2+1;
            }
        }
        if((xStartIndex+xEndIndex)/2 - xStartIndex+1 >= 2){
            roundRobinHelp(a,xStartIndex,(xStartIndex+xEndIndex)/2,yStartIndex,(yStartIndex+yEndIndex)/2,baseValue);
            roundRobinHelp(a,xStartIndex,(xStartIndex+xEndIndex)/2,(yStartIndex+yEndIndex)/2+1,yEndIndex,baseValue);
            roundRobinHelp(a,(xStartIndex+xEndIndex)/2+1,xEndIndex,yStartIndex,(yStartIndex+yEndIndex)/2,baseValue);
            roundRobinHelp(a,(xStartIndex+xEndIndex)/2+1,xEndIndex,(yStartIndex+yEndIndex)/2+1,yEndIndex,baseValue);
        }
    }
    private static String arrayToString(int[][] a){
        String res = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(j == a[0].length-1){
                    res += a[i][j];
                }else{
                    res += a[i][j]+",";
                }
            }
            res += "\n";
        }
        return res;
    }

}
