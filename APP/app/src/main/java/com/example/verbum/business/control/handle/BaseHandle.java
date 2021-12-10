package com.example.verbum.business.control.handle;

import android.content.Context;

import com.example.verbum.business.report.GeneratePDFReport;
import com.example.verbum.infra.utils.TAG;

import java.io.IOException;

public class BaseHandle extends Handle{
    @Override
    public void handleCourier(String address, Context context) throws Exception {
        if(address.equals(TAG.PDF_GENERATOR)){
            (new GeneratePDFReport(context)).generateFile();
        }else{
            if(nextHandle == null){
                nextHandle = new HtmlHandle();
            }
            nextHandle.handleCourier(address, context);
        }
    }
}
