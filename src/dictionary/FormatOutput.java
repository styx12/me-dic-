/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.awt.*;

/**
 *
 * @author raziel
 */
public class FormatOutput {

    public FormatOutput() {

        
    }

    private String nullCheck(String Suggestion) {

        if (Suggestion == null){

            return " ";
        }

        return Suggestion;
    }



    public String[] formatText(java.awt.List TList, java.awt.List SynList, java.awt.List AntList) {

        String[] word = new String[3];
        String Tword = "";
        String Synword = "";
        String Antword = "";

        int i = TList.getItemCount();
        int j = 0;

        while (j < i) {

            if(!Tword.equals("")){
            Tword = Tword + "-" + TList.getItem(j).toString();
            } else {
                 Tword = TList.getItem(j).toString();
            }

            j++;
        }

        //System.out.println("Meanning(s):\n" + Tword);


        i = SynList.getItemCount();
        j = 0;

       // System.out.println("itemcount="+i);

        while (j < i) {

            if(!Synword.equals("")){
            Synword = Synword + "-" + SynList.getItem(j).toString();
            } else {
                  Synword = SynList.getItem(j).toString();
            }

           // = Synword + "," + SynList.getItem(j).toString();
            j++;
        }

        // System.out.println("Synonym(s):\n" + Synword);

        i = AntList.getItemCount();
        j = 0;

        while (j < i) {

            if (!Antword.equals("")) {

            Antword = Antword + "-" + AntList.getItem(j).toString();

            } else {

               Antword = AntList.getItem(j).toString();
            }

            System.out.println("Anti=> "+AntList.getItem(j));

            j++;
        }

        //    System.out.println("Antinym(s):\n" + Antword);

        word[0] = Tword;
        word[1] = Synword;
        word[2] = Antword;

        return (word);//(Tword+"\n"+Synword+"\n"+Antword+"\n"));

    }

    public String HtmlFormatting (String [] word,String [] Suggestions) {

        if (word[0].equals(" ")) {

            word[0] = " ";

        } if (word[1].equals(" ")) {

            word[1] = " ";
        } if (word[2].equals(" ")) {
            
            word[2] = " ";
        }

      /*  int x = Suggestions.length;
      //  int i =0;

    for (int i =0;i<4; i++) {

        if( Suggestions[i].equals(null) && (i < x) ) {
            System.out.println(Suggestions[i]);
            Suggestions[i]="no suggestion!";
        }

        }*/

String TXword =
       " <html><table "+
"style=\"text-align: left; width: 100%; font-family: DejaVu Serif; margin-right: auto; margin-left: auto;\""+
"border=\"1\" cellpadding=\"2\" cellspacing=\"2\">"+
"<tbody> <tr>"+
"<td style=\"vertical-align: top;\">Meaning(s)</td>"+
"<td style=\"vertical-align: top;\">Snonym(s)<br></td>"+
"<td style=\"vertical-align: top;\">Antinym(s)<br>"+
"</td></tr><tr><td style=\"vertical-align: top; color: rgb(102, 0, 0);\">"+word[0]+"<br></td>"+
"<td style=\"vertical-align: top; color: rgb(102, 0, 0);\">"+word[1]+"<br></td>"+
"<td style=\"vertical-align: top; color: rgb(102, 0, 0);\">"+word[2]+"<br>"+
"</td></tr></tbody></table>"+
"<div style=\"text-align: center;\"><br style=\"color: rgb(0, 153, 0);\">"+
"</div><table "+
"style=\"text-align: left; width: 100%; margin-right: auto; margin-left: auto;\""+
"border=\"1\" cellpadding=\"2\" cellspacing=\"2\">"+
"<tbody><tr>"+
"<td style=\"vertical-align: top; font-family: Arial;\"><span "+
"style=\"color: rgb(0, 153, 0);\">Suggested&nbsp; words!</span> <br>"+
"</td></tr><tr><td style=\"vertical-align: top;font-family: Arial;\">"+this.nullCheck(Suggestions[0])+"<br>"+
"</td></tr><tr>"+
"<td style=\"vertical-align: top;font-family: Arial;\">"+this.nullCheck(Suggestions[1])+"<br>"+
"</td></tr><tr>"+
"<td style=\"vertical-align: top; font-family: Arial; \">"+this.nullCheck(Suggestions[2])+"<br>"+
"</td></tr><tr><td style=\"vertical-align: top; font-family: Arial; \">"+this.nullCheck(Suggestions[3])+"<br>"+
"</td></tr></tbody></table>"+
"<div style=\"text-align: center;\"><br></div>"+

        "<div style=\"text-align: center;\">  " +
        "<p class=\"Standard\">written by Raziel,email:<a href=\"http://Email/\">razielx11@hotmail.com</a><br/></p>"+
       "</div>"+

"</html";

return TXword;

     /*  return (
               
               "<html>"+
//"<head>"+
//"<meta content=\"text/html; charset=UTF-8\" http-equiv=\"Content-Type\">"+
//"<title></title>"+
//"</head>"+
//"<body>"+
"<div style=\"text-align: center;\"><span style=\"color: rgb(51, 204, 0);\"> " + "\n"+
               "Meanning(s)" +

              "- معنی"+
               "</span>"+
               "<br style=\"color: rgb(51, 204, 0);\">"+

"<br style=\"color: rgb(0, 0, 102);\">"+
"<span style=\"color: rgb(51, 51, 51);\">" +word[0]+ "</span><br>"+
"<br>"+
"<span style=\"color: rgb(51, 204, 0);\">Synonym(s) - مترادف</span><br>"+
"<br>"+
"<span style=\"color: rgb(0, 0, 102);\">"+ word[1] +"</span><br>"+
"<br>"+
"<span style=\"color: rgb(51, 204, 0);\">Antinym(s) - متضاد</span><br>"+
"<br>"+
"<span style=\"color: rgb(153, 51, 0);\">"+word[2]+"</span><br>"+
"</div>"+
//"</body>" +
               "</html>"
);

      */

    }

    public List dupRemover (List dupRemoved) {

      //  List dupRemoved = new List(20,false);

      int i = dupRemoved.getItemCount()-1;

        for (int x= 0;x< i;x++) {

            for(int y =0;y < (i-x)-1;y++) {

             //   System.out.println(dupRemoved.getItem(x).toString());

                if (dupRemoved.getItem(x).toString().equals(dupRemoved.getItem(y).toString())) {//.equals(
                     // dupRemoved.getItem(y).toString().

                    System.out.println("dupRemoved.getItem(x).toString()--> "+dupRemoved.getItem(x).toString());
                    dupRemoved.remove(x);

                        }
            }

        }

        return dupRemoved;
        
    }


    


}


