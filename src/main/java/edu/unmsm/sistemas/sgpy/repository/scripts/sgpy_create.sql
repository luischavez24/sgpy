/*CREACCION DE USUARIO*/
CREATE USER sgpy IDENTIFIED BY Prueba$1;
GRANT CONNECT, RESOURCE, SYNONYM TO sgpy;
GRANT UNLIMITED TABLESPACE TO sgpy;
GRANT CREATE VIEW, CREATE MATERIALIZED VIEW TO SGPY;

CREATE TABLESPACE ts_sgpy
DATAFILE 'c:\app\tablespaces\ts_sgpy_data.ora'
SIZE 200 m
EXTENT MANAGEMENT LOCAL AUTOALLOCATE;

CREATE TABLE PROFESIONES (
                CodProf NUMBER(5) NOT NULL,
                Grado VARCHAR2 NOT NULL,
                DesProf VARCHAR2(30) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PROFESIONES_PK PRIMARY KEY (CodProf)
) TABLESPACE ts_sgpy;
COMMENT ON TABLE PROFESIONES IS '1: Ing. Civil
2: Especialista Suelos
3: Maestria en geotecnia
4: Dr. Ing. Civil';
COMMENT ON COLUMN PROFESIONES.Grado IS '1: Bachiller
2: Titulo
3: Maestria
4: Doctorado
5: Diplomado
6: Curso
7: Tecnico
8: Otros';
COMMENT ON COLUMN PROFESIONES.Vigente IS 'Vigente 1';


CREATE TABLE TICS (
                CodTICs NUMBER(3) NOT NULL,
                DesTICs VARCHAR2(20) NOT NULL,
                Vigencia VARCHAR2(1) NOT NULL,
                CONSTRAINT TICS_PK PRIMARY KEY (CodTICs)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN TICS.Vigencia IS 'Vigente 1';


CREATE TABLE TIPOENTREG (
                TipoEntreg NUMBER(1) NOT NULL,
                DesEntreg VARCHAR2(50) NOT NULL,
                Vigencia VARCHAR2(1) NOT NULL,
                CONSTRAINT TIPOENTREG_PK PRIMARY KEY (TipoEntreg)
) TABLESPACE ts_sgpy;
COMMENT ON TABLE TIPOENTREG IS '1: Pyto
2: Informe
3: Observación
4: Gestión Pyto';
COMMENT ON COLUMN TIPOENTREG.Vigencia IS 'Vigente 1';


CREATE TABLE ENTREGABLES (
                TipoEntreg NUMBER(1) NOT NULL,
                CorrEntreg NUMBER(3) NOT NULL,
                DesEntreg VARCHAR2(50) NOT NULL,
                DesCortaEntreg VARCHAR2(17) NOT NULL,
                CONSTRAINT ENTREGABLES_PK PRIMARY KEY (TipoEntreg, CorrEntreg)
) TABLESPACE ts_sgpy;


CREATE TABLE FASE (
                CodFase NUMBER(1) NOT NULL,
                DesFase VARCHAR2(30) NOT NULL,
                Vigencia VARCHAR2(1) NOT NULL,
                CONSTRAINT FASE_PK PRIMARY KEY (CodFase)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN FASE.Vigencia IS 'Vigente 1';


CREATE TABLE FUNCION (
                CodFuncion VARCHAR2(4) NOT NULL,
                DesFuncion VARCHAR2(50) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT FUNCION_PK PRIMARY KEY (CodFuncion)
)TABLESPACE ts_sgpy;
COMMENT ON TABLE FUNCION IS '0001: Educación
0002: Transporte';
COMMENT ON COLUMN FUNCION.Vigente IS 'Vigente 1';


CREATE TABLE TIPODOC (
                CodDoc NUMBER(2) NOT NULL,
                DesTDoc VARCHAR2(30) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT TIPODOC_PK PRIMARY KEY (CodDoc)
) TABLESPACE ts_sgpy;
COMMENT ON TABLE TIPODOC IS '1: Word
2: Excel
3: AutoCad';
COMMENT ON COLUMN TIPODOC.DesTDoc IS '1: Word
2: Excel';
COMMENT ON COLUMN TIPODOC.Vigente IS 'Vigente 1';


CREATE TABLE DEPARTAMENTO (
                CodDpto VARCHAR2(3) NOT NULL,
                DesDpto VARCHAR2(50) NOT NULL,
                CONSTRAINT DEPARTAMENTO_PK PRIMARY KEY (CodDpto)
) TABLESPACE ts_sgpy;


CREATE TABLE PROVINCIA (
                CodDpto VARCHAR2(3) NOT NULL,
                CodProv VARCHAR2(3) NOT NULL,
                DesProv VARCHAR2(50) NOT NULL,
                CONSTRAINT PROVINCIA_PK PRIMARY KEY (CodDpto, CodProv)
) TABLESPACE ts_sgpy;


CREATE TABLE DISTRITO (
                CodDpto VARCHAR2(3) NOT NULL,
                CodProv VARCHAR2(3) NOT NULL,
                CodDist VARCHAR2(3) NOT NULL,
                DesDist VARCHAR2(50) NOT NULL,
                CONSTRAINT DISTRITO_PK PRIMARY KEY (CodDpto, CodProv, CodDist)
) TABLESPACE ts_sgpy;


CREATE TABLE PERSONA (
                CodPers NUMBER(6) NOT NULL,
                TipPersona VARCHAR2(1) NOT NULL,
                DesPersona VARCHAR2(100) NOT NULL,
                DesCorta VARCHAR2(30) NOT NULL,
                FlagCli VARCHAR2(1) NOT NULL,
                FlagEsp VARCHAR2(1) NOT NULL,
                FlagProf VARCHAR2(1) NOT NULL,
                Direcc VARCHAR2(100) NOT NULL,
                Hobby VARCHAR2(2000) NOT NULL,
                Foto BLOB NOT NULL,
                FecNac DATE NOT NULL,
                CodDpto VARCHAR2(3) NOT NULL,
                CodProv VARCHAR2(3) NOT NULL,
                CodDist VARCHAR2(3) NOT NULL,
                DNI VARCHAR2(20) NOT NULL,
                NroCIP VARCHAR2(10) NOT NULL,
                FecCIPVig DATE NOT NULL,
                CentroTrabajo NUMBER(6) NOT NULL,
                Cargo VARCHAR2(20) NOT NULL,
                LicCond VARCHAR2(1) NOT NULL,
                Observac VARCHAR2(300) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PERSONA_PK PRIMARY KEY (CodPers)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PERSONA.CodPers IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PERSONA.TipPersona IS '1: Juridico
0: Natural';
COMMENT ON COLUMN PERSONA.FlagCli IS '1: Cliente Si
0:Cliente No';
COMMENT ON COLUMN PERSONA.LicCond IS '1: Si tiene';
COMMENT ON COLUMN PERSONA.Vigente IS 'Vigente 1';


CREATE TABLE EXPERIENCIA (
                CodPers NUMBER(6) NOT NULL,
                CorrExp VARCHAR2(4) NOT NULL,
                LugarTrabajo VARCHAR2(30) NOT NULL,
                FecIni DATE NOT NULL,
                FecFin DATE NOT NULL,
                DesTrabajo VARCHAR2(500) NOT NULL,
                MotivoRetiro VARCHAR2(30) NOT NULL,
                Cargo VARCHAR2(20) NOT NULL,
                CodProf NUMBER(5) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT EXPERIENCIA_PK PRIMARY KEY (CodPers, CorrExp)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN EXPERIENCIA.CodPers IS '1: Reservado para la empresa MATRIZ';


CREATE TABLE PERSONAPROF (
                CodPers NUMBER(6) NOT NULL,
                CorrProf NUMBER(2) NOT NULL,
                CodProf NUMBER(5) NOT NULL,
                NroCIP VARCHAR2(10) NOT NULL,
                Universidad VARCHAR2(20) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PERSONAPROF_PK PRIMARY KEY (CodPers, CorrProf)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PERSONAPROF.CodPers IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PERSONAPROF.Vigente IS 'Vigente 1';


CREATE TABLE PERSONATICS (
                CodPers NUMBER(6) NOT NULL,
                CodTICs NUMBER(3) NOT NULL,
                DesMedio VARCHAR2(100) NOT NULL,
                Simbolo BLOB NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PERSONATICS_PK PRIMARY KEY (CodPers, CodTICs)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PERSONATICS.Vigente IS 'Vigente 1';


CREATE TABLE CLIENTE (
                CodCli NUMBER(6) NOT NULL,
                DesPliego VARCHAR2(50) NOT NULL,
                NroRuc VARCHAR2(20) NOT NULL,
                GerGener NUMBER(6) NOT NULL,
                GerInfraest NUMBER(6) NOT NULL,
                CONSTRAINT CLIENTE_PK PRIMARY KEY (CodCli)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN CLIENTE.CodCli IS 'Cliente
Municipalidad
Ministerio';
COMMENT ON COLUMN CLIENTE.DesPliego IS 'Nombre del Ministerio';


CREATE TABLE NIVEL (
                CodFase NUMBER(1) NOT NULL,
                CodNivel NUMBER(2) NOT NULL,
                DesNivel VARCHAR2(30) NOT NULL,
                Fase CHAR(1) NOT NULL,
                Vigente VARCHAR2(100) NOT NULL,
                CONSTRAINT NIVEL_PK PRIMARY KEY (CodFase, CodNivel)
) TABLESPACE ts_sgpy;
COMMENT ON TABLE NIVEL IS '1: Perfil
2: Factibilidad
3: Estudio Definitivo
4: Obra';
COMMENT ON COLUMN NIVEL.DesNivel IS '1: Perfl
2: Factibilidad
3: Estudio Definitivo
4: Obra';
COMMENT ON COLUMN NIVEL.Vigente IS 'Vigente 1';


CREATE TABLE ESTADO (
                CodFase NUMBER(1) NOT NULL,
                CodNivel NUMBER(2) NOT NULL,
                EstPyto NUMBER(2) NOT NULL,
                DesEstado VARCHAR2(30) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT ESTADO_PK PRIMARY KEY (CodFase, CodNivel, EstPyto)
) TABLESPACE ts_sgpy;
COMMENT ON TABLE ESTADO IS 'De acuerdo al Nivel
1: Registrado
2. Aprobado
3. Viable
4. Observado';
COMMENT ON COLUMN ESTADO.Vigente IS 'Vigente 1';


CREATE TABLE PROYECTO (
                CodPyto NUMBER(6) NOT NULL,
                CodFase NUMBER(1) NOT NULL,
                CodNivel NUMBER(2) NOT NULL,
                CodSNIP VARCHAR2(10) NOT NULL,
                NomPyto VARCHAR2(100) NOT NULL,
                FecReg DATE NOT NULL,
                CostoPIP NUMBER(9,2) NOT NULL,
                CostoDir NUMBER(9,2) NOT NULL,
                EstPyto NUMBER(2) NOT NULL,
                CodFuncion VARCHAR2(4) NOT NULL,
                CodDpto VARCHAR2(3) NOT NULL,
                CodProv VARCHAR2(3) NOT NULL,
                CodDist VARCHAR2(3) NOT NULL,
                CodCli NUMBER(6) NOT NULL,
                CodEsp NUMBER(6) NOT NULL,
                CodResp NUMBER(6) NOT NULL,
                Observac VARCHAR2(500) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT NUMPYTO PRIMARY KEY (CodPyto)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PROYECTO.CodSNIP IS 'Còdigo SNIP';
COMMENT ON COLUMN PROYECTO.CodResp IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PROYECTO.Vigente IS 'Vigente 1
No Vigente 0';


CREATE TABLE PYTOHITOS (
                CodPyto NUMBER(6) NOT NULL,
                CorrHitos NUMBER(4) NOT NULL,
                TipoEntreg NUMBER(1) NOT NULL,
                CorrEntreg NUMBER(3) NOT NULL,
                FecIni DATE NOT NULL,
                FecFin DATE,
                ImpContrato VARCHAR2(1) NOT NULL,
                FecFinReal DATE,
                PorcAvance NUMBER(3) NOT NULL,
                CodResp NUMBER(6) NOT NULL,
                CodInformar NUMBER(6) NOT NULL,
                AcuseRecibo VARCHAR2(1) NOT NULL,
                Observac VARCHAR2(1000) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PYTOHITOS_PK PRIMARY KEY (CodPyto, CorrHitos)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PYTOHITOS.ImpContrato IS '1: Impuesto x contrato - Penalidad
2: Impuesto x contrato - Sin Penalidad
3: Impuesto x el ejecutor';
COMMENT ON COLUMN PYTOHITOS.PorcAvance IS '99
100';
COMMENT ON COLUMN PYTOHITOS.CodResp IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PYTOHITOS.CodInformar IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PYTOHITOS.AcuseRecibo IS '1: Leido
2: Enviado';
COMMENT ON COLUMN PYTOHITOS.Vigente IS 'Vigente 1';


CREATE TABLE HITOSALERTA (
                CodPyto NUMBER(6) NOT NULL,
                CorrHitos NUMBER(4) NOT NULL,
                CodTICs NUMBER(3) NOT NULL,
                FecAlerta DATE NOT NULL,
                FecAlerta_1 VARCHAR2(1) NOT NULL,
                CONSTRAINT HITOSALERTA_PK PRIMARY KEY (CodPyto, CorrHitos, CodTICs)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN HITOSALERTA.FecAlerta_1 IS '1: Enviar alerta
0: No enviar';


CREATE TABLE PYTOCOSTO (
                CodPyto NUMBER(6) NOT NULL,
                CorrCosto NUMBER(3) NOT NULL,
                CodNivel NUMBER(2) NOT NULL,
                CostoDir NUMBER(9,2) NOT NULL,
                CostoEquip NUMBER(9,2) NOT NULL,
                CostoAdm NUMBER(2) NOT NULL,
                CostoImp NUMBER(2) NOT NULL,
                CostoOtros NUMBER(9,2) NOT NULL,
                Observac VARCHAR2(400) NOT NULL,
                CostoPIP NUMBER(9,2) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CodFase NUMBER(1) NOT NULL,
                CONSTRAINT PYTOCOSTO_PK PRIMARY KEY (CodPyto, CorrCosto)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PYTOCOSTO.Observac IS 'Se habilita si se reuqiereelcampo CostoOtros';


CREATE TABLE PYTODOCS (
                CodPyto NUMBER(6) NOT NULL,
                CorrDocs NUMBER(4) NOT NULL,
                CodFase NUMBER(1) NOT NULL,
                CodNivel NUMBER(2) NOT NULL,
                FecIni DATE NOT NULL,
                FecFin DATE NOT NULL,
                CostoEst NUMBER(9,2) NOT NULL,
                CodDoc NUMBER(2) NOT NULL,
                RutaDoc VARCHAR2(300) NOT NULL,
                VerDoc VARCHAR2(20) NOT NULL,
                Observac LONG NOT NULL,
                EstPyto NUMBER(2) NOT NULL,
                TipoEntreg NUMBER(1) NOT NULL,
                CorrEntreg NUMBER(3) NOT NULL,
                CodEsp NUMBER(6) NOT NULL,
                CodResp NUMBER(6) NOT NULL,
                Vigente VARCHAR2(1) NOT NULL,
                CONSTRAINT PYTODOCS_PK PRIMARY KEY (CodPyto, CorrDocs)
) TABLESPACE ts_sgpy;
COMMENT ON COLUMN PYTODOCS.CodResp IS '1: Reservado para la empresa MATRIZ';
COMMENT ON COLUMN PYTODOCS.Vigente IS 'Vigente 1';


ALTER TABLE PERSONAPROF ADD CONSTRAINT PROFESIONES_PERSONAPROF_FK
FOREIGN KEY (CodProf)
REFERENCES PROFESIONES (CodProf)
NOT DEFERRABLE;

ALTER TABLE EXPERIENCIA ADD CONSTRAINT PROFESIONES_EXPERIENCIA_FK
FOREIGN KEY (CodProf)
REFERENCES PROFESIONES (CodProf)
NOT DEFERRABLE;

ALTER TABLE PERSONATICS ADD CONSTRAINT MEDIOSCOMUN_PERSONACOMUN_FK
FOREIGN KEY (CodTICs)
REFERENCES TICS (CodTICs)
NOT DEFERRABLE;

ALTER TABLE HITOSALERTA ADD CONSTRAINT TICS_HITOSALERTA_FK
FOREIGN KEY (CodTICs)
REFERENCES TICS (CodTICs)
NOT DEFERRABLE;

ALTER TABLE ENTREGABLES ADD CONSTRAINT TIPOENTREG_ENTREGABLES_FK
FOREIGN KEY (TipoEntreg)
REFERENCES TIPOENTREG (TipoEntreg)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT ENTREGABLES_PYTODOCS_FK
FOREIGN KEY (CorrEntreg, TipoEntreg)
REFERENCES ENTREGABLES (CorrEntreg, TipoEntreg)
NOT DEFERRABLE;

ALTER TABLE PYTOHITOS ADD CONSTRAINT ENTREGABLES_PYTOHITOS_FK
FOREIGN KEY (TipoEntreg, CorrEntreg)
REFERENCES ENTREGABLES (TipoEntreg, CorrEntreg)
NOT DEFERRABLE;

ALTER TABLE NIVEL ADD CONSTRAINT FASE_NIVEL_FK
FOREIGN KEY (CodFase)
REFERENCES FASE (CodFase)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT FASE_PROYECTO_FK
FOREIGN KEY (CodFase)
REFERENCES FASE (CodFase)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT FUNCION_PROYECTO_FK
FOREIGN KEY (CodFuncion)
REFERENCES FUNCION (CodFuncion)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT TIPODOC_PYTODOCS_FK
FOREIGN KEY (CodDoc)
REFERENCES TIPODOC (CodDoc)
NOT DEFERRABLE;

ALTER TABLE PROVINCIA ADD CONSTRAINT DEPARTAMENTO_PROVINCIA_FK
FOREIGN KEY (CodDpto)
REFERENCES DEPARTAMENTO (CodDpto)
NOT DEFERRABLE;

ALTER TABLE DISTRITO ADD CONSTRAINT PROVINCIA_DISTRITO_FK
FOREIGN KEY (CodDpto, CodProv)
REFERENCES PROVINCIA (CodDpto, CodProv)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT DISTRITO_PROYECTO_FK
FOREIGN KEY (CodDist, CodDpto, CodProv)
REFERENCES DISTRITO (CodDist, CodDpto, CodProv)
NOT DEFERRABLE;

ALTER TABLE PERSONA ADD CONSTRAINT DISTRITO_PERSONA_FK
FOREIGN KEY (CodDpto, CodProv, CodDist)
REFERENCES DISTRITO (CodDpto, CodProv, CodDist)
NOT DEFERRABLE;

ALTER TABLE CLIENTE ADD CONSTRAINT PERSONA_CLIENTE_FK
FOREIGN KEY (CodCli)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PERSONATICS ADD CONSTRAINT PERSONA_PERSONACOMUN_FK
FOREIGN KEY (CodPers)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE CLIENTE ADD CONSTRAINT PERSONA_CLIENTE_FK1
FOREIGN KEY (GerGener)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE CLIENTE ADD CONSTRAINT PERSONA_CLIENTE_FK2
FOREIGN KEY (GerInfraest)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT PERSONA_PROYECTO_FK
FOREIGN KEY (CodEsp)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT PERSONA_PYTODOCS_FK
FOREIGN KEY (CodEsp)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PERSONA ADD CONSTRAINT PERSONA_PERSONA_FK
FOREIGN KEY (CentroTrabajo)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT PERSONA_PROYECTO_FK1
FOREIGN KEY (CodResp)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PERSONAPROF ADD CONSTRAINT PERSONA_PERSONAPROF_FK
FOREIGN KEY (CodPers)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE EXPERIENCIA ADD CONSTRAINT PERSONA_EXPERIENCIA_FK
FOREIGN KEY (CodPers)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT PERSONA_PYTODOCS_FK1
FOREIGN KEY (CodResp)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PYTOHITOS ADD CONSTRAINT PERSONA_PYTOHITOS_FK
FOREIGN KEY (CodResp)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PYTOHITOS ADD CONSTRAINT PERSONA_PYTOHITOS_FK1
FOREIGN KEY (CodInformar)
REFERENCES PERSONA (CodPers)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT CLIENTE_PROYECTO_FK
FOREIGN KEY (CodCli)
REFERENCES CLIENTE (CodCli)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT NIVEL_PROYECTO_FK
FOREIGN KEY (CodNivel, CodFase)
REFERENCES NIVEL (CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT NIVEL_PYTODOCS_FK
FOREIGN KEY (CodNivel, CodFase)
REFERENCES NIVEL (CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE PYTOCOSTO ADD CONSTRAINT NIVEL_PYTOCOSTO_FK
FOREIGN KEY (CodNivel, CodFase)
REFERENCES NIVEL (CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE ESTADO ADD CONSTRAINT NIVEL_ESTADO_FK
FOREIGN KEY (CodNivel, CodFase)
REFERENCES NIVEL (CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE PROYECTO ADD CONSTRAINT ESTADO_PROYECTO_FK
FOREIGN KEY (EstPyto, CodNivel, CodFase)
REFERENCES ESTADO (EstPyto, CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT ESTADO_PYTODOCS_FK
FOREIGN KEY (EstPyto, CodNivel, CodFase)
REFERENCES ESTADO (EstPyto, CodNivel, CodFase)
NOT DEFERRABLE;

ALTER TABLE PYTODOCS ADD CONSTRAINT PROYECTO_PYTODOCS_FK
FOREIGN KEY (CodPyto)
REFERENCES PROYECTO (CodPyto)
NOT DEFERRABLE;

ALTER TABLE PYTOCOSTO ADD CONSTRAINT PROYECTO_PYTOCOSTO_FK
FOREIGN KEY (CodPyto)
REFERENCES PROYECTO (CodPyto)
NOT DEFERRABLE;

ALTER TABLE PYTOHITOS ADD CONSTRAINT PROYECTO_PYTOHITOS_FK
FOREIGN KEY (CodPyto)
REFERENCES PROYECTO (CodPyto)
NOT DEFERRABLE;

ALTER TABLE HITOSALERTA ADD CONSTRAINT PYTOHITOS_HITOSALERTA_FK
FOREIGN KEY (CodPyto, CorrHitos)
REFERENCES PYTOHITOS (CodPyto, CorrHitos)
NOT DEFERRABLE;