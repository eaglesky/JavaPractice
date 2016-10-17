import java.util.*;

public class TestMap {
	public static void main (String[] args) {
		Map<String, Integer> testMap = new TreeMap<String, Integer>();
		//Map<String, Integer> testMap = new HashMap<String, Integer>();
		//Map<String, Integer> testMap = new LinkedHashMap<String, Integer>();
		//Map<String, Integer> testMap = new Hashtable<String, Integer>();

		testMap.put("Allen", 1);
		testMap.put("Jack", 3);
		testMap.put("Tom", 5);
		testMap.put("Tom", 7);
		int curVal = testMap.get("Tom");
		System.out.println("Tom = " + curVal);
		System.out.println("Current Size = " + testMap.size());
		testMap.remove("Tom");
		boolean checkContainKey = testMap.containsKey("Tom");
		System.out.println("Contains Tom ? " + checkContainKey);
		System.out.println("Tom value = " + testMap.get("Tom"));

		for (Map.Entry<String, Integer> entry : testMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("Anna: " + testMap.getOrDefault("Anna", 0));
		System.out.println("Jack: " + testMap.getOrDefault("Jack", 0));
	}
}