/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

/**
 * 文件上传状态.
 *
 * @author zhangjianshe
 */

public class FileUploadState {
	
	/** 到目前为止读取文件的比特数. */
	private Long byteRead = 0L;

	/**
	 * 文件总大小.
	 */
	private Long contentLength = 0L;

	/**
	 * 上传是否完成.
	 *
	 * @return true, if is finished
	 */
	public boolean isFinished() {
		return contentLength < 0 || ((byteRead.equals(contentLength)) && byteRead > 0);
	}

	/**
	 * 目前正在读取第几个文件.
	 */
	private Integer itemIndex;

	/**
	 * Gets the byte read.
	 *
	 * @return the byte read
	 */
	public Long getByteRead() {
		return byteRead;
	}

	/**
	 * Sets the byte read.
	 *
	 * @param byteRead
	 *            the new byte read
	 */
	public void setByteRead(Long byteRead) {
		this.byteRead = byteRead;
	}

	/**
	 * Gets the content length.
	 *
	 * @return the content length
	 */
	public Long getContentLength() {
		return contentLength;
	}

	/**
	 * Sets the content length.
	 *
	 * @param contentLength
	 *            the new content length
	 */
	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	/**
	 * Gets the item index.
	 *
	 * @return the item index
	 */
	public Integer getItemIndex() {
		return itemIndex;
	}

	/**
	 * Sets the item index.
	 *
	 * @param itemIndex
	 *            the new item index
	 */
	public void setItemIndex(Integer itemIndex) {
		this.itemIndex = itemIndex;
	}

}