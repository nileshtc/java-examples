import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ApplesAndOranges {

    static int[] populateDistances(int tree, int[] fruits){
        int distances[] = new int[fruits.length];
        for(int i = 0; i< fruits.length; i++){
            distances[i] = tree + fruits[i];
        } 
        return distances;
    }
    static int countFruitDistances(int s, int t, int[] distances){
        int counter = 0;
        for(int distance : distances){
            if(s<=distance && t >= distance){
                counter++;
            }
        }
        return counter;
    }
    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int distances_apples[] = populateDistances(a, apples);
        int distances_oranges[] = populateDistances(b, oranges);       
        int apple_count = countFruitDistances(s,t,distances_apples);
        int orange_count = countFruitDistances(s,t,distances_oranges);
        System.out.println(apple_count);
        System.out.println(orange_count);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
