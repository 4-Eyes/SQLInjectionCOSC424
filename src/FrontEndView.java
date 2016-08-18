package src;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrontEndView extends JFrame {
   private FrontEnd aFrontEnd = null;
   private BackEnd aBackEnd = null;
   private JTextArea displayArea = null;
   private JTextField userBox = null;
   private JTextField passBox = null;
   private JRadioButton nonPreparedButton = null;
   private JRadioButton preparedButton = null;
   private ButtonGroup buttonGroup = null;
   private JCheckBox metaCharFilterBox = null;

   public FrontEndView(FrontEnd var1) {
      this.initialize();
      this.aFrontEnd = var1;
   }

   private void initialize() {
      JPanel var1 = new JPanel();
      JLabel var2 = new JLabel();
      JLabel var3 = new JLabel();
      JLabel var4 = new JLabel();
      this.userBox = new JTextField("");
      this.passBox = new JTextField("");
      Button var5 = new Button("Authenticate User");
      this.displayArea = new JTextArea(10, 35);
      this.preparedButton = new JRadioButton("Prepared Statement", false);
      this.nonPreparedButton = new JRadioButton("Regular Statement", true);
      this.buttonGroup = new ButtonGroup();
      this.metaCharFilterBox = new JCheckBox("MetaCharacter Filtering", false);

      try {
         this.setDefaultCloseOperation(2);
         this.setSize(640, 480);
         this.setTitle("SQL Injection Testing Application");
         var2.setFont(new Font("Arial", 1, 30));
         var2.setText("SQL Injection Testing Application");
         var2.setBounds(13, 21, 600, 34);
         var2.setForeground(Color.blue);
         var2.setHorizontalAlignment(0);
         this.preparedButton.setBounds(50, 60, 200, 20);
         this.nonPreparedButton.setBounds(50, 90, 2000, 20);
         this.buttonGroup.add(this.preparedButton);
         this.buttonGroup.add(this.nonPreparedButton);
         this.metaCharFilterBox.setBounds(50, 120, 200, 20);
         var3.setFont(new Font("Arial", 1, 18));
         var3.setText("Username:");
         var3.setBounds(100, 170, 200, 35);
         var4.setForeground(Color.black);
         var4.setFont(new Font("Arial", 1, 18));
         var4.setText("Password:");
         var4.setBounds(100, 270, 200, 35);
         var4.setForeground(Color.black);
         this.userBox.setBounds(100, 220, 100, 35);
         this.userBox.setEditable(true);
         this.passBox.setBounds(100, 320, 100, 35);
         this.passBox.setEditable(true);
         this.displayArea.setBounds(320, 75, 260, 280);
         var5.setBounds(65, 400, 180, 35);
         var5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent var1) {
               String var2 = FrontEndView.this.aFrontEnd.processInput(FrontEndView.this.userBox.getText(), FrontEndView.this.passBox.getText(), FrontEndView.this.preparedButton.isSelected(), FrontEndView.this.metaCharFilterBox.isSelected());
               FrontEndView.this.displayArea.setText(var2);
            }
         });
         var1.setLayout((LayoutManager)null);
         var1.add(var2);
         var1.add(this.displayArea);
         var1.add(this.preparedButton);
         var1.add(this.nonPreparedButton);
         var1.add(this.metaCharFilterBox);
         var1.add(var3);
         var1.add(var4);
         var1.add(this.userBox);
         var1.add(this.passBox);
         var1.add(var5);
         this.setContentPane(var1);
      } catch (Throwable var7) {
         System.err.println("Exception occurred in initialize() of sqlInjectionApplication");
         var7.printStackTrace(System.out);
      }

   }

   public static void main(String[] var0) {
      try {
         BackEnd var1 = new BackEnd();
         FrontEnd var2 = new FrontEnd(var1);
         FrontEndView var3 = new FrontEndView(var2);
         var3.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent var1) {
               System.exit(0);
            }
         });
         var3.setVisible(true);
      } catch (Throwable var4) {
         System.err.println("Exception occurred in main() of FrontEndView");
         var4.printStackTrace(System.out);
      }

   }
}
