package leetcode.History.IntReverse;

/*
 * @author:liuzhaolu
 * @createTime: 2020-03-08 18:03
 * @desc:
 */
public class intReverse {
    public static void main(String[] args){

    }

    public int reverse(int x) {
        // long型比int型要长，用long转换int，若位数溢出返回0
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

}
