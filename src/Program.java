import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String filename = scan.nextLine();
		Map<String, Integer> map = findCount(filename);
		try {
			File file = new File("records_host_access_log_00.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				bw.write(entry.getKey()+" "+entry.getValue()+"\n");
			}
			bw.close();
		} catch (IOException e) {
			
		}
		
		
	}
	static Map<String, Integer> findCount(String s)  {
		
		Map<String, Integer> map = new HashMap<>();
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			while((line = br.readLine())!= null) {
				if(!s.equals("") ||!s.isEmpty()) {
					String host = s.substring(0,s.indexOf(" "));
					int counter = 0;
					if(map.containsKey(host)) {
						counter = map.get(host);	
					}
					map.put(host, ++counter);
				}
			}
			br.close();
		} catch (IOException e) {
		}
		return map;
		
	}
}
