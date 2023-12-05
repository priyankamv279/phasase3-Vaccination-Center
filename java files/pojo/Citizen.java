package com.example.demo.pojo;
import javax.persistence.*;
@Entity
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String personName;
	private int numberOfDoses;
	private String vaccinationStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vaccinationCenterId")	
	private Vaccinationcenter vaccinationCenter;

	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getNumberOfDoses() {
		return numberOfDoses;
	}
	public void setNumberOfDoses(int numberOfDoses) {
		this.numberOfDoses = numberOfDoses;
	}

	public String getVaccinationStatus() {
		if (numberOfDoses == 0) {
			return "Not Vaccinated";
		} else if (numberOfDoses == 2) {
			return "Fully Vaccinated";
		} else {
			// Handle other cases, if necessary
			return "Partially Vaccinated";
		}
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		if ("Fully Vaccinated".equals(vaccinationStatus)) {
			this.numberOfDoses = 2;
		} else if ("Not Vaccinated".equals(vaccinationStatus)) {
			this.numberOfDoses = 0;
		} else {

			this.numberOfDoses = 1; 
			this.vaccinationStatus = "Partially Vaccinated"; 
		}
		this.vaccinationStatus = vaccinationStatus;
	}

	public Vaccinationcenter getVaccinationCenter() {
		return vaccinationCenter;
	}
	public void setVaccinationCenter(Vaccinationcenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

}
