package com.proyecto.hellofx;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class PrimaryController {

    @FXML
    private Button botonAlertaInformacion;
    @FXML
    private Button botonAlertaConfirmacion;
    @FXML
    private Button botonTextInputDialog;
    @FXML
    private Button botonElegirDialogo;
    @FXML
    private Button botonAlertaConfirmVarios;
    @FXML
    private Button botonAlertaWarning;

    private void informacionDialogo() {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Bienvenido al curso de JAVA FX");
        alert.setContentText("En este tema veremos las ventanas de diálogo");

        alert.showAndWait();
    }

    private void warningDialogo() {

        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Ventana de aviso de algún peligro(WARNING)");
        alert.setContentText("Si te equivocas saldrá esta ventana");

        alert.showAndWait();
    }

    private void confirmacionDialogo() {

        //creamos la alerta
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Encuesta sobre el curso de Java FX");
        alert.setContentText("¿Te gusta el curso de Java FX?");

        //creamos los botones
        ButtonType botonSi = new ButtonType("Si");
        ButtonType botonNo = new ButtonType("No");
        ButtonType botonAbstencion = new ButtonType("Me abstengo");

        //indicamos que botones se mostrarán en la alerta
        alert.getButtonTypes().setAll(botonSi, botonNo, botonAbstencion);

        //indicamos el resultado
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == botonSi) {
            //Usuario elige "SI"
        } else if (resultado.get() == botonNo) {
            //Usuario elige "NO"
        } else if (resultado.get() == botonAbstencion) {
            //Usuario elige "Me abstengo"
        }
    }
    
    
    private void confirmacionVariosBotonesDialogo() {

        //creamos la alerta
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Danos tu opinion del curso");
        alert.setContentText("Elige una opción");

        //creamos los botones
        ButtonType botonMuyBueno = new ButtonType("Muy Bueno");
        ButtonType botonBueno = new ButtonType("Bueno");
        ButtonType botonRegular = new ButtonType("Regulinchi");
        ButtonType botonMuyMalo = new ButtonType("Muy Malo");

        //indicamos que botones se mostrarán en la alerta
        alert.getButtonTypes().setAll(botonMuyBueno, botonBueno, botonRegular, botonMuyMalo);

        //indicamos el resultado
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == botonMuyBueno) {
            //Usuario elige "Muy bueno"
        } else if (resultado.get() == botonBueno) {
            //Usuario elige "Bueno"
        } else if (resultado.get() == botonRegular) {
            //Usuario elige "Regulinchi"
        } else if (resultado.get() == botonMuyMalo) {
            //Usuario elige "Muy malo"
        }
    }

    @FXML
    private void Alert_Informacion(ActionEvent event) {
        informacionDialogo();
    }

    @FXML
    private void Alert_Confirmacion(ActionEvent event) {
        confirmacionDialogo();
    }

    @FXML
    private void Text_Input_Dialog(ActionEvent event) {
    }

    @FXML
    private void Elegir_Dialogo(ActionEvent event) {
    }

    @FXML
    private void Alert_Confirmacion_Varios_Botones(ActionEvent event) {
    }

    @FXML
    private void Alert_Warning(ActionEvent event) {
        warningDialogo();
    }
}
