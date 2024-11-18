package edu.gmu.cs321;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorkflowTest {
    @Test
    void createWorkflow() {
        WorkflowStaging ws = new WorkflowStaging();
        assertNotNull(ws);
    }

    @Test
    void addWFApprovalItem() {
        WorkflowStaging ws = new WorkflowStaging();
        assertEquals(0, ws.addApproval(1));
    }

    @Test
    void addDuplicateWFApprovalItem() {
        WorkflowStaging ws = new WorkflowStaging();
        ws.addApproval(1);
        assertEquals(-2, ws.addApproval(1));
    }

    @Test
    void addWFReviewerItem() {
        WorkflowStaging ws = new WorkflowStaging();
        assertEquals(0, ws.addReviewer(1));
    }

    @Test
    void addDuplicateWFReviewerItem() {
        WorkflowStaging ws = new WorkflowStaging();
        ws.addReviewer(1);
        assertEquals(-2, ws.addReviewer(1));
    }

    @Test
    void getNextWKReviewerItem() {
        WorkflowStaging ws = new WorkflowStaging();
        ws.addReviewer(1);
        assertEquals(1, ws.getNextReviewerWFItem());
    }

    @Test
    void getNextWFApproverItem() {
        WorkflowStaging ws = new WorkflowStaging();
        ws.addApproval(1);
        assertEquals(1, ws.getNextApprovalWFItem());
    }

    @Test
    void getNextEmptyWFReviewerItem() {
        WorkflowStaging ws = new WorkflowStaging();
        assertEquals(-3, ws.getNextReviewerWFItem());
    }

    @Test
    void getNextEmptyWFApproverItem() {
        WorkflowStaging ws = new WorkflowStaging();
        assertEquals(-3, ws.getNextApprovalWFItem());
    }
}
