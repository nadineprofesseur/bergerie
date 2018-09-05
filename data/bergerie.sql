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
    id integer NOT NULL,
    nom text,
    couleur text,
    poids text,
    naissance text
);


ALTER TABLE mouton OWNER TO postgres;

--
-- Data for Name: mouton; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mouton VALUES (2, 'Molly', 'Blanche', '20', '7 juillet 2018');
INSERT INTO mouton VALUES (1, 'Dolly', 'Rousse', '20', '5 juin 2015');
INSERT INTO mouton VALUES (3, 'Marguerite', 'Tachetée', '20', '2 août 2017');


--
-- Name: mouton mouton_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mouton
    ADD CONSTRAINT mouton_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

