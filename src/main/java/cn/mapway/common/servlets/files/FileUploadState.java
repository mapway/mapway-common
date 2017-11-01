package cn.mapway.common.servlets.files;

/**
 * 文件上传状态
 * 
 * @author zhangjianshe
 *
 */

public class FileUploadState {
	/**
	 * 到目前为止读取文件的比特数
	 */
	private Long byteRead = 0L;

	/**
	 * 文件总大小.
	 */
	private Long contentLength = 0L;

	/**
	 * 上传是否完成
	 * 
	 * @return
	 */
	public boolean isFinished() {
		return contentLength < 0 || ((byteRead.equals(contentLength)) && byteRead > 0);
	}

	/**
	 * 目前正在读取第几个文件.
	 */
	private Integer itemIndex;

	public Long getByteRead() {
		return byteRead;
	}

	public void setByteRead(Long byteRead) {
		this.byteRead = byteRead;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public Integer getItemIndex() {
		return itemIndex;
	}

	public void setItemIndex(Integer itemIndex) {
		this.itemIndex = itemIndex;
	}

}