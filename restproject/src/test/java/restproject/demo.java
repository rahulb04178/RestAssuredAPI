package restproject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class demo {
	
	//@Test
	public void getAPI() {
		
		baseURI="https://reqres.in/api";
		
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[2].id", equalTo(9))
		.log().all();
	}
	
	@Test
	public void postAPI() {
		
		JSONObject object = new JSONObject();
		object.put("name", "morpheus");
		object.put("job", "leader");
		
		System.out.println(object);
		
		baseURI="https://reqres.in/api";
		
		given().
		 headers("Content-type", "application/json").
         body(object.toJSONString()).
        when().
         post("/users").
        then().
         statusCode(201).log().all();
      
		
		
	}

}
