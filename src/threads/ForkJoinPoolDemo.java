package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolDemo extends RecursiveAction {

    private long workLoad = 0;

    public ForkJoinPoolDemo(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<ForkJoinPoolDemo> subtasks =
                    new ArrayList<ForkJoinPoolDemo>();

            subtasks.addAll(createSubtasks());

            for(RecursiveAction subtask : subtasks){
                subtask.fork();
            }

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

    private List<ForkJoinPoolDemo> createSubtasks() {
        List<ForkJoinPoolDemo> subtasks =
                new ArrayList<ForkJoinPoolDemo>();

        ForkJoinPoolDemo subtask1 = new ForkJoinPoolDemo(this.workLoad / 2);
        ForkJoinPoolDemo subtask2 = new ForkJoinPoolDemo(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }

}
