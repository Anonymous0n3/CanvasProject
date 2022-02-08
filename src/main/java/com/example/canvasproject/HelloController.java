package com.example.canvasproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {
    @FXML
    public Canvas canvas;

    public AnchorPane mainLayout;

    GraphicsContext gc;

    ArrayList<Entity> entities;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entities = new ArrayList<>();
        gc = canvas.getGraphicsContext2D();
    }

    public void setPoints(int points){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<points; i++){

            System.out.println("Zadej souřadnici x");
            double x = Integer.parseInt(sc.nextLine());

            System.out.println("Zadej souřadnici y");
            double y = Integer.parseInt(sc.nextLine());

            double w = 30;

            entities.add(new Entity(x,y,w,w, Paint.valueOf("RED")));
        }
        render();
        drawLines();
    }

    private void render() {
        entities.forEach(obj -> {
            obj.render(gc);
        });
    }

    public void setPoints(ActionEvent actionEvent) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Zadejte počet bodů na vykreslení");

        setPoints(Integer.parseInt(sc1.nextLine()));
    }

    private void drawLines(){
        if (entities.size() > 1){
            for (Entity entity : entities){
                for(Entity entity1 : entities){
                    if (entity.equals(entity1)){
                    }else{
                        gc.setLineWidth(4);
                        gc.moveTo(0,0);
                        gc.strokeLine(entity.getX() + entity.getW() / 2,entity.getY() + entity.getH() / 2,entity1.getX() + entity1.getW() / 2,entity1.getY() + entity1.getH() / 2);
                    }
                }
            }

        }
    }
}