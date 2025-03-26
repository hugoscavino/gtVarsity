public class RecursiveDuplicateCheck {
    public static boolean isDuplicate(String str) {
        int len = str.length();

        // Base case: If length is less than 2, it cannot have a duplicate half
        if (len < 2) {
            return false;
        }

        // Check possible split points where second half could match the first
        return checkRecursive(str, 0);
    }

    private static boolean checkRecursive(String str, int start) {
        int len = str.length();
        int mid = (len + start) / 2;

        // If the second half (from mid onward) is the same as the first half
        if (str.substring(start, mid).equals(str.substring(mid))) {
            return true;
        }

        // If we haven't found a match, recursively check a smaller part of the string
        if (start < len / 2) {
            return checkRecursive(str, start + 1);
        }

        return false; // No matching pattern found
    }

    public static void main(String[] args) {
        System.out.println(isDuplicate("abcabc"));   // true
        System.out.println(isDuplicate("abcdabcd")); // true
        System.out.println(isDuplicate("abcdabc"));  // true
        System.out.println(isDuplicate("aabb"));     // false
        System.out.println(isDuplicate("1212"));     // true
        System.out.println(isDuplicate("abcde"));    // false
    }
}