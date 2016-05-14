package sf.com.itsp.domain;

public class Task {

    private String address;

    private String operation;

    private String arriveTime;

    private String latestDepartureTime;

    public Task(String address, String operation, String arriveTime,String latestDepartureTime) {
        this.address = address;
        this.operation = operation;
        this.arriveTime = arriveTime;
        this.latestDepartureTime = latestDepartureTime;
    }

    public String getAddress() {
        return address;
    }

    public String getOperation() {
        return operation;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public String getLatestDepartureTime() {
        return latestDepartureTime;
    }
}
