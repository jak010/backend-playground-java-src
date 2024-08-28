package jsonExample;

import org.json.JSONException;
import org.json.JSONObject;

public class Example01 {

    public static void main(String[] args) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key","value");


        System.out.println(jsonObject.toString());
    }

}
