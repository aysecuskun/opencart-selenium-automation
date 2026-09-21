# OpenCart Selenium Automation

## Project Overview

This project is a Selenium WebDriver automation framework developed using Java, Maven, and TestNG.

The main goal of this project is to automate critical user flows of the OpenCart e-commerce application and demonstrate a maintainable test automation structure using the Page Object Model (POM).

The automation coverage was developed incrementally, starting with authentication and product-related scenarios and progressing through basket, checkout, and order flows.

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
├── pages
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── SearchPage.java
│   ├── ProductPage.java
│   ├── BasketPage.java
│   └── CheckoutPage.java
│
├── testBase
│   └── BaseClass.java
│
└── testCases
    ├── LoginTest.java
    ├── SearchTest.java
    ├── ProductTest.java
    ├── CartTest.java
    └── CheckoutTest.java
```

---

## Test Scope

### Authentication

* Login positive and negative scenarios

### Product & Search

* Product search scenarios
* Product details validation
* Product price and image validation
* Add product to basket
* Successful add-to-basket message validation

### Basket

* Product validation
* Quantity validation
* Quantity update
* Product removal
* Basket total validation
* Empty basket validation

### Checkout

* Checkout page validation
* Shipping address validation
* Required field validation
* Shipping method validation
* Payment method validation
* Negative checkout scenarios

### Order

* End-to-end checkout flow
* Order completion validation

---

## Test Classification

### Smoke Tests

Smoke tests cover the main critical functionalities of the application:

* Login
* Product Search
* Product Details
* Add to Basket
* Basket Access
* Checkout
* Order Completion

### Regression Tests

Regression coverage includes:

* Login positive and negative scenarios
* Search scenarios
* Product validation
* Basket operations
* Checkout validation scenarios
* Order flow

---

## TestNG

The project uses TestNG features such as:

* `@Test`
* `@BeforeMethod`
* `@AfterMethod`
* `@DataProvider`
* Test Groups
* TestNG XML
* Parallel Test Execution

---

## Automation Approach

The Page Object Model is used to separate page elements and page actions from test cases.

Page-specific locators and actions are maintained inside dedicated page classes, while test classes are responsible for executing scenarios and validating expected results.

Test data is handled using TestNG `DataProvider` where appropriate, allowing the same test scenario to be executed with different input values.

The framework also uses Selenium synchronization techniques and browser interaction methods to handle dynamic elements and page transitions.

---

## Test Data

Test scenarios and test data are maintained using Excel during the test design process.

The Excel scenarios are used as a reference for organizing and implementing the automated test cases.

---

## End-to-End Automation Flow

The project covers the following main e-commerce flow:

```text
Login
  ↓
Search Product
  ↓
Product Details
  ↓
Add to Basket
  ↓
Basket
  ↓
Checkout
  ↓
Shipping Address
  ↓
Shipping Method
  ↓
Payment Method
  ↓
Order Completion
```

---

## Project Status

✅ Core automation flow completed from login to order completion.

The project currently includes positive and negative functional scenarios across authentication, search, product, basket, and checkout functionalities.

The framework will continue to be improved with additional automation concepts, reporting, CI/CD integration, API testing, and other practices as the project evolves.
