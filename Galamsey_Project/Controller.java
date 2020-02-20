/**
 * @author Andrew Duncan
 */
package CSC313_project_EarthquakeMonitoring_10742022.Galamsey_Project;

//Import the necessary elements to combine the class with the 'Galamsey FX.fxml' file.
import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import java.net.URL;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane house; //id for the tableView object
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

    //Create new ids for the galamsey table
    @FXML private TableColumn<TableContent, String> veg_color, obs_name;
    @FXML private TableColumn<TableContent, Integer> colValue, occurYear;
    @FXML private TableColumn<TableContent, Double> longitude, latitude;
    TableColumn<TableContent, Integer> column = new TableColumn<>();
    TextField lati = new TextField();


    /**
     *
     * @param actionEvent
     * This method updates the behaviour of the Observatories tableView including generating the data in the Table view
     * when the Observatory button is clicked.
     */
    @FXML
    public void obstable(ActionEvent actionEvent){
        //Connect the table columns to the variables in the TableContent class that house the data going to be inputted in them.
        nameObs.setCellValueFactory(new PropertyValueFactory<TableContent, String>("obsName"));
        obsCountry.setCellValueFactory(new PropertyValueFactory<TableContent, String>("country"));
        startYear.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("startYear"));
        area.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("area"));
        average.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("avg"));

        //Remove the extra column that adds when in the Galamsey Table.
        tableView.getColumns().remove(column);
        house.getChildren().remove(lati);

        //Reset the column names back to original values.
        nameObs.setText("Observatory Name ");
        obsCountry.setText("Name of Country ");
        startYear.setText("Year Commenced ");
        area.setText("Area Covered in km ");
        average.setText("Average Color Value ");
        obsAverage.setId("updateAvg");

        //Reset the Ids of the elements in the GUI to original IDs.
        obsName.setId("obsName");
        country.setId("country");
        year.setId("year");
        areakm.setId("areakm");
        addObs.setId("obsInsert");

        // Reset the add Observatory button to its original functionality
        addObs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                obsInsert(actionEvent);
            }
        });

        // Reset the add Update Average button to its original functionality
        obsAverage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateAvg(actionEvent);
            }
        });

        //Reset the original prompt texts in the observatory textFields.
        obsName.setPromptText("Observatory name");
        country.setPromptText("Name of country");
        year.setPromptText("Year Commenced");
        areakm.setPromptText("Area in km");

        //Reset the text and style of both Add observatory and update average columns.
        addObs.setText("Add Observatory");
        addObs.setStyle("-fx-background-color: #85c6d4;");
        obsAverage.setText("Update Average");
        obsAverage.setStyle("-fx-background-color: #a0db8e;");

        //Reset the label components to original.
        feedback.setTextFill(Color.BLACK);
        feedback.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        feedback.setText("Observatories Table");

        //Refresh the table and flood it with the Observatory data.
        tableView.getItems().clear();
        tableView.setItems(getObsContent());
    }

    /**
     *
     * @param actionEvent
     * This method updates the behaviour of the Observatories tableView including generating the data in the Table view
     *  when the Galamsey button is clicked.
     *  This methods reassigns different ids and texts to the elements in the GUI to allow  the same elements to display
     *  different data (Galamsey data), and perform different functions.
     */
    public void galamtable(ActionEvent actionEvent){
        feedback.setText("Galamseys Table"); //Change feedback status

        //Change the ids of the same buttons to make the program think they are new buttons
        nameObs.setText("Vegetation Color"); //Change column name
        nameObs.setId("veg_color");
        nameObs.setCellValueFactory(new PropertyValueFactory<TableContent, String>("veg_color"));

        obsCountry.setText("Observatory name");//Change column name
        obsCountry.setId("obs_name");
        obsCountry.setCellValueFactory(new PropertyValueFactory<TableContent, String>("galObs_name"));

        startYear.setId("occurYear");
        startYear.setText("Year of Occurrence");//Change column name
        startYear.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("occurYear"));

        area.setId("longitude");
        area.setText("Longitude");//Change column name
        area.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("longi"));

        average.setId("latitude");
        average.setText("Latitude");//Change column name
        average.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("lat"));

        //Change button Ids
        addObs.setId("addition");
        obsAverage.setId("removal");

        //Change TextField ids
        obsName.setId("vegColor");
        country.setId("nameOfObs");
        year.setId("yearOccur");
        areakm.setId("long");
        lati.setId("lat");

        //Change button names and color
        addObs.setText("Add Galamsey");
        obsAverage.setText("Remove Galamsey");
        obsAverage.setStyle("-fx-background-color:  #ffcccb;");

        //Changing prompt text in textfields
        obsName.setPromptText("Vegetation Color: ");
        country.setPromptText("Observatory Name: ");
        year.setPromptText("Year: ");
        areakm.setPromptText("Longitude: ");
        lati.setPromptText("Latitude: ");

        //Initialize new column
        column.setText("Color Value");
        column.setId("col_value");
        column.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("colValue"));
        tableView.getColumns().add(column);

        //Change textfield layouts
        obsName.setLayoutX(18.0);
        obsName.setPrefWidth(116.0);

        country.setLayoutX(145.0);
        country.setPrefWidth(129.0);

        year.setLayoutX(283.0);
        year.setPrefWidth(131.0);

        areakm.setLayoutX(422.0);
        areakm.setPrefWidth(121.0);

        lati.setLayoutX(554.0);
        lati.setLayoutY(596.0);
        lati.setPrefWidth(121.0);

        //Add the new Text field to the view
        house.getChildren().add(lati);

        //Change the function of the same add Observatory button the Add a new Galamsey to the database and the table view.
        addObs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Check if any input in blank
                if (obsName.getText().equals("") || country.getText().equals("") || year.getText().equals("") || areakm.getText().equals("")
                        || lati.getText().equals("")) {

                    // Update the color and text of the label to present the status of the operation.
                    Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                            actionEvent1 -> feedback.setText("Cannot have an empty input!")), new KeyFrame(Duration.millis(0),
                            actionEvent2 -> feedback.setStyle("-fx-background-color:  #ff0000;")), new KeyFrame(Duration.millis(0),
                            actionEvent3 -> feedback.setTextFill(Color.WHITE)), new KeyFrame(Duration.millis(1500),
                            actionEvent3 -> feedback.setText("Galamsey Table")), new KeyFrame(Duration.millis(1500),
                            actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")), new KeyFrame(Duration.millis(1500),
                            actionEvent5 -> feedback.setTextFill(Color.BLACK)));
                    animation.play();
                }else {
                    //Instantiate the new Galamsey object using the inputted data.
                    Galamsey event = new Galamsey(Double.parseDouble(areakm.getText()), Double.parseDouble(lati.getText()),
                            Galamsey.Vegetation_color.valueOf(obsName.getText().toUpperCase()), Integer.parseInt(year.getText()),
                            country.getText());

                    // Update the color and text of the label to present the status of the operation.
                    Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                            actionEvent1 -> feedback.setText("Galamsey has been added!")), new KeyFrame(Duration.millis(0),
                            actionEvent2 -> feedback.setStyle("-fx-background-color:  #9acd32;")), new KeyFrame(Duration.millis(1500),
                            actionEvent3 -> feedback.setText("Galamsey Table")), new KeyFrame(Duration.millis(1500),
                            actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
                    animation.play();

                    //Clear all textfields when button is clicked
                    areakm.clear();
                    obsName.clear();
                    year.clear();
                    country.clear();
                    lati.clear();

                    //Refresh the table and flood it with the Observatory data.
                    tableView.getItems().clear();
                    tableView.setItems(getGalsContent());
                }
            }
        });

        //Change the functionality of the of the Update Average button to Remove the selected Galamsey.
        obsAverage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Get the row that has been selected
                ObservableList<TableContent> select = tableView.getSelectionModel().getSelectedItems();

                //Check if nothing has been selected.
                if (select.isEmpty()) {
                    // Update the color and text of the label to present the status of the operation.
                    Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                            actionEvent1 -> feedback.setText("Nothing has been selected!")), new KeyFrame(Duration.millis(0),
                            actionEvent2 -> feedback.setStyle("-fx-background-color:  #ff0000;")) ,new KeyFrame(Duration.millis(0),
                            actionEvent3 -> feedback.setTextFill(Color.WHITE)), new KeyFrame(Duration.millis(1500),
                            actionEvent3 -> feedback.setText("Galamsey Table")), new KeyFrame(Duration.millis(1500),
                            actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
                    animation.play();
                }else{
                    // Update the color and text of the label to present the status of the operation.
                    Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                            actionEvent1 -> feedback.setText("Galamsey has been removed!")), new KeyFrame(Duration.millis(0),
                            actionEvent2 -> feedback.setStyle("-fx-background-color:  #9acd32;")), new KeyFrame(Duration.millis(1500),
                            actionEvent3 -> feedback.setText("Galamsey Table")), new KeyFrame(Duration.millis(1500),
                            actionEvent4 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
                    animation.play();

                    //Remove the selected row from the database and the table view
                    data.removeGal(select.get(0).getGalObs_name(), select.get(0).getLongi(), select.get(0).getLat());

                    //Refresh the table and flood it with the Observatory data.
                    tableView.getItems().clear();
                    tableView.setItems(getGalsContent());
                }
            }
        });

        //Refresh the table and flood it with the Galamsey data.
        tableView.getItems().clear();
        tableView.setItems(getGalsContent());
    }

    /**
     *
     * @param actionEvent
     * This method adds an observatory to the database.
     */
    public void obsInsert(ActionEvent actionEvent){
        feedback.setTextFill(Color.BLACK);
        // Check if any input in is empty.
        if (obsName.getText().equals("") || country.getText().equals("") || year.getText().equals("") || areakm.getText().equals("")) {
            // Update the color and text of the label to present the status of the operation.
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                    actionEvent1 -> feedback.setText("Cannot have an empty input!")), new KeyFrame(Duration.millis(0),
                    actionEvent2 -> feedback.setStyle("-fx-background-color:  #ff0000;")), new KeyFrame(Duration.millis(0),
                    actionEvent3 -> feedback.setTextFill(Color.WHITE)), new KeyFrame(Duration.millis(1500),
                    actionEvent4 -> feedback.setText("Observatories Table")), new KeyFrame(Duration.millis(1500),
                    actionEvent5 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
            animation.play();
        }else {
            //Instantiate the new Observatory object using the inputted data.
            Observatory obs = new Observatory(obsName.getText(), country.getText(),
                    Integer.parseInt(year.getText()), Double.parseDouble(areakm.getText()));

            //Clear all textfields when button is clicked
            obsName.clear();
            year.clear();
            country.clear();
            areakm.clear();

            // Change the color and text of the label to present the status of the operation.
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(0),
                    actionEvent1 -> feedback.setText("Observatory has been added!")), new KeyFrame(Duration.millis(0),
                    actionEvent2 -> feedback.setStyle("-fx-background-color:  #9acd32;")), new KeyFrame(Duration.millis(1500),
                    actionEvent4 -> feedback.setText("Observatories Table")), new KeyFrame(Duration.millis(1500),
                    actionEvent5 -> feedback.setStyle("-fx-background-color:  #85c6d4;")));
            animation.play();

            //Refresh the table and flood it with the Observatory data.
            tableView.getItems().clear();
            tableView.setItems(getObsContent());
        }
    }

    /**
     *
     * @param actionEvent
     * This method updates the average column of the selected row
     */
    public void updateAvg(ActionEvent actionEvent){
        ObservableList<TableContent> obs = tableView.getSelectionModel().getSelectedItems(); //Get the value sin the selected row
        data.updateAverageColValue(obs.get(0).getObsName()); // Get the value in the name column
        /*
        Refresh the table.
         */
        tableView.getItems().clear();
        tableView.setItems(getObsContent());

    }


    /**
     *
     * @param url
     * @param resourceBundle
     * This method fills the TableView object with data stored in the database
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Connect the table columns to the variables in the TableContent class that house the data going to be inputted in them.
        nameObs.setCellValueFactory(new PropertyValueFactory<TableContent, String>("obsName"));
        obsCountry.setCellValueFactory(new PropertyValueFactory<TableContent, String>("country"));
        startYear.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("startYear"));
        area.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("area"));
        average.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("avg"));

        feedback.setTextFill(Color.BLACK); //Set the text color in the label at the top to black
        //Set the background color to light blue
        feedback.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        feedback.setText("Observatories Table"); //Set the label text
        tableView.setItems(getObsContent()); //Flood the table with data from the database
    }

    /**
     *
     * @return This returns the data in the Observatories table in the database in a list which is displayed in the
     * TableView object in the GUI
     */
    private ObservableList<TableContent> getObsContent(){
        ArrayList<String[]> allObs = data.getallObs(); //Stores all Observatory data in the arraylist
        for (String[] p: allObs){
            tableContents.add(new TableContent(p[0], p[1], Double.parseDouble(p[3]), Integer.parseInt(p[2]),
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
        ArrayList<String[]> allObs = data.getallGal(); //Stores all Galamsey data in the arraylist
        for (String[] p: allObs){
            tableContents.add(new TableContent(Double.parseDouble(p[2]), Double.parseDouble(p[3]), p[0], Integer.parseInt(p[1]),
                    Integer.parseInt(p[4]), p[5]));
        }
        return tableContents;
    }

}