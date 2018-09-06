import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class financialCalculator extends Application{

Label label1,label2,label3,label4,label5;
TextField textField1, textField2, textField3, textField4;
Button button;

    public static void main(String[] args) {
   launch(args);
    }
    
    double future_value=0.0,investment_amount=0.0,annual_rate=0.0,interest_rate_per_month=0.0;
    int years=0;
    
	@Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gPane = new GridPane();
        
        gPane.setAlignment(Pos.CENTER);
        gPane.setHgap(5);
        gPane.setVgap(5);
        
        gPane.add(label1=new Label("Investment Amount: "),0,0);
        gPane.add(textField1=new TextField(),1,0);
              
        gPane.add(label2=new Label("Number of Years: "),0,1);
        gPane.add(textField2=new TextField(),1,1);
        
        gPane.add(label3=new Label("Annual Interest Rate: "),0,2);
        gPane.add(textField3=new TextField(),1,2);
        
        gPane.add(label4=new Label("Future Value: "),0,3);
        gPane.add(textField4=new TextField(),1,3);
        
        gPane.add(button= new Button("Calculate"),1,4);
        gPane.add(label5= new Label(),1,4);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            DecimalFormat decimalFormat= new DecimalFormat("#.##");
            
            @Override
            public void handle(ActionEvent event) {

            	investment_amount= Double.parseDouble(textField1.getText());
            	years=Integer.parseInt(textField2.getText());
            	annual_rate= Double.parseDouble(textField3.getText());
                
                interest_rate_per_month = (annual_rate/1200);
                
                future_value = investment_amount*(Math.pow((1+interest_rate_per_month),years*12));
                
                textField4.setText("$"+decimalFormat.format(future_value));
                
                textField4.setEditable(false);
            }
        });
        Scene scene = new Scene(gPane,500,400);
        primaryStage.setTitle("financialCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}