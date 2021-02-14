package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuiMain {
    public static void home(Stage primaryStage){
        Pane root = new Pane();

        Button table = new Button(" View Premier\n League Table");
        Image img = new Image("table.png",100,100,false,false);
        ImageView view = new ImageView(img);
        view.setId("view");
        table.setId("Button");
        table.setLayoutX(200);
        table.setLayoutY(750);
        table.setGraphic(view);
        root.getChildren().add(table);
        table.setOnAction(event -> {
            Stage stage = (Stage) table.getScene().getWindow();
            stage.close();
            GuiTable.guiTable(primaryStage);
        });

        Button match = new Button("   View Matches");
        Image img1 = new Image("match.png",100,100,false,false);
        ImageView view1 = new ImageView(img1);
        match.setId("Button");
        match.setLayoutX(750);
        match.setLayoutY(750);
        match.setGraphic(view1);
        root.getChildren().add(match);
        match.setOnAction(event -> {
            Stage stage = (Stage) match.getScene().getWindow();
            stage.close();
            GuiMatch.guiMatch(primaryStage);
        });

        primaryStage.setTitle("Premier League Championship Home");
        primaryStage.getIcons().add(new Image("logo.png"));
        root.setId("pane");
        Scene scene = new Scene(root, 1200, 900);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
