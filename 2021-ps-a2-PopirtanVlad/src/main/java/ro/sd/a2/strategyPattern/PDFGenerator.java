package ro.sd.a2.strategyPattern;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFGenerator extends IFile{

    @Override
    public void generateFile() throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Points Scoring.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
        Chunk chunk = new Chunk(super.createContent(), font);
        document.add(chunk);
        document.close();
    }
}
