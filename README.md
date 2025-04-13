# 🚀 LambdaTest Automation Framework

This is a robust Test Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Extent Reports**. It supports both **local execution** and **cloud-based execution** on [LambdaTest](https://www.lambdatest.com/), a cross-browser testing platform.

## 📦 Tech Stack

- Java 11+
- Selenium 4
- TestNG
- Extent Reports (with Base64 screenshots)
- Allure Reports (optional)
- Maven
- LambdaTest Integration
- Log4j2 for logging
- Dotenv for config management

---

## ✅ Features

- 🌐 Run tests locally or on LambdaTest via `RUN_MODE` config
- 📸 Screenshots (Base64) attached on each log step in Extent Reports
- 🌗 Dark-themed, elegant Extent HTML reports
- 📊 Optional Allure reporting support
- 🚫 Handles alerts gracefully and skips screenshots when alerts are active
- 🔐 Secure credentials using `.env`
- 🧪 Test lifecycle managed via TestNG annotations (`@BeforeMethod`, `@AfterMethod`, etc.)

---
