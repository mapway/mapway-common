/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.apis;

/**
 * The Class BaseResp.
 */
public class BaseResp {
	
	/** The ret code. */
	public int retCode;

	/** The msg. */
	public String msg;

	/**
	 * 设置接口调用成功.
	 *
	 * @return the base resp
	 */
	public BaseResp ok() {
		return ok("");
	}

	/**
	 * 设置接口调用成功.
	 *
	 * @param message
	 *            成功的消息
	 * @return the base resp
	 */
	public BaseResp ok(String message) {
		return fail(0, message);
	}

	/**
	 * 设置接口调用错误.
	 *
	 * @param code
	 *            错误代码.
	 * @param message
	 *            错误消息.
	 * @return the base resp
	 */
	public BaseResp fail(int code, String message) {
		retCode = code;
		this.msg = message;
		return this;
	}
}
