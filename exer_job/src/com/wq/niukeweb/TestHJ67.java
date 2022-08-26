package com.wq.niukeweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-08-22 21:04
 */
public class TestHJ67 {
    //正确的
    private static int[] arr;//用于接收传入的4个整数
    private static int[] visited;//用于判断对应序号的整数有没有被使用。

    public static void main(String[] args) {
        TestHJ67 t=new TestHJ67();
//        t.HJ67();

        //正确的
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            arr=new int[4];
            visited=new int[4];
            for(int i=0;i<4;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(canGet24(0,0));
        }

    }

    //67、给出4个1-10的数字，通过加减乘除运算，得到数字为24就算胜利,除法指实数除法运算,
    // 运算符仅允许出现在两个数字之间,本题对数字选取顺序无要求，但每个数字仅允许使用一次，
    // 且需考虑括号运算此题允许数字重复，如3 3 4 4为合法输入，此输入一共有两个3，
    // 但是每个数字只允许使用一次，则运算过程中两个3都被选取并进行对应的计算操作。
    private void HJ67() {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<4;i++){              //获取4个1~10的随机数
            list.add((int) (Math.random()*10)+1);
        }
        System.out.println(list);
        char[] chars=list.toString().toCharArray();
        for (int m=0;m<chars.length;m++){

        }
    }

    //正确的
    //使用递归，第一个参数表示已使用的数字数，第二个参数表示对已使用的数字进行运算后得到的临时结果
    private static boolean canGet24(int cnt,double tmpres){
        if(cnt==4 && tmpres==24){//如果用了4个了，且结果已经是24了，那就说明24运算成功。
            return true;
        }
        if(cnt==0){//对于还没开始运算的情况，接收的第一个数值直接作为tmpres
            for(int i=0;i<4;i++){
                visited[i]=1;
                if(canGet24(1,arr[i])){
                    return true;
                }
                visited[i]=0;//每一轮循环都要把访问记录恢复
            }
            return false;//所有数字都试过了还没有得到24，说明不可能再得到。
        }
        if(cnt==2){
            //对于已经在两个数值参加运算的情况，要考虑两种可能
            //1.另两个数字参加运算后再和当前结果运算。
            int a=0,b=0;//剩下两个数值取到a,b中
            for(int i=0;i<4;i++){
                if(visited[i]==0){
                    if(a==0){
                        a=arr[i];
                    }else{
                        b=arr[i];
                    }
                }
            }
            for(double n:getAnyRes(a,b)){//对所有可能的ab运算结果进行判断
                for(double m:getAnyRes(tmpres,n)){//对所有可能的tmpres和n的运算结果进行判断
                    if(m==24){
                        return true;
                    }
                }
            }
            //2.当前结果与第三个数值参加运算。
            for(int i=0;i<4;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    if(canGet24(3,tmpres+arr[i])||canGet24(3,tmpres*arr[i])||//加和乘计算
                            canGet24(3,tmpres-arr[i])||canGet24(3,arr[i]-tmpres)){//减法计算
                        return true;
                    }
                    if(tmpres!=0 && canGet24(3,arr[i]/tmpres)
                            ||arr[i]!=0 && canGet24(3,tmpres/arr[i])){//除法计算
                        return true;
                    }
                    visited[i]=0;
                }
            }
            return false;//所有情况都试过了，还是没有24出现，返回false
        }
        if(cnt==1||cnt==3){
            for(int i=0;i<4;i++){
                if(visited[i]==0){
                    visited[i]=1;
                    if(canGet24(cnt+1,tmpres+arr[i])||canGet24(cnt+1,tmpres*arr[i])||//加和乘计算
                            canGet24(cnt+1,tmpres-arr[i])||canGet24(cnt+1,arr[i]-tmpres)){//减法计算
                        return true;
                    }
                    if(tmpres!=0 && canGet24(cnt+1,arr[i]/tmpres)||
                            arr[i]!=0 && canGet24(cnt+1,tmpres/arr[i])){//除法计算
                        return true;
                    }
                    visited[i]=0;
                }
            }
        }//不是1~4的返回false
        return false;
    }
    //以下函数用于返回两个数进行任何运算后可能的值，以列表形式返回。
    private static List<Double> getAnyRes(double a,double b){
        List<Double> res = new ArrayList<Double>();
        res.add(a+b);
        res.add(a*b);
        res.add(a-b);
        res.add(b-a);
        if(a!=0){
            res.add(b/a);
        }
        if(b!=0){
            res.add(a/b);
        }
        return res;
    }
}