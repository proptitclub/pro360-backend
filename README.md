# Pro360

# Pro360 Backend

## Introduction


Pro360 Backend is a backend system for Pro360

## Get started


### Tech stack

- Spring (Backend framework)
- Liquibase (manage database changelog)
- Postgresql (Database)

### Architecture

Project includes layers:

- Application
- Service
- Repository
- Entity

Project includes module:

- Core (core class, common utils,...)
- Domain (service and repository)
- Application (Spring Boot application with context, config, filter,...)

## Development


### Entity

### Repository

### Service

Implements the business logic of the current module.

Input is a Command. (ex: CreateNewUserCommand,...)

### Application

- Controller: call business from Service to execute user request
- DTO: request & response of controller

### Workflow (with IntelliJ IDEA & JPA Buddy)

- Create new domain module
- Define Entity
- Implement Service
- Create new Persistence Unit, which only contains entity of your module
- Generate change log from above Persistence Unit
- Import module into application