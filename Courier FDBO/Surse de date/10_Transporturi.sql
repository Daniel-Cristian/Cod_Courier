DROP TABLE transporturi;

 CREATE TABLE transporturi
   (	id_transport numeric(10,0), 
	id_depozit numeric(3,0), 
	id_sofer numeric(3,0), 
	id_vehicul numeric(3,0), 
	data_plecare DATE, 
	ora_plecare character varying(5), 
	data_sosire DATE, 
	ora_sosire character varying(5), 
	incidente character varying(2), 
	km_parcursi numeric(3,0), 
	combustibil_consumat numeric(3,0),
    	CONSTRAINT transporturi_pkey PRIMARY KEY (id_transport)
   );

------------------------------------------------------------
DELETE FROM TRANSPORTURI;

Insert into TRANSPORTURI values (1,1,2,3,to_date('12-JAN-18','DD-MON-RR'),'15:00',to_date('13-JAN-18','DD-MON-RR'),'08:00','Nu',580,210);
Insert into TRANSPORTURI values (2,2,3,5,to_date('12-JAN-18','DD-MON-RR'),'12:00',to_date('13-JAN-18','DD-MON-RR'),'21:00','Nu',280,50);
Insert into TRANSPORTURI values (3,3,4,9,to_date('19-JAN-18','DD-MON-RR'),'15:00',to_date('20-JAN-18','DD-MON-RR'),'08:00','Da',680,150);
Insert into TRANSPORTURI values (4,3,5,2,to_date('19-JAN-18','DD-MON-RR'),'12:00',to_date('21-JAN-18','DD-MON-RR'),'21:00','Nu',320,42);
Insert into TRANSPORTURI values (5,3,6,1,to_date('20-JAN-18','DD-MON-RR'),'15:00',to_date('21-JAN-18','DD-MON-RR'),'08:00','Nu',650,210);
Insert into TRANSPORTURI values (6,4,7,2,to_date('22-JAN-18','DD-MON-RR'),'12:00',to_date('23-JAN-18','DD-MON-RR'),'21:00','Nu',580,50);
Insert into TRANSPORTURI values (7,4,8,3,to_date('24-JAN-18','DD-MON-RR'),'15:00',to_date('25-JAN-18','DD-MON-RR'),'08:00','Da',280,150);
Insert into TRANSPORTURI values (8,1,9,5,to_date('25-JAN-18','DD-MON-RR'),'12:00',to_date('26-JAN-18','DD-MON-RR'),'21:00','Nu',680,42);
Insert into TRANSPORTURI values (9,1,10,6,to_date('26-JAN-18','DD-MON-RR'),'15:00',to_date('26-JAN-18','DD-MON-RR'),'21:00','Nu',320,210);
Insert into TRANSPORTURI values (10,2,1,7,to_date('27-JAN-18','DD-MON-RR'),'12:00',to_date('27-JAN-18','DD-MON-RR'),'21:00','Nu',650,421);
Insert into TRANSPORTURI values (11,1,11,12,to_date('29-JAN-18','DD-MON-RR'),'15:00',to_date('29-JAN-18','DD-MON-RR'),'19:00','Da',580,220);
Insert into TRANSPORTURI values (12,1,1,11,to_date('01-FEB-18','DD-MON-RR'),'12:00',to_date('01-FEB-18','DD-MON-RR'),'16:00','Nu',280,42);
Insert into TRANSPORTURI values (13,1,2,1,to_date('03-FEB-18','DD-MON-RR'),'15:00',to_date('03-FEB-18','DD-MON-RR'),'19:00','Nu',680,210);
Insert into TRANSPORTURI values (14,2,2,2,to_date('05-FEB-18','DD-MON-RR'),'12:00',to_date('05-FEB-18','DD-MON-RR'),'16:45','Nu',320,89);
Insert into TRANSPORTURI values (15,3,11,2,to_date('20-FEB-18','DD-MON-RR'),'15:00',to_date('21-FEB-18','DD-MON-RR'),'18:30','Da',650,152);
COMMIT;