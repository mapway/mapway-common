package cn.mapway.common.apis;

public class BaseResp {
	public int retCode;

	public String msg;

	/**
	 * 设置接口调用成功.
	 * 
	 * @return
	 */
	public BaseResp ok() {
		return ok("");
	}

	/**
	 * 设置接口调用成功.
	 * 
	 * @param message
	 *            成功的消息
	 * @return
	 */
	public BaseResp ok(String message) {
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
	public BaseResp fail(int code, String message) {
		retCode = code;
		this.msg = message;
		return this;
	}
}
