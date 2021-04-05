package com.example.cmsproject.transform;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;

import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.stream.StreamResult;

import javax.xml.transform.stream.StreamSource;

public class templateTransform {

    public void trans(String xslfile,String xmlfile) throws Exception {


        String resultpath = "/home/manu/cms/cmsproject/src/main/webapp/";
        String result = xmlfile.substring(0,xmlfile.length()-4);
        result = result+".html";
        result = resultpath+result;
        String path = "/home/manu/cms/cmsproject/src/main/resources/";
        xslfile = path+xslfile;
        xmlfile = path+xmlfile;

        try {

            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(xslfile);

            Source xmlDoc = new StreamSource(xmlfile);


            String outputFileName = result;

            OutputStream htmlFile = new FileOutputStream(outputFileName);

            Transformer transform = tFactory.newTransformer(xslDoc);

            transform.transform(xmlDoc, new StreamResult(htmlFile));

        } catch (Exception e)

        {

            e.printStackTrace();

        }

    }

}
