# car-app-demo

##Code

Clone the demo app repository

https://github.com/sanjayamrt/car-app-demo.git

##Build the Application

From the project directory execute the following command

./mvnw clean install

This command will generate the application jar file in target directory

##Application Execution

java -jar target/car-app-demo-0.0.1-SNAPSHOT.jar

This will make the application up and running on the port 8081

##Commands to execute

###Add Car Into the system

curl -d '{"make":"Toyota","model":"Rainy","year":2000, "color":"Black"}' 
-H "Content-Type: application/json" -X POST http://localhost:8081/cars

###Retrieve Car Details

curl -H "Content-Type: application/json" -X GET http://localhost:8081/cars/{ID}

###Delete Car from the application

curl -H "Content-Type: application/json" -X DELETE http://localhost:8081/cars/{ID}








