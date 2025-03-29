# WindVault

WindVault is a lightweight and efficient note-taking application built with Spring Boot. It provides a structured way to create, store, and manage notes and provides authentication and authorisation.

## Features
- Create, update, delete, and view notes
- User authentication and authorization
- RESTful API implementation
- Frontend with HTML, CSS, and JavaScript
- Spring Data JPA for database interactions
- MVC pattern for better code organization

## Project Structure
```
WindVault/
│── src/
│   ├── main/java/com/note/app/
│   │   ├── config/            # Application configurations
│   │   ├── controller/        # REST controllers
│   │   ├── dto/               # Data Transfer Objects
│   │   ├── mapper/            # Mapper classes
│   │   ├── model/             # Entity models
│   │   ├── repo/              # Repository interfaces
│   │   ├── service/           # Business logic
│   │   ├── security/          # Authentication and authorization logic
│   ├── main/resources/
│   │   ├── static/css/        # Stylesheets
│   │   ├── static/js/         # JavaScript files
│   │   ├── templates/         # HTML templates
│   │   ├── application.properties  # Configuration file
│── pom.xml                    # Maven dependencies
│── mvnw, mvnw.cmd             # Maven wrapper scripts
│── .gitignore                 # Git ignore rules
```

## Installation & Running
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/WindVault.git
   ```
2. Navigate into the project directory:
   ```sh
   cd WindVault
   ```
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```
5. Open your browser and visit `http://localhost:8080`

## Authentication
WindVault implements authentication using Spring Security with JWT. Users need to register and authenticate to access secured endpoints.

## Technologies Used
- Java & Spring Boot
- Spring Security & JWT
- Spring Data JPA
- Maven
- HTML, CSS, JavaScript
- H2 / MySQL (Configurable)

## Contributing
Pull requests are welcome. Please open an issue first to discuss any major changes.
