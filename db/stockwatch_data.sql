INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, role_id, username, password) VALUES (DEFAULT, 1, 'admin', '123');
INSERT INTO public."user" (id, role_id, username, password) VALUES (DEFAULT, 2, 'Andres', '123');
INSERT INTO public."user" (id, role_id, username, password) VALUES (DEFAULT, 2, 'Kristjan', '123');


