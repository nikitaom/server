# Server application
## Preparing
Before using this application be sure you have installed next programs on your computer:


* [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/)
* [PostgreSQL](https://www.postgresql.org)
* [ActiveMQ](https://activemq.apache.org)

Create database on PostgreSQL server using next commands:
````
create database user_list;
````
````
\c user_list;
````
````
CREATE TABLE users (
    id serial PRIMARY KEY, 
    name VARCHAR(50) NOT NULL, 
    surname VARCHAR(50) NOT NULL);
````


Before running app you should configure file src/main/resources/application.properties

## Run app
To run app use next command:
````
mvn spring-boot:run
````            
       
    
          