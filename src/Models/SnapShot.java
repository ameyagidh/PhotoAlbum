package Models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * SnapShot Class represents the SnapShot
 * of the PhotoAlbum at a given instance of time.
 */
public class SnapShot implements IModel {

  private String SnapShotID;
  private Timestamp timestamp;
  private String Description;
  private PhotoAlbum photoAlbum_obj;
  private List<SnapShot> SnapShotsList = new ArrayList<>();
  private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  /**
   * SnapShot()  is a constructor which is used to make a SnapSHot object.
   */

  public SnapShot(){

  }
  /**
   * SnapShot is used to create time stamps.
   *
   * @param Desciption contains for a particular snapshot.
   */
  public SnapShot(String Desciption, PhotoAlbum photoAlbum_obj) {
    this.SnapShotID = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
    this.timestamp = new Timestamp(System.currentTimeMillis());
    this.Description = Desciption;
    this.photoAlbum_obj = photoAlbum_obj;
  }

  /**
   * GetAllPhotoAlbumObject() function is used to
   * get all the values present in the photo album list.
   *
   * @return a string representing the shapes.
   */
  public String GetAllPhotoAlbumObject() {
    String str = "Printing SnapShots\n"
            + "SnapShot ID: " + this.SnapShotID + "\n"
            + "Timestamp: " + sdf3.format(this.timestamp) + "\n"
            + "Description: " + this.Description;
    for (IShape shapes : this.photoAlbum_obj.getShapesList()) {
      str += "\nShape Information: \n"
              + shapes.toString() + "\n";
    }
    return str;
  }

  /**
   * ResetSnapShotList() function returns a new List<SnapShot>.
   *
   * @return returns a List<SnapShot>.
   */
  public List<SnapShot> ResetSnapShotList() {
    return new ArrayList<>(this.SnapShotsList);
  }

  /**
   * TakeSnapShots() function adds a SnapShot to
   * the SnapShotsList.
   *
   * @param snapshot the SnapShot object.
   *
   */
  public void TakeSnapShots(SnapShot snapshot) {
    this.SnapShotsList.add(snapshot);

  }
  /**
   * removeSnapShot() function removes a shape from the SnapShapesList.
   *
   * @param snapshot snapshot of type SnapShot.
   */
  public void removeSnapShot(SnapShot snapshot) {
    this.SnapShotsList.remove(snapshot);
  }

  /**
   * getSnapShotsList() function returns a new List<SnapShot>.
   *
   * @return returns a List<SnapShot>.
   */
  public List<SnapShot> getSnapShotsList() {
    return this.SnapShotsList;
  }

  /**
   * getPhotoAlbum_obj() function returns a PhotoAlbum_obj
   *
   * @return photoAlbum_obj which is the photo Album object
   */
  public PhotoAlbum getPhotoAlbum_obj() {
    return this.photoAlbum_obj;
  }

  /**
   * getSnapShotID() function returns the SnapShotID of the snap shot.
   * @return SnapShotID which is the SnapShotID of the object.
   */
  public String getSnapShotID() {
    return this.SnapShotID;
  }

  /**
   * getTimeStamp() function returns the timestamp
   * @return timestamp which is the current timestamp.
   */
  public Timestamp getTimestamp() {
    return this.timestamp;
  }

  /**
   * getDescription() function returns the description of the snapshot.
   * @return Description of the snapshot.
   */
  public String getDescription() {
    return this.Description;
  }

}