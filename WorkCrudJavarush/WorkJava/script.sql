
USE test;
create table Users (
        id INT(8) not null auto_increment,
        name VARCHAR(25),
        age INT,
        isAdmin BIT not null default false,
        createdDate TIMESTAMP,
        primary key (id)
);

INSERT INTO Users (name, age, isAdmin, createdDate)
    VALUES ("Vasia", 20, 1, "11.01.2010"),
      ("Katia", 25, 0, "11.01.2010"),
      ("Vova", 30, 0, "11.02.2010"),
      ("Petia", 21, 1, "11.03.2010"),
      ("Gena", 22, 0, "11.01.2011"),
      ("Olia", 30, 0, "11.01.2012"),
      ("Petrovich", 40, 1, "11.01.2013"),
      ("Tom", 22, 0, "11.01.2015"),
      ("Gery",1, 0, "11.01.2016");
