//dev - karthikeya

import java.util.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        scanner.nextLine();  
        for (int i = 0; i < queries; i++) {
            String s = scanner.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
        scanner.close();
    }

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> signatureCount = new HashMap<>();
        int length = s.length();

        for (int start = 0; start < length; start++) {
            for (int end = start + 1; end <= length; end++) {
                String substring = s.substring(start, end);
                String signature = getSignature(substring);
                signatureCount.put(signature, signatureCount.getOrDefault(signature, 0) + 1);
            }
        }

        // Calculate the number of anagrammatic pairs
        int totalPairs = 0;
        for (int count : signatureCount.values()) {
            if (count > 1) {
                totalPairs += count * (count - 1) / 2;
            }
        }

        return totalPairs;
    }

    private static String getSignature(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
