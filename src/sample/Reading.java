package sample;

import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading {
    public static TextArea readfile(String filename, TextArea lbltext) throws FileNotFoundException {

        Scanner sc= new Scanner(new File(filename));
        while (sc.hasNext()){
            String line1 = sc.nextLine();
            lbltext.appendText(line1+"\n");
        }
        sc.close();
        return lbltext;
    }

}
