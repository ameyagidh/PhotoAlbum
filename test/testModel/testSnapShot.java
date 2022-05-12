import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Models.Color;
import Models.IShape;
import Models.Oval;
import Models.PhotoAlbum;
import Models.Rectangle;
import Models.SnapShot;

public class testSnapShot {
  private PhotoAlbum photoAlbum1;
  private SnapShot snapShot1;
  private SnapShot snapShot2;
  private PhotoAlbum photoAlbum2;
  private IShape shape1;
  private IShape shape2;
  private IShape shape3;
  private IShape shape4;
  private Color color1;
  private Color color2;
  private Color color3;
  private String SnapShotID;
  private String Description1;
  private Timestamp timestamp;
  private List<SnapShot> SnapShotsList = new ArrayList<>();
  private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private List<IShape> ShapesList1 = new ArrayList<>();

  /**
   * setUp() function creates objects.
   */

  @Before
  public void setUp() {
    this.color1 = new Color(180, 135, 110);
    this.color2 = new Color(100, 115, 85);
    this.shape1 = new Rectangle("R", 200, 200, color1, 50.0, 100.0);
    this.shape2 = new Oval("O", 500.0, 100.0, color2, 60.0, 30.0);
    this.shape3 = new Rectangle("R2", 20, 200, color1, 510.0, 90.0);
    this.shape4 = new Oval("O2", 500.0, 10.0, color2, 650.0, 70.0);
    this.photoAlbum1 = new PhotoAlbum();
    this.photoAlbum2 = new PhotoAlbum();
    this.Description1 = "First SnapShot";

  }

  /**
   * testIllegealConstructor1() function check the edge cases which should
   * raise an IllegalArgumentException.
   */

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor1() {
    this.color3 = new Color(1000, 115, 85);
  }

  /**
   * testGetAllPhotoAlbumObject()function check if the value returned by
   * GetAllPhotoAlbumObject() is as required.
   */

  @Test
  public void testGetAllPhotoAlbumObject() {
    this.SnapShotID = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    this.timestamp = new Timestamp(System.currentTimeMillis());
    String str1 = "Printing SnapShots\n"
            + "SnapShot ID: " + this.SnapShotID + "\n"
            + "Timestamp: " + sdf3.format(this.timestamp) + "\n"
            + "Description: First SnapShot\n"
            + "Shape Information: \n"
            + "Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0,200.0) Width: 50.0, Height: 100.0, Color: (180.0,135.0,110.0)\n"
            + "\nShape Information: \n"
            + "Name: O\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0) "
            + "X radius: 60.0, Y radius: 30.0, Color: (100.0,115.0,85.0)\n";
    this.SnapShotID = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape3);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape4);
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    this.timestamp = new Timestamp(System.currentTimeMillis());
    String str2 = "Printing SnapShots\n"
            + "SnapShot ID: " + this.SnapShotID + "\n"
            + "Timestamp: " + sdf3.format(this.timestamp) + "\n"
            + "Description: First SnapShot\n"
            + "Shape Information: \n"
            + "Name: R\n"
            + "Type: rectangle\n"
            + "Min corner: (200.0,200.0) Width: 50.0, Height: 100.0, Color: (180.0,135.0,110.0)\n"
            + "\n"
            + "Shape Information: \n"
            + "Name: O\n"
            + "Type: oval\n"
            + "Center: (500.0,100.0) X radius: 60.0, Y radius: 30.0, Color: (100.0,115.0,85.0)\n"
            + "\n"
            + "Shape Information: \n"
            + "Name: R2\n"
            + "Type: rectangle\n"
            + "Min corner: (20.0,200.0) Width: 510.0, Height: 90.0, Color: (180.0,135.0,110.0)\n"
            + "\n"
            + "Shape Information: \n"
            + "Name: O2\n"
            + "Type: oval\n"
            + "Center: (500.0,10.0) X radius: 650.0, Y radius: 70.0, Color: (100.0,115.0,85.0)\n";

    assertEquals(str2, this.snapShot1.GetAllPhotoAlbumObject());

  }

  /**
   * testResetSnapShotList() function check if the value returned by
   * ResetSnapShotList() is as required.
   */
  @Test
  public void testResetSnapShotList() {
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    assertEquals("[]", this.snapShot1.ResetSnapShotList().toString());
  }

  /**
   * testTakeSnapShots() function check if the value returned by
   * TakeSnapShots() is as required.
   */
  @Test
  public void testTakeSnapShots() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    this.SnapShotsList.add(this.snapShot1);
    this.snapShot1.TakeSnapShots(this.snapShot1);
    assertEquals(this.SnapShotsList.size(), this.snapShot1.getSnapShotsList().size());
  }

  /**
   * testGetSnapShotsList() function check if the value returned by
   * getSnapShotsList() is as required.
   */
  @Test
  public void testGetSnapShotsList() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    assertEquals(this.SnapShotsList, this.snapShot1.getSnapShotsList());
  }

  /**
   * testRemoveSnapShot() function check if the value returned by
   * removeShape() is as required.
   */
  @Test
  public void testRemoveSnapShot() {
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape1);
    this.photoAlbum1.AddShapeToPhotoAlbum(this.shape2);
    this.photoAlbum1.removeShape(this.shape2);
    this.snapShot1 = new SnapShot(this.Description1, this.photoAlbum1);
    assertEquals(this.SnapShotsList, this.snapShot1.getSnapShotsList());

  }

}
