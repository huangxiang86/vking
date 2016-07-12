package com.vking.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vking.test.dao.PartRepository;
import com.vking.test.data.Part;

@Component
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PartRepository partRepository;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(partRepository == null){
			System.out.println("partRepository is null");
		}else{
			Part part = partRepository.findByName("1231231231");
			resp.getOutputStream().print("<h1>" + part.getNumber() + "</h1>");
		}
		
		
	}

}
