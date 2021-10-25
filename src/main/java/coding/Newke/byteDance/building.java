package coding.Newke.byteDance;


import java.util.Scanner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-06 09:50
 * @desc:
 */
public class building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer d = scanner.nextInt();
        int[] builds = new int[n];
        for(int i = 0 ; i < n; i ++){
            builds[i] = scanner.nextInt();
        }
        System.out.println(building(builds,d));
    }

    private static int building(int[] builds, int d){
        // 最近的距离就超过d
        if(builds[1] - builds[0] > d){
            return 0;
        }
        return  0;
    }
}
