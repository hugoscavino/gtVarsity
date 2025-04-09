package exam.one.f;

class C {

    /**
     * What’s happening here?
     *--
     * This is a classic recursive backtracking example generating all combinations of 'X' and 'O' of length n.
     * --
     * 🧠 Function Behavior:
     * 	•	b is the current string being built.
     * 	•	n is the number of characters still to be added.
     *--
     * At each level:
     * 	•	If n == 0: we’ve reached a full combination, so we print b.
     * 	•	Otherwise:
     * 	•	Append 'X' and recurse.
     * 	•	Append 'O' and recurse.
     *
     * @param b
     * @param n
     */
    static void xyz(String b, int n) {

        if (n == 0) {
            System.out.println(b);
        } else {
                xyz(b + "X", n - 1);
                xyz(b + "O", n - 1);
            }
        }

    /**
     * Start with
     * Trace: xyz("", 3)
     *Level 1: xyz("", 3)
     *   → xyz("X", 2)
     *     → xyz("XX", 1)
     *       → xyz("XXX", 0) → print: XXX
     *       → xyz("XXO", 0) → print: XXO
     *     → xyz("XO", 1)
     *       → xyz("XOX", 0) → print: XOX
     *       → xyz("XOO", 0) → print: XOO
     *   → xyz("O", 2)
     *     → xyz("OX", 1)
     *       → xyz("OXX", 0) → print: OXX
     *       → xyz("OXO", 0) → print: OXO
     *     → xyz("OO", 1)
     *       → xyz("OOX", 0) → print: OOX
     *       → xyz("OOO", 0) → print: OOO
     *--
     * 📌 Summary:
     *--
     * This program prints all 8 possible strings of length 3 made of 'X' and 'O'.
     *--
     * It essentially generates all binary strings of length n, where:
     * 	•	'X' can represent 0,
     * 	•	'O' can represent 1 (or vice versa).
     *--
     * So it’s a powerful example of generating combinations or recursively building a decision tree.
     */
    public static void main (String[] args)
        {
            xyz("", 3);
        }

}
