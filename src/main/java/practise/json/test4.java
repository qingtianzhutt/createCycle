package practise.json;

import com.alibaba.fastjson.JSON;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class test4 {
    public static void main(String[] args) throws JSONException {
        HashMap<String, String> param = new HashMap<String, String>(){{
            put("deviceId", "123123142");
            put("value", "cardId");
        }};
        pig p = new pig();
        p.setHead("1232");
        p.getMouth().setMouthSize("11");

    }
}
