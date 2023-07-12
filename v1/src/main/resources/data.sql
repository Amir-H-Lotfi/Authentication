INSERT INTO users(id, username, password, email)
VALUES (0, 'USER0USERNAME', 'USER0PASSWORD', 'USER0@EMAIL.COM');

INSERT INTO customers(id, password, email, username)
VALUES (10, 'CUSTOMER0PASSWORD', 'CUSTOMER0@EMAIL.COM', 'CUSTOMER0USERNAME');
INSERT INTO customers(id, password, email, username)
VALUES (20, 'CUSTOMER1PASSWORD', 'CUSTOMER1@gmail.COM', 'CUSTOMER1USERNAME');

INSERT INTO customers(id, password, email, username)
VALUES (30, 'CUSTOMER2PASSWORD', 'CUSTOMER1@EMAIL.COM', 'CUSTOMER2USERNAME');
INSERT INTO customers(id, password, email, username)
VALUES (40, 'CUSTOMER3PASSWORD', 'CUSTOMER1@EMAIL.COM', 'CUSTOMER3USERNAME');


INSERT INTO resources(customer_id, id, resource)
VALUES (10, 10, 'MESSAGE YOU CAN READ');
INSERT INTO resources(customer_id, id, resource)
VALUES (20, 20, 'MESSAGE YOU CAN READ');

INSERT INTO resources(customer_id, id, resource)
VALUES (30, 30, 'MESSAGE YOU CAN READ/WRITE');
INSERT INTO resources(customer_id, id, resource)
VALUES (40, 40, 'MESSAGE YOU CAN READ/WRITE');
