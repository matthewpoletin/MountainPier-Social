--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2018-03-27 17:53:52 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

-- User: mountainpier
-- DROP USER mountainpier;

CREATE USER mountainpier WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;

--
-- TOC entry 3133 (class 1262 OID 27017)
-- Name: mountainpier-social; Type: DATABASE; Schema: -; Owner: mountainpier
--

CREATE DATABASE "mountainpier-social" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';


ALTER DATABASE "mountainpier-social" OWNER TO mountainpier;

\connect -reuse-previous=on "dbname='mountainpier-social'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13241)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3135 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 27020)
-- Name: relations; Type: TABLE; Schema: public; Owner: mountainpier
--

CREATE TABLE relations (
    relations_id integer NOT NULL,
    relations_est_date timestamp without time zone,
    relations_type character varying(255),
    relations_user_a_id integer,
    relations_user_b_id integer
);


ALTER TABLE relations OWNER TO mountainpier;

--
-- TOC entry 196 (class 1259 OID 27018)
-- Name: relations_relations_id_seq; Type: SEQUENCE; Schema: public; Owner: mountainpier
--

CREATE SEQUENCE relations_relations_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relations_relations_id_seq OWNER TO mountainpier;

--
-- TOC entry 3136 (class 0 OID 0)
-- Dependencies: 196
-- Name: relations_relations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mountainpier
--

ALTER SEQUENCE relations_relations_id_seq OWNED BY relations.relations_id;


--
-- TOC entry 199 (class 1259 OID 27028)
-- Name: users; Type: TABLE; Schema: public; Owner: mountainpier
--

CREATE TABLE users (
    users_id integer NOT NULL,
    users_avatar character varying(255),
    users_birth_date timestamp without time zone,
    users_reg_date timestamp without time zone,
    users_reg_email character varying(255),
    users_status character varying(255),
    users_username character varying(255)
);


ALTER TABLE users OWNER TO mountainpier;

--
-- TOC entry 198 (class 1259 OID 27026)
-- Name: users_users_id_seq; Type: SEQUENCE; Schema: public; Owner: mountainpier
--

CREATE SEQUENCE users_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_users_id_seq OWNER TO mountainpier;

--
-- TOC entry 3137 (class 0 OID 0)
-- Dependencies: 198
-- Name: users_users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mountainpier
--

ALTER SEQUENCE users_users_id_seq OWNED BY users.users_id;


--
-- TOC entry 2994 (class 2604 OID 27023)
-- Name: relations relations_id; Type: DEFAULT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY relations ALTER COLUMN relations_id SET DEFAULT nextval('relations_relations_id_seq'::regclass);


--
-- TOC entry 2995 (class 2604 OID 27031)
-- Name: users users_id; Type: DEFAULT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY users ALTER COLUMN users_id SET DEFAULT nextval('users_users_id_seq'::regclass);


--
-- TOC entry 3126 (class 0 OID 27020)
-- Dependencies: 197
-- Data for Name: relations; Type: TABLE DATA; Schema: public; Owner: mountainpier
--

COPY relations (relations_id, relations_est_date, relations_type, relations_user_a_id, relations_user_b_id) FROM stdin;
\.


--
-- TOC entry 3128 (class 0 OID 27028)
-- Dependencies: 199
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: mountainpier
--

COPY users (users_id, users_avatar, users_birth_date, users_reg_date, users_reg_email, users_status, users_username) FROM stdin;
\.


--
-- TOC entry 3138 (class 0 OID 0)
-- Dependencies: 196
-- Name: relations_relations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mountainpier
--

SELECT pg_catalog.setval('relations_relations_id_seq', 1, false);


--
-- TOC entry 3139 (class 0 OID 0)
-- Dependencies: 198
-- Name: users_users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mountainpier
--

SELECT pg_catalog.setval('users_users_id_seq', 1, false);


--
-- TOC entry 2997 (class 2606 OID 27025)
-- Name: relations relations_pkey; Type: CONSTRAINT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_pkey PRIMARY KEY (relations_id);


--
-- TOC entry 2999 (class 2606 OID 27038)
-- Name: users uk_o8aun046cuf6ekagariotbu35; Type: CONSTRAINT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_o8aun046cuf6ekagariotbu35 UNIQUE (users_username);


--
-- TOC entry 3001 (class 2606 OID 27036)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (users_id);


--
-- TOC entry 3002 (class 2606 OID 27039)
-- Name: relations fko70lnr3ukk37c3qutqisy8aw3; Type: FK CONSTRAINT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT fko70lnr3ukk37c3qutqisy8aw3 FOREIGN KEY (relations_user_a_id) REFERENCES users(users_id);


--
-- TOC entry 3003 (class 2606 OID 27044)
-- Name: relations fksgpl7nl50y6lwkajkn55kk22p; Type: FK CONSTRAINT; Schema: public; Owner: mountainpier
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT fksgpl7nl50y6lwkajkn55kk22p FOREIGN KEY (relations_user_b_id) REFERENCES users(users_id);


-- Completed on 2018-03-27 17:53:52 MSK

--
-- PostgreSQL database dump complete
--

