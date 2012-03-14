/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randontextgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * The publicly available interface to the random text generator
 * @author snehak85
 */
public class RandonTextGenerator {

    String fileName;
    String delimiters;

    /**
     * Constructor
     * Sets the default delimiter as period
     * @param fname
     */
    public RandonTextGenerator(String fname)
    {
        fileName = fname;
        delimiters = ".";
    }

    /**
     * Reads the file line by line, generating the chain repository and then using it to create the
     * random text
     * @return Random text generated
     * @throws FileNotFoundException
     */
    public String generateText() throws FileNotFoundException
    {
        String result = "";

        File fFile = new File(fileName);

        Scanner scanner = new Scanner(new FileReader(fFile)).useDelimiter(delimiters);

        StringProcessor p = new StringProcessor();

        ChainBuilder c = new ChainBuilder();

        try {
            //first use a Scanner to get each line
            while ( scanner.hasNext() ){
                String aLine = scanner.next();
                aLine = p.changeToLowerCase(aLine);
                aLine = p.removeDoubleQuotes(aLine);
                aLine = p.keepComma(aLine);
                aLine = p.keepColon(aLine);
                aLine = p.keepSemiColon(aLine);
                aLine = p.replaceWhiteSpace(aLine);
                aLine = p.collapseSpaces(aLine);
                if(aLine.equals(""))
                {
                    continue;
                }
                aLine = p.addStartCode(aLine);

                // All delimiters replaced by a period
                aLine = aLine + ".";
                c.generateChains(aLine);
            }
        }
        finally{
            scanner.close();
        }

        result = c.generateText();

        result = p.revertColon(result);
        result = p.revertComma(result);
        result = p.revertSemiColon(result);
        result = p.capitalize(result);
        return result;
    }

    /**
     * Set the delimiters in the file
     * @param delim
     */

    public void setDelimiters(String delim)
    {
        delimiters = delim;
    }
}
