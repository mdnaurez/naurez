# naurez

create a book
localhost:8083/api/books
body
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "genre": "Programming",
  "price": 450.00,
  "stock": 20,
  "rating": 0.0,
  "publisher": "Prentice Hall",
  "discountedPrice": 400.00
}
get a book
localhost:8083/api/books
get aparticular book with id
localhost:8083/api/books/give id



Rating & Review API
○ Customers can submit ratings (1–5) and reviews for books.
○ Book’s average rating should be updated on every new rating.

create a book
localhost:8083/api/books
{
  "title": "Book One",
  "author": "Author A",
  "price": 299.99
}

localhost:8083/api/books

{
  "title": "Book Two",
  "author": "Author B",
  "price": 399.99
}

in sql
mysql> select * from book;
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
| discounted_price | id | price  | rating | stock | author   | genre | publisher | title |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
|             NULL |  1 | 299.99 |      0 |     0 | Author A | NULL  | NULL      | NULL  |
|             NULL |  2 | 399.99 |      0 |     0 | Author B | NULL  | NULL      | NULL  |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
2 rows in set (0.00 sec)

create a customer

localhost:8083/api/customer
{
  "name": "John Doe",
  "email": "john@example.com",
  "membershipLevel": "GOLD",
  "registrationDate": "2024-06-01"
}

localhost:8083/api/customer
{
  "name": "Alice Smith",
  "email": "alice.smith@example.com",
  "membershipLevel": "GOLD",
  "registrationDate": "2024-07-15"
}
 in sql
 mysql> select * from customer;
+----+-------------------------+------------------+-------------+-------------------+
| id | email                   | membership_level | name        | registration_date |
+----+-------------------------+------------------+-------------+-------------------+
|  1 | john@example.com        | GOLD             | John Doe    | 2024-06-01        |
|  2 | alice.smith@example.com | GOLD             | Alice Smith | 2024-07-15        |


now customer is giving review

customer 1 is giving review
localhost:8083/reviews
{
  "rating": 5,
  "comment": "Excellent!",
  "bookId": 1,
  "customerId": 1
}

mysql> select * from review;
+---------+-------------+----+--------+------------+
| book_id | customer_id | id | rating | comment    |
+---------+-------------+----+--------+------------+
|       1 |           1 |  1 |      5 | Excellent! |
+---------+-------------+----+--------+------------+
1 row in set (0.00 sec)

mysql> select * from book;
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
| discounted_price | id | price  | rating | stock | author   | genre | publisher | title |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
|             NULL |  1 | 299.99 |      5 |     0 | Author A | NULL  | NULL      | NULL  |
|             NULL |  2 | 399.99 |      0 |     0 | Author B | NULL  | NULL      | NULL  |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
2 rows in set (0.00 sec)
here in book rating is 5


2nd person rate book 1 only and the book rating will change

localhost:8083/reviews
{
  "rating": 3,
  "comment": "Excellent!",
  "bookId": 1,
  "customerId": 2
}


mysql> select * from review;
+---------+-------------+----+--------+------------+
| book_id | customer_id | id | rating | comment    |
+---------+-------------+----+--------+------------+
|       1 |           1 |  1 |      5 | Excellent! |
|       1 |           2 |  2 |      3 | Excellent! |
+---------+-------------+----+--------+------------+
2 rows in set (0.00 sec)

mysql> select * from book;
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
| discounted_price | id | price  | rating | stock | author   | genre | publisher | title |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
|             NULL |  1 | 299.99 |      4 |     0 | Author A | NULL  | NULL      | NULL  |
|             NULL |  2 | 399.99 |      0 |     0 | Author B | NULL  | NULL      | NULL  |
+------------------+----+--------+--------+-------+----------+-------+-----------+-------+
2 rows in set (0.00 sec)
here the book 1 rating are the average of two customer rating
 












