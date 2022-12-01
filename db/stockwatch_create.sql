-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-12-01 09:20:37.688

-- tables
-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         first_name varchar(50)  NOT NULL,
                         last_name varchar(50)  NOT NULL,
                         email varchar(255)  NOT NULL,
                         start date  NOT NULL DEFAULT NOW(),
                         "end" date  NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: instrument
CREATE TABLE instrument (
                            id serial  NOT NULL,
                            ticker varchar(255)  NOT NULL,
                            CONSTRAINT instrument_ak_1 UNIQUE (ticker) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                            CONSTRAINT instrument_pk PRIMARY KEY (id)
);

-- Table: portfolio
CREATE TABLE portfolio (
                           id serial  NOT NULL,
                           user_id int  NOT NULL,
                           instrument_id int  NOT NULL,
                           purchase_price decimal(6,2)  NOT NULL,
                           amount int  NOT NULL,
                           transaction_fee decimal(4,2)  NULL,
                           purchase_date date  NOT NULL DEFAULT NOW(),
                           CONSTRAINT portfolio_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: transaction
CREATE TABLE transaction (
                             id serial  NOT NULL,
                             portfolio_id int  NOT NULL,
                             transaction_type_id int  NOT NULL,
                             amount int  NOT NULL,
                             price decimal(6,2)  NOT NULL,
                             date date  NOT NULL DEFAULT NOW(),
                             CONSTRAINT transaction_pk PRIMARY KEY (id)
);

-- Table: transaction_type
CREATE TABLE transaction_type (
                                  id serial  NOT NULL,
                                  name varchar(255)  NOT NULL,
                                  CONSTRAINT transaction_type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL DEFAULT 2,
                        contact_id int  NULL,
                        username varchar(50)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: watchlist
CREATE TABLE watchlist (
                           id serial  NOT NULL,
                           user_id int  NOT NULL,
                           instrument_id int  NOT NULL,
                           price_higher decimal(6,2)  NULL,
                           price_lower decimal(6,2)  NULL,
                           user_comment varchar(255)  NULL,
                           price_at_addition decimal(6,2)  NOT NULL,
                           addition_date date  NOT NULL DEFAULT NOW(),
                           CONSTRAINT watchlist_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: portfolio_instrument (table: portfolio)
ALTER TABLE portfolio ADD CONSTRAINT portfolio_instrument
    FOREIGN KEY (instrument_id)
        REFERENCES instrument (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: portfolio_user (table: portfolio)
ALTER TABLE portfolio ADD CONSTRAINT portfolio_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_portfolio (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_portfolio
    FOREIGN KEY (portfolio_id)
        REFERENCES portfolio (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_transaction_type (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_transaction_type
    FOREIGN KEY (transaction_type_id)
        REFERENCES transaction_type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: watchlist_instrument (table: watchlist)
ALTER TABLE watchlist ADD CONSTRAINT watchlist_instrument
    FOREIGN KEY (instrument_id)
        REFERENCES instrument (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: watchlist_user (table: watchlist)
ALTER TABLE watchlist ADD CONSTRAINT watchlist_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

