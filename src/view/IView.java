package view;

import model.IAlbum;
import model.Snapshot;

/**
 * The interface View.
 */
public interface IView {
  /**
   * Load model.
   *
   * @param model the model
   */
  void loadModel(IAlbum model);

  /**
   * Sets current snapshot.
   *
   * @param currentSnapshot the current snapshot
   */
  void setCurrentSnapshot(Snapshot currentSnapshot);
}
