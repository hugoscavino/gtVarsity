package exam.one.c;

class C {
    /**
     * 🧩 What is this code doing conceptually?
     *
     * It’s:
     * 	•	Printing two overlapping substrings on each recursive level
     * 	1.	From current left to right - 1
     * 	2.	From left + 1 to right
     * 	•	Then recursively moving left inward and right inward (like collapsing inward from both sides)
     *
     * 	Layer 1: abcde / bcdef
     *  Layer 2:  bcd  /  cde
     *  Layer 3:   c   /   d
     *
     * @param S string to parse
     * @param left
     * @param right
     */
    static void xyz(String S, int left, int right)
    {
        if (left <= right)
        {
            // 📌 S.substring(a, b) returns a substring from index a up to but not including index b.
            // Indexes:  0 1 2 3 4 5
            // Letters:  a b c d e f
                                           // begin index, end index
            System.out.println(S.substring(left, right));       // [left, right)
            System.out.println(S.substring(left+1, right+1));   // [left+1, right+1)

            xyz(S, left+1, right-1);                  // recursive call

        }
    }

    /**
     * 🧠 Let’s trace the recursive calls:
     *--
     * 1️⃣ Call: xyz("abcdef", 0, 5)
     * 	•	S.substring(0, 5) → "abcde"
     * 	•	S.substring(1, 6) → "bcdef"
     * 	•	Then recurse: xyz(S, 1, 4)
     *--
     * 2️⃣ Call: xyz("abcdef", 1, 4)
     * 	•	S.substring(1, 4) → "bcd"
     * 	•	S.substring(2, 5) → "cde"
     * 	•	Then recurse: xyz(S, 2, 3)
     *--
     * 3️⃣ Call: xyz("abcdef", 2, 3)
     * 	•	S.substring(2, 3) → "c"
     * 	•	S.substring(3, 4) → "d"
     * 	•	Then recurse: xyz(S, 3, 2)
     *--
     * 4️⃣ Call: xyz("abcdef", 3, 2)
     * 	•	Condition left <= right is false → base case → nothing happens
     *--
     * Output
     * -------
     * abcde
     * bcdef
     * bcd
     * cde
     * c
     * d
     *
     * @param args
     */
    public static void main(String[] args)
    {
        xyz("abcdef", 0, 5);
    }
}