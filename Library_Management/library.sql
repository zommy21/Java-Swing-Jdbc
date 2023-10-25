drop database if exists library;

create database library;

USE library;

create table admin(
	User_id varchar(50) primary key,
    Name varchar(50),
    Password varchar(50),
    Contact varchar(50)
);

insert into admin values('zommy','Nguyen Nhat Minh','minhdeptrai','0358267244');

create table books(
	Book_id varchar(50) primary key,
    category varchar(50),
    Name varchar(50),
    Author varchar(50),
    Copies int
);

insert into books values ('B001', 'Fiction', 'Pride and Prejudice', 'Jane Austen', 10),
('B002', 'Non-Fiction', 'A Brief History of Time', 'Stephen Hawking', 5),
('B003', 'Children\'s', 'The Very Hungry Caterpillar', 'Eric Carle', 20),
('B004', 'Mystery', 'The Hound of the Baskervilles', 'Sir Arthur Conan Doyle', 15),
('B005', 'Science Fiction', '2001: A Space Odyssey', 'Arthur C. Clarke', 10),
('B006', 'Poetry', 'The Love Song of J. Alfred Prufrock', 'T.S. Eliot', 5),
('B007', 'Drama', 'Hamlet', 'William Shakespeare', 15),
('B008', 'Biography', 'Steve Jobs', 'Walter Isaacson', 10),
('B009', 'History', 'The Second World War', 'Winston S. Churchill', 5),
('B010', 'Self-Help', 'The 7 Habits of Highly Effective People', 'Stephen R. Covey', 20);

create table staffs(
	Staff_id varchar(50) primary key,
    Name varchar(50),
    Contact varchar(50)
);

insert into staffs values('S001','Nguyen Nhat Minh','0358267244'),
('S002','Le Minh Khuong ','0358267245'),
('S003','Nguyen Xuan Hieu','0358267246'),
('S004','Le Xuan Dong','0358267247'),
('S005','Nguyen Quang Phuoc','0358267248');
