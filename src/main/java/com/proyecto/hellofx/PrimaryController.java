package com.proyecto.hellofx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

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
    @FXML
    private TextArea etiquetaRespuestas;

    private void informacionDialogo() {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Bienvenido al curso de JAVA FX");
        alert.setContentText("En este tema veremos las ventanas de diálogo");

        etiquetaRespuestas.setText("Ha pulsado el botón de 'Alerta Información'." + "\nMuchas gracias por usar nuestra aplicación.");

        alert.showAndWait();
    }

    private void warningDialogo() {

        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Módulo de Programación");
        alert.setHeaderText("Ventana de aviso de algún peligro(WARNING)");
        alert.setContentText("Si te equivocas saldrá esta ventana");

        etiquetaRespuestas.setText("Ha pulsado el botón de 'Alerta Warning'." + "\nMuchas gracias por usar nuestra aplicación.");

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
        ButtonType botonAbstencion = new ButtonType("Me abstengo", ButtonData.CANCEL_CLOSE); //indicamos que es un boton cancel_close

        //indicamos que botones se mostrarán en la alerta
        alert.getButtonTypes().setAll(botonSi, botonNo, botonAbstencion);

        //indicamos el resultado
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.get() == botonSi) {
            //Usuario elige "SI"

            //Dentro, creamos el dialogo de información correspondiente al botón "si"
            Alert meAlegro = new Alert(AlertType.INFORMATION);
            meAlegro.setTitle("Módulo de Programación");
            meAlegro.setHeaderText("Me alegro!");

            etiquetaRespuestas.setText("Has seleccionado: Si. " + "\nNos alegra saber que le ha gustado." + "\nMuchas gracias por su elección.");

            meAlegro.showAndWait();

        } else if (resultado.get() == botonNo) {
            //Usuario elige "NO"

            //Dentro, creamos el dialogo de información correspondiente al botón "no"
            Alert mejorar = new Alert(AlertType.ERROR);
            mejorar.setTitle("Módulo de Programación");
            mejorar.setHeaderText("Intentaremos mejorar!");

            etiquetaRespuestas.setText("Has seleccionado: No. " + "\nLamentamos saber que no le ha gustado. Intentaremos mejorar." + "\nMuchas gracias por su elección.");

            mejorar.showAndWait();

        } else if (resultado.get() == botonAbstencion) {
            //Usuario elige "Me abstengo"

            //Dentro, creamos el dialogo de información correspondiente al botón "no"
            Alert abstencion = new Alert(AlertType.WARNING);
            abstencion.setTitle("Módulo de Programación");
            abstencion.setHeaderText("Necesitamos tu opinión!");

            etiquetaRespuestas.setText("Has seleccionado: Me abstengo." + "\nDebe elegir una opción valida.");

            abstencion.showAndWait();
            confirmacionDialogo();

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
            etiquetaRespuestas.setText("Ha seleccionado: Muy bueno." + "\nMuchas gracias por su respuesta.");

        } else if (resultado.get() == botonBueno) {
            //Usuario elige "Bueno"
            etiquetaRespuestas.setText("Ha seleccionado: Bueno." + "\nMuchas gracias por su respuesta.");

        } else if (resultado.get() == botonRegular) {
            //Usuario elige "Regulinchi"
            etiquetaRespuestas.setText("Ha seleccionado: Regulinchi." + "\nMuchas gracias por su respuesta.");
        } else if (resultado.get() == botonMuyMalo) {
            //Usuario elige "Muy malo"
            etiquetaRespuestas.setText("Ha seleccionado: Muy Malo." + "\nMuchas gracias por su respuesta.");
        }
    }

    public void texInputDialogo() {
        TextInputDialog dialog = new TextInputDialog("Aquí escribe tu nombre");
        dialog.setTitle("Modulo de Programación");
        dialog.setHeaderText("Ventana para solicitar tu nombre");
        dialog.setContentText("Nombre");

        //Se pueden recoger los datos de 2 formas. En ambas, hay que declarar lo siguiente primero:
        Optional<String> result = dialog.showAndWait();

        //Una forma sería:
        if (result.isPresent() == true && !result.isEmpty()) {
            //si introduce un resultado
            etiquetaRespuestas.setText("Tu nombre: " + result.get() + "\nMuchas gracias " + result.get() + " por su respuesta.");

        } else if (result.isPresent() == false) {
            //si se le da a cancel

            Alert repetir = new Alert(AlertType.WARNING);
            repetir.setTitle("Módulo de Programación");
            repetir.setHeaderText("DEBES ESCRIBIR TU NOMBRE");

            ButtonType botonAceptar = new ButtonType("Aceptar");

            repetir.getButtonTypes().setAll(botonAceptar);

            Optional<ButtonType> resultado = repetir.showAndWait();

            if (resultado.get() == botonAceptar) {
                //Usuario elige "Aceptar"
                texInputDialogo();
            }

        }

        //Con Java 8, la otra forma podría hacerse:
//        result.ifPresent(nombre -> System.out.print("Tu nombre: " + nombre));
    }

    public void elegirOpcionDialogo() {
        List<String> eleccion = new ArrayList<>();
        eleccion.add("Muy bueno");
        eleccion.add("Bueno");
        eleccion.add("Malo");
        eleccion.add("Muy malo");

        ChoiceDialog<String> dialogo = new ChoiceDialog<>("Bueno", eleccion);
        dialogo.setTitle("Modulo de Programación");
        dialogo.setHeaderText("Deseamos tu opinión");
        dialogo.setContentText("Elige una opción");

        //Se pueden recoger los datos de 2 formas. En ambas, hay que declarar lo siguiente primero:
        Optional<String> result = dialogo.showAndWait();

        //Una forma sería:
        if (result.isPresent() == true && !result.isEmpty()) {
            //si introduce un resultado
            etiquetaRespuestas.setText("Has seleccionado: " + result.get() + "\nMuchas gracias por su elección.");

        } else if (result.isPresent() == false) {
            //si se le da a cancel

            Alert repetir = new Alert(AlertType.WARNING);
            repetir.setTitle("Módulo de Programación");
            repetir.setHeaderText("DEBES ELEGIR UNA OPCIÓN");

            ButtonType botonAceptar = new ButtonType("Aceptar");

            repetir.getButtonTypes().setAll(botonAceptar);

            Optional<ButtonType> resultado = repetir.showAndWait();

            if (resultado.get() == botonAceptar) {
                //Usuario elige "Aceptar"
                elegirOpcionDialogo(); //Le devolvemos al menú de dialogos
            }

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
        texInputDialogo();

    }

    @FXML
    private void Elegir_Dialogo(ActionEvent event) {
        elegirOpcionDialogo();
    }

    @FXML
    private void Alert_Confirmacion_Varios_Botones(ActionEvent event) {
        confirmacionVariosBotonesDialogo();
    }

    @FXML
    private void Alert_Warning(ActionEvent event) {
        warningDialogo();
    }
}
