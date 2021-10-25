package leetcode.Three.calcEquation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/6 下午5:33
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class calcEquation {
    /**
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     *
     * @param equations
     * @param values
     * @param queries
     * @return         a/b = 2, a/c = 3
     */
    /**
     * 1、a/b = 2.0; b/a = 0/5;
     * 2、a/b * b/c
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> result = new HashMap<>();   // 结果集，key为算式，value为结果。 例如：a/b,2.0
        for(int i = 0; i < equations.size(); i++){
            List<String> temp = equations.get(i);
            String a = temp.get(0);
            String b = temp.get(1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a).append("/").append(b);
            Double value = values[i];
            for(Map.Entry entry : result.entrySet()){
                String key = (String) entry.getKey();
                divisionNew(result,key,stringBuilder.toString(),(Double) entry.getValue(),value);
            }
            result.put(stringBuilder.toString(),value);
            result.put(stringBuilder.reverse().toString(), 1/value);
        }
        double[] ret = new double[queries.size()];
        for(int i = 0; i < queries.size();i++){
            List<String> temp = equations.get(i);
            String a = temp.get(0);
            String b = temp.get(1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a).append("/").append(b);
            if(result.containsKey(stringBuilder.toString())){
                ret[i] = result.get(stringBuilder.toString());
            } else {
                ret[i] = -1;
            }
        }
        return ret;
    }

    public void divisionNew(Map<String, Double> result, String originalEquation, String newEquation, Double valuesO, Double valuesN){
        if(originalEquation.equals(newEquation)){
            return;
        }
        String[] oEquation = originalEquation.split("/");
        String oA = oEquation[0];
        String oB = oEquation[1];
        String[] nEquation = newEquation.split("/");
        String nA = nEquation[0];
        String nB = nEquation[1];
        StringBuilder stringBuilder = new StringBuilder();
        if(oA.equals(nA)){  // a/b a/c
            stringBuilder.append(nB).append("/").append(oB);    // a/b / a/c = c/b =
            if(!result.containsKey(stringBuilder.toString())){
                result.put(stringBuilder.toString(),valuesO / valuesN);
            }
            String temp = stringBuilder.reverse().toString();
            if(!result.containsKey(temp)){
                result.put(temp, 1 / (valuesO / valuesN));
            }
        } else if(oA.equals(nB)){   // a/b c/a
            stringBuilder.append(nA).append("/").append(oB);    // a/b / a/c = c/b =
            if(!result.containsKey(stringBuilder.toString())){
                result.put(stringBuilder.toString(),valuesO * valuesN);
            }
            String temp = stringBuilder.reverse().toString();
            if(!result.containsKey(temp)){
                result.put(temp, 1 / (valuesO * valuesN));
            }
        } else if(oB.equals(nA)){ // a/b b/c
            stringBuilder.append(oA).append("/").append(nB);
            if(!result.containsKey(stringBuilder.toString())){
                result.put(stringBuilder.toString(),valuesO * valuesN);
            }
            String temp = stringBuilder.reverse().toString();
            if(!result.containsKey(temp)){
                result.put(temp, 1 / (valuesO * valuesN));
            }
        } else if(oB.equals(nB)){ // a/b c/b
            stringBuilder.append(oA).append("/").append(nA);    // a/b / a/c = c/b =
            if(!result.containsKey(stringBuilder.toString())){
                result.put(stringBuilder.toString(),valuesO / valuesN);
            }
            String temp = stringBuilder.reverse().toString();
            if(!result.containsKey(temp)){
                result.put(temp, 1 / (valuesO / valuesN));
            }
        }
    }
}
