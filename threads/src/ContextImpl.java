


public class ContextImpl implements Context {


    private Thread t[];
    private int n = t.length;

    public ContextImpl(Thread[] t) {
        this.t = t;
    }

    @Override
    public int getCompletedTaskCount() {
        int completed = 0;

        for (int i = 0; i < n; i++ ) {
            if (t[i].getState() == Thread.State.TERMINATED) {
                completed++;
            }
        }
        return completed;
    }

    @Override
    public int getFailedTaskCount() {
        int failed = 0;

        for (int i = 0; i < n; i++) {
            if (t[i].getUncaughtExceptionHandler() != null) {
                failed++;
            }
        }
        return failed;
    }

    @Override
    public int getInterruptedTaskCount() {
        int interrupted = 0;
        for (int i = 0; i < n; i++) {
           if (t[i].isInterrupted()) {
               interrupted++;
           }
        }
        return interrupted;
    }

    @Override
    public void interrupt() {
        for(int i = 0; i < n; i++ ) {
           if (t[i].getState() == Thread.State.NEW  ) {
               t[i].interrupt();
           }
        }
    }

    @Override
    public boolean isFinished() {
        if (this.getCompletedTaskCount() + this.getInterruptedTaskCount() == n ) {
            return true;
        }
        else return false;
    }
}
