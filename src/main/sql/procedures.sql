CREATE  TABLE procedures (
  patientId int(11) NOT NULL AUTO_INCREMENT,
  type VARCHAR(100) NOT NULL ,
  date DATE NOT NULL ,
  completed TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (patientId));