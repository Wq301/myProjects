package com.wq.niukeweb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * @author Wangqian
 * @create 2022-05-13 21:20
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//   t.test1();
//   t.test2();
        t.test3();//无去重功能
//        t.test4();
    }


    //1、计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
    public void test1() {
        //方法一：
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" "); //正则表达式实用性更强( str.split("\\s+"))
        int length = s[s.length - 1].length();
        System.out.println(length);
        //方法二：
//    Scanner sc = new Scanner(System.in);
//    String str = sc.nextLine();
//    int index = str.lastIndexOf(" ");
//    String ss = str.substring(index + 1);
//    System.out.println(ss.length());
    }

    //2、写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，
    // 然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
    public void test2() {
        Scanner s = new Scanner(System.in);
        String input1 = s.nextLine().toUpperCase();
        String input2 = s.nextLine().toUpperCase();
        String split3 = input1.replaceAll(input2, "");
        System.out.println(input1.length() - split3.length());
    }

    /*
    3、生成N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，
    把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
    数据范围： 1≤n≤1000 , 输入的数字大小满足: 1≤val≤500
     */
    public void test3() {
        System.out.print("请输入要自动生成的随机数的个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = (int) ((Math.random() * 10) + 1);
        }
        System.out.println("初始得到的随机数组为：" + Arrays.toString(num));
        //随机数排序，从小到大("冒泡排序法")
        for (int m = 0; m < num.length - 1; m++) {
            for (int k = 0; k < num.length - 1 - m; k++) {
                if (num[k] > num[k + 1]) {
                    int temp = num[k];
                    num[k] = num[k + 1];
                    num[k + 1] = temp;
                } else if (num[k] == num[k + 1]) {
                    num[k+1]=(int) ((Math.random() * 10) + 1);
                    m=0;
                    k=0;
                }
            }
        }
        //遍历数组元素
        for (int j = 0; j < num.length; j++) {
            System.out.println(num[j]);
        }
        System.out.println("最终得到的随机数组为：" + Arrays.toString(num));
    }

    public void test4() {
        System.out.print("请输入要自动生成的随机数的个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //创建TreeSet进行去重排序
        TreeSet set = new TreeSet();
        //输入
        for (int i = 0; i < n; i++) {
            set.add((int) ((Math.random() * 10) + 1));
        }
//        System.out.println("集合中的元素为："+set);
        //输出
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
