# 🚀 Smart Campus Sensor & Room Management API

A RESTful API built using **Java + JAX-RS (Jersey)** with an embedded **Grizzly server** to manage rooms, sensors, and sensor readings in a smart campus environment.

---

## 📌 Features

- 🏫 Room management (Create, Read, Delete)
- 🌡️ Sensor management with validation
- 📊 Sensor readings using sub-resource endpoints
- ⚡ In-memory data storage (HashMap & ArrayList)
- ❌ Proper error handling with HTTP status codes
- 📜 Logging filter for request & response tracking
- 🔗 RESTful design following best practices

---

## 🛠️ Tech Stack

- Java  
- JAX-RS (Jersey)  
- Grizzly HTTP Server  
- Maven  

---

## ▶️ How to Run

### 1. Clone the repository
git clone https://github.com/shevon16/Smart-Campus/tree/main/smart-campus-api
cd smart-campus-api  

### 2. Build the project
mvn clean install  

### 3. Run the server
mvn exec:java  

### 4. Server URL
http://localhost:8080/api/v1/

---

## 📡 API Overview

### 🔹 Discovery
GET /api/v1  

### 🔹 Rooms
GET /api/v1/rooms  
POST /api/v1/rooms  
GET /api/v1/rooms/{id}  
DELETE /api/v1/rooms/{id}  

### 🔹 Sensors
GET /api/v1/sensors  
GET /api/v1/sensors?type=Temperature  
POST /api/v1/sensors  

### 🔹 Sensor Readings
GET /api/v1/sensors/{id}/readings  
POST /api/v1/sensors/{id}/readings  

---

## 🧪 Sample Requests (cURL)

Create Room:
curl -X POST http://localhost:8080/api/v1/rooms -H "Content-Type: application/json" -d "{\"id\":\"LIB-301\",\"name\":\"Library Quiet Study\",\"capacity\":80}"

Get Rooms:
curl http://localhost:8080/api/v1/rooms  

Create Sensor:
curl -X POST http://localhost:8080/api/v1/sensors -H "Content-Type: application/json" -d "{\"id\":\"TEMP-001\",\"type\":\"Temperature\",\"status\":\"ACTIVE\",\"currentValue\":25.5,\"roomId\":\"LIB-301\"}"

Add Reading:
curl -X POST http://localhost:8080/api/v1/sensors/TEMP-001/readings -H "Content-Type: application/json" -d "{\"value\":28.5}"

Delete Room:
curl -X DELETE http://localhost:8080/api/v1/rooms/LIB-301  

---

## ⚠️ Error Handling

- 400 → Bad Request  
- 403 → Sensor in maintenance  
- 404 → Resource not found  
- 409 → Conflict (duplicate / room not empty)  
- 422 → Invalid linked resource  
- 500 → Internal server error  

---

## 🧠 Design Decisions

**Why 422 instead of 404?**  
422 is used when the request is valid but contains incorrect data (e.g., invalid roomId).

**Why not expose stack traces?**  
To prevent leaking internal system details and improve security.

**Why use filters for logging?**  
Filters centralize logging logic and automatically apply to all endpoints.

---

## 🔁 Idempotency

DELETE operations are idempotent:

- First DELETE → removes the resource  
- Second DELETE → returns 404  
- Final system state remains unchanged  

---

## 📂 Project Structure

com.smartcampus  
├── model  
├── resource  
├── repository  
├── exception  
├── exception.mapper  
├── filter  
└── Main.java  

---

## 👨‍💻 Author

**Shehan Joel**  
5COSC022W – Client-Server Architectures  

---

## ✅ Status

✔ Fully functional  
✔ All endpoints tested  
✔ Ready for submission  

---
