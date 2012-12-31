package util;

public class Services {
	public static double compare(String word1, String word2) {
		String result = null;
		try {
			String url = "http://wikipedia-miner.cms.waikato.ac.nz/services/compare?term1="
					+ word1 + "&term2=" + word2;
			XMLParser hp = new XMLParser();
			hp.ReadHTML(url);
			result = hp.getNextElement();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Double.parseDouble(result);
	}
}
