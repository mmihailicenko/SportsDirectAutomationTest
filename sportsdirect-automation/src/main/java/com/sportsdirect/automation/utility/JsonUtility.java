package com.sportsdirect.automation.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtility {

    private static final String JSON_PATH = "src\\main\\java\\com\\sportsdirect\\automation\\page_objects\\";
    private static JSONObject jo;

    public static String JsonFileParsing(String key, String value) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(JSON_PATH + "page_objects.json"));
            JSONObject jsonObj = (JSONObject) obj;
            jo = (JSONObject) jsonObj.get(key);
            return jo.get(value).toString();
        } catch (Exception e) {
            System.out.println("Parsing was not successful: " + e.getMessage());
        }
        return jo.get(value).toString();
    }
}
