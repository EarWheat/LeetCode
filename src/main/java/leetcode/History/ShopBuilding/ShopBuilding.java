package leetcode.History.ShopBuilding;

import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-02-04 19:16
 * @desc:小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
*  @input:输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
1<=n<=100000;
1<=wi<=100000;
*  @output:输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
*  @ex:
*  in:
*  6
*  5 3 8 3 2 5
*  out:3 3 5 4 4 4
*  desc: 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 */
public class ShopBuilding {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i = 0 ; i < n; i ++){
            input[i] = scanner.nextInt();
        }
        int[] output = viewBuilding(input);
        for(int i : output){
            System.out.print(i + " ");
        }
    }

    private static int[] viewBuilding(int[] builds){
        int[] result = new int[builds.length];
        for(int i = 0 ; i < builds.length; i++){
            int buildLeft = 0;
            int buildRight = 0;
            if(i == 0){
                int maxRight = builds[i + 1];
                // 右边第一个可见
                buildRight = 1;
                for(int m = i + 1; m < builds.length; m++){
                    if(builds[m] > maxRight){
                        maxRight = builds[m];
                        buildRight++;
                    }
                }
            } else if(i == builds.length - 1){
                int maxLeft = builds[i - 1];
                // 左边第一个可见
                buildLeft = 1;
                for(int m = i - 1; m >= 0; m--){
                    if(builds[m] > maxLeft){
                        maxLeft = builds[m];
                        buildLeft++;
                    }
                }
            } else {
                int maxLeft = builds[i - 1];
                // 左边第一个可见
                buildLeft = 1;
                for(int m = i - 1; m >= 0; m--){
                    if(builds[m] > maxLeft){
                        maxLeft = builds[m];
                        buildLeft++;
                    }
                }
                int maxRight = builds[i + 1];
                // 右边第一个可见
                buildRight = 1;
                for(int m = i + 1; m < builds.length; m++){
                    if(builds[m] > maxRight){
                        maxRight = builds[m];
                        buildRight++;
                    }
                }
            }
            result[i] = buildLeft + buildRight + 1;
        }
        return result;
    }

}
