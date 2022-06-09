import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class RandomArray {
    public static void main(String[] args) throws FileNotFoundException {
    		RandomArray call = new RandomArray();
    		Scanner scan = new Scanner(System.in);
    	    int x = scan.nextInt();
    	    int y = scan.nextInt();
    		int[] firstArray = call.createXArray(x);
    		call.printArray(firstArray);
    		int[] secondArray = call.createYArray(y, firstArray);
    		call.printArray(secondArray);

    }
    Random rand = new Random(123L); //DO YOU STILL NEED THIS HERE IF IT IS
    //ALREADY IN YOUR CREATEYARRAY METHOD?
   
    public int[] createXArray(int x) throws ArrayIndexOutOfBoundsException {
        if (x < 1 && x != 0) {
            throw new ArrayIndexOutOfBoundsException(); //method will terminate
        }
        else {
        int[] xArray = new int[x];
        for (int i = x; i > 0; --i) {
            xArray[i] = i;
        }
        return xArray;
        }
    }

    public int[] createYArray(int y, int[] xArray) {
        Random rand = new Random(123L);
        int[] yArray = new int[y];
        for (int i = 0; i < xArray.length; ++i) {
            yArray[i] = xArray[rand.nextInt()];
        }
        return yArray;
    }

    public int[] printArray(int[] array) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("output.txt");
        System.out.print(array);
        return array;
    }

    public static String getIdentificationString() {//returns prog name and programmer
        String a = "RandomArray, Abraham Velazquez";
        return a;
    }
}


