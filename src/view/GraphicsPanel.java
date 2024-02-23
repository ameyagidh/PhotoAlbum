package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JPanel;

import model.IShape;
import model.Snapshot;

/**
 * The type Graphics panel.
 */
public class GraphicsPanel extends JPanel {
  private Snapshot currentSnapshot;

  /**
   * Instantiates a new Graphics panel.
   *
   * @param currentSnapshot the current snapshot
   */
  public GraphicsPanel(Snapshot currentSnapshot) {
    this.currentSnapshot = currentSnapshot;
    setBackground(Color.WHITE);
  }

  /**
   * Update panel.
   *
   * @param snapshot the snapshot
   */
  public void updatePanel(Snapshot snapshot) {
    this.currentSnapshot = snapshot;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    List<IShape> currentShapes = currentSnapshot.getCurrentAlbumShapes().values().stream().collect
            (Collectors.toUnmodifiableList());
    for (IShape shape : currentShapes) {
      if (shape.getClass().equals(model.Rectangle.class)) {
        g.setColor(new Color((int) shape.getColor().getRed(),
                (int) shape.getColor().getGreen(),
                (int) shape.getColor().getBlue()));
        g.fillRect((int) shape.getCenterX(), (int) shape.getCenterY(),
                (int) shape.getSizeX(), (int) shape.getSizeY());
      }
      if (shape.getClass().equals(model.Oval.class)) {
        g.setColor(new Color((int) shape.getColor().getRed(),
                (int) shape.getColor().getGreen(),
                (int) shape.getColor().getBlue()));
        g.fillOval((int) shape.getCenterX(), (int) shape.getCenterY(),
                (int) shape.getSizeX(), (int) shape.getSizeY());
      }
    }

  }
}
