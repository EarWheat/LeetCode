package Interview.myPow;

/**
 * @Desc: 剑指 Offer 16. 数值的整数次方
 * @Author: 泽露
 * @Date: 2022/5/23 2:47 PM
 * @Version: 1.initial version; 2022/5/23 2:47 PM
 */
public class Solution {
//    public double myPow(double x, int n) {
//        if(n == 0 || x == 1){
//            return  1;
//        }
//        double result = x;
//        if(n > 0){
//            for (int i = 0; i < n - 1; i++) {
//                result *= x;
//            }
//        } else {
//            for (int i = n; i <= 0; i++) {
//                result /= x;
//            }
//        }
//        return result;
//    }

    public double myPow(double x, int n) {
        double result = 0;
        if(n == 0){
            return  1;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1 / x;
        }
        if(n > 0){
            if(n % 2 == 0){
                result = myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                result = myPow(x, n / 2) * myPow(x, n / 2 + 1);
            }
        } else {
            if(n % 2 == 0){
                result = myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                result = myPow(x, n / 2) * myPow(x, n / 2 - 1);
            }
        }
        return result;
    }
}
