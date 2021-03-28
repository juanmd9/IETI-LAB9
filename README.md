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
