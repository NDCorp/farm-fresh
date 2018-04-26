package com.netsky.farmfresh.tools.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

/* REFERENCE: 
 * 	http://snlkjha.blogspot.ca/2013/09/code-to-upload-multiple-files.html?m=1
 * 
 */
public class UploadPicture extends HttpServlet {
	//Upload picture
    //private String uploadPathDir;
    private static final String UPLOAD_DIR = "upload";
	private static final long serialVersionUID = 1L;

    //get and save the picture in the folder (uploadPathDir/userID)
    public void GetPicture(HttpServletRequest req, HttpServletResponse resp, String userFolder) throws ServletException, java.io.IOException 
    {
        String respMsg = "";
        int i = 1;
        respMsg += "<br>Here is information about uploaded files.<br>";
        
        try 
        {
        	//String uploadPathDir;
        	ServletContext servletContext = req.getSession().getServletContext();
        	if (servletContext == null) {
        		throw new NullPointerException("servletContext == null");
        	}
        	String uploadPathDir = servletContext.getRealPath("/src/main/webapp/assets/images") + File.separator + UPLOAD_DIR;
        	
        	if (!(new File(uploadPathDir)).exists())
            	(new File(uploadPathDir)).mkdir();
            
        	// file limit size of 512kB
            MultipartParser parser = new MultipartParser(req, 80 * 80 * 80); 
            Part _part;
            
            while ((_part = parser.readNextPart()) != null) 
            {	//Do only if the data is a file
                if (_part.isFile()) 
                {
                	// get some info about the file
                    FilePart fPart = (FilePart) _part;  
                    String name = fPart.getFileName();
                    
                    //Create the user folder under upload is it doesn't exist yet
                    uploadPathDir += File.separator + userFolder;
                    if (!(new File(uploadPathDir)).exists())
                    	(new File(uploadPathDir)).mkdir();
                    
                    if (name != null) 
                    {
                    	//Save file in the repository uploadPathDir
                        long fileSize = fPart.writeTo(new File(uploadPathDir));
                        respMsg += i++ + ". " + fPart.getFilePath() + "[" + fileSize / 1024 + " KB]<br>";
                    } 
                    else 
                    {
                    	respMsg = "<br>The user did not upload a file for this part.";
                    }
                }
            }// end while 
        } 
        catch (java.io.IOException ioe) 
        {
        	respMsg = ioe.getMessage();
        }
        
        req.setAttribute("message", respMsg);
        //getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
