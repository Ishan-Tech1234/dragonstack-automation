# DragonStack Automation Testing

## Overview
This project contains UI automation tests for the DragonStack web application.
It validates critical authentication workflows using Selenium WebDriver
against a React-based single-page application (SPA).

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven

## Test Coverage
- End-to-end identity lifecycle:
    - User signup
    - Post-signup validation
    - Logout
    - Login with the same credentials
    - Logout validation
- UI-based authentication state verification

## Automation Design
- Page Object Model (POM) for test maintainability
- Explicit waits for handling dynamic React rendering
- Dynamic test data generation to avoid environment dependency
- Clear separation between test logic and page interactions

## Locator Strategy
- XPath locators used due to absence of test-specific attributes
  (e.g., data-testid) in the application
- Preference given to semantic attributes (placeholder, text)
  over index-based paths wherever possible
- Locator limitations documented and handled via explicit synchronization

## How to Run
1. Clone the repository
2. Start the DragonStack application locally
3. Execute tests using:
   ```bash
   mvn test
