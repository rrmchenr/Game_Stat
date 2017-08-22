   _____                      _____   _             _         
  / ____|                    / ____| | |           | |        
 | (___    _   _   _ __     | (___   | |_    __ _  | |_   ___ 
  \___ \  | | | | | '_ \     \___ \  | __|  / _` | | __| / __|
  ____) | | |_| | | |_) |    ____) | | |_  | (_| | | |_  \__ \
 |_____/   \__,_| | .__/    |_____/   \__|  \__,_|  \__| |___/
                  | |                                         
                  |_|                                         

README

	GameStats is a Java Gui program that allows table creation into an hml
	file for organization and simpler input for fighting games. Once
	downloaded, you may run the file executable "SupStats" that will
	launch the gui.

Motivation

	GameStats was created to make it easier to create tables with color,
	organization, and formatting. It also collets data to be used to
	help players figure out their habbits and how to best improve.

Installation

	Unzip all the files and run the executable. For database functionality
	the user name "root" was used with no password. jdbc:mysql://localhost:3306/mysql
	is the local database name used with XAMPP to establish a connection.
	The table creator will still work if a database connection can not be reached.

Functionality
	
	"Create table" - Once the user has input what they want into the Java Gui,
	the "Create table" button can be pressed. This creates, or edits an HML file
	with already colored, and formated text. These stats are saved onto a database
	for future use for the user. 

	"Save and Open" - This button saves the tables created by the user, and opens
	the file they created. This is where they may view the tables and data
	analysis can begin.

BUGS

	Certain file names are difficult for the system to work with. EX: Spacebar only
	file names. 
	

