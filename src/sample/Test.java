package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Test {


    private  int a;
    private int b;

    public Test() {

        System.out.println("Calling constructor");
        a=10;
        b=20;

    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }


    @FXML
    private Button btnClose;

    @FXML
    private TextField txtA= new TextField("ala");

    @FXML
    private TextField txtB;

    @FXML
    void CloseClick(ActionEvent event) {


        a+=10;
        b+=50;
        System.out.println("a= " + a);
        System.out.println("b= " + b);
        updateValues();

        /*
        Stage stage = (Stage) btnClose.getScene().getWindow();
        System.out.println("closing");
        stage.close();

        */








    }

    @FXML
    public void initialize() {
        System.out.println("FXML initialization");

       // txtA= new TextField(Integer.toString(a));
        //txtB=new TextField(Integer.toString(b));

    }


    public void updateValues(){
        txtA.setText(Integer.toString(a));
        txtB.setText(Integer.toString(b));

    }

}