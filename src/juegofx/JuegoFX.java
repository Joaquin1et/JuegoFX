
package juegofx;

import java.util.Collection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Joaquín
 */
public class JuegoFX extends Application implements Runnable{
    
    private static Thread thread;
    
    @Override
    public void start(Stage stage ) throws Exception{
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/JuegoFx.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        JuegoFX juegoFx = new JuegoFX();
        
        juegoFx.iniciar();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
    
    private void iniciar(){
        thread = new Thread(this,"Gráficos");
        thread.start();
        
    }
    
    private void detener(){
        
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.print("Estamos estudiando los hilos");
    }
    
}
