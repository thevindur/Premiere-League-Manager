package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static sample.PremierLeagueManager.getFootballClubList;

public class GuiTable {
    public static void guiTable(Stage primaryStage) {
        Pane root = new Pane();

        Button back = new Button();
        Image img = new Image("home.png",35,35,false,false);
        ImageView view = new ImageView(img);
        back.setId("Button");
        back.setGraphic(view);
        back.setOnAction(event -> {
            Stage stage = (Stage) back.getScene().getWindow();
            stage.close();
            GuiMain.home(primaryStage);
        });

        Label mainHeading = new Label("Premier League Table");
        mainHeading.setId("MainHeading1");

        HBox Header = HBoxBuilder.create()
                .spacing(320)
                .padding(new Insets(0, 0, 0, 0))
                .children(back,mainHeading)
                .build();

        //Creating the table.
        TableView<Object> tableView = new TableView<>();
        TableColumn<Object, Object> column2 = new TableColumn<>("Club Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        column2.setMinWidth(250);

        TableColumn column3 = new TableColumn<>("Location");
        column3.setCellValueFactory(new PropertyValueFactory<>("clubLocation"));
        column3.setMinWidth(150);

        TableColumn column4 = new TableColumn<>("Seasons Played");
        column4.setCellValueFactory(new PropertyValueFactory<>("noOfSeasonsPlayed"));
        column4.setMinWidth(150);

        TableColumn column5 = new TableColumn<>("Wins");
        column5.setCellValueFactory(new PropertyValueFactory<>("clubWins"));
        column5.setMinWidth(80);

        TableColumn column6 = new TableColumn<>("Defeats");
        column6.setCellValueFactory(new PropertyValueFactory<>("clubDefeat"));
        column6.setMinWidth(80);

        TableColumn column7 = new TableColumn<>("Draws");
        column7.setCellValueFactory(new PropertyValueFactory<>("clubDraws"));
        column7.setMinWidth(80);

        TableColumn column8 = new TableColumn<>("Points");
        column8.setCellValueFactory(new PropertyValueFactory<>("clubPoints"));
        column8.setMinWidth(80);

        TableColumn column9 = new TableColumn<>("Matches Played");
        column9.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));
        column9.setMinWidth(130);

        TableColumn column10 = new TableColumn<>("Goals Received");
        column10.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));
        column10.setMinWidth(130);

        TableColumn column11 = new TableColumn<>("Goals Scored");
        column11.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));
        column11.setMinWidth(110);

        tableView.getColumns().addAll(column2,column3,column4,column5,column6,column7,column8,column9,column10,column11);
        tableView.setId("Table");

        //Inserting data to the table.
        for (int i = 0; i < getFootballClubList().size(); i++) {
            tableView.getItems().add(new FootballClub(getFootballClubList().get(i).getClubName(),
                    getFootballClubList().get(i).getClubLocation(),
                    getFootballClubList().get(i).getNoOfSeasonsPlayed(),
                    getFootballClubList().get(i).getClubWins(),
                    getFootballClubList().get(i).getClubDefeat(),
                    getFootballClubList().get(i).getClubDraws(),
                    getFootballClubList().get(i).getClubPoints(),
                    getFootballClubList().get(i).getNoOfMatchesPlayed(),
                    getFootballClubList().get(i).getGoalsReceived(),
                    getFootballClubList().get(i).getGoalsScored()));
        }

        Button sortGoalsScored = new Button("Sort(Desc) :\nGoals Scored");
        Image img1 = new Image("goals.png",70,70,false,false);
        ImageView view1 = new ImageView(img1);
        sortGoalsScored.setGraphic(view1);
        sortGoalsScored.setId("SortBtn");
        sortGoalsScored.setOnAction(event -> {
            column5.setSortable(false);
            column11.setSortable(true);
            column11.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(column11);
            tableView.sort();
        });

        Button sortLargestNoOfWins = new Button("Sort(Desc) :\nNo of Wins");
        Image img2 = new Image("wins.png",70,70,false,false);
        ImageView view2 = new ImageView(img2);
        sortLargestNoOfWins.setGraphic(view2);
        sortLargestNoOfWins.setId("SortBtn");
        sortLargestNoOfWins.setOnAction(event -> {
            column11.setSortable(false);
            column5.setSortable(true);
            column5.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().add(column5);
            tableView.sort();
        });

        HBox bottomBar = HBoxBuilder.create()
                .spacing(400)
                .padding(new Insets(0, 200, 0, 250))
                .children(sortGoalsScored,sortLargestNoOfWins)
                .build();

        VBox content = VBoxBuilder.create()
                .spacing(70.0)
                .padding(new Insets(50, 25, 20, 25))
                .children(Header,tableView,bottomBar)
                .build();
        content.setId("Content");
        content.setMinSize(1200,700);
        content.setTranslateX(65);
        content.setTranslateY(30);

        HBox bgImage = new HBox();
        bgImage.setId("BgImage");
        bgImage.setMinSize(1450,860);
        bgImage.setTranslateX(0);
        bgImage.setTranslateY(0);

        primaryStage.setTitle("Premier League Championship Table");
        primaryStage.getIcons().add(new Image("logo.png"));
        root.setId("pane");
        Scene scene = new Scene(new Group(root,bgImage,content), 1400, 830);
        scene.getStylesheets().add(Main.class.getResource("style1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
