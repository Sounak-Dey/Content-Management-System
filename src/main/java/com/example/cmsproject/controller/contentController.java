package com.example.cmsproject.controller;

import com.example.cmsproject.service.getXmlFiles;
import com.example.cmsproject.service.jsontoxml;
import com.example.cmsproject.service.xmltojson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("content")
public class contentController {
    jsontoxml jsonToXML = new jsontoxml();
    getXmlFiles getXmlFiles = new getXmlFiles();
    xmltojson xmltojson = new xmltojson();

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
        String jsonString = getXmlFiles.getfiles();
        if(jsonString.length() == 0){
            return Response.noContent().build();
        }
        else {
            return Response.ok().entity(jsonString).build();
        }
    }

    @POST
    @Path("html")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferhtml(String filename) throws Exception {
            String jsonString = xmltojson.convert(filename);
        if(jsonString.length() == 0){
            return Response.noContent().build();
        }
        else {
            return Response.ok().entity(jsonString).build();
        }
    }

}