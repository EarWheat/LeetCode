package leetcode.Nine.minFallingPathSum;
//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。
//
//
//
// 示例 1：
//
//
//
//
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
//
//
// 示例 2：
//
//
//
//
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
//
//
//
//
// 提示：
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 动态规划 矩阵 👍 262 👎 0

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Arrays;

/**
 * @Desc: 下降路径最小和
 * @Author: 泽露
 * @Date: 2023/7/13 12:07 PM
 * @Version: 1.initial version; 2023/7/13 12:07 PM
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mn = dp[i - 1][j];
                if (j > 0) {
                    mn = Math.min(mn, dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    mn = Math.min(mn, dp[i - 1][j + 1]);
                }
                dp[i][j] = mn + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        String entryUrl = "taobao://huodong.m.taobao.com/act/talent/live.html?ut_sk=1.YKy2MpAJa00DAPxcYdxiDiow_21380790_1689237164409.Copy.zhibo&bdi=50&mbdfu=10000&rtc_delay=5000&bui=50&max_delay=15000&livesource=share&viewer_id=2426471071&tlre=700&livePlayUrl=artc%3A%2F%2Flivecb-rtclive.taobao.com%2Fmediaplatform%2F278deadf-e8db-48f9-b985-5f08dd35f332%3Fauth_key%3D1691761727-0-0-ece4ba74f309ecaf99054983e163ff89&ibmve=20&ibmc=30&type=507&rtclive=1&nssi=0&id=418298524721&liveUrlType=rtcLive&wh_cid=278deadf-e8db-48f9-b985-5f08dd35f332&artp_switch_flags=69&psid=grtn&dscp=1&sjc=0&sourceType=other&bjip=60&suid=CF99148C-68EC-47C3-9A95-C756F8264FE6&pidm=0&livetype=living&cp_origin=taobaozhibo%7Ca2141.8001249%7C%7B%22feed_id%22%3A%22418298524721%22%2C%22account_id%22%3A%220%22%2C%22spm-cnt%22%3A%22a2141.8001249%22%2C%22app_key%22%3A%2221380790%22%2C%22os%22%3A%22ios%22%7D&F=pc&un=bf215854db863721acb7a888e4a1d6ac&share_crt_v=1&un_site=0&spm=a2159r.13376460.0.0&sp_abtk=common_zhibo_commonInfo&sp_tk=NmlsWGR0c1pzYXk%3D&cpp=1&shareurl=true&short_name=h.50NbBSW&bxsign=scd6z9oVbASCFgl4K83UoKznhClWcQxNfQefSr4E9EWBaiVhCLXhJ_8_OV9FO2Hez4m2D0CoNdYLDX7rHYWxiTLEc2jrqN25NNXtMmdI79Ey_CzHx0L53vVyemLS4JVrEHf&app=macos_safari";
        String[] split = entryUrl.split("taobao://");
        System.out.println(split.length);
        System.out.println(JSONObject.toJSONString(split));
        //        String liveSource = "";
//        URL url = new URL(entryUrl);
//        String query = url.getQuery();
//        String[] qs = query.split("&");
//        for (String q : qs) {
//            if (q.contains("livesource") || q.contains("liveSource")) {
//                String[] pair = q.split("=");
//                liveSource = pair[1];
//                break;
//            }
//        }
//        System.out.println(liveSource);
    }
}
