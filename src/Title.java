import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale;
import java.util.Scanner; // Import the Scanner class to read text files

public class Title {
    public static String title(String loc){
        String results = "";
        try {
            File myObj = new File(loc); //create file
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) { //this reads through the entire file
                String data = myReader.nextLine();
                if(data.indexOf("<div type=\"entry\" xml:id=") >0){ //start of entry
                    String title = ">";//number of entry
                    data = myReader.nextLine();
                    while(data.indexOf("<ab type=\"metadata\">")== -1){
                        title = title + data;
                        data = myReader.nextLine();
                    }
                    if(title.indexOf("\"#arber\"")!=-1){ //this adds in brackets before and after each arber note
                        title = title.replaceAll("<note resp=\"#arber\">", "[");
                        title = title.replaceAll("]</note>", "]");
                        title = title.replaceAll("</note>]", "]");
                        title = title.replaceAll("</note>", "]");
                    }
                    while(title.indexOf("<")>0){
                        title = title.replaceAll("<.*?>", "");
                    }
                    while(title.indexOf("  ")>0){
                        title = title.replaceAll("  ", " ");
                    }
                    title = title.substring(1,3).toUpperCase() + title.substring(3);
                    results = results + title.substring(1) + "\n";
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
        //System.out.print(title("data/reg_A-updated.xml")); //uncomment to run each file
        //System.out.print(title("data/reg_B-updated.xml"));
        //System.out.print(title("data/reg_C-updated.xml"));
        //System.out.print(title("data/reg_D-updated.xml"));
    }
}


