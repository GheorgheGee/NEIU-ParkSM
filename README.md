## Documentation

📄 Full explanation of the architecture and implementation:
➡️ [NEIUParkingManagementSystem (PDF)](/.idea/NEIUParkingManagementSystem.pdf)



                                                     NEIU Parking Management System


Vision and Scope

1. Vision

The NEIU Parking Management System provides a centralized, reliable, and efficient platform for handling
parking data at Northeastern Illinois University. It simplifies the registration process for students, staff,
vehicles, parking permits, lots, and events, replacing manual records with a digital system that enhances
operational efficiency, data accuracy, traceability, and reporting. Overall, the system supports NEIU’s goal of
maintaining a secure, organized, and accessible parking infrastructure on campus, while also reducing
administrative workload, lowering errors, and improving decision-making.

2. Business Objectives

• Keep accurate and current records of students, employees, vehicles, and permits.
• Make issuing and managing parking permits easier.
• Offer insights into parking usage through event tracking.
• Aid enforcement, compliance, and resource planning.
• Cut down on manual data entry, paper forms, and repetitive admin tasks.
• Build a foundation for future upgrades like online access, automated enforcement, and analytics.

3. Scope
   
3.1 In-Scope Functionality
   
The application will provide functionality for:
A. Student and Employee Management
• Add, view, update, and delete student records.
• Add, view, update, and delete employee records.
B. Vehicle Management
• Register vehicles linked to students or employees.
• Associate vehicles with zero or one student, or zero or one employee.
• Remove or update existing vehicles.
• Enforce referential integrity.
C. Permit Management
• Define permit types (e.g., Gold, Blue, Yellow).
• Issue parking permits with valid dates.
• Associate permits with vehicles.
• Track multiple permits per vehicle over time.
D. Parking Lot & Space Management
• Define parking lots and assign unique spaces.
• Manage space identification and availability (structural, not real-time).
E. Parking Event Tracking
• Record vehicle entries and exits.
• Associate events to lots and permits.
F. Data Views and Reporting
• Display student-vehicle table.
• Display employee-vehicle table.
• Display permit-vehicle status and validity.

3.2 Out-of-Scope Functionality

The current version does not include:

• Real-time sensor-based parking availability.
• Visualization dashboards or analytics.
• Automated citation or enforcement workflows.
• Mobile or web interface.
• User authentication or role-based access control.
• Payment processing.
• Integration with university systems.
These may be addressed in future releases.


4. Stakeholders

• Primary Users: NEIU Parking Officer / Admin
• Indirect Beneficiaries: Students and employees (due to better service)

5. Proposed System Environment

• Java console application
• MySQL relational database
• JDBC for connectivity
• Structured database schema with referential integrity
• SQL views for consolidated data representation

6. Constraints and Assumptions
   
Constraints:

• System depends on an active MySQL instance.
• Data must conform to defined relationships and constraints.
• Users interact through a text-based menu system.
Assumptions:
• Users have basic technical literacy.
• Parking data is updated regularly and accurately.
• Database will grow over time and require maintenance.

7. Success Criteria

The project will be considered successful if it:
• Accurately stores and retrieves parking-related data.
• Maintains referential integrity and prevents inconsistent entries.
• Reduces time and effort required to manage parking records.
• Provides clear, readable output to end-users.
• Supports future enhancements without redesigning the core database.

8. Future Vision

The application is intended as a scalable foundation for future innovation, including:
• A web or mobile front-end
• Real-time parking availability tracking
• Digital permit assignment integrated with student/employee accounts
• Reporting dashboards and analytics
• Integration with security and access-control systems
• Automated violation detection and alerts
These developments would transform the NEIU Parking Management System from a record-keeping system
into a comprehensive smart-campus parking management platform.

Description: This use case describes how a user interacts with the NEIU Parking Lot Database Management System to manage parkingrelated
information. Using a console-based menu, the user can add, view, update, and delete records for students,
employees, vehicles, parking permits, parking lots, parking spaces, and parking events. The system validates input, enforces
database constraints, and provides feedback after each operation.

Trigger: The admin starts the application and reaches the Main Menu.

Preconditions: The system is running and connected to the database. Student or Employee must exist 
in the system if the vehicle will be
associated with that person. Also, if a student/employee is not yet in DB, they can be added via the application.

Postconditions: A new vehicle is stored in the DB. The data is available for future queries, permit assignments, and CRUD operations.
Normal Flow: 1. User starts the Parking Management System application.

2. System displays the Main Menu with options, such as:
Manage Student
Manage Employee
Manage Vehicles
Manage Permits/Permit Types
Manage Parking Lots/Spaces
Manage Parking Events

3. User selects one of the managements options.

4. System displays a sub menu for the chosen entity, such as:
Add(Create)
View(Read)
Update
Delete
Return to previous Menu

5. User Selects an operation.

6. System prompts the user for the required input.

7. User enters the requested data.

8. System validates the input.

9. System performs the requested database operation via JDBC.
Executes SQL INSERT/SELECT/UPDATE/DELETE

10. System processes the result and displays the data via a formatted table.
Upon failure, the system will display the error message to the user.

11. System returns the user to the relevant sub menu or main menu.

12. User may repeat steps 3-11 for additional operations.

13. When done, user can EXIT the application from the Main Menu.

14. System terminates the application.

Alternative Flows: 1. Invalid Menu Option
User inputs a number that doesn’t match to the corresponding menu option
System displays “Invalid choice”

2. No records found
User chooses to view a record that doesn’t exist.
System displays a message such as “ No record found!” and returns to the menu.

Exceptions: 1. Invalid input format.
User enters invalid data.
System displays error and re-prompts for correct input.

2. Database connection error
System cannot insert data due to SQL error.
System informs users of system error and returns back to main menu.

3. Foreign Key Violation

4. Duplicate Primary Key
Priority: High. Essential System Functionality.
Frequency: Frequent. Expected multiple times per day by the admin or parking office.
Business Rules: License plate must be unique.
Owner can be either a current student or NEIU employee, even though, they can be added before adding a vehicle.
Certain deletes may be restricted or cascade.
Data must be kept consistent with defined foreign keys and ON DELETE rules (CASCADE / SET NULL)
Other Information: This use case is part of the core CRUD process for the Parking Management System.
Assumptions: User has basic computer skills.
User understands NEIU parking business concepts.
Database contains valid student and employee data.
System validates data before insertion.
