package TPE;

import java.util.ArrayList;
import java.util.List;

class TaskBinaryTree {
    private Node root;

    public TaskBinaryTree() {
        this.root = null;
    }

    public void insert(MyTask task) {
        root = insertRec(root, task);
    }

    private Node insertRec(Node root, MyTask task) {
        if (root == null) {
            root = new Node(task.getNivelPrioridad());
            root.addTask(task);
            return root;
        }

        if (task.getNivelPrioridad() < root.priority) {
            root.left = insertRec(root.left, task);
        } else if (task.getNivelPrioridad() > root.priority) {
            root.right = insertRec(root.right, task);
        } else {
            root.addTask(task);  // Si la prioridad es igual, añadir la tarea a la lista de tareas del nodo.
        }

        return root;
    }

    public List<MyTask> getTasksInPriorityRange(int low, int high) {
        List<MyTask> result = new ArrayList<>();
        getTasksInPriorityRangeRec(root, low, high, result);
        return result;
    }

    private void getTasksInPriorityRangeRec(Node root, int low, int high, List<MyTask> result) {
        if (root == null) {
            return;
        }

        if (low < root.priority) {
            getTasksInPriorityRangeRec(root.left, low, high, result);
        }

        if (low <= root.priority && high >= root.priority) {
            result.addAll(root.tasks);
        }

        if (high > root.priority) {
            getTasksInPriorityRangeRec(root.right, low, high, result);
        }
    }
}
