# Data-Centric-RAD-Assignment
*A JSF/JDBC dynamic web application that manages a MySQL database designed for a garage. Third Year, Data Centric RAD, Software Development.*

This assignment is worth 50% of the final grade of the module: Data Centric RAD. The goal is to demonstrate our knowledge of MySQL, Java Database Connectivity, and Java Server Faces; the topics covered in this module. Note that there are no marks going for the appearance of the project.

**Achitecture:**

The assignment uses the Model-View-Controller(MVC) design/architectural pattern.

* Model: an object that holds data(i.e. bean classes).
* View: manages the display of data and user input.
* Controller: seperates the models and the views by acting on behalf of both the models and the views. 
* DAO(Data Access Object): manages the communication to the database. The DAO should only be accessed by the controllers.

The architecture of the views was pre-defined in the project description:

* **Main Page**:
  * Link to the *Manage Manufacturers* page.
  * Link to the *Manage Models* page.
  * Link to the *Manage Vehicles* page.
  * Link to the *Find Cars/Find All Vehicles Page* page. 
* **Manage Manufacturers Page**:
  * Display details of all manufacturers.
  * *Add Manufacturer* button, that acts as a link.
  * *Update* and *Delete* actions for each manufacturer displayed.
  * Link back to the *Main* page.
* **Manage Models Page**:
  * Displays details of all models.
  * *Add Model* button, that acts as a link.
  * Link back o the *Main* page.
* **Manage Vehicles Page**:
  * Displays details of all vehicles.
  * *Add Vehicle* button, that acts as a link.
  * *All Details* button, to show that paricular vehicle in another view.
  * Link back to the *Main Page*.
* **Full Vehicle Details Page**:
  * Displays all details of the particular vehicle.
  * Link back to the *Main* page.
  * Link back to the *Vehicles* page.
* **Find All Vehicles Page**:
  * Link back to the *Main* page.
  * Search functionality using any number of the following criteria: Price, Colour and Fuel.
* **Search Results**:
  * Displays search results data.
  * Links back to *Find Cars* and *Main* pages.
* **Add Manufacturer Page**:
  * Gets user input and manages errors.
  * Submit button.
  * Links back to the *Manage Manufacturers* and *Main* pages.
* **Add Model Page**:
  * Gets user input and manages errors.
  * Submit button.
  * Links back to the *Manage Models* and *Main* pages.
* **Add Vehicle Page**:
  * Gets user input and manages errors.
  * Submit button.
  * Links back to the *Manage Vehicles* and *Main* pages.
* **Update Manufacturer Page**:
  * Gets user input and manages errors.
  * Submit button.
  * Links back to the *Manage Manufacturers* and *Main* pages.

The "garage" database was also provided.

-----

__*Tara O'Kelly - G00322214@gmit.ie*__ 