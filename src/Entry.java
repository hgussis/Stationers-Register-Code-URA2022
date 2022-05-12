import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Entry {
    public static String entry(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("<div type=\"entry\" xml:id=") >0){
                    //System.out.println(data);
                    int start = data.indexOf("id=") + 4;
                    int end = data.indexOf(">")-1;
                    //System.out.println(start + " " + end);
                    //System.out.println(data.substring(start, end));
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
        System.out.print(entry(path));
        System.out.print(entry("data/reg_C-updated.xml"));
        System.out.print(entry("data/reg_D-updated.xml"));
    }
}

