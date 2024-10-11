package org.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

    @Test
    public void testQuoteMattMullenweg() {
        given()
          .when().get("/quote/matt-mullenweg")
          .then()
             .statusCode(200)
             .body(is("Technology is best when it brings people together. - Matt Mullenweg"));
    }

    @Test
    public void testQuoteBFSkinner() {
        given()
          .when().get("/quote/bf-skinner")
          .then()
             .statusCode(200)
             .body(is("The real problem is not whether machines think, but whether men do. - B.F. Skinner"));
    }

    @Test
    public void testQuoteSteveJobs() {
        given()
          .when().get("/quote/steve-jobs")
          .then()
             .statusCode(200)
             .body(is("It’s not a faith in technology. It’s faith in people. - Steve Jobs"));
    }

    @Test
    public void testQuoteSteveJobsInnovation() {
        given()
          .when().get("/quote/steve-jobs-innovation")
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

    @Test
    public void testQuoteAlvinToffler() {
        given()
          .when().get("/quote/alvin-toffler")
          .then()
             .statusCode(200)
             .body(is("The great growling engine of change - technology. - Alvin Toffler"));
    }

    @Test
    public void testQuoteSeanGerety() {
        given()
          .when().get("/quote/sean-gerety")
          .then()
             .statusCode(200)
             .body(is("The technology you use impresses no one. The experience you create with it is everything. - Sean Gerety"));
    }

    @Test
    public void testQuoteAlbertEinstein() {
        given()
          .when().get("/quote/albert-einstein")
          .then()
             .statusCode(200)
             .body(is("It has become appallingly obvious that our technology has exceeded our humanity. - Albert Einstein"));
    }

    @Test
    public void testQuoteAmitRay() {
        given()
          .when().get("/quote/amit-ray")
          .then()
             .statusCode(200)
             .body(is("As more and more artificial intelligence is entering into the world, more and more emotional intelligence must enter into leadership. - Amit Ray"));
    }

    @Test
    public void testQuotePeterSondergaard() {
        given()
          .when().get("/quote/peter-sondergaard")
          .then()
             .statusCode(200)
             .body(is("Information is the oil of the 21st century, and analytics is the combustion engine. - Peter Sondergaard"));
    }
}
