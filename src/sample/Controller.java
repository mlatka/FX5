package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    @FXML
    private TextField txtAge;

    public TextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(TextField txtAge) {
        this.txtAge = txtAge;
    }

    @FXML
    private TextField txtWeight;

    @FXML
    private TextField txtHeight;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextArea txtAreaResults;

    @FXML
    void btnCalculateClicked(ActionEvent event) {

        StringBuilder message = new StringBuilder();
        try {
            int age = Integer.parseInt(txtAge.getText());
            message.append("Age= " + age);

            double weight = Double.parseDouble(txtWeight.getText());
            message.append(" Weight= " + weight);


        } catch (IllegalArgumentException ex) {
            message = new StringBuilder("Invalid arguments");
        }
        txtAreaResults.appendText(message.toString() + '\n');

    }


    @FXML
    void getParametersClicked(ActionEvent event) throws Exception {

        /*
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                Test.class.getResource("test.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow() );
        stage.show();

       */


        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "test.fxml"
                )
        );

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(
                new Scene(
                        (AnchorPane) loader.load()
                )
        );

        Test test= loader.<Test>getController();
        test.setA(100);
        System.out.println(test.getA());
        test.updateValues();

        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.showAndWait(); // to jest ważne !!!

        System.out.println("Testing");
       System.out.println(test.getA());
       System.out.println(test.getB());


    }

}
