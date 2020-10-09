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
            for(int j = 1; j <= i; j++){
                System.out.print(j + " * " + i + " = " + i * j + "  ");
            }
            System.out.println();
        }
    }
}
