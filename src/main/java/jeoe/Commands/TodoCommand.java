package jeoe.Commands;

import jeoe.Others.StorageManager;
import jeoe.Others.Ui;
import jeoe.Tasks.TaskManager;
import jeoe.Tasks.Todo;

/**
 * This class encapsulates the class TodoCommand.
 * It is meant to execute the creation of a Todo object.
 *
 * @author Joe Chua
 * @version Week-6
 */
public class TodoCommand extends Command {

    /** Contains the description of the to do command. */
    private String todoDescription;

    /**
     * Constructor for a TodoCommand object.
     * @param input The string input by the user to parse into a command.
     */
    TodoCommand(String input) {
        super(false);
        this.todoDescription = input.replaceFirst("todo ", "");
        if (input.length() < 5) {
            this.todoDescription = input.replaceFirst("todo", "");
        }
    }

    /**
     * Executes the Todo command.
     * Creates a todo object, adds it to the task list, saves it in local storage then displays it.
     *
     * @param taskManager Task manager handling tasks operations.
     * @param ui Ui handling output to users.
     * @param storageManager Storage manager handling storing & deletion of tasks.
     */
    @Override
    public void execute(TaskManager taskManager, Ui ui, StorageManager storageManager) {
        // create the actual task
        Todo todo = new Todo(todoDescription);

        // add to the storage in Task & save into HDD
        taskManager.addTask(todo);
        storageManager.save(taskManager.getTasks());

        // add to the reply
        ui.displayReply(todo.replyString(taskManager.getTasksSize()));
    }

    /**
     * Executes the Todo command.
     * Creates a todo object, adds it to the task list, saves it in local storage then returns the todo string.
     *
     * @param taskManager Task manager handling tasks operations.
     * @param ui Ui handling output to users.
     * @param storageManager Storage manager handling storing & deletion of tasks.
     */
    public String executeAndReply(TaskManager taskManager, Ui ui, StorageManager storageManager) {
        // create the actual task
        Todo todo = new Todo(todoDescription);

        // add to the storage in Task & save into HDD
        taskManager.addTask(todo);
        storageManager.save(taskManager.getTasks());

        // add to the reply
        return ui.getReply(todo.replyString(taskManager.getTasksSize()));
    }
}
