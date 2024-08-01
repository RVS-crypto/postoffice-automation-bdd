package restAssuredTests;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetCallBDD {
	Response resp = null;
	
	
	@Given("User runs a get call on following api {string}")
	public void user_runs_a_get_call_on_following_api(String api) {
		resp=RestAssured.given().
		when().
		get(api);
		System.out.println(resp.asPrettyString());
	}
	
	@Then("User validates that clients requested resource is available for {string}")
	public void user_validates_that_clients_requested_resource_is_available(String api) {
		resp=RestAssured.given().
		when().
		get(api);
		int status_code = resp.getStatusCode();
		Assert.assertEquals(200, status_code);
	}
	
	@Then("User validates that clients post resource is available for {string}")
	public void user_validates_that_clients_post_resource_is_available(String api) {
		
		JSONObject json = new JSONObject();
		json.put("id", "15");
		json.put("email", "test@123");
		json.put("first_name", "RV");
		json.put("last_name", "S");
		json.put("avatar", "https://reqres.in/img/faces/9-image.jpg");
		JSONArray jsonarr = new JSONArray();
		jsonarr.put(json);
		resp=RestAssured.given().contentType("application/json").body(jsonarr.toString()).
		post(api);
		int status_code = resp.getStatusCode();
		Assert.assertEquals(201, status_code);
	}
	
	
	@And("User validates that put call is working fine for {string}")
	public void user_validates_that_clients_put_resource_is_available(String api) {
		
		JSONObject json = new JSONObject();
		json.put("email", "test@123");
		json.put("first_name", "RV");
		json.put("last_name", "S");
		json.put("avatar", "https://reqres.in/img/faces/9-image.jpg");
		JSONArray jsonarr = new JSONArray();
		jsonarr.put(json);
		resp=RestAssured.given().headers("Content-Type","application/json").body(jsonarr.toString()).
		put(api);
		int status_code = resp.getStatusCode();
		Assert.assertEquals(200, status_code);
	}
	
	@And("User validates that delete call is working fine for {string}")
	public void user_validates_that_clients_delete_resource_is_available(String api) {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		resp=RestAssured.given().header("Content-type", "application/json").when().
		delete("/api/users/2");
		int status_code = resp.getStatusCode();
		System.out.println(status_code);
		Assert.assertEquals(204, status_code);
	}

}
