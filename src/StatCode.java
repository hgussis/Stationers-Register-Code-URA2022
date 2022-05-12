import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale;
import java.util.Scanner; // Import the Scanner class to read text files

public class StatCode {
    public static String statCode(String loc){
        String results = "";

        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("<div type=\"entry\" xml:id=") >0){ //start of entry
                    String title = ">";//number of entry
                    data = myReader.nextLine();
                    while(data.indexOf("<ab type=\"metadata\">")== -1){
                        title = title + data;
                        data = myReader.nextLine();
                    }
                    while(title.indexOf("<")>0){
                        title = title.replaceAll("<.*?>", "");
                    }
                    while(title.indexOf("  ")>0){
                        title = title.replaceAll("  ", " ");
                    }
                    title = title.toLowerCase();
                    String letter = ""; //the section below checks if each title contains certain words
                    if(title.contains("entred") || title.contains("entered")){
                        if(letter.equals("")){
                            letter = "E";
                        }
                        else letter = letter + ", E";
                    }
                    if(title.contains("assigned") || title.contains("assined") || title.contains("asined")){
                        if(letter.equals("")){
                            letter = "A";
                        }
                        else letter = letter + ", A";
                    }
                    if(title.contains("lycenced") || title.contains("licenced") || title.contains("lycences") || title.contains("lycensed") || title.contains("licence") || title.contains("licent")){ //added lycensed
                        if(letter.equals("")){
                            letter = "L";
                        }
                        else letter = letter + ", L";
                    }
                    String[] r = {"received", "receive", "receif", "receave", "receve", "recive", "reseiv", "reseve", "resceive", "rescaive", "resceve", "resseive", "recevyd", "receved", "receyyd", "receaued", "receyued", "receaved", "receifed", "receivet", "rccevyd"};
                    for (String word : r) { //this goes through the array to check if the title contains the word
                        if (title.contains(word)) {
                            if(letter.equals("")){
                                letter = "R";
                            }
                            else letter = letter + ", R";
                            //results = results + letter + "\n";
                            break;
                        }
                    }

                    if(letter.equals("")){
                        results += "\n";
                    } else{
                        results = results + letter + "\n";
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return results;
    }
    public static void main(String[] args){
        String path = "data/reg_B-updated.xml";
        //System.out.print(title(path));
        System.out.print(statCode("data/reg_A-updated.xml"));
        System.out.print(statCode("data/reg_B-updated.xml"));
        System.out.print(statCode("data/reg_C-updated.xml"));
        System.out.print(statCode("data/reg_D-updated.xml"));
    }
}


