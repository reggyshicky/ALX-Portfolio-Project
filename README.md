# Expense Tracker API

The Expense Tracker API is a robust backend system designed to facilitate efficient management of expenses. 
It provides a range of features including adding, updating, deleting, and filtering expenses by various 
criteria such as category, keyword, and date. Built with cutting-edge technologies like Spring Boot, Spring Security, 
and relational databases like MySQL and PostgreSQL, this API ensures high performance, reliability, and security for 
effective expense management.
## Getting Started

To get a copy of the project up and running on your local machine for development and testing purposes, follow these steps:
1. Clone the Repository:
   git clone https://github.com/reggyshicky/ALX-Portfolio-Project.git
2. Navigate to the Project Directory:
   cd expense-tracker-api
3. Set Up the Database:
   Create a MySQL or MariaDB database for development.
   Update the database configurations in application.properties file.
4. Build and Run the Application:
   ./mvnw spring-boot:run
5. Access the API Documentation:
   Once the application is running, access the Swagger UI documentation at:
   `[http://localhost:8080/api/v1/swagger-ui.html](http://localhost:8080/api/v1/swagger-ui/index.html#/)`
6. Explore and Test the APIs:
   Use tools like Postman to explore and test the available APIs.

### Prerequisites

Before you begin, ensure you have met the following requirements:

Java Development Kit (JDK): Install JDK version 8 or above. You can download it from Oracle's website or use a package manager like Homebrew (for macOS) or Chocolatey (for Windows).
brew install openjdk@11

Apache Maven: Maven is a build automation tool used primarily for Java projects. You can download it from the Apache Maven website or use a package manager.
brew install maven
MySQL or MariaDB: Install either MySQL or MariaDB database server for development. You can download MySQL from the MySQL website or install MariaDB using a package manager.
brew install mariadb

Git: Install Git to clone the project repository and manage version control.
brew install git

Integrated Development Environment (IDE): Choose an IDE of your preference for Java development. Some popular options include IntelliJ IDEA, Eclipse, and NetBeans.
Once you have installed these prerequisites, you are ready to proceed with setting up and running the project.

## Deployment

To deploy the Expense API project on a live system, follow these steps:
Prepare your production environment:
Ensure you have a production-ready server or cloud platform (e.g., AWS, Azure, Google Cloud Platform) configured and accessible.
Set up a production database instance, preferably using PostgreSQL, and configure the database connection properties in the application.properties file accordingly.

Build the project:
Make sure to build the project using Maven to generate the deployable artifact.
mvn clean install
Prepare the application for deployment:
Copy the generated JAR file (usually located in the target directory) to your production server or cloud platform.

Run the application:
Execute the JAR file on your production server or cloud platform to start the application.
java -jar expense-api.jar
Access the deployed application:
Once the application is running, you can access it using the appropriate URL provided by your server or cloud platform.

## Built With

Spring Boot - The web framework used for building Java-based applications and microservices. 
Spring Security - Provides authentication and authorization support within the Spring framework. 
PostgreSQL - An open-source relational database management system (RDBMS) used for storing and managing data in production environments. 
MariaDB - An open-source RDBMS used for devel opment and testing environments. 
Postman - A popular API testing tool used for testing APIs during development. 
Swagger UI - A tool for API documentation, used to create comprehensive and user-friendly API documentation for your Expense API project.

## Contributing

We welcome contributions to the Expense API project! Please follow these guidelines when contributing:

Fork the repository and clone it locally.
Create a new branch for your feature or bug fix.
Make your changes and ensure that the code passes all tests.
Commit your changes with clear and descriptive commit messages.
Push your changes to your forked repository.
Submit a pull request to the main repository, explaining the changes you've made.
By contributing to this project, you agree to abide by our code of conduct and contribute in a respectful manner.

## Authors

* **Priscah Reginah Shikanda** - *Developer* - [http://localhost:8080/api/v1/swagger-ui.html](http://localhost:8080/api/v1/swagger-ui/index.html#/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

