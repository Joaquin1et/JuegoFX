
package juegofx;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static volatile boolean enFuncionamiento = false;
    
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
    
    private synchronized void iniciar(){
        enFuncionamiento = true;
        
        thread = new Thread(this,"Gráficos");
        thread.start();
        
    }
    
    private synchronized void detener(){
        try {
            enFuncionamiento = true;
            
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(JuegoFX.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error en el metodo detener.");
        }
    }

    @Override
    public void run() {
        while(enFuncionamiento){
            
        }
    }
    
}
