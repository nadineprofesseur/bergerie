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

--
-- Name: journaliser(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION journaliser() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
DECLARE 
	description text;
    objetAvant text;
    objetApres text;
    operation text;
BEGIN
	objetAvant := '';
	objetApres := '';

	IF TG_OP = 'UPDATE' THEN
    	objetAvant := '{'||OLD.nom||','||OLD.couleur||','||OLD.naissance||'}';
   		objetApres := '{'||NEW.nom||','||NEW.couleur||','||NEW.naissance||'}';
        operation := 'MODIFIER';
    END IF;
	IF TG_OP = 'INSERT' THEN
    	objetAvant := '{}';
   		objetApres := '{'||NEW.nom||','||NEW.couleur||','||NEW.naissance||'}';
        operation := 'AJOUTER';
    END IF;
	IF TG_OP = 'DELETE' THEN
    	objetAvant := '{'||OLD.nom||','||OLD.couleur||','||OLD.naissance||'}';
    	objetApres := '{}';
        operation := 'EFFACER';
    END IF;

	description := objetAvant || ' -> ' || objetApres;
    -- https://www.postgresql.org/docs/9.1/static/plpgsql-trigger.html
	INSERT into journal(moment, operation, objet, description) VALUES(NOW(), operation, 'mouton', description);
    
	IF TG_OP = 'DELETE' THEN
		return OLD;
	END IF; 
    return NEW;
END
$$;


ALTER FUNCTION public.journaliser() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: distinction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE distinction (
    id integer NOT NULL,
    annee integer,
    titre text,
    detail text,
    mouton integer
);


ALTER TABLE distinction OWNER TO postgres;

--
-- Name: distinction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE distinction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE distinction_id_seq OWNER TO postgres;

--
-- Name: distinction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE distinction_id_seq OWNED BY distinction.id;


--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE journal (
    id integer NOT NULL,
    moment timestamp with time zone NOT NULL,
    operation text NOT NULL,
    description text,
    objet text NOT NULL
);


ALTER TABLE journal OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE journal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE journal_id_seq OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE journal_id_seq OWNED BY journal.id;


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
-- Name: distinction id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction ALTER COLUMN id SET DEFAULT nextval('distinction_id_seq'::regclass);


--
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal ALTER COLUMN id SET DEFAULT nextval('journal_id_seq'::regclass);


--
-- Name: mouton id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mouton ALTER COLUMN id SET DEFAULT nextval('mouton_id_seq'::regclass);


--
-- Data for Name: distinction; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO distinction VALUES (1, 2017, 'Mouton le plus sage', NULL, 2);
INSERT INTO distinction VALUES (2, 2015, 'Mouton le plus rapide', NULL, 2);
INSERT INTO distinction VALUES (3, 2016, 'Mouton le plus roux', NULL, 1);
INSERT INTO distinction VALUES (4, 2016, 'Mouton le plus noir', NULL, 2);


--
-- Name: distinction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('distinction_id_seq', 4, true);


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO journal VALUES (1, '2018-09-20 10:30:34.923266-04', 'AJOUTER', '{Dolly, 2016-06-01}', 'mouton');
INSERT INTO journal VALUES (11, '2018-09-20 10:59:36.967935-04', 'AJOUTER', '{Dolly, 2016-06-01}', 'mouton');
INSERT INTO journal VALUES (12, '2018-09-20 11:00:58.498813-04', 'AJOUTER', '{Dolly, 2016-06-01}', 'mouton');
INSERT INTO journal VALUES (13, '2018-09-20 11:04:32.144692-04', 'AJOUTER', '{Jojo}', 'mouton');
INSERT INTO journal VALUES (14, '2018-09-20 11:06:51.817885-04', 'AJOUTER', '{Jojo}', 'mouton');
INSERT INTO journal VALUES (15, '2018-09-20 11:23:48.700641-04', 'INSERT', '{Jojo} -> {Jojo}', 'mouton');
INSERT INTO journal VALUES (16, '2018-09-20 11:29:06.004611-04', 'INSERT', ' -> {Jojo,verte,aout}', 'mouton');
INSERT INTO journal VALUES (17, '2018-09-20 11:30:33.415524-04', 'INSERT', ' -> {Jojo,verte,aout}', 'mouton');
INSERT INTO journal VALUES (18, '2018-09-20 11:35:55.719039-04', 'AJOUTER', ' -> {Jojo,verte,aout}', 'mouton');
INSERT INTO journal VALUES (19, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (20, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (21, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (22, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (23, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (24, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (25, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (26, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (27, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (28, '2018-09-20 11:37:11.75627-04', 'MODIFIER', '{Jojo,verte,aout} -> {Loulou,verte,aout}', 'mouton');
INSERT INTO journal VALUES (29, '2018-09-20 11:39:37.70787-04', 'EFFACER', '{Loulou,verte,aout} -> ', 'mouton');
INSERT INTO journal VALUES (30, '2018-09-20 11:40:48.312734-04', 'EFFACER', '{Loulou,verte,aout} -> {}', 'mouton');
INSERT INTO journal VALUES (31, '2018-09-20 11:42:43.235306-04', 'EFFACER', '{Loulou,verte,aout} -> {}', 'mouton');


--
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('journal_id_seq', 31, true);


--
-- Data for Name: mouton; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO mouton VALUES ('Dodo', 'Rose', '', '', 5);
INSERT INTO mouton VALUES ('Marguerite', 'Tachetée', '10', '2 août 2017', 3);
INSERT INTO mouton VALUES ('test', 'test', 'test', 'test', 13);
INSERT INTO mouton VALUES ('alloallo', 'rose', '', '', 4);
INSERT INTO mouton VALUES ('Blabla', 'Rouge', '5', '2018', 14);
INSERT INTO mouton VALUES ('Kwei kwei', 'Noir', '5', '2016', 6);
INSERT INTO mouton VALUES ('Dolly', 'Rousse', '20', '5 juin 2015', 2);
INSERT INTO mouton VALUES ('Molly2', 'Blanche', '20', '7 juillet 2018', 1);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 24);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 25);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 27);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 28);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 29);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 31);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 33);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 34);
INSERT INTO mouton VALUES ('Loulou', 'verte', '7', 'aout', 36);


--
-- Name: mouton_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('mouton_id_seq', 36, true);


--
-- Name: distinction distinction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction
    ADD CONSTRAINT distinction_pkey PRIMARY KEY (id);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: mouton mouton_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY mouton
    ADD CONSTRAINT mouton_pkey PRIMARY KEY (id);


--
-- Name: fki_one_mouton_to_many_distinction; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_mouton_to_many_distinction ON distinction USING btree (mouton);


--
-- Name: mouton evenementajoutmouton; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementajoutmouton BEFORE INSERT ON mouton FOR EACH ROW EXECUTE PROCEDURE journaliser();


--
-- Name: mouton evenementeffacermouton; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementeffacermouton BEFORE DELETE ON mouton FOR EACH ROW EXECUTE PROCEDURE journaliser();


--
-- Name: mouton evenementmodifiermouton; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementmodifiermouton BEFORE UPDATE ON mouton FOR EACH ROW EXECUTE PROCEDURE journaliser();


--
-- Name: distinction one_mouton_to_many_distinction; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY distinction
    ADD CONSTRAINT one_mouton_to_many_distinction FOREIGN KEY (mouton) REFERENCES mouton(id);


--
-- PostgreSQL database dump complete
--

