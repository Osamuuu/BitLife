/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author costareea
 */
public class MusicManip {
  static  MediaPlayer mp;

    public MusicManip() {
        
        
    }

    
public static void startMusic(){
    mp.play();
}    
public static void stopMusic(){
    mp.stop();
   
}  
}
