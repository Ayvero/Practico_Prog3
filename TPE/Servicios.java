package TPE;


import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.HashMap;


import java.util.*;

public class Servicios {
    private CSVReader reader;

    public Servicios(String pathProcesadores, String pathTareas) {
        reader = new CSVReader();
        reader.readProcessors(pathProcesadores);
        reader.readTasks(pathTareas);
    }

    public MyTask servicio1(String ID) {
        return reader.getTasks().get(ID);
    }

    public List<MyTask> servicio2(boolean esCritica) {
        return esCritica ? reader.getCriticalTasks() : reader.getNonCriticalTasks();
    }

    public List<MyTask> servicio3(int prioridadInferior, int prioridadSuperior) {
        List<MyTask> result = new ArrayList<>();
        for (MyTask tarea : reader.getTasks().values()) {
            if (tarea.getNivelPrioridad() >= prioridadInferior && tarea.getNivelPrioridad() <= prioridadSuperior) {
                result.add(tarea);
            }
        }
        return result;
    }

/**
 * Lectura de archivos CSV: La complejidad temporal de la lectura de archivos depende del tamaño de los archivos y del rendimiento de la operación de lectura de archivos en el sistema operativo y en la biblioteca utilizada. En términos generales, si consideramos que la lectura de los archivos tiene una complejidad lineal con respecto al tamaño de los archivos, podríamos considerar la complejidad como O(m + n), donde 'm' es el tamaño del archivo de procesadores y 'n' es el tamaño del archivo de tareas.

Inicialización de los HashMaps y TreeMap: La inicialización de HashMaps y TreeMap con datos preexistentes tiene una complejidad temporal O(n), donde 'n' es el número de elementos que se están agregando a las estructuras de datos.

Entonces, la complejidad temporal total del constructor sería la suma de las complejidades de las operaciones individuales:

O(m + n) (lectura de archivos) + O(n) (inicialización de HashMaps y TreeMap)

Donde 'm' es el tamaño del archivo de procesadores y 'n' es el tamaño del archivo de tareas.
 * @param ID
 * @return
 */
		 /**
	  * Devuelve una tarea basada en su ID. La complejidad temporal de esta operación es O(1), 
	  * ya que, dado el ID, la búsqueda en un HashMap tiene complejidad constante.
	  * @param tarea
	  * @return
	  */
	 
		 /**
	  * Devuelve una lista de tareas que tienen una propiedad específica (es crítica o no). 
	  * Itera sobre todas las tareas y verifica si cumplen con la condición. 
	  * La complejidad temporal de esta operación es O(n), donde 'n' es el número de tareas, 
	  * ya que en el peor de los casos tendría que revisar todas las tareas para construir la lista de salida.
	  * @param lista
	  * @return
	  */
	 public String listadoTareas (List<MyTask> lista){
		 StringBuilder listado = new StringBuilder();
		 	for (MyTask tarea : lista) {
	            listado.append(tarea.getDatosTarea()).append("\n");
	        }

	        return listado.toString();
		 }
	 
	  
	 
	    
	/**
	 * *operaciones principales que realiza:

	Creación del submapa: La creación del submapa utilizando el método subMap tiene una complejidad temporal de O(log n), 
	donde n es el número total de niveles de prioridad en el árbol tareasPorPrioridad.
	Iteración sobre el submapa y agregado de tareas: Iterar sobre el submapa y agregar las tareas a la lista tareasEnRango 
	tiene una complejidad lineal O(t), donde t es el número total de tareas dentro del rango de prioridades especificado.
	Por lo tanto, la complejidad temporal total del método servicio3_3 sería la suma de estas dos operaciones:
	O(log n) + O(t)
	Sin embargo, en la práctica, la complejidad se ve dominada principalmente por el número total de tareas dentro del rango de prioridades (t), 
	ya que la creación del submapa es relativamente eficiente en términos de tiempo. Por lo tanto, 
	la complejidad temporal del método servicio3_3 se puede simplificar a:
	O(t) Donde t es el número total de tareas dentro del rango de prioridades especificado.
	 * @param prioridadInferior
	 * @param prioridadSuperior
	 * @return
	 */
	 
/*  * En el peor de los casos, si todas las entradas están en el rango, el iterador recorrerá todas las entradas 
	  * del TreeMap y agregará todas las listas de tareas, lo que nos da una complejidad de:
		O(N) para iterar sobre todas las entradas del TreeMap.
		O(K) para agregar todas las listas de tareas donde 'K' es el total de tareas que cumplen la condición.
		Por lo tanto, la complejidad total del método es O(N + K), donde 'N' es el número de entradas en el TreeMap y 'K' es el número total de tareas que cumplen la condición de estar dentro del rango de prioridades especificado.
	  * @param prioridadInferior
	  * @param prioridadSuperior
	  * @return
	  */

	 public HashMap<String, MyTask> getTasks() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

}
