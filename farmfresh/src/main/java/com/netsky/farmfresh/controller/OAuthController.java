package com.netsky.farmfresh.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.JsonObject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

//import javax.json.JsonObject;

import org.json.JSONObject;
//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netsky.farmbackend.dao.BuyerDAO;
import com.netsky.farmbackend.dao.CategoryDAO;
import com.netsky.farmbackend.dao.UserTypeDAO;
import com.netsky.farmbackend.dto.Buyer;
import com.netsky.farmbackend.dto.Category;
import com.netsky.farmbackend.dto.UserType;
import com.netsky.farmfresh.tools.controller.ToolBox;

@Controller
public class OAuthController {

	@Autowired BuyerDAO buyerDAO;
	@Autowired UserTypeDAO uTypeDAO;
	@Autowired CategoryDAO categoryDAO;
	
	public Buyer GetFBData(String access_token) throws Exception {
		
		try
		{
			String url = "https://graph.facebook.com/v2.12/me?fields=id%2Cname%2C%20picture%2C%20email&access_token="+access_token;
	
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			//Define get method to get data from fb
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			con.setReadTimeout(10000);
	
			//Read data (con.getResponseCode	InputStream())
			InputStreamReader strReader = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(strReader);
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			}
			in.close();
	
			//print in String
			//System.out.println(response.toString());
	
			//** create a new buyer using fb data
			Buyer buyer = new Buyer();
			JSONObject myResponse = new JSONObject(response.toString());
			//test.getJsonString(response.toString());
	
			//Read JSON response
			buyer.setFirstName(myResponse.getString("name"));
			buyer.setLastName(myResponse.getString("name"));
			//System.out.println("Name: " + myResponse.getString("name"));
	
			buyer.setEmail(myResponse.getString("email"));
			buyer.setDateCreated(ToolBox.GetCurrentDate());
	
			//Get the userType
			Category test = new Category();
			test = categoryDAO.get(1);
			
			UserType uType = new UserType();
			uType = uTypeDAO.getByAcronym('B');
			buyer.setUserType(uType);

			//May be I can encrypt fb id. in that case change field size in mysql to 40
			buyer.setFbBuyerId(myResponse.getString("id"));	
			
			/*
			JSONObject pict_response = myResponse.getJSONObject("picture");
			JSONObject data_response = pict_response.getJSONObject("data");
			buyer.setPicture(data_response.getString("url"));
			*/
			
			//Add a new buyer in the db with fb data
			buyerDAO.add(buyer);
			
				
			//avoid to return a buyer, use session variables
			return buyer; 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null; 
		}
		
	}
}
