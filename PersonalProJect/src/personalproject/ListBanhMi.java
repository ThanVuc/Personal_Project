package personalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListBanhMi {

    ArrayList<BanhMi> al = new ArrayList<>();

    public void addInList(BanhMi bm) {
        al.add(bm);
    }

    public void readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] s = line.split(",");
                if (s[0].equalsIgnoreCase("1")) {
                    BanhMiThit bmt = new BanhMiThit(s[4].trim(), s[1].trim(), s[2].trim(), Integer.parseInt(s[3].trim()));
                    al.add(bmt);
                } else {
                    BanhMiCha bmc = new BanhMiCha(Integer.parseInt(s[4].trim()), s[1].trim(), s[2].trim(), Integer.parseInt(s[3].trim()));
                    al.add(bmc);
                }
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Find Not Found!");
        } catch (IOException ex) {
            System.out.println("Read File IO Exception!");
        } catch (Exception ex) {
            System.out.println("Errors");
        }
    }

    public void writeFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (BanhMi banhMi : al) {
                bw.write(banhMi.toString() + "\n");
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Write File IO Exception!");
        }
    }

}
