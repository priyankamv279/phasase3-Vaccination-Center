package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.repo.VaccinationcenterRepository;

@Service
public class VaccinationcenterService {
	//creates an obj automatically wrt to the dummy object which u have created 
	@Autowired
	VaccinationcenterRepository repo;

	//insert
	public Vaccinationcenter insert(Vaccinationcenter v) {
		return repo.save(v);
	}

	//getallrecord
	public List<Vaccinationcenter> getall(){
		return repo.findAll();
	}

	public Optional<Vaccinationcenter> viewById(Integer id){
	    return repo.findById(id);
	}

	
	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public Vaccinationcenter editById(int id, Vaccinationcenter updatedCenter) {
		Optional<Vaccinationcenter>existingCenter = repo.findById(id);
		if (existingCenter.isPresent()) {
			Vaccinationcenter centerToUpdate = existingCenter.get();
			// Update properties of the existing center with the new values
			centerToUpdate.setVaccinationCenterName(updatedCenter.getVaccinationCenterName());
			centerToUpdate.setVaccinationCenterCity(updatedCenter.getVaccinationCenterCity());

			// Save the updated center
			return repo.save(centerToUpdate);
		} else {

			return null;
		}
	}

}
