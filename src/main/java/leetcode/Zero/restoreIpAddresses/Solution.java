package leetcode.Zero.restoreIpAddresses;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liuzhaolu
 * @description：93. 复原 IP 地址
 * @prd : https://leetcode-cn.com/problems/restore-ip-addresses/
 * @date ：2022/2/17 3:54 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/17 3:54 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 3) {
            return result;
        }
        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (j - i > 3) {
                    break;
                }
                for (int k = j + 1; k < s.length(); k++) {
                    if (k - j > 3) {
                        break;
                    }
                    if (s.length() - k > 3) {
                        continue;
                    }
                    if (isVail(s.substring(0, i)) && isVail(s.substring(i, j)) && isVail(s.substring(j, k)) && isVail(s.substring(k))) {
                        result.add(s.substring(0, i) + "." + s.substring(i, j) + "." + s.substring(j, k) + "." + s.substring(k));
                    }
                }
            }
        }
        return result;
    }


    public boolean isVail(String s) {
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0) {
            return false;
        }
        return true;
    }

    public boolean isVailIP(String s) {
        String[] ips = s.split("\\.");
        if (ips.length != 4) {
            return false;
        }
        for (String ip : ips) {
            if (ip.length() > 1 && ip.startsWith("0")) {
                return false;
            }
            for (int i = 0; i < ip.length(); i++) {
                if (ip.charAt(i) < '0' || ip.charAt(i) > '9') {
                    return false;
                }
            }
            if (Integer.parseInt(ip) > 255 || Integer.parseInt(ip) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(JSONObject.toJSONString(solution.restoreIpAddresses("0000")));
    }
}
