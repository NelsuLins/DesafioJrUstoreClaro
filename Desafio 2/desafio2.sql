create database funcionarios
default character set utf8
default collate utf8_general_ci;

use funcionarios;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
)default charset utf8;

CREATE TABLE `salary` (
  `id` int(11) NOT NULL,
  `value` decimal(10,2) NOT NULL,
  `payment_date` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
)default charset utf8;

insert into employee
(`name`, email)
values
('Nelson', 'nelsonlins12@gmail.com'),
('Ana', 'anavitoria@gmail.com'),
('Patricia', 'elzapatricia@gmail.com'),
('Elvia', 'elviabarros@gmail.com'),
('Marconi', 'marconigomes@gmail.com');

insert into salary values
('1', '5000.50', '2024-07-25', '1'),
('2', '4970.53', '2024-06-25', '1'),
('3', '5100.20', '2024-05-25', '1'),
('4', '4500.20', '2024-07-25', '2'),
('5', '4670.20', '2024-06-25', '2'),
('6', '4580.20', '2024-05-25', '2'),
('7', '4000.20', '2024-07-25', '3'),
('8', '4150.20', '2024-06-25', '3'),
('9', '4150.20', '2024-05-25', '3'),
('10', '4800.20', '2024-07-25', '4'),
('11', '4800.20', '2024-06-25', '4'),
('12', '4760.70', '2024-05-25', '4'),
('13', '3500.00', '2024-07-25', '5'),
('14', '3500.00', '2024-06-25', '5'),
('15', '3500.00', '2024-05-25', '5');

insert into salary values
('16', '5000.50', '2024-04-25', '1'),
('17', '4970.53', '2024-04-25', '2'),
('18', '5100.20', '2024-04-25', '3'),
('19', '4500.20', '2024-04-25', '4'),
('20', '4670.20', '2024-04-25', '5');

select e.`id`, e.`name`, sum(s.`value`)/3 as `average_salary`
from employee as e join salary as s
on e.`id` = s.`employee_id`
where s.`payment_date` <= (CURRENT_DATE - 90)
group by e.`id`
order by `average_salary` desc
limit 3





