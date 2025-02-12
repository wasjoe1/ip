package jeoe.Commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jeoe.Others.StorageManager;
import jeoe.Others.Ui;
import jeoe.Tasks.TaskManager;

public class DeadlineCommandTest {
    protected StorageManager sm;
    protected TaskManager tm;
    protected Ui ui = new Ui();

    @Test
    public void testAddDeadline() {
        try {
            String filePath = System.getProperty("user.dir") + "/storage/testTaskListData.txt";
            sm = new StorageManager(filePath);
            sm.deleteAllInFile();
            tm = new TaskManager(sm.load(), filePath);
            DeadlineCommand deadline = new DeadlineCommand("deadline test /by 2022-12-01 18:00");
            deadline.executeAndReply(tm, ui, sm);
            assertEquals("1. [D][ ] test (by: Dec 1 2022 18:00)\n", tm.toString());
        } catch (Exception e) {
            System.out.println("Exception in add deadline test, test failed");
        }
    }
}
