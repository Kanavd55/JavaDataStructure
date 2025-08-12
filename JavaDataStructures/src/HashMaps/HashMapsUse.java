package HashMaps;
import java.util.HashMap;
public class HashMapsUse {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("abc", 1);
		map.put("def", 2);
		if(map.containsKey("abc")) {
			System.out.println("map has abc");
		}else {
			System.out.println("map has def");
		}
		int k = map.get("abc");
		System.out.println(k);
	}
}
