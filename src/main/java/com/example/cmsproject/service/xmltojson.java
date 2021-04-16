package com.example.cmsproject.service;

import org.json.*;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class xmltojson {
    public static String xml= "<?xml version=\"1.0\" ?><root><test       attribute=\"text1\">javatpoint</test><test attribute=\"text2\">JTP</test></root>";

    public String convert(String filename) throws IOException {
        String jsonString = "";
        String path = "/home/manu/cms/cmsproject/src/main/resources/";
        filename = path+filename;
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        String line;
        StringBuilder sb = new StringBuilder();

        while((line=br.readLine())!= null){
            sb.append(line.trim());
        }
        String sendingString = sb.toString();
// TODO Auto-generated method stub
        try {
            JSONObject json = XML.toJSONObject(sendingString);
            jsonString = json.toString(4);
        }catch (JSONException e) {
// TODO: handle exception
            System.out.println(e.toString());
        }

        return jsonString;

    }


}
