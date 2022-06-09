public class ArrayMethods {
    public static void main(String[] args) {
        final int NUM_ELEMENTS = 11;
        ArrayMethods app = new ArrayMethods();
        int[] testData = new int[] {67, 43, 1, 9, 44, 12, 66, 91, 18, 17, 4};
    }

    public boolean shiftDown(int[] testData) {
        int i;
        if (testData.length > 10) {
            for (i = 0; i < testData.length; ++i) {
                if (testData[i] == testData[testData.length - 1]) {
                    testData[i] = testData[0];
                } else {
                    testData[i] = testData[i + 1];
                }
            }
        }
        else {
            return false;
        }
        return false;
    }

    public boolean shiftUp(int[] testData) {
    		for (int i = 0; i < testData.length; ++i) {
            if (testData[i] == testData[testData.length - 1]){
               testData[i] = testData[0];
            }
            else{
               testData[i] = testData[i + 1];
            }
         }
    		if (testData.length > 10) {
    			return true;
    		}
    		else {
    			return false;
    		}
//        int i;
//        if (testData.length > 10) {
//            for (i = 0; i < testData.length; ++i) {
//                if (testData[i] == testData[0]) {
//                    testData[i] = testData[testData.length - 1];
//                } else {
//                    testData[i] = testData[i - 1];
//                }
//            }
//        }
//        else {
//            return false;
//        }
//        return false;
    }

    public int[] reverse(int[] testData) {
        int i;
        for (i = 0; i < testData.length/2; ++i) {
            swap(testData, testData[i], testData[i+1]);
            }
        return testData;
    }

    public void swap(int[] testData, int j, int k) {
    	 for (int i = 0; i < testData.length/2; ++i) {
        int temp = testData[i];
        testData[i] = testData[testData.length - i - 1];
        testData[testData.length - i - 1] = temp;
    	 }
    }
    

    public int findMin(int[] testData) {
        int min = testData[0];
        int i;
        for (i = 0; i < testData.length; ++i) {
            if (testData[i] < min) {
                min = testData[i];
            }
        }
        return min;
    }

    public int findMinIndex(int[] testData) {
        int min = testData[0];
        int minIndex = 0;
        int i;
        for (i = 0; i < testData.length; ++i) {
            if (testData[i] < min) {
                min = testData[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
        public static String getIdentificationString () { /* first method */
            String a = "Program 1, Abraham Velazquez";
            return a;
        }
        public static String getIdentificationString ( int prog){ /* Second method */
            String b = "Program " + prog + ", Abraham Velazquez";
            return b;
        }
    }

