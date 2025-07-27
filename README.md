# Sample-test

This is a sample java test project provides the analysis of employees of the org interms of Salary and level order.

# Assumptions
- This app expected the well formatted csv, a sample mentioned at - `src\main\resources\employee.csv`
## Project Structure

```
sample-test
├── src
│   ├── main
│   │   └── java\bigcompany
│   │       └── App.java ..
│   └── test
│       └── java\bigcompany
│           └── AppTest.java ..
├── pom.xml
└── README.md
```

## Getting Started

To build and run this project, you need to have Maven installed on your machine. Follow the steps below to get started.

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed

### Building the Project

1. Open a terminal and navigate to the project directory:
   ```
   cd sample-test
   ```

2. Run the following command to build the project:
   ```
   mvn clean install
   ```

### Running Tests

To run the unit tests, use the following command:
```
mvn test
```

### Running the Application

After building the project, you can run the application using the following command:

```
   java -jar target/sample-test-1.0-SNAPSHOT-jar-with-dependencies.jar src\main\resources\employee.csv
```

