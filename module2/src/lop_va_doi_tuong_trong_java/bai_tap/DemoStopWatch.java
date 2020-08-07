package lop_va_doi_tuong_trong_java.bai_tap;

public class DemoStopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    //Lấy thời gian của máy tính trả về giá trị milis
    void start(){
        startTime = System.currentTimeMillis();
    }
    void end(){
        endTime = System.currentTimeMillis();
    }
    long getElapsedTime(){
        return endTime - startTime;
    }
}
