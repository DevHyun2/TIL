package train;

import java.util.Collections;
import java.util.HashMap;
import java.util.stream.IntStream;

public class SportsMan {
	
	public static void main(String[] args) {
		HashMap<String, String> location = new HashMap<String, String>();
		
		location.put("home", "Daejeon");
		location.put("office", "Seoul");
	
		for(String key : location.keySet()){
			
		    System.out.println(key + "=>" + location.get(key));
		}
//		[실행결과]
//		home => Daejeon
//		office => Seoul
	}
}