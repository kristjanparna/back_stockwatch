INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type)
VALUES (DEFAULT, 'customer');

INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'buy');
INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'sell');

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
INSERT INTO public.contact (id, first_name, last_name, email, start, "end")
VALUES (DEFAULT, 'Dominic', 'Toretto', 'racerboy@email.com', DEFAULT, NULL);

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
INSERT INTO public."user" (id, role_id, contact_id, username, password)
VALUES (DEFAULT, 2, 10, 'DOM', '123');

INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MSFT', 'Microsoft Corporation');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'AAPL', 'Apple Inc');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'GM', 'General Motors');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'F', 'Ford Motor Company');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MMM', '3M');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'CAT', 'Caterpillar');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'RWE.DE', 'RWE AG');
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
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'ZIM', 'ZIM Integrated Shipping');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'MVIS', 'MicroVision');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'NVDA', 'Nvidia');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'DIS', 'Walt Disney Company (The)');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'BYD', 'BYD');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'DELL', 'Dell Technologies Inc.');
INSERT INTO public.instrument (id, ticker, shortname) VALUES (DEFAULT, 'PFE', 'Pfizer, Inc.');

INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 24, 30, 60, 'Kas koroona tuleb tagasi?', 50.24, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 2, 180, null, 'Ootan uut iPhone', 140.94, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 2, 180, null, 'Ootan uut iPhone', 140.94, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 3, 180, null, null, 37.96, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 2, 7 , 36, 50, 'Kõrgete energiahindade tuules võiks ise ka rikkaks saada', 42.12, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 1, 24, 30, 60, 'Kas koroona tuleb tagasi?', 50.24, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 1, 2, 180, null, 'Ootan uut iPhone', 140.94, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 1, 2, 180, null, 'Ootan uut iPhone', 140.94, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 1, 3, 180, null, null, 37.96, DEFAULT);
INSERT INTO public.watchlist (id, user_id, instrument_id, price_higher, price_lower, user_comment, price_at_addition, addition_date)
VALUES (DEFAULT, 1, 7 , 36, 50, 'Kõrgete energiahindade tuules võiks ise ka rikkaks saada', 42.12, DEFAULT);

INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 9, 120.00, 60, 5.00, '2022-11-01');
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 13, 15.00, 10, null, '2022-05-30');
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 10, 120.00, 60, 5.00, '2022-10-30');
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 11, 15.00, 10, null, '2022-12-05');
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 1, 9, 120.00, 60, 5.00, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 1, 13, 15.00, 10, null, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 9, 120.00, 60, 5.00, '2021-04-27');
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 15, 15.00, 10, null, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 1, 7, 120.00, 60, 5.00, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 1, 15, 15.00, 10, null, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 19, 18.00, 10, null, DEFAULT);
INSERT INTO public.portfolio (id, user_id, instrument_id, purchase_price, amount, transaction_fee, purchase_date)
VALUES (DEFAULT, 2, 9, 120, 60, 10, '2022-11-15');

INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 1, 1, 60, 120.00, '2022-11-01');
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 2, 1, 10, 15.00, '2022-05-30');
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 3, 1, 60, 120.00, '2022-10-30');
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 4, 1, 10, 15.00, '2022-12-05');
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 5, 1, 60, 120.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 6, 1, 10, 15.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 7, 1, 60, 120.00, '2021-04-27');
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 8, 1, 10, 15.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 9, 1, 60, 120.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 10, 1, 10, 15.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 11, 1, 10, 18.00, DEFAULT);
INSERT INTO public.transaction (id, portfolio_id, transaction_type_id, amount, price, date)
VALUES (DEFAULT, 12, 2, 9, 120, '2022-11-15');


