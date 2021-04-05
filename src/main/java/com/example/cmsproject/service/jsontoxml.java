package com.example.cmsproject.service;

import com.example.cmsproject.transform.templateTransform;
import org.json.*;

import java.io.File;
import java.io.FileWriter;

public class jsontoxml {

    public static Boolean convert(String json, String root) throws Exception {
        //JSONObject jsonObject = new JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<" + root + ">" ;
        JSONArray jsonarray = new JSONArray(json);
        String xmlfile = jsonarray.getJSONObject(0).getString("title");
        xmlfile += ".xml";
        for (int i = 1; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            xml += org.json.XML.toString(jsonobject);
        }
        xml += "</" + root + ">";
        String filepath = "/home/manu/cms/cmsproject/src/main/resources/";
        filepath += xmlfile;
        File file = new File(filepath);
        FileWriter  fileWriter = new FileWriter(file);
        fileWriter.write(xml);
        fileWriter.close();
        System.out.println(xml);
       // templateTransform transform = new templateTransform();
       // transform.tranform("templateTransform.xsl","/Admission.xml");
        templateTransform templateTransform = new templateTransform();
        templateTransform.trans("templateTransform.xsl",xmlfile);
        if(xml.length()!=0){
            return true;
        }
        else{
            return false;
        }
    }
}
