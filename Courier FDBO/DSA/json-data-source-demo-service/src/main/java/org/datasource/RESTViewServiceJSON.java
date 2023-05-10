package org.datasource;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.datasource.json.locations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/*	REST Service URL
	http://localhost:8093/json-data-source-demo-service/rest/data/CategoriiListView
	http://localhost:8093/json-data-source-demo-service/rest/data/CategorieView
	http://localhost:8093/json-data-source-demo-service/rest/data/ColetView
*/
@RestController @RequestMapping("/data")
public class RESTViewServiceJSON {
	private static Logger logger = Logger.getLogger(RESTViewServiceJSON.class.getName());
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, 
		produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String testDataSource() {
		logger.info(">>>> org.datasource.rest.RESTViewService(JSON) is Up!");
		return "Test response from JDBCDataSource!";
	}
	
	@RequestMapping(value = "/CategorieView", method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public List<CategorieView> get_CategorieView() throws Exception {
		List<CategorieView> viewList = this.viewBuilder.build().getCategoriiViewList();
		return viewList;
	}
	
	@RequestMapping(value = "/ColetView", method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public List<ColetView> get_ColetView() throws Exception {
		List<ColetView> viewList = this.viewBuilder.build().getColeteViewList();
		return viewList;
	}
	
	@RequestMapping(value = "/CategoriiListView", method = RequestMethod.GET,
		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
		//produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	@ResponseBody
	public CategoriiListView get_CategoriiListView() throws Exception {
		CategoriiListView dataView = this.viewBuilder.build().getCategoriiListView();
		return dataView;
	}
	
	@RequestMapping(value = "/CategorieView/{id}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public CategorieView get_CategorieView_ByID(@PathVariable("id") Long idCategorie) throws Exception {
		Optional<CategorieView> viewData = this.viewBuilder.build().getCategoriiViewList()
				.stream().filter(d -> d.getIdCategorie().equals(idCategorie)).findFirst();
		return viewData.get();
	}
	
	@RequestMapping(value = "/CategoriiListView/{id}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public CategorieView get_CategorieListView_ByID(@PathVariable("id") Long idCategorie) throws Exception {
		logger.info("get_CategorieListView_ByID: " + idCategorie);
		Optional<CategorieView> viewData = this.viewBuilder.build().getCategoriiListView().getCategorii()
				.stream().filter(d -> d.getIdCategorie().equals(idCategorie)).findFirst();
		return viewData.get();
	}
	
	@RequestMapping(value = "/ColetView/{id}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public ColetView get_ColetView_ByID(@PathVariable("id") Long idColet) throws Exception {
		logger.info("get_ColetView_ByID: " + idColet);
		Optional<ColetView> viewData =
				this.viewBuilder.build().getColeteViewList()
					.stream().filter(c -> c.getIdColet().equals(idColet)).findFirst();
		return viewData.get();
	}
	
	// Set-up 
	private CategoriiViewBuilder viewBuilder;
	private JSONFileDataSourceConnector fileDataSourceConnector;
	
	public RESTViewServiceJSON() throws Exception {
		this.fileDataSourceConnector = 
				new JSONResourceFileDataSourceConnector("ColeteCategorii.json");
				//new JSONWebDataSourceConnector("ftp://admin:macpass@localhost:7721/DepartamentsCities.json");
//		new JSONWebDataSourceConnector("http://localhost:8080/rest", "admin", "secret");
		
		this.viewBuilder = new CategoriiViewBuilder(fileDataSourceConnector);
	}
}