INSERT INTO ROLES(id, role)
VALUES (0, 'USER_DEFAULT');
INSERT INTO ROLES(id, role)
VALUES (1, 'USER_PREMIUM');
INSERT INTO ROLES(id, role)
VALUES (2, 'USER_ADMIN');
INSERT INTO AUTHORITIES(id, authority)
VALUES (0, 'authority.read');
INSERT INTO AUTHORITIES(id, authority)
VALUES (1, 'authority.write');
INSERT INTO AUTHORITIES(id, authority)
VALUES (2, 'authority.create');
INSERT INTO AUTHORITIES(id, authority)
VALUES (3, 'authority.remove');
INSERT INTO USERS(id, username, password, email)
VALUES (0, 'bennettheather', '$2b$12$X1.niqdGGXPMnlcjedjWQuTo/NbqdAsRNMCE9P8a47xLTgk4OH.Vy', 'whenderson@example.com');
INSERT INTO ADMINS(id)
VALUES (0);
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (2, 0);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (2, 0);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (3, 0);
INSERT INTO USERS(id, username, password, email)
VALUES (1, 'mezakatherine', '$2b$12$X1.niqdGGXPMnlcjedjWQuGvlNJwynuZlsL6XtXzz74v9h/OT6RmG', 'martinstacy@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 1);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 1);
INSERT INTO RESOURCES(id, resource)
VALUES (1, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (1, 1);
INSERT INTO USERS(id, username, password, email)
VALUES (2, 'hilljessica', '$2b$12$X1.niqdGGXPMnlcjedjWQu6KNs2ckgGTbZc.b5ZjbTzJIh6N9TflW', 'denisethomas@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 2);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 2);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 2);
INSERT INTO RESOURCES(id, resource)
VALUES (2, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (2, 2);
INSERT INTO USERS(id, username, password, email)
VALUES (3, 'suzannegutierrez', '$2b$12$X1.niqdGGXPMnlcjedjWQun22T9bTfvJ.wMn6yZcvJkCcOBfAIwLW',
        'kimberly17@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 3);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 3);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 3);
INSERT INTO RESOURCES(id, resource)
VALUES (3, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (3, 3);
INSERT INTO USERS(id, username, password, email)
VALUES (4, 'zwatson', '$2b$12$X1.niqdGGXPMnlcjedjWQuwaWUsIuQI8OKuYztHmxffEzRCRT4vCe', 'sarahgarcia@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 4);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 4);
INSERT INTO RESOURCES(id, resource)
VALUES (4, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (4, 4);
INSERT INTO USERS(id, username, password, email)
VALUES (5, 'angela88', '$2b$12$X1.niqdGGXPMnlcjedjWQuhe9fX3TdEFdr02Szx.MzFAqzA2uvHFq', 'ryan13@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 5);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 5);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 5);
INSERT INTO RESOURCES(id, resource)
VALUES (5, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (5, 5);
INSERT INTO USERS(id, username, password, email)
VALUES (6, 'justinmassey', '$2b$12$X1.niqdGGXPMnlcjedjWQu.k6fa/NOUjegHNd0tZWKwJBJnuB.BVu', 'ochoahannah@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 6);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 6);
INSERT INTO RESOURCES(id, resource)
VALUES (6, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (6, 6);
INSERT INTO USERS(id, username, password, email)
VALUES (7, 'bryanmunoz', '$2b$12$X1.niqdGGXPMnlcjedjWQuseRaP5bvdidx/bFu/umIRElFixY3Yhq', 'gneal@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 7);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 7);
INSERT INTO RESOURCES(id, resource)
VALUES (7, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (7, 7);
INSERT INTO USERS(id, username, password, email)
VALUES (8, 'wnichols', '$2b$12$X1.niqdGGXPMnlcjedjWQuWoOeqrqJgAJGdklunDhth.PYNeEGUGC', 'romanwhitney@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 8);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 8);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 8);
INSERT INTO RESOURCES(id, resource)
VALUES (8, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (8, 8);
INSERT INTO USERS(id, username, password, email)
VALUES (9, 'lsimmons', '$2b$12$X1.niqdGGXPMnlcjedjWQuFrxQjb4w3mKLW0XrKvAQvO1xOV3xJx.', 'pstewart@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 9);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 9);
INSERT INTO RESOURCES(id, resource)
VALUES (9, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (9, 9);