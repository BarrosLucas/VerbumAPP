package com.example.verbum.business.control.handle;

import android.content.Context;

import java.io.IOException;

public abstract class Handle {
    public Handle nextHandle;

    public abstract void handleCourier(String next, Context context) throws Exception;
}
