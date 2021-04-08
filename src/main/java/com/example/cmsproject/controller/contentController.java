package com.example.cmsproject.controller;

import com.example.cmsproject.service.getHtmlFiles;
import com.example.cmsproject.service.jsontoxml;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("content")
public class contentController {
    jsontoxml jsonToXML = new jsontoxml();
    getHtmlFiles getHtmlFiles = new getHtmlFiles();

    @POST
    @Path("xml")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferTemplate(String json) throws Exception {
        Boolean var = jsonToXML.convert(json,"root");
        if(var == false){
            return Response.noContent().build();
        }
        else {
            return Response.ok().entity("converted").build();
        }
    }

    @GET
    @Path("filelist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferfile() throws Exception {
        String jsonString = getHtmlFiles.getfiles();
        if(jsonString.length() == 0){
            return Response.noContent().build();
        }
        else {
            return Response.ok().entity(jsonString).build();
        }
    }

}