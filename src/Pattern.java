
public class Pattern {

	private static void printCols(int n) {
		if(n <0)
			return;
		printRows(n);
		System.out.println("");
		printCols(n-1);
	}
	private static void printRows(int n) {
		// TODO Auto-generated method stub
		if(n<=0)
			return;
		System.out.print("* ");
		printRows(n-1);
	}
	
	static void staircase(int n) {
		for(int i =1;i<=n;i++){
            
            for(int j=(n-i);j>0;j--){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("#");
            }
            System.out.println("");
        }

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCols(5);
		staircase(5);
	}

}
