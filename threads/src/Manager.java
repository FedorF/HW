


public class Manager implements ExecutionManager {

    private Thread tasks[];
    Context context = new ContextImpl(tasks);

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        for (int i = 0; i < tasks.length; i++) {

            tasks[i].run();

        }

        return context;
    }
}
