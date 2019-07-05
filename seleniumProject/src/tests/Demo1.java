package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

	public static void main(String[] args) {
		
//		2925.03 (A)(2)/(C)(4)(F) TRAFFICKING IN COCAINE (Felony 1st Degree)
//		2911.12 (A)(3)/(D) BURGLARY (Felony 3rd Degree)
//		2925.03A2/C6E TRAFFICKING IN HEROIN (Felony 2nd Degree)
		String str = "2925.03 (A)(2)/(C)(4)(F) TRAFFICKING IN COCAINE (Felony 1st Degree)";
		
		
		Pattern pat = Pattern.compile("(.*\\)*)\\s(.*)\\s(\\(.*\\))");
		Matcher mat = pat.matcher(str);
		if(mat.find()) {
//			System.out.println(mat.group(0));
			System.out.println(mat.group(1));
			System.out.println(mat.group(2));
			System.out.println(mat.group(3).replaceFirst("\\(", "").replaceFirst("\\)", ""));
			System.out.println("yes");
		} else
			System.out.println("No");

	}

}
