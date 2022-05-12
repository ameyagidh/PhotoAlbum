import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import Controller.ControlledShapes;
import Models.*;
import Models.Color;
import View.AbstractView;

/**
 * PhotoAlbumMain class is the one where the photoAlbum class starts.
 * It contains variables like view_type which is the type of view,
 * outputfile which is the location of the output file, X_Max and Y_Max which
 * are the X and Y maximum size coordinates.
 */

public class PhotoAlbumMain {

  private String view_type;
  private String outputfile;
  private Integer X_Max;
  private Integer Y_Max;

  public PhotoAlbumMain(String view_type, String file_output, Integer x, Integer y) {
    this.view_type = view_type;
    this.outputfile = file_output;
    this.X_Max = x;
    this.Y_Max = y;
  }

  public void Shapes_to_draw(String word, PhotoAlbum photoAlbum_obj, IShape s1) {
    String[] word2 = word.split("\\s+");
    Color color1 = new Color(Double.parseDouble(word2[7]),
            Double.parseDouble(word2[8]),
            Double.parseDouble(word2[9]));
    s1 = photoAlbum_obj.createShape(word2[1], word2[2],
            Double.parseDouble(word2[3]), Double.parseDouble(word2[4]),
            Double.parseDouble(word2[5]), Double.parseDouble(word2[6])
            , color1);
    photoAlbum_obj.AddShapeToPhotoAlbum(s1);

  }

  public void Take_Snaps(String word, PhotoAlbum photoAlbum_obj, SnapShot snap_model) {
    SnapShot Snap_Shot = new SnapShot(word.replace("snapShot", ""), photoAlbum_obj.Deepcopy());
    snap_model.TakeSnapShots(Snap_Shot);

  }

  public void move_shapes(String word, PhotoAlbum photoAlbum_obj) {
    String[] word4 = word.split("\\s+");
    for (int i = 0; i < photoAlbum_obj.getShapesList().size(); i++) {
      if (Objects.equals(photoAlbum_obj.getShapesList().get(i).getName(), word4[1])) {
        photoAlbum_obj.getShapesList().get(i).move(Double.parseDouble(word4[2]),
                Double.parseDouble(word4[3]));
      }
    }

  }

  public void Change_Color(String word, PhotoAlbum photoAlbum_obj) {
    String[] word6 = word.split("\\s+");
    for (int i = 0; i < photoAlbum_obj.getShapesList().size(); i++) {
      if (Objects.equals(photoAlbum_obj.getShapesList().get(i).getName(), word6[1])) {
        Color color1 = new Color(Double.parseDouble(word6[2]),
                Double.parseDouble(word6[3]), Double.parseDouble(word6[4]));
        photoAlbum_obj.getShapesList().get(i).ChangeColor(color1);
      }
    }

  }

  public void Resize(String word, PhotoAlbum photoAlbum_obj) {
    String[] word5 = word.split("\\s+");
    for (int i = 0; i < photoAlbum_obj.getShapesList().size(); i++) {
      if (Objects.equals(photoAlbum_obj.getShapesList().get(i).getName(), word5[1])) {
        photoAlbum_obj.getShapesList().get(i).resize(Double.parseDouble(word5[2]),
                Double.parseDouble(word5[3]));
      }
    }
  }

  public void Remove_Shapes(String word, PhotoAlbum photoAlbum_obj) {
    String[] word4 = word.split("\\s+");
    for (int i = 0; i < photoAlbum_obj.getShapesList().size(); i++) {
      if (Objects.equals(photoAlbum_obj.getShapesList().get(i).getName(), word4[1])) {
        IShape s2 = photoAlbum_obj.getShapesList().get(i);
        photoAlbum_obj.removeShape(s2);
      }
    }
  }

  public void readFile(Readable readable) {
    Scanner sc = new Scanner(readable);
    PhotoAlbum photoAlbum_obj = new PhotoAlbum();
    IShape s1 = null;
    SnapShot snap_model = new SnapShot();

    while (sc.hasNext()) {
      String word = sc.nextLine();
      word = word.trim();
      if (word.startsWith("#")) {
        continue;
      }
      // Adding Shapes to the PhotoAlbum Object.
      if (word.startsWith("shape")) {
        this.Shapes_to_draw(word, photoAlbum_obj, s1);
      }

      // Moving Shapes by calling the necessary Function.
      if (word.startsWith("move")) {
        this.move_shapes(word, photoAlbum_obj);
      }
      // Resizing the Shapes here.
      if (word.startsWith("resize")) {
        this.Resize(word, photoAlbum_obj);
      }
      // Removing the Shapes.
      if (word.startsWith("remove")) {
        this.Remove_Shapes(word, photoAlbum_obj);
      }
      //  Changing the color of the Shapes here.
      if (word.startsWith("color")) {
        this.Change_Color(word, photoAlbum_obj);
      }
      // Taking SnapShots here.
      if (word.startsWith("snapShot") || word.startsWith("snapshot")) {
        this.Take_Snaps(word, photoAlbum_obj, snap_model);
      }
    }
    AbstractView view_obj = new AbstractView();
   ControlledShapes controller = new ControlledShapes(snap_model,view_obj,view_type,X_Max,Y_Max,outputfile);
   controller.go();
  }

  public static void main(String[] args) throws FileNotFoundException {
    List<String> Argument_input = Arrays.asList(args);
    Integer Y_Max = null;
    Integer X_Max = null;
    try {
      X_Max = Integer.parseInt(Argument_input.get(Argument_input.size() - 2));
      Y_Max = Integer.parseInt(Argument_input.get(Argument_input.size() - 1));
    } catch (Exception ignored) {

    }
    int Index_Of_InputFile = Argument_input.indexOf("-in");
    int Index_Of_OutputFile = Argument_input.indexOf("-out");
    int Index_Of_View_File = Argument_input.indexOf("-v");
    if (Index_Of_View_File == -1) {
      Index_Of_View_File = Argument_input.indexOf("-view");
    }

    String Current_Directory;
    Current_Directory = Argument_input.get(Index_Of_InputFile + 1);
    String view_type = Argument_input.get(Index_Of_View_File + 1);

    String outputFile = null;
    if (Index_Of_OutputFile != -1) {
      outputFile = Argument_input.get(Index_Of_OutputFile + 1);
    }
    if (Argument_input.get(Index_Of_View_File + 1).equalsIgnoreCase("web")) {
      if (Index_Of_OutputFile == -1) {
        System.out.println("No output file.");
        System.exit(0);
      }
    }
    File fileToRead = new File(Current_Directory);
    FileReader fr = new FileReader(fileToRead);
    PhotoAlbumMain photoAlbum_obj = new PhotoAlbumMain(view_type, outputFile, X_Max, Y_Max);
    photoAlbum_obj.readFile(fr);
  }
}

