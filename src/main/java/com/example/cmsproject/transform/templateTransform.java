package com.example.cmsproject.transform;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.Source;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.stream.StreamResult;

import javax.xml.transform.stream.StreamSource;

public class templateTransform {

    public void trans(String xslfile,String xmlfile) throws Exception {


        String resultpath = "/home/sounak/Desktop/DM/MajorProject/cmsproject/src/main/webapp/";
        String result = xmlfile.substring(0,xmlfile.length()-4);
        result = result+".html";
        File file = new File("/home/sounak/Desktop/DM/MajorProject/cmsproject/src/main/Content.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(result);
        fileWriter.close();
        result = resultpath+result;
        String path = "/home/sounak/Desktop/DM/MajorProject/cmsproject/src/main/resources/";
        xslfile = path+xslfile;
        xmlfile = path+xmlfile;
        String sendingString;

        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(xslfile);

            Source xmlDoc = new StreamSource(xmlfile);


            String outputFileName = result;


            OutputStream htmlFile = new FileOutputStream(outputFileName);

            sendingString = new String(htmlFile.toString());

            Transformer transform = tFactory.newTransformer(xslDoc);

            transform.transform(xmlDoc, new StreamResult(htmlFile));

        } catch (Exception e)

        {

            e.printStackTrace();

        }

    }

}
