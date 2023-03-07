package com.example.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label textLanguage;
    @FXML
    private Label textWelcome;
    @FXML
    private Label textUsername;
    @FXML
    private Label textPasswort;
    @FXML
    private ComboBox comboBoxLanguage;
    @FXML
    private TextField textAreaUsername;
    @FXML
    private TextField textAreaPasswort;
    @FXML
    private Button btnLogin;

    private static int loginCounter = 0;
    public void setModelLang()
    {
        comboBoxLanguage.getItems().addAll("German","English","French");
    }
    @FXML
    protected void auswahl(ActionEvent event)
    {
        int sprache = comboBoxLanguage.getSelectionModel().getSelectedIndex();
        switch (sprache)
        {
            case(0):
                Main.setLocal(Locale.GERMAN);
                ResourceBundle.getBundle("Sprachen",Main.getLocal());
                break;
            case(1):
                Main.setLocal(Locale.ENGLISH);
                ResourceBundle.getBundle("Sprachen",Main.getLocal());
                break;
            case(2):
                Main.setLocal(Locale.FRENCH);
                ResourceBundle.getBundle("Sprachen",Main.getLocal());
                break;
        }
        updateUI();
    }
    public static void showError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error");
        alert.setHeaderText("Maximum Tries of 3 has been reached");
        alert.setContentText("This message will be repeated after this");

        alert.showAndWait();
    }
    public static void showInfo()
    {
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.initStyle(StageStyle.UTILITY);
        notify.setTitle("Your input do not equals the data");
        notify.setHeaderText("Please repeat your Input");
        notify.setContentText("There could be a miss input, where you didn't write anything right");

        notify.showAndWait();
    }
    protected void updateUI()
    {
        ResourceBundle resource = ResourceBundle.getBundle("Sprachen",Main.getLocal());
        textLanguage.setText(resource.getString("textLanguage"));
        textUsername.setText(resource.getString("textUsername"));
        textPasswort.setText(resource.getString("textPasswort"));
        textWelcome.setText(resource.getString("textWelcome"));
        btnLogin.setText(resource.getString("btnLogin"));
    }
    public void setOnActionLogin(ActionEvent event)
    {
        String name = "Davidbangbos123";
        String passwort = "GetR3kedNab";
        if (textUsername.getText().contains(name) && textPasswort.getText().contains(passwort)) {
            setNewScene();
            System.out.println("Success");
        } else {
            if (textUsername.getText() != name  || textPasswort.getText() != passwort) {
                loginCounter = loginCounter + 1;
                if(loginCounter == 3)
                {
                    showError();
                    loginCounter = 0;
                }
                else
                {
                    showInfo();

                }
            }
        }
        updateUI();
    }
    public void setNewScene()
    {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        updateUI();
        setModelLang();
    }
}