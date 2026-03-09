# Scalable URL Shortening Service (Backend)

A **high-performance and scalable URL Shortener Backend** built using **Spring Boot**.
This service converts long URLs into short, shareable links and efficiently redirects users to the original URLs.

The system is designed with **scalability, caching, event streaming, and rate limiting**, similar to real-world URL shortening systems.

**Live using curl: 
**
curl --location 'https://scalable-url-shortening-service.onrender.com/api/url/shorten' \
--header 'Content-Type: application/json' \
--data '{
 "originalUrl":"https://google.com/"
}'
---

# 🚀 Features

* Generate short URLs from long URLs
* Redirect short URLs to original links
* Scalable backend architecture
* Cloud database integration
* Caching layer for faster lookups
* Rate limiting to prevent API abuse
* Event-driven processing with Kafka
* GraphQL support
* Secure API architecture

---

# 🛠 Tech Stack

* Java
* Spring Boot
* Maven
* REST APIs
* GraphQL
* MongoDB
* MongoDB Atlas (Cloud Database)
* Apache Kafka (Event Streaming)
* Redis (Caching)
* JWT Authentication
* Rate Limiting

---

# 🏗 System Architecture

The system is designed to handle **high read traffic**, which is typical in URL shortener platforms.

Core components:

Client
│
API Layer (Spring Boot Controllers)
│
Service Layer (Business Logic)
│
├── Cache Layer (Redis)
├── Database Layer (MongoDB Atlas)
└── Event Streaming (Kafka)

The cache layer ensures faster URL resolution, while Kafka enables asynchronous processing such as analytics and logging.

---

# 🗄 Database

The application uses **MongoDB Atlas**, a fully managed cloud database service by **MongoDB**.

Advantages:

* Managed cloud infrastructure
* High availability
* Automatic scaling
* Secure connection
* Global cluster support

Example document structure:

```json
{
  "_id": "65f3acb2d12",
  "originalUrl": "https://example.com/very/long/url",
  "shortCode": "abc123",
  "createdAt": "2026-03-09T10:20:00Z",
  "clickCount": 0
}
```

---

# 📂 Project Structure

```
backend
 ├── controller      # REST API endpoints
 ├── service         # Business logic layer
 ├── repository      # Database access layer
 ├── model           # Data models / entities
 ├── config          # Application configuration
 ├── security        # Authentication & authorization
 ├── cache           # Redis caching layer
 ├── kafka           # Event streaming integration
 ├── rateLimiter     # API rate limiting logic
 ├── graphql         # GraphQL APIs
 └── util            # Utility/helper classes
```

---

# ⚙️ Configuration

Configure the MongoDB Atlas connection in:

`application.properties`

```
spring.data.mongodb.uri=mongodb+srv://username:password@cluster.mongodb.net/urlshortener
```

Replace:

* username
* password
* cluster name

---

# ⚡ API Endpoints

## Create Short URL

POST `/api/shorten`

Request:

```json
{
  "url": "https://example.com/very/long/url"
}
```

Response:

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

## Redirect to Original URL

GET `/{shortCode}`

Example:

```
http://localhost:8080/abc123
```

Redirects the user to the original URL.

---

# 🔐 Security

The system includes:

* JWT-based authentication
* API request validation
* Rate limiting to prevent abuse

---

# ⚡ Performance Optimizations

To support high traffic:

* Redis caching to reduce database reads
* Efficient short code lookup
* Kafka for asynchronous event processing
* Indexed database queries

---

# ▶️ Running the Project

Clone the repository:

```
git clone https://github.com/vishalgulatigithub/Scalable-url-shortening-service-production.git
```

Navigate to the backend folder:

```
cd backend
```

Run the application:

```
./mvnw spring-boot:run
```

The server will start at:

```
http://localhost:8080
```

---

# 📈 Future Improvements

* Distributed ID generation
* URL expiration support
* Click analytics dashboard
* Global caching with Redis cluster
* Multi-region deployment
* URL preview metadata

---

# 📚 Learning Goals

This project explores important backend system design concepts:

* Scalable service architecture
* Distributed systems fundamentals
* Event-driven architecture
* Cloud database usage
* High-performance API design

---

# 👨‍💻 Author

Developed as a backend system design project using **Spring Boot**, **MongoDB Atlas**, and modern scalable architecture principles.

---
