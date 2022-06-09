/**
 * Binary search to fix data sets issues
 */
 import java.util.Scanner;
 
 public class BinarySearch {
  /** Use binary search to find the key in the list */
  public static int binarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;

    while (high >= low) {
      int mid = (low + high) / 2;
      if (key < list[mid])
        high = mid - 1;
      else if (key == list[mid])
        return mid;
      else
        low = mid + 1;
    }

    return -low - 1;
  }
  
  public static void main(String[] args) {
     
     Scanner in = new Scanner(System.in);
     
     int set = in.nextInt();
     int key = in.nextInt();
     
     int[][] datasets = { {},
                          {1,2,3,5,8,13,21,34,55,89},
                          {-81, -72, -63, -54, -45, -36, -27, -18, -9, 0},
                          {21, 34, 72, -63, 8, 5, -13, -27, -18, 1, 0, 2}
                        };
    
     System.out.println("Searching for key " + key + 
                        " in data set " + set +
                        " returned " + binarySearch(datasets[set], key));

  }
}