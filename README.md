# 💸 SpendLytic – Expense Tracker

SpendLytic is a smart expense tracker with a built-in budgeting assistant powered by LLaMA 3 via Ollama. It helps users track spending, manage budgets, and receive personalized financial advice using AI — all deployed on a robust, scalable backend built with Java Spring Boot, Docker, and AWS.

---

## 🚀 Features

- 📊 **Expense Logging** – Add, view, categorize daily spending
- 💰 **Budget Planning** – Set monthly budgets and recurring plans
- 🧠 **AI Budgeting Assistant** – Get personalized savings tips via LLaMA3
- 🔐 **JWT-Based Authentication** – Secure login and user sessions
- 📆 **Recurring Transactions** – Manage subscriptions and auto-expenses
- 📦 **RESTful APIs** – Modular and extensible backend
- ☁️ **Cloud Deployment** – Hosted on AWS EKS with CI/CD (Jenkins)

---

## 🧱 Tech Stack

| Layer          | Technology                          |
|----------------|-------------------------------------|
| Language       | Java 17                             |
| Framework      | Spring Boot, Spring Security        |
| Database       | MySQL                               |
| AI Model       | LLaMA3 via Ollama API               |
| Containerization| Docker                             |
| Orchestration  | Kubernetes (EKS)                    |
| CI/CD          | Jenkins                             |
| Frontend (Optional) | React or Thymeleaf              |

---

## 🧠 AI Assistant – How it Works

- Integrated with [Ollama](https://ollama.com/) running **LLaMA3** model locally or via API
- Backend endpoint `/spendlytic/ai/advice` fetches user expense data
- Sends curated prompts to LLaMA3 based on user patterns
- Returns personalized budgeting and saving suggestions

---

## 📐 System Architecture

```plaintext
   [Client / UI]
        ↓
 [Spring Boot Backend]
        ↓
+--------------------------+
| Controllers (REST APIs) |
+--------------------------+
        ↓
| Services → Repositories  |
        ↓
     [MySQL DB]
        ↓
   [LLaMA3 via Ollama]
        ↑
 [AI Advice Controller]
```

## 📦 Modules

### ✅ Auth Module
- Register/Login with JWT token support

### 💸 Expense Module
- Add, update, delete transactions
- View by date/category/type

### 💼 Budget Module
- Monthly budgets and goals
- Recurring plans and limits

### 🧠 AI Advice Module
- Calls LLaMA3 via Ollama
- Analyzes spending and suggests tips

---

## 🧪 Sample API Endpoints

```http
POST   /spendlytic/auth/signup/verify{id}
POST   /spendlytic/auth/login
POST   /spendlytic/transaction/new
GET    /spendlytic/transaction/getByUser{id}
GET    /spendlytic/ai/advice{id}  ← LLaMA3 Assistant
```

## 📈 Future Enhancements

- 📱 Add mobile-friendly UI with **React Native**
- 🧾 Export expenses to **CSV/PDF**
- 🔔 Add **reminders and monthly insights**
- 💬 Enable **chat-based AI interaction** (ChatGPT-like interface)

---

## 📸 Screenshots

Add screenshots of:

![image](https://github.com/user-attachments/assets/0b6e753a-9e7b-480a-8508-8bb85659f95b)
![image](https://github.com/user-attachments/assets/4f1bfae3-da23-492e-b809-2961df5bd64a)
![image](https://github.com/user-attachments/assets/2f37bd0a-7d2c-4c0b-a0e7-9b80718af929)
![image](https://github.com/user-attachments/assets/5f05fa57-42da-47e2-8612-b156d9e33c6f)
![image](https://github.com/user-attachments/assets/3e6c8517-2c35-4803-be81-3f4825a6f2e7)
![image](https://github.com/user-attachments/assets/c33c6751-35d4-46da-955a-f84abf96417f)
![image](https://github.com/user-attachments/assets/2b20eb2d-6ecb-46ab-a325-52472f3b9a91)




- 🖥️ **Dashboard View** – Summary of budgets, transactions, and trends  
- 🧠 **AI Budgeting Advice Screen** – LLaMA3-generated personalized insights  
- 📊 **Expense Log & Analytics View** – Category-wise spending and history

---




