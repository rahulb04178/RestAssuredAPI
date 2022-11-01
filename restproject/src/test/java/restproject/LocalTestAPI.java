package restproject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class LocalTestAPI {
	
	//@Test
	public void getLocalAPI() {
		
		baseURI = "http://localhost:3000/";
		
		given()
		.get("/users")
		.then()
		.statusCode(200).log().all();
		
	}
	
	//@Test
	public void postLoaclAPI() {
		
		JSONObject request = new JSONObject();
		
		request.put("Name", "Ruhi");
		request.put("DOB", "19112021");
		
		baseURI = "http://localhost:3000";
		
		 given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(request.toJSONString())
		.when()
		 .post("/users")
		.then()
		 .statusCode(201)
		 .log().all();
	}
	
	//@Test
	public void putLocalAPI() {
       		
		JSONObject request = new JSONObject();
		
		request.put("DOB", "08021993");
		request.put("Name", "Dinesh");
		
		baseURI = "http://localhost:3000";
		given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(request.toJSONString()).
		when()
		 .put("/users/6").
		then()
		 .statusCode(200)
		 .log().all();
			
	}
	
	//@Test
	public void patchLocalAPI() {
		
      JSONObject request = new JSONObject();
      
      request.put("Name", "Chhaya");
      
      baseURI = "http://localhost:3000";
      
      given()
       .contentType(ContentType.JSON)
       .accept(ContentType.JSON)
       .body(request.toJSONString()).
      when()
       .patch("/users/5").
      then()
       .statusCode(200)
       .log().all();
     
	}
	
	@Test
	public void deleteLocalAPI() {
		
		baseURI = "http://localhost:3000";
		
		when()
		 .delete("/users/3").
		then()
		 .statusCode(200)
		 .log().all();
	}

}
