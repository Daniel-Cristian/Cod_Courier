CREATE OR REPLACE FUNCTION get_restheart_data_media(pURL VARCHAR2, pUserPass VARCHAR2) 
RETURN clob IS
  l_req   UTL_HTTP.req;
  l_resp  UTL_HTTP.resp;
  l_buffer clob; 
begin
loop
  l_req  := UTL_HTTP.begin_request(pURL);
  UTL_HTTP.set_header(l_req, 'Authorization', 'Basic ' || 
    UTL_RAW.cast_to_varchar2(UTL_ENCODE.base64_encode(UTL_I18N.string_to_raw(pUserPass, 'AL32UTF8')))); 
  l_resp := UTL_HTTP.get_response(l_req);
  UTL_HTTP.READ_TEXT(l_resp, l_buffer,32000);
  UTL_HTTP.end_response(l_resp);
  return l_buffer;
end;

------------------------------------------------------------
DROP VIEW categorii_view;

CREATE OR REPLACE VIEW categorii_view AS
with json as  
(select JSON_QUERY(get_restheart_data_media('http://localhost:8080/colete', 'admin:secret'), '$.categorii_colete.categorie') doc from dual) 
SELECT id_categorie, denumire_categorie, greutate_min, greutate_max, valoare_min, valoare_max
FROM  JSON_TABLE( (select doc from json) , '$[*]'  
            COLUMNS ( ID_CATEGORIE   PATH '$.ID_CATEGORIE'  
                    , DENUMIRE_CATEGORIE PATH '$.DENUMIRE_CATEGORIE'  
                    , GREUTATE_MIN PATH '$.GREUTATE_MIN'  
                    , GREUTATE_MAX    PATH '$.GREUTATE_MAX' 
                    , VALOARE_MIN    PATH '$.VALOARE_MIN'  
                    , VALOARE_MAX     PATH '$.VALOARE_MAX'  
                    )  
);
SELECT * FROM categorii_view;

------------------------------------------------------------------
DROP VIEW colete_view;

CREATE OR REPLACE VIEW colete_view AS
with json as  
(select JSON_QUERY(get_restheart_data_media('http://localhost:8080/colete', 'admin:secret'), '$.categorii_colete.categorie') doc from dual) 
SELECT id_colet, greutate, valoare, continut_colet
FROM  JSON_TABLE( (select doc from json) , '$[*]'  
            COLUMNS ( nested PATH '$.colete.colet[*]' 
                               columns (
                                   id_colet     path '$.id_colet' null on error
                                 , greutate path '$.greutate' null on error
                                 , valoare path '$.valoare' null on error
                                 , continut_colet path '$.continut_colet' null on error
                               )
                    )  
);
SELECT * FROM colete_view;

------------------------------------------------------------------------
DROP VIEW categorii_colete_view;

CREATE OR REPLACE VIEW categorii_colete_view AS
with json as  
(select JSON_QUERY(get_restheart_data_media('http://localhost:8080/colete', 'admin:secret'), '$.categorii_colete.categorie') doc from dual) 
SELECT * FROM  JSON_TABLE( (select doc from json) , '$[*]'
               COLUMNS ( ID_CATEGORIE   PATH '$.ID_CATEGORIE'  
                    , DENUMIRE_CATEGORIE PATH '$.DENUMIRE_CATEGORIE'  
                    , GREUTATE_MIN PATH '$.GREUTATE_MIN'  
                    , GREUTATE_MAX    PATH '$.GREUTATE_MAX' 
                    , VALOARE_MIN    PATH '$.VALOARE_MIN'  
                    , VALOARE_MAX     PATH '$.VALOARE_MAX'  
                    , nested PATH '$.colete.colet[*]' 
                               columns (
                                   id_colet     path '$.id_colet' null on error
                                 , greutate path '$.greutate' null on error
                                 , valoare path '$.valoare' null on error
                                 , continut_colet path '$.continut_colet' null on error
                               )
                    )  
);
SELECT * FROM categorii_colete_view;
