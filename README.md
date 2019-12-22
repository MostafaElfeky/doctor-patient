# Doctor-Patient Appoitment

A simple Appointment web API between doctors and patients. 


## Solution

### Architecture
I have decoupling a three application services with a microservices architecture (doctors-service, patients-service and appointments-service) and Service discovery to make service discover each other dynamicly.

### Algorithm
I make doctors configure their working time in a `TIME_SCHEDULE` table, handled in `doctors-service`.
In `appointments-service` i create a schdule task running every day to take these configuration and convert them into  afree appoitments which will be ocypied py patient later.

### Prerequisites

What software we need to install .
```
MySQL 8
JDK 1.8
Eclipse
```

### Installing

 - Install MySQL 8 and create database name  it `appointmet`  with username  `root` and password `root`
 - Pull the repository into your local system .  
 - Import the four projects  as a maven project into eclipse worksapce. 
 - Please in property file {spring.jpa.hibernate.ddl-auto = create} to create database.
 - Run the attached SQL file `data.sql` which include some dummy data to play with.
 - Run services one by one as a spring boot web application. 
 - Each  service has it's own swagger documentation you can access them via:
	 - [doctors-service](http://localhost:8081/swagger-ui.html#/)
	 - [patients-service](http://localhost:8082/swagger-ui.html#/)
	 - [appointments-service](http://localhost:8083/swagger-ui.html#/)

## Built With

* [Java](https://www.java.com/download/) - Programming language.
* [MySQL](https://www.mysql.com/) - database.
* [Spring Boot](https://spring.io/) - The web framework used.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Eureka](https://github.com/Netflix/eureka) - _Service registry.


## Authors

* **Mostafa Elfeky** - *Initial work* - [LinkedIn](https://www.linkedin.com/in/mostafa-elfeky-1528ab104/)

