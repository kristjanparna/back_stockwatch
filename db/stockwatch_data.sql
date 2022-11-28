INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'customer');

INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Andres', 'Orgla', 'andres@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Kristjan', 'Pärna', 'kristjan@email.com', DEFAULT, NULL);

INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 1, NULL, 'admin', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 1, 'Andres', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 2, 'Kristjan', '123');




