package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static sample.PremierLeagueManager.*;

public class GuiMatch {
    private final static PremierLeagueManager manager = new PremierLeagueManager();
    static Random randomClub = new Random();
    public static void guiMatch(Stage primaryStage) {
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

        Label mainHeading = new Label("Premier League Match Statistics");
        mainHeading.setId("MainHeading1");

        HBox Header = HBoxBuilder.create()
                .spacing(100)
                .padding(new Insets(0, 0, 0, 0))
                .children(back,mainHeading)
                .build();

        TextField searchValue = new TextField();
        searchValue.setId("SearchBox");
        searchValue.setPromptText("DD-MM-YYYY");

        Button searchBtn = new Button("Search");
        Image img1 = new Image("search.png",25,25,false,false);
        ImageView view1 = new ImageView(img1);
        searchBtn.setGraphic(view1);
        searchBtn.setId("SearchBtn");
        searchBtn.setOnAction(event -> {
            if(searchValue.getText().isEmpty()){
                Alert newAlert = new Alert(Alert.AlertType.WARNING,"Please enter the date you want to search !!",ButtonType.OK);
                newAlert.show();
            }else{
                String Date = searchValue.getText();
                boolean flag = false;
                List<Integer> indexList = new ArrayList<>();
                for (int i = 0; i < footballFootBallMatchList.size(); i++){
                    try {
                        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(Date);
                        if (newDate.equals(footballFootBallMatchList.get(i).getMatchDate())){
                            flag = true;
                            indexList.add(i);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                if (!flag){
                    Alert newAlert = new Alert(Alert.AlertType.WARNING,"There are no Matches played on that Date.",ButtonType.OK);
                    newAlert.show();
                }else{
                    Stage stage = new Stage();
                    Pane newPane = new Pane();

                    Label heading = new Label("Search Results for '" + Date + "' ");
                    heading.setId("SearchHeading");

                    TableView tableView = new TableView();

                    TableColumn column1 = new TableColumn<>("Club One Name");
                    column1.setCellValueFactory(new PropertyValueFactory<>("clubOneName"));
                    column1.setMinWidth(250);

                    TableColumn column2 = new TableColumn<>("Club Two Name");
                    column2.setCellValueFactory(new PropertyValueFactory<>("clubTwoName"));
                    column2.setMinWidth(250);

                    TableColumn column3 = new TableColumn<>("Club One Score");
                    column3.setCellValueFactory(new PropertyValueFactory<>("clubOneScore"));
                    column3.setMinWidth(140);

                    TableColumn column4 = new TableColumn<>("Club Two Score");
                    column4.setCellValueFactory(new PropertyValueFactory<>("clubTwoScore"));
                    column4.setMinWidth(140);

                    TableColumn column5 = new TableColumn<>("Date Played");
                    column5.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
                    column5.setMinWidth(260);

                    tableView.getColumns().addAll(column1,column2,column3,column4,column5);
                    tableView.setMaxWidth(1060);
                    tableView.setMaxHeight(265);
                    tableView.setId("Table");

                    for (int i = 0; i < indexList.size(); i++) {
                        tableView.getItems().add(new FootBallMatch(getFootballMatchList().get(indexList.get(i)).getClubOneName(),
                                getFootballMatchList().get(indexList.get(i)).getClubTwoName(),
                                getFootballMatchList().get(indexList.get(i)).getClubOneScore(),
                                getFootballMatchList().get(indexList.get(i)).getClubTwoScore(),
                                getFootballMatchList().get(indexList.get(i)).getMatchDate()));
                    }

                    VBox content1 = VBoxBuilder.create()
                            .spacing(30.0)
                            .padding(new Insets(30, 25, 10, 25))
                            .children(heading,tableView)
                            .build();
                    content1.setId("Content1");
                    content1.setMinSize(1150,450);

                    stage.setTitle("Search Results");
                    stage.getIcons().add(new Image("search.png"));
                    Scene scene = new Scene(new Group(newPane,content1), 1100, 400);
                    scene.getStylesheets().add(Main.class.getResource("style1.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                }
            }
        });

        HBox leftAlign = HBoxBuilder.create()
                .spacing(10)
                .padding(new Insets(0, 200, 0, 0))
                .children(searchValue,searchBtn)
                .build();

        //Creating the table.
        TableView tableView = new TableView();

        TableColumn column1 = new TableColumn<>("Club One Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("clubOneName"));
        column1.setMinWidth(250);

        TableColumn column2 = new TableColumn<>("Club Two Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("clubTwoName"));
        column2.setMinWidth(250);

        TableColumn column3 = new TableColumn<>("Club One Score");
        column3.setCellValueFactory(new PropertyValueFactory<>("clubOneScore"));
        column3.setMinWidth(150);

        TableColumn column4 = new TableColumn<>("Club Two Score");
        column4.setCellValueFactory(new PropertyValueFactory<>("clubTwoScore"));
        column4.setMinWidth(150);

        TableColumn column5 = new TableColumn<>("Date Played");
        column5.setCellValueFactory(new PropertyValueFactory<>("matchDate"));
        column5.setMinWidth(250);

        tableView.getColumns().addAll(column1,column2,column3,column4,column5);
        tableView.setMaxWidth(1055);
        tableView.setId("Table");

        for (int i = 0; i < getFootballMatchList().size(); i++) {
            tableView.getItems().add(new FootBallMatch(getFootballMatchList().get(i).getClubOneName(),
                    getFootballMatchList().get(i).getClubTwoName(),
                    getFootballMatchList().get(i).getClubOneScore(),
                    getFootballMatchList().get(i).getClubTwoScore(),
                    getFootballMatchList().get(i).getMatchDate()));
        }

        Button sortDate = new Button("Sort : Date Played");
        Image img2 = new Image("sort.png",25,25,false,false);
        ImageView view2 = new ImageView(img2);
        sortDate.setGraphic(view2);
        sortDate.setId("SortBtn1");
        sortDate.setOnAction(event -> {
            column5.setSortType(TableColumn.SortType.ASCENDING);
            tableView.getSortOrder().add(column5);
            tableView.sort();
        });

        //Creating the random part.
        Label lblClubOneName = new Label("Club One Name : ");
        lblClubOneName.setId("MainLbl");
        Label lblClubTwoName = new Label("Club Two Name : ");
        lblClubTwoName.setId("MainLbl");
        Label lblClubOneScore= new Label("Club One Score : ");
        lblClubOneScore.setId("MainLbl");
        Label lblClubTwoScore= new Label("Club Two Score : ");
        lblClubTwoScore.setId("MainLbl");
        Label lblDate= new Label("Match Played Date : ");
        lblDate.setId("MainLbl");

        Text txtClubOneName = new Text("                                                   ");
        txtClubOneName.setId("MainLbl");
        Text txtClubTwoName = new Text("");
        txtClubTwoName.setId("MainLbl");
        Text txtClubOneScore = new Text("                                                   ");
        txtClubOneScore.setId("MainLbl");
        Text txtClubTwoScore = new Text("");
        txtClubTwoScore.setId("MainLbl");
        Text txtDate = new Text("                                                   ");
        txtDate.setId("MainLbl");

        GridPane gridPaneMatch = new GridPane();
        gridPaneMatch.setId("Result");
        gridPaneMatch.setHgap(20);
        gridPaneMatch.setVgap(40);

        gridPaneMatch.add(lblClubOneName,0,0);
        gridPaneMatch.add(txtClubOneName,1,0);
        gridPaneMatch.add(lblClubTwoName,2,0);
        gridPaneMatch.add(txtClubTwoName,3,0);
        gridPaneMatch.add(lblClubOneScore,0,1);
        gridPaneMatch.add(txtClubOneScore,1,1);
        gridPaneMatch.add(lblClubTwoScore,2,1);
        gridPaneMatch.add(txtClubTwoScore,3,1);
        gridPaneMatch.add(lblDate,0,2);
        gridPaneMatch.add(txtDate,1,2);

        //Coding for the random part.
        Button random = new Button("Random Match");
        Image img3 = new Image("random.png",25,25,false,false);
        ImageView view3 = new ImageView(img3);
        random.setId("SortBtn1");
        random.setGraphic(view3);
        random.setOnAction(event -> {
            int a = randomClub.nextInt(getFootballClubList().size());
            int b = randomClub.nextInt(getFootballClubList().size());

            if(a == b){
                b = randomClub.nextInt(getFootballClubList().size());
            }else{
                int randomScoreOne = randomClub.nextInt(10);
                int randomScoreTwo = randomClub.nextInt(10);
                int randomDay = 1 + randomClub.nextInt(28);
                int randomMonth = 1 + randomClub.nextInt(12);
                int randomYear = 2010 + randomClub.nextInt(2020-2010);

                String randomDate = randomDay + "-" + randomMonth + "-" + randomYear;
                try {
                    Date newRanDate = new SimpleDateFormat("dd-MM-yyyy").parse(randomDate);
                    FootBallMatch match = new FootBallMatch();

                    txtClubOneName.setText(getFootballClubList().get(a).getClubName());
                    txtClubTwoName.setText(getFootballClubList().get(b).getClubName());
                    txtClubOneScore.setText(String.valueOf(randomScoreOne));
                    txtClubTwoScore.setText(String.valueOf(randomScoreTwo));
                    txtDate.setText(String.valueOf(newRanDate));

                    match.setMatchDate(newRanDate);
                    match.setClubOneScore(randomScoreOne);
                    match.setClubTwoScore(randomScoreTwo);
                    match.setClubOneName(getFootballClubList().get(a).getClubName());
                    match.setClubTwoName(getFootballClubList().get(b).getClubName());

                    if (randomScoreOne>randomScoreTwo){
                        getFootballClubList().get(a).setClubWins(getFootballClubList().get(a).getClubWins() + 1);
                        getFootballClubList().get(a).setClubPoints(getFootballClubList().get(a).getClubPoints()+3);
                        getFootballClubList().get(a).setNoOfMatchesPlayed(getFootballClubList().get(a).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(a).setGoalsReceived(getFootballClubList().get(a).getGoalsReceived()+randomScoreTwo);
                        getFootballClubList().get(a).setGoalsScored(getFootballClubList().get(a).getGoalsScored()+randomScoreOne);

                        getFootballClubList().get(b).setClubDefeat(getFootballClubList().get(b).getClubDefeat() + 1);
                        getFootballClubList().get(b).setNoOfMatchesPlayed(getFootballClubList().get(b).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(b).setGoalsReceived(getFootballClubList().get(b).getGoalsReceived()+randomScoreOne);
                        getFootballClubList().get(b).setGoalsScored(getFootballClubList().get(b).getGoalsScored()+randomScoreTwo);
                    }else if (randomScoreTwo>randomScoreOne){
                        getFootballClubList().get(b).setClubWins(getFootballClubList().get(b).getClubWins() + 1);
                        getFootballClubList().get(b).setClubPoints(getFootballClubList().get(b).getClubPoints()+3);
                        getFootballClubList().get(b).setNoOfMatchesPlayed(getFootballClubList().get(b).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(b).setGoalsReceived(getFootballClubList().get(b).getGoalsReceived()+randomScoreOne);
                        getFootballClubList().get(b).setGoalsScored(getFootballClubList().get(b).getGoalsScored()+randomScoreTwo);

                        getFootballClubList().get(a).setClubDefeat(getFootballClubList().get(a).getClubDefeat() + 1);
                        getFootballClubList().get(a).setNoOfMatchesPlayed(getFootballClubList().get(a).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(a).setNoOfMatchesPlayed(getFootballClubList().get(a).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(a).setGoalsReceived(getFootballClubList().get(a).getGoalsReceived()+randomScoreTwo);
                        getFootballClubList().get(a).setGoalsScored(getFootballClubList().get(a).getGoalsScored()+randomScoreOne);
                    }else{
                        getFootballClubList().get(b).setClubDraws(getFootballClubList().get(b).getClubDraws() + 1);
                        getFootballClubList().get(b).setClubPoints(getFootballClubList().get(b).getClubPoints()+1);
                        getFootballClubList().get(b).setNoOfMatchesPlayed(getFootballClubList().get(b).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(b).setGoalsReceived(getFootballClubList().get(b).getGoalsReceived()+randomScoreOne);
                        getFootballClubList().get(b).setGoalsScored(getFootballClubList().get(b).getGoalsScored()+randomScoreTwo);

                        getFootballClubList().get(a).setClubDraws(getFootballClubList().get(a).getClubDraws() + 1);
                        getFootballClubList().get(a).setClubPoints(getFootballClubList().get(a).getClubPoints()+1);
                        getFootballClubList().get(a).setNoOfMatchesPlayed(getFootballClubList().get(a).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(a).setNoOfMatchesPlayed(getFootballClubList().get(a).getNoOfMatchesPlayed()+1);
                        getFootballClubList().get(a).setGoalsReceived(getFootballClubList().get(a).getGoalsReceived()+randomScoreTwo);
                        getFootballClubList().get(a).setGoalsScored(getFootballClubList().get(a).getGoalsScored()+randomScoreOne);
                    }
                    FootBallMatch footBallMatch = new FootBallMatch(getFootballClubList().get(a).getClubName(), getFootballClubList().get(b).getClubName(), randomScoreOne, randomScoreTwo, newRanDate);
                    footballFootBallMatchList.add(footBallMatch);
                    tableView.getItems().add(new FootBallMatch(getFootballClubList().get(a).getClubName(),
                            getFootballClubList().get(b).getClubName(),
                            randomScoreOne,
                            randomScoreTwo,
                            newRanDate));
                    try {
                        manager.saveToFile();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

        HBox rightAlign = HBoxBuilder.create()
                .spacing(50)
                .padding(new Insets(0, 0, 0, 0))
                .children(sortDate,random)
                .build();

        HBox topBar = HBoxBuilder.create()
                .spacing(10)
                .padding(new Insets(0, 0, 0, 0))
                .children(leftAlign,rightAlign)
                .build();


        HBox bottomBar = HBoxBuilder.create()
                .spacing(80)
                .padding(new Insets(0, 0, 0, 0))
                .children(gridPaneMatch)
                .build();

        //Inserting content to the vbox.
        VBox content = VBoxBuilder.create()
                .spacing(30.0)
                .padding(new Insets(30, 25, 10, 25))
                .children(Header,topBar,tableView,bottomBar)
                .build();
        content.setId("Content");
        content.setMinSize(1100,900);
        content.setTranslateX(65);
        content.setTranslateY(30);

        HBox bgImage = new HBox();
        bgImage.setId("BgImage2");
        bgImage.setMinSize(1600,1300);
        bgImage.setTranslateX(0);
        bgImage.setTranslateY(0);

        primaryStage.setTitle("Premier League Championship Matches");
        primaryStage.getIcons().add(new Image("logo.png"));
        root.setId("pane");
        Scene scene = new Scene(new Group(root,bgImage,content), 1200, 950);
        scene.getStylesheets().add(Main.class.getResource("style1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
