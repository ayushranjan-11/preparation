# Project Guidelines

## Project Overview

This is a Selenium automation testing project using the **Page Object Model (POM)** pattern with Page Factory for web UI test automation. The codebase also includes interview preparation and algorithm practice code.

## Code Organization

### Class Hierarchy & Structure

**Foundation Layer**
- **[BaseDriver](../src/test/java/base/BaseDriver.java)** (`package base`): Base class for all test classes
  - Initializes WebDriver (Chrome), WebDriverWait (30s timeout), and browser utilities
  - Provides constructors: default constructor and one accepting ChromeOptions
  - Methods: `resizeBrowser()`, `getDriver()`, `closeBrowser()` 
  - All test classes **must extend BaseDriver**

**Page Object Layer**
- **Page Classes** (`package pomAndPageFactory`): Encapsulate page elements and actions
  - [LoginPage](../src/main/java/pomAndPageFactory/LoginPage.java) example: Uses Selenium `@FindBy` annotations on WebElements
  - Constructor takes `WebDriver` and calls `PageFactory.initElements(webDriver, this)`
  - Provide getter methods returning WebElements (no assertions in page objects)

**Test Layer**
- **Test Classes** (e.g., [LoginPagePageFactory](../src/test/java/pomAndPageFactory/LoginPagePageFactory.java)): Extend BaseDriver
  - Use `@Test` annotations with `priority` attribute for test ordering
  - Use `@AfterClass` for cleanup (override parent's `closeBrowser()`)
  - Instantiate page objects inside test methods
  - Contain test logic and assertions

**Utilities & Helpers**
- **[BrowserSetup](../src/test/java/seleniumCodes/BrowserSetup.java)**: Standalone browser initialization (used for simpler test scenarios)
- **Interview/Algorithm Classes**: Separate packages (`InterviewQuestionsPractise`, `seleniumCodes`) for learning exercises

### Package Structure

```
src/main/java/pomAndPageFactory/         # Page objects
src/test/java/
  ├── base/                               # BaseDriver
  ├── pomAndPageFactory/                  # Test classes for POM
  ├── seleniumCodes/                      # Selenium technique samples
  ├── InterviewQuestionsPractise/          # Algorithm & coding problems
  └── SeleniumWIthTestNG/                 # TestNG-specific patterns
src/test/resources/                       # Config files & test data
  ├── pomAndpageFactory.properties         # URL, credentials
  └── testngPomAndPageFactory.xml          # TestNG suite config
```

## Architecture & Design Patterns

**Page Object Model (POM)**
- Each webpage → one Page class in `src/main/java`
- Web elements → captured as `@FindBy` annotated private WebElements
- User interactions → public methods (e.g., `username.sendKeys()`, `loginCTA.click()`)
- Returned WebElements allow tests to chain actions and assertions

**Page Factory Pattern**
- Uses Selenium's `PageFactory.initElements(driver, pageClass)` for lazy element location
- Page constructors always: accept WebDriver, call PageFactory.initElements

**Inheritance Pattern**
- All tests extend `BaseDriver` to inherit driver and wait utilities
- Eliminates duplication of driver initialization and cleanup

**Configuration Management**
- Use `.properties` files (referenced in BaseDriver) for URLs, credentials, timeouts
- Load via `FileInputStream` in test methods

## Build and Test

**Build**
```bash
mvn clean compile
```

**Run All Tests**
```bash
mvn clean test
```

**Run Specific Test Class**
```bash
mvn test -Dtest=LoginPagePageFactory
```

**Run Tests via TestNG XML Config**
```bash
mvn test -Dsuite=testngPomAndPageFactory.xml
```

**Key Maven Properties**
- Java version: 23
- Source encoding: UTF-8
- Dependencies: Selenium 4.34.0, TestNG 7.11.0, commons-io 2.19.0

## Conventions

### Class Naming & Location

| Class Type | Package | Example | Location |
|---|---|---|---|
| Page Object (POM) | `pomAndPageFactory` | `LoginPage` | `src/main/java/pomAndPageFactory/` |
| Test Class | `pomAndPageFactory` | `LoginPagePageFactory` | `src/test/java/pomAndPageFactory/` |
| Base Driver | `base` | `BaseDriver` | `src/test/java/base/` |
| Utilities | `seleniumCodes` | `BrowserSetup` | `src/test/java/seleniumCodes/` |

### Test Method Annotations

- **`@Test(priority = X)`**: Order test execution; lower numbers run first
- **`@AfterClass`**: Cleanup (driver.quit()); override BaseDriver method if needed

### Waiting & Synchronization

- Use `WebDriverWait` from BaseDriver (30-second default)
- Apply conditions: `ExpectedConditions.visibilityOf(element)`, `presenceOfElementLocated()`, etc.

### Element Location Strategy

Preferred order:
1. `id` attributes (most stable)
2. `name` attributes
3. `xpath` (when uniqueness requires it)
4. `tagName` (less specific, use with caution)

### Configuration Files

- **Location**: `src/test/resources/`
- **Format**: `.properties` key-value pairs (e.g., `url=https://...`, `username=user`)
- **Access**: Load via `FileInputStream` and `Properties.load()` in test

## Related Documentation

- **Selenium Documentation**: [Official Selenium Docs](https://www.selenium.dev/documentation/)  
- **Page Factory Pattern**: See Selenium support for PageFactory

## Common Gotchas

1. **Base class initialization**: Tests extending BaseDriver get WebDriver and WebDriverWait automatically; don't re-initialize in tests
2. **PageFactory setup**: Must call `PageFactory.initElements(driver, this)` in every page object constructor
3. **Element visibility**: Use `WebDriverWait` with `ExpectedConditions` to handle dynamic elements before interacting
4. **Properties file paths**: Use `System.getProperty("user.dir")` for cross-platform path resolution
