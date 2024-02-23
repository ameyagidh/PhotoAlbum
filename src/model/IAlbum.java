package model;

import java.util.List;

/**
 * The interface Album.
 */
public interface IAlbum {
  /**
   * Create new shape.
   *
   * @param kind    the kind
   * @param name    the name
   * @param centerX the center x
   * @param centerY the center y
   * @param sizeX   the size x
   * @param sizeY   the size y
   * @param color   the color
   * @return the shape
   */
  void createShape(String name, String kind, double centerX, double centerY,
                     double sizeX, double sizeY, Color color);

  /**
   * Add a shape.
   *
   * @param shape the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  void addShape(IShape shape) throws IllegalArgumentException;

  /**
   * Remove the shape.
   *
   * @param name the name
   * @throws IllegalArgumentException the illegal argument exception
   */
  void removeShape(String name) throws IllegalArgumentException;

  /**
   * Gets shape.
   *
   * @param name the name
   * @return the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  IShape getShape(String name) throws IllegalArgumentException;

  /**
   * Gets current shapes in Album.
   *
   * @return the current shapes
   */
  List<IShape> getCurrentShapes();

  /**
   * Move the shape.
   *
   * @param name       the name
   * @param newCenterX the new center x
   * @param newCenterY the new center y
   * @throws IllegalArgumentException the illegal argument exception
   */
  void move(String name, double newCenterX, double newCenterY) throws IllegalArgumentException;

  /**
   * Resize the shape.
   *
   * @param name     the name
   * @param newSizeX the new size x
   * @param newSizeY the new size y
   * @throws IllegalArgumentException the illegal argument exception
   */
  void resize(String name, double newSizeX, double newSizeY) throws IllegalArgumentException;

  /**
   * Change color of shape.
   *
   * @param name  the name
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  void changeColor(String name, double red, double green, double blue)
          throws IllegalArgumentException;

  /**
   * Take snapshot of album's current state.
   *
   * @param description the description
   */
  void takeSnapshot(String description);

  /**
   * Gets all snapshot ID's.
   *
   * @return the all snapshot i ds
   */
  List<String> getAllSnapshotIDs();

  /**
   * Gets all snapshots taken.
   *
   * @return the all snapshots
   */
  List<Snapshot> getAllSnapshots();

  /**
   * Gets snapshot based on ID.
   *
   * @param snapshotID the snapshot id
   * @return the snapshot
   * @throws IllegalArgumentException the illegal argument exception
   */
  Snapshot getSnapshot(String snapshotID) throws IllegalArgumentException;

  /**
   * Reset album.
   */
  void resetAlbum();
}
