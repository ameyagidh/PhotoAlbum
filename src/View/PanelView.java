package View;

import Models.*;
import Models.Rectangle;

import javax.swing.*;
import java.awt.*;

public class PanelView extends JPanel {
  private SnapShot snapshot;

  public PanelView(SnapShot snapshot) {
    this.snapshot = snapshot;
  }

  public void setSnapshot(SnapShot snapshot) {
    this.snapshot = snapshot;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IShape shape : this.snapshot.getPhotoAlbum_obj().getShapesList()) {
      if (shape.getType().equals("rectangle")) {
        Rectangle rectangle = (Rectangle) shape;
        int red = (int) rectangle.getColor().getRed();
        int green = (int) rectangle.getColor().getGreen();
        int blue = (int) rectangle.getColor().getBlue();
        java.awt.Color color = new java.awt.Color(red, green, blue);
        g.setColor(color);
        int x_cordinate = (int) rectangle.getX();
        int y_cordinate = (int) rectangle.getY();
        int width = (int) rectangle.getSize1();
        int height = (int) rectangle.getSize2();
        g.fillRect(x_cordinate, y_cordinate, width, height);
      }
      if (shape.getType().equals("oval")) {
        Oval oval = (Oval) shape;
        int red = (int) oval.getColor().getRed();
        int green = (int) oval.getColor().getGreen();
        int blue = (int) oval.getColor().getBlue();
        java.awt.Color color = new java.awt.Color(red, green, blue);
        g.setColor(color);
        int x_cordinate = (int) oval.getX();
        int y_cordinate = (int) oval.getY();
        int radius1 = (int) oval.getSize1();
        int radius2 = (int) oval.getSize2();
        g.fillOval(x_cordinate, y_cordinate, radius1, radius2);
      }
    }
  }
}

