package com.example.demo.controller;

import com.example.demo.pojo.Admin;
import com.example.demo.service.AdminService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	AdminService service;

	@RequestMapping("/")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView defaultPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();

		mv.setViewName("login.jsp");

		return mv;
	}

	@RequestMapping("/registration")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin a=new Admin();
		a.setPassword(request.getParameter("password"));
		a.setEmail(request.getParameter("email"));
		a.setUsername(request.getParameter("username"));

		if(service.insert(a)!=null) {
			mv.setViewName("display.jsp");
		}

		return mv;
	}
	
	@RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user by checking against database
        Admin isAuthenticated = service.findByUsernameAndPassword(username, password); // Implement this method in AdminService

        if (isAuthenticated != null) {
            // Redirect to dashboard upon successful login
            mv.setViewName("dashboard.jsp");
        } else {
            // Redirect back to login page or show error message
            mv.setViewName("errorlogin.jsp");
        }
        return mv;
    }
}
