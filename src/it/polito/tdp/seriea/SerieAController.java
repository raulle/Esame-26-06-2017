/**
 * Sample Skeleton for 'SerieA.fxml' Controller Class
 */

package it.polito.tdp.seriea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.seriea.model.Model;
import it.polito.tdp.seriea.model.Season;
import it.polito.tdp.seriea.model.Season2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class SerieAController {
	
	private Model model;
	
	public void setModel(Model model){
		this.model=model;
		
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxSquadra"
    private ChoiceBox<Season> boxSquadra; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcolaConnessioniSquadra"
    private Button btnCalcolaConnessioniSquadra; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimulaEspulsi"
    private Button btnSimulaEspulsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizzaStagioni"
    private Button btnAnalizzaStagioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaStagioni(ActionEvent event) {
    	boxSquadra.getItems().addAll(model.getStagioni());
    }

    @FXML
    void doCalcolaConnessioniStagione(ActionEvent event) {
    	Season s = boxSquadra.getValue();
    	List<Season2> l = model.getSquadre(s);
    	for(Season2 ss : l){
    		txtResult.appendText(ss.toString()+"\n");
    	}
    }

    @FXML
    void doSimulaEspulsi(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxSquadra != null : "fx:id=\"boxSquadra\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnCalcolaConnessioniSquadra != null : "fx:id=\"btnCalcolaConnessioniSquadra\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnSimulaEspulsi != null : "fx:id=\"btnSimulaEspulsi\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert btnAnalizzaStagioni != null : "fx:id=\"btnAnalizzaStagioni\" was not injected: check your FXML file 'SerieA.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SerieA.fxml'.";

    }
}
