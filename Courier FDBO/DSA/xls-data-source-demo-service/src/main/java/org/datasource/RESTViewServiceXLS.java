package org.datasource;

import java.util.List;
import java.util.logging.Logger;

import org.datasource.xlsx.categories.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*	REST Service URL
	http://localhost:8094/xls-data-source-demo-service/rest/data/DestinatariView
	http://localhost:8094/xls-data-source-demo-service/rest/data/VehiculeView
*/
@RestController @RequestMapping("/data")
public class RESTViewServiceXLS {
	private static Logger logger = Logger.getLogger(RESTViewServiceXLS.class.getName());
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, 
			produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String testDataSource() {
		logger.info(">>>> REST XML Data Source is Up!");
		return "Test response from JDBCDataSource!";
	}
	
	@RequestMapping(value = "/DestinatariView", method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public List<DestinatariView> get_DestinatariView() throws Exception {
		List<DestinatariView> viewList = this.destinatariViewBuilder.build().getDestinatariList();
		return viewList;
	}
	
	@RequestMapping(value = "/VehiculeView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public List<VehiculeView> get_VehiculeView() throws Exception {
		List<VehiculeView> viewList = this.vehiculeViewBuilder.build().getVehiculeList();
		return viewList;
	}
	
	// Set-up 
	private XLSXFileDataSourceConnector dataSourceConnector;
	
	private XLXSTupleViewBuilder destinatariTupleViewBuilder;
	private XLXSTupleViewBuilder vehiculeTupleViewBuilder;
	
	private DestinatariViewBuilder destinatariViewBuilder;
	private VehiculeViewBuilder vehiculeViewBuilder;
	
	public RESTViewServiceXLS() throws Exception {
		this.dataSourceConnector = 
				new XLSXResourceFileDataSourceConnector("Dest-Veh.xlsx");
				//new XLSXWebDataSourceConnector("ftp://admin:macpass@localhost:7721/CustProdCateg.xlsx");
		//
		this.destinatariTupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "DESTINATARI");
		this.vehiculeTupleViewBuilder = new XLXSTupleViewBuilder(this.dataSourceConnector, "VEHICULE");
		this.destinatariViewBuilder = new DestinatariViewBuilder(this.destinatariTupleViewBuilder);
		this.vehiculeViewBuilder = new VehiculeViewBuilder(this.vehiculeTupleViewBuilder);
	}
}


/* http://localhost:8080/xls-data-source-demo/rest/customers/test */
/* http://localhost:8080/xls-data-source-demo/rest/customers/CustomerCategoryView */