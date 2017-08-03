package supstats;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupStats implements ActionListener {

    FileWriter writer;

    JTextField Title, Play1, Play2, Stock1, Stock2, Stock3, Stock4, Stock5, Stock6, Stock7, Stock8, Stock9, Stock10, Stock11, Stock12,
            Damage1, Damage2, Damage3, Damage4, Damage5, Damage6, Damage7, Damage8, Damage9, Damage10, Damage11, Damage12,
            Note1, Note2, Note3, Note4, Note5, Note6, Note7, Note8, Note9, Note10, Note11, Note12;

    JComboBox S1, S2, S3;

    JButton CloseFile, CreateTable;

    public static void main(String[] args) {
        System.out.println("Sup stats will be fire");

        new SupStats();
    }

    public SupStats() {
        JFrame guiFrame = new JFrame();
        GridLayout Lay = new GridLayout();
        guiFrame.setLayout(Lay);

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("SupStats");
        guiFrame.setSize(530, 400);

        Title = new JTextField(40);
        Play1 = new JTextField(7);
        Play2 = new JTextField(7);

        Stock1 = new JTextField("Stock 1", 5);
        Stock5 = new JTextField("Stock 5", 5);
        Stock9 = new JTextField("Stock 9", 5);

        Stock2 = new JTextField("Stock 2", 5);
        Stock6 = new JTextField("Stock 6", 5);
        Stock10 = new JTextField("Stock 10", 5);

        Stock3 = new JTextField("Stock 3", 5);
        Stock7 = new JTextField("Stock 7", 5);
        Stock11 = new JTextField("Stock 11", 5);

        Stock4 = new JTextField("Stock 4", 5);
        Stock8 = new JTextField("Stock 8", 5);
        Stock12 = new JTextField("Stock 12", 5);

        Damage1 = new JTextField("", 2);
        Damage5 = new JTextField("", 2);
        Damage9 = new JTextField("", 2);

        Damage2 = new JTextField("", 2);
        Damage6 = new JTextField("", 2);
        Damage10 = new JTextField("", 2);

        Damage3 = new JTextField("", 2);
        Damage7 = new JTextField("", 2);
        Damage11 = new JTextField("", 2);

        Damage4 = new JTextField("", 2);
        Damage8 = new JTextField("", 2);
        Damage12 = new JTextField("", 2);

        Note1 = new JTextField("", 6);
        Note5 = new JTextField("", 6);
        Note9 = new JTextField("", 6);

        Note2 = new JTextField("", 6);
        Note6 = new JTextField("", 6);
        Note10 = new JTextField("", 6);

        Note3 = new JTextField("", 6);
        Note7 = new JTextField("", 6);
        Note11 = new JTextField("", 6);

        Note4 = new JTextField("", 6);
        Note8 = new JTextField("", 6);
        Note12 = new JTextField("", 6);

        JLabel TitleText = new JLabel();
        JLabel Key = new JLabel(" |Died to|        |%|    |Notes|             |Died to|      |%|      |Notes|            |Died to|       |%|      |Notes|         ");
        JLabel Space = new JLabel("---------------------------------------------------------------------------------------------------------------------------------");
        JLabel G1 = new JLabel("Game1");
        JLabel G2 = new JLabel("Game2");
        JLabel G3 = new JLabel("Game3");
        JLabel Player1 = new JLabel("Player 1");
        JLabel Player2 = new JLabel("Player 2");

        TitleText.setText("Title");

        CloseFile = new JButton("Write and Save");
        CreateTable = new JButton("Create Table");
        CloseFile.addActionListener(this);
        CreateTable.addActionListener(this);

        final JPanel Panel = new JPanel();

        String[] Stages = {"Smashville", "Town and City", "Final Destination", "DreamLand", "Battlefield", "Lylat Cruise", " "};
        S1 = new JComboBox(Stages);
        S2 = new JComboBox(Stages);
        S3 = new JComboBox(Stages);

        Panel.add(TitleText);
        Panel.add(Title);

        Panel.add(G1);
        Panel.add(S1);
        Panel.add(G2);
        Panel.add(S2);
        Panel.add(G3);
        Panel.add(S3);

        Panel.add(Player1);
        Panel.add(Play1);
        Panel.add(Player2);
        Panel.add(Play2);

        Panel.add(Key);

        Panel.add(Stock1);
        Panel.add(Damage1);
        Panel.add(Note1);
        Panel.add(Stock5);
        Panel.add(Damage5);
        Panel.add(Note5);
        Panel.add(Stock9);
        Panel.add(Damage9);
        Panel.add(Note9);

        Panel.add(Stock2);
        Panel.add(Damage2);
        Panel.add(Note2);
        Panel.add(Stock6);
        Panel.add(Damage6);
        Panel.add(Note6);
        Panel.add(Stock10);
        Panel.add(Damage10);
        Panel.add(Note10);

        Panel.add(Space);

        Panel.add(Stock3);
        Panel.add(Damage3);
        Panel.add(Note3);
        Panel.add(Stock7);
        Panel.add(Damage7);
        Panel.add(Note7);
        Panel.add(Stock11);
        Panel.add(Damage11);
        Panel.add(Note11);

        Panel.add(Stock4);
        Panel.add(Damage4);
        Panel.add(Note4);
        Panel.add(Stock8);
        Panel.add(Damage8);
        Panel.add(Note8);
        Panel.add(Stock12);
        Panel.add(Damage12);
        Panel.add(Note12);

        Panel.add(CreateTable);
        Panel.add(CloseFile);
        boolean Keep = true;
        try {

            writer = new FileWriter("ShowAuntJoyce.htm", Keep);
            BufferedWriter bw = new BufferedWriter(writer);
            if (Keep == false) {
                writer.append(
                        "<HTML>\n"
                        + "<HEAD>\n"
                        + "<TITLE>Sup Stats</TITLE>\n"
                        + "<style> "
                        + "table, th, td{"
                        + "border: 1px solid white;}</style>"
                        + "\n"
                        + "<BODY BGCOLOR=\"#000000\" TEXT=\"#FFFFFF\" LINK=\"#FF0000\" VLINK=\"#FFFFFF\" ALINK=\"#00FF00\" BACKGROUND=\"path/filename\" >\n"
                        + "\n"
                        + "</HEAD>\n" + "<H1><font color=\"red\">S</font><font color=#fff550\"\">u</font><font color=\"yellow\">p</font><font color=#00ccff\"\">S</font><font color=\"blue\">t</font><font color=#A600FF>a</font><font color=\"purple\">t</font><font color=\"red\">s</font></H1>\n");
            }
        } catch (IOException exe) {
            System.exit(1);
        }

        guiFrame.add(Panel, BorderLayout.SOUTH);
        guiFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

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

        

        if (e.getSource() == CreateTable) {
            try {
                writer.append(
                        "<table style = \"width:100%\">"
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
                        + "<tr>" + "<td>" + Player2 + "</td>"
                        + "<td>Stock1: " + Life3 + " <font color=\"red\">(" + Damage3.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note3.getText() + ")</font> <BR><BR>"
                        + "Stock2: " + Life4 + " <font color=\"red\">(" + Damage4.getText() + "%) </font>" + "<font color=\"yellow\">(" + Note4.getText() + ")</font></td>"
                        + "<td>Stock1: " + Life7 + " <font color=\"red\">(" + Damage7.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note7.getText() + ")</font> <BR><BR>"
                        + "Stock2: " + Life8 + " <font color=\"red\">(" + Damage8.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note8.getText() + ")</font></td>"
                        + "<td>Stock1: " + Life11 + " <font color=\"red\">(" + Damage11.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note11.getText() + ")</font> <BR><BR>"
                        + "Stock2: " + Life12 + " <font color=\"red\">(" + Damage12.getText() + "%)</font> " + "<font color=\"yellow\">(" + Note12.getText() + ") </font></td>"
                        + "</tr><BR> <BR>"
                        + "</BODY>\n"
                        + "</HTML>");

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                    System.out.println("Connected!");

                    String insert = "INSERT INTO supstats_test(Tag,Percent,Stage,Died_To)" + "VALUES (?,?,?,?)";
                    PreparedStatement PS2 = con.prepareStatement(insert);
                    if (Damage1.getText().isEmpty() == false) {

                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage1.getText()));
                        PS2.setString(3, Stage1);
                        PS2.setString(4, Life1);

                        PS2.execute();
                    }
                    if (Damage2.getText().isEmpty() == false) {

                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage2.getText()));
                        PS2.setString(3, (Stage1));
                        PS2.setString(4, Life2);
                        PS2.execute();
                    }
                    if (Damage3.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage3.getText()));
                        PS2.setString(3, (Stage1));
                        PS2.setString(4, Life3);
                        PS2.execute();
                    }

                    if (Damage4.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage4.getText()));
                        PS2.setString(3, (Stage1));
                        PS2.setString(4, Life4);
                        PS2.execute();
                    }
                    if (Damage5.getText().isEmpty() == false) {
                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage5.getText()));
                        PS2.setString(3, (Stage2));
                        PS2.setString(4, Life5);
                        PS2.execute();
                    }

                    if (Damage6.getText().isEmpty() == false) {
                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage6.getText()));
                        PS2.setString(3, (Stage2));
                        PS2.setString(4, Life6);
                        PS2.execute();
                    }

                    if (Damage7.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage7.getText()));
                        PS2.setString(3, (Stage2));
                        PS2.setString(4, Life7);
                        PS2.execute();
                    }

                    if (Damage8.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage8.getText()));
                        PS2.setString(3, (Stage2));
                        PS2.setString(4, Life8);
                        PS2.execute();
                    }

                    if (Damage9.getText().isEmpty() == false) {
                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage9.getText()));
                        PS2.setString(3, (Stage3));
                        PS2.setString(4, Life9);
                        PS2.execute();
                    }

                    if (Damage10.getText().isEmpty() == false) {
                        PS2.setString(1, Player1);
                        PS2.setInt(2, Integer.parseInt(Damage10.getText()));
                        PS2.setString(3, (Stage3));
                        PS2.setString(4, Life10);
                        PS2.execute();
                    }

                    if (Damage11.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage11.getText()));
                        PS2.setString(3, (Stage3));
                        PS2.setString(4, Life11);
                        PS2.execute();
                    }

                    if (Damage12.getText().isEmpty() == false) {
                        PS2.setString(1, Player2);
                        PS2.setInt(2, Integer.parseInt(Damage12.getText()));
                        PS2.setString(3, (Stage3));
                        PS2.setString(4, Life12);
                        PS2.execute();
                    }

                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }

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

            } catch (IOException ex) {
                System.exit(1);
            }
        } else if (e.getSource() == CloseFile) {
            try {
                writer.close();
            } catch (IOException lol) {
            }
        }
    }

}
