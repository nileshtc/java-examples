
public class StaticInJava {

	public static int i = 10;
	static {
		System.out.println("in here"+i);
		i++;
	}
	StaticInJava(){
		System.out.println("in const"+i);
		i++;
	}
	public void add(int a, long b) {
		System.out.println("in int long");
		System.out.println(a+b);
	}
	public void add(long a, int b) {
		System.out.println("in long int");
		System.out.println(a+b);
	}
	public static int incr() {
		System.out.println("in method"+i);
		return ++i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticInJava s = new StaticInJava();
		StaticInJava s1 = new StaticInJava();
		StaticInJava s2 = new StaticInJava();
		System.out.println(i);
		System.out.println(incr());
		
	}

}

abstract class StaticTest{
	public static void add() {
	}
}
