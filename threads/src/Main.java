

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        try {
            manager.execute();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
