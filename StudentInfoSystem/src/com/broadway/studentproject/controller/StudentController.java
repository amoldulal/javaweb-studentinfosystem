package com.broadway.studentproject.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.broadway.studentproject.dto.Student;
import com.broadway.studentproject.service.StudentService;
import com.broadway.studentproject.service.StudentServiceImpl;
import com.broadway.studentproject.util.ImageUtil;

@WebServlet("/StudentController")
@MultipartConfig

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String STUDENT_LIST_PAGE="studentdetails.jsp";
	private static final String STUDENT_NEW_PAGE="studentForm.jsp";
	StudentService studentService=new StudentServiceImpl();

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("actions");
		String forward="";
		if(action.equals("student_new")) {
			forward=STUDENT_NEW_PAGE;
		}
			if(action.equals("student_edit")) {
				int id=Integer.parseInt(request.getParameter("studentId"));
				request.setAttribute("student", studentService.getStudentInfoById(id));
				forward=STUDENT_NEW_PAGE;
			}
				
		else if(action.equals("student_delete")) {
			int id=Integer.parseInt(request.getParameter("studentId"));
			studentService.deleteStudentInfo(id);
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward=STUDENT_LIST_PAGE;
		}else if(action.equals("student_list")) {
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward=STUDENT_LIST_PAGE;
		}
		RequestDispatcher rd=request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student students = new Student();
		students.setStudentName(request.getParameter("sname"));
		students.setCollegeName(request.getParameter("cname"));
		students.setEmail(request.getParameter("email"));
		students.setRoll(Integer.parseInt(request.getParameter("roll")));
		students.setDepartment(request.getParameter("department"));
		students.setGender(request.getParameter("gender"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date dob = dateFormat.parse(request.getParameter("dob"));
			students.setDob(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] subjects = request.getParameterValues("subject");
		
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		students.setSubject(subject);
		//System.out.println("image upload");
		String studentId = request.getParameter("id");
		
		//for image
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(imageUrl + fileName, part);
		} else {
			imageUrl = studentService.getImageUrl(Integer.parseInt(studentId));
		}

		students.setImageUrl(imageUrl);

		if (studentId == null || studentId.isEmpty()) {
			studentService.saveStudentInfo(students);
		} else {
			students.setId(Integer.parseInt(studentId));
			studentService.updateStudentInfo(students);
		}
		RequestDispatcher rd = request.getRequestDispatcher(STUDENT_LIST_PAGE);
		request.setAttribute("students", studentService.getAllStudentInfo());
		rd.forward(request, response);

	}

}
