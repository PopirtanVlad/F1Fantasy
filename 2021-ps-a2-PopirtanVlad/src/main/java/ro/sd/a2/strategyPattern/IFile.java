package ro.sd.a2.strategyPattern;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class IFile {
    public String createContent(){ return "Qualifying\n" +
                "Q1 Finish" + "\t\t\t\t\t\t\t\t"+ "1 pt\n" +
                "Q2 Finish" + "\t\t\t\t\t\t\t\t"+ "2 pts\n" +
                "Q3 Finish" + "\t\t\t\t\t\t\t\t"+ "3 pts\n" +
                "Qualified ahead of team mate (driver only)" +"\t\t\t\t"+ "2 pts\n" +
                "Did not qualify (driver only)" + "\t\t\t\t\t\t" + "-5 pts\n" +
                "Disqualification from qualifying (driver only)" + "\t\t\t\t" +"-10 pts\n\n\n"+
                "Race\n" +
                "Finished Race" + "\t\t\t\t\t\t\t\t\t\t"+ "1 pt\n" +
                "Finished race, position gained (per place gained, max. +10 pts)" + "\t\t\t\t"+ "2 pts\n" +
                "Finished ahead of team mate (driver only)" + "\t\t\t\t\t\t"+ "3 pts\n" +
                "Fastest lap (driver only)" + "\t\t\t\t\t\t\t\t"+ "5 pts\n" +
                "Started race within Top 10, finished race but lost position"+ "\t\t\t\t" + "-2 pts\n" +
                "Started race outside Top 10, finished race but lost position"+ "\t\t\t\t" + "-1 pt\n" +
                "Not classified (driver only)"+ "\t\t\t\t\t\t\t\t" + "-15 pts\n" +
                "Disqualification from race (driver only)" + "\t\t\t\t\t\t"+ "-20 pts\n";
    }
    public abstract void generateFile() throws IOException, DocumentException;
}
