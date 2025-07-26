# My Maven Java Project

This is a simple Maven Java project that demonstrates the basic structure and functionality of a Maven application.

## Project Structure

```
sample-test
├── src
│   ├── main
│   │   └── java
│   │       └── App.java
│   └── test
│       └── java
│           └── AppTest.java
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

### Running the Application

After building the project, you can run the application using the following command:
```
mvn exec:java -Dexec.mainClass="App"
```

### Running Tests

To run the unit tests, use the following command:
```
mvn test
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.