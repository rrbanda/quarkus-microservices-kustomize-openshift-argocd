package org.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/quote/albert-einstein")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteAlbertEinstein() {
        return "Imagination is more important than knowledge. - Albert Einstein";
    }

    @GET
    @Path("/quote/steve-jobs")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteSteveJobs() {
        return "Innovation distinguishes between a leader and a follower. - Steve Jobs";
    }

    @GET
    @Path("/quote/information-technology")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteInformationTechnology() {
        return "Information technology and business are becoming inextricably interwoven. I don't think anybody can talk meaningfully about one without talking about the other. - Bill Gates";
    }
}
    @GET
    @Path("/quote/information-technology")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteInformationTechnology() {
        return "Information technology and business are becoming inextricably interwoven. I don't think anybody can talk meaningfully about one without talking about the other. - Bill Gates";
    }
