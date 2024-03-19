INSERT INTO COUNTRY VALUES (1, 'Russia');
INSERT INTO COUNTRY VALUES (2, 'German');
INSERT INTO COUNTRY VALUES (3, 'Japan');
INSERT INTO COUNTRY VALUES (4, 'USA');
INSERT INTO COUNTRY VALUES (5, 'South Korea');

INSERT INTO BRAND VALUES (1, 'Lada', 1);
INSERT INTO BRAND VALUES (2, 'BMW', 2);
INSERT INTO BRAND VALUES (3, 'Mitsubishi', 3);
INSERT INTO BRAND VALUES (4, 'Ford', 4);
INSERT INTO BRAND VALUES (5, 'Hyundai', 5);

INSERT INTO CAR_LINEUP VALUES (1, 'Granta', 1);
INSERT INTO CAR_LINEUP VALUES (2, '2 серия', 2);
INSERT INTO CAR_LINEUP VALUES (3, 'Lancer', 3);
INSERT INTO CAR_LINEUP VALUES (4, 'Mustang', 4);
INSERT INTO CAR_LINEUP VALUES (5, 'Elantra', 5);
INSERT INTO CAR_LINEUP VALUES (6, 'Solaris', 5);

INSERT INTO CLASS VALUES (1, 'Кроссевер', 'Автомобиль повышенной проходимости, который вобрал в себя всё лучшее от внедорожника, минивэна и хэтчбека');
INSERT INTO CLASS VALUES (2, 'Внедорожник', 'Автомобиль, обладающий повышенной проходимостью по бездорожью за счёт большого клиренса, ведущих передних и задних колёс');
INSERT INTO CLASS VALUES (3, 'Средний класс', 'Автомобиль для тех, кто часто совершает долгие поездки и нуждается в дополнительном комфорте');
INSERT INTO CLASS VALUES (4, 'Спорткар', 'Спортивные и прогулочные купе (возможно трехдверные хэтчбеки).');

INSERT INTO MODEL VALUES (1, 'Sport', 'это «спортивная» версия модели «Лада Гранта»', 3, 1, 1);
INSERT INTO MODEL VALUES (2, 'Grand Coupe', 'это седан, который выпускается с ноября 2019 года в Германии, на заводе в городе Лейпциге', 1, 2, 2);
INSERT INTO MODEL VALUES (3, 'X', 'Девятое поколение автомобиля Mitsubishi Lancer', 2, 3, 3);
INSERT INTO MODEL VALUES (4, 'VI', 'Спорткар Ford Mustang шестого поколения дебютировал на американском рынке в сентябре 2014 года, а в 2015 году автомобиль официально начали продавать в Европе — впервые в истории модели.', 4, 4, 4);
INSERT INTO MODEL VALUES (5, 'V', 'Первый экземпляр Ford Mustang пятого поколения был выпущен в 2004 году.', 4, 4, 4);
INSERT INTO MODEL VALUES (6, '1.6', 'Хендай Элантра — это четырёхдверный седан среднего класса, седьмое поколение которого выпускается в Корее с 2020 года.', 3, 5, 5);
INSERT INTO MODEL VALUES (7, '1.4', 'Хендай Солярис — это компактный седан для российского рынка, выпускающийся на заводе в Санкт-Петербурге с февраля 2017 года.', 3, 5, 6);
