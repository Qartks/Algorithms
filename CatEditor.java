package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/26/17.
 */
public class CatEditor {

    static public class Cursor {
        public int column;
        public int row;

        public Cursor(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public String toString() {
            return row + " " + column;
        }
    }

    // diff comes from the other screen.
    // content is content of the current screen before diff is applied.
    // cursor is the cursor of the current screen.

    // diff format:
    // The diff contains all content from beginning to end of document.

    //    {{"1", "\n"}, {"0", "cat"}}
    // house -> horse = {{"0", "ho"}, {"-1", "u"}, {"1", "r"}, {"0", "se"}}
    // "0" -> equality, "1" -> addition, "-1" -> removal
    static public Cursor fixCursorRow(String[][] diff, String content, Cursor cursor) {


        for (String[] s : diff ) {
            String action = s[0];
            String value = s[1];

            if (action.equals("1") && value.equals("\n")) {
                cursor.row++;
            } else if (action.equals("-1") && value.equals("\n")) {
                cursor.row--;
            }
        }

        return cursor;
    }

    public static void main(String[] args) {

        Cursor c = new Cursor(0, 0);
        String[][] cat = {{"-1", "\n"}, {"0", "cat"}};
        fixCursorRow(cat, "cat", c);


        System.out.println(c.toString());
    }


}
