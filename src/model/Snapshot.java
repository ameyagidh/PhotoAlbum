package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;


/**
 * The type Snapshot.
 */
public class Snapshot {
  private final String snapshotID;
  private final String snapshotTimestamp;
  private final String description;
  private final LinkedHashMap<String, IShape> currentAlbumShapes;

  /**
   * Instantiates a new Snapshot.
   *
   * @param snapshotID         the snapshot ID
   * @param currentAlbumShapes the current album shapes
   * @param description        the description of snapshot
   */
  public Snapshot(String snapshotID, LinkedHashMap<String, IShape> currentAlbumShapes,
                  String description) {
    this.currentAlbumShapes = currentAlbumShapes;
    this.description = description;
    this.snapshotID = snapshotID;
    this.snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
  }

  /**
   * Gets snapshot id.
   *
   * @return the snapshot id
   */
  public String getSnapshotID() {
    return snapshotID;
  }

  /**
   * Gets snapshot timestamp.
   *
   * @return the snapshot timestamp
   */
  public String getSnapshotTimestamp() {
    return snapshotTimestamp;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets current album shapes.
   *
   * @return the current album shapes
   */
  public LinkedHashMap<String, IShape> getCurrentAlbumShapes() {
    return currentAlbumShapes;
  }

  @Override
  public String toString() {
    return "Snapshot ID: " + this.snapshotID + "\n"
            + "Timestamp: " + this.snapshotTimestamp + "\n"
            + "Description: " + this.description + "\n"
            + "Shape Information:\n" + this.currentAlbumShapes.values()
            .stream().map(Object::toString).collect(Collectors.joining("")) + "\n";
  }
}
