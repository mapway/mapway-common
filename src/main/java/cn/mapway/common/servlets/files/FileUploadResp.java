package cn.mapway.common.servlets.files;

/**
 * 文件上传返回.
 * @author zhangjianshe
 *
 */
public class FileUploadResp {

	public Integer retCode;

	public String msg;

	/**
	 * 设置接口调用成功.
	 * 
	 * @return
	 */
	public FileUploadResp ok() {
		return ok("");
	}

	/**
	 * 设置接口调用成功.
	 * 
	 * @param message
	 *            成功的消息
	 * @return
	 */
	public FileUploadResp ok(String message) {
		return fail(0, message);
	}

	/**
	 * 设置接口调用错误
	 * 
	 * @param code
	 *            错误代码.
	 * @param message
	 *            错误消息.
	 * @return
	 */
	public FileUploadResp fail(int code, String message) {
		retCode = code;
		this.msg = message;
		return this;
	}

	/** 客户端上传的 extra数据. */
	public String extra;

	/** 相对路径. */
	public String relPath;

	/** MD5. */
	public String md5;

	/** 文件的大小(Byte). */
	public long size;

	/** 原始文件名. */
	public String fileName;

	/** 是否是图片. */
	public Boolean isPicture;

	public String icon;
}
