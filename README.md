# Library Management System

## Functionalieties
- Add new user/book
- Update user/book
- Delete user/book
- Show users/books
- Loan book

  ## Tech
  Core: <br>
  ![image](https://img.shields.io/badge/17-Java-orange?style=for-the-badge) &nbsp;
  ![image](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) &nbsp;
  ![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring) &nbsp;
  ![image](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) &nbsp;

  ## Rest-API Endpoints

  Service url: http://localhost:8080

  | HTTP METHOD | Endpoint           | Action                                      |
  |-------------|--------------------|---------------------------------------------|
  | GET         | /users             | Show all users                              |
  | GET         | /users/{id}        | Show user for a given ID                    |
  | POST        | /users             | Add new user                                |
  | PUT         | /users/{id}        | Update user for a given ID                  |
  | PATCH       | /users/{id}        | Update partially user for a given ID        |
  | DELETE      | /users/{id}        | Delete user for a given ID                  |
  | GET         | /books             | Show all books                              |
  | GET         | /books/{id}        | Show book for a given ID                    |
  | POST        | /books             | Add new book                                |
  | PUT         | /books/{id}        | Update book for a given ID                  |
  | PATCH       | /books/{id}        | Update partially book for a given ID        |
  | DELETE      | /books/{id}        | Delete book for a given ID                  |
  | PATCH       | /loan/{bookId}/{userId}  | Loan a book for given ID by user for given ID |
  | PATCH       | /return/{bookId}         | Return book for given ID                      |
  | DELETE      | /userLoanedBooks/{userId}| Show loaned books by user for given ID        |

