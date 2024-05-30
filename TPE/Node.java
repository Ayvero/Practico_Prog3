package TPE;

import java.util.ArrayList;
import java.util.List;

class Node {
    int priority;
    List<MyTask> tasks;
    Node left, right;

    public Node(int priority) {
        this.priority = priority;
        this.tasks = new ArrayList<>();
        this.left = this.right = null;
    }

    public void addTask(MyTask task) {
        tasks.add(task);
    }
}

