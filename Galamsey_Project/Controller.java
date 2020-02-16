/**
 * @author Andrew Duncan
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

//Import the necessary elements to combine the class with the 'Galamsey FX.fxml' file.
import Galamsey_Project.Observatory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import java.net.URL;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Initialize the instance variables using the id's and onActions(buttons) from the fxml file
    Monitoring data = new Monitoring();
    ObservableList<TableContent> tableContents = FXCollections.observableArrayList();
    @FXML private TextField obsName, country, year, areakm;
    @FXML private Button addObs, obsAverage, observatory, galamsey;
    @FXML private TableView<TableContent> tableView;
    @FXML private TableColumn<TableContent, String> nameObs, obsCountry;
    @FXML private TableColumn<TableContent, Integer> startYear;
    @FXML private TableColumn<TableContent, Double> area, average;
    @FXML private Label feedback;

    /**
     *
     * @param actionEvent
     */
    @FXML
    public void obstable(ActionEvent actionEvent){}

    /**
     *
     * @param actionEvent
     */
    public void galamtable(ActionEvent actionEvent){
        nameObs.setText("Vegetation Color");
        obsCountry.setText("Color Value");
        startYear.setText("Longitude");
        area.setText("Latitude");
        average.setText("Record Year");
        addObs.setText("Add Galamsey");
        obsAverage.setText("Remove Galamsey");
//        obsName.setPromptText("Vegetation Colour ");
//        country.setPromptText("");
//        year.setPromptText("");
//        areakm.setPromptText("");
        obsAverage.setStyle("-fx-background-color:  #ffcccb;");
        TableColumn<TableContent, String> column = new TableColumn<>();
        column.setText("Observatory Name");
        column.setCellValueFactory(new PropertyValueFactory<TableContent, String>("average"));
        tableView.getColumns().add(column);
        tableView.setItems(getGalsContent());
    }

    /**
     *
     * @param actionEvent
     * This method adds an observatory to the database.
     */
    public void obsInsert(ActionEvent actionEvent){
        feedback.setTextFill(Color.BLACK);
        if (obsName.getText().equals("") || country.getText().equals("") || year.getText().equals("") || areakm.getText().equals("")) {
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                    actionEvent1 -> feedback.setText("Cannot have an empty input!")), new KeyFrame(Duration.millis(0),
                    actionEvent2 -> feedback.setStyle("-fx-background-color:  #ff0000;")), new KeyFrame(Duration.millis(1500),
                    actionEvent3 -> feedback.setText("Observatories Table")), new KeyFrame(Duration.millis(1500),
                    actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
            animation.play();
        }else {
            Galamsey_Project.Observatory obs = new Observatory(obsName.getText(), country.getText(),
                    Integer.parseInt(year.getText()), Double.parseDouble(areakm.getText()));
            obsName.clear();
            year.clear();
            country.clear();
            areakm.clear();
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                    actionEvent1 -> feedback.setText("Observatory has been added!")), new KeyFrame(Duration.millis(0),
                    actionEvent2 -> feedback.setStyle("-fx-background-color:  #9acd32;")), new KeyFrame(Duration.millis(1500),
                    actionEvent3 -> feedback.setText("Observatories Table")), new KeyFrame(Duration.millis(1500),
                    actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
            animation.play();
            tableView.setItems(getObsContent());
        }
    }
    /**
     *
     * @param actionEvent
     */
    public void search(ActionEvent actionEvent){}

    /**
     *
     * @param actionEvent
     */
    public void from(ActionEvent actionEvent){}

    /**
     *
     * @param actionEvent
     */
    public void operations(ActionEvent actionEvent){}

    /**
     *
     * @param actionEvent
     */
    public void updateAvg(ActionEvent actionEvent){}


    /**
     *
     * @param url
     * @param resourceBundle
     * This method fills the TableView object with data stored in the database
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameObs.setCellValueFactory(new PropertyValueFactory<TableContent, String>("name"));
        obsCountry.setCellValueFactory(new PropertyValueFactory<TableContent, String>("country"));
        startYear.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("startYear"));
        area.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("area"));
        average.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("average"));

        feedback.setTextFill(Color.BLACK);
        feedback.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        feedback.setText("Observatories Table");
        tableView.setItems(getObsContent());
    }

    /**
     *
     * @return This returns the data in the Observatories table in the database in a list which is displayed in the
     * TableView object in the GUI
     */
    private ObservableList<TableContent> getObsContent(){
        ArrayList<String[]> allObs = data.getallObs();
        for (String[] p: allObs){
            tableContents.add(new TableContent(p[0], p[1], Integer.parseInt(p[2]), Double.parseDouble(p[3]),
                    Double.parseDouble(p[4])));
        }
        return tableContents;
    }

    /**
     *
     * @return This returns the data in the Observatories table in the database in a list which is displayed in the
     * TableView object in the GUI
     */
    private ObservableList<TableContent> getGalsContent(){
        ArrayList<String[]> allObs = data.getallGal();
        for (String[] p: allObs){
            tableContents.add(new TableContent(Double.parseDouble(p[2]), Double.parseDouble(p[3]), p[0],
                    Integer.parseInt(p[4]), p[5]));
        }
        return tableContents;
    }


}