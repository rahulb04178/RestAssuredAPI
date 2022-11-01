package restproject;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class Live5PiasaAPI {
	
	
	
   @Test
   public void ClientLoginAPI() {
	   
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	   given()
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
	    .log().all();
	   
   }
   
   //@Test
   public void getClientProfile() {
	
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	   given()
	    .header("UserID","ZyT47UW2g56")
	    .header("Password","H98qlU4Sn2")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .header("Cookie","5paisacookie=B8C6030205A1BFFCC4078C449491F68A710901B3B950E189CDE37400F5861CFBBD13738F6C886B203FAFA4D568377C79BE07A616ABCA2767626113900B0E21EF9B7F8FC9E9CF3CA968D7D598BA8E6DFC26684CA1790B49F472F6642D4935100049145B1E5068D06876E569A7878E427A27DC00476A608C79006E591DDBFA84E89DB06C5A2B213A7725BED920199030187CF5CFDF_C;JwtToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjUzNDIzMzE3Iiwicm9sZSI6IjEiLCJuYmYiOjE2NjcyMTczODQsImV4cCI6MTY2OTgwOTM4NCwiaWF0IjoxNjY3MjE3Mzg0fQ.I3ANdn9rPM_8-dLV9dE8uGpL8RhIDPzeBUnEqAX50wA")
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
	   
	   JSONObject head = new JSONObject();
       head.put("appName", "5PTRADE");
	   head.put("appVer", "1.0");
	   head.put("key", "8eeee59bdab88bace6189d001f96487e");
	   head.put("osName", "Android");
	   head.put("requestCode", "5PCCSV2");
	   
	   baseURI = "https://swaraj.5paisa.com/Mob/Service1.svc";
	   
	   given()
	    .header("UserID","ZyT47UW2g56")
	    .header("Password","H98qlU4Sn2")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .header("Cookie","5paisacookie=B8C6030205A1BFFCC4078C449491F68A710901B3B950E189CDE37400F5861CFBBD13738F6C886B203FAFA4D568377C79BE07A616ABCA2767626113900B0E21EF9B7F8FC9E9CF3CA968D7D598BA8E6DFC26684CA1790B49F472F6642D4935100049145B1E5068D06876E569A7878E427A27DC00476A608C79006E591DDBFA84E89DB06C5A2B213A7725BED920199030187CF5CFDF_C;JwtToken=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjUzNDIzMzE3Iiwicm9sZSI6IjEiLCJuYmYiOjE2NjcyMTczODQsImV4cCI6MTY2OTgwOTM4NCwiaWF0IjoxNjY3MjE3Mzg0fQ.I3ANdn9rPM_8-dLV9dE8uGpL8RhIDPzeBUnEqAX50wA")
	    .body(request.toJSONString()).
	   when()
	    .post("/V2/CheckClientStatus").
	   then()
	    .statusCode(200)
	    .log().all();
	   
	    
   }
   
}
