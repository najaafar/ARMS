/*
	MainFrame.java
	- main class for the GUI. A simple GUI that runs the program in the terminal.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class MainFrame {

    public static void main(String s[]) {

        initFrame();

    }

    public static void initFrame(){
        //init frame and content pane
        createAndShowGUI();
    }

    public static void addComponentsToPane(Container pane) {

        JButton button = new JButton();
        JPanel header, output, parameters, window;
        header = new JPanel(new BorderLayout());
        output = new JPanel();
        parameters = new JPanel();
        parameters.setPreferredSize(new Dimension(200, 300));
        window = new JPanel(new BorderLayout());

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
            
            //Create the menu bar.
            menuBar = new JMenuBar();
            
            //Build the first menu.
            menu = new JMenu("File");
            menu.setMnemonic(KeyEvent.VK_A);
            menu.getAccessibleContext().setAccessibleDescription("File");
            menuBar.add(menu);
            
            //a group of JMenuItems
            menuItem = new JMenuItem("Load project", KeyEvent.VK_T);
            //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
            menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("Open project from a directory");
            menu.add(menuItem);

            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
                    dialog.setMode(FileDialog.LOAD);
                    dialog.setVisible(true);
                    String file = dialog.getFile();

                    if(file.endsWith("txt")) {
                        Main.main(null);
                    }

                    else {
                        System.out.println("Invalid file.");
                    }
                    
                }
            });

            menuItem = new JMenuItem("Close project", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("Close project");
            menu.add(menuItem);            

            //a submenu
            menu.addSeparator();
            menuItem = new JMenuItem("Open File", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("Open a file from the project");
            menu.add(menuItem);

            menuItem = new JMenuItem("Close File", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("Close the file");
            menu.add(menuItem);

            menu.addSeparator();
            menuItem = new JMenuItem("Exit", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("Exit the program");
            menu.add(menuItem);

            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            //Build second menu in the menu bar.
            menu = new JMenu("View");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription("View");
            menuBar.add(menu);
            
            //Build second menu in the menu bar.
            menu = new JMenu("Project");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription("Project");
            menuBar.add(menu);

            menuItem = new JMenuItem("Build Project", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("Build the project");
            menu.add(menuItem);
            
            //Build second menu in the menu bar.
            menu = new JMenu("Tools");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription("Tools");
            menuBar.add(menu);
            
            //Build second menu in the menu bar.
            menu = new JMenu("Help");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription("Help");
            menuBar.add(menu);

            menuItem = new JMenuItem("About", KeyEvent.VK_T);
            menuItem.getAccessibleContext().setAccessibleDescription("About the program");
            menu.add(menuItem);

        header.add(menuBar, BorderLayout.PAGE_START);

        JToolBar toolBar2 = new JToolBar();
        JButton run, timer;
        run = new JButton("RUN");
        timer = new JButton("TIMER");
        toolBar2.add(run);
        toolBar2.add(timer);
        header.add(toolBar2, BorderLayout.PAGE_END);

        pane.add(header, BorderLayout.PAGE_START);


        //Lay out the parameters.
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Project", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Parameters", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        parameters.add(tabbedPane);
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        pane.add(parameters, BorderLayout.LINE_START);
        tabbedPane.setPreferredSize(new Dimension(185, 60));

        //Lay out the window
        JToolBar toolBar = new JToolBar("Still draggable");
        JButton previous, stop, pause, play, next;
        previous = new JButton("PREV");
        stop = new JButton("STOP");
        pause = new JButton("PAUSE");
        play = new JButton("PLAY");
        next = new JButton("NEXT");
        toolBar.add(previous);
        toolBar.add(stop);
        toolBar.add(pause);
        toolBar.add(play);
        toolBar.add(next);

        //this is designated fow the animation window
        JTextArea textArea2 = new JTextArea(30, 30);
        textArea2.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea2);

        //Lay out the main panel.
        window.add(toolBar, BorderLayout.PAGE_START);
        window.add(scrollPane, BorderLayout.CENTER);

        pane.add(window, BorderLayout.LINE_END);

        //textarea for command line
        JTextArea textArea = new JTextArea();
        textArea.setColumns(50);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        JScrollPane jScrollPane1 = new JScrollPane(textArea);    
        pane.add(jScrollPane1, BorderLayout.PAGE_END);
    }

    private static JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(2, 2));
        panel.add(filler);
        return panel;
    }

    private static void createAndShowGUI() {
        
        //Create and set up the window.
        JFrame frame = new JFrame("BorderLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Use the content pane's default BorderLayout. No need for
        //setLayout(new BorderLayout());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
