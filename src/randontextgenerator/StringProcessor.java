/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randontextgenerator;

/**
 * This class performs pre and post processing functions on the string
 *
 * @author snehak85
 */
public class StringProcessor {

    /**
     * Changes string to lower case
     * @param aLine
     * @return
     */
    protected String changeToLowerCase(String aLine) {
        aLine = aLine.toLowerCase();
        return aLine;
    }

    /**
     * Removes double quotes form the string
     * @param aLine
     * @return
     */
    protected String removeDoubleQuotes(String aLine) {
        aLine = aLine.replace("\"", "");
        return aLine;
    }

    /**
     * Removes single quotes from the string
     * @param aLine
     * @return
     */
    protected String removeSingleQuotes(String aLine) {
        aLine = aLine.replace("\'", "");
        return aLine;
    }


    /**
     * Adds the start code to the string
     * @param aLine
     * @return
     */
    protected String addStartCode(String aLine) {
        aLine = "(START) " + aLine;
        return aLine;
    }

    /**
     * Removes white space characters from the string
     * @param aLine
     * @return
     */
    protected String replaceWhiteSpace(String aLine) {
        aLine = aLine.replace("\n", " ");
        aLine = aLine.replace("\t", " ");
        aLine = aLine.replace("\r", " ");
        return aLine;
    }

    /**
     * Converts consecutive space characters to a single space character
     * @param aLine
     * @return
     */
    protected String collapseSpaces(String aLine) {
        aLine = aLine.trim();
        aLine = aLine.replaceAll("( )+", " ");
        return aLine;
    }

    /**
     * Adds spaces around a comma so that it is treated as a separate word
     * @param aLine
     * @return
     */
    protected String keepComma(String aLine) {
        aLine = aLine.replace(",", " , ");
        return aLine;
    }


    /**
     * Adds spaces around a semi colon so that it is treated as a separate word
     * @param aLine
     * @return
     */
    protected String keepSemiColon(String aLine) {
        aLine = aLine.replace(";", " ; ");
        return aLine;
    }

    /**
     * Adds spaces around a colon so that it is treated as a separate word
     * @param aLine
     * @return
     */
    protected String keepColon(String aLine) {
        aLine = aLine.replace(":", " : ");
        return aLine;
    }

    /**
     * Removes the added spaces around a comma
     * @param aLine
     * @return
     */
    protected String revertComma(String aLine) {
        aLine = aLine.replace(" , ", ", ");
        return aLine;
    }

    /**
     * Removes the added spaces around a semi colon
     * @param aLine
     * @return
     */
    protected String revertSemiColon(String aLine) {
        aLine = aLine.replace(" ; ", "; ");
        return aLine;
    }

    /**
     * Removes the added spaces around a colon
     * @param aLine
     * @return
     */
    protected String revertColon(String aLine) {
        aLine = aLine.replace(" : ", ": ");
        return aLine;
    }

    /**
     * Capitalizes the first letter of a sentence
     * @param aLine
     * @return
     */
    protected String capitalize(String aLine) {
        char[] stringArray = aLine.toCharArray();
        stringArray[0] = Character.toUpperCase(stringArray[0]);
        aLine = new String(stringArray);
        return aLine;
    }

}
