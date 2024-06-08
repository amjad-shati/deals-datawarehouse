# deals-datawarehouse

This is a Spring boot application that saves Deal records and offers retrieval by deal ID or by the creation date.

# Setup
- perform "mvn clean install" on the projects' root folder "deals-datawarehouse"
- perform "docker-compose up" on the sub-module "deals-datawarehouse-api", this will run Postgresql on a separate docker container
- you can start the Application then by command line or by the IDE, doesn't make a difference

# Swagger
- Here's the swagger documentation link that you can access after running the application: http://localhost:8080/deals-datawarehouse/swagger-ui/index.html#/