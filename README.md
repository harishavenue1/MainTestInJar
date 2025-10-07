# MainTestInJar - Test Execution Guide

A Java project with Selenium UI tests and REST API tests using TestNG framework.

## Project Structure
```
├── src/main/java/org/example/
│   ├── App.java                    # Main application
│   ├── Calculator.java             # Utility class
│   ├── StringUtils.java            # String utilities
│   ├── pages/GoogleSearchPage.java # Selenium Page Object
│   └── api/JsonPlaceholderAPI.java # REST API client
├── src/test/java/org/example/
│   ├── TestRunner.java             # Test suite runner
│   ├── GoogleSearchUITest.java     # Selenium UI tests
│   └── JsonPlaceholderAPITest.java # REST API tests
├── testng.xml                      # All tests suite
├── testng-ui.xml                   # UI tests only
└── testng-api.xml                  # API tests only
```

## Build Project
```bash
# Build JARs and copy dependencies
mvn clean package -DskipTests
```

## Run Tests with Maven

### All Tests
```bash
mvn test
```

### By Test Groups
```bash
# Groups don't work reliably with TestNG XML files
# Use TestNG XML files or Maven profiles instead (see below)
```

### By TestNG XML Files
```bash
# All tests (default)
mvn test

# API tests only
mvn test -DsuiteXmlFile=testng-api.xml

# UI tests only
mvn test -DsuiteXmlFile=testng-ui.xml
```

### By Maven Profiles
```bash
# API tests only
mvn test -Papi-tests

# UI tests only
mvn test -Pui-tests
```

### Specific Test Classes/Methods
```bash
# Single test class
mvn test -Dtest=JsonPlaceholderAPITest

# Single test method
mvn test -Dtest=JsonPlaceholderAPITest#testGetAllPosts

# Multiple test classes
mvn test -Dtest=JsonPlaceholderAPITest,GoogleSearchUITest
```

## Run Tests from JAR

### Build First
```bash
mvn clean package -DskipTests
```

### Execute Tests from JAR
```bash
# All tests
java -cp "target/MainTestInJar-1.0-SNAPSHOT.jar:target/MainTestInJar-1.0-SNAPSHOT-tests.jar:target/lib/*" org.example.TestRunner all

# API tests only
java -cp "target/MainTestInJar-1.0-SNAPSHOT.jar:target/MainTestInJar-1.0-SNAPSHOT-tests.jar:target/lib/*" org.example.TestRunner api

# UI tests only
java -cp "target/MainTestInJar-1.0-SNAPSHOT.jar:target/MainTestInJar-1.0-SNAPSHOT-tests.jar:target/lib/*" org.example.TestRunner ui
```

## Run Main Application
```bash
# Run main application
java -jar target/MainTestInJar-1.0-SNAPSHOT.jar
```

## Test Configuration

### Parallel Execution
Tests run in parallel with 4 threads (configured in testng.xml):
```xml
<suite name="MainTestInJar Test Suite" parallel="methods" thread-count="4"/>
```

### Test Groups
- **api**: REST API tests using JsonPlaceholder
- **ui**: Selenium WebDriver tests using Google Search

## Dependencies
- **TestNG 7.8.0**: Test framework
- **Selenium 4.15.0**: UI automation
- **REST Assured 5.3.2**: API testing
- **WebDriverManager 5.6.2**: Automatic driver management

## Notes
- UI tests run in headless Chrome by default
- API tests use JSONPlaceholder (https://jsonplaceholder.typicode.com)
- All TestNG XML files are included in the main JAR
- Dependencies are kept separate in lib/ directory for easier management