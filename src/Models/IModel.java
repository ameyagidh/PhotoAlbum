package Models;

import java.util.List;

/**
 * IModel Interface implements functions needed to be
 * implemented for the Classes that implement it.
 */
public interface IModel {
  /**
   * GetAllPhotoAlbumObject() function is used to
   * get all the values present in the photo album list.
   *
   * @return a string representing the shapes.
   */
  public String GetAllPhotoAlbumObject();

  /**
   * ResetSnapShotList() function returns a new List<SnapShot>.
   *
   * @return returns a List<SnapShot>.
   */
  public List<SnapShot> ResetSnapShotList();
  /**
   * TakeSnapShots() function adds a SnapShot to
   * the SnapShotsList.
   *
   * @param snapshot the SnapShot object.
   *
   */
  public void TakeSnapShots(SnapShot snapshot);

  /**
   * getSnapShotsList() function gives a list of Sna
   * @return
   */
  public List<SnapShot> getSnapShotsList();
}
