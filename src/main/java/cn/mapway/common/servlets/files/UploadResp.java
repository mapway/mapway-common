/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

import java.util.ArrayList;
import java.util.List;

import cn.mapway.common.apis.BaseResp;

/**
 * 上传返回.
 * 
 * @author zhangjianshe
 *
 */
public class UploadResp extends BaseResp {

	/** The files. */
	public List<FileUploadResp> files;

	/**
	 * Instantiates a new upload resp.
	 */
	public UploadResp() {
		files = new ArrayList<FileUploadResp>();
	}
}
