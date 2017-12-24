package com.broadway.studentproject.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class ImageUtil {
public static final String imageUploadPath = "C:/JavaClass/imageupload/" ;
	
	public static String writeImageToFile(String imageUrl, Part part) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = part.getInputStream();
			out = new FileOutputStream(new File(imageUrl));
			int lenght;
			byte[] b = new byte[1024];
			while ((lenght = in.read(b)) != -1) {
				out.write(b, 0, lenght);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return imageUrl;
	}
	
	public static String getFileName(Part part) {
		for (String content: part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=")+1).trim().replace("\"", "");
			}
		}
		return null;
		
	}
}
