package coding.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-11-11 17:57
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class ContentToVec {
    public static List<String> reshapeContentVec(String[][] contentVec, Long FirstDim) throws Exception
    {
        Integer tableLen = contentVec.length;
        Integer tableWid = contentVec[0].length;
        if (FirstDim < 1 || FirstDim > tableLen)
            throw new Exception("句子长度不合适, 请选择正确的句子长度");
        if (((tableLen * tableWid) % FirstDim) != 0)
            throw new Exception("张量形状错误, 必须保持维度相同");
        List<String> flatten = new ArrayList<String>();
        List<String> reshapeVec = new ArrayList<String>();
        for (int i = 0; i < tableLen; i++)
        {
            for (int j = 0; j < tableWid; j++)
            {
                flatten.add(contentVec[i][j]);
            }
        }
        Integer start = 0;
        Integer end = 0;
        while (start < flatten.size())
        {

            end = start + (int)(flatten.size() / FirstDim);
            String subVec = "";
            for (int j = start; j < end; j++)
            {
                subVec += flatten.get(j) + ",";
            }
            subVec = subVec.substring(0, subVec.length() - 1);
            reshapeVec.add(subVec);
            start = end;
        }
        return reshapeVec;
    }

    public static void main(String[] args) throws Exception
    {
        String[][] contentVec = {{"1", "2", "3"}, {"4", "5", "6"}, {"8", "9", "10"}, {"10", "11", "12"}};
        Long FirstDim = 4L;
        List<String> reshapeVec = reshapeContentVec(contentVec, FirstDim);
        System.out.println(reshapeVec);
    }
}
