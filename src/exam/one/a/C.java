package exam.one.a;

/**
 * Pass 1
 * return 191 + xyz(191, 99)
 * ...xyz(191, 99)
 * ...n2 <> 0
 * ...return 191 + (191, 98)
 * ...n2 <> 0
 * ...return 191 + (191, 97)
 * ...n2 <> 0
 * ...return 191 + (191, 96)
 * ... repeat
 * ... return 191 + (191, 0)
 * ...n2 == 0
 * ...return 0
 */
class C {
    /**
     * This function recursively adds n1 a total of n2 times. So essentially:
     * xyz(n1, n2) = n1 + n1 + n1 + ... (n2 times)
     *             = n1 * n2
     * 191 * 100 = 19100
     *
     * @param n1
     * @param n2
     * @return n1 + n1 + n1 + ... (n2 times)
     */
    static int xyz(int n1, int n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 + xyz(n1, n2 - 1);
    }

    /**
     * result = 19100 for 191, 100
     * --
     * However, for a smaller set
     * xyz(2, 3)
     * = 2 + xyz(2, 2)
     * = 2 + (2 + xyz(2, 1))
     * = 2 + (2 + (2 + xyz(2, 0)))
     * = 2 + (2 + (2 + 0))
     * = 6
     * xyz recursively adds n1 a total of n2 times.
     * which is the same as
     * n1 * n2 or 2 * 3
     *         or 191 * 100
     */
    public static void main(String[] args) {
        System.out.println(xyz(191, 100));
    }
}