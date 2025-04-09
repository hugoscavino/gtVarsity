package exam.one.e;

class C
{
    /**
     * 🧠 What does xyz(A, n) do?
     *
     * It recursively calls itself with n-1, and after each recursive call, it swaps:
     * 	•	A[0] (the first element)
     * 	•	A[n - 1] (the element at the current depth from the end)
     *
     * This progressively swaps the outer elements inward, but always involving A[0],
     * not symmetric swaps from both ends. So it’s not a clean reverse.
     * @param A
     * @param n
     */
    static void xyz(int A[], int n)
    {
        if (n > 1)
        {
            xyz(A, n-1);

            int t = A[0];
            A[0] = A[n-1];
            A[n-1] = t;
        }
    }

    /**
     * 🔁 Step-by-Step Execution:
     * Given A = [1, 2, 3, 4, 5]
     * First: xyz(A, 5)
     * 	•	Calls xyz(A, 4)
     * 	•	Calls xyz(A, 3)
     * 	•	Calls xyz(A, 2)
     * 	•	Calls xyz(A, 1) → base case → returns
     *--
     * Now the swaps begin on the way back out of the recursion:
     * xyz(A, 2):
     * 	•	Swaps A[0] and A[1] → [2, 1, 3, 4, 5]
     *--
     * xyz(A, 3):
     * 	•	Swaps A[0] and A[2] → [3, 1, 2, 4, 5]
     *--
     * xyz(A, 4):
     * 	•	Swaps A[0] and A[3] → [4, 1, 2, 3, 5]
     *--
     * xyz(A, 5):
     * 	•	Swaps A[0] and A[4] → [5, 1, 2, 3, 4]
     * 	--
     */
    public static void main(String[] args)
    {
        int A[] = {1,2,3,4,5};
        xyz(A, 5);

        for (int i = 0; i < 5; i++) {
            System.out.print(A[i]+" ");
        }

        System.out.println();
    }
}