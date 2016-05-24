package com.sf.app.library.utils.connectivity;

import com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType;

import static com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType.FAILED;
import static com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType.SUCCEEDED;

public class HttpResponseResult {
    // todo :zy, need merge ResponseResult
    private ResponseResultType resultType;
    private Exception responseException;
    private String responseResult;

    public final static HttpResponseResult RESPONSE_EXCEPTION_RESULT = new HttpResponseResult(FAILED, "", null);

    public ResponseResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResponseResultType resultType) {
        this.resultType = resultType;
    }

    public Exception getResponseException() {
        return responseException;
    }

    public void setResponseException(Exception responseException) {
        this.responseException = responseException;
    }

    public boolean isSuccess() {
        return resultType == SUCCEEDED;
    }

    public boolean isFailed() {
        return resultType == FAILED;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public HttpResponseResult(ResponseResultType resultType, String responseResult) {
        this(resultType, responseResult, null);
    }

    public HttpResponseResult(ResponseResultType resultType, String responseResult, Exception responseException) {
        this.resultType = resultType;
        this.responseException = responseException;
        this.responseResult = responseResult;
    }

    public boolean isEmpty() {
        return "".equals(responseResult) || "{}".equals(responseResult);
    }
}