/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

//import DbConn.DatabaseUtil;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication1.ActionHandling.multiEventImpl;
/**
 *
 * @author Osamu
 */
public class Scene2Controller implements Initializable {
    private static Player ply;
    StringProperty dialogH;
    static int actionNo;
    static boolean actionApplied;
    Alert dialogAlert;
    Alert alertReject;
    Alert alertEvent;
    Stage stageTheLabelBelongs;
    
    
    @FXML
    private ProgressBar pbCredibility;
    private  DoubleProperty CredibilityUpdater = new SimpleDoubleProperty(.5);
    private IntegerProperty credibilityUpdater = new SimpleIntegerProperty(50);
    @FXML
    private ProgressBar pbMotivation;
     private DoubleProperty MotivationUpdater = new SimpleDoubleProperty(.5);
     private IntegerProperty motivationUpdater = new SimpleIntegerProperty(50);
    @FXML
    private Label lblFounds;
    private final IntegerProperty foundsUpdater=new SimpleIntegerProperty();
    @FXML
    private Label lblnam11;
   // Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ProgressBar pbFinance;
    private final DoubleProperty FinancebarUpdater=new SimpleDoubleProperty();
    //
    
    @FXML
    private Label lblYH;

    @FXML
    private Label lblWeek;

    @FXML
    private Label lblCredibility;

    @FXML
    private Label lblFinance;

    @FXML
    private Button btnNextWeek;

    @FXML
    private Label lblnam;

    @FXML
    private BarChart chartFinancial;

    @FXML
    private Label lblMotivation;

    @FXML
    private Label lblCredibility1;

    @FXML
    private Accordion accMenu;
    

    @FXML
    private TitledPane acctpRD;

    @FXML
    private Label lblNewP;

    @FXML
    private Label lblImproveP;

    @FXML
    private Label lblCostR;

    @FXML
    private TitledPane acctpMarketing;

    @FXML
    private Label lblTVSpot;

    @FXML
    private Label lblMInsert;

    @FXML
    private Label lblOnline;

    @FXML
    private Label lblChangeD;

    @FXML   
    private TitledPane acctpEmployees;

    @FXML
    private Label lblTeamB;
            
    @FXML
    private ScrollPane scrollMessage;

    @FXML
    private Label lblSoftware;

    @FXML
    private Label lblBonus;

    @FXML
    private Label lblTrainning;


    @FXML
    private DialogPane dialogAccept;

    @FXML
    private DialogPane dialogReject;
    
     @FXML
    private DialogPane dialogEvent; 
    
    @FXML
    private TextFlow tflowMessages;
    
    @FXML
    private ImageView btnClose;
    
    @FXML
    private Label lblTop;
    @FXML
    private Pane paneTop;
    @FXML
    private MenuButton menuOptions;
    @FXML
    private MenuItem btnSave;
    @FXML
    private MenuItem btnMute;
    
    @FXML
    private ImageView imgSave;
    @FXML
    private ImageView imgMute;
    
    private static double xOffset = 0;
    private static double yOffset = 0;
    
 //   @FXML
  //  private Button btnSave;
    
 //   @FXML
//    private Label lblnam1;
@FXML
    private ImageView icoDev0;

    @FXML
    private ImageView icoDev1;

    @FXML
    private ImageView icoDev2;

    @FXML
    private ImageView icoMk3;

    @FXML
    private ImageView icoMk4;

    @FXML
    private ImageView icoMk5;

    @FXML
    private ImageView icoMk6;

    @FXML
    private ImageView icoHr7;

    @FXML
    private ImageView icoHr10;

    @FXML
    private ImageView icoHr8;

    @FXML
    private ImageView icoHr9;

    @FXML
    private Label lbl0;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl10;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl9;
     @FXML
    private Label lbl01;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl21;

    @FXML
    private Label lbl31;

    @FXML
    private Label lbl41;

    @FXML
    private Label lbl51;

    @FXML
    private Label lbl61;

    @FXML
    private Label lbl71;

    @FXML
    private Label lbl101;

    @FXML
    private Label lbl81;

    @FXML
    private Label lbl91;
    @FXML
    private ImageView imgDev;
   @FXML
    private ImageView imgHr;
   @FXML
    private ImageView imgMk;
    
    @FXML
    private void OnMouseClicked(MouseEvent e) {
         
        CurrentPlayer.updatePlayer(ply);
        if (e.getSource() == btnNextWeek) {
                  
            if (ply.getTurns() >= 51 || ply.getFinance()<=0 || 0 >=ply.getCredibility() || 0>=ply.getPeople()) {
                if (ply.getFinance() < 100000) {
                    endOfLevel("GameOver.fxml");
                } else {
                    endOfLevel("LevelComplete.fxml");
                }
            }
            CurrentPlayer.updatePlayer(ply);
            ActionHandling.addWeek();
            ply = CurrentPlayer.ply;
            alertEvent.close();
            addMessage(colorToHex(Color.RED), "Week "+ ply.getTurns());
           
           // ply = CurrentPlayer.ply;
            lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
            lblFounds.textProperty().bind(foundsUpdater.asString());
            
            CurrentPlayer.SeriesF.getData().add(new XYChart.Data<>(Integer.toString(ply.getTurns()),Integer.valueOf(ply.getFinance())));
            ply.getFinev()[ply.getTurns()]=ply.getFinance();
            updateVisuals();
           CurrentPlayer.updatePlayer(ply);
           updateVisuals();
           
           if(ply.getTurns()<52){
          if(checkMultiChoiceEv()==false){
          implementEvent();
          }
        }
           
        }
        if(e.getSource()==lblNewP){
        actionNo =0;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblNewP);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKVIOLET), "Action Under Implementation: New Product Development.");
        }
        }
        if(e.getSource()==lblImproveP){
        actionNo =1;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblImproveP);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKVIOLET), "Action Under Implementation: Improve Product.");
        }
        }
        if(e.getSource()==lblCostR){
            actionNo =2;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblCostR);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKVIOLET), "Action Under Implementation: Cost Reduction.");
        }
        }
        if(e.getSource()==lblTeamB){
            actionNo =3;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblTeamB);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKGOLDENROD), "Action Under Implementation: Team Building.");
        }
        }
        if(e.getSource()==lblSoftware){
            actionNo =10;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblSoftware);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKGOLDENROD), "Action Under Implementation: Software Implementation.");
        }
        }
        if(e.getSource()==lblBonus){
            actionNo =4;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblBonus);
       if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKGOLDENROD), "Action Under Implementation: Bonus.");
        }
        }
        if(e.getSource()==lblTrainning){
               actionNo =5;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblTrainning);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKGOLDENROD), "Action Under Implementation: Trainning.");
        }
        }
        if(e.getSource()==lblTVSpot){
               actionNo =6;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblTVSpot);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKOLIVEGREEN), "Action Under Implementation: TV Spot.");
        }
        }
        if(e.getSource()==lblMInsert){
              actionNo =7;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblMInsert);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKOLIVEGREEN), "Action Under Implementation: Magazine Insert.");
        }
        }
        if(e.getSource()==lblChangeD){
               actionNo =8;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblChangeD);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKOLIVEGREEN), "Action Under Implementation: Change Design.");
        }
        }
        if(e.getSource()==lblOnline){
               actionNo =9;
        CurrentPlayer.updatePlayer(ply);
        int oldV=ActionHandling.actioncontor;
        showActionScene("ImplementAction.fxml", lblOnline);
        if(oldV<ActionHandling.actioncontor){
            addMessage(colorToHex(Color.DARKOLIVEGREEN), "Action Under Implementation: Online Promo.");
        }
        }
        if (e.getSource()==btnClose){
            Platform.exit();
            System.exit(0);
        }
        ply = CurrentPlayer.ply;
        updateVisuals();
     /*   
        if(e.getSource()==btnSave){
            try {
                System.out.println("Se incearca salvarea");
                Save();
            } catch (IOException ex) {
                  System.out.println("N-a trecut de try");
                Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==btnMute){
            MusicManip.mp.stop();
        }
*/
    } 
    @FXML
    private void MenuAction(ActionEvent ae){
        if(ae.getSource()==btnSave || ae.getSource()==imgSave){
            try {
           
                Save();
            } catch (IOException ex) {
                 
                Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(ae.getSource()==btnMute || ae.getSource()==imgMute){
            if(btnMute.getText().equalsIgnoreCase("Mute")){
            MusicManip.mp.stop();
            btnMute.setText("Unmute");
            imgMute.setImage(new Image("javafxapplication1/resources/icons8-speaker-64.png"));
            } else{
                MusicManip.mp.play();
                btnMute.setText("Mute");
                imgMute.setImage(new Image("javafxapplication1/resources/icons8-no-audio-64.png"));
            }
        }
    }
     @FXML
    private void Pressed(MouseEvent e){
        stageTheLabelBelongs = (Stage) btnNextWeek.getScene().getWindow();
          xOffset = e.getSceneX();
          yOffset = e.getSceneY();

    }
     @FXML
    private void Dragged(MouseEvent e){
          stageTheLabelBelongs.setX(e.getScreenX() - xOffset);
          stageTheLabelBelongs.setY(e.getScreenY() - yOffset);
    }
   
    private void implementAction(int actionno, Label lbl ){
   
       ply=CurrentPlayer.ply;
    }
    @FXML
    private void endOfLevel(String showScene){
    Parent root;
    CurrentPlayer.updatePlayer(ply);
     
    Stage stageTheLabelBelongs = (Stage) btnNextWeek.getScene().getWindow(); 
   
//    stageTheLabelBelongs.setTitle("Business Simulator");
    try {   
 
                root = FXMLLoader.load(getClass().getResource(showScene));
                Scene scene=new Scene(root);
                scene.setFill(Color.TRANSPARENT);
                stageTheLabelBelongs.setScene(scene);
            } catch (IOException ex) {
                Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }     
}
    private void addMessage(String cl, String tx){
                Text txt= new Text();
                txt.setText( tx+"\n");
                txt.setFont(Font.font("Chalkboard SE", FontWeight.BOLD, 10));
              
                txt.setFill(Color.web(cl));             
                tflowMessages.getChildren().add(txt);
                ply.addMesg(cl+"|"+ tx);
    }
    private void implementEvent(){
        
      if (ply.getTurns() < 51 || ply.getFinance()>0 || 0 <ply.getCredibility() || 0<ply.getPeople()) {
        int chooseEv =(int)(Math.random()*ActionHandling.MAX_EVENT)+(ActionHandling.MAX_EVENT/4);
     
           if(ply.getTurns()>1 && (ActionHandling.MAX_EVENT)>=chooseEv){
             CurrentPlayer.event = chooseEv;
             showActionScene("EventShow.fxml",null);
          
                 ply.setFinance(ActionHandling.eventList.get(chooseEv).getEvFinancial()+ply.getFinance());
                 ply.setCredibility(ActionHandling.eventList.get(chooseEv).getEvCredibility()+ply.getCredibility());
                 ply.setPeople(ActionHandling.eventList.get(chooseEv).getEvMotivation()+ply.getPeople());
                 CurrentPlayer.updatePlayer(ply);
                 updateVisuals();
               //  alertEvent.close();
                 addMessage(colorToHex(Color.BLUE), ActionHandling.eventList.get(chooseEv).getEvMessage());
                 
            }
           if((ActionHandling.MAX_EVENT)<chooseEv && ply.getTurns()<52 && ActionHandling.multiEventList.size()>0){
               int chooseMEv =(int)(Math.random()*ActionHandling.MAX_MULTIev);
               CurrentPlayer.event = chooseMEv;
               int size = ActionHandling.multiEventImpl.size();
               
               showActionScene("EventMulti.fxml",null); 
               addMessage(colorToHex(Color.DARKMAGENTA), ActionHandling.multiEventList.get(chooseMEv).getEventObj().getEvMessage());
               
               if (size==ActionHandling.multiEventImpl.size()){
                   addMessage(colorToHex(Color.DARKMAGENTA), ActionHandling.multiEventList.get(chooseMEv).getOp1());
               }else{
               switch(ActionHandling.multiEventImpl.get(ActionHandling.multiEventImpl.size()-1).getYourchoice()){
               case 2:addMessage(colorToHex(Color.DARKMAGENTA), ActionHandling.multiEventImpl.get(ActionHandling.multiEventImpl.size()-1).getOp2());break;
               case 3: addMessage(colorToHex(Color.DARKMAGENTA), ActionHandling.multiEventImpl.get(ActionHandling.multiEventImpl.size()-1).getOp3());break;
               default:addMessage(colorToHex(Color.DARKMAGENTA), ActionHandling.multiEventList.get(chooseMEv).getOp1());

               }
               ActionHandling.multiEventList.remove(chooseMEv);
               }
               
               
           }
       
      }
            updateVisuals();
           
    }
    private void updateVisuals(){
        lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
        CredibilityUpdater.set(((double)ply.getCredibility()/100));
     //  pbCredibility.progressProperty().add(CredibilityUpdater);
         MotivationUpdater.set((double)ply.getPeople()/100); 
        lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
        lblFinance.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
        lblCredibility.textProperty().bind(new SimpleIntegerProperty(ply.getCredibility()).asString());
       lblMotivation.textProperty().bind(new SimpleIntegerProperty(ply.getPeople()).asString());
                if (ply.getTurns() >= 51 || ply.getFinance()<=0 || 0 >=ply.getCredibility() || 0>=ply.getPeople()) {
                if (ply.getFinance() < 100000) {
                    endOfLevel("GameOver.fxml");
                } else {
                    endOfLevel("LevelComplete.fxml");
                }
            }
       for(int m=0; m<ActionHandling.lblenable.length;m++){
           
               switch(m){
                   case 0: if(ActionHandling.lblenable[m]==-1) {lblNewP.setDisable(false);icoDev0.setOpacity(.3);lbl0.setVisible(false);}else {lblNewP.setDisable(true);icoDev0.setOpacity(1);lbl0.setVisible(true);lbl0.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl01.setVisible(false);}else  {lbl01.setVisible(true);lbl01.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 1: if(ActionHandling.lblenable[m]==-1) {lblImproveP.setDisable(false);icoDev1.setOpacity(.3);lbl1.setVisible(false);}else {lblImproveP.setDisable(true);icoDev1.setOpacity(1);lbl1.setVisible(true);lbl1.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl11.setVisible(false);}else {lbl11.setVisible(true);lbl11.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 2: if(ActionHandling.lblenable[m]==-1) {lblCostR.setDisable(false);icoDev2.setOpacity(.3);lbl2.setVisible(false);}else {lblCostR.setDisable(true);icoDev2.setOpacity(1);lbl2.setVisible(true);lbl2.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl21.setVisible(false);}else  {lbl21.setVisible(true);lbl21.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 3: if(ActionHandling.lblenable[m]==-1) {lblTeamB.setDisable(false);icoHr7.setOpacity(.3);lbl7.setVisible(false);}else {lblTeamB.setDisable(true);icoHr7.setOpacity(1);lbl7.setVisible(true);lbl7.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl71.setVisible(false);}else {lbl71.setVisible(true);lbl71.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 4: if(ActionHandling.lblenable[m]==-1) {lblBonus.setDisable(false);icoHr8.setOpacity(.3);lbl8.setVisible(false);}else {lblBonus.setDisable(true);icoHr8.setOpacity(1);lbl8.setVisible(true);lbl8.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl81.setVisible(false);}else {lbl81.setVisible(true);lbl81.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 5: if(ActionHandling.lblenable[m]==-1) {lblTrainning.setDisable(false);icoHr9.setOpacity(.3);lbl9.setVisible(false);}else {lblTrainning.setDisable(true);icoHr9.setOpacity(1);lbl9.setVisible(true);lbl9.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl91.setVisible(false);}else  {lbl91.setVisible(true);lbl91.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 6: if(ActionHandling.lblenable[m]==-1) {lblTVSpot.setDisable(false);icoMk3.setOpacity(.3);lbl3.setVisible(false);}else {lblTVSpot.setDisable(true);icoMk3.setOpacity(1);lbl3.setVisible(true);lbl3.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl31.setVisible(false);}else  {lbl31.setVisible(true);lbl31.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 7: if(ActionHandling.lblenable[m]==-1) {lblMInsert.setDisable(false);icoMk4.setOpacity(.3);lbl4.setVisible(false);}else {lblMInsert.setDisable(true);icoMk4.setOpacity(1);lbl4.setVisible(true);lbl4.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl41.setVisible(false);}else  {lbl41.setVisible(true);lbl41.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;} 
                   case 8: if(ActionHandling.lblenable[m]==-1) {lblChangeD.setDisable(false);icoMk5.setOpacity(.3);lbl5.setVisible(false);}else {lblChangeD.setDisable(true);icoMk5.setOpacity(1);lbl5.setVisible(true);lbl5.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl51.setVisible(false);}else  {lbl51.setVisible(true);lbl51.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;}
                   case 9: if(ActionHandling.lblenable[m]==-1) {lblOnline.setDisable(false);icoMk6.setOpacity(.3);lbl6.setVisible(false);}else {lblOnline.setDisable(true);icoMk6.setOpacity(1);lbl6.setVisible(true);lbl6.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl61.setVisible(false);}else {lbl61.setVisible(true);lbl61.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;} 
                   case 10:if(ActionHandling.lblenable[m]==-1) {lblSoftware.setDisable(false);icoHr10.setOpacity(.3);lbl10.setVisible(false);}else {lblSoftware.setDisable(true);icoHr10.setOpacity(1);lbl10.setVisible(true);lbl10.setText(Integer.toString(ActionHandling.lblenable[m]));}
                           if(ActionHandling.lblrevenue[m]==-1) {lbl101.setVisible(false);}else  {lbl101.setVisible(true);lbl101.setText(Integer.toString(ActionHandling.lblrevenue[m]));continue;} 
                   default: 
 
               }
           }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply = CurrentPlayer.ply;
        dialogAlert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.APPLY, ButtonType.CANCEL);
        alertReject = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CANCEL);
        alertEvent = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.CLOSE);
     //   lblFounds.getParent().setStyle("-fx-background-color: linear-gradient(from 25% 25% to 60% 60%,  #86e0b3, #ecffd8 )");
        FinancebarUpdater.set((double)ply.getFinance()/100000); 
        pbFinance.progressProperty().bind(FinancebarUpdater);
        actionApplied=false;
        if(ply.getTurns()>0){
            restoreFinMsg();
            updateVisuals();
        }else{
            updateVisuals();
            addMessage(colorToHex(Color.RED), "Week "+ ply.getTurns());
        }
        CredibilityUpdater.set(((double)ply.getCredibility()/100));
       pbCredibility.progressProperty().bind(CredibilityUpdater);
        
        
        
        MotivationUpdater.set((double)ply.getPeople()/100);
        pbMotivation.progressProperty().bind(MotivationUpdater);    
        
        lblnam.setText(ply.getName());
 
        foundsUpdater.set(ply.getFinance());

       lblFounds.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
       lblFinance.textProperty().bind(new SimpleIntegerProperty(ply.getFinance()).asString());
       lblCredibility.textProperty().bind(new SimpleIntegerProperty(ply.getCredibility()).asString());
       lblMotivation.textProperty().bind(new SimpleIntegerProperty(ply.getPeople()).asString());
       updateVisuals();
        //dialogAlert.titleProperty().bind(dialogH);
        lblWeek.textProperty().bind(new SimpleIntegerProperty(52-(ply.getTurns())).asString());
        
     //   DatabaseUtil dbu = new DatabaseUtil();
    //    dbu.derbyDBConnection("jdbc:derby:src/javafxapplication1/resources/DBBSim");
        chartFinancial.setData(CurrentPlayer.istoricF);
        //chartFinancial.categoryGapProperty().set(.5);
        
        
        DialogPane dialogReject = alertReject.getDialogPane();
        dialogReject.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogReject.autosize();
        dialogAccept = dialogAlert.getDialogPane();
        dialogAccept.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogAccept.autosize();
        dialogAccept.setPrefSize(300, 250);
        dialogEvent = alertEvent.getDialogPane();
        dialogEvent.getStylesheets().add(getClass().getResource("resources/Alert.css").toExternalForm());
        dialogEvent.autosize();
        dialogEvent.setPrefSize(300, 250);
       // addMessage(colorToHex(Color.RED), "Week "+ ply.getTurns());
        scrollMessage.vvalueProperty().bind(tflowMessages.heightProperty());
        scrollMessage.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollMessage.setFitToWidth(true);
        updateVisuals();
}  

    public void showActionScene(String ascene, Label lbl){
        CurrentPlayer.updatePlayer(ply);
        stageTheLabelBelongs = (Stage) btnNextWeek.getScene().getWindow();
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource(ascene));
            Stage stage2 = new Stage();
            Scene scene = new Scene(root2);
            stage2.setScene(scene);
            stage2.setTitle("Business Simulator");
            stage2.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setResizable(false);
           
            stage2.showAndWait();
            
          //  stageTheLabelBelongs.show();
            ply=CurrentPlayer.ply;
            if(lbl!=null){
             if (actionApplied==false){
            lbl.setDisable(false);
            actionApplied=false;
             }else{
            lbl.setDisable(true);
            actionApplied=false;
             }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Scene2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        ply=CurrentPlayer.ply;
        
    }
 private void Save() throws FileNotFoundException, IOException{
 // ply.setMessg(tflowMessages.getChildren());
  ply.setLblenable(ActionHandling.lblenable);
  ply.setLblrevenue(ActionHandling.lblrevenue);
  ply.setPlyImplAList(CurrentPlayer.PlyImplAList);
  ply.setPlyactionList(CurrentPlayer.PlyactionList);
  ply.setMultiEventList(ActionHandling.multiEventList);
  ply.setMultiEventImpl(ActionHandling.multiEventImpl);
  
 String path = System.getProperty("user.home")+File.separator+"Documents";
 path += File.separator + "BizzLife Saves";
File customDir = new File(path);

if (customDir.exists()) {

} else if (customDir.mkdirs()) {

} else {

} 
 File salvare = new File(path +File.separator+ply.getName()+"-"+ply.getPersoana()+".bizz");
 
 FileOutputStream gos = new FileOutputStream(salvare);
ObjectOutputStream ros = new ObjectOutputStream(gos);
                ros.writeObject(ply);
                ros.close();
                gos.close();
 
 }
 private String colorToHex(Color color) {
    String hex1;
    String hex2;

    hex1 = Integer.toHexString(color.hashCode()).toUpperCase();

    switch (hex1.length()) {
    case 2:
        hex2 = "000000";
        break;
    case 3:
        hex2 = String.format("00000%s", hex1.substring(0,1));
        break;
    case 4:
        hex2 = String.format("0000%s", hex1.substring(0,2));
        break;
    case 5:
        hex2 = String.format("000%s", hex1.substring(0,3));
        break;
    case 6:
        hex2 = String.format("00%s", hex1.substring(0,4));
        break;
    case 7:
        hex2 = String.format("0%s", hex1.substring(0,5));
        break;
    default:
        hex2 = hex1.substring(0, 6);
    }
    return hex2;
}
  private void restoreFinMsg(){
      for(int i=1; i<ply.getFinev().length;i++){
        CurrentPlayer.SeriesF.getData().add(new XYChart.Data<>(Integer.toString(i),ply.getFinev()[i]));
      }
      List <String> lst= new ArrayList<>(ply.getMessg());
     
      ply.getMessg().clear();
      
      for(int i=0; i<lst.size();i++){
          String[] st =lst.get(i).split("\\|");
          System.out.println(lst.get(i) +"="+st[0] +"|"+st[1]);
          addMessage(st[0],st[1]);
      }
  }
  
  private boolean checkMultiChoiceEv(){
    for(int i=0;i<multiEventImpl.size();i++){
      MultiChoiceEvents mev =  multiEventImpl.get(i);
        if(mev.getRemTurns()==0){
           CurrentPlayer.multiEvent=i;
           CurrentPlayer.mevTrigg=true;
           showActionScene("EventShow.fxml",null);
           ply=CurrentPlayer.ply;
           multiEventImpl.remove(i);
           CurrentPlayer.mevTrigg=false;
           return true;
        }
        if(mev.getRemTurns()>0){
          mev.setRemTurns(mev.getRemTurns()-1);
        }
      
    }
    return false;
}
 
}
