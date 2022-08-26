package com.wq.niukeweb;

import java.util.Scanner;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-08-21 22:51
 */
public class TestHJ43 {
    public static void main(String[] args) {
        TestHJ43 t=new TestHJ43();
        t.HJ43();
    }
    //43、描述
    //定义一个二维数组 N*M ，如 5 × 5 数组下所示：
    //int maze[5][5] = {
    //0, 1, 0, 0, 0,
    //0, 1, 1, 1, 0,
    //0, 0, 0, 0, 0,
    //0, 1, 1, 1, 0,
    //0, 0, 0, 1, 0,
    //};
    //它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
    // 要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
    //输出：
    //(0,0)、(1,0)、(2,0)、(2,1)、(2,2)、(2,3)、(2,4)、(3,4)、(4,4)
    public void HJ43() {
        System.out.println("请依次输入迷宫的行和列：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int row = sc.nextInt();   //行
            int clu = sc.nextInt();   //列
            int[][] str=new int[row][clu];
            //给二维数组赋值
            for (int i=0;i<row;i++){
                for (int j=0;j<clu;j++){
                    str[i][j] = sc.nextInt();
                }
            }
            //输出二位数组
            /**  这样是以一维数组形式输出                                 [0,1,0]
             *  for(int[] s:str){                                        [0,0,0]
             *        System.out.println(Arrays.toString(s));            [0,1,0]
             *  }
             */
            System.out.println("迷宫地图如下：");
            for(int[] s:str){
                for (int result:s){
                    System.out.print(result+" ");
                }
                System.out.println();
            }
            //迷宫出路
            System.out.println("正确的迷宫出路为：");
            int n;
            for (int m=0;m<row;m++){
                for (n=0;n<clu;n++){
                    if(str[m][n]==0){

                        if(n==clu-1){
                            System.out.print("["+m+","+n+"],");
                            n=clu-1;
                            break;
                        }else {
                            System.out.print("["+m+","+n+"],");
                        }
                    }else {
                            n-=1;
                            break;
                    }
                }
            }
        }
    }
}