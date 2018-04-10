package com.offp.com.profile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.JsonObject;

//import javax.json.JsonObject;

import org.json.JSONObject;
//import org.json.simple.JSONObject;

public class Profile_Modal {
	
	public static void main(String [] args) {
		try	
		{
			//Profile_Modal oProfile = new Profile_Modal();
			//oProfile.call_me();
		}
		catch (Exception ex)
		{
			System.err.println(ex);
		}
	}
	public Profile_Bean call_me(String access_token) throws Exception {
	     String url = "https://graph.facebook.com/v2.12/me?fields=id%2Cname%2C%20picture%2C%20email&access_token="+access_token;
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     con.setReadTimeout(10000);
	     InputStreamReader strReader = new InputStreamReader(con.getInputStream());
	     BufferedReader in = new BufferedReader(strReader);
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     
	     //print in String
	     System.out.println(response.toString());
	     
	     Profile_Bean o_Profile_Bean = new Profile_Bean();
	     //System.out.println(response["name"]);
	     JSONObject myResponse = new JSONObject(response.toString());
	     //test.getJsonString(response.toString());
	     
	     //Read JSON response, print and add to the object Profile_Bean
	     o_Profile_Bean.setUserName(myResponse.getString("name"));
	     //System.out.println("Name: " + myResponse.getString("name"));
	     
	     o_Profile_Bean.setId(myResponse.getString("id"));
	     //System.out.println("id: " + myResponse.getString("id"));
	     
	     o_Profile_Bean.setEmail(myResponse.getString("email"));
	     //System.out.println("Email: " + myResponse.getString("email"));
	     
	     JSONObject pict_response = myResponse.getJSONObject("picture");
	     JSONObject data_response = pict_response.getJSONObject("data");
	     o_Profile_Bean.setProfilePicture(data_response.getString("url"));
	     //System.out.println("URL: " + data_response.getString("url"));
		
	     //return the object
	     return o_Profile_Bean;    
	     
   }
}
