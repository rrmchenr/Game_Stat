package supstats.Game_Stats;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SupController {
    FileWriter writer;
    private final SupView theView;
    private  final Player thePlayer;
    boolean flag;
    String Stage;
    String Tag;
    
    public SupController(SupView theView, Player thePlayer){
        flag = false;
        this.theView = theView;
        this.thePlayer = thePlayer;
        
        this.theView.addCreateTableListener(new SupListener());
        
    
    }
    class SupListener implements ActionListener{

        
        @Override
        public void actionPerformed(ActionEvent ae) {
            //CreateTable button is pressed
            
            if(ae.getSource()==theView.CreateTable){
                //if a file writer has not been made, then make it
                if(flag==false){
                    makeFile();
                    
                }
                //Checks to see if the title and file fields are filled in
                if (theView.FileField.getText().isEmpty() == false && theView.Title.getText().isEmpty()==false)
                {
                    makeList();
                    if(theView.DB.isSelected()==true){
                    insertData();
                    }
                try{
                BufferedWriter bw = new BufferedWriter(writer);
                
                //Creates the table to be put on the file
                writer.append(theView.getTableString());
                
                //Inserts data in to the database
                theView.insertData();
                
                //resets fields in the Java Gui
                theView.reset();
                
                } catch (IOException ex) {
                    Logger.getLogger(SupController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else{
                    //Tells the user to input fields correctly
                theView.InsertError();
                }

            }
            if(ae.getSource()==theView.CloseFile){

            close();
            
            }
        }
    
    }
    public void close(){
                try {
                    File file;
                    file = new File(theView.FileField.getText() + ".htm");
                                        // file varable to be used to obtain a path.//temp file to get the path of file user created
                    File temp;

                    temp = new File(file.getAbsolutePath());
                    
                    //Opens the file
                    Desktop desktop =  Desktop.getDesktop();
                    desktop.open(temp);
                    //Closes the writer, and the program.
                    writer.close();
                    System.exit(0);
                        
                } catch (IOException IOex) {
                }
}
public void makeFile(){
        try {
            writer = new FileWriter(theView.FileField.getText() + ".htm", true);
            flag = true;
        } catch (IOException ex) {
            Logger.getLogger(SupController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void makeList(){
if(theView.Damage1.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock1.getText(), theView.Damage1.getText(), theView.Note1.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage2.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock2.getText(), theView.Damage2.getText(), theView.Note2.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage3.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock3.getText(), theView.Damage3.getText(), theView.Note3.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage4.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock4.getText(), theView.Damage4.getText(), theView.Note4.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage5.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock5.getText(), theView.Damage5.getText(), theView.Note5.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage6.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock6.getText(), theView.Damage6.getText(), theView.Note6.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage7.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock7.getText(), theView.Damage7.getText(), theView.Note7.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage8.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock8.getText(), theView.Damage8.getText(), theView.Note8.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage9.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock9.getText(), theView.Damage9.getText(), theView.Note9.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage10.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock10.getText(), theView.Damage10.getText(), theView.Note10.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage11.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock11.getText(), theView.Damage11.getText(), theView.Note11.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}
if(theView.Damage12.getText().isEmpty() == false){
thePlayer.addStocks(theView.Stock12.getText(), theView.Damage12.getText(), theView.Note12.getText());
}
else
{
    thePlayer.addStocks(" ", " "," " );
}

}

public void insertData(){
    Stage = theView.S1.getSelectedItem().toString();
    Tag = theView.Play1.getText();
try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            System.out.println("Connected!");
            
            String insert = "INSERT INTO supstats_test(Tag,Percent,Stage,Died_To)" + "VALUES (?,?,?,?)";
                PreparedStatement PS2 = con.prepareStatement(insert);
for(int i = 0;i<=11;i++){
                if (!" ".equals(thePlayer.getDiedTo(i))) {
                    if(i%4==0 && i!=0){
                    switchStage();
                    }
                    if(i%2==0 && i!=0){
                    switchTag();
                    }
                    PS2.setString(1, Tag);
                    PS2.setInt(2, Integer.parseInt(thePlayer.getPercent(i)));
                    PS2.setString(3,Stage );
                    PS2.setString(4, thePlayer.getDiedTo(i));

                    PS2.execute();
                    System.out.println(Stage + Tag + thePlayer.getDiedTo(i));
                }
}

        } catch (SQLException ex) {
            Logger.getLogger(SupView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
public void switchStage(){
if(Stage==theView.S1.getSelectedItem().toString()){
Stage = theView.S2.getSelectedItem().toString();
}
else{
Stage = theView.S3.getSelectedItem().toString();
}
    
}


public void switchTag(){
if(Tag.equals(theView.Play1.getText())){
    Tag=theView.Play2.getText().toString();
}
else{
Tag=theView.Play1.getText();
}

}
}
