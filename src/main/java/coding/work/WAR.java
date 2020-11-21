package coding.work;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-19 16:27
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class WAR {
    /**
     *
     * @param lastLowerTimes    本次不达标次数
     * @param lastLevel        上一个处置等级
     * @param isLower      是否完成WAR指标
     * @param war         war值
     * @return
     */
    public static Long computeWarPunishLevelV2(Long lastLowerTimes, Long lastLevel,  Boolean isLower, Double war) {
        if (!isLower) {
            if (lastLowerTimes == null || lastLowerTimes == 0) { // 正常司机终身首次
                return -1L;
            }
            if (lastLevel == 0 || lastLevel == -1){ //正常司机非首次犯错
                return 1L;
            } else if (lastLevel < 4 && lastLevel > 0 ) { // 待改善司机第2~4次犯错
                return  lastLevel + 1;
            } else if(lastLevel >= 4){
                return 4L;
            } else {
                return -2L;
            }
        } else { // 完成率超过城市最低要求
            if ((war == null || isLower == null) && lastLevel < 4) {
                return -2L;
            }
            return 0L;
        }
    }

    /**
     *
     * @param lastWarLevel      上一个处置等级
     * @param punishTimes       处置次数
     * @param needControl  是否需要管控
     * @param isComplete   是否完成WAR指标
     * @return
     */
    private static Long driverWarPunishLevel(Long lastWarLevel,Long lastWeekWarLevel, Long punishTimes, Boolean needControl, Boolean isComplete){
        if(isComplete){
            return 0L;
        }
        if(needControl){
            if(lastWarLevel == null || punishTimes == 0){
                return -1L;
            }
            if(lastWarLevel == -1L){
                return 1L;
            }
            if(lastWarLevel == 4L){
                // 本次为4档7天，需要看上周是否为-2空档, 否则下周给予空档
                if(lastWeekWarLevel == -2L){
                    return 4L;
                } else {
                    return -2L;
                }
            }
            if(lastWarLevel < -1L || lastWarLevel > 4L){
                return -2L;
            }
            return lastWarLevel + 1;
        } else {
            return -2L;
        }
    }

    public static void main(String[] args) {
        System.out.println(driverWarPunishLevel(4L,-2L,4L,true, false));
    }
}
