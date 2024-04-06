# Food Order Web App

## Overview
The Food Order App is a web application built using Java 17, Spring Boot MVC with PostgreSQL as the database. This Web App can Manage Multiple Restaurants from the Admin Side and Restaurant users can manage their Restaurants, orders, and offers.

## Features

### Admin
- Manage City
- Manage Area
- Manage Category
- Manage Sub-Category
- Manage Restaurants
- Manage Offers
- CRUD Operations for all above modules
- Download Reports for all the Above Modules
- Manage Complaints (Not Working Currently)
- Manage Feedback (Not Working Currently)

### Restaurants
- Manage Products
- Manage Offers
- Manage Orders (Not Working Currently)
- Manage Complaints (Not Working Currently)

## Technologies Used
- Java 17
- Spring Boot
- PostgreSQL

## Steps for Installation
1. Unzip Project
2. Open Project in IntelliJ IDEA
3. Open pgAdmin 4, Create a new Database
4. Go to `src/main/resources/application.properties`
5. Edit with created database URL, username, and password
6. Run the Project, App will open at [http://localhost:8080/](http://localhost:8080/)

## Predefined User Credentials
- **Admin**:
  - Email: admin@gmail.com
  - Password: Sttl@1234

## Usage
1. Admin can Manage Restaurants City and Area-wise.
2. Restaurants can Register and Log in using their credentials.
3. Restaurants can manage orders and products.
4. Admin and Restaurants can Download Reports.
