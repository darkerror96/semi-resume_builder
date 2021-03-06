
CREATE TABLE personal_info (
first_name TINYTEXT NOT NULL,
last_name TINYTEXT NOT NULL,
email TINYTEXT NOT NULL,
street1 TINYTEXT NOT NULL,
street2 TINYTEXT,
city TINYTEXT NOT NULL,
state TINYTEXT NOT NULL,
zip TINYTEXT NOT NULL);

CREATE TABLE summary (
summary TINYTEXT NOT NULL);

CREATE TABLE objective (
objective TINYTEXT NOT NULL);

CREATE TABLE education (
id INTEGER NOT NULL PRIMARY KEY,
school_name TINYTEXT NOT NULL,
school_city VARCHAR(20) NOT NULL,
school_state VARCHAR(20) NOT NULL,
degree TINYTEXT NOT NULL,
major TINYTEXT NOT NULL,
grad_month VARCHAR(15) NOT NULL,
grad_year INTEGER NOT NULL,
is_anticipated boolean);

CREATE TABLE experience (
 id INTEGER NOT NULL PRIMARY KEY,
 cmp_name TINYTEXT NOT NULL,
 pos TINYTEXT NOT NULL,
 cmp_loc TINYTEXT NOT NULL,
 start_date TINYTEXT NOT NULL,
 end_date TINYTEXT NOT NULL,
 cmp_summ VARCHAR(100) NOT NULL);

CREATE TABLE publication (
 id INTEGER NOT NULL PRIMARY KEY,
 auth_name TINYTEXT NOT NULL,
 title TINYTEXT NOT NULL,
 year SMALLINT NOT NULL,
 summary VARCHAR(100) NOT NULL); 
 
CREATE TABLE activity (
 id INTEGER NOT NULL PRIMARY KEY,
 activity TINYTEXT NOT NULL);
 
CREATE TABLE membership (
 id INTEGER NOT NULL PRIMARY KEY,
 membership TINYTEXT NOT NULL);
