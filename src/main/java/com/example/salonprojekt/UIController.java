package com.example.salonprojekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class UIController {
    Usecase uc=new Usecase();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label lblIndtastBrugernavn;
    @FXML
    private Label lblIndtastKodeord;
    @FXML
    private CheckBox chbVisKodeord;
    @FXML
    private TextField txtIndtastBrugernavn;
    @FXML
    private TextField txtIndtastKodeord;
    @FXML
    private PasswordField pswIndtastKodeordSkjult;
    @FXML
    private Button btnLogUd;
    @FXML
    private Button btnLogInd;
    @FXML
    private Label lblLoginFejl;
    @FXML
    private TextField txtOpretBrugernavn;
    @FXML
    private TextField txtOpretFornavn;
    @FXML
    private TextField txtOpretEfternavn;
    @FXML
    private TextField txtOpretMobil;
    @FXML private TextField txtOpretEmail;


    public UIController() throws SQLException {
    }
    @FXML
    public void visKodeord(ActionEvent event){
        if (chbVisKodeord.isSelected()){
            txtIndtastKodeord.setText(pswIndtastKodeordSkjult.getText());
            txtIndtastKodeord.setVisible(true);
            pswIndtastKodeordSkjult.setVisible(false);
            return;
        }
        pswIndtastKodeordSkjult.setText(txtIndtastKodeord.getText());
        pswIndtastKodeordSkjult.setVisible(true);
        txtIndtastKodeord.setVisible(false);
    }
    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToOpretKunde(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("opretKunde.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void opretKunde(ActionEvent event){
        Kunde k = new Kunde ();
        String brugernavn = txtOpretBrugernavn.getText();
        String kodeord = txtIndtastKodeord.getText();
        String fornavn = txtOpretFornavn.getText();
        String efternavn = txtOpretEfternavn.getText();
        String mobil = txtOpretMobil.getText();
        String email = txtOpretEmail.getText();
        k.setBrugernavn(brugernavn);
        k.setKodeord(kodeord);
        k.setFnavn(fornavn);
        k.setEnavn(efternavn);
        k.setMobil(mobil);
        k.setEmail(email);
        uc.opretKunde(brugernavn,kodeord,fornavn,efternavn,mobil,email);
    }

    public void login(ActionEvent event) throws SQLException, IOException {
        if (uc.login(txtIndtastBrugernavn.getText(),pswIndtastKodeordSkjult.getText())) {
            switchToMenu(event);
        }else lblLoginFejl.setText("Ugyldigt login");
    }
}