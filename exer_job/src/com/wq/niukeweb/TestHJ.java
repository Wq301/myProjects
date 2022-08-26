package com.wq.niukeweb;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-08-14 17:13
 */
public class TestHJ {
    public static void main(String[] args) {
        TestHJ t = new TestHJ();

//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入正整数：");
//        int num = scan.nextInt();
//        t.testHJ6(num);

//        t.testHJ91();
//        t.testHJ10();
        t.testHJ20();
    }

    //6、功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
    //输出描述：
    //按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
    public void testHJ6(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
                testHJ6(num / i);
                break;
            }
            if (i == num) {
                System.out.print(i + " ");
            }
        }
    }

    //9、输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
    //保证输入的整数最后一位不是 0 。
    public void testHJ9() {
        System.out.println("请输入一个末位不为0的正整数：");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            char[] chars = s.toCharArray();      //输入的字符数组
            if (chars[chars.length - 1] == '0') {
                System.out.println("输入的数字末位不可以为0！");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = chars.length - 1; i >= 0; i--) {
                    char[] chars2 = sb.toString().toCharArray();  //新的字符数组
                    if (i == chars.length - 1) {
                        sb.append(chars[i]);
                    } else {
                        int count = 0;
                        for (int k = 0; k < chars2.length; k++) {
                            if (chars2[k] == chars[i]) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            sb.append(chars[i]);
                        }
                    }

                }
                System.out.println(sb);
            }
        }

    }

    //方法二：
    public void testHJ91() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] chars = s.toCharArray();
        //Set中的LinkedHashSet就是有序的
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            set.add(chars[i]);
        }

        s = "";
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            s += it.next();
        }
        System.out.println(s);
    }

    //10、描述
    //编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
    //例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
    public void testHJ10() {
        System.out.println("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        System.out.println(set.size());
    }
    //20、描述
    //密码要求:
    //1.长度超过8位
    //2.包括大小写字母、数字、其它符号,以上四种至少三种
    //3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
    //输出描述：如果符合要求输出：OK，否则输出NG
    //输入：          输出：
    //021Abc9000         //OK
    //021Abc9Abc1        //NG
    //021ABC9000         //NG
    //021$bc9000         //OK

    public void testHJ20() {
        System.out.println("请输入您的密码：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String password = sc.nextLine();
            if (password.length() <= 8) {        //密码长度超过8位
                System.out.println("密码需要超过8位--->NG");
            } else {
                char[] chars = password.toCharArray();
                int a = 0, b = 0, c = 0, d = 0;
                boolean flag = true;
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        a = 1;   //密码中包含数字
                    } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                        b = 1;   //密码中包含小写字母
                    } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                        c = 1;   //密码中包含大写字母
                    } else if (chars[i] == ' ' || chars[i] == '\n') {
                        flag = false;      //存在空格或换行
                        break;
                    } else {
                        d = 1;   //密码中包含其他字符
                    }
                }
                if((a+b+c+d)<3){
                    System.out.println("密码中包含的类型少于三种--->NG");
                    flag=false;
                }else {      //包含四种类型中的至少三种
                    for (int m=3;m<password.length()/2+1;m++){
                        for(int k=0;k<password.length()/2+1;k++){
                            String str=password.substring(k,k+m);
                            String str2=password.substring(k+m);
                            if(str2.contains(str)){
                                System.out.println("密码中有长度大于2的包含公共元素的子串重复--->NG");
                                flag=false;
                                break;
                            }
                        }
                    }
                }
                if(flag){
                    System.out.println("密码设置合理--->OK");
                }
            }

        }
    }
}

