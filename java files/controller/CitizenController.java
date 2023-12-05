package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Citizen;
import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.service.CitizenService;

@Controller
public class CitizenController {

	@Autowired
	CitizenService service;

	@RequestMapping("/insertCitizen")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Citizen c=new Citizen();
		c.setPersonName(request.getParameter("citizenName"));

		Vaccinationcenter vaccinationCenter = new Vaccinationcenter();
		vaccinationCenter.setVaccinationCenterCity(request.getParameter("centerCity"));
		vaccinationCenter.setVaccinationCenterName(request.getParameter("vaccinationCenter"));

		// Set the Vaccinationcenter for the Citizen
		c.setVaccinationCenter(vaccinationCenter);
		int numberOfDoses = Integer.parseInt(request.getParameter("noOfDoses"));
		c.setNumberOfDoses(numberOfDoses);

		// Set vaccination status based on the number of doses
		if (numberOfDoses == 0) {
			c.setVaccinationStatus("Not Vaccinated");
		} else if (numberOfDoses == 2) {
			c.setVaccinationStatus("Fully Vaccinated");
		} else {
			// For other cases, you might want to handle it accordingly
			c.setVaccinationStatus("Partially Vaccinated");
		}
		if(service.insert(c)!=null) {
			mv.setViewName("displayallCitizens.jsp");
		}

		return mv;
	}

	//
	@RequestMapping("/editCitizen")
	public ModelAndView editCitizen(@RequestParam("id") Integer id,
			@RequestParam("citizenName") String citizenName,
			@RequestParam("vaccinationCenter") String vaccinationCenter,
			@RequestParam("centerCity") String centerCity,
			@RequestParam("noOfDoses") Integer noOfDoses,

			HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		Citizen updatedCitizen = new Citizen();

		updatedCitizen.setId(id);
		updatedCitizen.setPersonName(citizenName);
		updatedCitizen.setNumberOfDoses(noOfDoses);
		
		// Set vaccination status based on the number of doses
		if (noOfDoses == 0) {
			updatedCitizen.setVaccinationStatus("Not Vaccinated");
		} else if (noOfDoses == 2) {
			updatedCitizen.setVaccinationStatus("Fully Vaccinated");
		} else {
			// For other cases, you might want to handle it accordingly
			updatedCitizen.setVaccinationStatus("Partially Vaccinated");
		}
		
		Vaccinationcenter vc = new Vaccinationcenter(vaccinationCenter,centerCity);
		updatedCitizen.setVaccinationCenter(vc);

		Citizen editedCitizen = service.editById(id, updatedCitizen);
		if (editedCitizen != null) {
			mv.setViewName("viewCitizens.jsp");
			List<Citizen> list = service.getall();
			mv.addObject("list", list);
		} else {
			// Handle the case where the Citizen with the given ID doesn't exist
			mv.setViewName("errorEditPage.jsp");
		}

		return mv;
	}


	@RequestMapping("/getallCitizen")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Citizen> list=service.getall();
		mv.setViewName("viewCitizens.jsp");
		mv.addObject("list",list);

		return mv;
	}
	@RequestMapping("/deleteC")
	public ModelAndView deleteVaccinationCenter (@RequestParam("id") Integer id,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();		
		service.deleteById(id);
		mv.setViewName("displayallCitizens.jsp");
		return mv;
	}

	@RequestMapping("/viewCController")
	public ModelAndView view(@RequestParam("id") Integer id ) {
		ModelAndView mv = new ModelAndView();
		Optional<Citizen> citizen = service.viewById(id);

		if (citizen.isPresent()) {
			mv.setViewName("viewCdisplay.jsp");
			mv.addObject("citizen", citizen.get());
		} else {
			// Handle case where the center is not found
			mv.setViewName("errorEditPage.jsp");
		}
		return mv;
	}


}

