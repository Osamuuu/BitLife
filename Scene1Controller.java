/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication1.CurrentPlayer.istoricF;
import javax.swing.JOptionPane;


/**
 *
 * @author Osamu
 */
public class Scene1Controller implements Initializable {

    Player ply;

    Stage stageTheLabelBelongs;
    @FXML
    private Label label;
    @FXML
    private TextField txtPersName;
    @FXML
    private Button button;
    @FXML
    private Label lblyrn;

    @FXML
    private ImageView imgcaracter;
    
    @FXML
    private ImageView imageView;

    @FXML
    private TextField txtnume;
    @FXML
    private Label lblnam11;

    @FXML
    private Label lblAdv;

    @FXML
    private RadioButton rbFemale;
    @FXML
    private Label lblTop;
    @FXML
    private Pane paneTop;
    @FXML
    private RadioButton rbMale;
    @FXML
    private ImageView btnClose;
    @FXML
    private ToggleGroup genderGroup;
    
    private static double xOffset = 0;
    private static double yOffset = 0;
    
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnNewGame;
    @FXML
    private Button btnCredits;
    
    @FXML
    private void WhenYouWrite(KeyEvent e) {
        if(e.getText()!=""){
          lblAdv.setText("");
 
        }
       
    }
    @FXML
    private void handleRadioButtonSel(MouseEvent e){
        if(e.getSource()==rbMale){             
            imgcaracter.setImage(new Image("javafxapplication1/resources/Image-6777.png"));
        } if(e.getSource()==rbFemale){
            imgcaracter.setImage(new Image("javafxapplication1/resources/Image-4219.png"));
        }
        if (e.getSource()==btnClose){
            Platform.exit();
            System.exit(0);
        }
        
    }
  
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //  String plyN = null;
        int gender;
        if (rbFemale.isSelected() == true) {
            gender = 0;
        } else {
            gender = 1;
        }
        if (txtnume.lengthProperty().intValue() > 0 && txtPersName.lengthProperty().intValue() > 0) {
            ply = new Player(txtnume.getText(), txtPersName.getText(), 0, 50000, 50, 50, gender);
            stageTheLabelBelongs = (Stage) button.getScene().getWindow();
            
            CurrentPlayer.updatePlayer(ply);
            CurrentPlayer.updateIstoricF(istoricF, CurrentPlayer.SeriesF);
            //CurrentPlayer.istoricF.add(CurrentPlayer.SeriesF);
            ActionHandling.createActionList();
            ActionHandling.createEvList();
            ActionHandling.createMultiChoiceList();
            stageTheLabelBelongs.setTitle("Business Simulator");
          
           

     
           
              try {
                 Parent root2 = FXMLLoader.load(getClass().getResource("Level1Description.fxml"));
                  Stage stage2 = new Stage();
                  Scene scene = new Scene(root2);
                 stage2.setScene(scene);
                 stage2.initModality(Modality.APPLICATION_MODAL);
                 scene.setFill(Color.TRANSPARENT);
                 stage2.setTitle("Business Simulator");
                 stage2.initStyle(StageStyle.TRANSPARENT);
                stage2.showAndWait();
                
                Parent root  = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                Scene scene3 = new Scene(root);
                scene3.setFill(Color.TRANSPARENT);
                 
                 
                stageTheLabelBelongs.setScene(scene3);  
                } catch (IOException ex) {
                Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }   
            
        } else {
            lblAdv.setText("You have to fill all required fields!!!");
        }

    }
    
    @FXML
    private void Pressed(MouseEvent e){
        stageTheLabelBelongs = (Stage) paneTop.getScene().getWindow();
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
       
        
       // btnLoad.getParent().setStyle("-fx-background-color: linear-gradient(from 25% 25% to 60% 60%,  #86e0b3, #ecffd8 )");


        

    }
    @FXML
    private void ClickHandle(MouseEvent ev) throws IOException, ClassNotFoundException{
   if(ev.getSource()==btnLoad){
     ply=new Player();
   stageTheLabelBelongs = (Stage) btnLoad.getScene().getWindow();     
   FileChooser fileChooser = new FileChooser();
   fileChooser.setTitle("Load Saved Game");

  // fileChooser.showOpenDialog(null);
  String path = System.getProperty("user.home")+File.separator+"Documents";
    path += File.separator + "BizzLife Saves";
  fileChooser.setInitialDirectory(new File(path));
   File f=fileChooser.showOpenDialog(null);
   
       
         
            if (f!=null && f.exists() && f.getName().endsWith(".bizz")) {
             
                    
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ply = ((Player) ois.readObject());
                    // c = mdl;
                    ois.close();
                    fis.close();
                    
                    ActionHandling.lblenable=ply.getLblenable();
                    ActionHandling.lblrevenue=ply.getLblrevenue();
                    CurrentPlayer.updatePlayer(ply);
                    CurrentPlayer.PlyImplAList=ply.getPlyImplAList();
                    CurrentPlayer.PlyactionList=ply.getPlyactionList();
                    ActionHandling.multiEventList=ply.getMultiEventList();
                    ActionHandling.multiEventImpl=ply.getMultiEventImpl();
                    
                 //   CurrentPlayer.updatePlayer(ply);
                    
                    CurrentPlayer.updateIstoricF(istoricF, CurrentPlayer.SeriesF);
                    
                    ActionHandling.createActionList();
                    ActionHandling.createEvList();
                    
                    Parent root  = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                      
                      stageTheLabelBelongs.setScene(new Scene(root));  
              
              
                
                         }
                    
             } if (ev.getSource()==btnNewGame){
                 label.setDisable(false);
                 lblyrn.setDisable(false);
                 txtnume.setDisable(false);
                 txtPersName.setDisable(false);
                 rbFemale.setDisable(false);
                 rbMale.setDisable(false);
                 button.setDisable(false);
                 imgcaracter.setOpacity(1);
                 
             }
        }
   
    }
