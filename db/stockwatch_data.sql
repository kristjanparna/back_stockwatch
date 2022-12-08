INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'customer');

INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Andres', 'Orgla', 'andres@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Kristjan', 'Pärna', 'kristjan@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'John', 'Doe', 'j.d@anonymus.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'John', 'Wick', 'donttouchmydog@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'John', 'McClane', 'yippee-ki-yay@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Rocky', 'Balboa', 'boxer12@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'H.M', 'Murdock', 'h.m@a-team.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Michael', 'Knight', 'kitt@email.com', DEFAULT, NULL);
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'John', 'Matrix', 'mrolympia@email.com', DEFAULT, NULL);

INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 1, NULL, 'admin', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 1, 'Andres', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 2, 'Kristjan', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 3, 'John', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 4, 'Wick', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 5, 'Nakatomi', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 6, 'Rocky', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 7, 'Captain', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 8, 'BestDriver', '123');
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 9, 'commando', '123');

INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MSFT', 'Microsoft Corporation');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'APPL', 'Apple Inc');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'GM', 'General Motors');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'F', 'Ford Motor Company');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MMM', '3M');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'CAT', 'Caterpillar');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'RWE', 'RWE AG');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'BA', 'Boeing');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'BABA', 'AliBaba');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'IBM', 'International Business Machines');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'AMD', 'Advanced Micro Devices');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'COST', 'Costco');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'XOM', 'ExXon Mobile');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'AMZN', 'Amazon');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MS', 'Morgan Stanley');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'OXLC', 'Oxford Lane Capital Corp');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'ZEN', 'ZenDesk');

INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 3, 105.00, 20.00, null, 50.00, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 5, 120.00, 20.00, null, 60.00, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 17, 120.00, 20.00, null, 60.00, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 6, 5, 100, null, null, 76.51 , DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 6, 12, 430, null, 'Ootan jaemüügi aeglustumist', 481.16 , DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 5, 12, 430, null, 'Ootan jaemüügi aeglustumist', 481.16 , DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 5, 5, 120.00, 20.00, null, 60.00, DEFAULT);

INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 10, 120.00, 60, 5.00, DEFAULT);

INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 11, 15.00, 10, null, DEFAULT);

INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'buy');
INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'sell');
