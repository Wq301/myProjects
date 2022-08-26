package com.wq.niukeweb;

import java.util.Scanner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-08-21 17:03
 */
public class TestHJ30 {
    public static void main(String[] args) {
        TestHJ30 t = new TestHJ30();

        t.HJ30();
    }

    //30、描述
    //第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ，
    // 合并后生成的字符串为 "decfab"
    //第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
    // 这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。
    // 例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和
    // 下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），
    // 再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
    //第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
    //转换规则如下：
    //对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，
    // 然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
    //如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
    //如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
    //如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
    //根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
    public void HJ30() {
        System.out.println("请依次输入两个字符串：");
        Scanner sc = new Scanner(System.in);
        String newStr = new String();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            newStr = str1 + str2;
            System.out.println("合并后生成的字符串为：" + newStr);

            char[] chars = newStr.toCharArray();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    sb1.append(chars[i]);
                } else {
                    sb2.append(chars[i]);
                }
            }
            System.out.println("偶数字符数组：" + sb1);
            System.out.println("奇数字符数组：" + sb2);
            char[] newOu=maoPao(sb1.toString().toCharArray());
            char[] newJi=maoPao(sb2.toString().toCharArray());
            System.out.println("排序后的偶下表字符数组："+String.valueOf(newOu));
            System.out.println("排序后的奇下表字符数组："+String.valueOf(newJi));

            //第二步：把排序后的数组按要求组合
            StringBuilder newSb = new StringBuilder();
            for (int k=1;k<=newStr.length();k++){
                if (k % 2 != 0) {
                    newSb.append(String.valueOf(newOu).substring(0,1));
                    newOu=String.valueOf(newOu).substring(1).toCharArray();
                } else {
                    newSb.append(String.valueOf(newJi).substring(0,1));
                    newJi=String.valueOf(newJi).substring(1).toCharArray();
                }
            }
            System.out.println("排序后的新字符串为："+newSb);
            //第三步：转换操作
            char[] lastChar=newSb.toString().toCharArray();
            StringBuilder lastSb = new StringBuilder();
            for (int l=0;l<lastChar.length;l++){
                lastSb.append(change(lastChar[l]));
            }
            System.out.println("最终的字符串为："+lastSb);
        }
    }

    //冒泡法排序
    public char[] maoPao(char[] chars) {
        for (int m = 0; m < chars.length-1; m++) {
            for (int n = 0; n < chars.length - 1 - m; n++) {
                if (chars[n] > chars[n + 1]) {
                    char temp = chars[n];
                    chars[n] = chars[n + 1];
                    chars[n + 1] = temp;
                }
            }
        }
        return chars;
    }
    //十六进制转十进制再翻转
    public char change(char c){
        switch (c){
            case '0': return '0';
            case '1': return '8';
            case '2': return '4';
            case '3': return 'C';
            case '4': return '2';
            case '5': return 'A';
            case '6': return '6';
            case '7': return 'E';
            case '8': return '1';
            case '9': return '9';
            case 'A': return '5';
            case 'B': return 'D';
            case 'C': return '3';
            case 'D': return 'B';
            case 'E': return '7';
            case 'F': return 'F';
            case 'a': return '5';
            case 'b': return 'D';
            case 'c': return '3';
            case 'd': return 'B';
            case 'e': return '7';
            case 'f': return 'F';
            default: return 'M';
        }
    }

}