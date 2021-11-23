/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Osamu
 */
public class ImplementActionController implements Initializable {
    Player ply;
    @FXML
    private Button btnCancel;
    @FXML
    private Label lblBadLuck;
    @FXML
    private Label lblActionName;
    @FXML
    private Label lblFin;
    @FXML
    private Label lblActionDescr;
    @FXML
    private Label lblBenefit;
    @FXML
    private Button btnOK;
    @FXML
    private Label lblFin1;
    @FXML
    private Label lblFin11;
    @FXML
    private ImageView imgcaracter;
    @FXML
    private Label lblFinancial;
    @FXML
    private Label lblCredibility;
    @FXML
    private Label lblMotivation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ply= CurrentPlayer.ply;
       
      if(ply.getGender()==0){
           imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
      }else{
          imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
      }
      PlyActions pa = ActionHandling.actionList.get(Scene2Controller.actionNo);
      lblActionName.setText(pa.getActionName());
      lblBadLuck.setText(pa.getMessageBody());
      String txt;
      if(pa.getRevenueWks()==52){
          txt= pa.getWeeklyRevenue()+"$ until the end of the game";
      }else{
          txt=pa.getWeeklyRevenue()+"$ for "+pa.getRevenueWks()+" weeks";
      }
      lblFinancial.setText(txt);
      lblCredibility.setText(pa.getIncreaseCredibility()+" once.");
      lblMotivation.setText(pa.getIncreaseMotivation()+" once.");
        if(ply.getFinance()<= ActionHandling.actionList.get(Scene2Controller.actionNo).getCost()){
            btnOK.setDisable(true);
            btnOK.setText("Not Enought Money!");
            btnOK.setStyle("-fx-background-color: #f01818");
            
        }
       
   
    }    
  

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Parent root;
         Stage stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();  
        if(event.getSource()==btnCancel){
           Scene2Controller.actionApplied = false;
            stageTheLabelBelongs.close();  
        }
        if(event.getSource()==btnOK){         
            ActionHandling.applyAction(Scene2Controller.actionNo);     
            Scene2Controller.actionApplied = true;
            CurrentPlayer.updatePlayer(ply);
            stageTheLabelBelongs.close();
        }
        
        
    }
    
}
