/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

/**
 * 文件上传返回.
 * @author zhangjianshe
 *
 */
public class FileUploadResp {

	/** The ret code. */
	public Integer retCode;

	/** The msg. */
	public String msg;

	/**
	 * 设置接口调用成功.
	 *
	 * @return the file upload resp
	 */
	public FileUploadResp ok() {
		return ok("");
	}

	/**
	 * 设置接口调用成功.
	 *
	 * @param message
	 *            成功的消息
	 * @return the file upload resp
	 */
	public FileUploadResp ok(String message) {
		return fail(0, message);
	}

	/**
	 * 设置接口调用错误.
	 *
	 * @param code
	 *            错误代码.
	 * @param message
	 *            错误消息.
	 * @return the file upload resp
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

	/** The icon. */
	public String icon;
}
