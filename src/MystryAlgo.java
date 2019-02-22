import java.util.ArrayList;
import java.util.List;

public class MystryAlgo {
	public static void main(String[] args) {
		int a = 2437;
		int b = 875;
		int x = a;
		int y = b;
		List<String> list = new ArrayList<>();
		while(true){
			if(x > y) {
				x = x-y;
			}
			else if(y > x) {
				y = y-x;
			}
			list.add("x "+ x+ " y "+y+"\n");
			if(x == y) break;
		} 
		System.out.println(list);
		System.out.println(x);
	}
}
