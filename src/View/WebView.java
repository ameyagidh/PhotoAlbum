package View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

import Controller.ControlledShapes;
import Models.IModel;
import Models.IShape;
import Models.SnapShot;

/**
 * WebView .
 */
public class WebView extends AbstractView{

  private IModel snapShot;
  private String Output_File;
  private File file_;
  private String html;
  private WebView webView_obj;

  public WebView(IModel snapShot, String Output_File) {
    this.snapShot = snapShot;
    this.Output_File = Output_File;
    this.html = "";
  }

  /**
   * draw_view() function is used
   * to draw the shapes on the frame.
   */
  @Override
  public void draw_view() {
    this.html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
            "    <title>CS 5004</title>\n" +
            "    <link rel=\"stylesheet\" href=\"style.css\">\n" +
            "  </head>\n" +
            "  <body>\n";
    for (int i = 0; i < this.snapShot.getSnapShotsList().size(); i++) {
      SnapShot current_snapShot = this.snapShot.getSnapShotsList().get(i);
      html += "<h2 style = background-color: Pink>" + current_snapShot.getSnapShotID() + "&nbsp"
              + current_snapShot.getDescription() + "</h2>";
      html += "<div>\n" +
              " <svg width=\"1000\" height=\"1000\"><rect id=\"background\" x=\"0.000000\" y=\"0.000000\" " +
              "width=\"800.000000\" height=\"800.000000\" fill=\"rgb(33.000000,94.000000,248.000000)\"></rect>";

      for (int j = 0; j < current_snapShot.getPhotoAlbum_obj().getShapesList().size(); j++) {
        IShape current_Shape = current_snapShot.getPhotoAlbum_obj().getShapesList().get(j);
        html += "    <svg width=\"1000\" height=\"1000\">";
        if (current_Shape.getType().equalsIgnoreCase("rectangle")) {
          html += String.format("<rect id=\"%s\" x=\"%f\" "
                          + "y=\"%f\" width=\"%f\" height=\"%f\" fill=\"rgb(%f,%f,%f)\">",
                  current_Shape.getName(), current_Shape.getX(), current_Shape.getY(), current_Shape.getSize1(), current_Shape.getSize2(),
                  current_Shape.getColor().getRed(), current_Shape.getColor().getGreen(), current_Shape.getColor().getBlue())
                  + "</rect>";
        }
        if (current_Shape.getType().equalsIgnoreCase("oval")) {
          html += String.format("<ellipse id=\"%s\" cx=\"%f\" "
                          + "cy=\"%f\" rx=\"%f\" ry=\"%f\" fill=\"rgb(%f,%f,%f)\">",
                  current_Shape.getName(), current_Shape.getX(), current_Shape.getY(), current_Shape.getSize1(), current_Shape.getSize2(),
                  current_Shape.getColor().getRed(), current_Shape.getColor().getGreen(), current_Shape.getColor().getBlue())
                  + "</ellipse>";
        }
      }
      html += "</svg>";
      html += "</div>";
    }
    html += "</body>\n";
    html += "</html>\n";

    if (Objects.equals(this.Output_File, "")) {
      this.file_ = new File("buildingsOut.html");
    } else {
      this.file_ = new File(this.Output_File);
    }
    try {
      BufferedWriter buffer_writer = new BufferedWriter(new FileWriter(this.file_));
      buffer_writer.write(html);
      buffer_writer.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * SetC() function passes the controller to the view.
   *
   * @param controller which is of type ControlledShapes.
   */
  @Override
  public void SetC(ControlledShapes controller) {
  }

  public String getHtml() {
    return html;
  }

  public WebView getWebView_obj() {
    return webView_obj;
  }
}
