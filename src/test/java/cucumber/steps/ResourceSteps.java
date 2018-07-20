package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;

@ContextConfiguration
public class ResourceSteps {

    final private String BASEURL = "http://localhost:8080";
    private ResponseEntity<String> response;

    @When("^a get request is made to ' \"([^\"]*)\" '$")
    public void aGetRequestIsMadeToEndpoint(String endpoint) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>("", header);
        response = restTemplate.exchange(BASEURL + endpoint, HttpMethod.GET, request, String.class);
    }

    @Then("^a response code of (\\d+)$")
    public void aResponseCodeOf(int expectedResponseCode) {
        assertEquals(expectedResponseCode, response.getStatusCodeValue());
    }
}
