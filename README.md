# OpenCart Selenium Automation

## Project Overview

This project is a Selenium WebDriver automation framework developed using Java, Maven, and TestNG.

The main goal of this project is to automate critical user flows of the OpenCart e-commerce application and demonstrate a maintainable test automation structure using the Page Object Model (POM).

The project will be developed incrementally, starting with core functional scenarios and expanding to different Selenium and TestNG concepts.

---

## Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Git & GitHub
* Eclipse IDE

---

## Project Structure

```text
src/test/java
│
├── pageObjects
│   ├── LoginPage.java
│   ├── HomePage.java
│   ├── SearchPage.java
│   ├── ProductPage.java
│   └── CartPage.java
│
├── testBase
│   └── BaseClass.java
│
└── testCases
    ├── LoginTest.java
    ├── SearchTest.java
    ├── ProductTest.java
    └── CartTest.java
```

---

## Test Scope

### Login

* Valid login
* Invalid password
* Invalid email
* Empty password
* Empty email

### Search

* Search for an existing product
* Search for a non-existing product
* Search with an empty value

### Product

* Product details validation
* Add product to cart

### Cart

* Verify product in cart
* Validate product quantity
* Update product quantity
* Remove product from cart

---

## Test Classification

### Smoke Tests

Smoke tests will cover the critical functionalities of the application:

* Login
* Product Search
* Product Details
* Add to Cart
* Cart Access

### Regression Tests

Regression tests will cover a broader range of functional scenarios:

* Login positive and negative scenarios
* Search scenarios
* Product validation
* Cart operations
* Wishlist
* Checkout

---

## TestNG

The project will use TestNG features such as:

* `@Test`
* `@BeforeMethod`
* `@AfterMethod`
* `@DataProvider`
* Test Groups
* TestNG XML
* Parallel Test Execution

---

## Automation Approach

The Page Object Model will be used to separate page elements and actions from test cases.

Test data will be handled using TestNG DataProvider where appropriate, allowing the same test scenario to be executed with different input values.

The framework will also use appropriate Selenium synchronization techniques such as explicit waits for dynamic elements.

---

## Project Status

🚧 Project is currently under development.

The framework and test coverage will be expanded progressively as new Selenium and TestNG concepts are implemented.
