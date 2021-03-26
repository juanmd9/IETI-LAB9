# 2.3 JPA with MongoDB

## Part 1: Basic Mongo DB configuration and Spring Boot Integration

6. Run the project and verify that the connection to the database works properly. Answer the following questions:

- How many customers were created in the database?
  

R:/ One.
- Where is the *findAll* method implemented?
  

R:/ Is implemented in the MongoRepository.
- Suppose you have more than 1000 products in your database. How would you implement a method for supporting pagination and return pages of 50 products to your frontend?


R:/ Having this 'PageRequest.of(0, 2))', I'll replace the 0 for 'variable-1' which is sent from the front and the 2 for a 50, so it'll looks like 'PageRequest.of(variable-1, 50))'.
- How many products contain the "plus" word in their description?


R:/ Four.
- How many products are returned by the *findByDescriptionContaining* query? Why?


R:/ Two, because the PageRequest is requiring than any page have just two items.
- Which are the collection names where the objects are stored? Where are those names assigned?


R:/ In the models than have the @Document, so the collection takes the name of the class.


## Part 2: Custom configuration and Queries

5. Read some of the documentation about queries in Spring Data MongoDB:
 
    * https://www.baeldung.com/queries-in-spring-data-mongodb
    * https://www.mkyong.com/mongodb/spring-data-mongodb-query-document/

6. In the *Application* class create mocked data for 25 Todos and 10 different users (make sure the Todos have different dueDates and responsible)

7. Create the following queries using the Query class:

    * Todos where the dueDate has expired
    * Todos that are assigned to given user and have priority greater equal to 5
    * Users that have assigned more than 2 Todos.
    * Todos that contains a description with a length greater than 30 characters        

8. Implement the queries of the previous step using *derived query methods* in your repository interface. Is it possible to implement all of them?
