package leetcode.Four.validIPAddress;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/29 3:09 PM
 * @Version: 1.initial version; 2022/5/29 3:09 PM
 */
public class Answer {
    public String validIPAddress(String IP) {
        if (IP == null) {
            return "Neither";
        }

        String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
        String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
        String regex1 = "([\\da-fA-F]{1,4})";
        String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

        String result = "Neither";
        if (IP.matches(regexIPv4)) {
            result = "IPv4";
        } else if (IP.matches(regexIPv6)) {
            result = "IPv6";
        }
        return result;
    }
}
