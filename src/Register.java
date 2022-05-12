import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Register {
    public static String register(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("<idno type=\"RegisterRef\">") >0){
                    int start = data.indexOf("Ref\">") + 5;
                    int end = data.indexOf("</idno>");
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
        System.out.print(register(path));
        System.out.print(register("data/reg_C-updated.xml"));
        System.out.print(register("data/reg_D-updated.xml"));
    }
}


