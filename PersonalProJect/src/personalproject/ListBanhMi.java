package personalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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

    public boolean deleteById(String id) {
        for (BanhMi bm : al) {
            if (id.equalsIgnoreCase(bm.getId())) {
                al.remove(bm);
                return true;
            }
        }
        return false;
    }

    public void sortByPrice(String str) {
        int i, j;
        BanhMi key;
        for (i = 1; i < al.size(); i++) {
            key = al.get(i);
            j = i - 1;
            if (str.equalsIgnoreCase("ics")) {
                while ((j >= 0) && (al.get(j).getPrice() > key.getPrice())) {
                    al.set(j + 1, al.get(j));
                    j -= 1;
                }
            } else {
                while ((j >= 0) && (al.get(j).getPrice() < key.getPrice())) {
                    al.set(j + 1, al.get(j));
                    j -= 1;
                }
            }
            al.set(j + 1, key);
        }
    }

    public BanhMi findById(String id) {
        for (BanhMi banhMi : al) {
            if (id.equalsIgnoreCase(banhMi.getId())) {
                return banhMi;
            }
        }
        return null;
    }

    public ArrayList<BanhMi> listByType(int i) {
        ArrayList<BanhMi> tmp = new ArrayList<>();
        if (i == 0) {
            for (BanhMi banhMi : al) {
                if (banhMi instanceof BanhMiThit) {
                    tmp.add(banhMi);
                }
            }
            return tmp;
        } else {
            for (BanhMi banhMi : al) {
                if (banhMi instanceof BanhMiCha) {
                    tmp.add(banhMi);
                }
            }
            return tmp;
        }
    }
}
