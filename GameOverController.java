/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;




import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static javafxapplication1.CurrentPlayer.istoricF;



/**
 *
 * @author Osamu
 */
public class GameOverController implements Initializable {

    Player ply;
    Stage stageTheLabelBelongs;
    @FXML
    private Label lblDear;
    @FXML
    private Label lblnam111;
  
  
    @FXML
    private Button btnOK;

    @FXML
        private Button btnReplay;
    
    @FXML
    private ImageView imgcaracter;

   
    @FXML
    private Label lblTtitlu;

    @FXML
    private Label lblBadLuck;

    @FXML
    private ImageView btnClose;
    
    @FXML
    private Label lblTop;
    @FXML
    private Pane paneTop;
    private static double xOffset = 0;
    private static double yOffset = 0;
    
    @FXML
    private ProgressBar pbCredibility;
    private  DoubleProperty CredibilityUpdater = new SimpleDoubleProperty(.5);
    private IntegerProperty credibilityUpdater = new SimpleIntegerProperty(50);
    @FXML
    private ProgressBar pbMotivation;
     private DoubleProperty MotivationUpdater = new SimpleDoubleProperty(.5);
     private IntegerProperty motivationUpdater = new SimpleIntegerProperty(50);  
   
    @FXML
    private ProgressBar pbFinance;
    private final DoubleProperty FinancebarUpdater=new SimpleDoubleProperty();
     @FXML
    private Label lblCredibility;

    @FXML
    private Label lblFinance;
     @FXML
    private Label lblMotivation;
   @FXML
    private Label lblcredibility;

    @FXML
    private Label lblfinance;
     @FXML
    private Label lblmotivation;
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
     
         Parent root;
       
         stageTheLabelBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        if(event.getSource()==btnOK){
          stageTheLabelBelongs.close();
          Platform.exit();
          System.exit(0);
        }
        if(event.getSource()==btnReplay){
            CurrentPlayer.PlyImplAList.clear();
            CurrentPlayer.PlyactionList.clear();
            CurrentPlayer.istoricC.clear();
            CurrentPlayer.SeriesF.getData().clear();
            
           // FXCollections.fill(istoricF, new Series(Integer, Integer));
            CurrentPlayer.istoricM.clear();
            CurrentPlayer.ply.setCredibility(50);
            CurrentPlayer.ply.setFinance(50000);
            CurrentPlayer.ply.setPeople(50);
            CurrentPlayer.ply.setTurns(0);
            ActionHandling.lblenable = new int [20];
            Arrays.fill(ActionHandling.lblenable,-1);
            ActionHandling.lblrevenue = new int [20];
            Arrays.fill(ActionHandling.lblrevenue,-1);
            ActionHandling.actioncontor=0;
            CurrentPlayer.mevTrigg=false;
            CurrentPlayer.multiEvent=-1;
            ActionHandling.multiEventImpl.clear();
            ActionHandling.multiEventList.clear();
            ActionHandling.createMultiChoiceList();
            CurrentPlayer.SeriesF.getData().clear();
        //   CurrentPlayer.updateIstoricF(istoricF, CurrentPlayer.SeriesF);
            ply=CurrentPlayer.ply;
             try {
               
                 root =FXMLLoader.load(getClass().getClassLoader().getResource("javafxapplication1/Scene2.fxml"));
                 
                 stageTheLabelBelongs.setScene(new Scene(root));
             } catch (IOException ex) {
                 Logger.getLogger(GameOverController.class.getName()).log(Level.SEVERE, null, ex);
             }
               
             
        }
  
            
    }
@FXML
    private void Pressed(MouseEvent e){
        stageTheLabelBelongs = (Stage) btnReplay.getScene().getWindow();
          xOffset = e.getSceneX();
          yOffset = e.getSceneY();

    }
     @FXML
    private void Dragged(MouseEvent e){
          stageTheLabelBelongs.setX(e.getScreenX() - xOffset);
          stageTheLabelBelongs.setY(e.getScreenY() - yOffset);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ply= CurrentPlayer.ply;
 //       lblFinance.getParent().setStyle("-fx-background-color: linear-gradient(from 25% 25% to 60% 60%,  #86e0b3, #ecffd8 )");

     //   stageTheLabelBelongs = (Stage) btnReplay.getScene().getWindow();
        
       lblDear.setText("Dear "+ply.getName());
       
      if(ply.getGender()==0){
           imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
      }else{
          imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
      }
       pbFinance.setProgress((double)ply.getFinance()/100000);
      lblfinance.setText(String.valueOf(ply.getFinance()));
      if(ply.getFinance()<=0){
      pbFinance.setStyle("-fx-control-inner-background: RED");
      lblfinance.textFillProperty().set(Color.RED);
      }
        pbCredibility.setProgress((double)ply.getCredibility()/100);
        lblcredibility.setText(String.valueOf(ply.getCredibility()));
        if(ply.getCredibility()<=0){
      pbCredibility.setStyle("-fx-control-inner-background: RED");
      lblcredibility.textFillProperty().set(Color.RED);
        }
        pbMotivation.setProgress((double)ply.getPeople()/100);
        lblmotivation.setText(String.valueOf(ply.getPeople()));
        if(ply.getPeople()<=0){
      pbMotivation.setStyle("-fx-control-inner-background: RED");
      lblmotivation.textFillProperty().set(Color.RED);
      
      } 
    }
    @FXML
    private void OnMouseClicked(MouseEvent ev){
    if (ev.getSource()==btnClose){
            Platform.exit();
            System.exit(0);
        }
}
}
