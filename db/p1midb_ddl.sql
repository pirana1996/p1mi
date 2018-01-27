-- Database: p1midb

-- DROP DATABASE p1midb;

CREATE DATABASE p1midb
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Arabic_Saudi Arabia.1256'
    LC_CTYPE = 'Arabic_Saudi Arabia.1256'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE p1midb
    IS 'Database for the project "Mission Impossible"';
    
CREATE TABLE "person" (

	person_id serial PRIMARY KEY,

    first_name varchar(20),

    last_name varchar(20),

    country varchar(20),

    city varchar(20),

    birth_date timestamp,

    total_rating float(2),

    phone_number varchar(20),

    description text

);



CREATE TABLE category (

	category_id serial PRIMARY KEY,

    super_category_id integer REFERENCES category ON DELETE CASCADE ON UPDATE CASCADE,

    "name" varchar(20)

);



CREATE TABLE "product" (

	product_id serial PRIMARY KEY,

    seller_id integer REFERENCES "person" (person_id) ON DELETE CASCADE ON UPDATE CASCADE,

    buyer_id integer REFERENCES "person" (person_id) ON DELETE SET NULL ON UPDATE CASCADE,

    category_id integer REFERENCES category (category_id) ON DELETE RESTRICT ON UPDATE CASCADE,

    "name" varchar(50),

    description text,

    "location" text,

    is_sold bool,

    bidding_allowed bool,

    price integer

);



CREATE TABLE "comment" (

	comment_id serial PRIMARY KEY,

    person_id integer REFERENCES "person" ON DELETE CASCADE ON UPDATE CASCADE,

    product_id integer REFERENCES product ON DELETE CASCADE ON UPDATE CASCADE,

    "content" text,

    date_time timestamp without time zone,

    repy_to integer REFERENCES "comment"  ON DELETE CASCADE ON UPDATE CASCADE

);



CREATE TABLE picture (

	picture_id serial PRIMARY KEY,

    product_id integer REFERENCES product ON DELETE CASCADE ON UPDATE CASCADE,

    "content" varchar

);



CREATE TABLE rating (

	rating_id serial PRIMARY KEY,

    buyer_id integer REFERENCES "person" ON DELETE CASCADE ON UPDATE CASCADE,

    seller_id integer REFERENCES "person" ON DELETE SET NULL ON UPDATE CASCADE,

    stars integer CHECK (stars BETWEEN 0 AND 5) DEFAULT 0,

    "comment" text

);



CREATE TABLE bid (

	bid_id serial PRIMARY KEY,

    bidder_id integer REFERENCES "person" (person_id) ON DELETE CASCADE ON UPDATE CASCADE,

    product_id integer REFERENCES product (product_id) ON DELETE CASCADE ON UPDATE CASCADE,

    amount integer CHECK (amount>=0),

    date_time timestamp without time zone

);