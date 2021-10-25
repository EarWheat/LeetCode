package leetcode.Three.NestedIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/23 上午7:19
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index;

    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
