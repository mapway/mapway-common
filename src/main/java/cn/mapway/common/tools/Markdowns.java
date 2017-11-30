package cn.mapway.common.tools;

/**
 * markdown 文档处理器
 * 
 * @author zhangjianshe
 *
 */
public class Markdowns {
	/**
	 * 将MARKDOWN输出到 html
	 * 
	 * @param helper
	 * @return
	 */
	public static String toHTML(String markdown) {

		// MutableDataSet options = new MutableDataSet();
		//
		// options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(),
		// StrikethroughExtension.create()));
		//
		// // uncomment to convert soft-breaks to hard breaks
		// //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");
		//
		//
		// Parser parser = Parser.builder(options).build();
		//
		// HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		//
		// // You can re-use parser and renderer instances
		// Node document = parser.parse(markdown);
		// String html = renderer.render(document);
		//
		return markdown;
	}
}
