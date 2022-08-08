package leetcode.Zero.maxValue;

import leetcode.Util.TreeNode;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/8 3:16 PM
 * @Version: 1.initial version; 2022/8/8 3:16 PM
 */
public class Answer {
    public int maxValue(TreeNode root, int k) {
        //return process(root,k,k);//这里restK需要分别传入1-k，选最大的
        //记忆化搜索的话：备忘录得用：Map<TreeNood,int[]>，有点复杂了，哈哈。
        //按照记忆化搜索转成dp的套路：看一下计算的过程：从树低往上dp。
        //当前root和其子节点的不同restK有关，所以需要先求出其子节点的不同restK的总价值
        //这里不同的是dp的过程也需要递归来求
        //按照这个套路来就行了。
        int[] res = process(root,k);
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i<=k;i++){
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
    /*private int process(TreeNode root, int restK, int k){
        //每个结点可以不要和不要。
        if(root == null){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        //不管restK==0 or !=0.都可以选择不要当前root结点
        res = process(root.left,k,k) + process(root.right,k,k);
        //restK!=0的情况： 等于0的情况就是上面的，只能不要
        if(restK != 0){
            //要的情况:
            int temp = Integer.MIN_VALUE;
            for(int i = 0;i<=restK-1;i++){
                temp = Math.max(temp,process(root.left,i,k)+process(root.right,restK-1-i,k));
            }
            res = Math.max(res,temp+root.val);//还得加上当前root的val
        }
        return res;
    }*/
    private int[] process(TreeNode root, int k){
        //返回的是当前root往下的在不同restK的情况下的最大总价值和
        int[] res = new int[k+1];//包括restK==0
        if(root == null){
            return res;
        }
        int[] lfSon = process(root.left,k);
        int[] rgSon = process(root.right,k);
        //当前root不要的情况:
        int tmp = lfSon[k]+rgSon[k];
        for(int i = 0;i<=k;i++){
            res[i] = tmp;
        }
        //要的情况:
        for(int i = 1;i<=k;i++){
            int temp = Integer.MIN_VALUE;
            for(int j = 0;j<=i-1;j++){
                temp = Math.max(temp,lfSon[j]+rgSon[i-1-j]);
            }
            res[i] = Math.max(res[i],temp + root.val);
        }
        return res;
    }

    作者：inventionliu
    链接：https://leetcode.cn/problems/er-cha-shu-ran-se-UGC/solution/xin-de-shu-by-inventionliu-iy3m/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
