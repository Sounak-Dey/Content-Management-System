package com.example.cmsproject.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.Iterator;

@Path("admin")
public class adminController {

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferTemplate(String json) throws Exception {

            JSONParser jsonParser = new JSONParser();
            JSONObject clientjson = (JSONObject) jsonParser.parse(json);
            FileReader reader = new FileReader("/home/sounak/Desktop/DM/MajorProject/cmsproject/src/main/admin.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray admin = (JSONArray) obj;

        Iterator<JSONObject> iterator = admin.iterator();
        while (iterator.hasNext()) {
            JSONObject slide = iterator.next();
            String username = (String) slide.get("username");
            String password = (String) slide.get("password");
            String type = (String) slide.get("type");
            String clientusername = (String) clientjson.get("username");
            String clientpassword = (String) clientjson.get("password");
            if((clientusername.equals(username)) && (clientpassword.equals(password)) && (type.equals("template"))){
                return Response.ok().entity(1).build();
            }
            else if((clientusername.equals(username)) && (clientpassword.equals(password)) && (type.equals("content"))){
                return Response.ok().entity(2).build();
            }
        }
            return Response.status(203).build();

    }

}
