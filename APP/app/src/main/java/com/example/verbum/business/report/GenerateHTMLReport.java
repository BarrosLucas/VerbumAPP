package com.example.verbum.business.report;

import android.content.Context;
import android.os.Environment;

import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GenerateHTMLReport extends GenerateReports{
    ObjectOutputStream file;

    public GenerateHTMLReport(Context context){
        super(context);
        dest = "Report.html";
    }

    @Override
    public void generateFile() throws Exception {

    }

    @Override
    public void createFile() throws Exception {
        file = new ObjectOutputStream(new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString(), dest)));
    }

    @Override
    public void settings() throws Exception {

    }

    @Override
    public void body() throws Exception {

    }


}
