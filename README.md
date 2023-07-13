# Hotel Project

## Description

A small Spring Boot application for hotel systems can be built to provide various RESTful APIs for managing hotel-related operations.

<a href="https://docs.oracle.com/javase/tutorial/index.html"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" height="40px" width="40px" /></a><a href="https://www.postgresql.org/"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" height="40px" width="40px" /></a>

## Getting Started

To save the project and configure the database data in the application.properties file, follow these steps:

Save the Project: Before configuring the database, make sure you have created a new Spring Boot project and have it set up in your preferred IDE or text editor.

### Prerequisites

Configure Database Connection: Open the application.properties file, which is typically located in the src/main/resources directory of your project. If the file doesn't exist, you can create it.

Specify Database Details: Inside the application.properties file, add the following lines to configure your database connection:


# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=db_username
spring.datasource.password=db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
Replace db_name with the name of your database, db_username with the username for accessing the database, and db_password with the corresponding password.

Save the Configuration: Save the application.properties file after making the necessary changes.
By configuring the database details in the application.properties file, Spring Boot will automatically connect to the specified database when the application starts up. This will allow you to interact with the database using Spring Data JPA or any other database library of your choice.


## Usage

Start your Spring Boot application: Make sure your Spring Boot application is running either through your IDE or by executing the generated JAR file.

Launch Postman: Open Postman on your system. If you haven't installed Postman yet, you can download and install it from the official website (https://www.postman.com/).

Create a new request: Click on the "New" button in Postman to create a new request. You can choose the HTTP method (GET, POST, PUT, DELETE, etc.) based on the API you want to test.

Enter request URL: In the request URL field, enter the URL of your API endpoint. For example, if you have implemented an API to retrieve hotel details by ID, the URL might look like: http://localhost:8080/hotels/{hotelId}. Replace {hotelId} with the actual ID of the hotel you want to retrieve.

Set request headers (if required): If your API requires any headers, such as authentication tokens or content type headers, you can add them in the "Headers" section of Postman. Specify the header key-value pairs as per your API requirements.

Set request body (if required): If your API expects a request body (for POST or PUT requests), you can provide the necessary data in the "Body" section of Postman. Select the appropriate data format (JSON, XML, form data, etc.) and enter the payload accordingly.

Send the request: Once you have set up the request URL, headers, and body (if applicable), click the "Send" button in Postman to send the request to your Spring Boot application.

View the response: Postman will display the response received from the API in the "Response" section. You can examine the response status code, headers, and body to verify the behavior of your API.
