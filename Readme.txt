/* =================================================================================
*  author: Allen.Zhang created at CST March 17, 2024 22:25
* =================================================================================
*/


	This "LibaryManagerApp" is an Android APP source code for a sample libary management system.

    Unfortunately, due to my time constraints, I only have 3 to 4 hours to complete it, so I can only write a simple instance and framework. I have only added brief notes on many implementation details and did not have time to implement them.
	
	Additionally, due to the outdated version of the Android Studio tool on my personal laptop, as well as limited access to the Google server in a home network environment, the code I wrote cannot be compiled in Android Studio. Therefore, my code was written blindly and I did not compile PASS or attempt to run it (in fact, my time does not allow me to do these attempts), This is truly a sorry and regrettable thing.
	
	Here is my brief explanation and design concept of the code for this APP:
	
	I developed this Android app using Android Studio tool, which is designed to help a library design a simple book borrowing and returning record management system. So i writed a simplified version of the framework. Assuming that this library has a total of 1000 books and is open to borrowing services for 50 readers, each reader can borrow up to 6 books at the same time. The maximum borrowing period for each book is 3 months. If a reader returns any book beyond this period, the management system will issue a warning to that reader and stop their permission to borrow the remaining books. Each of these 1000 books has a unique book identification ID in the management system, and each of these 50 readers has a unique reader identification ID in the management system. I just writed a simplified version of an Android library management system application based on these requirements, and the code been written in Koltin language.
	
	To develop a simplified version of an Android library management system application, i first need to define some core data structures and business logic. The following is a simple framework based on Kotlin language, which includes the basic ideas of data model, business logic, and interface design.
	
	data model 1 --- Book  (in "Book.kt" file)
	
	data model 2 --- Reader  (in "Reader.kt" file)
	
	data model 3 --- Library  (in "Library.kt" file)

	UI design part:

    Activity 1 --- MainActivity
		This is the home page activity of APP.
		Display basic information about the library, such as the number of books in collection, the number of readers, etc.
		Provide an entrance for borrowing, returning, and viewing overdue books.

	Activity 2 --- BorrowBookActivity
		Display a list of available books for borrowing.
		Provide search function to facilitate readers in searching for books.
		Display book details, including title, author, borrowing status, etc.
		Provide a borrowing button and call the BorrowBook method of the Library.

	Activity 3 --- ReturnBookActivity
		Display the list of books currently borrowed by the reader.
		Provide a return button and call the ReturnBook method of the Library.

	Activity 4 --- OverdueBooksActivity
		Display a list of overdue books and corresponding reader information.
		Provide warning prompts, such as sending notifications or emails to relevant readers and administrators.

    Implementation of other key features logic:
	
	In Android Studio, i need to create corresponding Activity and Fragment to implement the above interface, and call the features logic method of Library class in it. In addition, i also need to consider the issue of data persistence, such as using SQLite or Room databases to store information about books and readers, so that data can be restored after application restart.
	
	Finally, I want to use SQLite for data persistence in Android applications. I used the SQLiteOpenHelper class provided by Android to create and manage databases.

	Firstly, I need to create database tables to store information about books, readers, and borrowing records. I have written model classes such as Book, Reader, and BorrowRecord, which contain corresponding properties and constructors.

	Then, create a class that inherits from SQLiteOpenHelper to manage the database.
	
	Next, in the Library class, i can use this DatabaseHelper to perform CRUD operations (create, read, update, and delete)
	
	In the code, I provided an example of accessing a database. In OverdueBooksActivity, I used the Library object to load and display a list of overdue books.
	
    This code is just a very basic framework, and many details need to be considered in practical applications, such as exception handling, data validation, UI optimization, network requests (if involving remote databases), etc. I think my code is just a foundation, and there is still a lot of detailed work to be done on this basis in order for the program to run properly.
	  
	
	  
	