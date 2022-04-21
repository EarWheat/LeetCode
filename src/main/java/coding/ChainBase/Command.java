package coding.ChainBase;

import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/4/20 4:51 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/20 4:51 下午     liuzhaolu       firstVersion
 */
public interface Command {

    boolean execute(Map<Object, Object> context);
}
