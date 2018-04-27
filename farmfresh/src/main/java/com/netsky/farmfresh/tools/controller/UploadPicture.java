package com.netsky.farmfresh.tools.controller;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

/* REFERENCE: 
 * 	http://snlkjha.blogspot.ca/2013/09/code-to-upload-multiple-files.html?m=1
 * 
 */
public class UploadPicture extends HttpServlet {
	
    private static final String UPLOAD_DIR = "upload";
	private static final long serialVersionUID = 1L;

    //get and save the picture in the folder (uploadPathDir/userID)
    public void GetPicture(HttpServletRequest req, HttpServletResponse resp, String userFolder) throws ServletException, java.io.IOException 
    {
        int i = 1;
        
        try 
        {
        	// request
        	//HttpServletRequest tempReq = req;
            
        	//String uploadPathDir;
        	ServletContext servletContext = req.getSession().getServletContext();
        	if (servletContext == null) {
        		throw new NullPointerException("servletContext == null");
        	}
        	String uploadPathDir = servletContext.getRealPath("\\src\\main\\webapp\\assets\\images")
        							+ File.separator + UPLOAD_DIR + File.separator + userFolder;
        	
        	//Create the user folder under upload is it doesn't exist yet
            Path path = Paths.get(uploadPathDir);
            if (!Files.exists(path))
            	Files.createDirectories(path);
            
        	// file limit size of 512kB
            MultipartParser parser = new MultipartParser(req, 80 * 80 * 80); 
            Part _part;
            int j = 0;
            while ((_part = parser.readNextPart()) != null) 
            {	//Do only if the data is a file
                if (_part.isFile()) 
                {
                	// get some info about the file
                    FilePart fPart = (FilePart) _part;  
                    String name = fPart.getFileName();

                    if (name != null) 
                    {
                    	//Save file in the repository uploadPathDir
                        long fileSize = fPart.writeTo(new File(uploadPathDir));
                    } 
                }
                else 
                	j++;
            }
        } 
        catch (java.io.IOException ioe) 
        {
        	ioe.printStackTrace();
        }
        
    }
}
