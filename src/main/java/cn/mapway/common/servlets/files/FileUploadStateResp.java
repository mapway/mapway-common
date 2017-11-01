package cn.mapway.common.servlets.files;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传撞题返回
 * 
 * @author zhangjianshe
 *
 */
public class FileUploadStateResp extends cn.mapway.common.apis.BaseResp {

	public List<FileUploadState> files;

	public FileUploadStateResp() {
		files = new ArrayList<FileUploadState>();
	}
}
