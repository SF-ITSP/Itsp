package com.sf.app.library.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class IoUtil {
    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void disconnectQuietly(HttpURLConnection connection) {
        if (connection == null) {
            return;
        }

        connection.disconnect();
    }
}
