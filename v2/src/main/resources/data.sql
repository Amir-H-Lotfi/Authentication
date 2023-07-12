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
VALUES (100, 'xtrujillo', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.qBabtxVD6PyfZl7RN01Zx6Y1WUGAD8m', 'diazbrandi@example.org');
INSERT INTO ADMINS(id)
VALUES (100);
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (2, 100);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (2, 100);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (3, 100);
INSERT INTO USERS(id, username, password, email)
VALUES (101, 'williamfox', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.1zGff9MnnYc3GCqm.eRHX7m83EZ23S6',
        'jenniferaguilar@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 101);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 101);
INSERT INTO RESOURCES(id, resource)
VALUES (101, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (101, 101);
INSERT INTO USERS(id, username, password, email)
VALUES (102, 'andrewkidd', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.ZOqM9CQGcrVA7xYmWV9W7uaP0QHL20m', 'akrause@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 102);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 102);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 102);
INSERT INTO RESOURCES(id, resource)
VALUES (102, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (102, 102);
INSERT INTO USERS(id, username, password, email)
VALUES (103, 'ronaldrose', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.FeXxdntyRE/5vOdOwwwir1UWavesyk.', 'avilajuan@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 103);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 103);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 103);
INSERT INTO RESOURCES(id, resource)
VALUES (103, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (103, 103);
INSERT INTO USERS(id, username, password, email)
VALUES (104, 'rebecca62', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.0TB0HlGhHSr66zbdun9Ra/rVicReVpG', 'ginamullen@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 104);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 104);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 104);
INSERT INTO RESOURCES(id, resource)
VALUES (104, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (104, 104);
INSERT INTO USERS(id, username, password, email)
VALUES (105, 'randy37', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.XDR0AtHXN/gL1p61yXYTKuXCAFcd2b2', 'kristyward@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 105);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 105);
INSERT INTO RESOURCES(id, resource)
VALUES (105, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (105, 105);
INSERT INTO USERS(id, username, password, email)
VALUES (106, 'dennis07', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.Y3DD73FNwFJsEige7IOdkJELVp7QWc.', 'stephanietucker@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 106);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 106);
INSERT INTO RESOURCES(id, resource)
VALUES (106, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (106, 106);
INSERT INTO USERS(id, username, password, email)
VALUES (107, 'lsmall', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.ysWFZxUV3woeMW39Ip9ulzpMZ6imypa', 'ellenrobinson@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 107);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 107);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 107);
INSERT INTO RESOURCES(id, resource)
VALUES (107, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (107, 107);
INSERT INTO USERS(id, username, password, email)
VALUES (108, 'caitlin70', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.pEjMBT.RnSI.IBPd.f/4lrWncLT3Lcq', 'brucekaren@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 108);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 108);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 108);
INSERT INTO RESOURCES(id, resource)
VALUES (108, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (108, 108);
INSERT INTO USERS(id, username, password, email)
VALUES (109, 'edwinrojas', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.9JcPQgUi6YyKxRd.YG1YjOwZdktG0ii', 'hgarcia@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 109);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 109);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 109);
INSERT INTO RESOURCES(id, resource)
VALUES (109, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (109, 109);
INSERT INTO USERS(id, username, password, email)
VALUES (110, 'johnsonjustin', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.LDTJjuBkQ2i8k/NoGWoDZudh3U0sgmC', 'edwinsmith@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 110);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 110);
INSERT INTO RESOURCES(id, resource)
VALUES (110, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (110, 110);
INSERT INTO USERS(id, username, password, email)
VALUES (111, 'rebeccajones', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.kkOINGLi/W5ydYPVP8uf2t3YJrEE6xG', 'twong@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 111);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 111);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 111);
INSERT INTO RESOURCES(id, resource)
VALUES (111, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (111, 111);
INSERT INTO USERS(id, username, password, email)
VALUES (112, 'josevilla', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.L/KfwXSymxLvo0lka4eJmoivE2nAI1S', 'barnettgina@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 112);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 112);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 112);
INSERT INTO RESOURCES(id, resource)
VALUES (112, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (112, 112);
INSERT INTO USERS(id, username, password, email)
VALUES (113, 'fsmith', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.ozK1EizWYuJNZWCAWyXWdUct.JNLnvi', 'fergusonlauren@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 113);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 113);
INSERT INTO RESOURCES(id, resource)
VALUES (113, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (113, 113);
INSERT INTO USERS(id, username, password, email)
VALUES (114, 'zweeks', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.UyvWL0s7GgG7KVp78X9SZqooFYDXPD.', 'davidromero@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 114);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 114);
INSERT INTO RESOURCES(id, resource)
VALUES (114, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (114, 114);
INSERT INTO USERS(id, username, password, email)
VALUES (115, 'moonrandall', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.sugBoayMaKA8ijjMhKAOJM6LIxpKOd.',
        'robersonheidi@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 115);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 115);
INSERT INTO RESOURCES(id, resource)
VALUES (115, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (115, 115);
INSERT INTO USERS(id, username, password, email)
VALUES (116, 'gonzalesjeffery', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.A5AvlE51FI6iR2VAxXqim/iLTvZ0oZ.',
        'rowecheryl@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 116);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 116);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 116);
INSERT INTO RESOURCES(id, resource)
VALUES (116, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (116, 116);
INSERT INTO USERS(id, username, password, email)
VALUES (117, 'kristentaylor', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.ipBeMnvUvqvk3aA4YvZxgaLjnoNHDVC',
        'mccarthychristina@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 117);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 117);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 117);
INSERT INTO RESOURCES(id, resource)
VALUES (117, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (117, 117);
INSERT INTO USERS(id, username, password, email)
VALUES (118, 'zdorsey', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.P.B7fHukB5SDM75p/IzsmpNHg9pzr/.', 'andreaherring@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 118);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 118);
INSERT INTO RESOURCES(id, resource)
VALUES (118, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (118, 118);
INSERT INTO USERS(id, username, password, email)
VALUES (119, 'martinezcheryl', '$2b$12$Jnai20Sfe5rBeIpsHlj8R./iKcLLvbdRggGozk/9wrWc8lgvIWtZ6', 'kadams@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 119);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 119);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 119);
INSERT INTO RESOURCES(id, resource)
VALUES (119, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (119, 119);
INSERT INTO USERS(id, username, password, email)
VALUES (120, 'cookdeanna', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.6xPHoTf780HBHAYAll.QZ5Q9BEg5a8q', 'joshua76@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 120);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 120);
INSERT INTO RESOURCES(id, resource)
VALUES (120, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (120, 120);
INSERT INTO USERS(id, username, password, email)
VALUES (121, 'christian83', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.GElk4AFKEITnpVawU2wPbjLh2fiTgES', 'kristen22@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 121);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 121);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 121);
INSERT INTO RESOURCES(id, resource)
VALUES (121, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (121, 121);
INSERT INTO USERS(id, username, password, email)
VALUES (122, 'nhernandez', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.7bomn3ve61EtfuqyiixteckE7qwMoTi', 'nicole93@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 122);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 122);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 122);
INSERT INTO RESOURCES(id, resource)
VALUES (122, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (122, 122);
INSERT INTO USERS(id, username, password, email)
VALUES (123, 'wardelizabeth', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.PXaj9srLktsBoN6PT/clhB1Xk4fCX6q', 'jasongomez@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 123);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 123);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 123);
INSERT INTO RESOURCES(id, resource)
VALUES (123, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (123, 123);
INSERT INTO USERS(id, username, password, email)
VALUES (124, 'douglas26', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.f38njDfXyZ6WZmemfIu0vOgHhbMilqm', 'taracook@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 124);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 124);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 124);
INSERT INTO RESOURCES(id, resource)
VALUES (124, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (124, 124);
INSERT INTO USERS(id, username, password, email)
VALUES (125, 'antonio22', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.dU8WJ9YiCd6LOBEiw537VQSpcjDKLKq', 'wnewman@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 125);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 125);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 125);
INSERT INTO RESOURCES(id, resource)
VALUES (125, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (125, 125);
INSERT INTO USERS(id, username, password, email)
VALUES (126, 'xmoss', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.qS6wdQKeeO92aEIJotyr7rh7fODFC4.', 'josephcarpenter@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 126);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 126);
INSERT INTO RESOURCES(id, resource)
VALUES (126, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (126, 126);
INSERT INTO USERS(id, username, password, email)
VALUES (127, 'santanajohn', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.MKFR5tbd3rputSkT95oQuF3k7HjbyLS', 'gmeyer@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 127);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 127);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 127);
INSERT INTO RESOURCES(id, resource)
VALUES (127, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (127, 127);
INSERT INTO USERS(id, username, password, email)
VALUES (128, 'emilysparks', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.zo9u2VjnzcAC9Q2G.iIfmxyoY4s7Fhm', 'wmcfarland@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 128);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 128);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 128);
INSERT INTO RESOURCES(id, resource)
VALUES (128, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (128, 128);
INSERT INTO USERS(id, username, password, email)
VALUES (129, 'oliviathompson', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.9hQxbE2rWoGCMP8mkGtAyLhI8fXEojG', 'daymark@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 129);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 129);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 129);
INSERT INTO RESOURCES(id, resource)
VALUES (129, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (129, 129);
INSERT INTO USERS(id, username, password, email)
VALUES (130, 'whitemichael', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.eozPdnDfb7uT2qGtjScmCZdaUKAEm7W', 'hvillanueva@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 130);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 130);
INSERT INTO RESOURCES(id, resource)
VALUES (130, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (130, 130);
INSERT INTO USERS(id, username, password, email)
VALUES (131, 'morrisruth', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.vet6fK5NAvFf9ikKocXMu0sE80O8zCK', 'hamiltonmark@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 131);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 131);
INSERT INTO RESOURCES(id, resource)
VALUES (131, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (131, 131);
INSERT INTO USERS(id, username, password, email)
VALUES (132, 'wkelley', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.t0EXQQmK5e7wElu3C45o./3PtcTko9O', 'mcculloughalyssa@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 132);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 132);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 132);
INSERT INTO RESOURCES(id, resource)
VALUES (132, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (132, 132);
INSERT INTO USERS(id, username, password, email)
VALUES (133, 'lwilliams', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.qBi9D0KanyOibXj5/25JXKtH3jTe72y', 'rebeccaweeks@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 133);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 133);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 133);
INSERT INTO RESOURCES(id, resource)
VALUES (133, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (133, 133);
INSERT INTO USERS(id, username, password, email)
VALUES (134, 'wlewis', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.TxHuES5qyX/xnr/8iqvncjw7dsDuRxe', 'robertwarren@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 134);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 134);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 134);
INSERT INTO RESOURCES(id, resource)
VALUES (134, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (134, 134);
INSERT INTO USERS(id, username, password, email)
VALUES (135, 'aprilrich', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.hGx8m6UMPppfVFjx3P2J29EanZ2kot.', 'dlang@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 135);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 135);
INSERT INTO RESOURCES(id, resource)
VALUES (135, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (135, 135);
INSERT INTO USERS(id, username, password, email)
VALUES (136, 'gabriela23', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.Ffm6tTQeblyUWWyaZv/TWEAcnSh/ZuW', 'robin98@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 136);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 136);
INSERT INTO RESOURCES(id, resource)
VALUES (136, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (136, 136);
INSERT INTO USERS(id, username, password, email)
VALUES (137, 'pattonmichelle', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.Y2jbjGUIWWz0AWZFesiztquQEPetM.C',
        'christinarobinson@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 137);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 137);
INSERT INTO RESOURCES(id, resource)
VALUES (137, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (137, 137);
INSERT INTO USERS(id, username, password, email)
VALUES (138, 'jonesjames', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.iW8KqN.joDN6MX1L2rtxjGXkgm/9qgO', 'wthompson@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 138);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 138);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 138);
INSERT INTO RESOURCES(id, resource)
VALUES (138, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (138, 138);
INSERT INTO USERS(id, username, password, email)
VALUES (139, 'hannahlopez', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.s7w2m/rGil6LZxAIaPuV1ulNSRJGr6i', 'eringonzalez@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 139);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 139);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 139);
INSERT INTO RESOURCES(id, resource)
VALUES (139, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (139, 139);
INSERT INTO USERS(id, username, password, email)
VALUES (140, 'daniel35', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.Y6pG5Sf3ezyh93Bfib5QReb13qR5PJC', 'debrarivera@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 140);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 140);
INSERT INTO RESOURCES(id, resource)
VALUES (140, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (140, 140);
INSERT INTO USERS(id, username, password, email)
VALUES (141, 'nmckinney', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.r74OqWH5eR6bjfFwm7M0KiclqUdrYkm', 'brownanthony@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 141);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 141);
INSERT INTO RESOURCES(id, resource)
VALUES (141, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (141, 141);
INSERT INTO USERS(id, username, password, email)
VALUES (142, 'linda61', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.iQZcX3aVjyq7iFTAIFGSxh1xnMGFmRS', 'ufrederick@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 142);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 142);
INSERT INTO RESOURCES(id, resource)
VALUES (142, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (142, 142);
INSERT INTO USERS(id, username, password, email)
VALUES (143, 'claytonanna', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.L.fxOeLkTs5/jmGAIET0HP8UrDRReI6', 'davismark@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 143);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 143);
INSERT INTO RESOURCES(id, resource)
VALUES (143, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (143, 143);
INSERT INTO USERS(id, username, password, email)
VALUES (144, 'paul89', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.VeZA0JwpF.zr2WakftCtj.W.kxhQjtu', 'tadams@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 144);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 144);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 144);
INSERT INTO RESOURCES(id, resource)
VALUES (144, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (144, 144);
INSERT INTO USERS(id, username, password, email)
VALUES (145, 'rossbrenda', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.9jki3Uon2K2S4ju/DI/bFX1ouGaUiCC',
        'johnathanhoward@example.net');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 145);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 145);
INSERT INTO RESOURCES(id, resource)
VALUES (145, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (145, 145);
INSERT INTO USERS(id, username, password, email)
VALUES (146, 'loricardenas', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.3QvoYoAyF1ki73gA0MBndOKjQ5.ajjC',
        'villanuevaashley@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 146);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 146);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 146);
INSERT INTO RESOURCES(id, resource)
VALUES (146, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (146, 146);
INSERT INTO USERS(id, username, password, email)
VALUES (147, 'stacychan', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.ViLPqhgcPiNl8FPwTw8JNtHiK8zs8Ra', 'michael83@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 147);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 147);
INSERT INTO RESOURCES(id, resource)
VALUES (147, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (147, 147);
INSERT INTO USERS(id, username, password, email)
VALUES (148, 'brittany52', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.udwIctv7WYiN4ZKo0KNJfOlkEE6bBze',
        'escobartimothy@example.com');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (1, 148);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 148);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (1, 148);
INSERT INTO RESOURCES(id, resource)
VALUES (148, 'Message you can read/write');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (148, 148);
INSERT INTO USERS(id, username, password, email)
VALUES (149, 'armstrongallen', '$2b$12$Jnai20Sfe5rBeIpsHlj8R.wkTmia6bKjEQS3Ly9lKcgg/Uxha5Nza',
        'christopher49@example.org');
INSERT INTO USERS_ROLES(roles_id, users_id)
VALUES (0, 149);
INSERT INTO USERS_AUTHORITIES(authorities_id, users_id)
VALUES (0, 149);
INSERT INTO RESOURCES(id, resource)
VALUES (149, 'Message you can read');
INSERT INTO CUSTOMERS(id, resource_id)
VALUES (149, 149);