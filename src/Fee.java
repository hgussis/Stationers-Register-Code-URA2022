import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Fee {
    public static String fee(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("<num type=\"totalEntryPence\" value=") >0){
                    int start = data.indexOf("value=") + 7;
                    int end = data.indexOf(">") -2;
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
        System.out.print(fee(path));
        System.out.print(fee("data/reg_C-updated.xml"));
        System.out.print(fee("data/reg_D-updated.xml"));
    }
}

