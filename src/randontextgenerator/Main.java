/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randontextgenerator;

import java.io.FileNotFoundException;

/**
 *
 * @author snehak85
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        String filename = args[0];

        RandonTextGenerator gen = new RandonTextGenerator(filename);

        gen.setDelimiters("[.?!]");

        String text = gen.generateText();
        
        System.out.println(text);
    }

}
