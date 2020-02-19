/**
 * @author Andrew Duncan
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

//import the necessary modules needed to run the GUI/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class enables the user to run the GUI
 */
public class GalaGUI extends Application {

    @Override
    public void start(Stage primStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Galamsey FX.fxml"));
        primStage.setTitle("Galamsey Records");
        primStage.setScene(new Scene(root,1009, 650));
        primStage.show();
    }

    public static void main(String[] args){
        launch(args);


    }


}

