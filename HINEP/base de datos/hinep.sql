--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.0
-- Dumped by pg_dump version 9.2.0
-- Started on 2012-10-22 14:47:11

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 208 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 208
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 33202)
-- Name: camas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE camas (
    id_cama numeric NOT NULL,
    desc_cama character varying(50),
    nro_habitacion character varying(30),
    disponible boolean
);


ALTER TABLE public.camas OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 33200)
-- Name: camas_id_cama_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE camas_id_cama_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.camas_id_cama_seq OWNER TO postgres;

--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 170
-- Name: camas_id_cama_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE camas_id_cama_seq OWNED BY camas.id_cama;


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 170
-- Name: camas_id_cama_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('camas_id_cama_seq', 1, false);


--
-- TOC entry 173 (class 1259 OID 33368)
-- Name: cargos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cargos (
    id_cargo numeric NOT NULL,
    cargo character varying(30)
);


ALTER TABLE public.cargos OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 33366)
-- Name: cargos_id_cargo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cargos_id_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cargos_id_cargo_seq OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 172
-- Name: cargos_id_cargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cargos_id_cargo_seq OWNED BY cargos.id_cargo;


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 172
-- Name: cargos_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargos_id_cargo_seq', 1, false);


--
-- TOC entry 175 (class 1259 OID 33376)
-- Name: esperas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE esperas (
    id_esperas numeric NOT NULL,
    id_paciente numeric,
    fecha date,
    sintomas character varying(100),
    nivel_imp character varying(30),
    estado character varying(50)
);


ALTER TABLE public.esperas OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 33374)
-- Name: esperas_id_esperas_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE esperas_id_esperas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.esperas_id_esperas_seq OWNER TO postgres;

--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 174
-- Name: esperas_id_esperas_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE esperas_id_esperas_seq OWNED BY esperas.id_esperas;


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 174
-- Name: esperas_id_esperas_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('esperas_id_esperas_seq', 1, false);


--
-- TOC entry 177 (class 1259 OID 33393)
-- Name: guardias; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE guardias (
    id_guardia numeric NOT NULL,
    id_personal numeric,
    id_cargo numeric,
    fecha date
);


ALTER TABLE public.guardias OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 33391)
-- Name: guardias_id_guardia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE guardias_id_guardia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.guardias_id_guardia_seq OWNER TO postgres;

--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 176
-- Name: guardias_id_guardia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE guardias_id_guardia_seq OWNED BY guardias.id_guardia;


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 176
-- Name: guardias_id_guardia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('guardias_id_guardia_seq', 1, false);


--
-- TOC entry 179 (class 1259 OID 33409)
-- Name: historias_clinicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE historias_clinicas (
    id_historia numeric NOT NULL,
    id_personal numeric,
    id_paciente numeric,
    fecha date,
    diagnostico character varying(100),
    patologia character varying(100),
    peso character varying(20),
    talla character varying(20),
    hora time without time zone
);


ALTER TABLE public.historias_clinicas OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 33407)
-- Name: historias_clinicas_id_historia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE historias_clinicas_id_historia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.historias_clinicas_id_historia_seq OWNER TO postgres;

--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 178
-- Name: historias_clinicas_id_historia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE historias_clinicas_id_historia_seq OWNED BY historias_clinicas.id_historia;


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 178
-- Name: historias_clinicas_id_historia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('historias_clinicas_id_historia_seq', 1, false);


--
-- TOC entry 181 (class 1259 OID 33430)
-- Name: internaciones_transitorias; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE internaciones_transitorias (
    id_int numeric NOT NULL,
    id_servicio numeric,
    id_cama numeric,
    id_paciente numeric,
    id_pers_ing numeric,
    id_pers_alta numeric,
    fecha_ing date,
    hora_ing date,
    fecha_alta date,
    hora_alta date,
    motivo_alta character varying(50)
);


ALTER TABLE public.internaciones_transitorias OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 33428)
-- Name: internaciones_transitorias_id_int_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE internaciones_transitorias_id_int_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.internaciones_transitorias_id_int_seq OWNER TO postgres;

--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 180
-- Name: internaciones_transitorias_id_int_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE internaciones_transitorias_id_int_seq OWNED BY internaciones_transitorias.id_int;


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 180
-- Name: internaciones_transitorias_id_int_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('internaciones_transitorias_id_int_seq', 1, false);


--
-- TOC entry 183 (class 1259 OID 33461)
-- Name: medicaciones; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medicaciones (
    id_medicacion numeric NOT NULL,
    id_prescripcion numeric,
    id_personal numeric,
    fecha date,
    hora date,
    dosis character varying(30)
);


ALTER TABLE public.medicaciones OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 33459)
-- Name: medicaciones_id_medicacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE medicaciones_id_medicacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicaciones_id_medicacion_seq OWNER TO postgres;

--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 182
-- Name: medicaciones_id_medicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE medicaciones_id_medicacion_seq OWNED BY medicaciones.id_medicacion;


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 182
-- Name: medicaciones_id_medicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('medicaciones_id_medicacion_seq', 1, false);


--
-- TOC entry 185 (class 1259 OID 33482)
-- Name: obras_sociales; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE obras_sociales (
    id_os numeric NOT NULL,
    nombre_os character varying(50)
);


ALTER TABLE public.obras_sociales OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 33480)
-- Name: obras_sociales_id_os_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE obras_sociales_id_os_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.obras_sociales_id_os_seq OWNER TO postgres;

--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 184
-- Name: obras_sociales_id_os_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE obras_sociales_id_os_seq OWNED BY obras_sociales.id_os;


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 184
-- Name: obras_sociales_id_os_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('obras_sociales_id_os_seq', 1, false);


--
-- TOC entry 187 (class 1259 OID 33490)
-- Name: ordenes_practicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ordenes_practicas (
    id_orden numeric NOT NULL,
    id_practica_servicio numeric,
    id_personal numeric,
    id_paciente numeric,
    fecha date
);


ALTER TABLE public.ordenes_practicas OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 33488)
-- Name: ordenes_practicas_id_orden_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ordenes_practicas_id_orden_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ordenes_practicas_id_orden_seq OWNER TO postgres;

--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 186
-- Name: ordenes_practicas_id_orden_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ordenes_practicas_id_orden_seq OWNED BY ordenes_practicas.id_orden;


--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 186
-- Name: ordenes_practicas_id_orden_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ordenes_practicas_id_orden_seq', 1, false);


--
-- TOC entry 189 (class 1259 OID 33516)
-- Name: pacientes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pacientes (
    id_paciente numeric NOT NULL,
    id_os numeric,
    numero_os character varying(20),
    nom_1 character varying(50),
    nom_2 character varying(50),
    ape_1 character varying(50),
    ape_2 character varying(50),
    dni character varying(15),
    fecha_nac date,
    sexo character varying(9)
);


ALTER TABLE public.pacientes OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 33514)
-- Name: pacientes_id_paciente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pacientes_id_paciente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pacientes_id_paciente_seq OWNER TO postgres;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 188
-- Name: pacientes_id_paciente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pacientes_id_paciente_seq OWNED BY pacientes.id_paciente;


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 188
-- Name: pacientes_id_paciente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pacientes_id_paciente_seq', 2, true);


--
-- TOC entry 191 (class 1259 OID 33536)
-- Name: permisos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permisos (
    id_permiso numeric NOT NULL,
    permiso character varying(60)
);


ALTER TABLE public.permisos OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 33534)
-- Name: permisos_id_permiso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE permisos_id_permiso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permisos_id_permiso_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 190
-- Name: permisos_id_permiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE permisos_id_permiso_seq OWNED BY permisos.id_permiso;


--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 190
-- Name: permisos_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('permisos_id_permiso_seq', 1, false);


--
-- TOC entry 193 (class 1259 OID 33552)
-- Name: personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal (
    id_personal numeric NOT NULL,
    nombre character varying(50),
    apellido character varying(50),
    dni character varying(15),
    fecha_nac date,
    domicilio character varying(50),
    telefono character varying(50),
    fecha_ing date,
    profesion character varying(30),
    matricula character varying(20)
);


ALTER TABLE public.personal OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 33550)
-- Name: personal_id_personal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE personal_id_personal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_id_personal_seq OWNER TO postgres;

--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 192
-- Name: personal_id_personal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE personal_id_personal_seq OWNED BY personal.id_personal;


--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 192
-- Name: personal_id_personal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('personal_id_personal_seq', 1, false);


--
-- TOC entry 195 (class 1259 OID 33560)
-- Name: practicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE practicas (
    id_practica numeric NOT NULL,
    id_personal numeric,
    id_orden numeric,
    fecha date,
    observacion character varying(100)
);


ALTER TABLE public.practicas OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 33558)
-- Name: practicas_id_practica_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE practicas_id_practica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.practicas_id_practica_seq OWNER TO postgres;

--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 194
-- Name: practicas_id_practica_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE practicas_id_practica_seq OWNED BY practicas.id_practica;


--
-- TOC entry 2188 (class 0 OID 0)
-- Dependencies: 194
-- Name: practicas_id_practica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('practicas_id_practica_seq', 1, false);


--
-- TOC entry 197 (class 1259 OID 33571)
-- Name: practicas_servicios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE practicas_servicios (
    id_practica_servicio numeric NOT NULL,
    id_servicio numeric,
    tipo_practica character varying(100)
);


ALTER TABLE public.practicas_servicios OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 33569)
-- Name: practicas_servicios_id_practica_servicio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE practicas_servicios_id_practica_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.practicas_servicios_id_practica_servicio_seq OWNER TO postgres;

--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 196
-- Name: practicas_servicios_id_practica_servicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE practicas_servicios_id_practica_servicio_seq OWNED BY practicas_servicios.id_practica_servicio;


--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 196
-- Name: practicas_servicios_id_practica_servicio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('practicas_servicios_id_practica_servicio_seq', 1, false);


--
-- TOC entry 199 (class 1259 OID 33587)
-- Name: prescripciones; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prescripciones (
    id_prescripcion numeric NOT NULL,
    id_receta numeric,
    id_remedio numeric,
    indicacion character varying(100)
);


ALTER TABLE public.prescripciones OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 33585)
-- Name: prescripciones_id_prescripcion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prescripciones_id_prescripcion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prescripciones_id_prescripcion_seq OWNER TO postgres;

--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 198
-- Name: prescripciones_id_prescripcion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prescripciones_id_prescripcion_seq OWNED BY prescripciones.id_prescripcion;


--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 198
-- Name: prescripciones_id_prescripcion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prescripciones_id_prescripcion_seq', 1, false);


--
-- TOC entry 201 (class 1259 OID 33609)
-- Name: recetas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recetas (
    id_receta numeric NOT NULL,
    id_personal numeric,
    id_paciente numeric,
    fecha date,
    hora date
);


ALTER TABLE public.recetas OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 33607)
-- Name: recetas_id_receta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recetas_id_receta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recetas_id_receta_seq OWNER TO postgres;

--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 200
-- Name: recetas_id_receta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recetas_id_receta_seq OWNED BY recetas.id_receta;


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 200
-- Name: recetas_id_receta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recetas_id_receta_seq', 1, false);


--
-- TOC entry 203 (class 1259 OID 33620)
-- Name: remedios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE remedios (
    id_remedio numeric NOT NULL,
    desc_remedio character varying(50),
    tipo_remedio character varying(30)
);


ALTER TABLE public.remedios OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 33618)
-- Name: remedios_id_remedio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE remedios_id_remedio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.remedios_id_remedio_seq OWNER TO postgres;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 202
-- Name: remedios_id_remedio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE remedios_id_remedio_seq OWNED BY remedios.id_remedio;


--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 202
-- Name: remedios_id_remedio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('remedios_id_remedio_seq', 1, false);


--
-- TOC entry 205 (class 1259 OID 33628)
-- Name: servicios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE servicios (
    id_servicio numeric NOT NULL,
    desc_servicio character varying(60)
);


ALTER TABLE public.servicios OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 33626)
-- Name: servicios_id_servicio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE servicios_id_servicio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.servicios_id_servicio_seq OWNER TO postgres;

--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 204
-- Name: servicios_id_servicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE servicios_id_servicio_seq OWNED BY servicios.id_servicio;


--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 204
-- Name: servicios_id_servicio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('servicios_id_servicio_seq', 1, false);


--
-- TOC entry 207 (class 1259 OID 33636)
-- Name: tutores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tutores (
    id_tutor numeric NOT NULL,
    nom_1 character varying(50),
    nom_2 character varying(50),
    ape_1 character varying(50),
    ape_2 character varying(50),
    dni character varying(15),
    telefono character varying(50),
    domicilio character varying(60)
);


ALTER TABLE public.tutores OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 33634)
-- Name: tutores_id_tutor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tutores_id_tutor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tutores_id_tutor_seq OWNER TO postgres;

--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 206
-- Name: tutores_id_tutor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tutores_id_tutor_seq OWNED BY tutores.id_tutor;


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 206
-- Name: tutores_id_tutor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tutores_id_tutor_seq', 1, false);


--
-- TOC entry 169 (class 1259 OID 33181)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id_usuario numeric NOT NULL,
    id_personal numeric,
    id_permiso numeric,
    usuario character varying(30),
    pass character varying(8)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 33179)
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 168
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuarios_id_usuario_seq OWNED BY usuarios.id_usuario;


--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 168
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuarios_id_usuario_seq', 1, true);


--
-- TOC entry 2051 (class 2604 OID 40969)
-- Name: id_cama; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY camas ALTER COLUMN id_cama SET DEFAULT nextval('camas_id_cama_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 40982)
-- Name: id_cargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargos ALTER COLUMN id_cargo SET DEFAULT nextval('cargos_id_cargo_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 40995)
-- Name: id_esperas; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY esperas ALTER COLUMN id_esperas SET DEFAULT nextval('esperas_id_esperas_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 41005)
-- Name: id_guardia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY guardias ALTER COLUMN id_guardia SET DEFAULT nextval('guardias_id_guardia_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 41015)
-- Name: id_historia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historias_clinicas ALTER COLUMN id_historia SET DEFAULT nextval('historias_clinicas_id_historia_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 41025)
-- Name: id_int; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias ALTER COLUMN id_int SET DEFAULT nextval('internaciones_transitorias_id_int_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 41035)
-- Name: id_medicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicaciones ALTER COLUMN id_medicacion SET DEFAULT nextval('medicaciones_id_medicacion_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 41046)
-- Name: id_os; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY obras_sociales ALTER COLUMN id_os SET DEFAULT nextval('obras_sociales_id_os_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 41059)
-- Name: id_orden; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas ALTER COLUMN id_orden SET DEFAULT nextval('ordenes_practicas_id_orden_seq'::regclass);


--
-- TOC entry 2060 (class 2604 OID 41069)
-- Name: id_paciente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pacientes ALTER COLUMN id_paciente SET DEFAULT nextval('pacientes_id_paciente_seq'::regclass);


--
-- TOC entry 2061 (class 2604 OID 41079)
-- Name: id_permiso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permisos ALTER COLUMN id_permiso SET DEFAULT nextval('permisos_id_permiso_seq'::regclass);


--
-- TOC entry 2062 (class 2604 OID 41092)
-- Name: id_personal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY personal ALTER COLUMN id_personal SET DEFAULT nextval('personal_id_personal_seq'::regclass);


--
-- TOC entry 2063 (class 2604 OID 41105)
-- Name: id_practica; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas ALTER COLUMN id_practica SET DEFAULT nextval('practicas_id_practica_seq'::regclass);


--
-- TOC entry 2064 (class 2604 OID 41115)
-- Name: id_practica_servicio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas_servicios ALTER COLUMN id_practica_servicio SET DEFAULT nextval('practicas_servicios_id_practica_servicio_seq'::regclass);


--
-- TOC entry 2065 (class 2604 OID 41125)
-- Name: id_prescripcion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prescripciones ALTER COLUMN id_prescripcion SET DEFAULT nextval('prescripciones_id_prescripcion_seq'::regclass);


--
-- TOC entry 2066 (class 2604 OID 41135)
-- Name: id_receta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recetas ALTER COLUMN id_receta SET DEFAULT nextval('recetas_id_receta_seq'::regclass);


--
-- TOC entry 2067 (class 2604 OID 41146)
-- Name: id_remedio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY remedios ALTER COLUMN id_remedio SET DEFAULT nextval('remedios_id_remedio_seq'::regclass);


--
-- TOC entry 2068 (class 2604 OID 41159)
-- Name: id_servicio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY servicios ALTER COLUMN id_servicio SET DEFAULT nextval('servicios_id_servicio_seq'::regclass);


--
-- TOC entry 2069 (class 2604 OID 41172)
-- Name: id_tutor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tutores ALTER COLUMN id_tutor SET DEFAULT nextval('tutores_id_tutor_seq'::regclass);


--
-- TOC entry 2050 (class 2604 OID 41185)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 2136 (class 0 OID 33202)
-- Dependencies: 171
-- Data for Name: camas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY camas (id_cama, desc_cama, nro_habitacion, disponible) FROM stdin;
\.


--
-- TOC entry 2137 (class 0 OID 33368)
-- Dependencies: 173
-- Data for Name: cargos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargos (id_cargo, cargo) FROM stdin;
\.


--
-- TOC entry 2138 (class 0 OID 33376)
-- Dependencies: 175
-- Data for Name: esperas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY esperas (id_esperas, id_paciente, fecha, sintomas, nivel_imp, estado) FROM stdin;
\.


--
-- TOC entry 2139 (class 0 OID 33393)
-- Dependencies: 177
-- Data for Name: guardias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY guardias (id_guardia, id_personal, id_cargo, fecha) FROM stdin;
\.


--
-- TOC entry 2140 (class 0 OID 33409)
-- Dependencies: 179
-- Data for Name: historias_clinicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY historias_clinicas (id_historia, id_personal, id_paciente, fecha, diagnostico, patologia, peso, talla, hora) FROM stdin;
\.


--
-- TOC entry 2141 (class 0 OID 33430)
-- Dependencies: 181
-- Data for Name: internaciones_transitorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY internaciones_transitorias (id_int, id_servicio, id_cama, id_paciente, id_pers_ing, id_pers_alta, fecha_ing, hora_ing, fecha_alta, hora_alta, motivo_alta) FROM stdin;
\.


--
-- TOC entry 2142 (class 0 OID 33461)
-- Dependencies: 183
-- Data for Name: medicaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY medicaciones (id_medicacion, id_prescripcion, id_personal, fecha, hora, dosis) FROM stdin;
\.


--
-- TOC entry 2143 (class 0 OID 33482)
-- Dependencies: 185
-- Data for Name: obras_sociales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY obras_sociales (id_os, nombre_os) FROM stdin;
0	NO_POSEE
1	OSEP
\.


--
-- TOC entry 2144 (class 0 OID 33490)
-- Dependencies: 187
-- Data for Name: ordenes_practicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ordenes_practicas (id_orden, id_practica_servicio, id_personal, id_paciente, fecha) FROM stdin;
\.


--
-- TOC entry 2145 (class 0 OID 33516)
-- Dependencies: 189
-- Data for Name: pacientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pacientes (id_paciente, id_os, numero_os, nom_1, nom_2, ape_1, ape_2, dni, fecha_nac, sexo) FROM stdin;
2	1	3544	Federico		Ramayo		35387887	1990-11-19	M
\.


--
-- TOC entry 2146 (class 0 OID 33536)
-- Dependencies: 191
-- Data for Name: permisos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permisos (id_permiso, permiso) FROM stdin;
0	administrador
\.


--
-- TOC entry 2147 (class 0 OID 33552)
-- Dependencies: 193
-- Data for Name: personal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personal (id_personal, nombre, apellido, dni, fecha_nac, domicilio, telefono, fecha_ing, profesion, matricula) FROM stdin;
8	SY	SOFT	123	2009-05-25	UNCA	444441	2012-08-13	ADMIN	\N
\.


--
-- TOC entry 2148 (class 0 OID 33560)
-- Dependencies: 195
-- Data for Name: practicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY practicas (id_practica, id_personal, id_orden, fecha, observacion) FROM stdin;
\.


--
-- TOC entry 2149 (class 0 OID 33571)
-- Dependencies: 197
-- Data for Name: practicas_servicios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY practicas_servicios (id_practica_servicio, id_servicio, tipo_practica) FROM stdin;
\.


--
-- TOC entry 2150 (class 0 OID 33587)
-- Dependencies: 199
-- Data for Name: prescripciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prescripciones (id_prescripcion, id_receta, id_remedio, indicacion) FROM stdin;
\.


--
-- TOC entry 2151 (class 0 OID 33609)
-- Dependencies: 201
-- Data for Name: recetas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recetas (id_receta, id_personal, id_paciente, fecha, hora) FROM stdin;
\.


--
-- TOC entry 2152 (class 0 OID 33620)
-- Dependencies: 203
-- Data for Name: remedios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY remedios (id_remedio, desc_remedio, tipo_remedio) FROM stdin;
\.


--
-- TOC entry 2153 (class 0 OID 33628)
-- Dependencies: 205
-- Data for Name: servicios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servicios (id_servicio, desc_servicio) FROM stdin;
\.


--
-- TOC entry 2154 (class 0 OID 33636)
-- Dependencies: 207
-- Data for Name: tutores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tutores (id_tutor, nom_1, nom_2, ape_1, ape_2, dni, telefono, domicilio) FROM stdin;
\.


--
-- TOC entry 2135 (class 0 OID 33181)
-- Dependencies: 169
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (id_usuario, id_personal, id_permiso, usuario, pass) FROM stdin;
1	8	0	admin	admin
\.


--
-- TOC entry 2073 (class 2606 OID 40971)
-- Name: pk_camas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY camas
    ADD CONSTRAINT pk_camas PRIMARY KEY (id_cama);


--
-- TOC entry 2075 (class 2606 OID 40984)
-- Name: pk_cargos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cargos
    ADD CONSTRAINT pk_cargos PRIMARY KEY (id_cargo);


--
-- TOC entry 2077 (class 2606 OID 40997)
-- Name: pk_esperas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY esperas
    ADD CONSTRAINT pk_esperas PRIMARY KEY (id_esperas);


--
-- TOC entry 2079 (class 2606 OID 41007)
-- Name: pk_guardias; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT pk_guardias PRIMARY KEY (id_guardia);


--
-- TOC entry 2081 (class 2606 OID 41017)
-- Name: pk_historiasclinicas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT pk_historiasclinicas PRIMARY KEY (id_historia);


--
-- TOC entry 2083 (class 2606 OID 41027)
-- Name: pk_internaciones; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT pk_internaciones PRIMARY KEY (id_int);


--
-- TOC entry 2085 (class 2606 OID 41037)
-- Name: pk_medicaciones; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT pk_medicaciones PRIMARY KEY (id_medicacion);


--
-- TOC entry 2087 (class 2606 OID 41048)
-- Name: pk_obrasociales; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY obras_sociales
    ADD CONSTRAINT pk_obrasociales PRIMARY KEY (id_os);


--
-- TOC entry 2089 (class 2606 OID 41061)
-- Name: pk_ordenespracticas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT pk_ordenespracticas PRIMARY KEY (id_orden);


--
-- TOC entry 2091 (class 2606 OID 41071)
-- Name: pk_pacientes; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pacientes
    ADD CONSTRAINT pk_pacientes PRIMARY KEY (id_paciente);


--
-- TOC entry 2093 (class 2606 OID 41081)
-- Name: pk_permiso; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permisos
    ADD CONSTRAINT pk_permiso PRIMARY KEY (id_permiso);


--
-- TOC entry 2095 (class 2606 OID 41094)
-- Name: pk_personal; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT pk_personal PRIMARY KEY (id_personal);


--
-- TOC entry 2097 (class 2606 OID 41107)
-- Name: pk_practicas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT pk_practicas PRIMARY KEY (id_practica);


--
-- TOC entry 2099 (class 2606 OID 41117)
-- Name: pk_practicasservicios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY practicas_servicios
    ADD CONSTRAINT pk_practicasservicios PRIMARY KEY (id_practica_servicio);


--
-- TOC entry 2101 (class 2606 OID 41127)
-- Name: pk_prescripciones; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT pk_prescripciones PRIMARY KEY (id_prescripcion);


--
-- TOC entry 2103 (class 2606 OID 41137)
-- Name: pk_recetas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT pk_recetas PRIMARY KEY (id_receta);


--
-- TOC entry 2105 (class 2606 OID 41148)
-- Name: pk_remedio; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY remedios
    ADD CONSTRAINT pk_remedio PRIMARY KEY (id_remedio);


--
-- TOC entry 2107 (class 2606 OID 41161)
-- Name: pk_servicios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY servicios
    ADD CONSTRAINT pk_servicios PRIMARY KEY (id_servicio);


--
-- TOC entry 2109 (class 2606 OID 41174)
-- Name: pk_tutores; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tutores
    ADD CONSTRAINT pk_tutores PRIMARY KEY (id_tutor);


--
-- TOC entry 2071 (class 2606 OID 41187)
-- Name: pk_usuarios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario);


--
-- TOC entry 2117 (class 2606 OID 41395)
-- Name: id_cama_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_cama_fkey FOREIGN KEY (id_cama) REFERENCES camas(id_cama);


--
-- TOC entry 2113 (class 2606 OID 41400)
-- Name: id_cargo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT id_cargo_fkey FOREIGN KEY (id_cargo) REFERENCES cargos(id_cargo);


--
-- TOC entry 2128 (class 2606 OID 41405)
-- Name: id_orden_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT id_orden_fkey FOREIGN KEY (id_orden) REFERENCES ordenes_practicas(id_orden);


--
-- TOC entry 2127 (class 2606 OID 41410)
-- Name: id_os_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pacientes
    ADD CONSTRAINT id_os_fkey FOREIGN KEY (id_os) REFERENCES obras_sociales(id_os);


--
-- TOC entry 2112 (class 2606 OID 41415)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY esperas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2118 (class 2606 OID 41425)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2124 (class 2606 OID 41430)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2133 (class 2606 OID 41435)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2115 (class 2606 OID 41520)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2110 (class 2606 OID 41440)
-- Name: id_permiso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_permiso_fkey FOREIGN KEY (id_permiso) REFERENCES permisos(id_permiso);


--
-- TOC entry 2119 (class 2606 OID 41445)
-- Name: id_pers_alta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_pers_alta_fkey FOREIGN KEY (id_pers_alta) REFERENCES personal(id_personal);


--
-- TOC entry 2120 (class 2606 OID 41450)
-- Name: id_pers_ing_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_pers_ing_fkey FOREIGN KEY (id_pers_ing) REFERENCES personal(id_personal);


--
-- TOC entry 2114 (class 2606 OID 41455)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2122 (class 2606 OID 41465)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2125 (class 2606 OID 41470)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2129 (class 2606 OID 41475)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2134 (class 2606 OID 41480)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2111 (class 2606 OID 41485)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2116 (class 2606 OID 41525)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2126 (class 2606 OID 41490)
-- Name: id_practica_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_practica_servicio_fkey FOREIGN KEY (id_practica_servicio) REFERENCES practicas_servicios(id_practica_servicio);


--
-- TOC entry 2123 (class 2606 OID 41495)
-- Name: id_prescripcion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT id_prescripcion_fkey FOREIGN KEY (id_prescripcion) REFERENCES prescripciones(id_prescripcion);


--
-- TOC entry 2131 (class 2606 OID 41500)
-- Name: id_receta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT id_receta_fkey FOREIGN KEY (id_receta) REFERENCES recetas(id_receta);


--
-- TOC entry 2132 (class 2606 OID 41505)
-- Name: id_remedio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT id_remedio_fkey FOREIGN KEY (id_remedio) REFERENCES remedios(id_remedio);


--
-- TOC entry 2121 (class 2606 OID 41510)
-- Name: id_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_servicio_fkey FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio);


--
-- TOC entry 2130 (class 2606 OID 41515)
-- Name: id_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas_servicios
    ADD CONSTRAINT id_servicio_fkey FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio);


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-10-22 14:47:12

--
-- PostgreSQL database dump complete
--

