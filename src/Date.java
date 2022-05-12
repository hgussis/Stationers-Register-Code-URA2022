import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Date {
    public static String date(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("</date>") >0 && data.indexOf("notAfter=") >0){
                    int start = data.indexOf("notAfter=") + 22;
                    int end = data.indexOf("</date>");
                    results = results + data.substring(start, end) + "\n";
                }
                else if(data.indexOf(" <date type=\"Register\" when=") >0){
                    int start = data.indexOf(">") + 1;
                    int end = data.indexOf("</");
                    results = results + data.substring(start, end) + "\n";
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
        System.out.print(date(path));
        System.out.print(date("data/reg_C-updated.xml"));
        System.out.print(date("data/reg_D-updated.xml"));
    }
}
