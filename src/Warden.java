//This file returns the name of every Warden

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Locale;
import java.util.Scanner; // Import the Scanner class to read text files

public class Warden {
    public static String warden(String loc){
        String results = "";
        try {
            File myObj = new File(loc);
            Scanner myReader = new Scanner(myObj);
            String full1 ="";
            String full2 = "";
            String full3 = "";
            String full4 = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.indexOf("role=\"warden\"") >0){
                    //System.out.println(data);
                    int start = data.indexOf("n=") + 3;
                    int end = data.indexOf("role")-2;
                    full1 = data.substring(start, end);
                    String last = full1.substring(0,full1.length()-1);
                    String first = full1.substring(full1.length()-1);
                    full1 = first.toUpperCase() + ". " + last.substring(0,1).toUpperCase() + last.substring(1);
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    data = myReader.nextLine();
                    if(data.indexOf("role=\"warden\"") >0) { //there are multiple if statements to account for entries with >1 warden
                        start = data.indexOf("n=") + 3;
                        end = data.indexOf("role") - 2;
                        full2 = data.substring(start, end);
                        last = full2.substring(0, full2.length() - 1);
                        first = full2.substring(full2.length() - 1);
                        full2 = first.toUpperCase() + ". " + last.substring(0, 1).toUpperCase() + last.substring(1);
                        results = results + full1 + ", " + full2;
                        data = myReader.nextLine();
                        data = myReader.nextLine();
                        data = myReader.nextLine();
                        data = myReader.nextLine();
                        if(data.indexOf("role=\"warden\"") >0) {
                            start = data.indexOf("n=") + 3;
                            end = data.indexOf("role") - 2;
                            full3 = data.substring(start, end);
                            last = full3.substring(0, full3.length() - 1);
                            first = full3.substring(full3.length() - 1);
                            full3 = first.toUpperCase() + ". " + last.substring(0, 1).toUpperCase() + last.substring(1);
                            results = results + ", " + full3;
                            data = myReader.nextLine();
                            data = myReader.nextLine();
                            data = myReader.nextLine();
                            data = myReader.nextLine();
                            if (data.indexOf("role=\"warden\"") > 0) {
                                start = data.indexOf("n=") + 3;
                                end = data.indexOf("role") - 2;
                                full4 = data.substring(start, end);
                                last = full4.substring(0, full4.length() - 1);
                                first = full4.substring(full4.length() - 1);
                                full4 = first.toUpperCase() + ". " + last.substring(0, 1).toUpperCase() + last.substring(1);
                                results = results + ", " + full4;
                            }
                        }
                    } else results = results + full1;
                    results += "\n";


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
        System.out.print(warden(path));
        System.out.print(warden("data/reg_C-updated.xml"));
        System.out.print(warden("data/reg_D-updated.xml"));
    }
}


