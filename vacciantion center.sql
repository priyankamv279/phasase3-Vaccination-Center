create database db8;
use db8;
show tables;
desc admin;
select * from admin;
-------------------------------------------------------------------------------------------------
select * from citizen;

drop table citizen;

INSERT INTO Citizen (person_name, number_of_doses, vaccination_status,vaccination_center_id) 
VALUES ('Waseem Attar', 2, 'Fully Vaccinated', 1),
       ('Johny Deep', 0, 'Not Vaccinated',2),
       ('Ray', 0, 'Not Vaccinated',3),
       ('Lee', 2, 'Fully Vaccinated',4),
       ('Jay', 0, 'Not Vaccinated',5),
       ('Brain', 0, 'Not Vaccinated',6);

SELECT c.id, c.person_name, c.number_of_doses, c.vaccination_status, vc.vaccination_center_name, vc.vaccination_center_city
FROM Citizen c
JOIN Vaccinationcenter vc ON c.vaccination_center_id = vc.vaccination_center_id;


truncate table Citizen;


---------------------------------------------------------------------------------------------------------------------------------
select * from Vaccinationcenter;
INSERT INTO vaccinationcenter (vaccination_center_name, vaccination_center_city)
VALUES ('City Hosiptal', 'Mumbai'),
       ('Galaxy Clinic', 'Mumbai'),
       ('Sunshine Hosiptal', 'Pune'),
	   ('Central Medical Care', 'Hyderbad'),
	   ('Central', 'Pune'),
        ('Sanjeevani Clinic', 'Bengaluru');
truncate table vaccinationcenter;
commit;

SELECT DISTINCT vc.vaccination_center_city FROM vaccinationcenter vc;