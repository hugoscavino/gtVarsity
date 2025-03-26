public class StringPermutations2 {

    // Public method to initiate the permutation process
    public static void permutations(String s) {
        permutations("", s);
    }

    // Recursive method to generate permutations
    private static void permutations(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            System.out.println(prefix); // Base case: all characters are used
        } else {
            for (int i = 0; i < n; i++) {
                // Choose the character at index i
                char chosen = remaining.charAt(i);
                // Form the new prefix by adding the chosen character
                String newPrefix = prefix + chosen;
                // Form the new remaining string by excluding the chosen character
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                // Recur with the new prefix and remaining characters
                permutations(newPrefix, newRemaining);
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        String s = "abc";
        permutations(s);
    }
}