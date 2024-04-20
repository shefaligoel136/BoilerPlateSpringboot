### Things to take care during MC round

- understand the problem statement
- ask followup questions to understand the problem statement better
- check if there are test cases given to help you understand the problem better
- talk about expectations around concurrency and multi threading
- see if there is a possibility of multi-threading in any part, which you may have missed - clear the expectations around the same.

### Abstraction , Entity Model , DTO and Validation
1. create entity models. Make sure to use ENUMS.
2. add getter setter and allArgsConstruct and NoArgsConstruct and Builder annotations
3. see potential of adding javax validations. if time constraints create the stubs to implement towards the end of the interview
4. create the DAO / DTO / Repository to play with DB / InMemory

### Interface , Service Module , Implementation Structure
1. After grasp on entity model, create Resources/Controller
2. This will help you create Request-Response Model
3. Create API Signature for each use-case
4. Create Service classes as required. Each group of use-case becomes a service.
5. Create interface of a service and implement it

### Business Logic , Utility Methods , Strategy Selection (if required)
1. Till now only bare bones was developed. Now comes the actual coding
2. quickly create Utility methods which would hold the business logic. This can be static classes as well, just doing transformation
3. DB queries and its implementation will happen now. Create SQL entity if not already done
4. start integrating it all up. Service methods should be minimalistic calling various other methods
5. In case if it requires add transactional annotation.
6. Transactional helps in handling concurrency by default if done properly
7. add synchronized to any method needing synchronization
8. for parallel programming, use ExecutorService / .parallelStream() with lambda
9. Handle exception where feels necessary. Better to create individual Exception class for better presentation

### Driver Class / Testing
1. Create main class / postman collection to test API with dummy data
2. Ensure to reuse postman history to your advantage
3. 