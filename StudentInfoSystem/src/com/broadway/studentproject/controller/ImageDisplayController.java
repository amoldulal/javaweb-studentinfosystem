package com.broadway.studentproject.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.broadway.studentproject.service.StudentService;
import com.broadway.studentproject.service.StudentServiceImpl;
import com.broadway.studentproject.service.UserService;
import com.broadway.studentproject.service.UserServiceImpl;

@WebServlet("/ImageDisplayController")

public class ImageDisplayController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl();
	UserService userService = new UserServiceImpl();
	private static final int DEFAULT_BUFFER_SIZE = 1024;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String studentId = request.getParameter("studentId");
		String filePath = "";
		if (studentId!=null) {
			filePath=studentService.getImageUrl(Integer.parseInt(studentId));
		}else {
			String userId=request.getParameter("userId");
			filePath=userService.getImageUrl(Integer.parseInt(userId));
		}
				
		File file = new File(filePath);
		
		String contentType = getServletContext().getMimeType(file.getName());
		
		if (contentType == null) {
			contentType = "application/octet-stream";
		}
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setHeader("content-Length", String.valueOf(file.length()));
		response.setHeader("content-Disposition", "attachement;filename\"" + file.getName() + "\"");
		
		byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(response.getOutputStream());
			int length;
			while ((length = in.read(bytes)) > 0) {
				out.write(bytes, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
			out.close();
		}
	}
}
