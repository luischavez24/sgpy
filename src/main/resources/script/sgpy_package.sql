CREATE OR REPLACE PACKAGE BUSQUEDAS IS
	PROCEDURE SP_BUSCAR_PYTODOCS(
    		PCOD_PYTO NUMBER,
    		PCORR_DOC NUMBER,
    		PYTODOCSBUSQ OUT SYS_REFCURSOR);
	PROCEDURE SP_BUSCAR_PYTODOCSDETAILS(
    		PCOD_PYTO NUMBER,
    		PCORR_DOC NUMBER,
    		PYTODOCSBUSQ OUT SYS_REFCURSOR);
    PROCEDURE SP_BUSCARTODOS_PYTODOCS(
            PCOD_PYTO NUMBER,
    		PYTODOCSBUSQ OUT SYS_REFCURSOR);
END BUSQUEDAS;

CREATE OR REPLACE PACKAGE BODY BUSQUEDAS IS
	PROCEDURE SP_BUSCAR_PYTODOCS(
        PCOD_PYTO NUMBER,
        PCORR_DOC NUMBER,
        PYTODOCSBUSQ OUT SYS_REFCURSOR
	)AS
	BEGIN
        OPEN PYTODOCSBUSQ FOR SELECT * FROM PYTODOCS
        WHERE PCOD_PYTO = CODPYTO
        AND PCORR_DOC = CORRDOCS;
	END SP_BUSCAR_PYTODOCS;

	PROCEDURE SP_BUSCAR_PYTODOCSDETAILS(
        PCOD_PYTO NUMBER,
        PCORR_DOC NUMBER,
        PYTODOCSBUSQ OUT SYS_REFCURSOR
	)AS
	BEGIN
		OPEN PYTODOCSBUSQ FOR SELECT * FROM LISTAR_PYTODOCS
		WHERE PCOD_PYTO = CODPYTO
		AND PCORR_DOC = CORRDOCS;
	END SP_BUSCAR_PYTODOCSDETAILS;
    PROCEDURE SP_BUSCARTODOS_PYTODOCS(
        PCOD_PYTO NUMBER,
        PYTODOCSBUSQ OUT SYS_REFCURSOR
    ) AS
    BEGIN
        OPEN PYTODOCSBUSQ FOR 
        SELECT * FROM LISTAR_PYTODOCS
        WHERE CODPYTO LIKE '%' || PCOD_PYTO || '%' 
        OR
        CORRDOCS LIKE '%' || PCOD_PYTO || '%' ;  
    END SP_BUSCARTODOS_PYTODOCS;
END BUSQUEDAS;

CREATE OR REPLACE PACKAGE LISTAR IS
	PROCEDURE SP_LIST_ENTREGABLES(LISTAENTREGABLES OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_ESTADOPYTO(LISTAESTADOPYTO OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_ESTADOE(LISTAESTADOS OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_FASE(LISTARFASE OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_NIVEL(LISTARNIVEL OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_PYTODOCS(LISTAPYTODOCS OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_TIPODOC(LISTARTIPODOC OUT SYS_REFCURSOR);
	PROCEDURE SP_LIST_TIPOENTREG(LISTARTIPOENTREG OUT SYS_REFCURSOR);
END LISTAR;

CREATE OR REPLACE PACKAGE BODY LISTAR IS
	PROCEDURE SP_LIST_ENTREGABLES(LISTAENTREGABLES OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTAENTREGABLES FOR SELECT * FROM ENTREGABLES;
	END SP_LIST_ENTREGABLES;
	
	PROCEDURE SP_LIST_ESTADOPYTO(LISTAESTADOPYTO OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTAESTADOPYTO FOR SELECT * FROM LISTAR_ESTADOPYTO;   ---view
	END SP_LIST_ESTADOPYTO;
	
	PROCEDURE SP_LIST_ESTADOE(LISTAESTADOS OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTAESTADOS FOR SELECT * FROM ESTADO;
	END SP_LIST_ESTADOE;
	
	PROCEDURE SP_LIST_FASE(LISTARFASE OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTARFASE FOR SELECT * FROM FASE;
	END SP_LIST_FASE;
	
	PROCEDURE SP_LIST_NIVEL(LISTARNIVEL OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTARNIVEL FOR SELECT * FROM NIVEL;
	END SP_LIST_NIVEL;
	
	PROCEDURE SP_LIST_PYTODOCS(LISTAPYTODOCS OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTAPYTODOCS FOR SELECT * FROM LISTAR_PYTODOCS;  ---view 
	END SP_LIST_PYTODOCS;
	
	PROCEDURE SP_LIST_TIPODOC(LISTARTIPODOC OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTARTIPODOC FOR SELECT * FROM TIPODOC
            WHERE VIGENTE <> 'N';   
	END SP_LIST_TIPODOC;
	
	PROCEDURE SP_LIST_TIPOENTREG(LISTARTIPOENTREG OUT SYS_REFCURSOR) 
	AS
	BEGIN
    		OPEN LISTARTIPOENTREG FOR SELECT * FROM TIPOENTREG;
	END SP_LIST_TIPOENTREG;
END LISTAR;

CREATE OR REPLACE PACKAGE INSERTAR IS
	PROCEDURE SP_INSERT_ENTREGABLES(
    		TIPOENTREG NUMBER,
    		CORRENTREG NUMBER,
    		DESENTREG VARCHAR2,
    		DESCORTAENTREG VARCHAR2);
	PROCEDURE SP_INSERT_ESTADOPYTO(
    		CODFASE NUMBER,
    		CODNIVEL NUMBER,
    		ESTPYTO NUMBER,
    		DESESTADO VARCHAR2,
    		VIGENTE VARCHAR2);
	PROCEDURE SP_INSERT_FASE(
    		CODFASE NUMBER,
    		DESFASE VARCHAR2,
    		VIGENTE VARCHAR2);
	PROCEDURE SP_INSERT_NIVEL(
    		CODFASE NUMBER,
    		CODNIVEL NUMBER,
    		DESNIVEL VARCHAR2,
    		FASE VARCHAR2,
    		VIGENTE VARCHAR2);
	PROCEDURE SP_INSERT_PYTODOCS(
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
    		VIGENTE VARCHAR2);
	PROCEDURE SP_INSERT_TIPODOC(
    		CODDOC NUMBER,
    		DESTDOC VARCHAR2,
    		VIGENTE VARCHAR2);
END INSERTAR;

CREATE OR REPLACE PACKAGE BODY INSERTAR IS
	PROCEDURE SP_INSERT_ENTREGABLES(
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
            DESCORTAENTREG);
	END SP_INSERT_ENTREGABLES;

	PROCEDURE SP_INSERT_ESTADOPYTO(
        CODFASE NUMBER,
        CODNIVEL NUMBER,
        ESTPYTO NUMBER,
        DESESTADO VARCHAR2,
        VIGENTE VARCHAR2
	)
	AS
	BEGIN
        INSERT INTO ESTADO 
        VALUES(
            CODFASE,
            CODNIVEL,
            ESTPYTO,
            DESESTADO,
            VIGENTE);
	END SP_INSERT_ESTADOPYTO;
	
	PROCEDURE SP_INSERT_FASE(
        CODFASE NUMBER,
        DESFASE VARCHAR2,
        VIGENTE VARCHAR2
	)
	AS
	BEGIN
        INSERT INTO FASE
        VALUES(
            CODFASE,
            DESFASE,
            VIGENTE);
	END SP_INSERT_FASE;
	
	PROCEDURE SP_INSERT_NIVEL(
        CODFASE NUMBER,
        CODNIVEL NUMBER,
        DESNIVEL VARCHAR2,
        FASE VARCHAR2,
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
            VIGENTE);
	END SP_INSERT_NIVEL;

	PROCEDURE SP_INSERT_PYTODOCS(
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
        VIGENTE VARCHAR2)
	AS
	BEGIN
    INSERT INTO PYTODOCS 
    VALUES(
        CODPYTO,
        SQ_CORRDOC.NEXTVAL,
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
	END SP_INSERT_PYTODOCS;

	PROCEDURE SP_INSERT_TIPODOC(
    	CODDOC NUMBER,
    	DESTDOC VARCHAR2,
    	VIGENTE VARCHAR2)
	AS
	BEGIN
        INSERT INTO TIPODOC 
    	VALUES(
        	CODDOC,
    		DESTDOC,
    		VIGENTE);
	END SP_INSERT_TIPODOC;
END INSERTAR;

CREATE OR REPLACE PACKAGE UPDATES IS
	PROCEDURE SP_UPDATE_ENTREGABLES(
    		EN_TIPOENTREG NUMBER,
    		EN_CORRENTREG NUMBER,
    		EN_DESENTREG VARCHAR2,
    		EN_DESCORTAENTREG VARCHAR2);
	PROCEDURE SP_UPDATE_ESTADOPYTO(
    		ES_CODFASE NUMBER,
    		ES_CODNIVEL NUMBER,
    		ES_ESTPYTO NUMBER,
    		ES_DESESTADO VARCHAR2,
    		ES_VIGENTE VARCHAR2);
	PROCEDURE SP_UPDATE_FASE(
    		FA_CODFASE NUMBER,
    		FA_DESFASE VARCHAR2,
    		FA_VIGENCIA VARCHAR2);
	PROCEDURE SP_UPDATE_NIVEL(
    		NI_CODFASE NUMBER,
    		NI_CODNIVEL NUMBER,
    		NI_DESNIVEL VARCHAR2,
   		NI_FASE CHAR,
    		NI_VIGENTE VARCHAR2);
	PROCEDURE SP_UPDATE_PYTODOCS(
    		PY_CODPYTO NUMBER,
    		PY_CORRDOCS NUMBER,
    		PY_FECFIN DATE,
    		PY_COSTOEST NUMBER,
    		PY_RUTADOC VARCHAR2,
    		PY_CODDOC NUMBER,
    		PY_VERDOC VARCHAR2,
    		PY_OBSERVAC VARCHAR2,
    		PY_CODESP NUMBER,
    		PY_CODRESP NUMBER,
    		PY_VIGENTE VARCHAR2);
	PROCEDURE SP_UPDATE_TIPODOC(
    		TD_CODDOC NUMBER,
    		TD_DESTDOC VARCHAR2,
    		TD_VIGENTE VARCHAR2);
END UPDATES;

CREATE OR REPLACE PACKAGE BODY UPDATES IS
	PROCEDURE SP_UPDATE_ENTREGABLES(
    		EN_TIPOENTREG NUMBER,
    		EN_CORRENTREG NUMBER,
    		EN_DESENTREG VARCHAR2,
    		EN_DESCORTAENTREG VARCHAR2)
	AS
	BEGIN
      	   UPDATE ENTREGABLES SET 
        	DESENTREG = EN_DESENTREG,
        	DESCORTAENTREG = EN_DESCORTAENTREG
       
      	WHERE
       		TIPOENTREG = EN_TIPOENTREG AND CORRENTREG = EN_CORRENTREG;
	END SP_UPDATE_ENTREGABLES;
	
	PROCEDURE SP_UPDATE_ESTADOPYTO(
    		ES_CODFASE NUMBER,
    		ES_CODNIVEL NUMBER,
    		ES_ESTPYTO NUMBER,
    		ES_DESESTADO VARCHAR2,
    		ES_VIGENTE VARCHAR2)
	AS
	BEGIN
    	   UPDATE ESTADO SET
      		DESESTADO = ES_DESESTADO,
      		VIGENTE = ES_VIGENTE
    
    	WHERE 
      		CODFASE = ES_CODFASE AND 
      		CODNIVEL = ES_CODNIVEL AND
      		ESTPYTO = ES_ESTPYTO;

	END SP_UPDATE_ESTADOPYTO;
	
	PROCEDURE SP_UPDATE_FASE(
    		FA_CODFASE NUMBER,
    		FA_DESFASE VARCHAR2,
    		FA_VIGENCIA VARCHAR2)
	AS
	BEGIN
      	   UPDATE FASE SET 
        	DESFASE = FA_DESFASE,
        	VIGENCIA = FA_VIGENCIA
      	WHERE
       		CODFASE = FA_CODFASE;
	END SP_UPDATE_FASE;
	
	PROCEDURE SP_UPDATE_NIVEL(
    		NI_CODFASE NUMBER,
    		NI_CODNIVEL NUMBER,
    		NI_DESNIVEL VARCHAR2,
    		NI_FASE CHAR,
    		NI_VIGENTE VARCHAR2)
	AS
	BEGIN
      	   UPDATE NIVEL SET 
        	DESNIVEL = NI_DESNIVEL,
        	FASE = NI_FASE,
        	VIGENTE = NI_VIGENTE
      	WHERE
       		CODFASE = NI_CODFASE AND CODNIVEL = NI_CODNIVEL;
	END SP_UPDATE_NIVEL;
	
	PROCEDURE SP_UPDATE_PYTODOCS(
    		PY_CODPYTO NUMBER,
   		PY_CORRDOCS NUMBER,
    		PY_FECFIN DATE,
    		PY_COSTOEST NUMBER,
    		PY_RUTADOC VARCHAR2,
    		PY_CODDOC NUMBER,
    		PY_VERDOC VARCHAR2,
    		PY_OBSERVAC VARCHAR2,
    		PY_CODESP NUMBER,
    		PY_CODRESP NUMBER,
    		PY_VIGENTE VARCHAR2)
  	AS 
	BEGIN
      	   UPDATE PYTODOCS SET 
        	COSTOEST = PY_COSTOEST,
        	FECFIN = PY_FECFIN,
        	RUTADOC = PY_RUTADOC,
        	CODDOC = PY_CODDOC,
        	VERDOC = PY_VERDOC,
        	OBSERVAC = PY_OBSERVAC,
        	CODESP = PY_CODESP,
        	CODRESP = PY_CODRESP,
        	VIGENTE = PY_VIGENTE
      	WHERE
       		CODPYTO = PY_CODPYTO 
        	AND CORRDOCS = PY_CORRDOCS;
  	END SP_UPDATE_PYTODOCS;
	
	PROCEDURE SP_UPDATE_TIPODOC(
    		TD_CODDOC NUMBER,
    		TD_DESTDOC VARCHAR2,
    		TD_VIGENTE VARCHAR2)
	AS
	BEGIN
    	   UPDATE TIPODOC SET
      		DESTDOC = TD_DESTDOC,
      		VIGENTE = TD_VIGENTE
    	WHERE 
      		CODDOC = TD_CODDOC;
	END SP_UPDATE_TIPODOC;
	
END UPDATES;
	
CREATE OR REPLACE PACKAGE DELETES IS
	PROCEDURE SP_DELETE_ENTREGABLES(
    		EN_TIPOENTREG NUMBER,
    		EN_CORRENTREG NUMBER);	
	PROCEDURE SP_DELETE_ESTADOPYTO(
    		ES_CODFASE NUMBER,
    		ES_CODNIVEL NUMBER,
    		ES_ESTPYTO NUMBER);
	PROCEDURE SP_DELETE_FASE(
    		FA_CODFASE NUMBER);
	PROCEDURE SP_DELETE_NIVEL(
    		NI_CODFASE NUMBER,
    		NI_CODNIVEL NUMBER);
	PROCEDURE SP_DELETE_PYTODOCS(
    		PY_CODPYTO NUMBER,
    		PY_CORRDOCS NUMBER);
	PROCEDURE SP_DELETE_TIPODOC(
    		ES_CODDOC NUMBER);
END DELETES;

CREATE OR REPLACE PACKAGE BODY DELETES IS
	
    PROCEDURE SP_DELETE_ENTREGABLES(
    		EN_TIPOENTREG NUMBER,
    		EN_CORRENTREG NUMBER)
	AS 
	BEGIN
  		DELETE FROM ENTREGABLES
    	WHERE
      		TIPOENTREG = EN_TIPOENTREG AND
      		CORRENTREG = EN_CORRENTREG;
	END SP_DELETE_ENTREGABLES;
	
	PROCEDURE SP_DELETE_ESTADOPYTO(
    		ES_CODFASE NUMBER,
    		ES_CODNIVEL NUMBER,
    		ES_ESTPYTO NUMBER)
	AS
	BEGIN
  		DELETE FROM ESTADO
    	WHERE 
      		CODFASE = ES_CODFASE AND
      		CODNIVEL = ES_CODNIVEL AND
      		ESTPYTO = ES_ESTPYTO;
	END SP_DELETE_ESTADOPYTO;
	
	PROCEDURE SP_DELETE_FASE(
    		FA_CODFASE NUMBER)
	AS
	BEGIN
    		DELETE FROM FASE
        WHERE
            CODFASE = FA_CODFASE;
	END SP_DELETE_FASE;

	PROCEDURE SP_DELETE_NIVEL(
    		NI_CODFASE NUMBER,
    		NI_CODNIVEL NUMBER)
	AS
	BEGIN
    		DELETE FROM NIVEL
        WHERE
            CODFASE = NI_CODFASE AND
            CODNIVEL = NI_CODNIVEL;
	END SP_DELETE_NIVEL;
	
	PROCEDURE SP_DELETE_PYTODOCS(
    		PY_CODPYTO NUMBER,
    		PY_CORRDOCS NUMBER)
	AS 
	BEGIN
  		DELETE FROM PYTODOCS 
    	WHERE 
      		CODPYTO = PY_CODPYTO AND 
      		CORRDOCS = PY_CORRDOCS;
	END SP_DELETE_PYTODOCS;
	
	PROCEDURE SP_DELETE_TIPODOC(
    		ES_CODDOC NUMBER)
	AS 
	BEGIN 
  		DELETE FROM TIPODOC
    	WHERE 
      		CODDOC = ES_CODDOC;
	END SP_DELETE_TIPODOC;

END DELETES;