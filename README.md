# MovieApp
Open Movie Database with MovieApp
=================================

The MovieApp to obtain movie information

Architectural overview
----------------------
This app is split into 3 types of searches

    - Series
    - Title ID
    - Title

The movie can be searched with 3 types of parameters mentioned above

Development environment
-----------------------

1.  Android Studio
2.  Java
3.  Junit
4.  Espresso
5.  Volley

Building the application
-----------------------

Download the project from the Git hub onto your local machine
Launch Android Studio  
On Menu bar -  File => Open (point out to the path where the project is located)

Running the application
-----------------------

1. To execute the MovieApp android Device is required - developed and tested on a Virtual Device

      Name             Resolution         API              Target             CPU/ABI   Size on Disk  
  Pixel 3 API 27   1080 x 2160:440dpi     27       Android 8.1 (Google Play)    x86       9.8 GB

Note:
To get the virtual device on Android Studio , Tools -> AVD Manager and create a virtual device

2. To Launch the MovieApp on the android device - right click on the MainActivity.java and select - Run 'MainActivity'
3. Enter the text to search <eg: Spy>
4. Click on the necessary buttons (SERIES, TITLE_ID, TITLE) according to the need
5. Keypad will be hided to display the results in full screen mode
6. Results are displayed based on the given input and required button clicked
7. Scroll to view the full details of the movie
8. To display the key pad - click on the search text

Testing
-------
1. Testing is done by using Espresso and the tests are written in MovieSearchTest.java class
2. Automation Test Scenarios covered
        testObjectDisplayed - Verifies all the elements on app is displayed
        testMovieTitles     - Verifies the appropriate movie is dispalyed based on the title search
        testMovieTitleID    - Verifies the appropriate movie is dispalyed based on the title_id search
        testMovieSeries     - Verifies the appropriate movie is dispalyed based on the series search
3. To execute tests - right click on the MovieSearchTest.java class and select - Run 'MovieSearchTest'

Test Notes:
1. Happy path scenarios covered
2. Tests can be extended to do the data driven testing by given multiple input search with different search types (series, title_id, title)
3. 401 - Not authenticated, test covered manually by entering wrong api key
4. Security and Configurability can be done by accessing the api key from environmental variables, but for the ease of use right now the apikey is hardcoded

Dependencies
------------
Required dependencies are added in the build.gradle file

References and Usage
--------------------
1. ​http://www.omdbapi.com/​
2. ​http://www.omdbapi.com/swagger.yaml
