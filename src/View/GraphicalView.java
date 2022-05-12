package View;

import Controller.ControlledShapes;
import Models.*;

public class GraphicalView extends AbstractView {
  private IModel multiple_snapshots;
  private ControlledShapes controller_obj;
  private int X_Max;
  private int Y_Max;
  private HelperGraphicalView helper_obj;

  public GraphicalView(IModel multiple_snapshots, int X_Max, int Y_Max) {
    this.multiple_snapshots = multiple_snapshots;
    this.X_Max = X_Max;
    this.Y_Max = Y_Max;
  }

  public void draw_view() {
  this.helper_obj = new HelperGraphicalView(this.multiple_snapshots,this.X_Max,this.Y_Max);
  this.helper_obj.draw_viewhelper();
  }

  /**
   * SetC() function passes the controller to the view.
   *
   * @param controller which is of type ControlledShapes.
   */
  public void SetC(ControlledShapes controller) {
    this.controller_obj = controller;
  }
}
