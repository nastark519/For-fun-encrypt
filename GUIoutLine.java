import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.io.*;
/**
 * Thi is the GUI set up for the final project that contains,
 * a text field, buttons, meun bar, Color chooser, 
 * and a scroll bar, that will acitvate when needed.
 * 
 * @author (Nathan Stark) 
 * @version (final_Project CS 162)
 */
public class GUIoutLine extends JFrame
{
    private Container content;
    private JButton button1, button2;
    private JSlider sizeSlider;
    private JScrollPane scrollPane;
    private JEditorPane editPane;
    private JRadioButton colorRed, colorBlack;

    /**
     * Constructor for objects of class GUIoutLine
     */
    public GUIoutLine()
    {
        super("My favorit Project");
        makeCompanents();
        contain();
        menu();
    }
    
    /**
     * Do what needs to be done for the text to be shifted.
     */
    private void otherEncrypt()
    {
        BetterShiftEncrypt encrypt = new BetterShiftEncrypt();
        String text;
        text = editPane.getText();
        editPane.setText(encrypt.apply(text));

    }

    /**
     * Do what needs to be done for the text to be shifted.
     */
    private void shiftEncrypt()
    {
        EncryptShift encrypt = new EncryptShift();
        String text;
        text = editPane.getText();
        editPane.setText(encrypt.apply(text));

    }

    /**
     * Do what needs to be done for changing font size
     * using the slider.
     */
    private void fontSlide()
    {
        String fontNam = editPane.getFont().getFontName();
        int styleNam = editPane.getFont().getStyle();

        editPane.setFont(new Font(fontNam,styleNam,sizeSlider.getValue()));
    }

    /**
     * Change the text color in the eaditor panel's text to red.
     */
    private void textToRed()
    {if(colorRed.isSelected()){
            editPane.setForeground(Color.red);
            colorBlack.setSelected(false);
        }
    }

    /**
     * Change the text color in the eaditor panel's text to black.
     */
    private void textToBlack()
    {
        if(colorBlack.isSelected()){
            editPane.setForeground(Color.black);
            colorRed.setSelected(false);
        }
    }

    /**
     * Make buttons a slider the label for the slider and radio buttons.
     */
    private void makeCompanents()
    {
        button1 = new JButton("Shift Encrypt");
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { shiftEncrypt(); }
            });
        button2 = new JButton("Other Encrypt");
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { otherEncrypt(); }
            });

        sizeSlider = new JSlider(3,36,12);
        sizeSlider.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) { 
                    fontSlide();}
            });
        colorRed = new JRadioButton("Red");
        colorRed.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { textToRed();}
            });
        colorBlack = new JRadioButton("Black", true);
        colorBlack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { textToBlack();}
            });

        editPane = new JEditorPane();
        scrollPane = new JScrollPane(editPane);
    }

    /**
     * The bacic construct to the panel.
     */
    private void contain()
    {
        content =  getContentPane();

        JFrame east = new JFrame();
        Container contentEast = east.getContentPane();
        contentEast.setLayout(new BoxLayout(contentEast, BoxLayout.Y_AXIS));

        contentEast.add(button1);
        contentEast.add(button2);
        contentEast.add(colorRed);
        contentEast.add(colorBlack);
        contentEast.add(new JLabel("Font Size Slider"));
        contentEast.add(sizeSlider);
        content.add(contentEast,BorderLayout.EAST);

        content.add(scrollPane, BorderLayout.CENTER);

        pack();
        setSize(900,700);
        setVisible(true);
    }

    /**
     * creates the menue bar.
     */
    private void menu()
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        menu = new JMenu("File");

        item = new JMenuItem("Save");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    saved();
                }
            });
        menu.add(item);

        item = new JMenuItem("Clear");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clear();
                }
            });
        menu.add(item);

        item = new JMenuItem("Quit");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quit();
                }
            });
        menu.add(item);
        menubar.add(menu);

        menu = new JMenu("Options");

        item = new JMenuItem("Help");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    help();
                }
            });
        menu.add(item);
        menubar.add(menu);

    }

    /**
     * Clears the text field used.
     */
    private void clear()
    {
        editPane.setText("");
    }

    /**
     * quit closes the program when called.
     */
    private void quit()
    {
        System.exit(0);
    }

    /**
     * Displays information about the project to help the user
     * understand what it can be used for.
     */
    private void help()
    {
        JOptionPane.showMessageDialog(this,
            "This is a simple encryption text wirter. \n" +
            "You should give it a go.",
            "Help to understand",
            JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Creats a text file of what has been encrypted.
     */
    private void saved()
    {
        try{
            int n = 1;
            FileWriter writer = new FileWriter("codedMessage" + n + ".txt");
            writer.write(editPane.getText() + "\r\n");
            n++;
            writer.close();
        }
        catch(IOException e){
            System.err.println("There was a problem writing to " +
                "codedMessage");
        }
    }

}