package resources;

public enum APIResources {


	baseURI("https://api.tmsandbox.co.nz"),
	charitiesResource("/v1/Charities.file_format");
	
	private String resource;
	
	
	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource()
	{
		return resource;
	}



	
}
