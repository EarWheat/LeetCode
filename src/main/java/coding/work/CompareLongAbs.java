package coding.work;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-17 18:28
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class CompareLongAbs {
    public boolean CompareLongAbs(Long param1, Long param2, Long diff){
        return Math.abs(param1-param2) <= diff;
    }
}
