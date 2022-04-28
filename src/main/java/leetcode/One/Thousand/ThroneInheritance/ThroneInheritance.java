package leetcode.One.Thousand.ThroneInheritance;


import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/20 下午2:23
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ThroneInheritance {
    String kingName;

    Map<String, List<String>> map = new HashMap<>();

    Set<String> deathSet = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        map.put(kingName, new LinkedList<>());
    }

    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.put(childName, new LinkedList<>());
    }

    public void death(String name) {
        deathSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new LinkedList<>();
        dfs(result, kingName);
        return result;
    }

    private void dfs(List<String> result, String name) {
        if (!deathSet.contains(name)) {
            result.add(name);
        }
        for (String subName :  map.get(name)) {
            dfs(result, subName);
        }
    }

}
