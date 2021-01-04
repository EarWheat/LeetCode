package leetcode.Five.fib;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/4 下午12:16
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class fib {
    public int fib(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
