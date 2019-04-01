package com.strings;

/*
@GS
@Hackerank
Give column name given a column number in excel.
 */

public class ExcelNumberToColumnName {
    private static final int LETTER_COUNT = 26;

    public static void main(String[] args) {
        int num = 17602;
        System.out.println(findStringRep(num));
    }

    private static char getCharacterForNum(int num) {
        char begin = 'A';
        return (char) (begin + (num - 1));
    }

    private static String findStringRep(int num) {
        char ret;
        StringBuilder builder = new StringBuilder();
        // for single letters, num -> ascii value -> char -> string
        if (num <= LETTER_COUNT) {
            ret = getCharacterForNum(num);
            builder.append(ret);
            return builder.toString();
        }

        builder = find(num);

        return builder.toString();
    }

    private static StringBuilder find(int num) {
        StringBuilder b;
        int div = num / LETTER_COUNT;
        int mod = num % LETTER_COUNT;
        // boundary condition
        if (mod == 0) {
            div = div - 1;
            mod = LETTER_COUNT;
        }
        b = recurse(div).append(getCharacterForNum(mod));
        return b;
    }

    private static StringBuilder recurse(int n) {
        StringBuilder builder = new StringBuilder();
        if (n <= LETTER_COUNT) {
            builder.append(getCharacterForNum(n));
            return builder;
        }
        int temp1 = n / LETTER_COUNT;
        int temp2 = n % LETTER_COUNT;
        builder = recurse(temp1).append(recurse(temp2));
        return builder;
    }


}
