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

    // Information Technology Leaders
    @GET
    @Path("/quote/albert-einstein")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteAlbertEinstein() {
        return "Imagination is more important than knowledge. - Albert Einstein";
    }

    // Famous Scientists
    @GET
    @Path("/quote/isaac-newton")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteIsaacNewton() {
        return "If I have seen further, it is by standing on the shoulders of giants. - Isaac Newton";
    }

    @GET
    @Path("/quote/marie-curie")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteMarieCurie() {
        return "Nothing in life is to be feared, it is only to be understood. - Marie Curie";
    }

    @GET
    @Path("/quote/nikola-tesla")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteNikolaTesla() {
        return "The present is theirs; the future, for which I have really worked, is mine. - Nikola Tesla";
    }

    @GET
    @Path("/quote/charles-darwin")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteCharlesDarwin() {
        return "It is not the strongest of the species that survive, nor the most intelligent, but the one most responsive to change. - Charles Darwin";
    }

    @GET
    @Path("/quote/galileo-galilei")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteGalileoGalilei() {
        return "You cannot teach a man anything; you can only help him find it within himself. - Galileo Galilei";
    }

    @GET
    @Path("/quote/stephen-hawking")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteStephenHawking() {
        return "Intelligence is the ability to adapt to change. - Stephen Hawking";
    }

    @GET
    @Path("/quote/richard-feynman")
    @Produces(MediaType.TEXT_PLAIN)
    public String quoteRichardFeynman() {
        return "I would rather have questions that can't be answered than answers that can't be questioned. - Richard Feynman";
    }
}
