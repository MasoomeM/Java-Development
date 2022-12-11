/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codgeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;

/**
 *
 * @author Masoome
 */
public class CodGenerator {
    private ArrayList<String> AllWords = new ArrayList<>();
    
    public void get_text(){
        File text = new File("text.txt");
        if (text.exists()) {
            try {
            String[] str;
            Scanner ReadText = new Scanner(text);
            while (ReadText.hasNextLine()) {
                str = ReadText.nextLine().split(" ");
                for (int i = 0; i < str.length; i++) {
                    AllWords.add(str[i]);
//                    System.out.println(str[i]);
                }
            }
            ReadText.close();
            }catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
            }
        
        }
    }
    
    public void set_tags(Double AllWidth, Double AllHeight){
        try {
            PrintWriter TagWriter = new PrintWriter("Tags.txt");
            Text theText;
            Double width;
            Double layoutX = 17.0;
            Double layoutY = 20.0;
            int i = 0;
            do {
                TagWriter.write("<Text fx:id=\"id" + i + "\" layoutX =\"" + layoutX + "\" layoutY=\"" + layoutY 
                                + "\" onMouseEntered=\"#handleMouseMoveId" + i
                                + "\" strokeType=\"OUTSIDE\" strokeWidth=\"0.0\" text=\"" + AllWords.get(i) + "\" /> \n");
                theText = new Text(AllWords.get(i));
                width = theText.getBoundsInLocal().getWidth();
                layoutX += round(width) + 11.0;
                if(layoutX > AllWidth - 40){
                    layoutX = 17.0;
                    if (layoutY < AllHeight - 20)
                        layoutY += 20;
                    else{
                        System.out.println("ScrollPane becomes full. Please expand size of ScrollPane");
                        break;
                    }
                }
                
                i++;
            } while(i < AllWords.size());
            
            TagWriter.close();
            
        } catch (FileNotFoundException ex) {
          Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }
    
    public void set_functions(){
        try{
            PrintWriter FunctionWriter = new PrintWriter("Functions.txt");
            for (int i = 0; i < AllWords.size(); i++) {
                FunctionWriter.write("@FXML\n");
                FunctionWriter.write("private void handleMouseMove" + "(MouseEvent event) {\n");
                FunctionWriter.write("\twrite_to_json(id" + i + ".getId(), id" + i + ".getText(), id" +
                                     i + ".getLayoutX(), id" + i + ".getLayoutY());\n}\n\n");
            }
            
            FunctionWriter.close();    
            
        } catch (FileNotFoundException ex) {
          Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    public void set_declaration(){
        try{
            PrintWriter declareWriter = new PrintWriter("Declaration.txt");
            declareWriter.write("@FXML\n");
            for (int i = 0; i < AllWords.size(); i++) {
                declareWriter.write("public Text id" + i + ";\n");
            }
            
            declareWriter.close();    
            
        } catch (FileNotFoundException ex) {
          Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
}
