package com.example.cmsproject.service;

import org.json.simple.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class getHtmlFiles {
    public String getfiles(){
        List<String> filelist = new ArrayList<String>();
        File[] files = new File("/home/manu/cms/cmsproject/src/main/webapp/").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".html");
            }
        });
        for (File file : files) {
            if (file.isFile()) {
                filelist.add(file.getName());
            }
        }

        String jsonStr = JSONArray.toJSONString(filelist);
        return jsonStr;
    }

    public static void main(String[] args) {
        getHtmlFiles getHtmlFiles = new getHtmlFiles();
        getHtmlFiles.getfiles();
    }
}
