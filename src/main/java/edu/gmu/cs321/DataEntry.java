package edu.gmu.cs321;

public class DataEntry {
    public void addItemToWorkflow(ImmForm immForm) {
        WorkflowStaging ws = new WorkflowStaging();
        ws.createNewWFItem(immForm);
    }
}
