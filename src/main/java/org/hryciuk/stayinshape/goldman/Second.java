package org.hryciuk.stayinshape.goldman;

/**
 *
 */
public class Second {
    /**
     * Instructions to candidate.
     *  1) Run this code in the REPL to observe its behaviour. The
     *     execution entry point is main().
     *  2) There are bugs in the implementation of atoi(). Consider
     *     adding some relevant tests.
     *  3) Correct the implementation of atoi(). Feel free to use
     *     print-style debugging in the absence of a true debugger.
     *  4) If time permits, consider adding robustness to atoi().
     *     For example, what type of input checking would be useful?
     */

        /**
         * Takes a string str and returns the int value represented by
         * the string. For example, atoi("42") returns 42.
         */
        public static int atoi(String str)
        {
            // check if string is not null
            // check if each character in the string fits in a range of number characters in ascii code table
            // Character.isNumber()
            int result = 0;
            int strLength = str.length();

            // length of the string corresponds to powers of 10
            // if the length == 3
            //i = 0 * 10^(length - 1 - i)
            //i = 1 * 10^(length - 1 - i)
            for (int i = 0; i < strLength; ++i) {
                char c = str.charAt(i);
                int val = Integer.parseInt("" + c);
                val = val * 10 ^ (strLength - 1 - i);
                result += val;
            }
            return result;
        };


        /**
         * boolean doTestsPass()
         * Returns true if all tests pass. Otherwise returns false.
         */
        public static boolean doTestsPass()
        {
            // todo: implement more tests, please
            // atoi("");  -> throw exception
            // atoi("123p0") -> throw exception
            // atoi("0001") -> throw exception
            int shouldBeFortyTwo = atoi("42");
            int shouldBeOneHundred = atoi("100");
            int shouldBeNinetyNine = atoi("99");
            // feel free to make testing more elegant
            boolean result = true;
            result = result && (shouldBeFortyTwo == 42);
            result = result && (shouldBeOneHundred == 100);
            result = result && (shouldBeNinetyNine == 99);
            result = result && (3 == 3);
            result = result && (1 != 2);

            return result;
        };


        /**
         * Execution entry point.
         */
        public static void main(String[] args)
        {
            if(doTestsPass())
            {
                System.out.println("All tests pass");
            }
            else
            {
                System.out.println("There are test failures");
            }
        }
}
