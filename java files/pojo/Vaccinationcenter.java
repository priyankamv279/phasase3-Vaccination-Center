package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaccinationcenter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccinationCenterId;
    private String vaccinationCenterName;
    private String vaccinationCenterCity;
    
    public Vaccinationcenter()
    {
   	 
    }

    public Vaccinationcenter(String vaccinationCenterName, String vaccinationCenterCity)
    {
    
   	 this.vaccinationCenterName = vaccinationCenterName;
   	 this.vaccinationCenterCity = vaccinationCenterCity;
    }

    public int getVaccinationCenterId()
    {
   	 return vaccinationCenterId;
    }

    public void setVaccinationCenterId(int vaccinationCenterId)
    {
   	 this.vaccinationCenterId = vaccinationCenterId;
    }

    public String getVaccinationCenterName()
    {
   	 return vaccinationCenterName;
    }

    public void setVaccinationCenterName(String vaccinationCenterName)
    {
   	 this.vaccinationCenterName = vaccinationCenterName;
    }

    public String getVaccinationCenterCity()
    {
   	 return vaccinationCenterCity;
    }

    public void setVaccinationCenterCity(String vaccinationCenterCity)
    {
   	 this.vaccinationCenterCity = vaccinationCenterCity;
    }

    @Override
    public String toString()
    {
   	 return "Vaccinationcenter [vaccinationCenterId=" + vaccinationCenterId + ", vaccinationCenterName="
   			 + vaccinationCenterName + ", vaccinationCenterCity=" + vaccinationCenterCity + "]";
    }
    
}
