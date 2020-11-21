package coding.work;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Word2VecBin {

    static Map<String, HashMap<String, double[]>> graphMap = new ConcurrentHashMap<String, HashMap<String, double[]>>();

    HashMap<String, double[]> wordMap = new HashMap<String, double[]>();
    int words;
    int size;
    int topNSize = 40;
    private static final int MAX_SIZE = 50;

    public Word2VecBin() {}

    /**
     * 得到词向量
     *
     * @param word
     * @return
     */
    public double[] getWordVector(String word) {
        return wordMap.get(word);
    }


    /**
     * 加载模型
     *
     * @param path
     *            模型的路径
     * @throws IOException
     */
    public void loadGoogleModel(String path) throws IOException {


        if(graphMap.containsKey(path)) {
            wordMap = graphMap.get(path);
        }else{
            DataInputStream dis = null;
            BufferedInputStream bis = null;
            double len = 0;
            double vector = 0;

            try {
//            本地路径的方法
//            bis = new BufferedInputStream(new FileInputStream(path));
//            dis = new DataInputStream(bis);
//          网络传输的方法
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(500);
                conn.setReadTimeout(500);

                dis = new DataInputStream(conn.getInputStream());


                // //读取词数
                words = Integer.parseInt(readString(dis));
                // //大小
                size = Integer.parseInt(readString(dis));
                String word;
                double[] vectors = null;
                for (int i = 0; i < words; i++) {
                    word = readString(dis);
                    vectors = new double[size];
                    for (int j = 0; j < size; j++) {
                        vector = readFloat(dis);
                        len += vector * vector;
                        vectors[j] = (float) vector;
                    }
                    wordMap.put(word, vectors);
                }
                graphMap.put(path, wordMap);
            } finally {
                if (bis != null) {
                    bis.close();
                }
                if (dis != null) {
                    dis.close();
                }

            }
        }

    }



    /**
     * 读取一个字符串
     *
     * @param dis
     * @return
     * @throws IOException
     */
    private static String readString(DataInputStream dis) throws IOException {
        // TODO Auto-generated method stub
        byte[] bytes = new byte[MAX_SIZE];
        byte b = dis.readByte();
        int i = -1;
        StringBuilder sb = new StringBuilder();
        while (b != 32 && b != 10) {
            i++;
            bytes[i] = b;
            b = dis.readByte();
            if (i == 49) {
                sb.append(new String(bytes));
                i = -1;
                bytes = new byte[MAX_SIZE];
            }
        }
        sb.append(new String(bytes, 0, i + 1));
        return sb.toString();
    }

    public static double readFloat(InputStream is) throws IOException {
        byte[] bytes = new byte[4];
        is.read(bytes);
        return getFloat(bytes);
    }

    /**
     * 读取一个float
     *
     * @param b
     * @return
     */
    public static double getFloat(byte[] b) {
        int accum = 0;
        accum = accum | (b[0] & 0xff) << 0;
        accum = accum | (b[1] & 0xff) << 8;
        accum = accum | (b[2] & 0xff) << 16;
        accum = accum | (b[3] & 0xff) << 24;
        return Double.valueOf(Float.intBitsToFloat(accum));
    }

    private static List<String> getWordVector(String content, String stopWord, Long wordNum, Long worddim, String url) {

        Word2VecBin model = new Word2VecBin();
        try {
            model.loadGoogleModel(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = content.split(" ");
        String[] stopWords = stopWord.split(",");
        HashMap stopWordsHM = new HashMap();
        for (String word : stopWords) {
            stopWordsHM.put(word, 1);
        }

        int wordsLen = words.length;
        int trueNum = 0;
        List<String> stringList = new ArrayList<>();
         ArrayList al = new ArrayList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordsLen; i++)
        {
            String word = words[i];
//            System.out.println(word);

            double[] vec = model.getWordVector(word);
            if (!stopWordsHM.containsKey(word) && vec != null){
                trueNum++;
//                System.out.println(Arrays.toString(vec));
                for(int j=0; j<worddim; j++){
                    sb.append(vec[j]).append(",");
                }
            }

            if(trueNum >= wordNum) break;

        }

        for (int i=0; i<wordNum-trueNum;i++){
            for(int j=0; j<worddim; j++){
                sb.append("0.0,");
            }
        }

//        System.out.println(sb.length());
        String res = sb.toString();
        al.add(res.substring(0, res.length()-1));
        return al;
    }

    public static void main(String[] args) throws IOException {
//        String url = "http://img0.didiglobal.com/static/psi_models/do1_niTrKZU1R8LzlJVwv3pY";
//        String content = "Me cobrou a mais do que o aplicativo informou... Ele não desviou do trânsito porque não quis.... Eu não concordo em ter que pagar a mais,pois não fui informada que si ter trânsito é cobrado a mais...";
//        String stopWord = "de,a,o,que,e,do,da,em,um,para,com,não,uma,os,no,se,na,por,mais,as,dos,como,mas,ao,ele,das,à,seu,sua,ou,quando,muito,nos,já,eu,também,só,pelo,pela,até,isso,ela,entre,depois,sem,mesmo,aos,seus,quem,nas,me,esse,eles,você,essa,num,nem,suas,meu,às,minha,numa,pelos,elas,qual,nós,lhe,deles,essas,esses,pelas,este,dele,tu,te,vocês,vos,lhes,meus,minhas,teu,tua,teus,tuas,nosso,nossa,nossos,nossas,dela,delas,esta,estes,estas,aquele,aquela,aqueles,aquelas,isto,aquilo,estou,está,estamos,estão,estive,esteve,estivemos,estiveram,estava,estávamos,estavam,estivera,estivéramos,esteja,estejamos,estejam,estivesse,estivéssemos,estivessem,estiver,estivermos,estiverem,hei,há,havemos,hão,houve,houvemos,houveram,houvera,houvéramos,haja,hajamos,hajam,houvesse,houvéssemos,houvessem,houver,houvermos,houverem,houverei,houverá,houveremos,houverão,houveria,houveríamos,houveriam,sou,somos,são,era,éramos,eram,fui,foi,fomos,foram,fora,fôramos,seja,sejamos,sejam,fosse,fôssemos,fossem,for,formos,forem,serei,será,seremos,serão,seria,seríamos,seriam,tenho,tem,temos,tém,tinha,tínhamos,tinham,tive,teve,tivemos,tiveram,tivera,tivéramos,tenha,tenhamos,tenham,tivesse,tivéssemos,tivessem,tiver,tivermos,tiverem,terei,terá,teremos,terão,teria,teríamos,teriam";
//        Long wordNum = 30L;
//        Long worddim = 105L;
//
//        List<String> wordVector = getWordVector(content, stopWord, wordNum, worddim, url);
//        System.out.println(wordVector);
        System.out.println(param2JSON("order_id","1234123","country_code","BR"));
    }

    public static String param2JSON(String... str){
        if(str.length % 2 != 0){
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        int i = 0;
        while (i < str.length){
            jsonObject.put(str[i],str[i+1]);
            i = i+2;
        }
        return jsonObject.toJSONString();
    }
}


