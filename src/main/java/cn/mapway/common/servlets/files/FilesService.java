/*
 * mapway.cn author by zhangjianshe@gmail.com
 */
package cn.mapway.common.servlets.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.nutz.lang.Files;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.random.R;



/**
 * 文件上传服务类.
 *
 * @author zhangjianshe
 */
public class FilesService {

	/** The Constant SUPPORT_FIELS. */
	private final static String SUPPORT_FIELS = "SUPPORT_FIELS";

	/** The support file formats. */
	private static List<String> supportFileFormats;

	/** The image types. */
	private String[] imageTypes;

	/** The properties. */
	private FileUploadProperties properties;

	/**
	 * Instantiates a new files service.
	 */
	public FilesService() {
		imageTypes = Lang.array("png", "jpg", "jpeg", "bmp", "gif");
	}

	/**
	 * 设置文件上传属性.
	 *
	 * @param p
	 *            the new properties
	 */
	public void setProperties(FileUploadProperties p) {
		properties = p;
	}

	/**
	 * Gets the support format.
	 *
	 * @return the support format
	 */
	public synchronized List<String> getSupportFormat() {
		if (supportFileFormats == null) {

			supportFileFormats = new ArrayList<String>();
			supportFileFormats.add("png");
			supportFileFormats.add("jpg");
			supportFileFormats.add("gif");
			supportFileFormats.add("jpeg");
			supportFileFormats.add("apk");
			String[] fs = Strings.splitIgnoreBlank(properties.getSupportFormat());

			String envConfigure = System.getenv(SUPPORT_FIELS);
			if (!Strings.isBlank(envConfigure)) {
				String[] fs1 = Strings.splitIgnoreBlank(envConfigure);
				supportFileFormats.addAll(Lang.array2list(fs1));
			}

			supportFileFormats.addAll(Lang.array2list(fs));
		}

		return supportFileFormats;
	}

	/**
	 * 保存用户上传的文件.
	 *
	 * @param tag
	 *            the tag
	 * @param extra
	 *            the extra
	 * @param relPath
	 *            the rel path
	 * @param randomName
	 *            the random name
	 * @param upfile
	 *            the upfile
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the file upload resp
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public FileUploadResp saveRequestFile(String tag, String extra, String relPath, String randomName, FileItem upfile,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		FileUploadResp resp = new FileUploadResp();
		if (upfile.getSize() <= 0) {
			resp.fail(1, "没有上传文件信息");
			return resp;
		}

		String filename = upfile.getName();

		// 检查文件格式
		String prefix = filename.substring(filename.lastIndexOf(".") + 1);

		boolean accept = false;
		for (String fp : getSupportFormat()) {
			if (fp.equalsIgnoreCase(prefix)) {
				accept = true;
				break;
			}
		}

		String hashcode = Lang.md5(upfile.getInputStream());

		String fn = "";
		// 保存的文件名
		if (randomName != null && randomName.equals("1")) {
			// 原始文件名
			fn = extractOrigionName(upfile);
		} else {
			// 从hash码中取出前两位构造一个子目录
			String str2 = hashcode.substring(0, 2);
			// 随机文件名
			fn = str2 + File.separator + hashcode + "." + prefix;
		}

		// 相对路径
		relPath = relPath + File.separator + fn;

		// 全路径
		String fullPath = properties.repository + File.separator + relPath;

		// 保存文件
		try {

			Files.write(fullPath, upfile.getInputStream());
			resp.extra = extra;
			resp.md5 = hashcode;
			resp.size = upfile.getSize();
			resp.relPath = relPath.replaceAll("\\\\", "/");
			resp.retCode = 0;
			resp.fileName = extractOrigionName(upfile);
			resp.msg = "success";
			String suffixName = Files.getSuffixName(resp.fileName);
			resp.isPicture = isImage(suffixName);
			resp.icon = suffixName;
		} catch (IOException e) {

		}

		return resp;
	}

	/**
	 * 判断是不是图片.
	 *
	 * @param fileExtension
	 *            the file extension
	 * @return true, if is image
	 */
	public boolean isImage(String fileExtension) {
		return Lang.contains(imageTypes, fileExtension);
	}

	/**
	 * 获取原始文件名.
	 *
	 * @param upfile
	 *            the upfile
	 * @return the string
	 */
	private String extractOrigionName(FileItem upfile) {
		if (upfile == null) {
			return R.UU16();
		}
		String fileName = upfile.getName();
		if (Strings.isBlank(fileName)) {
			return R.UU16();
		}
		String targetName = "";
		String tfn = fileName.replaceAll("\\\\", "/");
		int index = tfn.lastIndexOf('/');
		if (index >= 0) {
			targetName = tfn.substring(tfn.lastIndexOf('/') + 1);
		} else {
			targetName = tfn;
		}
		return targetName;
	}

	/** The Constant SESSION_UPLOAD_INFORMATION. */
	private final static String SESSION_UPLOAD_INFORMATION = "SESSION_UPLOAD_INFORMATION";

	/** The Constant REQUEST_TAG. */
	public static final String REQUEST_TAG = "tag";

	/**
	 * 获取Session 中的上传监听器,每个Session保存一个.
	 *
	 * @param session
	 *            the session
	 * @return the session listener
	 */
	public static synchronized Map<String, RequestFileUploadListener> getSessionListener(HttpSession session) {

		@SuppressWarnings("unchecked")
		ConcurrentMap<String, RequestFileUploadListener> sessionListener = (ConcurrentMap<String, RequestFileUploadListener>) session
				.getAttribute(SESSION_UPLOAD_INFORMATION);

		if (sessionListener == null) {
			sessionListener = new ConcurrentHashMap<String, RequestFileUploadListener>();
			sessionListener = new ConcurrentHashMap<>();
			session.setAttribute(SESSION_UPLOAD_INFORMATION, sessionListener);
		}
		return sessionListener;
	}

	/**
	 * 获取Request中对应的上传监听器.
	 *
	 * @param session
	 *            the session
	 * @param tag
	 *            the tag
	 * @return the request file upload listener
	 */
	public static RequestFileUploadListener findUploadListener(HttpSession session, String tag) {
		if (!Strings.isBlank(tag)) {
			return getSessionListener(session).get(tag);
		} else {
			return null;
		}
	}

	/**
	 * 移除Session中的监听器.
	 *
	 * @param session
	 *            the session
	 * @param tag
	 *            the tag
	 */
	public static void removeUploadListener(HttpSession session, String tag) {
		if (!Strings.isBlank(tag)) {
			Map<String, RequestFileUploadListener> sessionListener = getSessionListener(session);
			sessionListener.remove(tag);
		}
	}
}
