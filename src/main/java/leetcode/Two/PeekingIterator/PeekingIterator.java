package leetcode.Two.PeekingIterator;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/10/5 7:22 下午
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer ret = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}

