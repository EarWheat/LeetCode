package coding.ChainBase;

import java.util.List;
import java.util.Map;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/4/20 4:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/4/20 4:50 下午     liuzhaolu       firstVersion
 */
public class ChainBase {

    List<Command> commands;
    Command currentCommand;
    Command nextCommand;

    void setNextCommand(Command command) {
        this.nextCommand = command;
    }

    void exec(Map<Object, Object> context) {
        if(currentCommand.execute(context)){

        }
    }
}
