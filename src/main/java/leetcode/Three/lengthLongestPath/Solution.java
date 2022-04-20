package leetcode.Three.lengthLongestPath;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：liuzhaolu
 * @description：388. 文件的最长绝对路径
 * @prd : https://leetcode-cn.com/problems/longest-absolute-file-path/
 * @date ：2022/4/20 9:46 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/20 9:46 上午     liuzhaolu       firstVersion
 */
public class Solution {


    public static void main(String[] args) {
        String a = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath(a));
    }

    public static class Dir {
        String name;
        List<Dir> subDir;

        public Dir(String name) {
            this.name = name;
        }
    }

    public int lengthLongestPath(String input) {
        if(!input.contains("\\n\\t")){
            return 0;
        }
        Dir root = crateDir(input);
        return lengthLongestPathV2(root);
    }

    public int lengthLongestPathV2(Dir dir) {
        int cur = dir.name.length();
        int max = 0;
        int result = cur;
        if (dir.subDir != null) {
            for (Dir d : dir.subDir) {
                cur++;
                max = Math.max(max, lengthLongestPathV2(d));
                result = Math.max(result, cur + max);
                cur--;
            }
        }
        return result;
    }

    public Dir crateDir(String input) {
        if (!input.contains("\\n")) {
            return null;
        }
        List<String> dirNames = new ArrayList<>();
        StringBuilder dirName = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            if (input.charAt(i) != '\\') {
                dirName.append(input.charAt(i));
                i++;
            } else {
                if (i + 4 < input.length()) {
                    String temp = input.substring(i, i + 4);
                    if ("\\n\\t".equalsIgnoreCase(temp)) {
                        if (i + 4 >= input.length() || input.charAt(i + 4) != '\\') {
                            dirNames.add(dirName.toString());
                            dirName.delete(0, dirName.length());
                        } else {
                            dirName.append("\\n\\t");
                        }
                        i = i + 4;
                    } else {
                        dirName.append(input.charAt(i));
                        i++;
                    }
                }
            }
        }
        dirNames.add(dirName.toString());
        Dir dir = new Dir(dirNames.get(0));
        List<Dir> child = new ArrayList<>();
        for (int j = 1; j < dirNames.size(); j++) {
            if (dirNames.get(j).contains("\\n\\t")) {
                String tempDirName = dirNames.get(j);
                String newDirName = tempDirName.replace("\\n\\t\\t", "\\n\\t");
                child.add(crateDir(newDirName));
            } else {
                child.add(new Dir(dirNames.get(j)));
            }
        }
        dir.subDir = child;
        return dir;
    }
}
