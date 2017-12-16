import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class InsideAPolygon extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Pane paneObj=new Pane();
        Polygon polygon=new Polygon();
        paneObj.getChildren().add(polygon);
        ObservableList<Double> list=polygon.getPoints();
        list.addAll(40.0,20.0,70.0,40.0,60.0,80.0,45.0,20.0,60.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        paneObj.setOnMouseMoved(e ->
        {
            paneObj.getChildren().clear();;
            Text text=new Text(e.getX(),e.getY(),"Mouse point is"+(polygon.contains(e.getX(),e.getY())?"inside":"outside")+"the Polygon");
            paneObj.getChildren().addAll(polygon,text);
        });
        //Scene and place
        Scene scene=new Scene(paneObj,300,150);
        primaryStage.setTitle("Excercise15_14");
        primaryStage.setScene(scene);
        primaryStage.show();;
    }
    public void main (String []args){
        launch(args);
    }
}
