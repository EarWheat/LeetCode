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

    private static String getDay() {
        LocalDate date = LocalDate.of(2020,12,31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYYMM");
        return formatter.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getDay());
    }
}
