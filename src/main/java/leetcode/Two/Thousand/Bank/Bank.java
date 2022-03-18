package leetcode.Two.Thousand.Bank;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：liuzhaolu
 * @description：2043. 简易银行系统
 * @prd : https://leetcode-cn.com/problems/simple-bank-system/
 * @date ：2022/3/18 3:56 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/3/18 3:56 下午     liuzhaolu       firstVersion
 */
public class Bank {

    public CopyOnWriteArrayList<Long> count = new CopyOnWriteArrayList<>();

    public Bank(long[] balance) {
        Arrays.stream(balance).forEach(b -> {
            count.add(b);
        });
    }

    public boolean transfer(int account1, int account2, long money) {
        if ((account2 > 0 && account2 <= count.size()) && withdraw(account1, money)) {
            return deposit(account2, money);
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > count.size()) {
            return false;
        }
        long originMoney = count.get(account - 1);
        count.set(account - 1, originMoney + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > count.size()) {
            return false;
        }
        long originMoney = count.get(account - 1);
        if (originMoney < money) {
            return false;
        }
        count.set(account - 1, originMoney - money);
        return true;
    }
}
