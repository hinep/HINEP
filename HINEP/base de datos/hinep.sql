--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.1
-- Dumped by pg_dump version 9.2.0
-- Started on 2012-10-14 04:51:10

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 190 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2113 (class 0 OID 0)
-- Dependencies: 190
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 168 (class 1259 OID 16394)
-- Name: camas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE camas (
    id_cama numeric NOT NULL,
    desc_cama character varying(30),
    nro_habitacion numeric NOT NULL,
    disponible boolean
);


ALTER TABLE public.camas OWNER TO postgres;

--
-- TOC entry 2114 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN camas.id_cama; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN camas.id_cama IS 'Código que identifica una cama de internación transitoria';


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN camas.desc_cama; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN camas.desc_cama IS 'Descripción de una cama de internación transitoria';


--
-- TOC entry 2116 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN camas.nro_habitacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN camas.nro_habitacion IS 'Número del  habitación de una cama en internación transitoria';


--
-- TOC entry 2117 (class 0 OID 0)
-- Dependencies: 168
-- Name: COLUMN camas.disponible; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN camas.disponible IS 'Disponibilidad de una cama en internación transitoria';


--
-- TOC entry 169 (class 1259 OID 16400)
-- Name: cargos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cargos (
    id_cargo numeric NOT NULL,
    cargo character varying(15)
);


ALTER TABLE public.cargos OWNER TO postgres;

--
-- TOC entry 2118 (class 0 OID 0)
-- Dependencies: 169
-- Name: COLUMN cargos.id_cargo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN cargos.id_cargo IS 'Código que identifica el cargo que puede tener un empleado del HINEP';


--
-- TOC entry 2119 (class 0 OID 0)
-- Dependencies: 169
-- Name: COLUMN cargos.cargo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN cargos.cargo IS 'Descripción del cargo que puede tener un empleado del HINEP';


--
-- TOC entry 171 (class 1259 OID 16412)
-- Name: esperas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE esperas (
    id_espera integer NOT NULL,
    id_paciente numeric,
    fecha date,
    sintomas character varying(50),
    nivel_imp character varying(8),
    estado character varying(12)
);


ALTER TABLE public.esperas OWNER TO postgres;

--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.id_espera; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.id_espera IS 'Código que identifica una solicitud de atención por parte del paciente';


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.id_paciente IS 'Clave foránea de la tabla PACIENTES';


--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.fecha IS 'Fecha en que un paciente solicitó ser atendido en el servicio de guardia';


--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.sintomas; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.sintomas IS 'Síntomas que presenta un paciente';


--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.nivel_imp; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.nivel_imp IS 'Nivel de importancia en una espera de un paciente para ser atendido';


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 171
-- Name: COLUMN esperas.estado; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN esperas.estado IS 'Estado en que se encuentra';


--
-- TOC entry 170 (class 1259 OID 16410)
-- Name: esperas_id_espera_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE esperas_id_espera_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.esperas_id_espera_seq OWNER TO postgres;

--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 170
-- Name: esperas_id_espera_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE esperas_id_espera_seq OWNED BY esperas.id_espera;


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 170
-- Name: esperas_id_espera_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('esperas_id_espera_seq', 1, false);


--
-- TOC entry 172 (class 1259 OID 16421)
-- Name: guardias; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE guardias (
    id_guardia numeric NOT NULL,
    id_personal numeric,
    id_cargos numeric,
    fecha date
);


ALTER TABLE public.guardias OWNER TO postgres;

--
-- TOC entry 2128 (class 0 OID 0)
-- Dependencies: 172
-- Name: COLUMN guardias.id_guardia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN guardias.id_guardia IS 'Código que identifica una asignación de guardia a un empleado del servicio';


--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 172
-- Name: COLUMN guardias.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN guardias.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 172
-- Name: COLUMN guardias.id_cargos; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN guardias.id_cargos IS 'Clave foránea de la tabla CARGOS';


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 172
-- Name: COLUMN guardias.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN guardias.fecha IS 'Fecha en que a un empleado del servicio le toca hacer guardia';


--
-- TOC entry 173 (class 1259 OID 16434)
-- Name: historias_clinicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE historias_clinicas (
    id_historia numeric NOT NULL,
    id_paciente numeric,
    id_personal numeric,
    fecha date,
    hora time with time zone,
    peso numeric,
    talla numeric,
    diagnostico character varying(40),
    patologia character varying(30)
);


ALTER TABLE public.historias_clinicas OWNER TO postgres;

--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.id_historia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.id_historia IS 'Código que identifica una atención de un paciente en la guardia';


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.id_paciente IS 'Clave foránea de la tabla PACIENTES';


--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.fecha IS 'Fecha en que un paciente fue atendido en el servicio de guardia';


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.hora; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.hora IS 'Hora en que se registró la  atención del paciente';


--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.peso; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.peso IS 'Peso de un paciente 
';


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.talla; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.talla IS 'Altura de un paciente';


--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.diagnostico; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.diagnostico IS 'Diagnóstico establecido por el médico al atender un paciente ';


--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 173
-- Name: COLUMN historias_clinicas.patologia; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN historias_clinicas.patologia IS 'Patología de un paciente atendido en la guardia';


--
-- TOC entry 174 (class 1259 OID 16442)
-- Name: internaciones_transitorias; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE internaciones_transitorias (
    id_int numeric NOT NULL,
    id_paciente numeric,
    id_cama numeric,
    id_pers_ing numeric,
    id_pers_alta numeric,
    id_servicio numeric,
    fecha_ing date,
    hora_ing time with time zone,
    fecha_alta date,
    hora_alta time with time zone,
    motivo_alta character varying(15)
);


ALTER TABLE public.internaciones_transitorias OWNER TO postgres;

--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_int; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_int IS 'Código que identifica una internación transitoria de un paciente';


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_paciente IS 'Clave foránea de la tabla PACIENTES';


--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_cama; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_cama IS 'Clave foránea de la tabla CAMAS ';


--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_pers_ing; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_pers_ing IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_pers_alta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_pers_alta IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.id_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.id_servicio IS 'Clave foránea de la tabla SERVICIOS';


--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.fecha_ing; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.fecha_ing IS 'Fecha en que un paciente fue ingresado a internación transitoria';


--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.hora_ing; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.hora_ing IS 'Hora en que un paciente fue ingresado a internación transitoria';


--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.fecha_alta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.fecha_alta IS 'Fecha en que fue dado de alta un paciente de internación transitoria';


--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.hora_alta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.hora_alta IS 'Hora en que un paciente fue dado de alta de internación transitoria';


--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 174
-- Name: COLUMN internaciones_transitorias.motivo_alta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN internaciones_transitorias.motivo_alta IS 'Motivo por el que fue dado de alta un paciente de internación transitoria';


--
-- TOC entry 175 (class 1259 OID 16450)
-- Name: medicaciones; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE medicaciones (
    id_medicacion numeric NOT NULL,
    id_prescripcion numeric,
    id_personal numeric,
    fecha date,
    hora time with time zone,
    dosis character varying
);


ALTER TABLE public.medicaciones OWNER TO postgres;

--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.id_medicacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.id_medicacion IS 'Código que identifica la administración de un medicamento a un paciente';


--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.id_prescripcion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.id_prescripcion IS 'Clave foránea de la tabla PRESCRIPCIONES';


--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.fecha IS 'Fecha en que fue administrado un medicamento a un paciente';


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.hora; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.hora IS 'Hora en que fue administrado un medicamento a un paciente';


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 175
-- Name: COLUMN medicaciones.dosis; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN medicaciones.dosis IS 'Dosis de medicamento suministrada por la enfermera a un paciente';


--
-- TOC entry 176 (class 1259 OID 16458)
-- Name: obras_sociales; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE obras_sociales (
    id_os numeric NOT NULL,
    nombre_os character varying(15)
);


ALTER TABLE public.obras_sociales OWNER TO postgres;

--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 176
-- Name: COLUMN obras_sociales.id_os; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN obras_sociales.id_os IS 'Código que identifica una Obra Social';


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 176
-- Name: COLUMN obras_sociales.nombre_os; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN obras_sociales.nombre_os IS 'Descripcion de la obra social';


--
-- TOC entry 177 (class 1259 OID 16466)
-- Name: ordenes_practicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ordenes_practicas (
    id_orden numeric NOT NULL,
    id_paciente numeric,
    id_personal numeric,
    id_practica_servicio numeric,
    fecha date
);


ALTER TABLE public.ordenes_practicas OWNER TO postgres;

--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN ordenes_practicas.id_orden; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN ordenes_practicas.id_orden IS 'Código que identifica la indicación de una práctica a un paciente en un servicio ';


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN ordenes_practicas.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN ordenes_practicas.id_paciente IS 'Clave foránea de la tabla PACIENTES';


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN ordenes_practicas.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN ordenes_practicas.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN ordenes_practicas.id_practica_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN ordenes_practicas.id_practica_servicio IS 'Clave foránea de la tabla PRACTICAS_SERVICIOS';


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 177
-- Name: COLUMN ordenes_practicas.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN ordenes_practicas.fecha IS 'Fecha en que se indicó la realización de una práctica en un servicio a un paciente
';


--
-- TOC entry 179 (class 1259 OID 16516)
-- Name: paciente_tutor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE paciente_tutor (
    id_paciente numeric NOT NULL,
    id_tutor numeric NOT NULL
);


ALTER TABLE public.paciente_tutor OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 179
-- Name: COLUMN paciente_tutor.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN paciente_tutor.id_paciente IS 'Identificación de un paciente';


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 179
-- Name: COLUMN paciente_tutor.id_tutor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN paciente_tutor.id_tutor IS 'Identificación del tutor de un paciente';


--
-- TOC entry 178 (class 1259 OID 16481)
-- Name: pacientes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pacientes (
    id_paciente numeric NOT NULL,
    id_os numeric,
    numero_os numeric,
    nom_1 character varying(12),
    nom_2 character varying(12),
    ape_1 character varying(15),
    ape_2 character varying(15),
    dni numeric,
    fecha_nac date,
    sexo character(4),
    domicilio character varying(30)
);


ALTER TABLE public.pacientes OWNER TO postgres;

--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.id_paciente IS 'Código que identifica un paciente';


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.id_os; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.id_os IS 'Clave foránea de la tabla OBRAS_SOCIALES';


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.numero_os; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.numero_os IS 'Numero de carnet de Obra Social del paciente';


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.nom_1; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.nom_1 IS 'Primer Nombre de un paciente';


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.nom_2; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.nom_2 IS 'Segundo Nombre de un paciente';


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.ape_1; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.ape_1 IS 'Primer apellido de un paciente ';


--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.ape_2; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.ape_2 IS 'Segundo apellido de un paciente ';


--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.dni; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.dni IS 'Número de documento de un paciente';


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.fecha_nac; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.fecha_nac IS 'Fecha de nacimiento de un paciente';


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.sexo; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.sexo IS 'Sexo de un paciente';


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 178
-- Name: COLUMN pacientes.domicilio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pacientes.domicilio IS 'Dirección de un paciente impartida por su tutor';


--
-- TOC entry 180 (class 1259 OID 16524)
-- Name: permisos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permisos (
    id_permiso numeric NOT NULL,
    permiso character varying(20)
);


ALTER TABLE public.permisos OWNER TO postgres;

--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 180
-- Name: COLUMN permisos.id_permiso; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN permisos.id_permiso IS 'Código que identifica el tipo de permiso proporcionado a un empleado';


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 180
-- Name: COLUMN permisos.permiso; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN permisos.permiso IS 'Descripción del tipo de permiso proporcionado';


--
-- TOC entry 181 (class 1259 OID 16532)
-- Name: personal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE personal (
    id_personal numeric NOT NULL,
    nombre character varying(25),
    apellido character varying(30),
    dni numeric,
    fecha_nac date,
    domicilio character varying(20),
    telefono numeric,
    fecha_ing date,
    profesion character varying(20),
    matricula numeric
);


ALTER TABLE public.personal OWNER TO postgres;

--
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.id_personal IS 'Código que identifica a un empleado del HINEP';


--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.nombre; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.nombre IS 'Nombre/s de un empleado del HINEP';


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.apellido; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.apellido IS 'Apellido/s de un empleado del HINEP';


--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.dni; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.dni IS 'Número de documento de un empleado del HINEP';


--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.fecha_nac; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.fecha_nac IS 'Fecha de nacimiento de un empleado del HINEP';


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.domicilio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.domicilio IS 'Domicilio de un empleado del HINEP';


--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.telefono; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.telefono IS 'Teléfono de un empleado del HINEP';


--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.fecha_ing; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.fecha_ing IS 'Fecha en que un empleado ingreso al HINEP';


--
-- TOC entry 2188 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.profesion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.profesion IS 'Profesión de un empleado del HINEP';


--
-- TOC entry 2189 (class 0 OID 0)
-- Dependencies: 181
-- Name: COLUMN personal.matricula; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN personal.matricula IS 'Número de matrícula profesional de un empleado del HINEP';


--
-- TOC entry 182 (class 1259 OID 16540)
-- Name: practicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE practicas (
    id_practica numeric NOT NULL,
    id_orden numeric,
    id_personal numeric,
    fecha date,
    observacion character varying(50)
);


ALTER TABLE public.practicas OWNER TO postgres;

--
-- TOC entry 2190 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN practicas.id_practica; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas.id_practica IS 'Código que identifica una práctica realizada por un servicio a un paciente';


--
-- TOC entry 2191 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN practicas.id_orden; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas.id_orden IS 'Clave foránea de la tabla ORDENES_PRACTICAS';


--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN practicas.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN practicas.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas.fecha IS 'Fecha en que se le realizó una práctica a un paciente en un servicio del HINEP';


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 182
-- Name: COLUMN practicas.observacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas.observacion IS 'Observación en una práctica realizada a un paciente en un servicio de la guardia';


--
-- TOC entry 183 (class 1259 OID 16549)
-- Name: practicas_servicios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE practicas_servicios (
    id_practica_servicio numeric NOT NULL,
    id_servicio numeric,
    tipo_practica character varying(20)
);


ALTER TABLE public.practicas_servicios OWNER TO postgres;

--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN practicas_servicios.id_practica_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas_servicios.id_practica_servicio IS 'Código que identifica una práctica que realiza un servicio del HINEP';


--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN practicas_servicios.id_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas_servicios.id_servicio IS 'Clave foránea de la tabla SERVICIOS';


--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 183
-- Name: COLUMN practicas_servicios.tipo_practica; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN practicas_servicios.tipo_practica IS 'Tipo de práctica que imparte un servicio del HINEP';


--
-- TOC entry 184 (class 1259 OID 16557)
-- Name: prescripciones; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prescripciones (
    id_prescripcion numeric NOT NULL,
    id_receta numeric,
    id_remedio numeric,
    indicacion character varying(20)
);


ALTER TABLE public.prescripciones OWNER TO postgres;

--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN prescripciones.id_prescripcion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN prescripciones.id_prescripcion IS 'Código que identifica la prescripción de un medicamento a un paciente';


--
-- TOC entry 2199 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN prescripciones.id_receta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN prescripciones.id_receta IS 'Clave foránea de la tabla RECETAS';


--
-- TOC entry 2200 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN prescripciones.id_remedio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN prescripciones.id_remedio IS 'Clave foránea de la tabla REMEDIOS';


--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 184
-- Name: COLUMN prescripciones.indicacion; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN prescripciones.indicacion IS 'Indicación del médico de la administración de un medicamento a un paciente';


--
-- TOC entry 185 (class 1259 OID 16565)
-- Name: recetas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recetas (
    id_receta numeric NOT NULL,
    id_paciente numeric,
    id_personal numeric,
    fecha date,
    hora time with time zone
);


ALTER TABLE public.recetas OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN recetas.id_receta; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN recetas.id_receta IS 'Código que identifica una receta de medicamentos prescriptos al paciente';


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN recetas.id_paciente; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN recetas.id_paciente IS 'Clave foránea de la tabla PACIENTES';


--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN recetas.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN recetas.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN recetas.fecha; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN recetas.fecha IS 'Fecha en que se prescribió una receta al paciente';


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN recetas.hora; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN recetas.hora IS 'hora en que se guardó la receta ';


--
-- TOC entry 186 (class 1259 OID 16573)
-- Name: remedios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE remedios (
    id_remedio numeric NOT NULL,
    desc_remedio character varying(30),
    tipo_remedio character varying(20)
);


ALTER TABLE public.remedios OWNER TO postgres;

--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN remedios.id_remedio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN remedios.id_remedio IS 'Código que identifica un medicamento';


--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN remedios.desc_remedio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN remedios.desc_remedio IS 'Descripción de un medicamento del almacén de medicamentos del HINEP';


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 186
-- Name: COLUMN remedios.tipo_remedio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN remedios.tipo_remedio IS 'Tipo de medicación administrada a un paciente';


--
-- TOC entry 187 (class 1259 OID 16581)
-- Name: servicios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE servicios (
    id_servicio numeric NOT NULL,
    desc_servicio character varying(30)
);


ALTER TABLE public.servicios OWNER TO postgres;

--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN servicios.id_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN servicios.id_servicio IS 'Código que identifica a un servicio del HINEP';


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN servicios.desc_servicio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN servicios.desc_servicio IS 'Descripción de un servicio del HINEP';


--
-- TOC entry 188 (class 1259 OID 16589)
-- Name: tutores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tutores (
    id_tutor numeric NOT NULL,
    nom_1 character varying(12),
    nom_2 character varying(12),
    ape_1 character varying(15),
    ape_2 character varying(15),
    dni numeric,
    telefono numeric,
    domicilio character varying(30)
);


ALTER TABLE public.tutores OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.id_tutor; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.id_tutor IS 'Código que identifica a un tutor de un paciente';


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.nom_1; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.nom_1 IS 'Primer Nombre de un tutor  del paciente';


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.nom_2; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.nom_2 IS 'Segundo Nombre de un tutor del paciente';


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.ape_1; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.ape_1 IS 'Primer apellido de un tutor de un paciente ';


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.ape_2; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.ape_2 IS 'Segundo apellido de un tutor de un paciente';


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.dni; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.dni IS 'Número de documento del tutor de un paciente';


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.telefono; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.telefono IS 'Teléfono del tutor de un paciente';


--
-- TOC entry 2219 (class 0 OID 0)
-- Dependencies: 188
-- Name: COLUMN tutores.domicilio; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN tutores.domicilio IS 'Domicilio del tutor de un paciente';


--
-- TOC entry 189 (class 1259 OID 16597)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id_usuario numeric NOT NULL,
    id_personal numeric,
    id_permiso numeric,
    usuario character varying(10),
    pass character varying(15)
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 2220 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN usuarios.id_usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuarios.id_usuario IS 'Código que identifica a un usuario autorizado del sistema';


--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN usuarios.id_personal; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuarios.id_personal IS 'Clave foránea de la tabla PERSONAL';


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN usuarios.id_permiso; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuarios.id_permiso IS 'Clave foránea de la tabla PERMISOS';


--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN usuarios.usuario; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuarios.usuario IS 'Nombre de usuario';


--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 189
-- Name: COLUMN usuarios.pass; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN usuarios.pass IS 'Contraseña de usuario';


--
-- TOC entry 2017 (class 2604 OID 16415)
-- Name: id_espera; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY esperas ALTER COLUMN id_espera SET DEFAULT nextval('esperas_id_espera_seq'::regclass);


--
-- TOC entry 2085 (class 0 OID 16394)
-- Dependencies: 168
-- Data for Name: camas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY camas (id_cama, desc_cama, nro_habitacion, disponible) FROM stdin;
\.


--
-- TOC entry 2086 (class 0 OID 16400)
-- Dependencies: 169
-- Data for Name: cargos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargos (id_cargo, cargo) FROM stdin;
\.


--
-- TOC entry 2087 (class 0 OID 16412)
-- Dependencies: 171
-- Data for Name: esperas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY esperas (id_espera, id_paciente, fecha, sintomas, nivel_imp, estado) FROM stdin;
\.


--
-- TOC entry 2088 (class 0 OID 16421)
-- Dependencies: 172
-- Data for Name: guardias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY guardias (id_guardia, id_personal, id_cargos, fecha) FROM stdin;
\.


--
-- TOC entry 2089 (class 0 OID 16434)
-- Dependencies: 173
-- Data for Name: historias_clinicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY historias_clinicas (id_historia, id_paciente, id_personal, fecha, hora, peso, talla, diagnostico, patologia) FROM stdin;
\.


--
-- TOC entry 2090 (class 0 OID 16442)
-- Dependencies: 174
-- Data for Name: internaciones_transitorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY internaciones_transitorias (id_int, id_paciente, id_cama, id_pers_ing, id_pers_alta, id_servicio, fecha_ing, hora_ing, fecha_alta, hora_alta, motivo_alta) FROM stdin;
\.


--
-- TOC entry 2091 (class 0 OID 16450)
-- Dependencies: 175
-- Data for Name: medicaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY medicaciones (id_medicacion, id_prescripcion, id_personal, fecha, hora, dosis) FROM stdin;
\.


--
-- TOC entry 2092 (class 0 OID 16458)
-- Dependencies: 176
-- Data for Name: obras_sociales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY obras_sociales (id_os, nombre_os) FROM stdin;
\.


--
-- TOC entry 2093 (class 0 OID 16466)
-- Dependencies: 177
-- Data for Name: ordenes_practicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ordenes_practicas (id_orden, id_paciente, id_personal, id_practica_servicio, fecha) FROM stdin;
\.


--
-- TOC entry 2095 (class 0 OID 16516)
-- Dependencies: 179
-- Data for Name: paciente_tutor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY paciente_tutor (id_paciente, id_tutor) FROM stdin;
\.


--
-- TOC entry 2094 (class 0 OID 16481)
-- Dependencies: 178
-- Data for Name: pacientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pacientes (id_paciente, id_os, numero_os, nom_1, nom_2, ape_1, ape_2, dni, fecha_nac, sexo, domicilio) FROM stdin;
\.


--
-- TOC entry 2096 (class 0 OID 16524)
-- Dependencies: 180
-- Data for Name: permisos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permisos (id_permiso, permiso) FROM stdin;
\.


--
-- TOC entry 2097 (class 0 OID 16532)
-- Dependencies: 181
-- Data for Name: personal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY personal (id_personal, nombre, apellido, dni, fecha_nac, domicilio, telefono, fecha_ing, profesion, matricula) FROM stdin;
\.


--
-- TOC entry 2098 (class 0 OID 16540)
-- Dependencies: 182
-- Data for Name: practicas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY practicas (id_practica, id_orden, id_personal, fecha, observacion) FROM stdin;
\.


--
-- TOC entry 2099 (class 0 OID 16549)
-- Dependencies: 183
-- Data for Name: practicas_servicios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY practicas_servicios (id_practica_servicio, id_servicio, tipo_practica) FROM stdin;
\.


--
-- TOC entry 2100 (class 0 OID 16557)
-- Dependencies: 184
-- Data for Name: prescripciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prescripciones (id_prescripcion, id_receta, id_remedio, indicacion) FROM stdin;
\.


--
-- TOC entry 2101 (class 0 OID 16565)
-- Dependencies: 185
-- Data for Name: recetas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recetas (id_receta, id_paciente, id_personal, fecha, hora) FROM stdin;
\.


--
-- TOC entry 2102 (class 0 OID 16573)
-- Dependencies: 186
-- Data for Name: remedios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY remedios (id_remedio, desc_remedio, tipo_remedio) FROM stdin;
\.


--
-- TOC entry 2103 (class 0 OID 16581)
-- Dependencies: 187
-- Data for Name: servicios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY servicios (id_servicio, desc_servicio) FROM stdin;
\.


--
-- TOC entry 2104 (class 0 OID 16589)
-- Dependencies: 188
-- Data for Name: tutores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tutores (id_tutor, nom_1, nom_2, ape_1, ape_2, dni, telefono, domicilio) FROM stdin;
\.


--
-- TOC entry 2105 (class 0 OID 16597)
-- Dependencies: 189
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (id_usuario, id_personal, id_permiso, usuario, pass) FROM stdin;
\.


--
-- TOC entry 2019 (class 2606 OID 16409)
-- Name: id_cama_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY camas
    ADD CONSTRAINT id_cama_pkey PRIMARY KEY (id_cama);


--
-- TOC entry 2021 (class 2606 OID 16407)
-- Name: id_cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cargos
    ADD CONSTRAINT id_cargo_pkey PRIMARY KEY (id_cargo);


--
-- TOC entry 2023 (class 2606 OID 16420)
-- Name: id_espera_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY esperas
    ADD CONSTRAINT id_espera_pkey PRIMARY KEY (id_espera);


--
-- TOC entry 2025 (class 2606 OID 16428)
-- Name: id_guardia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT id_guardia_pkey PRIMARY KEY (id_guardia);


--
-- TOC entry 2027 (class 2606 OID 16441)
-- Name: id_historia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT id_historia_pkey PRIMARY KEY (id_historia);


--
-- TOC entry 2029 (class 2606 OID 16449)
-- Name: id_int_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_int_pkey PRIMARY KEY (id_int);


--
-- TOC entry 2031 (class 2606 OID 16457)
-- Name: id_medicacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT id_medicacion_pkey PRIMARY KEY (id_medicacion);


--
-- TOC entry 2035 (class 2606 OID 16473)
-- Name: id_orden_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_orden_pkey PRIMARY KEY (id_orden);


--
-- TOC entry 2033 (class 2606 OID 16465)
-- Name: id_os_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY obras_sociales
    ADD CONSTRAINT id_os_pkey PRIMARY KEY (id_os);


--
-- TOC entry 2037 (class 2606 OID 16515)
-- Name: id_paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pacientes
    ADD CONSTRAINT id_paciente_pkey PRIMARY KEY (id_paciente);


--
-- TOC entry 2039 (class 2606 OID 16523)
-- Name: id_paciente_tutor; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY paciente_tutor
    ADD CONSTRAINT id_paciente_tutor PRIMARY KEY (id_paciente, id_tutor);


--
-- TOC entry 2041 (class 2606 OID 16531)
-- Name: id_permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permisos
    ADD CONSTRAINT id_permiso_pkey PRIMARY KEY (id_permiso);


--
-- TOC entry 2043 (class 2606 OID 16539)
-- Name: id_personal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY personal
    ADD CONSTRAINT id_personal_pkey PRIMARY KEY (id_personal);


--
-- TOC entry 2045 (class 2606 OID 16547)
-- Name: id_practica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT id_practica_pkey PRIMARY KEY (id_practica);


--
-- TOC entry 2047 (class 2606 OID 16556)
-- Name: id_practica_servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY practicas_servicios
    ADD CONSTRAINT id_practica_servicio_pkey PRIMARY KEY (id_practica_servicio);


--
-- TOC entry 2049 (class 2606 OID 16564)
-- Name: id_prescripcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT id_prescripcion_pkey PRIMARY KEY (id_prescripcion);


--
-- TOC entry 2051 (class 2606 OID 16572)
-- Name: id_receta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT id_receta_pkey PRIMARY KEY (id_receta);


--
-- TOC entry 2053 (class 2606 OID 16580)
-- Name: id_remedio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY remedios
    ADD CONSTRAINT id_remedio_pkey PRIMARY KEY (id_remedio);


--
-- TOC entry 2055 (class 2606 OID 16588)
-- Name: id_servicio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY servicios
    ADD CONSTRAINT id_servicio_pkey PRIMARY KEY (id_servicio);


--
-- TOC entry 2057 (class 2606 OID 16596)
-- Name: id_tutor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tutores
    ADD CONSTRAINT id_tutor_pkey PRIMARY KEY (id_tutor);


--
-- TOC entry 2059 (class 2606 OID 16604)
-- Name: id_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2066 (class 2606 OID 16635)
-- Name: id_cama_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_cama_fkey FOREIGN KEY (id_cama) REFERENCES camas(id_cama);


--
-- TOC entry 2061 (class 2606 OID 16610)
-- Name: id_cargo_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT id_cargo_fkey FOREIGN KEY (id_cargos) REFERENCES cargos(id_cargo);


--
-- TOC entry 2076 (class 2606 OID 16685)
-- Name: id_orden_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT id_orden_fkey FOREIGN KEY (id_orden) REFERENCES ordenes_practicas(id_orden);


--
-- TOC entry 2075 (class 2606 OID 16680)
-- Name: id_os_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pacientes
    ADD CONSTRAINT id_os_fkey FOREIGN KEY (id_os) REFERENCES obras_sociales(id_os);


--
-- TOC entry 2060 (class 2606 OID 16605)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY esperas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2063 (class 2606 OID 16620)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2065 (class 2606 OID 16630)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2072 (class 2606 OID 16665)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2081 (class 2606 OID 16710)
-- Name: id_paciente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT id_paciente_fkey FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente);


--
-- TOC entry 2084 (class 2606 OID 16725)
-- Name: id_permiso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_permiso_fkey FOREIGN KEY (id_permiso) REFERENCES permisos(id_permiso);


--
-- TOC entry 2068 (class 2606 OID 16645)
-- Name: id_pers_alta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_pers_alta_fkey FOREIGN KEY (id_pers_alta) REFERENCES personal(id_personal);


--
-- TOC entry 2067 (class 2606 OID 16640)
-- Name: id_pers_ing_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_pers_ing_fkey FOREIGN KEY (id_pers_ing) REFERENCES personal(id_personal);


--
-- TOC entry 2062 (class 2606 OID 16615)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY guardias
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2064 (class 2606 OID 16625)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY historias_clinicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2071 (class 2606 OID 16660)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2073 (class 2606 OID 16670)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2077 (class 2606 OID 16690)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2082 (class 2606 OID 16715)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recetas
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2083 (class 2606 OID 16720)
-- Name: id_personal_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_personal_fkey FOREIGN KEY (id_personal) REFERENCES personal(id_personal);


--
-- TOC entry 2074 (class 2606 OID 16675)
-- Name: id_practica_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ordenes_practicas
    ADD CONSTRAINT id_practica_servicio_fkey FOREIGN KEY (id_practica_servicio) REFERENCES practicas_servicios(id_practica_servicio);


--
-- TOC entry 2070 (class 2606 OID 16655)
-- Name: id_prescripcion_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY medicaciones
    ADD CONSTRAINT id_prescripcion_fkey FOREIGN KEY (id_prescripcion) REFERENCES prescripciones(id_prescripcion);


--
-- TOC entry 2079 (class 2606 OID 16700)
-- Name: id_receta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT id_receta_fkey FOREIGN KEY (id_receta) REFERENCES recetas(id_receta);


--
-- TOC entry 2080 (class 2606 OID 16705)
-- Name: id_remedio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prescripciones
    ADD CONSTRAINT id_remedio_fkey FOREIGN KEY (id_remedio) REFERENCES remedios(id_remedio);


--
-- TOC entry 2069 (class 2606 OID 16650)
-- Name: id_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internaciones_transitorias
    ADD CONSTRAINT id_servicio_fkey FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio);


--
-- TOC entry 2078 (class 2606 OID 16695)
-- Name: id_servicio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY practicas_servicios
    ADD CONSTRAINT id_servicio_fkey FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio);


--
-- TOC entry 2112 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-10-14 04:51:10

--
-- PostgreSQL database dump complete
--

