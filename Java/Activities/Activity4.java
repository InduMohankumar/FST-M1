package day1;

public class Activity4 {

    public static void main(String[] args) {
        // Initialize an array with numbers in random order
        int[] numbers = {42, 5, 17, 23, 9, 88, 15};

        System.out.println("Array BEFORE sorting:");
        printArray(numbers);

        
        insertionSort(numbers);

        System.out.println("\nArray AFTER sorting:");
        printArray(numbers);
    }

    // Insertion sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // to print array elements
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
