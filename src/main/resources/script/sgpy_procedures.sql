---inicio procedure listar

CREATE OR REPLACE PROCEDURE SP_BUSCAR_PYTODOCS(
    PCOD_PYTO NUMBER,
    PCOD_DOC NUMBER,
    PYTODOCSBUSQ OUT SYS_REFCURSOR
)AS
BEGIN
    OPEN PYTODOCSBUSQ FOR SELECT * FROM PYTODOCS;
END;

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


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Alexander
 * Created: 18/10/2017
 */
---inicio de procedure listar
CREATE OR REPLACE PROCEDURE SP_LISTAR_ENTREGABLES(listaentregables out sys_refcursor) 
AS
BEGIN
    OPEN listaentregables FOR SELECT * FROM ENTREGABLES;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_NIVEL(listafase out sys_refcursor) 
AS
BEGIN
    OPEN listafase FOR SELECT * FROM NIVEL;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_FASE(listanivel out sys_refcursor) 
AS
BEGIN
    OPEN listanivel FOR SELECT * FROM FASE;
END;
---fin de procedure listar

---inicio de procedure insertar
CREATE OR REPLACE PROCEDURE SP_INSERTAR_ENTREGABLES(
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
    CORRENTREG, --Umm no se si usaras una secuencia para el correlativo de entregables, por eso le puse solo el atributo
    DESENTREG,
    DESCORTAENTREG
);
END;
---
CREATE OR REPLACE PROCEDURE SP_INSERTAR_NIVEL(
    CODFASE NUMBER,
    CODNIVEL NUMBER,
    DESNIVEL VARCHAR2,
    FASE CHAR,  --segÃºn la BD del profe esta como CHAR, revisa como lo manejaste tÃº
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
---
CREATE OR REPLACE PROCEDURE SP_INSERTAR_FASE(
    CODFASE NUMBER,
    DESFASE VARCHAR2,
    VIGENCIA VARCHAR2
)
AS
BEGIN
    INSERT INTO FASE 
    VALUES(
    CODFASE,
    DESFASE, 
    VIGENCIA);
END;
---fin de procedur insertar

---inicio de procedure update
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
---
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
---
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
---fin de procedure update

---inicio de procedure delete
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
---
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
---
CREATE OR REPLACE PROCEDURE SP_DELETE_FASE
(
    FA_CODFASE NUMBER
)
AS
BEGIN
    DELETE FROM FASE
        WHERE
            CODFASE = FA_CODFASE;
END;