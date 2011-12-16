/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

/**
 *
 * @author raziel
 */
public class DupRemove {


    public String [] dupSuggestionFill (String [] Suggestions) {

        for(int i = 0;i< Suggestions.length;i++) {

            for (int j = i++;j < Suggestions.length;j++) {

                if(Suggestions[i].equals(Suggestions[j]) && !Suggestions[j].equals(" ")) {

                    Suggestions[j]=" ";

                }

            }


        }

        return Suggestions;

    }
    

}
