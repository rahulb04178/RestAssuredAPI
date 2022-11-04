package restproject;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;

import static io.restassured.RestAssured.*;

public class UAT5PaisaAPI {
	
	private Cookies cookies;

	@Test(priority = 0)
	public void loginAPI() {
		
	JSONObject object = new JSONObject();	
	JSONObject headrequest = new JSONObject();
	JSONObject bodyrequest = new JSONObject();
	headrequest.put("appName", "5PTRADE");
	headrequest.put("appVer", "1.0");
	headrequest.put("key", "4dddd59bdab77bace6189d001f96487e");
	headrequest.put("osName", "Android");
	headrequest.put("requestCode", "5PLoginV5");
	bodyrequest.put("Email_id", "D7AGeio+deDH94QUQiP/6w==");
	bodyrequest.put("Password", "2fZ2bCLnalqKiUGEs96/dg==");
	bodyrequest.put("LocalIP", "192.168.88.41");
	bodyrequest.put("PublicIP", "192.168.88.41");
	bodyrequest.put("HDSerailNumber", "");
	bodyrequest.put("MACAddress", "");
	bodyrequest.put("MachineID", "BM4653-D-039377");
	bodyrequest.put("VersionNo", "1.7");
	bodyrequest.put("RequestNo", "1");
	bodyrequest.put("My2PIN", "YAftqUV3rrXnbuCkD9Z+LA==");
	bodyrequest.put("ConnectionType", "1");
	object.put("head", headrequest);
	object.put("body", bodyrequest);


		baseURI = "http://ttavatar.5paisa.in/5Paisa_Mobile_Service/Service1.svc";
		
	 cookies = given()
		.header("UserID","RaM08AN5d13")
	    .header("Password","R08ama1NT3")
	    .contentType(ContentType.JSON)
	    .accept(ContentType.JSON)
	    .body(object.toJSONString()).
	   when()
	    .post("/V5/LoginRequestMobileNewbyEmail").
	   then()
	    .statusCode(200)
	    .extract().response().getDetailedCookies();    
	}
	
	@Test(priority = 1)
    public void getTradeBook() {
		
		JSONObject object = new JSONObject();	
		JSONObject headrequest = new JSONObject();
		JSONObject bodyrequest = new JSONObject();
		headrequest.put("appName", "5PTRADE");
		headrequest.put("appVer", "1.0");
		headrequest.put("key", "4dddd59bdab77bace6189d001f96487e");
		headrequest.put("osName", "WEB");
		headrequest.put("requestCode", "5PTrdBkV2");
    	bodyrequest.put("ClientCode", "50000021");
    	object.put("head", headrequest);
    	object.put("body", bodyrequest);
    	
    	baseURI = "http://ttavatar.5paisa.in/5Paisa_Mobile_Service/Service1.svc";
		
       given()
        .cookies(cookies)
   		.header("UserID","RaM08AN5d13")
   	    .header("Password","R08ama1NT3")
   	    .contentType(ContentType.JSON)
   	    .accept(ContentType.JSON)
   	    .body(object.toJSONString()).
   	   when()
   	    .post("/V2/TradeBook").
   	   then()
   	    .statusCode(200)
   	    .assertThat().body("head.statusDescription", Matchers.equalTo("Success"));
    }	
	
	
}
