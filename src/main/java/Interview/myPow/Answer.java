package Interview.myPow;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/23 3:18 PM
 * @Version: 1.initial version; 2022/5/23 3:18 PM
 */
public class Answer {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
}
