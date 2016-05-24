package com.sf.app.library.utils.connectivity;

import com.google.common.io.CharStreams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType;

import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_OK;
import static com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType.FAILED;
import static com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType.SUCCEEDED;
import static com.sf.app.library.utils.IoUtil.disconnectQuietly;

public class HttpClient {
    private String HEADER_CONTENT_TYPE = "Content-Type";
    private String VALUE_APPLICATION_JSON = "application/json";
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF8");
    private static final int CONNECT_TIMEOUT_MILLIS = 30 * 1000;
    private static final int READ_TIMEOUT_MILLIS = 35 * 1000;
    private static final String DEFAULT_PROTOCOL = "http";

    private String host;
    private int port;
    private final static String URL_JOINER = "/";

    private Map<String, String> propertiesMap = new HashMap<String, String>();

    public HttpClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String request(String path) {
        try {
            HttpURLConnection connection = initConnection(URL_JOINER + path);
            return getResponse(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private String getResponse(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        String response = CharStreams.toString(new InputStreamReader(inputStream, DEFAULT_CHARSET));
        inputStream.close();
        return response;
    }

    private HttpURLConnection initConnection(String path) throws IOException {
        URL url = new URL(DEFAULT_PROTOCOL, host, port, path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(8000);
        connection.setReadTimeout(8000);
        return connection;
    }

    public HttpResponseResult sendRequestGetResponse(String path, String request) {
        HttpURLConnection connection = null;
        try {
            connection = initConnection(path);
            send(request, connection);
            return receive(connection, path);
        } catch (Exception e) {
            return HttpResponseResult.RESPONSE_EXCEPTION_RESULT;
        } finally {
            disconnectQuietly(connection);
        }
    }

    private HttpResponseResult receive(HttpURLConnection connection, String path) throws IOException {
        int responseCode = connection.getResponseCode();

        if (responseCode == HTTP_OK) {
            return getHttpResponseResult(connection.getInputStream(), SUCCEEDED, path);
        }

        if (responseCode == HTTP_INTERNAL_ERROR) {
            return getHttpResponseResult(connection.getErrorStream(), FAILED, path);
        }

        return HttpResponseResult.RESPONSE_EXCEPTION_RESULT;
    }

    private HttpResponseResult getHttpResponseResult(InputStream inputStream, ResponseResultType succeeded, String path) throws IOException {
        String response = CharStreams.toString(new InputStreamReader(inputStream, DEFAULT_CHARSET));
        return new HttpResponseResult(succeeded, response);
    }

    private void send(String request, HttpURLConnection connection) throws IOException {
        byte[] bytes = request.getBytes(DEFAULT_CHARSET);
        connection.setFixedLengthStreamingMode(bytes.length);
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
}