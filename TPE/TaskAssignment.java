package TPE;
import java.util.*;

public class TaskAssignment {
	
	    private CSVReader reader;
	    private int estadosGeneradosBacktracking;
	    private int candidatosConsideradosGreedy;
	    private List<Processor> bestAssignmentBacktracking;
	    private List<Processor> bestAssignmentGreedy;
	    private int minExecutionTimeBacktracking;
	    private int minExecutionTimeGreedy;

	    public TaskAssignment(CSVReader reader) {
	        this.reader = reader;
	        this.estadosGeneradosBacktracking = 0;
	        this.candidatosConsideradosGreedy = 0;
	        this.bestAssignmentBacktracking = new ArrayList<>();
	        this.bestAssignmentGreedy = new ArrayList<>();
	        this.minExecutionTimeBacktracking = Integer.MAX_VALUE;
	        this.minExecutionTimeGreedy = Integer.MAX_VALUE;
	    }

	    public void backtrackingAssignTasks(int X) {
	        List<Processor> processors = new ArrayList<>(reader.getProcessors().values());
	        List<MyTask> criticalTasks = reader.getCriticalTasks();
	        List<MyTask> nonCriticalTasks = reader.getNonCriticalTasks();
	        backtrackingHelper(processors, criticalTasks, nonCriticalTasks, X, 0);
	    }

	    private void backtrackingHelper(List<Processor> processors, List<MyTask> criticalTasks, List<MyTask> nonCriticalTasks, int X, int index) {
	        if (index >= criticalTasks.size() + nonCriticalTasks.size()) {
	            int maxExecutionTime = calculateMaxExecutionTime(processors);
	            if (isValidAssignment(processors, X) && maxExecutionTime < minExecutionTimeBacktracking) {
	                minExecutionTimeBacktracking = maxExecutionTime;
	                bestAssignmentBacktracking = cloneProcessors(processors);
	            }
	            estadosGeneradosBacktracking++;
	            return;
	        }

	        List<MyTask> tasks = new ArrayList<>();
	        tasks.addAll(criticalTasks);
	        tasks.addAll(nonCriticalTasks);

	        MyTask currentTask = tasks.get(index);
	        for (Processor processor : processors) {
	            if (canAssignTask(processor, currentTask, X)) {
	                processor.addTask(currentTask);
	                backtrackingHelper(processors, criticalTasks, nonCriticalTasks, X, index + 1);
	                processor.removeTask(currentTask);
	            }
	        }
	    }

	    private boolean canAssignTask(Processor processor, MyTask task, int X) {
	        if (!processor.isRefrigerado() && processor.getTotalExecutionTime() + task.getTiempoEjecucion() > X) {
	            return false;
	        }
	        if (task.isCritica() && processor.hasCriticalTask()) {
	            return false;
	        }
	        return true;
	    }

	    private boolean isValidAssignment(List<Processor> processors, int X) {
	        for (Processor processor : processors) {
	            if (!processor.isRefrigerado() && processor.getTotalExecutionTime() > X) {
	                return false;
	            }
	            if (processor.countCriticalTasks() > 1) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private int calculateMaxExecutionTime(List<Processor> processors) {
	        int maxTime = 0;
	        for (Processor processor : processors) {
	            maxTime = Math.max(maxTime, processor.getTotalExecutionTime());
	        }
	        return maxTime;
	    }

	    private List<Processor> cloneProcessors(List<Processor> processors) {
	        List<Processor> clonedProcessors = new ArrayList<>();
	        for (Processor processor : processors) {
	            Processor clonedProcessor = new Processor(
	                processor.getId(),
	                processor.getCodigo(),
	                processor.isRefrigerado(),
	                processor.getAnio()
	            );
	            for (MyTask task : processor.getTasks()) {
	                clonedProcessor.addTask(task);
	            }
	            clonedProcessors.add(clonedProcessor);
	        }
	        return clonedProcessors;
	    }

	    public void greedyAssignTasks(int X) {
	        List<Processor> processors = new ArrayList<>(reader.getProcessors().values());
	        List<MyTask> criticalTasks = reader.getCriticalTasks();
	        List<MyTask> nonCriticalTasks = reader.getNonCriticalTasks();

	        List<MyTask> allTasks = new ArrayList<>();
	        allTasks.addAll(criticalTasks);
	        allTasks.addAll(nonCriticalTasks);
	        allTasks.sort(Comparator.comparingInt(MyTask::getNivelPrioridad).reversed());

	        for (MyTask task : allTasks) {
	            Processor bestProcessor = null;
	            int minIncrement = Integer.MAX_VALUE;

	            for (Processor processor : processors) {
	                if (canAssignTask(processor, task, X)) {
	                    int originalTime = processor.getTotalExecutionTime();
	                    processor.addTask(task);
	                    int newTime = processor.getTotalExecutionTime();
	                    processor.removeTask(task);

	                    int increment = newTime - originalTime;
	                    if (increment < minIncrement) {
	                        minIncrement = increment;
	                        bestProcessor = processor;
	                    }
	                }
	            }

	            if (bestProcessor != null) {
	                bestProcessor.addTask(task);
	                candidatosConsideradosGreedy++;
	            }
	        }

	        int maxExecutionTime = calculateMaxExecutionTime(processors);
	        if (maxExecutionTime < minExecutionTimeGreedy) {
	            minExecutionTimeGreedy = maxExecutionTime;
	            bestAssignmentGreedy = cloneProcessors(processors);
	        }
	    }

	    public void printResultsBacktracking() {
	        System.out.println("Backtracking:");
	        System.out.println("Solución obtenida:");
	        for (Processor processor : bestAssignmentBacktracking) {
	            System.out.println("Procesador " + processor.getId() + " tareas: " + processor.getTasks());
	        }
	        System.out.println("Tiempo máximo de ejecución: " + minExecutionTimeBacktracking);
	        System.out.println("Estados generados: " + estadosGeneradosBacktracking);
	    }
	        
	        
	        public void printResultsGreedy() {
	        System.out.println("\nGreedy:");
	        System.out.println("Solución obtenida:");
	        for (Processor processor : bestAssignmentGreedy) {
	            System.out.println("Procesador " + processor.getId() + " tareas: " + processor.getTasks());
	        }
	        System.out.println("Tiempo máximo de ejecución: " + minExecutionTimeGreedy);
	        System.out.println("Candidatos considerados: " + candidatosConsideradosGreedy);
	    }

	    public int getEstadosGeneradosBacktracking() {
	        return estadosGeneradosBacktracking;
	    }

	    public int getCandidatosConsideradosGreedy() {
	        return candidatosConsideradosGreedy;
	    }

	    // Complejidad temporal
	    // backtrackingAssignTasks: O(P^T) - Donde P es el número de procesadores y T es el número de tareas.
	    // greedyAssignTasks: O(T * P) - Donde T es el número de tareas y P es el número de procesadores.
	}



