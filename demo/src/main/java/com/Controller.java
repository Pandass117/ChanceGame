package com;

import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import java.util.Collections;


public class Controller {
    //25 buttons
    public Button btn;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button btn10;
    public Button btn11;
    public Button btn12;
    public Button btn13;
    public Button btn14;
    public Button btn15;
    public Button btn16;
    public Button btn17;
    public Button btn18;
    public Button btn19;
    public Button btn20;
    public Button btn21;
    public Button btn22;
    public Button btn23;
    public Button btn24;

    public ScrollBar vscrollPercentage;
    public Label lblOutcome;
    public Button btnPlay; //button to play again
    public Label lblSelectedPercentage;
    public Label lblCurrentPercentage;
    public Button btnChange; //button that changes percentage
    private ArrayList<Button> btnList = new ArrayList<Button>();
    private int numBtn; //button to store number of green buttons




/*
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
*/

    //Requires: btn, or btn1... or btn24 to be clicked on
    //Modifies: this
    //Effects: by the chance selected, the button selected will turn green, otherwise it turns red
    //if there is a red button, then you lose, if there are 3 green buttons, you win
    //also disables the button to change percentage and enables try again button
    public void btnPressed(ActionEvent actionEvent) {
        Button temp = (Button) actionEvent.getSource();
        String s = lblCurrentPercentage.getText();
        s = s.substring(0, s.length()-1);
        double percentage = Double.parseDouble(s);

        int randomNum = (int) (Math.random() * 100);

        temp.setDisable(true);
        if (randomNum < percentage){
            temp.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
            numBtn++;



            if (numBtn == 3){
                win();
            }
        }
        else{
            temp.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
            lose();
        }

        btnPlay.setDisable(false);
        btnChange.setDisable(true);

        
    }

    //Requires:
    //Modifies: this
    //Effects: shows: "you lose", disables buttons btn, btn1... btn24
    private void lose(){
        lblOutcome.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));
        lblOutcome.setText("you lose...");
        Collections.addAll(btnList, btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24);

        for (Button btn : btnList){
            btn.setDisable(true);

        }
        
    }

    //Requires:
    //Modifies: this
    //Effects: shows: "you win", disables buttons btn, btn1... btn24
    private void win(){
        lblOutcome.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));
        lblOutcome.setText("YOU WIN!!!!");
        Collections.addAll(btnList, btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24);

        for (Button btn : btnList){
            btn.setDisable(true);

        }

    }

    //Requires:
    //Modifies: this
    //Effects: adds buttons btn, btn1... btn24 to an ArrayList, resets and enables all buttons, sets vscroll increment, disables play again buttom
    //enables change percent button, resets most text
    public void initialize(){

        Collections.addAll(btnList, btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24);

        for (Button btn : btnList){
            btn.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
            btn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));
            btn.setDisable(false);

        }
        getScroll();
        vscrollPercentage.setUnitIncrement(1);
        numBtn = 0;
        btnPlay.setDisable(true);
        btnChange.setDisable(false);
        lblOutcome.setText("");
        lblOutcome.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));

    }


    //Requires:
    //Modifies: this
    //Effects: resets and enables all buttons, disables play again buttom
    //enables change percent button, resets most text
    public void playAgain(ActionEvent actionEvent) {
        for (Button btn : btnList){
            btn.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
            btn.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));
            btn.setDisable(false);

        }
        getScroll();

        numBtn = 0;
        btnPlay.setDisable(true);
        btnChange.setDisable(false);
        lblOutcome.setText("");
        lblOutcome.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, new CornerRadii(10), null )));

    }


    //Requires:
    //Modifies: this
    //Effects: sets lblSelectedPercentage to the value of the scroll bar
    private void getScroll(){
        double scrollVal;

        scrollVal = vscrollPercentage.getValue();
        scrollVal = Math.round(scrollVal);
        lblSelectedPercentage.setText(Double.toString(scrollVal)+"%");
    }





    public void released(MouseEvent mouseEvent) {
        getScroll();
    }

    public void dragRelease(MouseDragEvent mouseDragEvent) {
        getScroll();

    }

    public void msClick(MouseEvent mouseEvent) {
        getScroll();
    }

    //Requires:
    //Modifies: this
    //Effects: set the current percentage of a button turning green to the selected percentage
    public void btnChangePercent(ActionEvent actionEvent) {
        String selected;
        selected = lblSelectedPercentage.getText();
        lblCurrentPercentage.setText(selected);
    }


}