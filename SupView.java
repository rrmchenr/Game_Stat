
package supstats.Game_Stats;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class SupView extends JFrame{
    
    int tables;
    
        JTextField FileField, Title, Play1, Play2, Stock1, Stock2, Stock3, Stock4, Stock5, Stock6, Stock7, Stock8, Stock9, Stock10, Stock11, Stock12,
            Damage1, Damage2, Damage3, Damage4, Damage5, Damage6, Damage7, Damage8, Damage9, Damage10, Damage11, Damage12,
            Note1, Note2, Note3, Note4, Note5, Note6, Note7, Note8, Note9, Note10, Note11, Note12;
        
        public JRadioButton DB;
        public JRadioButton NoDB;
        public ButtonGroup DataBase;
        
        JComboBox S1, S2, S3;
        
        private JLabel TableLabel = new JLabel("lol");
        
        JButton CloseFile, CreateTable;
    
        
        SupView(){
                
        //variables for the java Gui
        UIManager.put("Button.background", Color.GRAY);
        UIManager.put("Button.foreground", Color.YELLOW);
        UIManager.put("Panel.background", Color.LIGHT_GRAY);

       JFrame guiFrame = new JFrame();
        GridLayout Lay = new GridLayout();
        this.setLayout(Lay);
        
        //Gui settings initilised
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SupStats");
        this.setSize(525, 400);
        this.setResizable(false);
        FileField = new JTextField("", 30);
        Title = new JTextField(40);
        Play1 = new JTextField(7);
        Play2 = new JTextField(7);
        
        //First row of stock inputs
        Stock1 = new JTextField("Stock 1", 5);
        Stock5 = new JTextField("Stock 5", 5);
        Stock9 = new JTextField("Stock 9", 5);

        //Second row of stock inputs
        Stock2 = new JTextField("Stock 2", 5);
        Stock6 = new JTextField("Stock 6", 5);
        Stock10 = new JTextField("Stock 10", 5);

        //Third row of stock inputs
        Stock3 = new JTextField("Stock 3", 5);
        Stock7 = new JTextField("Stock 7", 5);
        Stock11 = new JTextField("Stock 11", 5);

        //Fourth row of stock inputs
        Stock4 = new JTextField("Stock 4", 5);
        Stock8 = new JTextField("Stock 8", 5);
        Stock12 = new JTextField("Stock 12", 5);

        //First row of damage inputs
        Damage1 = new JTextField("", 2);
        Damage5 = new JTextField("", 2);
        Damage9 = new JTextField("", 2);

        //Second row of damage inputs
        Damage2 = new JTextField("", 2);
        Damage6 = new JTextField("", 2);
        Damage10 = new JTextField("", 2);

        //Third row of damage inputs
        Damage3 = new JTextField("", 2);
        Damage7 = new JTextField("", 2);
        Damage11 = new JTextField("", 2);

        //Fourth row of damage inputs
        Damage4 = new JTextField("", 2);
        Damage8 = new JTextField("", 2);
        Damage12 = new JTextField("", 2);

        //First row of note inputs
        Note1 = new JTextField("", 6);
        Note5 = new JTextField("", 6);
        Note9 = new JTextField("", 6);

        //First row of note inputs
        Note2 = new JTextField("", 6);
        Note6 = new JTextField("", 6);
        Note10 = new JTextField("", 6);
        
        //First row of note inputs
        Note3 = new JTextField("", 6);
        Note7 = new JTextField("", 6);
        Note11 = new JTextField("", 6);
        
        //First row of note inputs
        Note4 = new JTextField("", 6);
        Note8 = new JTextField("", 6);
        Note12 = new JTextField("", 6);
        
        NoDB = new JRadioButton("No Database",true);
        DB = new JRadioButton("Database",false);
        
        //Gui Layout 
        JLabel File = new JLabel("File name/Old File name");
        JLabel TitleText = new JLabel();
        JLabel Key = new JLabel(" |Died to|        |%|    |Notes|             |Died to|      |%|      |Notes|            |Died to|       |%|      |Notes|         ");
        JLabel Space = new JLabel("---------------------------------------------------------------------------------------------------------------------------------");
        JLabel G1 = new JLabel("Game1");
        JLabel G2 = new JLabel("Game2");
        JLabel G3 = new JLabel("Game3");
        JLabel Player1 = new JLabel("Player 1");
        JLabel Player2 = new JLabel("Player 2");
        
        //counts the number of tables 
        TableLabel = new JLabel("             Number of tables created  " + tables + " ");

        TitleText.setText("Title");
        
        //creates buttons and adds action listeners
        CloseFile = new JButton("Save and open");
        CreateTable = new JButton("Create Table");
        //SupStats s = new SupStats();
        //CloseFile.addActionListener(s);
        //CreateTable.addActionListener(s);

        //creates a Panel for all the interface options to go.
        final JPanel Panel = new JPanel();

        String[] Stages = {"Smashville", "Town and City", "Final Destination", "DreamLand", "Battlefield", "Lylat Cruise", " "};
        S1 = new JComboBox(Stages);
        S2 = new JComboBox(Stages);
        S3 = new JComboBox(Stages);
        
        // adds title lables and Title text field 
        Panel.add(TitleText);
        Panel.add(Title);
        
        //adds Game and stage selections
        Panel.add(G1);
        Panel.add(S1);
        Panel.add(G2);
        Panel.add(S2);
        Panel.add(G3);
        Panel.add(S3);
        
        //adds player lables, and text fields
        Panel.add(Player1);
        Panel.add(Play1);
        Panel.add(Player2);
        Panel.add(Play2);
        
        //adds top lables for clearer user input
        Panel.add(Key);
        
        //adds the first row of inputs
        Panel.add(Stock1);
        Panel.add(Damage1);
        Panel.add(Note1);
        Panel.add(Stock5);
        Panel.add(Damage5);
        Panel.add(Note5);
        Panel.add(Stock9);
        Panel.add(Damage9);
        Panel.add(Note9);
        
        //adds the second row of inputs
        Panel.add(Stock2);
        Panel.add(Damage2);
        Panel.add(Note2);
        Panel.add(Stock6);
        Panel.add(Damage6);
        Panel.add(Note6);
        Panel.add(Stock10);
        Panel.add(Damage10);
        Panel.add(Note10);
        
        // puts space between the player inputs
        Panel.add(Space);
        
        //adds the third row of inputs
        Panel.add(Stock3);
        Panel.add(Damage3);
        Panel.add(Note3);
        Panel.add(Stock7);
        Panel.add(Damage7);
        Panel.add(Note7);
        Panel.add(Stock11);
        Panel.add(Damage11);
        Panel.add(Note11);
        
        //adds the fourth and final row of inputs
        Panel.add(Stock4);
        Panel.add(Damage4);
        Panel.add(Note4);
        Panel.add(Stock8);
        Panel.add(Damage8);
        Panel.add(Note8);
        Panel.add(Stock12);
        Panel.add(Damage12);
        Panel.add(Note12);
        
        //adds table counter label
        Panel.add(TableLabel);
        
        //adds buttons
        Panel.add(CreateTable);
        Panel.add(CloseFile);
        
        //adds file input lable and input
        Panel.add(File);
        Panel.add(FileField);
        
        Panel.add(NoDB);
        Panel.add(DB);
        
        DataBase = new ButtonGroup();
        DataBase.add(NoDB);
        DataBase.add(DB);
        
        tables = 0;
        
        //Creates the Gui and makes int visible
        this.add(Panel);
        //guiFrame.setVisible(true);
        }
        void addCreateTableListener(ActionListener listenForCreateTableButton){
        CreateTable.addActionListener(listenForCreateTableButton);
        CloseFile.addActionListener(listenForCreateTableButton);
        }
       public String getTableString(){
        String Life1 = Stock1.getText();
        String Life2 = Stock2.getText();
        String Life3 = Stock3.getText();
        String Life4 = Stock4.getText();
        String Life5 = Stock5.getText();
        String Life6 = Stock6.getText();
        String Life7 = Stock7.getText();
        String Life8 = Stock8.getText();
        String Life9 = Stock9.getText();
        String Life10 = Stock10.getText();
        String Life11 = Stock11.getText();
        String Life12 = Stock12.getText();
        String table =        "<HTML>\n"
                            + "<HEAD>\n"
                            + "<TITLE>Sup Stats</TITLE>\n"
                            + "<style> "
                            + "table, th, td{"
                            + "border: 1px solid white;}</style>"
                            + "\n"
                            + "<BODY BGCOLOR=\"#000000\" TEXT=\"#FFFFFF\" LINK=\"#FF0000\" VLINK=\"#FFFFFF\" ALINK=\"#00FF00\" BACKGROUND=\"path/filename\" >\n"
                            + "\n"
                            + "\n"
                            + "<table style = \"width:100%\">"
                            + "<caption><h3>" + Title.getText() + "</h3></caption><tr>"
                            + "<th> </th>"
                            + "<th>" + S1.getSelectedItem() + "</th>"
                            + "<th>" + S2.getSelectedItem() + "</th>"
                            + "<th>" + S3.getSelectedItem() + "</th>"
                            + "</tr>"
                            + "<tr>"
                            + "<td>" + Play1.getText() + "</td>"
                            + "<td>Stock1: " + Life1 + " <font color=\"red\">(" + Damage1.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note1.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life2 + "<font color=\"red\"> (" + Damage2.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note2.getText() + ")</font>"
                            + "<td>Stock1: " + Life5 + "<font color=\"red\"> (" + Damage5.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note5.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life6 + " <font color=\"red\">(" + Damage6.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note6.getText() + ")</font></td>"
                            + "<td>Stock1: " + Life9 + " <font color=\"red\">(" + Damage9.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note9.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life10 + " <font color=\"red\">(" + Damage10.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note10.getText() + ")</font> </td>"
                            + "</tr>"
                            + "<tr>" + "<td>" + Play2.getText() + "</td>"
                            + "<td>Stock1: " + Life3 + " <font color=\"red\">(" + Damage3.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note3.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life4 + " <font color=\"red\">(" + Damage4.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note4.getText() + ")</font></td>"
                            + "<td>Stock1: " + Life7 + " <font color=\"red\">(" + Damage7.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note7.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life8 + " <font color=\"red\">(" + Damage8.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note8.getText() + ")</font></td>"
                            + "<td>Stock1: " + Life11 + " <font color=\"red\">(" + Damage11.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note11.getText() + ")</font> <BR><BR>"
                            + "Stock2: " + Life12 + " <font color=\"red\">(" + Damage12.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note12.getText() + ") </font></td>"
                            + "</tr><BR> <BR>"
                            + "</BODY>\n"
                            + "</HTML>";
       
        return table;
       
       }
       public void insertData(){
        String Player1 = Play1.getText();
        String Player2 = Play2.getText();
        String Stage1 = (String) S1.getSelectedItem();
        String Stage2 = (String) S2.getSelectedItem();
        String Stage3 = (String) S3.getSelectedItem();
                String Life1 = Stock1.getText();
        String Life2 = Stock2.getText();
        String Life3 = Stock3.getText();
        String Life4 = Stock4.getText();
        String Life5 = Stock5.getText();
        String Life6 = Stock6.getText();
        String Life7 = Stock7.getText();
        String Life8 = Stock8.getText();
        String Life9 = Stock9.getText();
        String Life10 = Stock10.getText();
        String Life11 = Stock11.getText();
        String Life12 = Stock12.getText();

                
       }
       public void InsertError(){
       JOptionPane.showMessageDialog(this, "Please Give a title and file name");
       }
       
       public void reset(){
       Title.setText("");

            Play1.setText("");
            Play2.setText("");
            this.S1.setSelectedIndex(0);
            this.S2.setSelectedIndex(0);
            this.S3.setSelectedIndex(0);
            Stock1.setText("Stock 1");
            Stock2.setText("Stock 2");
            Stock3.setText("Stock 3");
            Stock4.setText("Stock 4");
            Stock5.setText("Stock 5");
            Stock6.setText("Stock 6");
            Stock7.setText("Stock 7");
            Stock8.setText("Stock 8");
            Stock9.setText("Stock 9");
            Stock10.setText("Stock 10");
            Stock11.setText("Stock 11");
            Stock12.setText("Stock 12");
            Damage1.setText("");
            Damage2.setText("");
            Damage3.setText("");
            Damage4.setText("");
            Damage5.setText("");
            Damage6.setText("");
            Damage7.setText("");
            Damage8.setText("");
            Damage9.setText("");
            Damage10.setText("");
            Damage11.setText("");
            Damage12.setText("");
            Note1.setText("");
            Note2.setText("");
            Note3.setText("");
            Note4.setText("");
            Note5.setText("");
            Note6.setText("");
            Note7.setText("");
            Note8.setText("");
            Note9.setText("");
            Note10.setText("");
            Note11.setText("");
            Note12.setText("");
            tables++;
            TableLabel.setText("             Number of tables created  " + tables + " ");
            
            
       }      

}

