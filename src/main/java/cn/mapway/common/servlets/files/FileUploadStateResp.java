/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传撞题返回.
 *
 * @author zhangjianshe
 */
public class FileUploadStateResp extends cn.mapway.common.apis.BaseResp {

	/** The files. */
	public List<FileUploadState> files;

	/**
	 * Instantiates a new file upload state resp.
	 */
	public FileUploadStateResp() {
		files = new ArrayList<FileUploadState>();
	}
}
