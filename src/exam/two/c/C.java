package exam.two.c;

public class C {

    static int xyz(int n, int m)
    {
        if (2*m > n) {
            return m;
        }
        return xyz(n, 2*m);
    }

    /**
     * 🧠 What does it do?
     *--
     * This function:
     * 	•	Keeps doubling m (i.e., m = 1, 2, 4, 8, 16, ...)
     * 	•	Until 2 * m > n
     * 	•	Then it returns the current value of m
     *--
     * 📌 In simple terms:
     *--
     * The function returns the largest power of 2 that is ≤ n.
     *--
     * Why?
     * 	•	Because it keeps multiplying m by 2 (m *= 2)
     * 	•	Until 2 * m > n, which means m is the last power of 2 still within the limit
     *
     */
    public static void main(String[] args) {
        //    c. Assume that n and m are positive integers and m = 1 initially.
        // Return the biggest 2’s power value that is less than or equal to n.
        // Example:

        int result = xyz(20, 1);
        System.out.println(result);
        // m = 1 → 2*1 = 2 <= 20 → call xyz(20, 2)
        // m = 2 → 2*2 = 4 <= 20 → call xyz(20, 4)
        // m = 4 → 2*4 = 8 <= 20 → call xyz(20, 8)
        // m = 8 → 2*8 = 16 <= 20 → call xyz(20, 16)
        // m = 16 → 2*16 = 32 > 20 → return 16
        // So, it returns 16, which is the largest power of 2 ≤ 20

        // Function Call    Output
        //xyz(30, 1)        16
        //xyz(9, 1)         8
        //xyz(64, 1)        32
        //xyz(1, 1)         1

    }
}
