package Models;

/**
 * AbstractShape represents the abstract type of
 * Shape which implements IShape interface.
 */
public abstract class AbstractShape implements IShape {
  private final String name;

  /**
   * AbstractShape constructor is used to initialize the Name and Type
   * of the Shape.
   *
   * @param Name name of the shape.
   */
  public AbstractShape(String Name) {
    this.name = Name;
  }

  /**
   * getName() function returns a String representing the
   * name of the shape.
   *
   * @return a String shows the name of the shape.
   */
  public String getName() {
    return this.name;
  }

}