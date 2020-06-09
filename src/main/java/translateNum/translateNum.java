package translateNum;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-09 14:32
 * @desc:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

  a,b,c,d,e,f,g,h,i,j, k, l, m
* 0,1,2,3,4,5,6,7,8,9,10,11,12

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
思路：递归
* 1: translateNum(1)                        1       b
* 12: translateNum(12)                       2        bc, m
* 122: translateNum(12) + translateNum(2)     2 + 1,   bcc, mc, bw
* 1225: translateNum(122) + translateNum(12)    3 + 2    bccf, mcf, bwf, bcz, mz    如果最后一个能拼成新的，则在原来的基础上
* 12258: translateNum(1225)                     5  bccfi, bwfi, mcfi, bczi, mzi    如果不能和最后一个拼成新的，则等于前面的
*
* 1: translateNum(1)                        1       b
* 11: translateNum(11)                       2       bb, l
* 111: translateNum(11) + translateNum(1)    3       bbb, lb, bl,
* 1111: translateNum(111) + translateNum(11)   5       bbbb, lbb, blb, bbl, ll    如果最后一个能拼成新的，则在原来的基础上
* 11111: translateNum(1111) + translateNum(111)   8       bbbbb, lbbb, blbb, bblb, llb, bbbl, lbl, bll    如果不能和最后一个拼成新的，则等于前面的
*
* 1:    b
* 10:    ba, k
* 100:    baa, ka,
* 1001:    baab, kab,
* 10001:    baaab, kaab
* 10010:    baaba, kaba, kak,baak
* 10100:    babaa, kbaa, kka,
 */
public class translateNum {
    public static int translateNum(int num) {
        // 只有1个数字
        if(num < 10){
            return 1;
        }
        if(num <= 25){
            return 2;
        }
        if(num < 100){
            return 1;
        }
        if(num % 100 < 10){ // 最后两位含0 1001 100
            return translateNum(num / 10);
        }
        if(num % 100 <= 25){    // 最后两位
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            return translateNum(num / 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(translateNum(1));
        System.out.println(translateNum(10));
        System.out.println(translateNum(100));
        System.out.println(translateNum(1001));
        System.out.println(translateNum(10001));
        System.out.println(translateNum(10010));
        System.out.println(translateNum(10100));
        System.out.println(translateNum(12258));
        System.out.println(translateNum(11111));
    }


}
