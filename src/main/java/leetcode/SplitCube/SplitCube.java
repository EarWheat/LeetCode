package leetcode.SplitCube;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-17 16:57
 * @desc:有一个x*y*z的立方体，要在这个立方体上砍k刀，每一刀可以看作是用一个平行于立方体某一面的平面切割立方体，且必须在坐标为整数的位置切割，如在x=0.5处用平面切割是非法的。
问在切割k刀之后，最多可以把立方体切割成多少块。
 * @input:输入仅包含一行，一行包含4个正整数x,y,z,k分别表示x*y*z的立方体和切割k刀。（1<=x,y,z<=10^6,0<=k<=10^9）
 * @output:输出仅包含一个正整数，即至多切割成多少块。
 * @ex:
 * 2 2 2 3
 * 8
 */
public class SplitCube {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(SplitCube(x,y,z,k));
    }

    private static int SplitCube(int x, int y, int z, int k){
        int maxD = x * y * z;
        int maxK = (x-1) + (y-1) + (z-1);
        int a = x - 1;
        int b = y - 1;
        int c = z - 1;
        if(k > maxK){
            return maxD;
        } else {
            while (maxK != k){
                int m = max(a,b,c);
                if(m == 1){
                    a = a - 1;
                } else if(b == 1){
                    b = b - 1;
                } else if(c == 1){
                    c = c - 1;
                }
                maxD = (a + 1) * (b + 1) + (c + 1);
            }
        }
        return maxD;
    }

    private static int max(int a, int b ,int c){
        // a最大
        if(a >= b && a >= c){
            return 1;
        }
        // b最大
        if(b >= a && b >= c){
            return 2;
        }
        // c最大
        if(c >= a && c >= b){
            return 3;
        }
        return 0;
    }
}
