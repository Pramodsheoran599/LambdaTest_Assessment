# 🚀 LambdaTest Automation Framework

This is a robust Test Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Extent Reports**. It supports both **local execution** and **cloud-based execution** on [LambdaTest](https://www.lambdatest.com/), a cross-browser testing platform.

## 📦 Tech Stack

- Java 11+
- Selenium 4
- TestNG
- Extent Reports (with Base64 screenshots)
- Maven
- LambdaTest Integration
- Dotenv for config management

---

## ✅ Features

- 🌐 Run tests locally or on LambdaTest via `RUN_MODE` config
- 📸 Screenshots (Base64) attached on each log step in Extent Reports
- 🌗 Dark-themed, elegant Extent HTML reports
- 🚫 Handles alerts gracefully and skips screenshots when alerts are active
- 🔐 Secure credentials using `.env`
- 🧪 Test lifecycle managed via TestNG annotations (`@BeforeMethod`, `@AfterMethod`, etc.)

---

## 🧹 Thought Process Behind the Framework

This framework was built with scalability, readability, and maintainability in mind. Here's a breakdown of the thought process:

- 🏃 **Modular Design**: Followed a layered architecture to separate concerns like WebDriver setup, utilities, test logic, and reporting.
- ⚖️ **Flexible Execution**: Added support to toggle between local and cloud (LambdaTest) execution via environment variables for seamless CI/CD integration.
- 📢 **Enhanced Reporting**: Integrated ExtentSparkReporter to generate visually rich reports with embedded screenshots for better debugging and traceability.
- 🪟 **Smart Logging**: Each step is logged with screenshots (Base64 encoded) to ensure a complete audit trail of the test.
- 🛎 **Environment Security**: Used `.env` files to keep credentials and environment-specific data secure and configurable.
- 🔄 **Reusability**: Utility classes like `CommonUtils`, `ExtentManager`, and `LambdaTestManager` were created to promote reusability and reduce code duplication.

### 🔧 Custom Framework Design Rationale

For this assessment, I chose to build a custom framework design instead of following the standard PageFactory model.

The PageFactory model has three major limitations in my opinion:

1. **Lack of flexibility with dynamic locators**: It's challenging to define XPath or CSS selectors that adapt to dynamic text or element structure within PageFactory.
2. **Tight coupling of locators and logic**: PageFactory binds WebElements directly to page classes, which hinders test readability and maintainability when the UI changes.
3. **Redunt Page object creation**: Need to create Page Objects inside every test class.
   
In contrast, my design separates **Page Locators** and their **Utility Functions**, and creates their objects in BaseTest enabling a cleaner abstraction. This makes it easier to handle dynamic components and improves the overall modularity of the codebase.

This architecture lays a strong foundation for building advanced testing features such as:

- Test categorization
- Data-driven and parameterized testing
- Third-party integrations like TestRail, Slack, etc.
 
---

## 📁 Project Structure

```
├── base/                 # BaseTest class for setup & teardown
├── PageObjects           # Classes containing just the page locators and nothing else.
├── ApplicationUtils      # Application specific methods like login page methods etc.
├── CommonUtils/          # Framework specific Util files
├── Listeners/            # Listener Files for execution flow
├── Constants/            # Can contain framework or Page level Constants
├── .env                  # Secure environment config
├── resources/testng.xml  # TestNG suite configuration
└── pom.xml               # Maven dependencies

```

## 🚀 Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/your-username/lambdatest-automation-framework.git
cd lambdatest
```

### 2. Add environment variables

Create a `.env` file in the root directory:

```dotenv
LT_USERNAME=your-lambdatest-username
LT_ACCESS_KEY=your-lambdatest-access-key
RUN_MODE=lambdatest   # or 'local'
APP_USERNAME=application_username
APP_PASSWORD=application_password

```

**ℹ️ .env Setup Tip**: Make sure to include the `.env` file at the root level of the project. It should not be committed to version control. Add sensitive or environment-specific config here for seamless integration.

---


