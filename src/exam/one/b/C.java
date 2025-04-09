package exam.one.b;

class C
{
    /**
     * This function recursively processes the string by:
     * 	1.	Taking the substring excluding the last two characters: S.substring(0, n - 2)
     * 	2.	Then appending the last character, followed by the second last character
     * --
     * So, in effect, the function swaps the last two characters of the string, then does the same to the rest recursively.
     * This function swaps the last two characters recursively and builds a new string.
     * So "1/2-3*4" becomes "12/3-4*".
     *
     * @param s the string to parse
     * @return parsed string
     */
    static String xyz(String s)
    {
        int n = s.length();

        if (n == 1) {
            return s;
        }

        return( xyz(s.substring(0, n-2)) + s.charAt(n-1) + s.charAt(n-2) );
    }

    /**
     * ✅ Let’s trace xyz("1/2-3*4") step-by-step:
     * --
     * Input string: "1/2-3*4"
     * Length = 7
     *--
     * We’ll write it step-by-step:
     *----
     * First call:
     *--
     * xyz("1/2-3*4")
     * 	•	n = 7
     * 	•	Recurse on: xyz("1/2-3") (first 5 chars)
     * 	•	Append: '4' and '*'
     *----
     * Second call:
     *--
     * xyz("1/2-3")
     * 	•	n = 5
     * 	•	Recurse on: xyz("1/2")
     * 	•	Append: '3' and '-'
     *----
     * Third call:
     *--
     * xyz("1/2")
     * 	•	n = 3
     * 	•	Recurse on: xyz("1")
     * 	•	Append: '2' and '/'
     *----
     * Fourth call (base case):
     *--
     * xyz("1") returns "1"
     * --------------------------
     * 🔄 Now we reconstruct from the inside out:
     * 3rd Call
     * xyz("1/2") → xyz("1") + '2' + '/' → "1" + "2/" = "12/"
     * --
     * 2nd Call
     * xyz("1/2-3") → "12/" + '3' + '-' = "12/3-"
     * --
     * 3rd Call
     * xyz("1/2-3*4") → "12/3-" + '4' + '*' = "12/3-4*"
     */
    public static void main(String[] args)
    {
        System.out.println(xyz("1/2-3*4"));
    }
}