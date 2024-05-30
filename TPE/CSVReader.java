package TPE;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import java.io.*;
import java.util.*;

public class CSVReader {
    private HashMap<String, Processor> processors;
    private HashMap<String, MyTask> tasks;
    private List<MyTask> criticalTasks;
    private List<MyTask> nonCriticalTasks;

    public CSVReader() {
        this.processors = new HashMap<>();
        this.tasks = new HashMap<>();
        this.criticalTasks = new ArrayList<>();
        this.nonCriticalTasks = new ArrayList<>();
    }

    public void readTasks(String taskPath) {
        File file = new File(taskPath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String id = parts[0].trim();
                String nombre = parts[1].trim();
                int tiempoEjecucion = Integer.parseInt(parts[2].trim());
                boolean critica = Boolean.parseBoolean(parts[3].trim());
                int nivelPrioridad = Integer.parseInt(parts[4].trim());
                MyTask tarea = new MyTask(id, nombre, tiempoEjecucion, critica, nivelPrioridad);
                tasks.put(id, tarea);
                if (critica) {
                    criticalTasks.add(tarea);
                } else {
                    nonCriticalTasks.add(tarea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readProcessors(String processorPath) {
        File file = new File(processorPath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String id = parts[0].trim();
                String codigo = parts[1].trim();
                boolean refrigerado = Boolean.parseBoolean(parts[2].trim());
                int anio = Integer.parseInt(parts[3].trim());
                Processor procesador = new Processor(id, codigo, refrigerado, anio);
                processors.put(id, procesador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, MyTask> getTasks() {
        return tasks;
    }

    public HashMap<String, Processor> getProcessors() {
        return processors;
    }

    public List<MyTask> getCriticalTasks() {
        return criticalTasks;
    }

    public List<MyTask> getNonCriticalTasks() {
        return nonCriticalTasks;
    }
}
