package org.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class GreetingResourceTest {

    // Test for the hello endpoint
    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    // Tests for Information Technology Leaders
    @Test
    public void testQuoteAlbertEinstein() {
        given()
          .when().get("/quote/albert-einstein")
          .then()
             .statusCode(200)
             .body(is("Imagination is more important than knowledge. - Albert Einstein"));
    }

    @Test
    public void testQuoteSteveJobs() {
        given()
          .when().get("/quote/steve-jobs")
          .then()
             .statusCode(200)
             .body(is("Innovation distinguishes between a leader and a follower. - Steve Jobs"));
    }

    @Test
    public void testQuoteBillGates() {
        given()
          .when().get("/quote/bill-gates")
          .then()
             .statusCode(200)
             .body(is("Information technology and business are becoming inextricably interwoven. I don't think anybody can talk meaningfully about one without talking about the other. - Bill Gates"));
    }

    // Tests for Famous Scientists
    @Test
    public void testQuoteIsaacNewton() {
        given()
          .when().get("/quote/isaac-newton")
          .then()
             .statusCode(200)
             .body(is("If I have seen further, it is by standing on the shoulders of giants. - Isaac Newton"));
    }

    @Test
    public void testQuoteMarieCurie() {
        given()
          .when().get("/quote/marie-curie")
          .then()
             .statusCode(200)
             .body(is("Nothing in life is to be feared, it is only to be understood. - Marie Curie"));
    }

    @Test
    public void testQuoteNikolaTesla() {
        given()
          .when().get("/quote/nikola-tesla")
          .then()
             .statusCode(200)
             .body(is("The present is theirs; the future, for which I have really worked, is mine. - Nikola Tesla"));
    }

    @Test
    public void testQuoteCharlesDarwin() {
        given()
          .when().get("/quote/charles-darwin")
          .then()
             .statusCode(200)
             .body(is("It is not the strongest of the species that survive, nor the most intelligent, but the one most responsive to change. - Charles Darwin"));
    }

    @Test
    public void testQuoteGalileoGalilei() {
        given()
          .when().get("/quote/galileo-galilei")
          .then()
             .statusCode(200)
             .body(is("You cannot teach a man anything; you can only help him find it within himself. - Galileo Galilei"));
    }

    @Test
    public void testQuoteStephenHawking() {
        given()
          .when().get("/quote/stephen-hawking")
          .then()
             .statusCode(200)
             .body(is("Intelligence is the ability to adapt to change. - Stephen Hawking"));
    }

    @Test
    public void testQuoteRichardFeynman() {
        given()
          .when().get("/quote/richard-feynman")
          .then()
             .statusCode(200)
             .body(is("I would rather have questions that can't be answered than answers that can't be questioned. - Richard Feynman"));
    }
}
