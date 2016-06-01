package com.sf.app.library.connectivity;

import static com.sf.app.library.connectivity.ResponseResult.ResponseResultType.FAILED;

public class ResponseResult<T> {

    private ResponseResultType resultType;
    private T result;
    private Exception exception;

    public enum ResponseResultType {
        SUCCEEDED,
        FAILED,
        SUCCEEDED_EMPTY
    }

    public ResponseResultType getResultType() {
        return resultType;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
        this.resultType = ResponseResultType.SUCCEEDED;
    }

    public void setEmptyResult() {
        this.resultType = ResponseResultType.SUCCEEDED_EMPTY;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
        this.resultType = FAILED;
    }
}