# DragonStack E2E Automation

This project contains an **end-to-end (E2E) automation test** for the DragonStack application, designed with clear boundaries and real-world automation principles.

---

## 🎯 What this E2E test proves

This test validates the **core user lifecycle**:

1. User is authenticated via backend API
2. An authenticated user can create a dragon
3. The created dragon is rendered correctly in the UI

If this test passes, we are confident that **authentication, backend logic, and UI rendering work together end to end**.

---

## 🔑 Why backend authentication is used

Instead of logging in via the UI, this test:
- Calls the backend `/account/login` API directly
- Extracts the session cookie (`sessionString`)
- Injects the cookie into the browser

### Benefits:
- Faster and more reliable tests
- No dependency on UI login flakiness
- Authentication logic is still fully validated
- Mirrors how browsers actually manage sessions

This keeps the test **true E2E**, not a mocked or shortcut flow.

---

## 🧱 Design principles followed

- **Single BaseTest** for WebDriver lifecycle
- **Explicit navigation** inside tests (no hidden behavior)
- **Clear separation of concerns**:
  - API logic → helpers
  - UI interactions → Page Objects
  - Assertions → Tests
- No shared state between tests
- No test dependency on execution order

---

## ✅ What is intentionally NOT tested here

- UI login form behavior (covered in separate tests)
- Logout behavior (treated as cleanup, not core business validation)
- Edge cases and negative scenarios

This test focuses on **one strong business truth**, not everything at once.

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Apache HttpClient
- Maven

---

## 🚀 How this test is intended to run

- Locally during development
- In CI pipelines (e.g., Jenkins)
- Deterministically, without test data pollution

---
