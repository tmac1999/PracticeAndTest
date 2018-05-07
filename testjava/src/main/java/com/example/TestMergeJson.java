package com.example;

import com.example.json.JSONException;
import com.example.json.JSONObject;

import java.util.Iterator;

/**
 * Created by mrz on 18/5/7.
 */

public class TestMergeJson {
    public static void main(String[] args) {
        /**
         params.put("jifen", data.optString("jifen"));
         params.put("jinbi", data.optString("jinbi"));
         params.put("lessonname", data.optString("lessonname"));
         params.put("num", data.optString("num"));
         params.put("questionTypeSubject", data.optString("questionTypeSubject"));
         params.put("openProps", data.optString("openProps"));
         params.put("groupName", data.optString("groupName"));
         params.put("groupType", data.optString("groupType"));
         params.put("starsCount", data.optString("starsCount"));
         params.put("needCorrectCount", data.optString("needCorrectCount"));
         */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("jifen",123);
        jsonObject.put("openProps",false);
        jsonObject.put("groupName","hugeProps");
        JSONObject toBeMerged = new JSONObject();
        toBeMerged.put("aaa",123);
        toBeMerged.put("bbb",false);
        toBeMerged.put("ccc","xxx");
        JSONObject result = jsonMerge(toBeMerged, jsonObject);
        Print.pln(result);

    }
    public static JSONObject jsonMerge(JSONObject o1, JSONObject o2) throws JSONException {

        Iterator i1 = o1.keys();
        Iterator i2 = o2.keys();
        JSONObject mergedObj = new JSONObject();
        String tmp_key;
        while(i1.hasNext()) {
            tmp_key = (String) i1.next();
            mergedObj.put(tmp_key, o1.get(tmp_key));
        }
        while(i2.hasNext()) {
            tmp_key = (String) i2.next();
            mergedObj.put(tmp_key, o2.get(tmp_key));
        }
        return mergedObj;
    }
}
