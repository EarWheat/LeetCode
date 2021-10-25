package coding.NineToNine;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-10-09 13:01
 * @desc 9*9乘法表
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class NineToNine {
    public static void main(String[] args) {
        for(int i = 1;i <= 9; i++){
            for(int k = 1; k < i; k++){
                System.out.print("       ");
            }
            for(int j = i; j <= 9; j++){
                if(i * j < 10){
                    System.out.print(i + "*" + j + "=" + i * j + "  ");
                } else {
                    System.out.print(i + "*" + j + "=" + i * j + " ");
                }
            }
            System.out.println();
        }
    }
}
