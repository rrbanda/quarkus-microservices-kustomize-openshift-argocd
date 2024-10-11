package org.demo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/quote/matt-mullenweg")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteMattMullenweg() {
        return "Technology is best when it brings people together. - Matt Mullenweg";
    }

    @GET
    @Path("/quote/bf-skinner")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteBFSkinner() {
        return "The real problem is not whether machines think, but whether men do. - B.F. Skinner";
    }

    @GET
    @Path("/quote/steve-jobs")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteSteveJobs() {
        return "It’s not a faith in technology. It’s faith in people. - Steve Jobs";
    }

    @GET
    @Path("/quote/steve-jobs-innovation")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteSteveJobsInnovation() {
        return "Innovation distinguishes between a leader and a follower. - Steve Jobs";
    }

    @GET
    @Path("/quote/bill-gates")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteBillGates() {
        return "Information technology and business are becoming inextricably interwoven. I don't think anybody can talk meaningfully about one without talking about the other. - Bill Gates";
    }

    @GET
    @Path("/quote/alvin-toffler")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteAlvinToffler() {
        return "The great growling engine of change - technology. - Alvin Toffler";
    }

    @GET
    @Path("/quote/sean-gerety")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteSeanGerety() {
        return "The technology you use impresses no one. The experience you create with it is everything. - Sean Gerety";
    }

    @GET
    @Path("/quote/albert-einstein")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteAlbertEinstein() {
        return "It has become appallingly obvious that our technology has exceeded our humanity. - Albert Einstein";
    }

    @GET
    @Path("/quote/amit-ray")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteAmitRay() {
        return "As more and more artificial intelligence is entering into the world, more and more emotional intelligence must enter into leadership. - Amit Ray";
    }

    @GET
    @Path("/quote/peter-sondergaard")
    @Produces(MediaType.TEXT_PLAIN)
    public String quotePeterSondergaard() {
        return "Information is the oil of the 21st century, and analytics is the combustion engine. - Peter Sondergaard";
    }
}
