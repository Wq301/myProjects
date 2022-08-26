package com.wq.niukeweb;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-08-22 15:43
 */
public class TestHJ61 {
    public static void main(String[] args) {
        TestHJ61 t=new TestHJ61();
//        t.HJ61();

        //正确的方法
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            System.out.println(count(sc.nextInt(),sc.nextInt()));
        }
        sc.close();
    }

    //61、把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
    //注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。

    private void HJ61() {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            System.out.println("请输入总苹果数：");
            int applesNum=sc.nextInt();
            System.out.println("请输入盘子的数量：");
            int panNum=sc.nextInt();

            LinkedHashSet set=new LinkedHashSet<>();
            for (int i=0;i<panNum;i++){
                for (int j=0;j<applesNum-i;j++){
//                    applesNum=applesNum-j;
                    set.add(paiXu(String.valueOf(i)+String.valueOf(j)+String.valueOf(applesNum-i-j)));
//                    System.out.println("("+i+","+j+","+(applesNum-i-j)+")");
                }
            }
            System.out.println(set);
            System.out.println("总共有"+set.size()+"种分法");
        }
    }
    public String paiXu(String str){
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length-1;i++){
            for (int j=0;j<chars.length-1-i;j++){
                if(chars[j]>chars[j+1]){
                    char temp=chars[j];
                    chars[j]=chars[j+1];
                    chars[j+1]=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int k=0;k<chars.length;k++){
            sb.append(chars[k]);
        }
        return sb.toString();
    }

    //正确的方法
    public static int count(int m,int n){     //m为苹果的数量，n为盘子的数量
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return count(m,n-1)+count(m-n,n);
    }
}