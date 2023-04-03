CREATE OR REPLACE DIRECTORY ext_file_xml AS 'C:\Data\XML';
GRANT ALL ON DIRECTORY ext_file_xml TO PUBLIC;

SELECT * FROM all_directories WHERE directory_name='EXT_FILE_XML';
-------------------------------------------------------------------

CREATE OR REPLACE VIEW det_fact_view AS
select x.nr_factura, x.linie_factura, x.id_colet
    from xmltable(
        '/linii_facturi/linie'
        passing xmltype(
            bfilename('EXT_FILE_XML', 'detalii_fact.xml')
            , nls_charset_id('AL32UTF8')
        )
        columns 
              NR_FACTURA   integer   path 'NR_FACTURA'
            , LINIE_FACTURA     integer   path 'LINIE_FACTURA'
            , ID_COLET    integer   path 'ID_COLET'
        ) x;

SELECT * FROM det_fact_view;