public class RecursiveIndexFinder {
    public static int index(String s1, String s2) {
        return findIndex(s1, s2, 0);
    }

    private static int findIndex(String s1, String s2, int currentIndex) {
        // Base case: If s1 is shorter than s2, return -1 (s2 can't exist in s1)
        if (s1.length() < s2.length()) {
            return -1;
        }

        // If the beginning of s1 matches s2, return the current index
        if (s1.startsWith(s2)) {
            return currentIndex;
        }

        // Recursively check the substring excluding the first character
        int nextIndex = findIndex(s1.substring(1), s2, currentIndex + 1);

        return nextIndex; // Return the computed index or -1 if not found
    }

    public static void main(String[] args) {
        System.out.println(index("hello", "lo"));     // 3
        System.out.println(index("hellohello", "lo")); // 3
        System.out.println(index("abcabc", "abc"));   // 0
        System.out.println(index("abcdef", "de"));    // 3
        System.out.println(index("abcdef", "xyz"));   // -1
        System.out.println(index("aaaaa", "aa"));     // 0
    }
}