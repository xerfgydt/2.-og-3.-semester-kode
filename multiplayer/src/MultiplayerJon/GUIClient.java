package MultiplayerJon;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class GUIClient extends Application {
    private PrintWriter pw;
    private double width = 500;
    private double height = 500;
    private GraphicsContext graphicsContext;
    public static void main(String[] args) {
        Application.launch(args); // vi starter "manuelt"
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Lav Container
        VBox vBox = new VBox();

        //2. Lav GUI element. Noget synligt
        makeGUIElements(vBox);

        //3. Lav Scene
        Scene scene = new Scene(vBox, width,height + 100 );
        scene.setOnKeyPressed(event -> {
            this.handleKeyPressed(event);
        });

        //4. Angiv Scene i Stage
        primaryStage.setScene(scene);

        // 5. Kald på Stage.show()
        primaryStage.show();
    }

    private void handleKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case UP: pw.println("UP"); break;
            case DOWN: pw.println("DOWN"); break;
            case LEFT: pw.println("LEFT"); break;
            case RIGHT: pw.println("RIGHT"); break;

        }
    }

    private void makeGUIElements(VBox vBox) {
        TextField nameField = new TextField();
        nameField.setPromptText("indtast navn");
        TextField redField = new TextField();
        redField.setPromptText("indtast rød 0-255");
        TextField greenField = new TextField();
        greenField.setPromptText("indtast grøn 0-255");
        TextField blueField = new TextField();
        blueField.setPromptText("indtast blå 0-255");
        Label label = new Label("Brug pilene til at styre din player");
        Button connectBtn = new Button("Forbind");
        connectBtn.setOnAction(event -> {
            System.out.println("de har trykket på mig!");
            // Opret forbindelse til Houston 192.168.0.8
            // Skal sende med følgende protokol:
            this.connectToServer();
            pw.println(nameField.getText()); // send navn til serveren
            // 2. send farver (rgb) på en seperat linie "12,144,54"
            String color = redField.getText() + "," + greenField.getText() +
                    "," + blueField.getText();
            pw.println(color);
            nameField.setDisable(true);
            redField.setDisable(true);
            greenField.setDisable(true);
            blueField.setDisable(true);
        });
        vBox.getChildren().addAll(nameField,redField, greenField, blueField,label);
        vBox.getChildren().addAll(connectBtn);
        // opret Canvas
        Canvas canvas = new Canvas(width,height);
        // håndtere Mouse events:

        EventHandler<MouseEvent> mousePressedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                graphicsContext.beginPath();
                graphicsContext.moveTo(event.getX(), event.getY());
            }
        };
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mousePressedHandler);

        EventHandler<MouseEvent> mouseDraggedHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                graphicsContext.lineTo(event.getX(), event.getY());
                graphicsContext.stroke(); // tegner fra sidste point i Path til x,y
            }
        };

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDraggedHandler);


        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.BLUE); // sætter farve på stregen
        graphicsContext.setLineWidth(2);

        vBox.getChildren().add(canvas);

    }

    private void connectToServer(){
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.0.8");
            Socket socket = new Socket(inetAddress, 6780);
            pw = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("har forbindelse til server");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}