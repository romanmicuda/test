# test

Fork this repo and solve the test

# fruits/vegetables
https://github.com/utegsk/test/blob/main/test1.md


### Running the Application

1. **Package the Application**:
   Build your application:

   ```bash
   ./mvn clean package
   ```

2. **Run the Application**:
   To print the products:
   
   ```bash
   java -jar target\myapp-0.0.1-SNAPSHOT.jar print src\main\resources\products.json
   ```

   To find the maximum value:
   ```bash
   java -jar target\myapp-0.0.1-SNAPSHOT.jar findMax src\main\resources\products.json
   ```

### Running the Tests

```bash
mvn test
```