package exam.two.a;

public class C {

    static boolean xyz(int A[], int left, int right) {
        if (left >= right) {
            return true;
        }

        int m = (left + right) / 2;

        boolean a1 = xyz(A, left, m);
        boolean a2 = xyz(A, m+1, right);
        boolean a3 = (A[m] != A[m+1]);

        return ( a1 &&  a2 && a3);
    }

    /**
     * Final Answer:
     *
     * This function returns true if the array contains no pair of adjacent equal elements,
     * but it does so by recursively checking sub-arrays and enforcing that:
     * It’s essentially a recursive check for adjacent duplicates, using a divide-and-conquer approach.
     * --
     * int[] A = {1, 2, 2, 3};
     * xyz(A, 0, 3) → false
     * 	•	A[1] == A[2] → false
     * 	•	So the function returns false immediately.
     * 	--
     * 	---
     * 	Return false if one or more pairs of adjacent elements in the array are equal. Otherwise, return true
     */
    public static void main(String[] args) {
        //a. Assume that l = 0 and r = n-1 initially.
        int A[] = {1,2,2,3}; // false
        int n = A.length;
        boolean result = xyz(A, 1, n-1);
        System.out.println(result);

        int[] AA = {1, 2, 3, 4};; // true
        int n2 = AA.length;
        boolean result2 = xyz(AA, 1, n2-1);
        System.out.println(result2);

    }
}
