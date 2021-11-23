/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author daniel.constantin
 */
public class EventMultiController implements Initializable {
    Player ply;
    @FXML
    private Button btn1;
    @FXML
    private Label lblBody;
    @FXML
    private Label lblHeader;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Pane pane;
   
   @FXML
 private void ClickMouse(MouseEvent event) {

            Stage stageTheLabelBelongs = (Stage) btn1.getScene().getWindow();  
        if(event.getSource()==btn1){   
          
            CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+ActionHandling.multiEventList.get(CurrentPlayer.event).getEventObj().getEvFinancial());
             CurrentPlayer.ply.setCredibility(CurrentPlayer.ply.getCredibility()+ActionHandling.multiEventList.get(CurrentPlayer.event).getEventObj().getEvCredibility());
              CurrentPlayer.ply.setPeople(CurrentPlayer.ply.getPeople()+ActionHandling.multiEventList.get(CurrentPlayer.event).getEventObj().getEvMotivation());
            
        }
        if(event.getSource()==btn2){
           
            MultiChoiceEvents mcev = new MultiChoiceEvents(ActionHandling.multiEventList.get(CurrentPlayer.event).getEventObj(), ActionHandling.multiEventList.get(CurrentPlayer.event).getOp1(),ActionHandling.multiEventList.get(CurrentPlayer.event).getOp2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getOp3(), ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns2(),ActionHandling.multiEventList.get(CurrentPlayer.event).message2, ActionHandling.multiEventList.get(CurrentPlayer.event).getModCredibility2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModMotivation2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModFinacial2(), ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getMessage3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModCredibility3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModMotivation3(), ActionHandling.multiEventList.get(CurrentPlayer.event).getModFinacial3(),2,ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns2());
            ActionHandling.multiEventImpl.add(mcev);
           
        }
        if(event.getSource()==btn3){
           
            MultiChoiceEvents mcev = new MultiChoiceEvents(ActionHandling.multiEventList.get(CurrentPlayer.event).getEventObj(), ActionHandling.multiEventList.get(CurrentPlayer.event).getOp1(),ActionHandling.multiEventList.get(CurrentPlayer.event).getOp2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getOp3(), ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns2(),ActionHandling.multiEventList.get(CurrentPlayer.event).message2, ActionHandling.multiEventList.get(CurrentPlayer.event).getModCredibility2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModMotivation2(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModFinacial2(), ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getMessage3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModCredibility3(),ActionHandling.multiEventList.get(CurrentPlayer.event).getModMotivation3(), ActionHandling.multiEventList.get(CurrentPlayer.event).getModFinacial3(),3,ActionHandling.multiEventList.get(CurrentPlayer.event).getTurns3());
            ActionHandling.multiEventImpl.add(mcev);
            
           
        }
      // ActionHandling.multiEventList.remove(event);
       stageTheLabelBelongs.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ply= CurrentPlayer.ply;
            
          int chooseEv = CurrentPlayer.event;
     
          
           
           lblHeader.setText(ActionHandling.multiEventList.get(chooseEv).getEventObj().getEvName());     
           lblBody.setText(ActionHandling.multiEventList.get(chooseEv).getEventObj().getEvMessage());
            btn1.setText((ActionHandling.multiEventList.get(chooseEv).getOp1()));
            btn1.setPrefWidth((btn1.getText().length() * 7)+30); 
            btn1.setLayoutX((pane.getPrefWidth()/2)-(btn1.getPrefWidth()/2));
            System.out.println(pane.getPrefWidth()+" // "+btn1.getPrefWidth());
            btn2.setText((ActionHandling.multiEventList.get(chooseEv).getOp2()));
             btn2.setPrefWidth((btn2.getText().length() * 7)+30); 
            btn2.setLayoutX((pane.getPrefWidth()/2)-(btn2.getPrefWidth()/2));
            btn3.setText((ActionHandling.multiEventList.get(chooseEv).getOp3()));
             btn3.setPrefWidth((btn3.getText().length() * 7)+30); 
            btn3.setLayoutX((pane.getPrefWidth()/2)-(btn3.getPrefWidth()/2));
             CurrentPlayer.updatePlayer(ply);
            
       
    
           
    }    

    
    
}
