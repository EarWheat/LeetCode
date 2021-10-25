package coding.Newke.didi;


/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/9/28 10:41 上午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Demo{
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        MethodInterface method = new MethodImpl();
        method.method1(childClass);
        Context rateContext = new RateContext();
        Context rejectOrderContext = new RejectContext();
        method.method2(rejectOrderContext);
    }

}
