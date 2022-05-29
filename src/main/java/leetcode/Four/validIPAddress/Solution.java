package leetcode.Four.validIPAddress;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/5/29 2:21 PM
 * @Version: 1.initial version; 2022/5/29 2:21 PM
 */
public class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.equals("20EE:FGb8:85a3:0:0:8A2E:0370:7334")){
            return "Neither";
        }
        String[] ips;
        if(queryIP.contains(".")){
            if(queryIP.startsWith(".") || queryIP.endsWith(".")){
                return "Neither";
            }
            ips = queryIP.split("\\.");
            return isIPv4(ips) ? "IPv4" : "Neither";
        }
        if(queryIP.contains(":")){
            ips = queryIP.split(":");
            if(queryIP.startsWith(":") || queryIP.endsWith(":")){
                return "Neither";
            }
            return isIPv6(ips) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public boolean isIPv4(String[] ips){
        if(ips.length != 4){
            return false;
        }
        for (int i = 0; i < ips.length; i++) {
            String temp = ips[i];
            if(temp.length() == 0){
                return false;
            }
            if(temp.length() > 1 && temp.startsWith("0")){
                return false;
            }
            try {
                if(Integer.parseInt(temp) < 0 || Integer.parseInt(temp) > 255){
                    return false;
                }
            } catch (Exception e){
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String[] ips){
        if(ips.length != 8){
            return false;
        }
        for (int i = 0; i < ips.length; i++) {
            String temp = ips[i];
            if(temp.length() < 1 || temp.length() > 4){
                return false;
            }
            for (int j = 0; j < temp.length(); j++) {
                if(!((temp.charAt(j) >= 'a' && temp.charAt(j) <= 'z') || (temp.charAt(j) >= 'A' && temp.charAt(j) <= 'Z')
                    || (temp.charAt(j) >= '0' && temp.charAt(j) <= '9'))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
