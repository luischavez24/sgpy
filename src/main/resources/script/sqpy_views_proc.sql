CREATE OR REPLACE VIEW LISTAR_PYTODOCS AS
    SELECT 
        PD.CODPYTO, 
        PD.CORRDOCS, 
        FA.DESFASE, 
        NL.DESNIVEL, 
        PD.FECINI, 
        PD.FECFIN, 
        PD.COSTOEST,
        TD.DESTDOC,
        PD.VERDOC,
        TE.DESENTREG,
        PD.VIGENTE
    FROM 
        PYTODOCS PD
    INNER JOIN NIVEL NL
    ON PD.CODNIVEL= NL.CODNIVEL
    INNER JOIN FASE FA
    ON NL.CODFASE = FA.CODFASE
    INNER JOIN TIPODOC TD
    ON PD.CODDOC = TD.CODDOC
    INNER JOIN TIPOENTREG TE
    ON PD.TIPOENTREG = TE.TIPOENTREG;
    
CREATE OR REPLACE PROCEDURE SP_LISTAR_PYTODOCS(listapytodocs out sys_refcursor) 
AS
BEGIN
    OPEN listapytodocs FOR SELECT * FROM LISTAR_PYTODOCS;
END;

CREATE OR REPLACE PROCEDURE SP_INSERTAR_PYDOCS(
    CODPYTO NUMBER,
    CODFASE NUMBER,
    CODNIVEL NUMBER,
    FECINI DATE,
    FECFIN DATE,
    COSTOEST NUMBER,
    CODDOC INT,
    RUTADOC VARCHAR2,
    VERDOC VARCHAR2,
    OBSERVAC VARCHAR2,
    ESTPYTO NUMBER,
    TIPOENTREG NUMBER,
    CORRENTREG NUMBER,
    CODESP NUMBER,
    CODRESP NUMBER,
    VIGENTE VARCHAR2
)
AS
BEGIN
    INSERT INTO PYTODOCS 
    VALUES(
    CODPYTO,
    SQ_CORRDOC.nextval,
    CODFASE,
    CODNIVEL,
    FECINI,
    FECFIN,
    COSTOEST,
    CODDOC,
    RUTADOC,
    VERDOC,
    OBSERVAC,
    ESTPYTO,
    TIPOENTREG,
    CORRENTREG,
    CODESP,
    CODRESP,
    VIGENTE);
END;
---Procedure update de pytodocs
create or replace procedure sp_update_pytodocs(
    py_CODPYTO NUMBER,
    py_corrdocs number,
    py_CODFASE NUMBER,
    py_CODNIVEL NUMBER,
    py_ESTPYTO NUMBER,
    py_FECFIN DATE,
    py_COSTOEST NUMBER,
    py_RUTADOC VARCHAR2,
    py_VERDOc VARCHAR2,
    py_OBSERVAC VARCHAR2,
    py_CODESP NUMBER,
    py_CODRESP NUMBER,
    py_VIGENTE VARCHAR2)
  as begin
      update pytodocs set 
        codfase = py_CODFASE,
        codnivel = py_CODNIVEL,
        ESTPYTO = py_ESTPYTO,
        FECFIN = py_FECFIN,
        COSTOEST = py_COSTOEST,
        rutadoc = py_RUTADOC,
        verdoc = py_VERDOC,
        observac = py_OBSERVAC,
        codesp = py_CODESP,
        codresp = py_CODRESP,
        vigente = py_VIGENTE
        
      where
       codpyto = py_codpyto and corrdocs = py_corrdocs;
  end;
---Fin procedure update pytodocs

CREATE SEQUENCE SQ_CORRDOC
    MINVALUE 1
    MAXVALUE 1000;
    
