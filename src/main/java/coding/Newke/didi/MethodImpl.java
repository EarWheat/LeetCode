package coding.Newke.didi;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/28 4:40 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MethodImpl implements MethodInterface{

    @Override
    public void method1(AbstractClass abstractClass) {
        if(abstractClass instanceof ChildClass){
            System.out.println(((ChildClass) abstractClass).getChildName());
        }
    }

    @Override
    public void method2(Context context) {

    }

    @Override
    public <T> void method3(T t) {
        RejectContext rejectContext= null;
        if(t instanceof RejectContext){
            rejectContext = (RejectContext) t;
        }
    }
}
