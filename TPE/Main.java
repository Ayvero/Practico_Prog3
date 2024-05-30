package TPE;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

	
	    public static void main(String[] args) {
	        // Inicializar el lector de CSV y cargar los datos
	    	Servicios servicios = new Servicios("./src/TPE_DataSet/Procesadores.csv", "./src/TPE_DataSet/Tareas.csv");
	    	// Leer los datos de los archivos
            CSVReader reader = new CSVReader();
            reader.readProcessors("./src/TPE_DataSet/Procesadores.csv");
            reader.readTasks("./src/TPE_DataSet/Tareas.csv");

            // Obtener las listas de procesadores y tareas
            List<Processor> processors = new ArrayList<>(reader.getProcessors().values());
            List<MyTask> tasks = new ArrayList<>(reader.getTasks().values());

	       
	        // Crear instancias de la clase asignación
            // Crear una instancia de TaskAssignment
	        TaskAssignment asignacion = new TaskAssignment(reader);
	        
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("Seleccione una opción:");
	            System.out.println("1. Obtener información de una tarea por ID");
	            System.out.println("2. Ver todas las tareas críticas o no críticas");
	            System.out.println("3. Obtener todas las tareas entre 2 niveles de prioridad");
	            System.out.println("4. Asignar tareas a procesadores usando Backtracking");
	            System.out.println("5. Asignar tareas a procesadores usando Greedy");
	            System.out.println("6. Salir");

	            int opcion = scanner.nextInt();
	            scanner.nextLine();  // Consumir el salto de línea

	            switch (opcion) {
	                case 1:
	                    System.out.println("Ingrese el ID de la tarea:");
	                    String id = scanner.nextLine();
	                    MyTask tarea = servicios.servicio1(id);
	                    System.out.println(tarea != null ? tarea : "Tarea no encontrada");
	                    break;

	                case 2:
	                    System.out.println("¿Desea ver tareas críticas (true) o no críticas (false)?");
	                    boolean criticas = scanner.nextBoolean();
	                    List<MyTask> tareasTipo = servicios.servicio2(criticas);
	                    tareasTipo.forEach(System.out::println);
	                    break;

	                case 3:
	                    System.out.println("Ingrese el nivel de prioridad mínimo:");
	                    int nivelMin = scanner.nextInt();
	                    System.out.println("Ingrese el nivel de prioridad máximo:");
	                    int nivelMax = scanner.nextInt();
	                    List<MyTask> tareasPrioridad = servicios.servicio3(nivelMin, nivelMax);
	                    tareasPrioridad.forEach(System.out::println);
	                    break;

	                case 4:
	                    System.out.println("Ingrese el valor de X para procesadores no refrigerados:");
	                    int xBacktracking = scanner.nextInt();
	                    asignacion.backtrackingAssignTasks(xBacktracking);
	                    asignacion.printResultsBacktracking();
	                    break;

	                case 5:
	                    System.out.println("Ingrese el valor de X para procesadores no refrigerados:");
	                    int xGreedy = scanner.nextInt();
	                    asignacion.greedyAssignTasks(xGreedy);
	                    asignacion.printResultsGreedy();
	                    break;

	                case 6:
	                    exit = true;
	                    break;

	                default:
	                    System.out.println("Opción no válida. Intente de nuevo.");
	            }
	        }

	        scanner.close();
	    }
	}

	

