package ro.sd.a2.strategyPattern;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class TXTGenerator extends IFile{


    @Override
    public void generateFile() throws IOException, DocumentException {
        String str = super.createContent();
        BufferedWriter writer = new BufferedWriter(new FileWriter("Points Scoring.txt"));
        writer.write(str);

        writer.close();
    }
}
