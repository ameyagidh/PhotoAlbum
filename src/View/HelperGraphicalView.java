package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Controller.ControlledShapes;
import Models.IModel;
import Models.SnapShot;

public class HelperGraphicalView extends JFrame{
  private SnapShot snapshot;
  private IModel multiple_snapshots;
  private PanelView panel;
  private ControlledShapes controller_obj;
  private int Counter = 0;
  private JPanel SnapShot_Panel;
  private JLabel SnapShot_ID;
  private JLabel description;
  private int X_Max;
  private int Y_Max;

  public HelperGraphicalView(IModel multiple_snapshots, int X_Max, int Y_Max) {
    this.multiple_snapshots = multiple_snapshots;
    this.X_Max = X_Max;
    this.Y_Max = Y_Max;
  }

  public void draw_viewhelper() {
  snapshot = multiple_snapshots.getSnapShotsList().get(Counter);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    if ((X_Max == 0) || (Y_Max == 0)) {
    this.setSize(1000, 1000);
  } else {
    this.setSize(this.X_Max, this.Y_Max);
  }
  panel = new PanelView(snapshot);
    panel.setBackground(new Color(28, 104, 163));
  SnapShot_Panel = new JPanel();
  SnapShot_ID = new JLabel("<html>" + snapshot.getSnapShotID() + "<br/>" + "</html>");
  description = new JLabel("<html>" + snapshot.getDescription() + "</html>");

    SnapShot_Panel.add(SnapShot_ID, BorderLayout.WEST);
    SnapShot_Panel.add(description, BorderLayout.WEST);
    SnapShot_Panel.setBackground(new Color(234, 14, 72));
    this.add(SnapShot_Panel, BorderLayout.NORTH);
    this.add(panel, BorderLayout.CENTER);
  JButton Previous_Button = new JButton("<< Prev <<");
  JButton Select_Button = new JButton("^^Select^^");
  JButton Next_Button = new JButton(">> Next >>");
  JButton Quit_Button = new JButton("xx Quit xx");
    Next_Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      if (Counter < multiple_snapshots.getSnapShotsList().size() - 1) {
        Counter += 1;
        snapshot = multiple_snapshots.getSnapShotsList().get(Counter);
        ReDraw();
      } else {
        JFrame j1 = new JFrame("Message");
        JLabel l1 = new JLabel("Start of photo album. No snapshots to show beyond this one.");
        j1.add(l1);
        j1.setSize(150, 150);
        j1.setVisible(true);
      }
    }
  });
    Select_Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      JFrame j1 = new JFrame();
      List<String> SnapShot_IDs = new ArrayList<String>();
      for (SnapShot snapShot : multiple_snapshots.getSnapShotsList()) {
        SnapShot_IDs.add(snapShot.getSnapShotID());
      }
      JComboBox comboBox = new JComboBox(SnapShot_IDs.toArray());
      comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          JComboBox j1 = (JComboBox) actionEvent.getSource();
          String SnapShot_ID = j1.getSelectedItem().toString();
          for (int i = 0; i < multiple_snapshots.getSnapShotsList().size(); i++) {
            if (multiple_snapshots.getSnapShotsList().get(i).getSnapShotID().equalsIgnoreCase(SnapShot_ID)) {
              Counter = i;
            }
          }
          snapshot = multiple_snapshots.getSnapShotsList().get(Counter);
          ReDraw();
        }
      });
      j1.add(comboBox);
      j1.setSize(150, 150);
      j1.setVisible(true);
    }
  });

    Previous_Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      if (Counter > 0) {
        Counter -= 1;
        snapshot = multiple_snapshots.getSnapShotsList().get(Counter);
        ReDraw();
      } else {
        JFrame j1 = new JFrame("Message");
        JLabel l1 = new JLabel("End of photo album. No snapshots to show beyond this one.");
        j1.add(l1);
        j1.setSize(150, 150);
        j1.setVisible(true);
      }
    }
  });
    Quit_Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      dispose();
    }
  });
  JPanel Button_Panel = new JPanel();
    Button_Panel.setBackground(new Color(211, 226, 16));
    Button_Panel.add(Previous_Button);
    Button_Panel.add(Select_Button);
    Button_Panel.add(Next_Button);
    Button_Panel.add(Quit_Button);
    this.add(Button_Panel, BorderLayout.SOUTH);
    this.setVisible(true);

}

  public void ReDraw() {
    this.SnapShot_ID.setText(snapshot.getSnapShotID());
    this.description.setText(snapshot.getDescription());
    this.panel.setSnapshot(snapshot);
    this.panel.repaint();
    this.setVisible(true);
  }

}
