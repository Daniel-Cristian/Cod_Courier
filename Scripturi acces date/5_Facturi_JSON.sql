DROP FUNCTION get_external_data;
CREATE OR REPLACE FUNCTION get_external_data(
    default_directory VARCHAR2, file_path VARCHAR2) 
RETURN CLOB IS
    json_file bfile := bfilename(UPPER(default_directory),file_path);
    json_clob clob;
    l_dest_offset   integer := 1;
    l_src_offset    integer := 1;
    l_bfile_csid    number  := 0;
    l_lang_context  integer := 0;
    l_warning       integer := 0;    
begin
    dbms_lob.createtemporary(json_clob,true);
    
    dbms_lob.fileopen(json_file, dbms_lob.file_readonly);

    dbms_lob.loadclobfromfile (
    dest_lob      => json_clob,
    src_bfile     => json_file,
    amount        => dbms_lob.lobmaxsize,
    dest_offset   => l_dest_offset,
    src_offset    => l_src_offset,
    bfile_csid    => l_bfile_csid ,
    lang_context  => l_lang_context,
    warning       => l_warning);
    
    dbms_lob.fileclose(json_file);
  
    return json_clob;
end;

------------------------------------------------
CREATE OR REPLACE DIRECTORY ext_file_json AS 'C:\Data\JSON';

CREATE OR REPLACE VIEW facturi_view AS
with json as
(select JSON_QUERY(get_external_data('EXT_FILE_JSON','fact.json'),
    '$.facturi.factura') doc from dual)
SELECT nr_factura,id_expeditor,id_destinatar,data_tiparire
FROM  JSON_TABLE( (select doc from json) , '$[*]'  
            COLUMNS ( nr_factura   PATH '$.nr_factura'  
                    , id_expeditor PATH '$.id_expeditor'  
                    , id_destinatar PATH '$.id_destinatar'  
                    , data_tiparire     PATH '$.data_tiparire' 
                    )  
);

SELECT * FROM facturi_view;



