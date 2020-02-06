This application will walk through Spring Boot REST + Angular + JPA + Hibernate + MySQL CRUD example. 
We will create a REST web service application using Spring Boot and a client application using Angular.
REST web service will expose methods for create, read, update and delete operation. The Angular application will use Angular Http API
for CRUD operation. If our client application is running on different domain from web service domain, then the Spring Boot web
service controller will configure client domain URL using @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS).
Angular application will be single page application that will perform CRUD operation.
On the basis of REST web service response HTTP status code, the Angular application will display messages for
success and failure of CRUD operation. In our REST web service application we will expose two methods for read operation, one for fetching data by id and another for fetching all data. In our example we will perform CRUD operation on addressbook. When we create record, the record id will be automatically generated by database. To fetch and delete record by id, we will use request parameter to pass record id from client to REST web service application. In our Spring Boot application, we will configure database using application.properties file. To interact with database we will use JPA EntityManager.