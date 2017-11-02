---inicio procedure buscar
CREATE OR REPLACE PROCEDURE SP_BUSCAR_PYTODOCS(
    PCOD_PYTO NUMBER,
    PCORR_DOC NUMBER,
    PYTODOCSBUSQ OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN PYTODOCSBUSQ FOR SELECT * FROM PYTODOCS
    WHERE PCOD_PYTO = CODPYTO
    AND PCORR_DOC = CORRDOCS;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_PYTODOCSDETAILS(
    PCOD_PYTO NUMBER,
    PCORR_DOC NUMBER,
    PYTODOCSBUSQ OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN PYTODOCSBUSQ FOR SELECT * FROM listar_pytodocs
    WHERE PCOD_PYTO = CODPYTO
    AND PCORR_DOC = CORRDOCS;
END;
---fin procedure buscar

---inicio procedure listar
CREATE OR REPLACE PROCEDURE SP_LIST_ENTREGABLES(listaentregables out sys_refcursor) 
AS
BEGIN
    OPEN listaentregables FOR SELECT * FROM ENTREGABLES;
END;

CREATE OR REPLACE PROCEDURE SP_LIST_ESTADOPYTO(listaestadopyto out sys_refcursor) 
AS
BEGIN
    OPEN listaestadopyto FOR SELECT * FROM LIST_ESTADOPYTO;   ---view
END;

CREATE OR REPLACE PROCEDURE SP_LIST_ESTADOE(listaestados out sys_refcursor) 
AS
BEGIN
    OPEN listaestados FOR SELECT * FROM ESTADO;
END;

CREATE OR REPLACE PROCEDURE SP_LIST_FASE(listarfase out sys_refcursor) 
AS
BEGIN
    OPEN listarfase FOR SELECT * FROM FASE;
END;

CREATE OR REPLACE PROCEDURE SP_LIST_NIVEL(listarnivel out sys_refcursor) 
AS
BEGIN
    OPEN listarnivel FOR SELECT * FROM NIVEL;
END;

CREATE OR REPLACE PROCEDURE SP_LIST_PYTODOCS(listapytodocs out sys_refcursor) 
AS
BEGIN
    OPEN listapytodocs FOR SELECT * FROM LISTAR_PYTODOCS;  ---view 
END;

CREATE OR REPLACE PROCEDURE SP_LIST_TIPODOC(listartipodoc out sys_refcursor) 
AS
BEGIN
    OPEN listartipodoc FOR SELECT * FROM TIPODOC;   
END;

CREATE OR REPLACE PROCEDURE SP_LIST_TIPOENTREG(listartipoentreg out sys_refcursor) 
AS
BEGIN
    OPEN listartipoentreg FOR SELECT * FROM TIPOENTREG;
END;
---fin procedure listar


---inicio procedure insertar
create or replace procedure sp_insert_entregables(
    TIPOENTREG NUMBER,
    CORRENTREG NUMBER,
    DESENTREG VARCHAR2,
    DESCORTAENTREG VARCHAR2
)
AS
BEGIN
    INSERT INTO ENTREGABLES 
    VALUES(
    TIPOENTREG,
    CORRENTREG,
    DESENTREG,
    DESCORTAENTREG
);
END;

CREATE OR REPLACE PROCEDURE SP_INSERT_estadopyto(
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

CREATE OR REPLACE PROCEDURE SP_INSERT_FASE(
    codfase number,
    desfase varchar2,
    vigente varchar2
)
AS
BEGIN
    INSERT INTO fase
    VALUES(
    codfase,
    desfase,
    vigente
    );
END;

create or replace procedure sp_insert_nivel
(
    CODFASE NUMBER,
    CODNIVEL NUMBER,
    DESNIVEL VARCHAR2,
    FASE varchar2,
    VIGENTE VARCHAR2
)
AS
BEGIN
    INSERT INTO NIVEL 
    VALUES(
    CODFASE,
    CODNIVEL, 
    DESNIVEL,
    FASE,
    VIGENTE
);
END;

CREATE OR REPLACE PROCEDURE SP_INSERT_PYTODOCS(
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

CREATE OR REPLACE PROCEDURE sp_insert_tipodoc(
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

create or replace procedure sp_insert_tipoentreg(
) as
begin
end;

---fin procedure insertar


---inicio Procedure update 

CREATE OR REPLACE PROCEDURE SP_UPDATE_ENTREGABLES(
    EN_TIPOENTREG NUMBER,
    EN_CORRENTREG NUMBER,
    EN_DESENTREG VARCHAR2,
    EN_DESCORTAENTREG VARCHAR2
)
AS
BEGIN
      UPDATE ENTREGABLES set 
        DESENTREG = EN_DESENTREG,
        DESCORTAENTREG = EN_DESCORTAENTREG
       
      WHERE
       TIPOENTREG = EN_TIPOENTREG and CORRENTREG = EN_CORRENTREG;
END;

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

CREATE OR REPLACE PROCEDURE SP_UPDATE_FASE(
    FA_CODFASE NUMBER,
    FA_DESFASE VARCHAR2,
    FA_VIGENCIA VARCHAR2
    
)
AS
BEGIN
      UPDATE FASE set 
        DESFASE = FA_DESFASE,
        VIGENCIA = FA_VIGENCIA
       
      WHERE
       CODFASE = FA_CODFASE;
END;

CREATE OR REPLACE PROCEDURE SP_UPDATE_NIVEL(
    NI_CODFASE NUMBER,
    NI_CODNIVEL NUMBER,
    NI_DESNIVEL VARCHAR2,
    NI_FASE CHAR,
    NI_VIGENTE VARCHAR2
)
AS
BEGIN
      UPDATE NIVEL set 
        DESNIVEL = NI_DESNIVEL,
        FASE = NI_FASE,
        VIGENTE = NI_VIGENTE
       
      WHERE
       CODFASE = NI_CODFASE and CODNIVEL = NI_CODNIVEL;
END;

create or replace procedure sp_update_pytodocs(
    py_CODPYTO NUMBER,
    py_corrdocs number,
    py_FECFIN DATE,
    py_COSTOEST NUMBER,
    py_RUTADOC VARCHAR2,
    py_coddoc number,
    py_VERDOC VARCHAR2,
    py_OBSERVAC VARCHAR2,
    py_CODESP NUMBER,
    py_CODRESP NUMBER,
    py_VIGENTE VARCHAR2)
  as begin
      update pytodocs set 
        COSTOEST = py_COSTOEST,
        fechafin = py_FECFIN,
        rutadoc = py_RUTADOC,
        coddoc = py_coddoc,
        verdoc = py_VERDOC,
        observac = py_OBSERVAC,
        codesp = py_CODESP,
        codresp = py_CODRESP,
        vigente = py_VIGENTE
        
      where
       codpyto = py_codpyto 
        and corrdocs = py_corrdocs;
  end;
  
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

create or replace procedure sp_update_tipoentreg(
) as
begin
end;

---Fin procedure update 


----inicio delete procedure

CREATE OR REPLACE PROCEDURE SP_DELETE_ENTREGABLES
(
    EN_TIPOENTREG NUMBER,
    EN_CORRENTREG NUMBER
)
AS 
BEGIN
  DELETE FROM ENTREGABLES
    WHERE
      TIPOENTREG = EN_TIPOENTREG AND
      CORRENTREG = EN_CORRENTREG;
END;

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

create or replace procedure sp_delete_fase
(
    FA_CODFASE NUMBER
) AS
BEGIN
    DELETE FROM FASE
        WHERE
            CODFASE = FA_CODFASE;
END;

CREATE OR REPLACE PROCEDURE SP_DELETE_NIVEL
(
    NI_CODFASE NUMBER,
    NI_CODNIVEL NUMBER
)
AS
BEGIN
    DELETE FROM NIVEL
        WHERE
            CODFASE = NI_CODFASE AND
            CODNIVEL = NI_CODNIVEL;
END;

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

create or replace procedure sp_delete_tipodoc
(
    es_coddoc number
)
as begin
  delete from tipodoc
    where 
      coddoc = es_coddoc;
end;

create or replace procedure sp_delete_tipoentreg
(
) as
begin
end;

---fin procedure delete
