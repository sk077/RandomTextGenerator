/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randontextgenerator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author snehak85
 * This class is used to generate 3 word chains from the given line of input.
 * It also generates the random text using the chain repository.
 */
public class ChainBuilder {

    // Set of all start sentences
    private HashSet startSentences;

    // Repository of all generated chaing
    private HashMap chainRepository;

    /**
     * Default constructor creates an empty chain repository and start sentence set
     */
    public ChainBuilder()
    {
        startSentences = new HashSet();
        chainRepository = new HashMap();
    }

    /**
     * @param aLine (The line from which 3 word chains are generated. It must have at least
     * 3 words
     */
    public void generateChains(String aLine)
    {
        String words[] = aLine.split(" ");

        if(words.length < 3)
        {
            return;
        }

        // If it is a start sentence add to set of start sentences
        if(words[0].compareTo("(START)")==0)
        {
            startSentences.add(words[1] + " " + words[2]);
        }

        for(int i = 1; i < words.length - 2 ; i++)
        {
            // Chain of 3 words starting at words[i]
            String chain = words[i] + " " + words[i+1] + " " + words[i+2];
            String firstTwoWords = words[i] + " " + words[i+1];

            /* The chain repository stores the chains in such a way that any chain
             * can easily be found by its first two words. It stores the set of chains (no duplicates)
             * that start with a given pair of words
             */
            HashSet values;
            if(chainRepository.containsKey(firstTwoWords))
            {
                values = (HashSet)chainRepository.get(firstTwoWords);
            }
            else
            {
                values = new HashSet();
            }
            values.add(chain);
            chainRepository.put(firstTwoWords, values);
        }
    }

    /**
     * This function randomly chooses a start sentence from the set of start sentences.
     * It then randomly finds a chain from the repository beginning with the last words of the
     * sentence generated so far. It continues this process until it encounters a period
     * @return the random generated text
     */

    public String generateText()
    {
        String result = "";

        Random generatorStart = new Random();
        Random chainSelector = new Random();

        // Randomly choose a start sentence
        int index = generatorStart.nextInt(startSentences.size());
        Object startStrs[] = startSentences.toArray();
        result = result + (String)startStrs[index];
        String lastTwoWords = result;

        while(!result.contains("."))
        {
            // Find the set of all chains beginning with the last 2 words generated
            HashSet values = (HashSet)chainRepository.get(lastTwoWords);
            Object strs[] = values.toArray();
            int i = chainSelector.nextInt(values.size());
            // Randomly select one of them
            String chain = (String)strs[values.size()-i-1];
            String words[] = chain.split(" ");
            // Set the new last 2 words
            lastTwoWords = words[1] + " " + words[2];
            // Append the third word to the result string
            result = result + " " + words[2];
        }
        return result;
    }

}
