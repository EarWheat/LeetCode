package exam;

import java.util.Scanner;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/18 类说明:
 */
public class exam1 {
    public static void main(String[] args) {
        int m,n;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            m=sc.nextInt();
            n=sc.nextInt();
            for(int i=m;i<n;i++){
                int ge  = i%10;
                int shi = i/10%10;
                int bai = i/10/10%10;

                //水仙花数判断要求
                if(i == (ge*ge*ge+shi*shi*shi+bai*bai*bai)){
                    System.out.print(i+ " ");
                    count++;
                }
            }
            if(count < 1){
                System.out.println("no");
            }

        }
    }
}
