/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.openfx;

import edu.gmu.cs321.ImmForm;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ApprovalScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView table = new TableView();
        
        primaryStage.setTitle("Approval Template");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Approval");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Display Immigrant Info.
        final TextField immInfo = new TextField();
        immInfo.setEditable(false);
        immInfo.setPromptText("Immigrant Info goes here.");
        GridPane.setConstraints(immInfo, 0, 1);
        grid.getChildren().add(immInfo);

        //Display Errors
        final TextField errors = new TextField();
        errors.setEditable(false);
        errors.setPromptText("Errors go here.");
        GridPane.setConstraints(errors, 1, 1);
        grid.getChildren().add(errors);

        //very bottom
        final Separator bSep = new Separator();
        GridPane.setConstraints(bSep, 0, 2);
        GridPane.setColumnSpan(bSep, 8);
        grid.getChildren().add(bSep);


        //denial button code
        Button denial = new Button("Deny Email");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn1.getChildren().add(denial);
        grid.add(hbBtn1, 0, 5);

        //approval button code
        Button accept = new Button("Accept Email");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(accept);
        grid.add(hbBtn2, 5, 5);

        //event listeners for buttons
        //for denial
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        grid.setColumnSpan(actiontarget, 2);
        grid.setHalignment(actiontarget, HPos.RIGHT);
        actiontarget.setId("actiontarget");
        //for approval
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 0, 6);
        grid.setColumnSpan(actiontarget2, 2);
        grid.setHalignment(actiontarget2, HPos.RIGHT);
        actiontarget2.setId("actiontarget2");

        denial.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget2.setText(null);
                actiontarget.setFill(Color.FIREBRICK);
                rejectForm();
                actiontarget.setText("Form was Denied, Sent to Reviewer");
            }
        });

        accept.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setText(null);
                actiontarget2.setFill(Color.CORNFLOWERBLUE);
                approveForm();
                actiontarget2.setText("Form was Accepted, Email Pending");
            }
        });
        
        Scene scene = new Scene(grid, 1000, 1000);
        
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }
    
    /**
     * Display fields for approval.
     */
    public void displayFields(ImmForm CurFrom)
    {
      // TODO document why this method is empty
    }

    /**
     * rejects form for Approval
     */
    public String rejectForm()
    {
        return "";
    }

    /**
     * approves form for Approval
     */
    public Boolean approveForm()
    {
        return false;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
