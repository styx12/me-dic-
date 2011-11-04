/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author raziel
 */
public class DBConfig {

    public String [] DBC = null;
    private String ConfigFilePATH = "DBConfig.cfg";
   
    public DBConfig () {

       DBC = new String[3];

       try {

    File ConfigFile = new File(ConfigFilePATH);
    Scanner ConfigFileScanner = new Scanner(ConfigFile);


       } catch (IOException e) {
           e.getMessage();
       }
    }

    public String [] readDBConfig () {


        return null;

    }

}
