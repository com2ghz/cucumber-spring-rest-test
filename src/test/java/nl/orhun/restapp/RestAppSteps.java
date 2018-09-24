package nl.orhun.restapp;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class RestAppSteps  {

    private Response response;
    private List<Person> persons;

    @LocalServerPort
    protected int port;

    @When("^I request persons from the system$")
    public void iRequestPersonsFromTheSystem() {
        response = given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .get("/persons");
    }

    @Then("^I get a response with status (\\d+)$")
    public void iGetAResponseWithStatus(int status) {
        response.then().statusCode(status);
    }

    @And("^I get a list of (\\d+) persons$")
    public void iGetAListOfPersons(int length) {
        persons = Arrays.asList(response.as(Person[].class));
        assertEquals(length, persons.size());
    }

    @And("^field (.*) has value (.*)$")
    public void bla(String jsonPath, String expected) {
        JsonPath jsonDoc = response.jsonPath();
        String value = jsonDoc.getString(jsonPath);
        assertEquals(expected, value);
    }
}
