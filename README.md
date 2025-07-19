# Controllers

## AdminController

GET /admin/all
  
DELETE /admin/delete/{id}

## AuthController
GET /auth/signup

GET /auth/signin

POST /auth/register {username, password, email}

POST /auth/login {username, password}

PUT /auth/logout

## MainController

GET /main/products

## PersonalController 

GET /me/

POST /me/create-product {author, name, price}

GET /me/products

# Middlewares / Interceptors
## Admininterceptor
makes pages with /admin/ path unaccessable without Admin account

## AuthInterceptor
makes pages with pathes /me/ and /main/ unaccessable for unauthorized guests.

# Models
DTO's - Data Transfer Objects, they need for safe data transfering between endpoints, layers and other stuff.

Product - DTO for products, also table

RedisModel - Need for caching

User - DTO entity, and table.


# Repositories (interfaces)
ProductRepository - repository for ProductService, extends JpaRepository

RedisRepository - for Redis caching service

UserRepository - for UserService

# Services
ProductService - service for products (products table in database)

RedisService - service for caching in redis

UserService - needs for interacting with user table in database (saving, deleting, updating, etc.)

# Architecture

<img width="723" height="262" alt="image" src="https://github.com/user-attachments/assets/24dc9bcf-1ebc-4bb3-a024-24c9fd1dcbc0" />


















