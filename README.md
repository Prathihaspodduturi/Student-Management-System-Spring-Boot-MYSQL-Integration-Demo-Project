# Student-Management-System-Spring-Boot-MYSQL-Integration-Demo-Project

# Overview
This project, titled "Student Management System," demonstrates a practical implementation of CRUD (Create, Read, Update, Delete) operations using Java's Spring Boot framework in conjunction with a MySQL database. It's designed as a straightforward, user-friendly system for managing student data.

# Features
- CRUD Operations: Create, read, update, and delete student records in a MySQL database.
- Search Functionality: Ability to search for students
- Batch Processing: Support for handling multiple student records simultaneously.
- Efficient Database Interaction: Utilizes JPA (Java Persistence API) for optimized database transactions.
- Logging and Debugging: Configured logging for SQL statements and Hibernate operations, aiding in debugging and monitoring.

# File Description
starter-sql-scripts has two files
- create-user-sql : for creating a user and granting all permission to the user
- student-tracker-sql : for creating table Student

# Technologies Used
- Spring Boot: For the overall framework, providing a range of functionalities including the web server, data handling, and more.
- MySQL: Used as the database for storing student information.
- Hibernate: As an ORM tool for efficient database operations.
- Maven: For project management and dependencies.
- Jakarta Persistence (JPA): For database interaction.

# Setup and Installation

1. Database Setup:
   - Ensure MySQL is installed and running on your system.
   - Run the scripts provided in the sql.
   - Update the application.properties file with your MySQL username and password for establishing connectiion between Database and Spring Boot.

2. Running the Application:
   - Clone the repository to your local machine.
   - Open the project in IntelliJ or Eclipse or any IDE.
   - Run CurddemoApplication.java to start the application.

# Usage
- The application performs various operations on the 'student' table in the MySQL database.
- Operations include adding new student records, updating existing records, retrieving student information, and deleting records.
- Logging is set up to monitor SQL and Hibernate operations for easy tracking and debugging.
