package restproject;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JSONValidationSchema {

  @Test
  public void jsonValidator() {
	  
		baseURI="https://reqres.in/api";
		
		given()
		 .get("/users?page=2").
		 then()
		  .statusCode(200)
		  .assertThat().body(matchesJsonSchemaInClasspath("schema.json")).log().all();

  }	
	
}
