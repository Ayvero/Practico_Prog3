package TPE;


import java.util.ArrayList;
import java.util.List;

public class Processor {
    private String id;
    private String codigo;
    private boolean refrigerado;
    private int anio;
    private List<MyTask> tasks;

    public Processor(String id, String codigo, boolean refrigerado, int anio) {
        this.id = id;
        this.codigo = codigo;
        this.refrigerado = refrigerado;
        this.anio = anio;
        this.tasks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public int getAnio() {
        return anio;
    }

    public List<MyTask> getTasks() {
        return tasks;
    }

    public void addTask(MyTask task) {
        tasks.add(task);
    }

    public void removeTask(MyTask task) {
        tasks.remove(task);
    }

    public int getTotalExecutionTime() {
        int total = 0;
        for (MyTask task : tasks) {
            total += task.getTiempoEjecucion();
        }
        return total;
    }

    public boolean hasCriticalTask() {
        for (MyTask task : tasks) {
            if (task.isCritica()) {
                return true;
            }
        }
        return false;
    }

    public int countCriticalTasks() {
        int count = 0;
        for (MyTask task : tasks) {
            if (task.isCritica()) {
                count++;
            }
        }
        return count;
    }
}
