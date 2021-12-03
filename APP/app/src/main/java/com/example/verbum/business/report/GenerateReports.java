package com.example.verbum.business.report;

import android.content.Context;

import androidx.core.content.FileProvider;

public abstract class GenerateReports extends FileProvider {
    Context context;
    String dest;
    public GenerateReports(Context context){
        this.context = context;
    }

    public abstract void generateFile() throws Exception;

    public abstract void createFile() throws Exception;

    public abstract void body() throws Exception;

    public abstract void settings() throws Exception;
}
