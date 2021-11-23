/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;



import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 *
 * @author Osamu
 */
public class EventController implements Initializable {

    Player ply;
  
    @FXML
    private Button btnOK;

    //@FXML
    //private Label lblDear;

    @FXML
    private Label lblBody;

    //@FXML
    //private ImageView imgcaracter;

 //  @FXML
 //   private Label lblEventName;

    @FXML
    private Label lblHeader;

    @FXML
    private ImageView img;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        
           Parent root;
            CurrentPlayer.updatePlayer(ply);
            Stage stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
      
            stageTheLabelBelongs.close();  
            
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply= CurrentPlayer.ply;
        if(CurrentPlayer.mevTrigg==false){
          int chooseEv = CurrentPlayer.event;
           if(ply.getTurns()>1 && (ActionHandling.MAX_EVENT)>=chooseEv){          
           lblHeader.setText(ActionHandling.eventList.get(chooseEv).getEvName());     
           lblBody.setText(ActionHandling.eventList.get(chooseEv).getEvMessage());
           }
        }else  {
            //  lblHeader.setStyle("-fx-border-color: #FFD700 "+"-fx-border-width:10 "+"-fx-border-radius: 20 20 20 20");
             if(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getYourchoice()==2){
                lblHeader.setText(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getEventObj().getEvName());
                lblBody.setText(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getMessage2()); 
                CurrentPlayer.ply.setCredibility(CurrentPlayer.ply.getCredibility()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModCredibility2());
                CurrentPlayer.ply.setPeople(CurrentPlayer.ply.getPeople()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModMotivation2());
                CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModFinacial2());
                //CurrentPlayer.multiEvent=-1;
                
                 
                

                             }
             if(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getYourchoice()==3){
                lblHeader.setText(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getEventObj().getEvName());
                lblBody.setText(ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getMessage3());
                CurrentPlayer.ply.setCredibility(CurrentPlayer.ply.getCredibility()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModCredibility3());
                CurrentPlayer.ply.setPeople(CurrentPlayer.ply.getPeople()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModMotivation3());
                CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+ActionHandling.multiEventImpl.get(CurrentPlayer.multiEvent).getModFinacial3());
               // CurrentPlayer.multiEvent=-1;
             }
           }
          
            
                 CurrentPlayer.updatePlayer(ply);
            
       
    
           
    }

}
