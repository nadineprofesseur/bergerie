--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.4
-- Dumped by pg_dump version 9.6.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: bergerie; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE bergerie WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE bergerie OWNER TO postgres;

\connect bergerie

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: mouton; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE mouton (
    nom text,
    couleur text,
    poids text,
    naissance text,
    id integer NOT NULL
);


ALTER TABLE mouton OWNER TO postgres;

--
-- Name: mouton_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE mouton_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mouton_id_seq OWNER TO postgres;

--
-- Name: mouton_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE mouton_id_seq OWNED BY mouton.id;


--
-- Name: mouton id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mouton ALTER COLUMN id SET DEFAULT nextval('mouton_id_seq'::regclass);


--
-- Data for Name: mouton; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mouton VALUES ('Molly', 'Blanche', '20', '7 juillet 2018', 1);
INSERT INTO mouton VALUES ('Dolly', 'Rousse', '20', '5 juin 2015', 2);
INSERT INTO mouton VALUES ('Marguerite', 'Tachetée', '20', '2 août 2017', 3);
INSERT INTO mouton VALUES ('allo', 'rose', '', '', 4);


--
-- Name: mouton_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mouton_id_seq', 4, true);


--
-- Name: mouton mouton_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mouton
    ADD CONSTRAINT mouton_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

