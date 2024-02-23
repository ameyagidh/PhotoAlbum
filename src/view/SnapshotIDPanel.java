package view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Snapshot;

/**
 * The type Snapshot id panel.
 */
public class SnapshotIDPanel extends JPanel {
  private final JLabel snapshotText;
  private Snapshot currentSnapshot;

  /**
   * Instantiates a new Snapshot id panel.
   *
   * @param currentSnapshot the current snapshot
   */
  public SnapshotIDPanel(Snapshot currentSnapshot) {
    this.currentSnapshot = currentSnapshot;
    snapshotText = new JLabel();
    snapshotText.setText("<html><u><b>Snapshot ID:</u> " + currentSnapshot.getSnapshotID() + "<br>"
            + "<u><b>Description:</u> " + currentSnapshot.getDescription());
    this.setBackground(Color.ORANGE);
    this.add(snapshotText);
  }

  /**
   * Update panel.
   *
   * @param snapshot the snapshot
   */
  public void updatePanel(Snapshot snapshot) {
    this.currentSnapshot = snapshot;
    snapshotText.setText("<html><u><b>Snapshot ID:</u> " + currentSnapshot.getSnapshotID() + "<br>"
            + "<u><b>Description:</u> " + currentSnapshot.getDescription());
  }
}
