package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void Simple_Savings(String FileName, String PV, String IntRate, String Period, String FV) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nPresent Value : "   + PV);
        fileWriter.write("\nInterest Rate : "   + IntRate);
        fileWriter.write("\nTime : "            + Period);
        fileWriter.write("\nFuture Value : "    + FV          + "\n\n");

        fileWriter.close();

    }
    public static void Compound_Interest(String FileName,String FV,String IntRate,String PV,String MonthPay,String Period) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter=  new FileWriter(file01,true);
        fileWriter.write("\nFuture Value : "     + FV);
        fileWriter.write("\nInterest Rate : "    + IntRate);
        fileWriter.write("\nPresent Value : "    + PV);
        fileWriter.write("\nMonthly Payment : "  + MonthPay);
        fileWriter.write("\nPeriod : "           + Period     + "\n\n");

        fileWriter.close();

    }
    public static void Loan(String FileName,String HP,String IntRate,String LTerm,String MonthPay) throws IOException {
        File file01 = new File(FileName);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nHome Price : "       + HP);
        fileWriter.write("\nInterest Rate : "    + IntRate);
        fileWriter.write("\nLoan Term : "        + LTerm);
        fileWriter.write("\nMonthly Payment : "  + MonthPay   + "\n\n");

        fileWriter.close();

    }

    public static void Mortgage(String filename,String HP,String DP,String Period,String IntRate,String MonthPay) throws IOException {
        File file01 = new File(filename);
        FileWriter fileWriter =  new FileWriter(file01,true);
        fileWriter.write("\nHome value : "      + HP);
        fileWriter.write("\nDown Payment : "    + DP);
        fileWriter.write("\nLoan  term : "      + Period);
        fileWriter.write("\nInterest Rate : "   + IntRate);
        fileWriter.write("\nMonthly Payment : " + MonthPay    +  "\n\n");

        fileWriter.close();

    }
}