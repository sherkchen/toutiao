package shu.chl.toutiao.Util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Map;

public class ToutiaoUtil {
    private static final Logger logger = LoggerFactory.getLogger(ToutiaoUtil.class);
    public static  String imagePath="J:\\201906\\02day\\toutiao\\src\\main\\resources\\static\\images";
    public static String TOUTIAO_DOMAIN = "http://127.0.0.1:8080/home";
    public static String[] IMAGE_FILE_EXTD = new String[] {"png", "bmp", "jpg", "jpeg"};
    public static String getJSONString(int code){
        JSONObject json=new JSONObject();
        json.put("code",code);
        return json.toJSONString();
    }
    public static boolean isImage(String imagName){

          int boundIndex=imagName.lastIndexOf('.');
          if(boundIndex<0) return false;
          String type=imagName.substring(boundIndex+1).toLowerCase();
          for(int i=0;i<IMAGE_FILE_EXTD.length;i++){
              if(type.equals(IMAGE_FILE_EXTD[i]))
                  return  true;
          }
          return false;
    }

    //code记录状态码,用来返回给客户端的信息。
    public static String getJSONString(int code,String msg){
        JSONObject json=new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        return json.toJSONString();
    }
    public static String getJSONString(int code,Map<String,Object> map){
        JSONObject json=new JSONObject();
        json.put("code",code);
        for(Map.Entry<String,Object> entry:map.entrySet()){
              json.put(entry.getKey(),entry.getValue());
        }
        return json.toJSONString();
    }


    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("生成MD5失败", e);
            return null;
        }
    }
}
