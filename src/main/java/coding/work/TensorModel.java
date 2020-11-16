//package coding.work;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.io.IOUtils;
//import org.tensorflow.Graph;
//import org.tensorflow.Session;
//import org.tensorflow.Tensor;
//
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.text.NumberFormat;
//
//public class TensorModel {
//
//    static Map<String, Graph> graphMap = new ConcurrentHashMap<>();
//
//    public static JSONObject wordvectorModel(String url_path, List<String> wordList) {
//        JSONObject res_hash = new JSONObject();
//        try {
//            int len = wordList.size();
//            int llen = wordList.get(0).split(",").length;
//
//            float[][] input_wordvector = new float[len][llen];
//
//            for (int i = 0; i < len; i++) {
//                String[] words = wordList.get(i).split(",");
//
//                for (int j = 0; j < words.length; j++) {
//                    input_wordvector[i][j] = Float.valueOf(words[j]);
//                }
//            }
//
//            Graph graph = null;
//
//            if (graphMap.containsKey(url_path)) {
//                graph = graphMap.get(url_path);
//            } else {
//                graph = new Graph();
//                URL url = new URL(url_path);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setConnectTimeout(500);
//                conn.setReadTimeout(500);
//
//                InputStream is = conn.getInputStream();
//                byte[] graphBytes = IOUtils.toByteArray(is);
//                graph.importGraphDef(graphBytes);
//                graphMap.put(url_path, graph);
//            }
//
//            Session session = new Session(graph);
//            Tensor t = Tensor.create(input_wordvector);
//            List out = session.runner().feed("Input_x", t).fetch("Output").run();
//
//
//            ArrayList<Float> res_array = new ArrayList<Float>();
//            for (Object s : out) {
//                float[][] rs = new float[1][2];
//                Tensor aa = (Tensor) s;
//                aa.copyTo(rs);
//                for (float i : rs[0]) {
//                    res_array.add(i);
//                }
//            }
//            float pos_probability = res_array.get(0);
//            float neg_probability = res_array.get(1);
//            int result = pos_probability>neg_probability?1:0 ;
//            res_hash.put("pos_probability", pos_probability);
//            res_hash.put("neg_probability", neg_probability);
//            res_hash.put("result", result);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return res_hash;
//    }
//}