package coding.work;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.text.NumberFormat;

public class TensorModel {

    static Map<String, Graph> graphMap = new ConcurrentHashMap<String, Graph>();

    public static JSONObject wordvectorModel(String url_path, List<String> wordList) {
        JSONObject res_hash = new JSONObject();
        try {
            int len = wordList.size();
            int llen = wordList.get(0).split(",").length;

            double[][] input_wordvector = new double[len][llen];

            for (int i = 0; i < len; i++) {
                String[] words = wordList.get(i).split(",");

                for (int j = 0; j < words.length; j++) {
                    input_wordvector[i][j] = Double.parseDouble(words[j]);
                }
            }

            Graph graph = null;

            if (graphMap.containsKey(url_path)) {
                graph = graphMap.get(url_path);
            } else {
                graph = new Graph();
                URL url = new URL(url_path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(500);
                conn.setReadTimeout(500);

                InputStream is = conn.getInputStream();
                byte[] graphBytes = IOUtils.toByteArray(is);
                graph.importGraphDef(graphBytes);
                graphMap.put(url_path, graph);
            }

            Session session = new Session(graph);
            Tensor t = Tensor.create(input_wordvector);
//            System.out.println(t);

            List out = session.runner().feed("Input_x", t).fetch("Output").run();


            ArrayList<Double> res_array = new ArrayList<Double>();
            for (Object s : out) {
                double[][] rs = new double[1][2];
                Tensor aa = (Tensor) s;
                aa.copyTo(rs);
                for (double i : rs[0]) {
                    res_array.add(i);
                }
            }
            double pos_probability = res_array.get(0);
            double neg_probability = res_array.get(1);
            int result = pos_probability>neg_probability?1:0 ;
            res_hash.put("pos_probability", pos_probability);
            res_hash.put("neg_probability", neg_probability);
            res_hash.put("result", result);

        } catch (Exception e) {
            System.out.println(e);
        }
        return res_hash;
    }

    public static void main(String[] args) {
        String input = "3.13247013092041,-1.5908812284469604,-0.12490372359752655,0.013907265849411488,-0.8531115651130676,1.1557852029800415,0.3367002606391907,-2.0325703620910645,-3.15537166595459,-1.0124952793121338,1.5522464513778687,0.8537430763244629,-3.516331911087036,-2.663844108581543,0.10714729875326157,-2.6812570095062256,-0.6787408590316772,0.2749360203742981,0.07945175468921661,-0.3308737277984619,-2.3868961334228516,-0.029200561344623566,0.38160544633865356,1.059981107711792,-2.1310112476348877,-2.7855608463287354,-0.5445519089698792,1.0292686223983765,-2.9549715518951416,-2.1024677753448486,-0.20300112664699554,2.3504908084869385,-0.34959015250205994,1.8924407958984375,0.024880126118659973,-0.725612223148346,2.445718288421631,0.19800934195518494,-1.1862404346466064,-0.5523959994316101,-1.51823890209198,-1.2246711254119873,0.44390323758125305,-2.276742458343506,1.8339189291000366,-0.2186666876077652,1.5030356645584106,-0.44548308849334717,-2.5051960945129395,-0.5365214943885803,-0.9437887668609619,0.8427940011024475,-0.8617923855781555,-1.6833851337432861,-0.7518491744995117,0.21214823424816132,-0.39979246258735657,0.21662770211696625,-0.024116599932312965,3.4570326805114746,0.685316801071167,-0.3069726526737213,-0.6311206817626953,-0.8972480893135071,-1.3236829042434692,1.9132388830184937,0.7881048917770386,-0.8883413076400757,0.05481356009840965,-0.8005428910255432,2.346536874771118,1.6611685752868652,1.5939340591430664,-2.0053563117980957,-2.466796636581421,-1.4018325805664062,0.47813016176223755,1.4400891065597534,2.491680860519409,-0.4136401116847992,-1.4041842222213745,-1.0673017501831055,1.9484292268753052,-3.5138816833496094,2.3879313468933105,1.877400279045105,-0.7999415993690491,0.5167697072029114,-1.0171043872833252,-1.1106818914413452,0.17527617514133453,2.0925800800323486,-0.8969983458518982,-0.7499828338623047,-2.5815725326538086,-3.466946601867676,-1.5615384578704834,0.29011860489845276,1.807275652885437,-0.8964935541152954,0.419838547706604,-1.342138648033142,0.7598831057548523,-1.8846267461776733,0.4306408166885376,1.6587878465652466,-0.25184667110443115,-0.24116113781929016,-1.177595853805542,0.5771554112434387,0.5051463842391968,-1.082595705986023,-0.7552427053451538,-1.1284816265106201,0.40303343534469604,0.300473153591156,1.9742451906204224,-1.1781586408615112,-1.2519181966781616,-1.6111793518066406,-2.730389356613159,0.17794488370418549,-2.987330913543701,0.34200459718704224,0.6462860703468323,-0.9015678763389587,0.34251391887664795,0.517187774181366,1.3858379125595093,1.5004069805145264,-2.699108839035034,-0.7997871041297913,0.45449647307395935,-1.2706714868545532,-0.850737988948822,-0.571999728679657,0.8567925691604614,-0.19487331807613373,2.1982133388519287,1.1554598808288574,1.2348483800888062,0.6268060803413391,-0.5728158950805664,-0.9412743449211121,-0.280850350856781,-0.476389616727829,-3.1235949993133545,1.2643383741378784,-1.5540947914123535,-0.5415611863136292,0.061949338763952255,2.36501407623291,0.037983037531375885,-2.670095682144165,-1.6871200799942017,-0.518665075302124,-0.5428470969200134,0.5131558775901794,0.2805924713611603,-2.0789308547973633,-0.4416721761226654,0.1893305629491806,-2.9412591457366943,-0.9764801263809204,1.1720869541168213,0.3454148471355438,1.1480796337127686,1.4406570196151733,1.6493523120880127,-0.9378277659416199,-0.9343110918998718,0.39522966742515564,-0.4125443994998932,1.5466467142105103,-1.088891625404358,-0.006804720964282751,-2.398935556411743,-0.6647515892982483,-2.215076446533203,-1.3687485456466675,0.6000447273254395,-0.8646523356437683,-0.666094183921814,0.15281003713607788,-2.2778265476226807,0.7108011245727539,-0.6577410101890564,-0.44426366686820984,-1.5958502292633057,1.0980160236358643,1.4218671321868896,-1.7655820846557617,0.025703398510813713,-2.261557102203369,0.19865505397319794,2.0218639373779297,0.37025851011276245,0.13543543219566345,-1.328405737876892,0.44691210985183716,-0.9904876351356506,-0.671699583530426,-1.3880729675292969,0.4539310038089752,0.4766881763935089,1.4894146919250488,-1.2685121297836304,1.242184042930603,-0.605094850063324,2.4696531295776367,-1.3049567937850952,-2.6092097759246826,1.7396881580352783,2.8048319816589355,-4.701345443725586,-1.5505034923553467,-0.8969013094902039,-0.9411452412605286,0.9004514813423157,-1.1820002794265747,2.0842037200927734,-2.9957034587860107,-0.5937539935112,-1.2846747636795044,-0.797910749912262,-1.0335636138916016,-2.4346141815185547,-0.5499200820922852,1.7880305051803589,0.9206995368003845,-1.0034403800964355,-2.1438913345336914,-2.165848970413208,-0.5959117412567139,-1.263391375541687,-0.6793686747550964,-1.6644243001937866,1.0434587001800537,-0.23169942200183868,0.9678241014480591,3.0012946128845215,-3.1345443725585938,3.781142473220825,-0.035296231508255005,-0.36011114716529846,-1.1130930185317993,2.122687578201294,-1.0479222536087036,-1.8748061656951904,-0.9953238368034363,-1.7210785150527954,-0.30453482270240784,0.9324268102645874,-3.4977102279663086,0.29666075110435486,1.3969074487686157,-0.16727390885353088,0.8541991710662842,0.9824774265289307,1.985466718673706,2.298715591430664,-0.8921111822128296,2.0130505561828613,-1.386212706565857,2.0206127166748047,-0.44434502720832825,1.8957117795944214,-0.5494987368583679,0.9163931012153625,0.867890477180481,1.9399518966674805,-1.9940131902694702,-2.188001871109009,-1.093684196472168,0.10321091115474701,0.6095978617668152,1.9852708578109741,0.07174110412597656,-1.1924477815628052,-0.6334881782531738,1.3530802726745605,-2.6921780109405518,-1.3993200063705444,1.0167028903961182,1.102672815322876,0.7619620561599731,1.7890067100524902,1.4231469631195068,-0.9236393570899963,-2.9821889400482178,3.363058090209961,1.6240352392196655,1.9808502197265625,-0.049973033368587494,1.7218571901321411,1.519463300704956,-0.9172130823135376,0.7609443664550781,-1.0762120485305786,-0.34675630927085876,5.781166076660156,0.6839357614517212,-1.002923607826233,1.4961286783218384,-1.821382999420166,-2.4997053146362305,-0.2534194588661194,0.5441324710845947,1.1483122110366821,1.1223154067993164,0.3727795481681824,2.5852150917053223,2.987614154815674,-1.4001588821411133,1.7924052476882935,-0.9266757369041443,0.5674502849578857,1.1089402437210083,-0.1570885330438614,-0.6268397569656372,-1.5140318870544434,-0.07887483388185501,0.18806092441082,-0.457615464925766,0.03658352419734001,-1.5543910264968872,2.6811914443969727,1.2109817266464233,-0.9344202280044556,-2.3103325366973877,-4.070062637329102,-2.3293676376342773,0.08123649656772614,1.7394447326660156,0.2656216323375702,-0.2186345010995865,-1.891871452331543,-0.9161769151687622,1.295631766319275,-0.5959012508392334,0.462459921836853,-0.8154094815254211,0.8424063324928284,0.7154410481452942,-2.7388110160827637,-0.8695785403251648,1.42802095413208,-0.8123922944068909,0.8068206310272217,1.1948211193084717,0.715086042881012,0.022104399278759956,1.3622007369995117,-3.832716703414917,0.5296421647071838,-1.0884156227111816,-5.768418312072754,1.1736122369766235,-1.5311336517333984,-1.038122534751892,-0.035687997937202454,2.58068585395813,-1.8600788116455078,-2.9053213596343994,2.6246888637542725,2.054083824157715,0.26792001724243164,-0.26720619201660156,0.5103284120559692,-3.6087849140167236,0.27813729643821716,0.4311465322971344,-0.18734659254550934,-0.293043851852417,-1.573488712310791,0.3123392164707184,-0.4406767785549164,-2.3328068256378174,1.8543018102645874,-1.7371371984481812,-3.087238311767578,2.006925344467163,-1.7682006359100342,-0.9740258455276489,-3.222426176071167,-1.8155453205108643,1.9108948707580566,-1.254374623298645,-2.0566952228546143,-1.853516936302185,2.963291883468628,-2.687410354614258,2.95796537399292,2.347745895385742,-2.0295088291168213,-1.4655399322509766,-0.6075553297996521,1.5807868242263794,-1.9240158796310425,4.4848480224609375,2.696962833404541,-1.4445165395736694,0.9952082633972168,-4.540734767913818,0.018927309662103653,-1.1366029977798462,-2.557825803756714,2.510873556137085,0.5256253480911255,-1.3055109977722168,2.5357418060302734,-0.43751993775367737,3.096552848815918,-1.310364842414856,-0.33529791235923767,-2.0050532817840576,-0.003302082885056734,0.2434941530227661,-0.0033100699074566364,-1.4709203243255615,-1.407755732536316,-0.43480372428894043,3.9632015228271484,1.0938252210617065,0.5693458914756775,-0.16290967166423798,3.882554292678833,0.9897926449775696,1.8639971017837524,-0.8976143002510071,-0.8083350658416748,2.3418381214141846,1.9471670389175415,-0.24310553073883057,-1.7600830793380737,0.7694176435470581,0.5405320525169373,-3.3214032649993896,0.6159362196922302,-0.8508361577987671,1.7370247840881348,-0.6498470306396484,2.1625592708587646,-1.236107587814331,-0.13839450478553772,1.0780977010726929,-1.111692190170288,2.6078951358795166,1.3088929653167725,-0.8480220437049866,1.032538890838623,-2.8492977619171143,-2.0333995819091797,-0.45698362588882446,0.1435905247926712,-0.08281310647726059,1.7844254970550537,-0.5991696119308472,-0.42163318395614624,-0.955626904964447,-0.5094498991966248,-0.8761722445487976,-0.10407305508852005,-0.7342426776885986,-0.08724205940961838,-0.4096375107765198,0.6017403602600098,-1.0822738409042358,-0.3142523467540741,1.4551455974578857,-0.03985494747757912,0.19540290534496307,1.3761143684387207,-0.23533985018730164,0.6799719929695129,1.5217547416687012,1.153334379196167,0.17386730015277863,-0.9902554750442505,-0.20559899508953094,2.4011125564575195,-2.7299699783325195,-0.2664967179298401,-1.2935503721237183,-0.4930313527584076,0.8322598934173584,-0.7603667378425598,-0.5295816659927368,-0.9854297041893005,0.030326949432492256,0.13688622415065765,1.2427176237106323,-2.3629472255706787,0.051033731549978256,0.23667651414871216,0.7494234442710876,-0.53218674659729,-1.1574656963348389,1.4996819496154785,-1.290269374847412,1.0712581872940063,-1.6220533847808838,0.38776513934135437,-0.7218326330184937,2.4833922386169434,1.6301060914993286,-1.8598766326904297,1.5241087675094604,-0.1872023195028305,-1.1071455478668213,2.8650686740875244,-0.8867030143737793,3.051023483276367,1.0727049112319946,-2.6407949924468994,0.9600037932395935,0.7253502011299133,0.5820503234863281,1.8832716941833496,1.1623344421386719,-0.43590378761291504,0.6142581701278687,0.207814022898674,0.7794237732887268,0.891606867313385,-0.7406143546104431,0.7603452205657959,-0.39936670660972595,-0.9422426819801331,-1.656436800956726,-0.4876510500907898,-1.7062079906463623,-0.4294324219226837,-1.588944911956787,-0.5375643372535706,-1.00972580909729,-0.49068477749824524,-0.45027732849121094,-1.5831412076950073,-1.01716148853302,-1.5951645374298096,0.14989790320396423,-0.8320865631103516,1.3090153932571411,1.1969705820083618,-0.8931757807731628,-1.0934754610061646,-0.3102669417858124,1.5717978477478027,0.2607273459434509,0.6505318284034729,1.0652192831039429,-0.2657950520515442,-4.584495544433594,-0.43035489320755005,0.32122674584388733,1.175686240196228,0.9266742467880249,2.702113151550293,0.24129849672317505,0.501230776309967,0.13221022486686707,2.021578073501587,-4.549723148345947,-0.7725564241409302,-2.339775562286377,-0.8725664615631104,3.246680498123169,-1.3846262693405151,0.06873641163110733,0.5661776661872864,0.07188113033771515,0.616933286190033,-0.649379551410675,-1.8070638179779053,0.4185239374637604,0.9672176241874695,-0.5247666835784912,1.260461449623108,0.09536010771989822,-1.066229224205017,-1.5349284410476685,-0.36061418056488037,0.6056848764419556,0.12063514441251755,1.028775930404663,-1.3372491598129272,1.5048267841339111,0.27414682507514954,0.06685581803321838,-1.8759360313415527,1.6576933860778809,-0.5847814679145813,1.3379319906234741,-1.2889162302017212,1.99697744846344,-2.572927474975586,0.4820256233215332,-1.1008813381195068,1.7819141149520874,1.5962188243865967,-0.6158737540245056,0.6722883582115173,-0.3920152485370636,-1.4309144020080566,-0.06118607148528099,1.8587989807128906,1.1284551620483398,-1.0408111810684204,0.6977726221084595,-0.15155933797359467,-0.7910958528518677,0.17656691372394562,-0.7856159210205078,-0.2365683615207672,1.428708791732788,3.7499308586120605,2.1374642848968506,-0.8863359689712524,1.5852807760238647,-2.041503667831421,-1.3816853761672974,3.429151773452759,1.6813151836395264,-2.30908203125,0.01722649857401848,2.3874027729034424,0.3370389938354492,-0.4652649462223053,-1.3443702459335327,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0";
        List<String> str = new ArrayList<>();
        str.add(input);
        System.out.println(JSONObject.toJSONString(TensorModel.wordvectorModel("http://img0.didiglobal.com/static/psi_models/do1_MgUvDcjeuGaRddiWlyn3",str)));
    }
}