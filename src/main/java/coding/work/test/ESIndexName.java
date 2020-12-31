package coding.work.test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/31 下午12:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ESIndexName {

    private static String getESIndexName(Integer indexRange) {
        // 美东机房 国内机房选择不同的searchService，ES 上index name 不同
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
        List<String> suffix = Lists.newArrayList();
        if (indexRange == 0) {
            suffix.add(formatter.format(now));
        } else {
            int sign = indexRange < 0 ? -1 : 1;
            indexRange = indexRange * sign;
            for (int i = 0; i <= indexRange; i++) {
                suffix.add(formatter.format(now.plusMonths(i * sign)));
            }
        }
        List<String> indexNames = Lists.newArrayList();
        for (String s : suffix) {
            indexNames.add("us01-dos-order".concat(s));
        }

        return Joiner.on(",").join(indexNames);
    }

    public static void main(String[] args) {
        System.out.println(getESIndexName(-6));
    }
}
