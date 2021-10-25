package leetcode.Seven.accountsMerge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/18 上午10:39
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class accountsMerge {
    /**
     * 输入：
     * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     * 输出：
     * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     */
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts.size() <= 1){
            return accounts;
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> name2Email = new HashMap<>();   // 存储name和email的对应
        Map<String, String> email2name = new HashMap<>();   // 存储email和name的对应
        Map<String, List<String>> repeatEmail = new HashMap<>(); // 存储重复的邮箱
        int repeatName = 0; // 重名人数
        boolean merged;
        for(List<String> temp : accounts){
            merged = false;
            String name = temp.get(0);
            if (name2Email.containsKey(name)) {
                name += "_codingFlag_" + (repeatName++);  // 打上标记
            }
            List<String> personalEmail = new ArrayList<>(); // 个人邮箱
            temp.remove(0);
            for (int i = 0; i < temp.size(); i++) {
                String email = temp.get(i);
                if(personalEmail.contains(email)){
                    personalEmail.add(email);
                    continue;
                }
                if(email2name.containsKey(email)){
                    String originalName = email2name.get(email);    // 原始姓名
                    List<String> originalEmails = name2Email.get(originalName);  // 原始邮箱
                    for (String e : temp) {
                        if (!originalEmails.contains(e)) {
                            originalEmails.add(e);  // 合并邮箱
                            if (email2name.containsKey(e)) { // 原始邮箱不包含
                                String newName = email2name.get(e);
                                if (name2Email.containsKey(newName)) {
                                    List<String> newEmail = name2Email.get(newName);
                                    for (String ne : newEmail) {
                                        if (!originalEmails.contains(ne)) {
                                            originalEmails.add(ne);
                                        }
                                    }
                                    name2Email.remove(newName);
                                }
                            }
                        }
                        email2name.put(e, originalName);  // 添加总邮箱
                    }
                    merged = true;
                    break;
                } else {
                    email2name.put(email, name);  // 添加总邮箱
                }
                personalEmail.add(email);
            }
            if(!merged){
                name2Email.put(name,personalEmail);
            }
        }
        for(Map.Entry<String, List<String>> entry : name2Email.entrySet()){
            List<String> temp = new ArrayList<>();
            String name = entry.getKey();
            if(name.contains("_codingFlag_")){
                name = name.split("_")[0];
            }
            temp.add(name);
            List<String> email = entry.getValue().stream().sorted().collect(Collectors.toList());
            temp.addAll(email);
            result.add(temp);
        }
        return result;
    }

    public static List<List<String>> solution(List<List<String>> accounts) {
        if(accounts.size() <= 1){
            return accounts;
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> name2Email = new HashMap<>();   // 存储name和email的对应
        Map<String, String> email2name = new HashMap<>();   // 存储email和name的对应
        int repeatName = 0; // 重名人数
        boolean merged;
        for(List<String> temp : accounts){
            merged = false;
            String name = temp.get(0);
            if (name2Email.containsKey(name)) {
                name += "_codingFlag_" + (repeatName++);  // 打上标记
            }
            Set<String> personalEmail = new HashSet<>(); // 个人邮箱
            temp.remove(0);
            for (int i = 0; i < temp.size(); i++) {
                String email = temp.get(i);
                if(personalEmail.contains(email)){
                    continue;
                }
                if(email2name.containsKey(email)){
                    String originalName = email2name.get(email);    // 原始姓名
                    Set<String> originalEmails = new HashSet<>();
                    originalEmails = name2Email.get(originalName);  // 原始邮箱
                    for (int j = i; j < temp.size(); j++) {
                        String e = temp.get(j);
                        if(!originalEmails.contains(e) && email2name.containsKey(e)){    // 原始邮箱不包含
                            String newName = email2name.get(e);
                            if(name2Email.containsKey(newName)){
                                originalEmails.addAll(name2Email.get(newName));
                                name2Email.remove(newName);
                            }
                        }
                    }
                    originalEmails.addAll(temp);    // 合并邮箱
                    for (int j = 0; j < temp.size(); j++) {
                        email2name.put(temp.get(j), originalName);  // 添加总邮箱
                    }
                    merged = true;
                    break;
                } else {
                    email2name.put(email, name);  // 添加总邮箱
                }
                personalEmail.add(email);
            }
            if(!merged){
                name2Email.put(name,personalEmail);
            }
        }
        for(Map.Entry<String, Set<String>> entry : name2Email.entrySet()){
            List<String> temp = new ArrayList<>();
            String name = entry.getKey();
            if(name.contains("_codingFlag_")){
                name = name.split("_")[0];
            }
            temp.add(name);
            List<String> email = entry.getValue().stream().sorted().collect(Collectors.toList());
            temp.addAll(email);
            result.add(temp);
        }
        return result;
    }

    /**
     * [["David","David0@m.co","David0@m.co","David1@m.co"],["David","David6@m.co","David1@m.co","David6@m.co"],["David","David3@m.co","David8@m.co","David0@m.co"],["David","David5@m.co","David8@m.co","David7@m.co"],["David","David5@m.co","David2@m.co","David1@m.co"],["David","David0@m.co","David7@m.co","David6@m.co"],["David","David0@m.co","David1@m.co","David4@m.co"],["David","David1@m.co","David1@m.co","David8@m.co"]]
     * [["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]
     * [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
     * [["Kevin","Kevin1@m.co","Kevin5@m.co","Kevin2@m.co"],["Bob","Bob3@m.co","Bob1@m.co","Bob2@m.co"],["Lily","Lily3@m.co","Lily2@m.co","Lily0@m.co"],["Gabe","Gabe2@m.co","Gabe0@m.co","Gabe2@m.co"],["Kevin","Kevin4@m.co","Kevin3@m.co","Kevin3@m.co"]]
     * @param args
     */
    public static void main(String[] args) {
//        String[][] temp = new String[][]{{"David","David0@m.co","David1@m.co"},{"David","David3@m.co","David4@m.co"},{"David","David4@m.co","David5@m.co"},{"David","David2@m.co","David3@m.co"},{"David","David1@m.co","David2@m.co"}};
//        String[][] temp = new String[][]{{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}};
//        String[][] temp = new String[][]{{"Kevin","Kevin1@m.co","Kevin5@m.co","Kevin2@m.co"},{"Bob","Bob3@m.co","Bob1@m.co","Bob2@m.co"},{"Kevin","Kevin4@m.co","Kevin3@m.co","Kevin3@m.co"}};
        String[][] temp = new String[][]{{"John", "johnsmith@mail.com", "john00@mail.com"},{"John", "johnnybravo@mail.com"},{"John", "johnsmith@mail.com", "john_newyork@mail.com"},{"Mary", "mary@mail.com"}};
        List<List<String>> accounts = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            List<String> email = new ArrayList<>();
            for (int j = 0; j < temp[i].length; j++) {
                email.add(temp[i][j]);
            }
            accounts.add(email);
        }
        System.out.println(solution(accounts));
    }
}
