-- public.appointment определение

-- Drop table

-- DROP TABLE public.appointment;

CREATE TABLE public.appointment (
	id serial4 NOT NULL,
	type_pension int4 NOT NULL,
	recipients int4 NOT NULL,
	"size" int4 NOT NULL,
	start_date date NOT NULL
);
INSERT INTO public.appointment (type_pension,recipients,"size",start_date) VALUES
	 (1,1,6000,'2026-04-23'),
	 (1,2,16000,'2026-04-23'),
	 (2,3,18000,'2026-04-08'),
	 (3,4,16288,'2026-04-22'),
	 (4,5,16288,'2026-04-15');



-- public.recipient определение

-- Drop table

-- DROP TABLE public.recipient;

CREATE TABLE public.recipient (
	id serial4 NOT NULL,
	snils int8 NOT NULL,
	fio varchar NOT NULL,
	birth_date date NOT NULL,
	address varchar NOT NULL
);

INSERT INTO public.recipient (snils,fio,birth_date,address) VALUES
	 (21342567423,'Иванов Сергей Петрович','1991-05-14','г. Москва, ул. Лесная, д. 12, кв. 45'),
	 (98314824051,'Смирнова Анна Васильевна','1985-11-22','г. Казань, ул. Мира, д. 8, кв. 102'),
	 (12948532675,'Кузнецов Максим Игоревич','2008-02-03','г. Новосибирск, пр-т Красный, д. 56, кв. 12'),
	 (12349581254,'Петрова Елена Николаевна','1995-08-10','г. Екатеринбург, ул. Малышева, д. 31, кв. 7'),
	 (12345678912,'Иванов Иванов Иванович','2004-04-09','г. Москва, ул. Петровская 2');


-- public.type_pension определение

-- Drop table

-- DROP TABLE public.type_pension;

CREATE TABLE public.type_pension (
	id int4 DEFAULT nextval('type_pensio_id_seq'::regclass) NOT NULL,
	"name" varchar NOT NULL,
	"condition" varchar NOT NULL,
	base_size int8 NOT NULL
);
INSERT INTO public.type_pension ("name","condition",base_size) VALUES
	 ('Социальная пенсия','гражданам, не набравшим стаж или ИПК для страховой пенсии',9424),
	 ('Страховая пенсия (инвалидность (I))','инвалидность (I)',4791),
	 ('Страховая пенсия (случай потери)','случай потери',4792),
	 ('Страховая пенсия (старость)','старость',16288),
	 ('Государственная пенсия','военные, госслужащие',35000);