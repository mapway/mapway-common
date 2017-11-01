/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

/**
 * The Class FileUploadProperties.
 */
public class FileUploadProperties {

	/** The repository. */
	public String repository = "";
	
	/** The url prefix. */
	public String urlPrefix = "";
	
	/** The support format. */
	public String supportFormat = "";

	/**
	 * Gets the repository.
	 *
	 * @return the repository
	 */
	public String getRepository() {
		return repository;
	}

	/**
	 * Sets the repository.
	 *
	 * @param repository
	 *            the new repository
	 */
	public void setRepository(String repository) {
		this.repository = repository;
	}

	/**
	 * Gets the url prefix.
	 *
	 * @return the url prefix
	 */
	public String getUrlPrefix() {
		return urlPrefix;
	}

	/**
	 * Sets the url prefix.
	 *
	 * @param urlPrefix
	 *            the new url prefix
	 */
	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	/**
	 * Gets the support format.
	 *
	 * @return the support format
	 */
	public String getSupportFormat() {
		return supportFormat;
	}

	/**
	 * Sets the support format.
	 *
	 * @param supportFormat
	 *            the new support format
	 */
	public void setSupportFormat(String supportFormat) {
		this.supportFormat = supportFormat;
	}

}
