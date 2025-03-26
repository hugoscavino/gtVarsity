public class StringPermutations {

    // Entry point method
    static void permutations(String s) {
        permutations("", s);
    }

    // Recursive method
    static void permutations(String s1, String s2) {
        if (s2.isEmpty()) {
            System.out.println(s1); // Base case: all characters have been used
            return;
        }

        for (int i = 0; i < s2.length(); i++) {
            // Move character at index i from s2 to s1
            String newS1 = s1 + s2.charAt(i);
            String newS2 = s2.substring(0, i) + s2.substring(i + 1);
            permutations(newS1, newS2); // Recursive call
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println("Permutations of \"" + s + "\":");
        permutations(s);
    }
}