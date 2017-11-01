/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

/**
 * mimetype data.
 * 
 * @author zhangjianshe
 *
 */
public class MimeTypeData {
	
	/** The mime. */
	public String mime;
	
	/** The icon. */
	public String icon;

	/**
	 * Instantiates a new mime type data.
	 *
	 * @param mime
	 *            the mime
	 * @param icon
	 *            the icon
	 */
	public MimeTypeData(String mime, String icon) {
		this.mime = mime;
		this.icon = icon;
	}
}