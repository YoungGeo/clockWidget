
package george;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Widget extends Application {
	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load((URL) this.getClass().getResource("FXMLDocument.fxml"));
		Scene scene = new Scene(root);
		scene.setFill((Paint) Color.TRANSPARENT);
		stage.setTitle("Clock");
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.show();
	}

	public static void main(String[] args) {
		Widget.launch((String[]) args);
	}
}
