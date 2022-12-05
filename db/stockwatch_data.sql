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

INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'MSFT');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'APPL');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'GM');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'F');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'MMM');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'CAT');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'RWE');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'BA');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'BABA');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'IBM');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'AMD');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'COST');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'XOM');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'AMZN');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'MS');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'OXLC');
INSERT INTO public.instrument (id, ticker) VALUES (DEFAULT, 'ZEN');

INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 3, 105.00, 20.00, null, 50.00, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 5, 120.00, 20.00, null, 60.00, DEFAULT);

INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'buy');
INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'sell');
