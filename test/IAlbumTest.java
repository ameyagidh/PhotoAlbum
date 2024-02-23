import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import model.AlbumModel;
import model.Color;
import model.IAlbum;
import model.IShape;
import model.Oval;
import model.Rectangle;

/**
 * The type Album test.
 */
public class IAlbumTest {
  private Color colorRed;
  private Color colorBlue;
  private IShape rectangle;
  private IShape oval;
  private IAlbum photoAlbumModel;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    colorRed = new Color(255, 0, 0);
    colorBlue = new Color(0, 0, 255);

    rectangle = new Rectangle("R", 0, 0,
            50, 25, colorRed);
    oval = new Oval("O", 0, 0, 60, 10, colorBlue);

    photoAlbumModel = new AlbumModel();
  }

  /**
   * Test add shape.
   */
  @Test
  public void testAddShape() {
    photoAlbumModel.addShape(rectangle);
    assertEquals("[Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n]",
            photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test invalid add shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAddShape() {
    photoAlbumModel.addShape(null);

  }

  /**
   * Test remove all shapes.
   */
  @Test
  public void testRemoveAllShapes() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    photoAlbumModel.removeShape("R");
    photoAlbumModel.removeShape("O");
    assertEquals("[]", photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test remove one shape.
   */
  @Test
  public void testRemoveOneShape() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    photoAlbumModel.removeShape("R");
    assertEquals("[Name: O\n"
            + "Type: Oval\n"
            + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
            + "Color: (0.0, 0.0, 255.0)\n\n]", photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test remove invalid name shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveInvalidNameShape() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.removeShape("Rectangle");
  }

  /**
   * Test get shape.
   */
  @Test
  public void testGetShape() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    assertEquals("Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n",
            photoAlbumModel.getShape("R").toString());
  }

  /**
   * Test get invalid name shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetInvalidNameShape() {
    photoAlbumModel.addShape(rectangle);
    assertEquals("Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n",
            photoAlbumModel.getShape("Rectangle").toString());
  }

  /**
   * Test get current shapes.
   */
  @Test
  public void testGetCurrentShapes() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    assertEquals("[Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n"
                    + ", Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (0.0, 0.0, 255.0)\n\n]",
            photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test get empty current shapes.
   */
  @Test
  public void testGetEmptyCurrentShapes() {
    assertEquals("[]", photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test valid move.
   */
  @Test
  public void testValidMove() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.move("R", 99, 99);
    assertEquals("[Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (99.0, 99.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n]",
            photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test invalid name move.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNameMove() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.move("Rectangle", 99, 99);
  }

  /**
   * Test valid resize.
   */
  @Test
  public void testValidResize() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.resize("R", 5, 5);
    assertEquals("[Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 5.0, Height: 5.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n]",
            photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test invalid name resize.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNameResize() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.resize("Rectangle", 999, 999);
  }

  /**
   * Test valid change color.
   */
  @Test
  public void testValidChangeColor() {
    photoAlbumModel.addShape(oval);
    photoAlbumModel.changeColor("O", 255, 255, 255);
    assertEquals("[Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (255.0, 255.0, 255.0)\n\n]",
            photoAlbumModel.getCurrentShapes().toString());
  }

  /**
   * Test invalid name change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidNameChangeColor() {
    photoAlbumModel.addShape(oval);
    photoAlbumModel.changeColor("Oval", 0, 0, 0);
  }

  /**
   * Test high out of range change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testHighOutOfRangeChangeColor() {
    photoAlbumModel.addShape(oval);
    photoAlbumModel.changeColor("O", 256, 0, 0);
  }

  /**
   * Test low out of range change color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testLowOutOfRangeChangeColor() {
    photoAlbumModel.addShape(oval);
    photoAlbumModel.changeColor("O", -1, 0, 0);
  }

  /**
   * Test take snapshot zero shapes.
   */
  @Test
  public void testTakeSnapshotZeroShapes() {
    photoAlbumModel.takeSnapshot("No Shapes");
    String snapshotID = String.join("", photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotID + "\n"
            + "Timestamp: " + snapshotTimestamp + "\n"
            + "Description: No Shapes\n"
            + "Shape Information:\n\n]", photoAlbumModel.getAllSnapshots().toString());
  }

  /**
   * Test take snapshot one shape.
   */
  @Test
  public void testTakeSnapshotOneShape() {
    photoAlbumModel.takeSnapshot("No Shapes");
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.takeSnapshot("Rectangle added");
    String snapshotIDNoShapes = String.join("", photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotIDOneShape = String.join("", photoAlbumModel.getAllSnapshotIDs().get(1));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotIDNoShapes + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: No Shapes\n"
                    + "Shape Information:\n"
                    + "\n"
                    + ", Snapshot ID: " + snapshotIDOneShape + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: Rectangle added\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n\n]",
            photoAlbumModel.getAllSnapshots().toString());

  }

  /**
   * Test take snapshot more shapes.
   */
  @Test
  public void testTakeSnapshotMoreShapes() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    photoAlbumModel.takeSnapshot("2 Shapes in album");
    String snapshotID = String.join("", photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotID + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: 2 Shapes in album\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n"
                    + "Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (0.0, 0.0, 255.0)\n\n\n]",
            photoAlbumModel.getAllSnapshots().toString());

  }

  /**
   * Test take snapshot remove one shape.
   */
  @Test
  public void testTakeSnapshotRemoveOneShape() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    photoAlbumModel.takeSnapshot("2 Shapes in album");
    photoAlbumModel.removeShape("R");
    photoAlbumModel.takeSnapshot("Rectangle removed");
    String snapshotIDTwoShapes = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotIDOneShape = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(1));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotIDTwoShapes + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: 2 Shapes in album\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n"
                    + "Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (0.0, 0.0, 255.0)\n"
                    + "\n\n"
                    + ", Snapshot ID: " + snapshotIDOneShape + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: Rectangle removed\n"
                    + "Shape Information:\n"
                    + "Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (0.0, 0.0, 255.0)\n\n\n]",
            photoAlbumModel.getAllSnapshots().toString());

  }

  /**
   * Test take snapshot remove all shapes.
   */
  @Test
  public void testTakeSnapshotRemoveAllShapes() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.addShape(oval);
    photoAlbumModel.takeSnapshot("2 Shapes added");
    photoAlbumModel.removeShape("R");
    photoAlbumModel.removeShape("O");
    photoAlbumModel.takeSnapshot("2 Shapes removed");
    String snapshotIDTwoShapes = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotIDZeroShapes = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(1));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotIDTwoShapes + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: 2 Shapes added\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n"
                    + "Name: O\n"
                    + "Type: Oval\n"
                    + "Center: (0.0, 0.0), X radius: 60.0, Y radius: 10.0, "
                    + "Color: (0.0, 0.0, 255.0)\n\n\n"
                    + ", Snapshot ID: " + snapshotIDZeroShapes + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: 2 Shapes removed\n"
                    + "Shape Information:\n\n]",
            photoAlbumModel.getAllSnapshots().toString());
  }

  /**
   * Test take snapshot update shape.
   */
  @Test
  public void testTakeSnapshotUpdateShape() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.takeSnapshot("Original Rectangle");
    photoAlbumModel.changeColor("R", 255, 255, 255);
    photoAlbumModel.takeSnapshot("Rectangle color changed");
    String snapshotIDOriginalColor = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(0));
    String snapshotIDChangedColor = String.join("",
            photoAlbumModel.getAllSnapshotIDs().get(1));
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("[Snapshot ID: " + snapshotIDOriginalColor + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: Original Rectangle\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 0.0, 0.0)\n\n\n"
                    + ", Snapshot ID: " + snapshotIDChangedColor + "\n"
                    + "Timestamp: " + snapshotTimestamp + "\n"
                    + "Description: Rectangle color changed\n"
                    + "Shape Information:\n"
                    + "Name: R\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0, 0.0), Width: 50.0, Height: 25.0, "
                    + "Color: (255.0, 255.0, 255.0)\n\n\n]",
            photoAlbumModel.getAllSnapshots().toString());
  }

  /**
   * Test get all snapshot i ds.
   */
  @Test
  public void testGetAllSnapshotIDs() {
    photoAlbumModel.takeSnapshot("Empty Snapshot");
    String snapshotID = String.join("", photoAlbumModel.getAllSnapshotIDs());
    assertEquals("[" + snapshotID + "]", photoAlbumModel.getAllSnapshotIDs().toString());
  }

  /**
   * Test get all snapshot i ds empty.
   */
  @Test
  public void testGetAllSnapshotIDsEmpty() {
    assertEquals("[]", photoAlbumModel.getAllSnapshotIDs().toString());
  }

  /**
   * Test get all snapshots.
   */
  @Test
  public void testGetAllSnapshots() {
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    photoAlbumModel.takeSnapshot("First");
    String snapshotIDFirst = String.join("", photoAlbumModel.getAllSnapshotIDs());
    assertEquals("[Snapshot ID: " + snapshotIDFirst + "\n"
            + "Timestamp: " + snapshotTimestamp + "\n"
            + "Description: First\n"
            + "Shape Information:\n\n]", photoAlbumModel.getAllSnapshots().toString());
    photoAlbumModel.takeSnapshot("Second");
    String snapshotIDSecond = String.join("", photoAlbumModel.getAllSnapshotIDs().get(1));
    assertEquals("[Snapshot ID: " + snapshotIDFirst + "\n"
            + "Timestamp: " + snapshotTimestamp + "\n"
            + "Description: First\n"
            + "Shape Information:\n\n"
            + ", Snapshot ID: " + snapshotIDSecond + "\n"
            + "Timestamp: " + snapshotTimestamp + "\n"
            + "Description: Second\n"
            + "Shape Information:\n\n]", photoAlbumModel.getAllSnapshots().toString());
  }

  /**
   * Test get all snapshots empty.
   */
  @Test
  public void testGetAllSnapshotsEmpty() {
    assertEquals("[]", photoAlbumModel.getAllSnapshots().toString());
  }

  /**
   * Test valid get snapshot.
   */
  @Test
  public void testValidGetSnapshot() {
    photoAlbumModel.takeSnapshot("First");
    String snapshotID = String.join("", photoAlbumModel.getAllSnapshotIDs());
    String snapshotTimestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
            .format(new Timestamp(System.currentTimeMillis()));
    assertEquals("Snapshot ID: " + snapshotID + "\n"
            + "Timestamp: " + snapshotTimestamp + "\n"
            + "Description: First\n"
            + "Shape Information:\n\n", photoAlbumModel.getSnapshot(snapshotID).toString());
  }

  /**
   * Test invalid id get snapshot.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidIDGetSnapshot() {
    photoAlbumModel.takeSnapshot("Test");
    photoAlbumModel.getSnapshot("Invalid ID");
  }

  /**
   * Test reset album.
   */
  @Test
  public void testResetAlbum() {
    photoAlbumModel.addShape(rectangle);
    photoAlbumModel.takeSnapshot("Snapshot!");
    photoAlbumModel.resetAlbum();
    assertEquals("[]", photoAlbumModel.getCurrentShapes().toString());
    assertEquals("[]", photoAlbumModel.getAllSnapshotIDs().toString());
    assertEquals("[]", photoAlbumModel.getAllSnapshots().toString());
  }
}