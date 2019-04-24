INSERT INTO `country`
VALUES (1, 'Ukraine'),
       (2, 'USA'),
       (3, 'Spain'),
       (4, 'Poland'),
       (5, 'Italy'),
       (6, 'England'),
       (7, 'France'),
       (8, 'Nitherland'),
       (9, 'Switherland'),
       (10, 'Sweden');
INSERT INTO `city`
VALUES (1, 'Kyiv', 1),
       (3, 'Las Vegas', 2),
       (4, 'New York', 2),
       (5, 'Barcelona', 3),
       (6, 'Madrid', 3),
       (7, 'Warshava', 4),
       (8, 'Krakiv', 4),
       (9, 'Roma', 5),
       (10, 'Venezia', 5),
       (11, 'London', 6),
       (12, 'Manchester', 6),
       (13, 'Paris', 7),
       (14, 'Marsel', 7),
       (15, 'Amsterdam', 8),
       (16, 'Gaaga', 8),
       (17, 'Bern', 9),
       (18, 'Basel', 9),
       (19, 'Stockholm', 10),
       (20, 'Falum', 10),
       (22, 'Bialystok', 2);
INSERT INTO `clients`
VALUES (1, 'Vasya', 'Pupkin', 'vasya@gmail.com', '063 63 63 063', 1),
       (2, 'Oleg', 'Bucket', 'bucket@gmail.com', '097 78 78 734', 3);
INSERT INTO `hotel`
VALUES (1, 'Ocean Plaza', 'op@gmail.com', '222 22 22', 3, 'Vashington 12');
INSERT INTO `roomtype`
VALUES (1, 'Lux'),
       (2, 'Comfort'),
       (3, 'Standart');
INSERT INTO `room`
VALUES (1, 1, 2, 1, 3),
       (2, 2, 4, 1, 1),
       (3, 5, 1, 1, 2);
INSERT INTO `visa`
VALUES (1, '2019-01-01', '2020-01-01', 2, 1);
INSERT INTO `booking`
VALUES (1, '2019-03-03', '2019-03-20', 1, 1);









