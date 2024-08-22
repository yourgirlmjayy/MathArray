import java.util.Arrays;

public class MathArray {
    // ATTRIBUTES OF THE MATH ARRAY CLASS
    private int[] arr;
    // length of the array
    private int length;

    // CONSTRUCTORS //

    /*
     * Constructor that initializes the MathArray object with the provided array.
     * The input array is directly assigned to the instance variable 'arr',
     * and the 'length' variable is set to the length of the input array.
     */
    public MathArray(int[] input_arr) {
        this.arr = input_arr;
        this.length = input_arr.length;
    }

    /*
     * Constructor that initializes the MathArray object with a specified default value and length.
     * An array of the given length is created, and each element is set to the specified default value.
     * The 'arr' instance variable stores this array, and 'length' is set to the given length.
     */
    public MathArray(int defaultValue, int length) {
        this.length = length;
        this.arr = new int[length];
        for (int i = 0; i < length;
             i++){
            arr[i] = defaultValue;
        }
    }

    // METHODS //

    // Returns the length of the array contained within the MathArray object.
    public int getLength() {
        return this.length;
    }

    // Returns the array contained within the MathArray object.
    public int[] getArray() {
        return this.arr;
    }

    // Calculates and returns the mean (average) value of the elements in the array.
    public double mean() {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        return sum / length;
    }

    // Returns the element in the array with the largest value
    public int max() {
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public double median() {
        double median;

        // Create a sorted copy of the array
        int[] sortedArray = arr.clone();
        Arrays.sort(sortedArray);

        // Check if the number of elements is odd
        if (this.length % 2 != 0) {
            // Determine the middle element for odd-length arrays
            median = sortedArray[length / 2];
        } else {
            // Calculate the average of the two middle elements for even-length arrays
            double midpoints = sortedArray[(length / 2) - 1] + arr[length / 2];
            median = midpoints / 2;
        }
        return median;
    }

    public double std() {
        // initialize sum variable
        double sum = 0;
        // determine mean value of the array
        double mean = this.mean();
        // Calculate the sum of squared differences from the mean
        for (int i = 0;  i < length; i++) {
            double dist = Math.pow((arr[i] - mean), 2); // square of the difference
            sum += dist; // accumulate the squared differences
        }
        return Math.sqrt((sum/length));
    }

    public boolean add(MathArray otherArray) {
        if (this.length != otherArray.getLength()) {
            return false; // Return false if lengths of arrays differ
        }

        else {
            for (int i = 0; i < length; i++) {
                // Add corresponding elements of the two arrays
                arr[i] = arr[i] + otherArray.getArray()[i];
            }
        }
        return true;
    }

    public static void main(String [] args) {
        // TESTS //

        //  Instances of the Math Array class
        MathArray myArray = new MathArray(new int[]{1, 32, 9, 23, 7});
        MathArray otherArray = new MathArray(new int[]{3, 1, 0, 32, 17});
        MathArray testArray = new MathArray(12, 12);

        // TESTING METHODS

        int lengthOfMyArray = myArray.getLength(); // should return 5
        int [] getTestArray = testArray.getArray(); // should create an array with 12 elements of the same value
        double mean = otherArray.mean(); // should return 10.6
        int max = myArray.max(); // should return 32
        double median = otherArray.median(); // should return 3.0
        double median2 = testArray.median(); // should return 12.0
        double std = myArray.std(); // should return 11.377170122662314
        boolean add = otherArray.add(testArray); // should return false
        boolean add2 = myArray.add(otherArray); // should return true

    }
}