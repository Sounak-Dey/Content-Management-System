package com.example.cmsproject.service;

import org.json.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class jsontoxml {

    public static Boolean convert(String json, String root) throws JSONException, IOException {
        //JSONObject jsonObject = new JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\" ISO-8859-15\"?>\n<" + root + ">" ;
        JSONArray jsonarray = new JSONArray(json);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            xml += org.json.XML.toString(jsonobject);
        }
        xml += "</" + root + ">";
        File file = new File("/home/manu/Admission.xml");
        FileWriter  fileWriter = new FileWriter(file);
        fileWriter.write(xml);
        fileWriter.close();
        System.out.println(xml);
        if(xml.length()!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
