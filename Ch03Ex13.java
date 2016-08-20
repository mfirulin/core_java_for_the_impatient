
public class Ch03Ex13 implements Runnable {
    private int id;
    
    public Ch03Ex13(int id) {
        this.id = id;
    }
    
    public void run() {
        System.out.println(id);
    }
    
    public static Runnable joinTasks(Runnable[] tasks) {
        return () -> {
            for (Runnable ta : tasks) {
                Thread th = new Thread(ta);
                th.start();
            }
        };
    }
    
    public static void main(String[] args) {
        Ch03Ex13[] tasks = new Ch03Ex13[10];
        for (int i = 0; i < tasks.length; i++)
            tasks[i] = new Ch03Ex13(i + 1);
            
        Runnable superTask = joinTasks(tasks);
        new Thread(superTask).start();  
    }
}