import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MosCodeToNumber {
	public static void main(String[] args) {
		int sum = mosscode("AA");
		if (sum == 62) {
			System.out.println("Right Answer!");
		}
	}

	private static int mosscode(String string) {

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("M", 4);
		map.put("C", 8);
		map.put("G", 25);
		map.put("R", 100);
		int count = dfs(map, string);
		return count;
	}

	private static int dfs(Map<String, Integer> map, String string) {
		String[] st = string.split("");
		int count = 0;
		if (st.length > 1) {
			Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Integer> pair = it.next();
				System.out.println(pair.getKey() + pair.getValue());
				for (int i = 0; i < st.length; i++) {
					if (st[i].equals(pair.getKey())) {
						count += pair.getValue();
						System.out.println(count);
						;
						return count;
					}
				}
			}
		}
		return 0;
	}

}
