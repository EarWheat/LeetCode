package leetcode.One.Thousand.longestDupSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：1044. 最长重复子串
 * @prd : https://leetcode-cn.com/problems/longest-duplicate-substring/
 * @date ：2021/12/23 2:14 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/23 2:14 下午     liuzhaolu       firstVersion
 */
public class Solution {
    long mod1=(long)1e9+7;
    long mod2=mod1+2;
    int start=-1;
    public String longestDupSubstring(String s) {
        int l=1,r=s.length();
        while(l<r){
            int mid=(l+r)>>1;
            if(hasDuplicate(s,mid)){l=mid;}
            else{r=mid-1;}
            if(l==r-1){
                if(hasDuplicate(s,r)){l=r;}
                else if(hasDuplicate(s,l)){;}
                break;
            }
        }
        return start==-1?"":s.substring(start,start+l);
    }
    public boolean hasDuplicate(String s,int l){
        //判断是否存在长度为l的最长重复串，注意使用双哈希
        Map<Long,Integer> map1=new HashMap<>();
        Map<Long,Integer> map2=new HashMap<>();
        long h1=0,p1=1,h2=0,p2=1;
        for(int i=0;i<l-1;i++){
            p1=(p1*31)%mod1;
            p2=(p2*41)%mod2;
        }
        for(int i=0;i<l;i++){
            h1=(h1*31+s.charAt(i)-'a')%mod1;
            h2=(h2*41+s.charAt(i)-'a')%mod2;
        }
        map1.put(h1,0);
        map2.put(h2,0);
        for(int i=1;i<=s.length()-l;i++){
            h1=(h1+(mod1-p1)*(s.charAt(i-1)-'a'))%mod1;
            h1=(h1*31+s.charAt(i-1+l)-'a')%mod1;
            h2=(h2+(mod2-p2)*(s.charAt(i-1)-'a'))%mod2;
            h2=(h2*41+s.charAt(i-1+l)-'a')%mod2;
            if(map1.containsKey(h1)&&map2.containsKey(h2)){
                start=i;
                return true;
            }
            map1.put(h1,i);
            map2.put(h2,i);
        }
        return false;
    }
}
