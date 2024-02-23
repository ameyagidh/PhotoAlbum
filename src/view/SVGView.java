package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import model.IAlbum;
import model.IShape;
import model.Snapshot;

/**
 * The type Svg view.
 */
public class SVGView implements IView {
  private IAlbum model;
  private StringBuilder htmlBuilder;
  private final String outputFileName;
  private File outputFile;
  private final int windowWidth;
  private final int windowHeight;

  /**
   * Instantiates a new Svg view.
   *
   * @param outputFileName the output file name
   * @param xMax           the x max
   * @param yMax           the y max
   */
  public SVGView(String outputFileName, int xMax, int yMax) {
    this.outputFileName = outputFileName;
    this.windowWidth = xMax;
    this.windowHeight = yMax;
  }

  public void loadModel(IAlbum model) {
    this.model = model;
    Snapshot currentSnapshot = this.model.getAllSnapshots().get
            (this.model.getAllSnapshots().size() - 1);
    outputFile = new File(this.outputFileName);
    htmlBuilder = new StringBuilder();
    htmlBuilder.append("""
            <!DOCTYPE html>
            <html>
            <head>
                <style>
                    h1 {
                        border-style: solid;
                        border-width: 7px;
                        border-color: darkblue;
                        background: blueviolet;
                    }
                        
                    div {
                        border-style: solid;
                        border-width: 7px;
                        border-color: darkmagenta;
                        background: lightblue;
                    }
                </style>
            </head>
            <body>
            <h1>HTML View with SVG</h1>
            """);
    processSnapshot(currentSnapshot);
  }


  @Override
  public void setCurrentSnapshot(Snapshot currentSnapshot) {
    int currentSnapshotIndex = this.model.getAllSnapshots().indexOf(currentSnapshot);
    if (0 == currentSnapshotIndex) {
      createFile();
    } else processSnapshot(this.model.getAllSnapshots().get(currentSnapshotIndex - 1));
  }

  /**
   * Process snapshot.
   *
   * @param snapshot the snapshot
   */
  public void processSnapshot(Snapshot snapshot) {
    htmlBuilder.append("<div>\n");
    String snapshotID = "<h2>Snapshot ID: " + snapshot.getSnapshotID() + "</h2>\n";
    String snapshotTimestamp = "<h4>Timestamp: " + snapshot.getSnapshotTimestamp() + "</h4>\n";
    String snapshotDescription = "<h4>Description:" + snapshot.getDescription() + "</h4>\n";
    String svgWindowSize = "<svg width=" + this.windowWidth + " height=" + this.windowHeight
            + ">\n";
    htmlBuilder.append(snapshotID);
    htmlBuilder.append(snapshotTimestamp);
    htmlBuilder.append(snapshotDescription);
    htmlBuilder.append(svgWindowSize);

    List<IShape> currentShapes = snapshot.getCurrentAlbumShapes().values().stream().collect
            (Collectors.toUnmodifiableList());
    for (IShape shape : currentShapes) {
      if (shape.getClass().equals(model.Rectangle.class)) {
        String rectangleString = "<rect id=" + shape.getName()
                + " x=" + shape.getCenterX()
                + " y=" + shape.getCenterY()
                + " width=" + shape.getSizeX()
                + " height=" + shape.getSizeY()
                + " fill=rgb(" + shape.getColor().getRed()
                + "," + shape.getColor().getGreen()
                + "," + shape.getColor().getBlue() + ")>"
                + "</rect>\n";
        htmlBuilder.append(rectangleString);
      }
      if (shape.getClass().equals(model.Oval.class)) {
        String ovalString = "<ellipse id=" + shape.getName()
                + " cx=" + shape.getCenterX()
                + " cy=" + shape.getCenterY()
                + " rx=" + shape.getSizeX()
                + " ry=" + shape.getSizeY()
                + " fill=rgb(" + shape.getColor().getRed()
                + "," + shape.getColor().getGreen()
                + "," + shape.getColor().getBlue() + ")>"
                + "</ellipse>\n";
        htmlBuilder.append(ovalString);
      }
    }
    htmlBuilder.append("</svg>\n");
    htmlBuilder.append("</div>\n");
    htmlBuilder.append("<br>\n\n");
    setCurrentSnapshot(snapshot);
  }

  /**
   * Create file.
   */
  public void createFile() {
    htmlBuilder.append("""
            \n</body>
            \n</html>""");
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.outputFile))) {
      bufferedWriter.write(htmlBuilder.toString());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
