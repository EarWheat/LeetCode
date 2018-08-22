package coding;

import java.util.Scanner;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/22 类说明:
 */
public class Pack {

    public static void getPack(int[] weight,int[] value,int capacity){
        int[][] m = new int[weight.length][capacity+1];
        m[0][0] = 0;
        for(int i = 1;i <weight.length;i++){
            for(int j = 1;j<=capacity;j++){
                if(j >= weight[i]){
                    m[i][j] = Math.max(m[i-1][j], m[i-1][j-weight[i]]+value[i]);
                } else {
                    m[i][j] = m[i-1][j];
                }
            }
        }
        for(int i = 0;i<m.length;i++){
            for(int j = 0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("max value:"+m[weight.length-1][capacity-1]);
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        int[] weight = {8,6,4,9,2,7,4};
//        int[] value = {6,7,3,8,5,2,1};
        int[] weight = {0,2,3,4,5};
        int[] value = {0,3,4,5,6};
        while (scanner.hasNextInt()){
            int capacity = scanner.nextInt();
            getPack(weight,value,capacity);
        }
    }
}
