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


create or replace view listar_estadopyto as
  select 
      es.estpyto,
      nv.desnivel,
      fs.desfase,
      es.desestado,
      es.vigente
  from 
      estado es
    inner join nivel nv
    on es.codnivel = nv.codnivel
    inner join fase fs
    on es.codfase = fs.codfase
    inner join PYTODOCS pd
    on es.estpyto = pd.ESTPYTO
;

select * from estado;
CREATE SEQUENCE SQ_CORRDOC
    MINVALUE 1
    MAXVALUE 1000;
    
