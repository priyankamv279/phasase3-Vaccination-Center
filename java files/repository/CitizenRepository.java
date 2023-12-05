package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Citizen;
import com.example.demo.pojo.Vaccinationcenter;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> 
{
//
	List<Citizen> findByVaccinationCenter(Vaccinationcenter center);
	
}