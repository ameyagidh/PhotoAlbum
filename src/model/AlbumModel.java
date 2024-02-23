package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Album model.
 */
public class AlbumModel implements IAlbum {
  private LinkedHashMap<String, Snapshot> snapshotLinkedHashMap;
  private LinkedHashMap<String, IShape> shapeLinkedHashMap;

  /**
   * Instantiates a new Album model.
   */
  public AlbumModel() {
    snapshotLinkedHashMap = new LinkedHashMap<>();
    shapeLinkedHashMap = new LinkedHashMap<>();
  }

  @Override
  public void createShape(String name, String type, double centerX, double centerY,
                            double sizeX, double sizeY, Color color) {
    if (type.equalsIgnoreCase("Rectangle")) {
      addShape(new Rectangle(name, centerX, centerY, sizeX, sizeY, color));
    }
    if (type.equalsIgnoreCase("Oval")) {
      addShape(new Oval(name, centerX, centerY, sizeX, sizeY, color));
    }
  }

  @Override
  public void addShape(IShape shape) {
    if (shape != null) {
      shapeLinkedHashMap.put(shape.getName(), shape);
    } else throw new IllegalArgumentException("Invalid shape to add!");
  }

  @Override
  public void removeShape(String name) {
    if (shapeLinkedHashMap.containsKey(name)) {
      shapeLinkedHashMap.remove(name);
    } else throw new IllegalArgumentException("Shape " + name + " does not exit!");
  }

  @Override
  public IShape getShape(String name) throws IllegalArgumentException {
    if (shapeLinkedHashMap.containsKey(name)) {
      return shapeLinkedHashMap.get(name);
    } else throw new IllegalArgumentException("Shape " + name + " does not exit!");
  }

  @Override
  public List<IShape> getCurrentShapes() {
    return new ArrayList<>(shapeLinkedHashMap.values());
  }

  @Override
  public void move(String name, double newCenterX, double newCenterY)
          throws IllegalArgumentException {
    if (shapeLinkedHashMap.containsKey(name)) {
      shapeLinkedHashMap.get(name).setCenterX(newCenterX);
      shapeLinkedHashMap.get(name).setCenterY(newCenterY);
    } else throw new IllegalArgumentException("Shape " + name + " can not be moved!");
  }

  @Override
  public void resize(String name, double newSizeX, double newSizeY)
          throws IllegalArgumentException {
    if (shapeLinkedHashMap.containsKey(name)) {
      shapeLinkedHashMap.get(name).setSizeX(newSizeX);
      shapeLinkedHashMap.get(name).setSizeY(newSizeY);
    } else throw new IllegalArgumentException("Shape " + name + " can not be resized!");
  }

  @Override
  public void changeColor(String name, double red, double green, double blue) {
    if (shapeLinkedHashMap.containsKey(name)) {
      shapeLinkedHashMap.get(name).changeColor(red, green, blue);
    } else throw new IllegalArgumentException("Shape " + name + " color can not be changed!");
  }

  @Override
  public void takeSnapshot(String description) {
    String snapshotID = UUID.randomUUID().toString();
    LinkedHashMap<String, IShape> newHashmap = new LinkedHashMap<>();
    for (Map.Entry<String, IShape> entry : shapeLinkedHashMap.entrySet()) {
      newHashmap.put(entry.getKey(), entry.getValue().copyShape());
    }
    Snapshot snapshot = new Snapshot(snapshotID, newHashmap, description);
    snapshotLinkedHashMap.put(snapshotID, snapshot);
  }

  @Override
  public List<String> getAllSnapshotIDs() {
    return new ArrayList<>(snapshotLinkedHashMap.keySet());
  }

  @Override
  public List<Snapshot> getAllSnapshots() {
    return new ArrayList<>(snapshotLinkedHashMap.values());
  }

  @Override
  public Snapshot getSnapshot(String snapshotID) {
    if (snapshotLinkedHashMap.containsKey(snapshotID)) {
      return snapshotLinkedHashMap.get(snapshotID);
    } else throw new IllegalArgumentException("Invalid Snapshot ID: " + snapshotID);
  }

  @Override
  public void resetAlbum() {
    snapshotLinkedHashMap = new LinkedHashMap<>();
    shapeLinkedHashMap = new LinkedHashMap<>();
  }

  @Override
  public String toString() {
    return getAllSnapshots().stream().map(Object::toString)
            .collect(Collectors.joining(""));
  }
}
