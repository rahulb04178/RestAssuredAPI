package restproject;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.*;



public class Live5PiasaAPI {
	
	
   private Cookies cookies;
   
   @Test
   public void ClientLoginAPI() {
	   
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	  cookies = given()
	    .header("UserID","ZyT47UW2g56")
	    .header("Password","H98qlU4Sn2")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .header("Cookie","5paisacookie=8178C3F56E80CD71C8D720EF26BA2CDF8F5347E6DD22FBC70FF60ADE856B647E4923DFB3BAA3D0D1EAA44627E18AE13629BBE600D726F31BF8E29AE815345E4CD2819CADEF2D67AB693C3F84F78C8A397C2C18B69E245F6BC95C02AD6B7B048DCA8BC6E9B3BB50A645CCD64F5D34460B7B7C5A81B08ACEF7A65FC2AE629A686ECA69C9207E8D00D0A1001FB22C422914C776F9D6_C;JwtToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjU5NjQyMjYyIiwicm9sZSI6IjEiLCJuYmYiOjE2NTY1Nzk0OTQsImV4cCI6MTY1OTE3MTQ5NCwiaWF0IjoxNjU2NTc5NDk0fQ.l3u8-ysUUTV8Ee0Mfxmj8izrebrVYmWhc6mwFXEWIME")
	    .body("53423317").
	   when()
	    .post("/V1/ClientLoginRequest").
	   then()
	    .statusCode(200)
	    .body("Success", Matchers.equalTo(0))
	    .extract().response().getDetailedCookies();	 
	  
   }
   
   //@Test
   public void getClientProfile() {
	
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	   given()
	    .cookies(cookies)
	    .header("UserID","ZyT47UW2g56")
	    .header("Password","H98qlU4Sn2")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body("53423317").
	   when()
	    .post("/ClientProfile").
	   then()
	    .statusCode(200)
	    .body("Message", Matchers.equalTo(""))
	    .log().all();
	  	   
   }
   
   //@Test
   public void checkClientStatus() {
	   
	   JSONObject request = new JSONObject();
	   request.put("Email_Id", "LAJRIMNAIK@GMAIL.COM");
	   
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	   given()
	    .header("UserID","ZyT47UW2g56")
	    .header("Password","H98qlU4Sn2")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(request.toJSONString()).
	   when()
	    .post("/V2/CheckClientStatus").
	   then()
	    .statusCode(200)
	    .log().all();
	   
	    
   }
   
}
