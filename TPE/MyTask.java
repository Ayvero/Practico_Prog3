package TPE;

public class MyTask {
	
	
	    private String id;
	    private String nombre;
	    private int tiempoEjecucion;
	    private boolean critica;
	    private int nivelPrioridad;

	    public MyTask(String id, String nombre, int tiempoEjecucion, boolean critica, int nivelPrioridad) {
	        this.id = id;
	        this.nombre = nombre;
	        this.tiempoEjecucion = tiempoEjecucion;
	        this.critica = critica;
	        this.nivelPrioridad = nivelPrioridad;
	    }

	    public String getId() {
	        return id;
	    }

	    public boolean isCritica() {
	        return critica;
	    }

	    public int getNivelPrioridad() {
	        return nivelPrioridad;
	    }

		public int getTiempoEjecucion() {
			// TODO Esbozo de método generado automáticamente
			return tiempoEjecucion ;
		}

		public String getNombre() {
			// TODO Esbozo de método generado automáticamente
			return nombre;
		}

		

		public String getDatosTarea() {
			// TODO Esbozo de método generado automáticamente
			return null;
		}
	}



