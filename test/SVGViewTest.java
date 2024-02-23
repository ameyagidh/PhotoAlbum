import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import controller.Controller;
import controller.IController;
import model.AlbumModel;
import model.IAlbum;
import view.IView;
import view.SVGView;

/**
 * The type Svg view test.
 */
public class SVGViewTest {
  private IAlbum model;
  private IController controller;


  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    model = new AlbumModel();
    IView svgView = new SVGView("test/test_demo_input.html", 800, 800);
    controller = new Controller("demo_input.txt", model, svgView);
  }

  /**
   * Test html view.
   *
   * @throws Exception the exception
   */
  @Test
  public void testHTMLView() throws Exception {
    controller.go();
    String outputTextHTML = (Files.readString(Path.of("test/test_demo_input.html")));
    assertEquals("<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + "    <style>\n"
            + "        h1 {\n"
            + "            border-style: solid;\n"
            + "            border-width: 7px;\n"
            + "            border-color: darkblue;\n"
            + "            background: blueviolet;\n"
            + "        }\n"
            + "\n"
            + "        div {\n"
            + "            border-style: solid;\n"
            + "            border-width: 7px;\n"
            + "            border-color: darkmagenta;\n"
            + "            background: lightblue;\n"
            + "        }\n"
            + "    </style>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>HTML View with SVG</h1>\n"
            + "<div>\n"
            + "<h2>Snapshot ID: " + model.getAllSnapshotIDs().get(3) + "</h2>\n"
            + "<h4>Timestamp: " + this.model.getAllSnapshots().get(3).getSnapshotTimestamp()
            + "</h4>\n"
            + "<h4>Description: Selfie after removing the rectangle from the picture</h4>\n"
            + "<svg width=800 height=800>\n"
            + "<ellipse id=myoval cx=500.0 cy=400.0 rx=60.0 ry=30.0 fill=rgb(0.0,255.0,1.0)>"
            + "</ellipse>\n"
            + "</svg>\n"
            + "</div>\n"
            + "<br>\n"
            + "\n"
            + "<div>\n"
            + "<h2>Snapshot ID: " + model.getAllSnapshotIDs().get(2) + "</h2>\n"
            + "<h4>Timestamp: " + this.model.getAllSnapshots().get(2).getSnapshotTimestamp()
            + "</h4>\n"
            + "<h4>Description:</h4>\n"
            + "<svg width=800 height=800>\n"
            + "<rect id=myrect x=100.0 y=300.0 width=25.0 height=100.0 fill=rgb(0.0,0.0,255.0)>"
            + "</rect>\n"
            + "<ellipse id=myoval cx=500.0 cy=400.0 rx=60.0 ry=30.0 fill=rgb(0.0,255.0,1.0)>"
            + "</ellipse>\n"
            + "</svg>\n"
            + "</div>\n"
            + "<br>\n"
            + "\n"
            + "<div>\n"
            + "<h2>Snapshot ID: " + model.getAllSnapshotIDs().get(1) + "</h2>\n"
            + "<h4>Timestamp: " + this.model.getAllSnapshots().get(1).getSnapshotTimestamp()
            + "</h4>\n"
            + "<h4>Description: 2nd selfie</h4>\n"
            + "<svg width=800 height=800>\n"
            + "<rect id=myrect x=100.0 y=300.0 width=25.0 height=100.0 fill=rgb(255.0,0.0,0.0)>"
            + "</rect>\n"
            + "<ellipse id=myoval cx=500.0 cy=100.0 rx=60.0 ry=30.0 fill=rgb(0.0,255.0,1.0)>"
            + "</ellipse>\n"
            + "</svg>\n"
            + "</div>\n"
            + "<br>\n"
            + "\n"
            + "<div>\n"
            + "<h2>Snapshot ID: " + model.getAllSnapshotIDs().get(0) + "</h2>\n"
            + "<h4>Timestamp: " + this.model.getAllSnapshots().get(0).getSnapshotTimestamp()
            + "</h4>\n"
            + "<h4>Description: After first selfie</h4>\n"
            + "<svg width=800 height=800>\n"
            + "<rect id=myrect x=200.0 y=200.0 width=50.0 height=100.0 fill=rgb(255.0,0.0,0.0)>"
            + "</rect>\n"
            + "<ellipse id=myoval cx=500.0 cy=100.0 rx=60.0 ry=30.0 fill=rgb(0.0,255.0,1.0)>"
            + "</ellipse>\n"
            + "</svg>\n"
            + "</div>\n"
            + "<br>\n"
            + "\n"
            + "\n"
            + "</body>\n"
            + "\n"
            + "</html>", outputTextHTML);
  }
}