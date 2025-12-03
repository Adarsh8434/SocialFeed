# 🚀 Inkle Backend Internship – Social Activity Feed

This project is built as part of the **Inkle Backend Internship Assignment**.  
It includes social features like posts, likes, follow, block, admin/user/owner roles, and a global real activity feed of all the event logging.

---
Github login : https://github.com/Adarsh8434/SocialFeed
Postman link : [https://www.postman.com/adarsh8987/workspace/sweetshop/collection/34759469-b988acaa-4f61-444a-b9a1-fb3115ca46ff?action=share&creator=34759469](https://inkle8.postman.co/workspace/Inkle~9881ad96-db71-441a-8d6e-d3d5a4e8579e/collection/34759469-b988acaa-4f61-444a-b9a1-fb3115ca46ff?action=share&creator=34759469)
## 🌟 Features

### 👤 Users
- Create User Profile (name, role)
- Users can follow / unfollow, like / unlike, block / unblock
- Admin can delete any user or post
- Owner can promote or demote admins

### 📝 Posts
- Create posts
- View all posts
- Soft delete (isDeleted=true)

### ❤️ Likes
- Like / Unlike posts

### 🤝 Follow System
- Follow & unfollow others

### 🚫 Block System
- Block users so the blocked user cannot see posts or activities

### 📰 Activity Feed Wall
Example activities:
Rohit made a post
Adarsh liked Rohit's post
Aman followed Ajay
User deleted by ‘Owner’
Post deleted by ‘Admin’



---

## 👑 Roles & Permissions

| Action | USER | ADMIN | OWNER |
|--------|------|--------|--------|
| Create Posts | ✔ | ✔ | ✔ |
| Like / Follow / Block | ✔ | ✔ | ✔ |
| Delete any Post | ❌ | ✔ | ✔ |
| Delete any User | ❌ | ✔ | ✔ |
| Create Admin | ❌ | ❌ | ✔ |
| Remove Admin | ❌ | ❌ | ✔ |

---

## 🧠 Tech Stack

| Technology | Purpose |
|------------|----------|
| Java 17 | Backend |
| Spring Boot | Framework |
| MySQL | Database |
| JPA / Hibernate | ORM |
| Lombok | Boilerplate reduction |
| Postman | API testing |

---

## 📦 REST API Endpoints

### USER
```http
POST /users
GET  /users
DELETE /users/{id}?role=ADMIN
POSTS
http
Copy code
POST /posts?userId=1&content=Hello
GET  /posts?requesterId=1
DELETE /posts/{postId}?role=ADMIN
FOLLOW
http
Copy code
POST /follow?followerId=1&followedId=2
DELETE /follow?followerId=1&followedId=2
LIKE
http
Copy code
POST /likes?postId=1&userId=1
DELETE /likes?postId=1&userId=1
BLOCK
http
Copy code
POST /block?blockerId=1&blockedId=2
DELETE /block?blockerId=1&blockedId=2
ADMIN
http
Copy code
DELETE /admin/users/2
DELETE /admin/posts/1
OWNER
http
Copy code
POST /owner/make-admin/2
DELETE /owner/make-admin/2
ACTIVITY FEED
http
Copy code
GET /activities/feed?requesterId=1
🧪 Postman Collection
Import the postman_collection.json file included in the repository to test all APIs.

🏗 Setup & Run
Clone project
bash
Copy code
git clone https://github.com/Adarsh8434/SocialFeed
cd inkle-social-feed
Configure Database
In application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/inkle?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run the project
bash
Copy code
mvn spring-boot:run

👤 Author
Adarsh Kumar Choubey
LinkedIn:https://www.linkedin.com/in/adarshku/
GitHub: https://github.com/Adarsh8434






