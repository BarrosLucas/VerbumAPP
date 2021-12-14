package com.example.verbum.business.report;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.example.verbum.business.model.User;
import com.example.verbum.infra.persistence.UserPersistence;
import com.example.verbum.infra.utils.FileUtils;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GeneratePDFReport extends GenerateReports{
    PdfDocumentInfo info;
    PdfDocument pdfDocument;
    Document document;

    public GeneratePDFReport(Context context){
        super(context);
        this.context = context;
        dest = "Report.pdf";
    }


    @Override
    public void generateFile() throws IOException {
        createFile();
        settings();
        //createPdf();
        body();
        FileUtils.openFile(context, new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()+"/"+dest));
    }

    @Override
    public void createFile() throws FileNotFoundException {
        PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()+"/"+dest)));
        pdfDocument = new PdfDocument(pdfWriter);
        info = pdfDocument.getDocumentInfo();
    }

    @Override
    public void settings() throws FileNotFoundException {
        if(info == null){
            createFile();
        }
        info.setTitle("Histórico de Logins");
        info.setAuthor("Equipe Verbum");
        info.setSubject("Verbum Demo");
        info.setKeywords("Login, PDF, Usuários");
        info.setCreator("Um simples relatório de logins");
        document = new Document(pdfDocument, PageSize.A4, true);

    }

    @Override
    public void body() throws IOException {
        Color mColorAccent = new DeviceRgb(153, 204, 255);
        Color mColorBlack = new DeviceRgb(0, 0, 0);
        float mHeadingFontSize = 20.0f;
        float mValueFontSize = 26.0f;


       // PdfFont font = PdfFontFactory.createFont("assets/fonts/brandon_medium.otf", "UTF-8", true);

        LineSeparator lineSeparator = new LineSeparator(new DottedLine());
        lineSeparator.setStrokeColor(new DeviceRgb(0, 0, 68));


        Text mOrderDetailsTitleChunk = new Text("VERBUM APP").setFontSize(36.0f).setFontColor(mColorBlack);
        Paragraph mOrderDetailsTitleParagraph = new Paragraph(mOrderDetailsTitleChunk)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(mOrderDetailsTitleParagraph);

        ArrayList<User> users = getUsers();

        for(User u: users){
            Text mOrderIdChunk = new Text(u.getName()+": ").setFontSize(mHeadingFontSize).setFontColor(mColorAccent);
            Paragraph mOrderIdParagraph = new Paragraph(mOrderIdChunk);
            document.add(mOrderIdParagraph);

            Text mOrderIdValueChunk = new Text("Qnt. de Logins: "+u.getAmountAccess()+"").setFontSize(mValueFontSize).setFontColor(mColorBlack);
            Paragraph mOrderIdValueParagraph = new Paragraph(mOrderIdValueChunk);
            document.add(mOrderIdValueParagraph);

            document.add(new Paragraph(""));
            document.add(lineSeparator);
        }

        document.close();
    }

    public ArrayList<User> getUsers(){
        UserPersistence userPersistence = UserPersistence.getInstance();
        return userPersistence.load(context);
    }

}