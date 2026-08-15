# SDET Practice Project

A self-directed practice project covering UI test automation, API testing, and CI/CD — built to strengthen hands-on skills for SDET/QA Automation roles.

## Tools used
- **Java + Selenium WebDriver + JUnit 5** — automated UI tests (login form validation, dropdown selection)
- **Postman** — API test collection with assertions (GET request, status code and response body validation)
- **Git & GitHub** — version control
- **GitHub Actions** — CI pipeline that runs tests automatically on every push

## Project structure
- `src/test/java/LoginFormTest.java` — validates login success and failure flows
- `src/test/java/DropdownTest.java` — validates dropdown selection behavior
- `ReqRes-API-Tests.postman_collection.json` — Postman collection for API testing
- `.github/workflows/test.yml` — CI workflow configuration

## How to run
1. Clone the repo
2. Open in IntelliJ IDEA (Maven dependencies resolve automatically)
3. Run tests via `mvn test`, or directly from the IDE

## Author
Jagan Thammishetti