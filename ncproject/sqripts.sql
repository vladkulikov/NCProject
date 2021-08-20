-- Table: public.entity_type

-- DROP TABLE public.entity_type;

CREATE TABLE public.entity_type
(
    entity_type_id integer NOT NULL,
    entity_type_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT entity_type_pkey PRIMARY KEY (entity_type_id)
)

TABLESPACE pg_default;

ALTER TABLE public.entity_type
    OWNER to postgres;



-- Table: public.entity_type_attribute

-- DROP TABLE public.entity_type_attribute;

CREATE TABLE public.entity_type_attribute
(
    entity_type_id integer NOT NULL,
    attribute_id integer NOT NULL,
    CONSTRAINT entity_type_attribute_pkey PRIMARY KEY (entity_type_id, attribute_id),
    CONSTRAINT attribute_id FOREIGN KEY (attribute_id)
        REFERENCES public.attribute (attribute_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
        NOT VALID,
    CONSTRAINT entity_type_id FOREIGN KEY (entity_type_id)
        REFERENCES public.entity_type (entity_type_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.entity_type_attribute
    OWNER to postgres;



-- Table: public.attribute

-- DROP TABLE public.attribute;

CREATE TABLE public.attribute
(
    attribute_id integer NOT NULL,
    attribute_name text COLLATE pg_catalog."default" NOT NULL,
    attribute_type integer,
    attribute_multiply boolean,
    CONSTRAINT attribute_pkey PRIMARY KEY (attribute_id)
)

TABLESPACE pg_default;

ALTER TABLE public.attribute
    OWNER to postgres;



-- Table: public.value

-- DROP TABLE public.value;

CREATE TABLE public.value
(
    value_id integer NOT NULL,
    entity_id integer NOT NULL,
    attribute_id integer NOT NULL,
    value text COLLATE pg_catalog."default",
    reference integer,
    CONSTRAINT value_pkey PRIMARY KEY (value_id),
    CONSTRAINT attribute_id FOREIGN KEY (attribute_id)
        REFERENCES public.attribute (attribute_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
        NOT VALID,
    CONSTRAINT entity_id FOREIGN KEY (entity_id)
        REFERENCES public.entity (entity_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT reference FOREIGN KEY (reference)
        REFERENCES public.entity (entity_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT
)

TABLESPACE pg_default;

ALTER TABLE public.value
    OWNER to postgres;



-- Table: public.entity

-- DROP TABLE public.entity;

CREATE TABLE public.entity
(
    entity_id integer NOT NULL,
    entity_name text COLLATE pg_catalog."default" NOT NULL,
    entity_type_id integer NOT NULL,
    CONSTRAINT entity_pkey PRIMARY KEY (entity_id),
    CONSTRAINT entity_type_id FOREIGN KEY (entity_type_id)
        REFERENCES public.entity_type (entity_type_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.entity
    OWNER to postgres;










