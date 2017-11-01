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

	public List<FileUploadResp> files;

	public UploadResp() {
		files = new ArrayList<FileUploadResp>();
	}
}
