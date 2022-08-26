package com.wq.niukeweb;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Wangqian
 * @create 2022-05-17 22:06
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test = new Test2();
        test.test1();
    }

    public void test1() {
        System.out.println("请输入下列键值对的个数：");
        Scanner scanner = new Scanner(System.in);
        int tableSize = scanner.nextInt();
        Map<Integer, Integer> table = new HashMap<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (table.containsKey(key)) {
                table.put(key, table.get(key) + value);
            } else {
                table.put(key, value);
            }
        }
        for (Integer key : table.keySet()) {
            System.out.println(key + " " + table.get(key));
        }
    }
}
