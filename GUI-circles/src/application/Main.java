package src.application;
	

//import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;


public class Main extends Application {
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	

	
	@Override
	public void start(Stage primaryStage) {
		try {

			
			AnchorPane content = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource
				    ("GUI.fxml"));
			
			
			Scene scene = new Scene(content);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
//			Random r = new Random();
			Group circles = new Group();
			for (int i = 0; i < 30; i++) {
			   Circle circle = new Circle(150, Color.web("black", 0.1));
			   //circle.relocate(r.nextInt(200), r.nextInt(200));
			 
			   circle.setStrokeType(StrokeType.OUTSIDE);
			   circle.setStroke(Color.web("black", 0.16));
			   circle.setStrokeWidth(4);
			   circles.getChildren().add(circle);
			   
			   //circles.setEffect(new BoxBlur(10, 10, 3));
			   //circles.setEffect(new DropShadow(30, Color.web("black", 0.8)));
			}
			
			/*Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
				     new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, 
				    		 new Stop[]{
				            new Stop(0, Color.web("#f8bd55")),
				            new Stop(0.14, Color.web("#c0fe56")),
				            new Stop(0.28, Color.web("#5dfbc1")),
				            new Stop(0.43, Color.web("#64c2f8")),
				            new Stop(0.57, Color.web("#be4af7")),
				            new Stop(0.71, Color.web("#ed5fc2")),
				            new Stop(0.85, Color.web("#ef504c")),
				            new Stop(1, Color.web("#f2660f")),}));
				colors.widthProperty().bind(scene.widthProperty());
				colors.heightProperty().bind(scene.heightProperty());
			
			content.getChildren().add(colors);*/
			content.getChildren().add(circles);
				
		/*Group blendModeGroup = 
			    new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
			        Color.BLACK), circles), colors);
			colors.setBlendMode(BlendMode.OVERLAY);//SCREEN
			content.getChildren().add(blendModeGroup);*/
			
			
			/*Timeline timeline = new Timeline();
			for (Node circle: circles.getChildren()) {
			    timeline.getKeyFrames().addAll(
			        new KeyFrame(Duration.ZERO, // set start position at 0
			            new KeyValue(circle.translateXProperty(), r.nextDouble()*800),
			            new KeyValue(circle.translateYProperty(), r.nextDouble()*600)
			        ),
			        new KeyFrame(new Duration(40000), // set end position at 40s
			            new KeyValue(circle.translateXProperty(), r.nextDouble()*800),
			            new KeyValue(circle.translateYProperty(), r.nextDouble()*600)
			        )
			    );
			}
			// play 40s of animation
			timeline.play();*/
			
			
			primaryStage.show();
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
			
		

	
	
}
