package restproject;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExample {

@Test
public void putAPI() {
		
		JSONObject object = new JSONObject();
		object.put("name", "morpheus");
		object.put("job", "leader");
		
		//System.out.println(object);
		
		baseURI="https://reqres.in";
		
		given().
		 headers("Content-type", "application/json").
         body(object.toJSONString()).
        when().
         put("/api/users/2").
        then().
         statusCode(200).log().all();
      
	}

@Test
public void patchAPI() {
	
	JSONObject object = new JSONObject();
	object.put("name", "morpheus");
	object.put("job", "leader");
	
	//System.out.println(object);
	
	baseURI="https://reqres.in";
	
	given().
	 headers("Content-type", "application/json").
     body(object.toJSONString()).
    when().
     patch("/api/users/2").
    then().
     statusCode(200).log().all();
  
}

@Test
public void deleteAPI() {
	
	baseURI="https://reqres.in";
	
    when().
     delete("/api/users/2").
    then().
     statusCode(204).log().all();
  
}

}
