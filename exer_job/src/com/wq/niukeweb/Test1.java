package com.wq.niukeweb;

import java.util.Scanner;

/*
 * @author Wangqian
 * @create 2022-05-17 20:37
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test = new Test1();
//        test.test1();
        test.test2();
//        test.test3();
    }

    //4、输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
    //长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
    //输入描述：
    //连续输入字符串(每个字符串长度小于等于100)
    //输出描述：
    //依次输出所有分割后的长度为8的新字符串
    public void test1() {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int l = str.length();
            if (l % 8 != 0) {
                int num = 8 - (l % 8);//需要添加'0'的个数
                for (int i = 0; i < num; i++) {
                    str = str + '0';
                }
            }
            System.out.println("得到新的字符串：" + str);
            System.out.println("分割后的字符串依次为：");
            //将字符串分割成每个元素长度为8的数组
            int newl = str.length();//新字符串的长度
            int count = newl / 8;  //数组的长度
            String[] newStr = new String[count];
            int j = 0;
            while (j < newl) {
                for (int k = 0; k < count; k++) {
                    newStr[k] = str.substring(j, j + 8);
                    j += 8;
                }
            }
            //输出裁剪后的字符串数组
            for (String s : newStr) {
                System.out.println(s);
            }
        }

    }


    public void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();//牢记字符串缓冲区的建立语法
            sb.append(str);//字符串缓冲区的加入
            int size = str.length();
            int addZero = 8 - size % 8;//addzero的可能值包括8
            while ((addZero > 0) && (addZero < 8)) {//注意边界调节，避免addzero=8
                sb.append("0");//使用‘’或“”都可
                addZero--;
            }
            String str1 = sb.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }

        }
    }

    //5、描述
    //写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
    //数据范围：保证结果在 1≤n≤2的31次方-1
    //输入描述：
    //输入一个十六进制的数值字符串。
    //输出描述：
    //输出该数值的十进制字符串。不同组的测试用例用\n隔开。
    public void test3() {
        System.out.println("请输入一个十六进制的数：(转换为十进制)");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
        }
    }
}
