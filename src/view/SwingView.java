package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.IAlbum;
import model.Snapshot;

/**
 * The type Swing view.
 */
public class SwingView extends JFrame implements IView {
  private IAlbum model;
  private Snapshot currentSnapshot;
  private SnapshotIDPanel snapshotLabel;
  private GraphicsPanel graphicsPanel;

  /**
   * Instantiates a new Swing view.
   *
   * @param title the title
   * @param xMax  the x max
   * @param yMax  the y max
   */
  public SwingView(String title, int xMax, int yMax) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, xMax, yMax);
    setLayout(new BorderLayout());

    JPanel controlPanel = controlPanel();
    this.add(controlPanel, BorderLayout.SOUTH);

    JButton prevButton = new JButton("<- Previous");
    prevButton.addActionListener(e -> prevButtonAction());
    controlPanel.add(prevButton);

    JButton selectButton = new JButton("Select");
    selectButton.addActionListener(e -> setCurrentSnapshot(selectPane()));
    controlPanel.add(selectButton);

    JButton nextButton = new JButton("Next ->");
    nextButton.addActionListener(e -> nextButtonAction());
    controlPanel.add(nextButton);

    JButton quitButton = new JButton("Quit!");
    quitButton.addActionListener(e -> System.exit(1));
    controlPanel.add(quitButton);
  }

  /**
   * Next button action.
   */
  public void nextButtonAction() {
    int currentSnapshotIndex = this.model.getAllSnapshotIDs().indexOf
            (currentSnapshot.getSnapshotID());
    if (currentSnapshotIndex >= this.model.getAllSnapshots().size() - 1) {
      JOptionPane.showMessageDialog(this,
              "End of photo album. No more snapshots!");
      setCurrentSnapshot(this.model.getAllSnapshots().get(this.model.getAllSnapshots().size() - 1));
      return;
    }
    setCurrentSnapshot(this.model.getAllSnapshots().get(currentSnapshotIndex + 1));
  }

  /**
   * Select pane snapshot.
   *
   * @return the snapshot
   */
  public Snapshot selectPane() {
    String[] optionsToChoose = this.model.getAllSnapshotIDs().toArray(new String[0]);
    int currentOption = this.model.getAllSnapshots().indexOf(currentSnapshot);
    String selectedSnapshot = (String) JOptionPane.showInputDialog(null,
            "What Snapshot would you like to load?", "Load Snapshot",
            JOptionPane.QUESTION_MESSAGE, null, optionsToChoose,
            optionsToChoose[currentOption]);
    return this.model.getSnapshot(selectedSnapshot);
  }

  /**
   * Prev button action.
   */
  public void prevButtonAction() {
    int currentSnapshotIndex = this.model.getAllSnapshotIDs().indexOf
            (currentSnapshot.getSnapshotID());
    if (currentSnapshotIndex <= 0) {
      JOptionPane.showMessageDialog(this,
              "Beginning of photo album. No more snapshots!");
      setCurrentSnapshot(this.model.getAllSnapshots().get(0));
      return;
    }
    setCurrentSnapshot(this.model.getAllSnapshots().get(currentSnapshotIndex - 1));
  }

  /**
   * Control panel j panel.
   *
   * @return the j panel
   */
  public JPanel controlPanel() {
    JPanel controlPanel = new JPanel();
    controlPanel.setPreferredSize(new Dimension(getWidth(), 35));
    controlPanel.setBackground(Color.BLACK);
    return controlPanel;
  }

  public void setCurrentSnapshot(Snapshot snapshot) {
    this.currentSnapshot = snapshot;
    updateAlbum();
  }

  public void loadModel(IAlbum model) {
    this.model = model;
    this.currentSnapshot = this.model.getAllSnapshots().get
            (this.model.getAllSnapshots().size() - 1);

    this.snapshotLabel = new SnapshotIDPanel(currentSnapshot);
    this.snapshotLabel.setPreferredSize(new Dimension(getWidth(), 40));
    this.add(snapshotLabel, BorderLayout.NORTH);

    this.graphicsPanel = new GraphicsPanel(currentSnapshot);
    this.graphicsPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
    this.add(graphicsPanel, BorderLayout.CENTER);
    this.add(new JScrollPane(graphicsPanel), BorderLayout.CENTER);
    this.setVisible(true);
  }

  /**
   * Update album.
   */
  public void updateAlbum() {
    snapshotLabel.updatePanel(currentSnapshot);
    snapshotLabel.repaint();
    graphicsPanel.updatePanel(currentSnapshot);
    graphicsPanel.repaint();
  }

}
