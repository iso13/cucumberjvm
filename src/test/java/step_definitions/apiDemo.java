package step_definitions;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


import io.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.Map;



public class apiDemo {
    private String url;
    private Response response;
    private ValidatableResponse json;
    public int length;

    @Given("^the apis are up and running for \"([^\"]*)\"$")
    public void the_apis_are_up_and_running_for(String url) throws Throwable {
        this.url = url;
        response = given().when().get(url);
        Assert.assertEquals(200, response.getStatusCode());

    }

    @When("^a user performs a get request to \"([^\"]*)\"$")
    public void a_user_performs_a_get_request_to(String url) throws Throwable {

        this.url = this.url + url;
    }

    @When("^a user performs a GET request to \"([^\"]*)\"$")
    public void a_user_performs_a_GET_request_to(String url) throws Throwable {
        response = given().when().get(this.url + url);

        System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the response code should be (\\d+)$")
    public void the_response_code_should_be(int statusCode) throws Throwable {
        json = response.then().statusCode(statusCode);
    }

    @Then("^the response should have the following$")
    public void the_response_should_have_the_following(Map<String, String> responseFields) throws Throwable {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                json.body(field.getKey(), equalTo(String.valueOf(field.getValue())));
            } else {
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }

    }

}
