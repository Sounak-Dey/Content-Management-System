package com.example.cmsproject.controller;

import com.example.cmsproject.service.xmltojson;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class userController {

    xmltojson xmltojson = new xmltojson();

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
