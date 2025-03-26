public class SubsetPrinter {

    public static void subsets(int[] a, int n) {
        subsets("", a, n - 1); // Start recursion from the last index of the first n elements
    }

    public static void subsets(String s, int[] a, int n) {
        if (n < 0) {
            if (!s.isEmpty()) {
                System.out.println(s);
            }
            return;
        }

        // Recursive call excluding current element
        subsets(s, a, n - 1);

        // Recursive call including current element (prepend to maintain order as in example)
        subsets(a[n] + s, a, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("Subsets using first 3 elements:");
        subsets(a, 3);
    }
}