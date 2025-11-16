# Backgroud


# Project Related

## Database Operate
### 启动MySQL
```sql
mysql -u root -p
```
### 查看数据库
```sql
show databases;
```
### 创建数据库
```sql
CREATE DATABASE test
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;
```
### 进入数据库
```sql
use xxx(database_name);
```

### 创建数据表
```sql
CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  age INT
);
```
### 查看数据表
```sql
show tables;
```
