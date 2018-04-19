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
	
	public void GetFBData(String access_token) throws Exception {
		
		try
		{
			String url = "https://graph.facebook.com/v2.12/me?fields=id%2Cname%2C%20picture%2C%20email&access_token="+access_token;
	
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			//return null; 
		}
		
	}
}
