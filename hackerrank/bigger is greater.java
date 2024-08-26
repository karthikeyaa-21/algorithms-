//developer - karthikeya
//hackerrank med

import java.util.Scanner;

public class NextLexicographicalPermutation {
    
    public static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        int n = arr.length;
        
        // Step 1: Find the pivot
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // If no pivot found, return "no answer"
        if (i == -1) {
            return "no answer";
        }
        
        // Step 2: Find the successor
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        
        // Step 3: Swap pivot with successor
        swap(arr, i, j);
        
        // Step 4: Reverse the suffix
        reverse(arr, i + 1, n - 1);
        
        return new String(arr);
    }
    
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < t; i++) {
            String w = scanner.nextLine();
            System.out.println(biggerIsGreater(w));
        }
        
        scanner.close();
    }
}
