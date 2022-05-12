package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PhotoAlbum Class is used to represent the photoAlbum.
 */
public class PhotoAlbum {
  private final List<String> PhotoAlbumList = new ArrayList<>();
  private final List<IShape> ShapesList = new ArrayList<>();
  private IShape Shape;

  /**
   * PhotoAlbum() constructor creates a
   * photo album list of shapes.
   */
  public PhotoAlbum() {

  }

  /**
   * createShape() function is used to create an IShape object.
   *
   * @param Name  name of the shape.
   * @param type  type of the shape.
   * @param x     x coordinate of the shape.
   * @param y     y coordinate of the shape.
   * @param size1 size1 of the shape.
   * @param size2 size2 of the shape.
   * @param color of type Color.
   * @return an IShape object.
   */
  public IShape createShape(String Name, String type, double x, double y,
                            double size1, double size2,
                            Color color) {
    if (!this.PhotoAlbumList.contains(Name)) {// maybe hashmap.
      if (type.equalsIgnoreCase("rectangle")) {
        this.Shape = new Rectangle(Name, x, y, color, size1, size2);
        //this.ShapesList.add(this.Shape);
        //this.PhotoAlbumList.add(this.Shape.getName());
        // return Shape;
        return new Rectangle(Name, x, y, color, size1, size2);
      } else if (type.equalsIgnoreCase("oval")) {
        //this.Shape =  new Oval(Name, x, y, color, size1, size2);
        //this.ShapesList.add(this.Shape);
        //this.PhotoAlbumList.add(this.Shape.getName());
        // return Shape;
        return new Oval(Name, x, y, color, size1, size2);
      }
    }
    return null;
  }

  /**
   * AddShapeToPhotoAlbum() function adds a shape to
   * the ShapesList.
   *
   * @param shape the IShape object.
   * @return a list of Shapes called ShapesList.
   */
  public void AddShapeToPhotoAlbum(IShape shape) {
    this.ShapesList.add(shape);
    this.PhotoAlbumList.add(shape.getName());
  }

  /**
   * getPhotoAlbumList() function returns the list of shape names present.
   *
   * @return a list of String called PhotAlbumList.
   */
  public List<String> getPhotoAlbumList() {
    return this.PhotoAlbumList;
  }

  /**
   * removeShape() function removes a shape from the ShapesList.
   *
   * @param shape shape of type IShape.
   */
  public void removeShape(IShape shape) {
    this.ShapesList.remove(shape);
    this.PhotoAlbumList.remove(shape.getName());
  }

  /**
   * getShapesList() function returns a new List<IShape>.
   *
   * @return returns a List<IShape>.
   */
  public List<IShape> getShapesList() {
    return this.ShapesList;
  }

public PhotoAlbum Deepcopy(){
    PhotoAlbum copy = new PhotoAlbum();
    for(int j= 0; j < this.getShapesList().size();j++){
      if(this.getShapesList().get(j).getType().equalsIgnoreCase("rectangle"))
      {
        IShape curr_Shape = this.getShapesList().get(j);
        IShape shape_rectangle = new Rectangle(curr_Shape.getName(),curr_Shape.getX(),curr_Shape.getY(),
                curr_Shape.getColor(),curr_Shape.getSize1(),curr_Shape.getSize2());
        copy.AddShapeToPhotoAlbum(shape_rectangle);
      }
      if(this.getShapesList().get(j).getType().equalsIgnoreCase("oval"))
      {
        IShape curr_Shape = this.getShapesList().get(j);
        IShape shape_oval = new Oval(curr_Shape.getName(),curr_Shape.getX(),curr_Shape.getY(),
                curr_Shape.getColor(),curr_Shape.getSize1(),curr_Shape.getSize2());
        copy.AddShapeToPhotoAlbum(shape_oval);
      }


    }

    return copy;
}

}

