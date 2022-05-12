package Controller;

import Models.IModel;
import View.GraphicalView;
import View.IView;
import View.WebView;

/**
 * ControlledShapes Class is used to initalize the controller.
 */

public class ControlledShapes implements IController {
  private IModel model_obj;
  private IView view_obj;
  private String view_type;
  private ControlledShapes controller;
  private String outputfile;
  private Integer X_Max;
  private Integer Y_Max;

  /**
   * ControlledShapes() constructor sets up the Controller.
   */
  public ControlledShapes(IModel model_obj, IView view_obj,String view_type,Integer X_Max,Integer Y_Max,String outputfile) {
    this.model_obj = model_obj;
    // model_obj is the model Object which contains the model Object
    this.view_obj = view_obj;
    // view_obj contains the view type object
    this.X_Max = X_Max;
    // X_Max contains the maximum x coordinate value.
    this.Y_Max = Y_Max;
    // Y_Max contains the maximum Y coordinate value.
    this.outputfile = outputfile;
    // outputfile contains the outputfile.
    this.view_type = view_type;
    // view_type contains the type of the view which is web or graphical.
  }

  /**
   * go() function starts the controller.
   */

  public void go(){
    if (this.view_type.equalsIgnoreCase("graphical")) {
      this.view_obj = new GraphicalView(this.model_obj, this.X_Max, Y_Max);
      view_obj.SetC(controller);
      view_obj.draw_view();

    } else {
      this.view_obj = new WebView(model_obj, this.outputfile);
      view_obj.SetC(controller);
      view_obj.draw_view();
    }
  }

  /**
   * getModel_obj() funciton is used to return the model_obj.
   *
   * @return the model_obj.
   */
  public IModel getModel_obj() {
    return this.model_obj;
  }

  public IView getView_obj() {
    return view_obj;
  }
}


