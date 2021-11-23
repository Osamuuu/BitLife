/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Osamu
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
     /* 
        URL mus = getClass().getResource("/javafxapplication1/resources/bensound-ukulele.mp3");
        MediaPlayer mp = new MediaPlayer(new Media(mus.toString()));
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.play();
        */
     
    URL mus = getClass().getResource("/javafxapplication1/resources/bensound-ukulele.mp3");
    
        MusicManip.mp = new MediaPlayer(new Media(mus.toString()));
        MusicManip.mp.setCycleCount(MediaPlayer.INDEFINITE);
        MusicManip.startMusic();
       Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
       Scene scene = new Scene(root);
      //  scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Business Simulator");
       
        
        stage.show();
 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
