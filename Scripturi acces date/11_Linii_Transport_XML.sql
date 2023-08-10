CREATE OR REPLACE DIRECTORY ext_file_xml AS 'C:\Data\XML';
GRANT ALL ON DIRECTORY ext_file_xml TO PUBLIC;

SELECT * FROM all_directories WHERE directory_name='EXT_FILE_XML';
-------------------------------------------------------------------

CREATE OR REPLACE VIEW det_transp AS
select x.id_transport, x.linie_transport, x.nr_factura
    from xmltable(
        '/linii_transport/linie'
        passing xmltype(
            bfilename('EXT_FILE_XML', 'linii_transp.xml')
            , nls_charset_id('AL32UTF8')
        )
        columns 
              ID_TRANSPORT   integer   path 'ID_TRANSPORT '
            , LINIE_TRANSPORT     integer   path 'LINIE_TRANSPORT'
            , NR_FACTURA    integer   path 'NR_FACTURA'
        ) x;

SELECT * FROM det_transp;