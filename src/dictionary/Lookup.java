// <editor-fold defaultstate="collapsed" desc="comment">
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.sql.*;
import java.awt.*;

/**
 *
 * @author raziel
 */
public class Lookup {

    public List Meanings = null;
    public List Synonyms = null;
    public List Antinyms = null;
    public String[] Suggestions = new String[5];
    private int[] ID1;
    private int[] ID2;
    //  private int [] SwapID;
    //  int id01 = 0;
    //  int id02 = 0;
    private static java.sql.Connection conn = null;
    private static java.sql.Statement stat = null;
    private static java.sql.ResultSet rs = null;
    public String DBPath = "jdbc:firebirdsql://localhost:3050//home/fb/Dix.fdb";
    public String Username = "raziel";
    public String Password = "tintin";

    public Lookup() {

        if (!System.getProperty("os.name").equals("Linux")) {

            DBPath = "jdbc:firebirdsql://localhost:3050:C\\Dic\\Dictionary.fdb";

        }

        Meanings = new List(20, false);
        Synonyms = new List(20, false);
        Antinyms = new List(20, false);

        ID1 = new int[10];
        ID2 = new int[10];

    }

    public void Search(String word, String TTable, String SynTable, String AntTable) {



        try {

            java.sql.DriverManager.registerDriver(
                    (java.sql.Driver) Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance());

            conn = DriverManager.getConnection(DBPath, Username, Password);
            stat = conn.createStatement();

            rs = stat.executeQuery("select * from " + TTable + " where word like '" + word + "';");

            int i = 0;

            while (rs.next() && (i < 20)) {

                Meanings.add(rs.getString("trans").trim());
                ID1[i] = rs.getInt("id");

                //System.out.println("wordID => "+ID1[i]);
                i++;
            }

            int j = 0, x = 0;

            while (j < i) {

                rs = stat.executeQuery("select * from " + SynTable + " where ID1 like '" + ID1[j] + "';");

                while (rs.next()) {

                    ID2[x] = rs.getInt("id2");
                    //  System.out.println("Syn-ID2["+x+"] = "+ID2[x]);


                    x++;
                }
                j++;
            }

            j = 0;

            while (j <= x && (j < 20)) {

                rs = stat.executeQuery("select * from " + TTable + " where ID like '" + ID2[j] + "';");

                while (rs.next()) {

                    Synonyms.add(rs.getString("word").trim());
                    // System.out.println(rs.getString("word").trim());

                }
                j++;
            }

            /** swaping id2 with id1 */
            int temp = j;
            j = 0;
            x = 0;

            while (j < i) {

                rs = stat.executeQuery("select * from " + SynTable + " where ID2 like '" + ID1[j] + "';");

                while (rs.next()) {

                    ID2[x] = rs.getInt("id1");
                    System.out.println("Syn-ID2-afterSwap[" + x + "] = " + ID2[x]);

                    x++;
                }
                j++;
            }

            j = 0;

            while (j < x && (j < 20)) {

                rs = stat.executeQuery("select * from " + TTable + " where ID like '" + ID2[j] + "';");

                while (rs.next()) {

                    Synonyms.add(rs.getString("word").trim());
                    //   System.out.println(rs.getString("word").trim());

                }
                j++;
            }
//////////////////////////////////////////////////////////////////////////////////////////////

            //* the same goes for the antinyms! */

            //temp = 0;
            j = 0;
            x = 0;


            while (j <= i && (x < 20)) {

                rs = stat.executeQuery("select * from " + AntTable + " where ID1 like '" + ID1[j] + "';");

                while (rs.next()) {

                    ID2[x] = rs.getInt("id2");
                    System.out.print("Anti-ID2[" + x + "] = ");
                    System.out.println(ID2[x]);

                    x++;
                }

                j++;
            }

            j = 0;

            while (j < x) {

                rs = stat.executeQuery("select * from " + TTable + " where ID like '" + ID2[j] + "';");

                while (rs.next()) {

                    Antinyms.add(rs.getString("word").trim());
                    // System.out.println("AntIinLookup=> "+Antinyms[j]);

                }

                j++;
            }

            temp = j;
            j = 0;
            x = 0;

            while (j <= i && (x < 20)) {

                rs = stat.executeQuery("select * from " + AntTable + " where ID2 like '" + ID1[j] + "';");

                while (rs.next()) {

                    ID2[x] = rs.getInt("id1");
                    System.out.print("Anti-ID2-afterSwap[" + x + "] = ");
                    System.out.println(ID2[x]);

                    x++;
                }
                j++;
            }


            j = 0;

            while (j < x) {

                rs = stat.executeQuery("select * from " + TTable + " where ID like '" + ID2[j] + "';");

                while (rs.next()) {

                    Antinyms.add(rs.getString("word").trim());
                    //    System.out.println("AntIinLookup=> "+Antinyms[j]);

                    temp++;
                }

                j++;

            }

            rs = stat.executeQuery("select distinct word from " + TTable + " where word like '" + word + "%' ;");
            System.out.println("select distinct word from " + TTable + " where word like '" + word + "%' ;");
            int t = 0;
            String str;

            while (rs.next()) {

                str = rs.getString("word").trim();

                if ((!word.equals(str)) && (t < 5)) {
                    Suggestions[t] = str;
                    System.out.println("Suggestions=> " + str);
                    t++;
                }
            }
            
            rs.close();
            conn.close();

        } catch (Exception e) {
            e.getMessage();
        }

        int u = 0;

        for (u = 0; u < 2; u++) {

        }

    }
}// </editor-fold>

