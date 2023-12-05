package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Citizen;
import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.repo.CitizenRepository;

@Service
public class CitizenService {
	//creates an obj automatically wrt to the dummy object which u have created 
	@Autowired
	CitizenRepository repo;
	
	public Citizen insert(Citizen c) {
		return repo.save(c);
	}
	//getallrecord
	public List<Citizen> getall(){
		return repo.findAll();
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public Citizen editById(int id, Citizen updatedCitizen) {
		Optional<Citizen>existingCitizen = repo.findById(id);
		if (existingCitizen.isPresent()) {
			Citizen citizenToUpdate = existingCitizen.get();
			// Update properties of the existing center with the new values
			citizenToUpdate.setPersonName(updatedCitizen.getPersonName());
			citizenToUpdate.setNumberOfDoses(updatedCitizen.getNumberOfDoses());
			citizenToUpdate.setVaccinationStatus(updatedCitizen.getVaccinationStatus());
			citizenToUpdate.setVaccinationCenter(updatedCitizen.getVaccinationCenter());

			// Save the updated citizen
			return repo.save(citizenToUpdate);
		} else {

			return null;
		}
	}
	
	public Optional<Citizen> viewById(Integer id){
	    return repo.findById(id);
	}

	//
	 public List<Citizen> getCitizensByVaccinationCenter(Vaccinationcenter center) {
	        // method in your CitizenRepository to find citizens by vaccination center
	        return repo.findByVaccinationCenter(center);
	    }
}

