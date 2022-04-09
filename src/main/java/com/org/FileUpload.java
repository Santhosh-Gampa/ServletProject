package com.org;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUpload extends HttpServlet{
	
	
	private String UPLOAD_DIRECTORY;
	String fileName ;
	
	public void init() {
		// Get the file location where it would be stored.
		UPLOAD_DIRECTORY = getServletContext().getInitParameter("file-upload");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		fileName = "";
		//String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		String uploadPath = UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		for (Part part : request.getParts()) {
		    fileName = getFileName(part);
		    part.write(uploadPath + File.separator + fileName);
		}
		
	}
	
	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	    	System.out.println(content);
	        if (content.trim().startsWith("filename"))
	        	return part.getSubmittedFileName();
	            //return content.substring(content.indexOf("=") + 2, content.length() - 1);
	        }
	    return "TestFile";
	}

}
