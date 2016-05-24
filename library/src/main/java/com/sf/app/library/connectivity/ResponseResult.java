package com.sf.app.library.utils.connectivity;

import java.util.List;

import static com.sf.app.library.utils.connectivity.ResponseResult.ResponseResultType.FAILED;

public class ResponseResult<T> {

    private ResponseResultType resultType;
    private List<T> resultList;
    private Exception exception;

    public enum ResponseResultType {
        SUCCEEDED,
        FAILED
    }

    public ResponseResultType getResultType() {
        return resultType;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
        this.resultType = ResponseResultType.SUCCEEDED;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
        this.resultType = FAILED;
    }
}