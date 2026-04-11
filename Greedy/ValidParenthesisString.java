class ValidParenthesisString {
    public boolean checkValidString(String s)
    {
        // Intuition:
        // '*' can act as '(', ')' or empty.
        // So instead of fixing its value, we validate if a valid interpretation is POSSIBLE.

        // Key Idea:
        // 1. Left → Right:
        //    Treat '*' as '(' to avoid premature closing.
        //    Ensure we never have more ')' than '(' at any point.
        //
        // 2. Right → Left:
        //    Treat '*' as ')' to avoid leftover opening brackets.
        //    Ensure we never have more '(' than ')' from reverse perspective.
        //
        // If both passes are valid → string is valid.

        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        // ---------------- LEFT TO RIGHT ----------------
        // We try to ensure:
        // "At any point, closing brackets should not exceed opening ones"
        int counter1 = 0;

        for(int i = 0 ; i<s.length() ; i++)
        {
            // Treat '*' as '(' to maximize opening balance
            if(s.charAt(i) == '(' || s.charAt(i) == '*')
            {
                counter1 += 1;
            }
            else
            {
                // Encountered ')', reduce balance
                counter1 -= 1;
            }

            // If balance becomes negative → too many ')'
            // No way to fix using '*'
            if(counter1 < 0) return false;
        }

        // ---------------- RIGHT TO LEFT ----------------
        // Now we ensure:
        // "At any point, opening brackets should not exceed closing ones"
        int counter2 = 0;

        for(int i = 0 ; i< reversed.length() ; i++)
        {
            // Treat '*' as ')' to maximize closing balance
            if(reversed.charAt(i) == ')' || reversed.charAt(i) == '*')
            {
                counter2 += 1;
            }
            else
            {
                // Encountered '(', reduce balance
                counter2 -= 1;
            }

            // If balance becomes negative → too many '('
            if(counter2 < 0) return false;
        }

        // If both validations pass → valid string exists
        return true;
    }
}