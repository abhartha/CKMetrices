package ck;

public class ThreadExecution implements Runnable {
    String path;
    CreateChart cc;
    ThreadExecution(String path, CreateChart createChart) {
        this.path = path;
        cc = createChart;
    }
    public void run() {
        while(true) {
            try {
                Thread.sleep(15000);
                CKReport report = new CK().calculate(path);
                cc.updateData(report);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}