/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author raziel
 */
public class LanguageDeterminator {

    public String Direction(String str) {

        int direction = java.lang.Character.getDirectionality(str.charAt(0));

        if (direction == 0) {
            return "uno";
        } else if (direction == 2) {
            return "bi";
        }
        return "unknown";

    }//end of Direction method
}
