package com.example.projeto_alpha;

import gui.utils.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private int id;
    @FXML
    private MenuItem menuItemCliente;
    @FXML
    private MenuItem menuItemProduto;
    @FXML
    private MenuItem menuItemSobre;


    @FXML
    public void onMenuItemClienteAction() {
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemProduto() {
        System.out.println("onMenuItemDepartmentAction");
    }

    @FXML
    public void onMenuItemSobre() {
        System.out.println("Funfou");
        loadView("About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized void loadView(String absoluteName) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = loader.load();
            Scene mainScene = MainAplication.getMainScene();
            VBox mainVbox =(VBox) ((ScrollPane)mainScene.getRoot()).getContent();
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);

        }
    }
}