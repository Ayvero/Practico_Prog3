# Trabajo Práctico Final - Optimización de Asignación de Tareas  

## 📌 Descripción  

Este proyecto es el trabajo práctico final de la materia **Programacion 3** en la **Universidad Nacional  del Centro (UNICEN)**.  
El objetivo es desarrollar algoritmos de búsqueda y optimización para la asignación eficiente de tareas a procesadores, aplicando técnicas de **Backtracking** y **Greedy**.  

El problema se basa en procesar información de archivos CSV que contienen listas de tareas y procesadores, y luego asignarlas de manera óptima bajo ciertas restricciones.  
El desafío principal es minimizar el tiempo de ejecución total, asegurando un reparto eficiente de las tareas y cumpliendo con las condiciones establecidas.  

## 🎯 Objetivos  

- Implementar búsquedas eficientes sobre un conjunto de tareas.  
- Asignar tareas a procesadores minimizando el tiempo máximo de ejecución.  
- Comparar soluciones obtenidas mediante **Backtracking** y **Greedy**.  
- Analizar la eficiencia de ambas técnicas mediante métricas cuantificables.  

## 🔍 Tecnologías y Conceptos Aplicados  

- **Lenguaje**: Java  
- **Estructuras de datos**: Listas, Colas, Pilas  
- **Algoritmos de búsqueda y optimización**:  
  - Backtracking  
  - Greedy  
- **Análisis de complejidad**  

## 📂 Estructura del Repositorio  

- `TPE/` → Código fuente del proyecto  
- `dataTPE/` → Archivos CSV de entrada  
- `Enunciado.pdf` → Detalle completo del enunciado del trabajo práctico  

## 📊 Comparación de Algoritmos  

Los resultados incluyen:  

| Técnica       | Tiempo Máximo de Ejecución | Costo Computacional |
|--------------|--------------------------|----------------------|
| **Backtracking** | [Valor] ms | [Cantidad de estados generados] |
| **Greedy**      | [Valor] ms | [Cantidad de candidatos considerados] |

## 🚀 Instalación y Ejecución  

1. Clonar el repositorio:  
   ```bash
   git clone https://github.com/Ayvero/Practico_Prog3.git

2.  Compilar el proyecto:
   javac -d bin src/*.java

4. Ejecutar el programa:

   java -cp bin Main

   📢 ### Notas
Este proyecto fue desarrollado como parte de la evaluación final de Programacion 3.

Se buscó aplicar buenas prácticas de programación y optimización de algoritmos.

Cualquier sugerencia o feedback es bienvenido.

-----------------------------------------------------



## Description
This is a final project for the "Algorithms and Data Structures" course. The task involves solving various problems related to processors and tasks. The first stage focuses on implementing simple services for task searches, while the second stage aims at solving task assignments to processors using different algorithmic techniques.

The project involves two stages:
1. **Simple services for task searching**.
2. **Task assignment to processors**, with the goal of minimizing execution time using two algorithmic techniques: Backtracking and Greedy.

The assignment involves processing two CSV files (`Procesadores.csv` and `Tareas.csv`), each containing data regarding processors and tasks. The processed data is then used to implement the required services and solve the task assignment problem.

### Objective
- In the first part, the objective is to implement the following services:
  - **Service 1**: Given a task ID, retrieve all information about the corresponding task.
  - **Service 2**: Allow the user to choose whether they want to view critical tasks or non-critical tasks, and generate the appropriate list.
  - **Service 3**: Retrieve all tasks between two specified priority levels.

- In the second part, the goal is to assign tasks to processors in a way that minimizes the final execution time, considering the following restrictions:
  - No processor can execute more than two critical tasks.
  - Non-refrigerated processors cannot dedicate more than a specified execution time (X) to assigned tasks.

### Techniques to be used:
- **Backtracking**: This technique will attempt all possible combinations of task assignments, ensuring that the constraints are met while trying to minimize the execution time.
- **Greedy**: A greedy approach will be used, which assigns tasks in a way that minimizes the execution time at each step without considering future consequences.

### Metrics:
- **Backtracking**:
  - **Solution**: Each processor with assigned tasks.
  - **Maximum execution time**.
  - **Metric**: Number of states generated.
  
- **Greedy**:
  - **Solution**: Each processor with assigned tasks.
  - **Maximum execution time**.
  - **Metric**: Number of candidates considered.

Additionally, a brief explanation of the strategy used for each technique is required, which should be included as a comment before the main function.

## Project Structure
- `Servicios.java`: Contains the implementation of the required services and logic for both parts of the project.
- `Tareas.csv` and `Procesadores.csv`: Sample data files that will be processed.
- `README.md`: This file contains the description of the project and objectives.

## Getting Started
To get started with the project, clone the repository to your local machine and compile the Java files using your preferred IDE or build tool.

```bash
git clone https://github.com/Ayvero/Practico_Prog3.git


---------------------------------------------------







