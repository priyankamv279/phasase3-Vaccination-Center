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
import com.example.demo.service.VaccinationcenterService;

@Controller
public class VaccinationcenterController {
	@Autowired
	VaccinationcenterService service;

	@Autowired
	CitizenService citizenService;


	@RequestMapping("/insert")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Vaccinationcenter vc=new Vaccinationcenter();
		vc.setVaccinationCenterName(request.getParameter("centerName"));
		vc.setVaccinationCenterCity(request.getParameter("centerCity"));
		if(service.insert(vc)!=null) {
			mv.setViewName("displayallCenters.jsp");
		}

		return mv;
	}

	@RequestMapping("/getall")
	//alternate of request.getParameter=>@RequestParam("name") String name 
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Vaccinationcenter> list=service.getall();
		mv.setViewName("viewCenters.jsp");
		mv.addObject("list",list);

		return mv;
	}

	@RequestMapping("/deleteVC")
	public ModelAndView deleteVaccinationCenter (@RequestParam("id") Integer id,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();		
		service.deleteById(id);
		mv.setViewName("displayallCenters.jsp");
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView editVaccinationCenter(@RequestParam("id") Integer id,
			@RequestParam("centerName") String centerName,
			@RequestParam("centerCity") String centerCity,
			HttpServletRequest request,
			HttpServletResponse response) {


		ModelAndView mv = new ModelAndView();


		Vaccinationcenter updatedCenter = new Vaccinationcenter();

		updatedCenter.setVaccinationCenterId(id);
		updatedCenter.setVaccinationCenterName(centerName);
		updatedCenter.setVaccinationCenterCity(centerCity);

		Vaccinationcenter editedCenter = service.editById(id, updatedCenter);
		if (editedCenter != null) {
			mv.setViewName("viewCenters.jsp");
			List<Vaccinationcenter> list = service.getall();
			mv.addObject("list", list);
		} else {
			// Handle the case where the center with the given ID doesn't exist
			mv.setViewName("errorEditPage.jsp");
		}

		return mv;
	}

	@RequestMapping("/view")
	public ModelAndView view(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Optional<Vaccinationcenter> centerOptional = service.viewById(id);

		if (centerOptional.isPresent()) {
			Vaccinationcenter center = centerOptional.get();
			mv.setViewName("viewVCdisplay.jsp");
			mv.addObject("center", center);

			// Fetch citizens by the vaccination center
			List<Citizen> citizens = citizenService.getCitizensByVaccinationCenter(center);
			mv.addObject("citizens", citizens);

			//
		} else {
			// Handle case where the center is not found
			mv.setViewName("errorEditPage.jsp");
		}
		return mv;
	}


}

