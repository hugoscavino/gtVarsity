package exam.two.d;

public class C {
    /**
     * 	•	A is a 2D square array of size n × n
     * 	•	The function is recursive, reducing n until it reaches 1.
     *
     * 	1.	xyz(A, n - 1) recursively computes the sum of elements in the (n-1) x (n-1) upper-left sub-matrix.
     * 	2.	Then, it adds:
     * 	•	The last column of the current n x n matrix (excluding bottom-right corner): A[0][n-1], A[1][n-1], ..., A[n-2][n-1]
     * 	•	The last row of the current matrix (excluding bottom-right corner): A[n-1][0], A[n-1][1], ..., A[n-1][n-2]
     * 	3.	Finally, adds the bottom-right element A[n-1][n-1].
     * 	--
     * 	📌 What is this function really doing?
     *
     * It recursively sums all elements in the upper-left square matrix of size n × n, building outward from 1 x 1 to n x n.
     * --
     * At each level, it:
     * 	•	Adds the new outer row and column (without double-counting the corner),
     * 	•	Recursively includes the inner square.
     * 	--
     *
     * @param A
     * @param n
     * @return
     */
    static int xyz(int A[][], int n)
    {
        if (n == 1) {
            return A[0][0];
        }

        int result = xyz(A, n-1);

        for (int i = 0; i < n-1; i++) {
            result += (A[i][n - 1] + A[n - 1][i]);
        }
        return result + A[n-1][n-1];
    }

    /**
     * 🔁 Visualization for 3×3 matrix:
     *
     * For n = 3, the function does:
     * 	1.	xyz(A, 2):
     * 	•	Returns the sum of A[0][0], A[0][1], A[1][0], A[1][1]
     * 	2.	Adds:
     * 	•	A[0][2], A[1][2] (last column except corner)
     * 	•	A[2][0], A[2][1] (last row except corner)
     * 	•	A[2][2] (bottom-right corner)
     *
     * ✅ Result: sum of all elements in a 3×3 matrix
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int result = xyz(A, 3);
        System.out.println("Sum of all elements: " + result);    }
}
