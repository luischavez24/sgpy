---inicio procedure listar

CREATE OR REPLACE PROCEDURE SP_LISTAR_PYTODOCS(listapytodocs out sys_refcursor) 
AS
BEGIN
    OPEN listapytodocs FOR SELECT * FROM LISTAR_PYTODOCS;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_estadopyto(listaestadopyto out sys_refcursor) 
AS
BEGIN
    OPEN listaestadopyto FOR SELECT * FROM listar_estadopyto;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_estadoE(listaestadopyto out sys_refcursor) 
AS
BEGIN
    OPEN listaestadopyto FOR SELECT * FROM estado;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_TIPODOC(listartipodoc out sys_refcursor) 
AS
BEGIN
    OPEN listartipodoc FOR SELECT * FROM tipodoc;
END;

---fin procedure insertar



---inicio procedure insertar

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
--
CREATE OR REPLACE PROCEDURE SP_INSERTAR_estadopyto(
    codfase number,
    codnivel number,
    estpyto number,
    desestado varchar2,
    vigente varchar2
)
AS
BEGIN
    INSERT INTO estado 
    VALUES(
    codfase,
    codnivel,
    estpyto,
    desestado,
    vigente
    );
END;


CREATE OR REPLACE PROCEDURE SP_INSERT_tipodoc(
    coddoc number,
    desTdoc varchar2,
    vigente varchar2
)
AS
BEGIN
    INSERT INTO tipodoc 
    VALUES(
    coddoc,
    destdoc,
    vigente
    );
END;

---fin procedure insertar



---inicio Procedure update 

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
  
CREATE OR REPLACE PROCEDURE SP_update_estadopyto(
    es_codfase number,
    es_codnivel number,
    es_estpyto number,
    es_desestado varchar2,
    es_vigente varchar2
)
AS
BEGIN
    update estado set
      desestado = es_desestado,
      vigente = es_vigente
    
    where 
      codfase = es_codfase and 
      codnivel = es_codnivel and
      estpyto = es_estpyto;

END;

CREATE OR REPLACE PROCEDURE SP_update_tipodoc(
    td_coddoc number,
    td_destdoc varchar2,
    td_vigente varchar2
)
AS
BEGIN
    update tipodoc set
      destdoc = td_destdoc,
      vigente = td_vigente
    
    where 
      coddoc = td_coddoc;

END;
  

---Fin procedure update 



----inicio delete procedure

create or replace procedure SP_DELETE_PYTODOCS
(
    PY_CODPYTO NUMBER,
    PY_CORRDOCS NUMBER
)
as 
begin
  delete from pytodocs 
    where 
      codpyto = py_codpyto and 
      corrdocs = py_corrdocs;
end;

--
create or replace procedure sp_delete_estadopyto
(
    es_codfase number,
    es_codnivel number,
    es_estpyto number
)
as begin
  delete from estado
    where 
      codfase = es_codfase and
      codnivel = es_codnivel and
      estpyto = es_estpyto;

end;

--
create or replace procedure sp_delete_tipodoc
(
    es_coddoc number
)
as begin
  delete from tipodoc
    where 
      coddoc = es_coddoc;

end;

------fin delete procedure