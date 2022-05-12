package Controller;

import Models.IModel;

/**
 * IController interface determines the protocols and methods the classes
 * implementing it my have.
 */
public interface IController {

  /**
   * go() function starts the controller.
   */
  public void go();

  /**
   * getModel_obj() funciton is used to return the model_obj.
   *
   * @return the model_obj.
   */
  public IModel getModel_obj();

}
