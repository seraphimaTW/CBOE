/*
 * OPRA Feed Specification: https://www.opradata.com/specs/opra_output_binary_dr_spec.pdf
 *
 */

import java.util.Arrays;
import java.util.Collections;

public class TargetMethods {

    public TargetMethods() {

    }

    /*
     * Returns a character array of valid message types based on a given
     * message category.
     */
    public char[] getMessageTypes(byte category) {
        char[] types;

        switch (category) {
            case 'a':
                types = new char[]{' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'X'};
                break;
            case 'd':
            case 'f':
            case 'C':
                types = new char[]{' '};
                break;
            case 'H':
                types = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P'};
                break;
            case 'k':
            case 'q':
                types = new char[]{' ', 'F', 'I', 'R', 'T', 'A', 'B', 'O', 'C', 'X', 'Y'};
                break;
            case 'Y':
                types = new char[]{' ', 'I'};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + category);
        }

        return types;
    }

    /*
     * Returns the length of a message based on category, type, and message indicator
     */
    public int getMessageLength(char category, char type, char indicator) {
        int length;

        if (category == 'a'
                && Arrays.asList(' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'X')
                .contains(type)
                && indicator == ' ') {
            length = 43;
        } else if (category == 'd' && type == ' ' && indicator == ' ') {
            length = 30;
        } else if (category == 'f' && type == ' ' && indicator == ' ') {
            length = 72;
        } else if (category == 'k'
                && Arrays.asList(' ', 'A', 'B', 'C', 'F', 'I', 'O', 'R', 'T', 'X', 'Y')
                .contains(type)
                && Arrays.asList(' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P')
                .contains(indicator)) {
            length = 43;
        } else if (category == 'q'
                && Arrays.asList(' ', 'A', 'B', 'C', 'F', 'I', 'O', 'R', 'T', 'X', 'Y')
                .contains(type)
                && Arrays.asList(' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P')
                .contains(indicator)) {
            length = 29;
        } else if (category == 'C' && type == ' ' && indicator == ' ') {
            length = 450;
        } else if (category == 'H'
                && Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P').contains(type)
                && indicator == ' ') {
            length = 450;
        } else if (category == 'Y' && Arrays.asList(' ', 'I').contains(type) && indicator == ' ') {
            length = 27;
        } else {
            throw new IllegalStateException("Unexpected combination of: " + category + " category, " + type + " type, " + indicator + " indicator");
        }

        return length;
    }
}
