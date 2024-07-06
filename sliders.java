import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class sliders extends Application {
	protected Text color_display = new Text("Color display");
	protected Slider opacity_slider = new Slider();
	protected Slider green_slider = new Slider();
	protected Slider blue_slider = new Slider();
	protected Slider red_slider = new Slider();
	
	
	@Override
	public void start(Stage primaryStage){
		StackPane text_area = new StackPane(color_display);
		text_area.setPadding(new Insets(10, 10, 10, 10));
		opacity_slider.setMin(0.0);
		opacity_slider.setMax(1.0);
		green_slider.setMin(0.0);
		green_slider.setMax(1.0);
		blue_slider.setMin(0.0);
		blue_slider.setMax(1.0);
		red_slider.setMin(0.0);
		red_slider.setMax(1.0);
		opacity_slider.valueProperty().addListener(ov -> color_setter());
		opacity_slider.setValue(1);
		green_slider.valueProperty().addListener(ov -> color_setter());
		blue_slider.valueProperty().addListener(ov -> color_setter());
		red_slider.valueProperty().addListener(ov -> color_setter());
		GridPane slider_area = new GridPane();
		slider_area.setAlignment(Pos.CENTER);
		slider_area.setVgap(5);
		slider_area.setHgap(5);
		slider_area.add(new Label("Opacity"), 0, 3);
		slider_area.add(opacity_slider, 1, 3);
		slider_area.add(new Label("Green"), 0, 1);
		slider_area.add(green_slider, 1, 1);
		slider_area.add(new Label("Blue"), 0, 2);
		slider_area.add(blue_slider, 1, 2);
		slider_area.add(new Label("Red"), 0, 0);
		slider_area.add(red_slider, 1, 0);
		BorderPane area = new BorderPane();
		area.setTop(paneForText);
		area.setCenter(slider_area);
		Scene scene = new Scene(area, 250, 150);
		primaryStage.setTitle("Color Sliders");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void color_setter() {
		color_display.setFill(new Color(red_slider.getValue(), green_slider.getValue(), blue_slider.getValue(), opacity_slider.getValue()));
	}
}