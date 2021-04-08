package com.example.cmsproject.controller;

import com.example.cmsproject.service.jsontoxml;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("template")
public class templateController {
    jsontoxml jsonToXML = new jsontoxml();

    @POST
    @Path("xml")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transferContent(String json) throws Exception {
        Boolean var = jsonToXML.convert(json,"root");
        if(var == false){
            return Response.noContent().build();
        }
        else {
            return Response.ok().entity("converted").build();
        }
    }

}
