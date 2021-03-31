package com.example.cmsproject.transform;

import net.sf.saxon.s9api.*;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

public class templateTransform {
    public static void main(String[] args) {
        Processor proc = new Processor(false);
        XsltCompiler comp = proc.newXsltCompiler();

        ClassLoader classLoader = XsltCompiler.class.getClassLoader();
        // load xsl file from java project

        InputStream xsl = classLoader.getResourceAsStream("templateTransform.xsl");
        // load xml file from java project
        InputStream xmlInput = classLoader.getResourceAsStream("Admission.xml");
        try {
            XsltExecutable exp = comp.compile(new StreamSource(xsl));

            XdmNode source = proc.newDocumentBuilder().build(new StreamSource(xmlInput));

            String outputDir = System.getProperty("user.home");
            // create a result.html file as result in the user home directory
            Serializer out = proc.newSerializer(new File(outputDir, "result.html"));
            out.setOutputProperty(Serializer.Property.METHOD, "html");
            out.setOutputProperty(Serializer.Property.INDENT, "yes");
            XsltTransformer trans = exp.load();
            trans.setInitialContextNode(source);
            trans.setDestination(out);
            trans.transform();
        } catch (SaxonApiException e) {
            e.printStackTrace();
        }
    }
}
