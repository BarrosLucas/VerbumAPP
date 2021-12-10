package com.example.verbum.business.control.handle;

import android.content.Context;

import com.example.verbum.business.report.GenerateHTMLReport;
import com.example.verbum.infra.utils.TAG;

public class HtmlHandle extends Handle{

    @Override
    public void handleCourier(String address, Context context) throws Exception {
        if(address.equals(TAG.HTML_GENERATOR)){
            (new GenerateHTMLReport(context)).generateFile();
        }else{
            nextHandle.handleCourier(address, context);
        }
    }
}
