package cn.mapway.common.servlets.files;

public class FileUploadProperties {

	public String repository = "";
	public String urlPrefix = "";
	public String supportFormat = "";

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getSupportFormat() {
		return supportFormat;
	}

	public void setSupportFormat(String supportFormat) {
		this.supportFormat = supportFormat;
	}

}
