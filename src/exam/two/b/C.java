package exam.two.b;

public class C {
    /**
     * 	• Recursively computes the maximum absolute difference between adjacent elements in the first n - 1 elements.
     * Then it compares that result t with the absolute difference
     * between the last two elements (A[n - 2] and A[n - 1]):
     *--
     * So it returns the maximum of:
     * 	•	the previous maximum (t)
     * 	•	the current adjacent difference (|A[n-2] - A[n-1]|)
     *
     * @param A
     * @param n
     * @return
     */
    static int xyz (int A[], int n) {
        if (n == 1) {
            return 0;
        }

        int t = xyz(A, n - 1);

        if (t > Math.abs(A[n - 2] - A[n - 1])) {
            return t;
        }
        return Math.abs(A[n-2]-A[n-1]);
    }



    /**
     * b. Assume that A is an array containing n integers.
     * Returns the biggest absolute value of the difference between two adjacent elements in the array.
     *--
     * 🧠 What does it compute?
     *--
     * This function computes the maximum absolute difference between any two adjacent elements in
     * the array A[0] through A[n-1].
     * --
     * int[] A = {4, 7, 2, 9};
     * xyz(A, 4)
     *--
     * Recursive steps:
     * 	•	xyz(A, 1) → 0
     * 	•	xyz(A, 2) → max(0, |4 - 7|) = 3
     * 	•	xyz(A, 3) → max(3, |7 - 2|) = 5
     * 	•	xyz(A, 4) → max(5, |2 - 9|) = 7 ✅
     */
    public static void main(String[] args) {
        int[] A = {4, 7, 2, 9};
        int result = xyz(A, 4);
        System.out.println(result);
    }
}
