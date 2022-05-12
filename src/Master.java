import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale;
import java.util.Scanner; // Import the Scanner class to read text files

public class Master {
    public static String master(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("role=\"master\"") >0){
                    //System.out.println(data);
                    int start = data.indexOf("n=") + 3;
                    int end = data.indexOf("role")-2;
                    String full1 = data.substring(start, end);
                    String last = full1.substring(0,full1.length()-1);
                    String first = full1.substring(full1.length()-1);
                    full1 = first.toUpperCase() + ". " + last.substring(0,1).toUpperCase() + last.substring(1);
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    String full2 = "";
                    if(data.indexOf("role=\"master\"") >0){ //this accounts for if there is >1 master
                        start = data.indexOf("n=") + 3;
                        end = data.indexOf("role")-2;
                        full2 = data.substring(start, end);
                        last = full2.substring(0,full2.length()-1);
                        first = full2.substring(full2.length()-1);
                        full2 = first.toUpperCase() + ". " + last.substring(0,1).toUpperCase() + last.substring(1);
                        results = results + full1 + ", " + full2 + "\n";
                    } else results = results + full1 + "\n";

                }
                /*else if(data.indexOf(" <date type=\"Register\" when=") >0){
                    int start = data.indexOf(">") + 1;
                    int end = data.indexOf("</");
                    results = results + data.substring(start, end) + "\n";
                } */

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
        System.out.print(master(path));
        System.out.print(master("data/reg_C-updated.xml"));
        System.out.print(master("data/reg_D-updated.xml"));
    }
}


