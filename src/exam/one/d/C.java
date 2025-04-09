package exam.one.d;

class C
{
    /**
     * This method rearranges the array by recursively pulling outer values inward toward the center,
     * while shifting values to make room, kind of like a controlled shuffle.
     * @param A array of int
     * @param left
     * @param right
     */
    static void xyz(int A[], int left, int right)
    {
        if (left < right)
        {
            xyz(A, left+1, right-1);

            int m = (left + right)/2;
            int temp = A[left];

            for (int i = left+1; i <= m; i++) {
                A[i-1] = A[i];
            }

            A[m] = A[right];

            for (int i = right-1; i >= m+1; i--) {
                A[i+1] = A[i];
            }

            A[m+1] = temp;
        }
    }

    /**
     * Let’s trace it step by step:
     *--
     * We start with:
     * A = [1, 2, 3, 4, 5, 6]
     *--
     * We call
     * xyz(A, 0, 5)
     * --
     * This function recursively calls:
     * 	•	xyz(1, 4)
     * 	•	Then xyz(2, 3)
     * --
     * Only after it hits the base case (left >= right) does it begin the
     * swapping/shuffling on the way back up the recursive calls.
     *
     * ------------
     * First recursive call: xyz(2, 3)
     * 	•	m = (2 + 3) / 2 = 2
     * 	•	temp = A[2] = 3
     * 	•	Shift A[3] to A[2] → A[2] = 4
     * 	•	Insert A[3] = 4 into A[2] (already done above)
     * 	•	Right side shift doesn’t apply (as i = 2 to 3 is skipped)
     * 	•	Place temp (3) into A[3]
     * --
     * Result:
     * A = [1, 2, 4, 3, 5, 6]
     * ---------------
     * Back to call: xyz(1, 4)
     * 	•	m = (1 + 4)/2 = 2
     * 	•	temp = A[1] = 2
     * 	•	Shift: A[2] → A[1], A[3] → A[2] → now A[1] = 4, A[2] = 3
     * 	•	Insert A[4] = 5 into A[2]
     * 	•	Shift: A[3] → A[4] (since i = 3), now A[4] = A[3] = 3
     * 	•	Place temp (2) into A[3]
     *
     * Result:
     * A = [1, 4, 5, 2, 3, 6]
     * --
     * Back to call: xyz(0, 5)
     * 	•	m = 2
     * 	•	temp = A[0] = 1
     * 	•	Shift: A[1] → A[0], A[2] → A[1], A[3] → A[2] → A becomes [4, 5, 2, 2, 3, 6]
     * 	•	Insert A[5] = 6 into A[2]
     * 	•	Shift: A[4] → A[5], A[3] → A[4] → A becomes [4, 5, 6, 2, 2, 3]
     * 	•	Place temp (1) into A[3]
     * 	--
     * 	Final result
     * 	A = [4, 5, 6, 1, 2, 3]
     */
    public static void main(String[] args)
    {
        int A[] = {1,2,3,4,5,6};

        xyz(A, 0, 5);

        for (int i = 0; i < 6; i++) {
            System.out.print(A[i]+" ");
        }

        System.out.println();
    }
}