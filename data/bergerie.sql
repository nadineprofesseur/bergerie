-- Table: public.mouton

-- DROP TABLE public.mouton;

CREATE TABLE public.mouton
(
    id integer NOT NULL,
    nom text COLLATE pg_catalog."default",
    couleur text COLLATE pg_catalog."default",
    poids text COLLATE pg_catalog."default",
    naissance text COLLATE pg_catalog."default",
    CONSTRAINT mouton_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.mouton
    OWNER to postgres;