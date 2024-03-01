import java.io.FileNotFoundException;

import controller.Controller;
import controller.IController;
import model.AlbumModel;
import view.SVGView;
import view.SwingView;

// -in buildings.txt -v web -out buildings.html 1000 1000
// -in playground.txt -v graphical -out 1000 1000

/**
 * The type Main.
 */

public class Main {
  static String inputFileName;
  static String outputFileName;
  static String viewType;
  static int xMax;
  static int yMax;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws FileNotFoundException the file not found exception
   */
  public static void main(String[] args) throws FileNotFoundException {
    for (int i = 0; i < args.length - 1; i++) {
      try {
        xMax = Integer.parseInt(args[i]);
        yMax = Integer.parseInt(args[i + 1]);
      } catch (NumberFormatException e) {
        xMax = 1000;
        yMax = 1000;
      }
      if (args[i].equalsIgnoreCase("-in")) {
        inputFileName = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-out")) {
        outputFileName = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-view")
              || args[i].equalsIgnoreCase("-v")) {
        viewType = args[i + 1];
      }
    }
    if (null == inputFileName || null == viewType) {
      System.err.println("Input file name and view type is required");
      System.exit(3);
    }
    if (viewType.equalsIgnoreCase("graphical")) {
      IController controller = new Controller(inputFileName, new AlbumModel(),
              new SwingView("CS 5004 Shapes Photo Album Viewer by Ameya Santosh Gidh", xMax, yMax));
      controller.go();
    }
    if (viewType.equalsIgnoreCase("web")) {
      if (null == outputFileName) {
        outputFileName = "webView.html";
      }
      IController controller = new Controller(inputFileName, new AlbumModel(),
              new SVGView(outputFileName, xMax, yMax));
      controller.go();
    }
  }
}
