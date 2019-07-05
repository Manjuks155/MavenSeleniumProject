package tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Url {

	public static void main(String[] args) {
		//		System.out.println("\nOutput: \n" + callURL("http://jena.int.westgroup.com/cgi-bin/westgetRT.sh?command=docket&signon=N_DOHSCIOTO&casenumber=19E0001"));

		List<String> legacyIDs = new ArrayList<String>();
		
		legacyIDs.add("AR-17-002234");
		legacyIDs.add("AR-17-002458");
		legacyIDs.add("AR-17-003271");
		legacyIDs.add("AR-17-003892");
		legacyIDs.add("AR-17-004179");
		legacyIDs.add("FD-17-008101");
		legacyIDs.add("FD-17-008418");
		
		System.out.println("<dockets>");
		for(String legacy : legacyIDs) {
			System.out.println("\nOutput: \n" + callURL("http://uat.coreworkbench.cps.int.westgroup.com/cpsweb/resources/realtime?allowMultipart=true&caseNumber="+legacy+"&command=docket&signon=N_DPAALLEG"));
		}
		System.out.println("</dockets>");
	}

	public static String callURL(String myURL) {
//		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		} 

		return sb.toString();
	}
}
