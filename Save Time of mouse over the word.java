/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package englishapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author moatari-esfehani
 */
public class FirstPageController implements Initializable {
    @FXML
    private Text text1;
    @FXML
    private Text wide;
    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private Text text2;
    @FXML
    private Pane Pane;
    @FXML
    private Text TextImage;
    @FXML
    private  Text TextText ;
    @FXML
      private  Text TextAudio ;
    @FXML
   private void handleMouseentered(MouseEvent event){
       text1.setCursor(Cursor.TEXT);
   }
   @FXML
   private void handleMouseEntered(MouseEvent event){
       text2.setCursor(Cursor.HAND);
   }
    
    @FXML
   private void handleOnMouseClicked(MouseEvent event) throws IOException
    { 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondFXML.fxml"));
        Parent root=null;
        root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
//    stage.initModality(Modality.APPLICATION_MODAL);
//    stage.initStyle(StageStyle.UNDECORATED);
    stage.setTitle("ABC");
    stage.setScene(new Scene(root,1000,650));  
    stage.show();
        
    }
   @FXML
   private void handleOnMouseClickedImage(MouseEvent event) throws IOException
    {  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("imagefxml.fxml"));
                   Parent root1 = null;
                   
                   
                   
                       
                    
                 try {
                     root1 = (Parent) fxmlLoader.load();
                 } catch (IOException ex) {
                     Logger.getLogger(EnglishApp.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
       
         

            
         
         
        Scene scene = new Scene(root1,Color.LIGHTYELLOW);
        Stage stage1 = new Stage();
        
       
        stage1.setScene(scene);
       stage1.show();
       long startTime = System.currentTimeMillis();
//
//stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
//          public void handle(WindowEvent we) {
//              System.out.println("Stage is closing");
//          }
//      });        
//        stage1.close();
//        
//    }
stage1.setOnHiding(new EventHandler<WindowEvent>() {

         @Override
         public void handle(WindowEvent event) {
             Platform.runLater(new Runnable() {
long finishTime = System.currentTimeMillis();
                 @Override
                 public void run() {
                     System.out.println("Application Closed by click to Close Button(X)");
                     long total=(finishTime-startTime)/1000;
                      System.out.println(total);
                     System.exit(0);
                 }
             });
         }
     });
    }
    
   @FXML
   private void handleOnMouseClickedText(MouseEvent event) throws IOException
    { 
       
        
    }
   
   @FXML
   private void handleMouseMoved(MouseEvent event) throws IOException
    { 
//        int i=0;
 
        String msg =
          "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
          "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ")";
            double[] position = null;
        String file = "NewUser.txt";
        System.out.print(msg+ System.currentTimeMillis()/1000);
        // Files.newBufferedWriter() uses UTF-8 encoding by default
       
       
            
//		
  }
		

	

  
         
//        position[i]=event.getX();
//        position[i+1]= event.getY();
//        i=i+1;
//         //System.out.print(msg);
//         String pos="i="+ i;
         @FXML
   private void handleMouseWide(MouseEvent event){
       wide.setCursor(Cursor.HAND);
       
       wide.setFont(Font.font("Verdana", FontWeight.BOLD,14));
   }
    @FXML
   private void handleExitWide(MouseEvent event){
       wide.setCursor(Cursor.TEXT);
       
       wide.setFont(Font.font("Verdana",FontWeight.NORMAL,12));
   }
   
   @FXML
   private void handleMouseWideClicked (MouseEvent event){
       
      TextText.setVisible(true);
      TextImage.setVisible(true);
         TextAudio.setVisible(true);
//       
   }
  
        @FXML
   private void handlescrollEvent(ScrollEvent event)
   {
        
//            double zoomFactor = 1.1;
//            double deltaY = event.getDeltaY();
//
//            if (deltaY < 0) {
//                zoomFactor = 0.90;
//            }
//           Pane.setScaleX(Pane.getScaleX() * zoomFactor);
//            Pane.setScaleY(Pane.getScaleY() * zoomFactor);
//
//            event.consume();
        }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
