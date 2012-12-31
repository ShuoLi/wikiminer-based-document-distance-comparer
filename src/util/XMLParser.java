package util;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class XMLParser {
	private Document doc = null;

	public void ReadHTML(String url) {
		try {
			String html = Jsoup.connect(url).timeout(30 * 1000).get().toString();
			this.doc = Jsoup.parse(html, "", Parser.xmlParser());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNextElement() {
		Elements inventor_tag = doc.getElementsByTag("interpretation");
		String text = inventor_tag.attr("relatedness");
		return text;
	}
	
	public String getElementStream(String element) {
		Element inventor_tag = doc.select("p").first();
		String text = Jsoup.parse(inventor_tag.html()).text();
		return text;
	}
}