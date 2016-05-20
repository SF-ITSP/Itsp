package sf.com.itsp.domain;

public class Task {
    private String address;
    private String operation;
    private String arriveTime;
    private String latestDepartureTime;
    private int waitingTime;
    private String vehicleStatus;

    public Task(String address, String operation, String arriveTime, String latestDepartureTime, int waitingTime, String vehicleStatus) {
        this.address = address;
        this.operation = operation;
        this.arriveTime = arriveTime;
        this.latestDepartureTime = latestDepartureTime;
        this.waitingTime = waitingTime;
        this.vehicleStatus = vehicleStatus;
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

    public int getWaitingTime() {
        return waitingTime;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

}
