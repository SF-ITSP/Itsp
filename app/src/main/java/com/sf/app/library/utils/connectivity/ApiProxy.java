package com.sf.app.library.utils.connectivity;

public class ApiProxy {
    private static ApiProxy instance;

    protected ApiProxy() {
    }

    public static synchronized ApiProxy sharedInstance() {
        if (instance == null) {
            instance = new ApiProxy();
        }

        return instance;
    }

    public String requestOrder() {
        return "1";
    }
}
