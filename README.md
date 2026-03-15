<p align="center">
  <!-- TECHNOLOGY BADGES -->
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Lombok-FE0000?style=flat&logo=java" alt="Lombok">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white" alt="Docker">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=mysql&logoColor=white" alt="MySQL">
</p>

<h1 align="center">NEIU Parking Management System</h1>

<p align="center">
  A centralized, reliable platform for managing parking data at Northeastern Illinois University.<br>
  Console-based Java application with JDBC and a MySQL backend, containerized with Docker.
</p>

<hr>

<h2>Features</h2>
<ul>
  <li><strong>Student & Employee Management:</strong> Add, view, update, delete records</li>
  <li><strong>Vehicle Management:</strong> Register, update, remove vehicles linked to students/employees</li>
  <li><strong>Permit Management:</strong> Define permit types, issue permits, track validity</li>
  <li><strong>Parking Lot & Space Management:</strong> Define lots, assign spaces, manage availability</li>
  <li><strong>Parking Event Tracking:</strong> Record entries/exits, associate with permits/lots</li>
  <li><strong>Data Views & Reporting:</strong> Display tables for students, employees, vehicles, and permits</li>
</ul>

<hr>

<h2>Technologies Used</h2>
<p>
  <strong>Java</strong> • <strong>Lombok</strong> • <strong>Maven</strong> • <strong>Docker</strong> • <strong>MySQL</strong> • <strong>JDBC</strong> • SQL Views
</p>

<hr>

<h2>Screenshots / Documentation</h2>
<p>
  📄 Full documentation: <a href="./.idea/NEIUParkingManagementSystem.pdf">NEIUParkingManagementSystem.pdf</a>
</p>

<hr>

<h2>Vision & Scope</h2>
<p>
  The system provides NEIU with a secure, organized parking infrastructure while reducing admin workload and errors.
  Future enhancements may include web/mobile interfaces, real-time tracking, automated enforcement, and analytics dashboards.
</p>

<hr>

<h2>Use Case Summary</h2>
<ul>
  <li><strong>Trigger:</strong> Admin starts the application</li>
  <li><strong>Preconditions:</strong> System running, database connected, students/employees exist</li>
  <li><strong>Postconditions:</strong> Data stored and available for queries/CRUD operations</li>
</ul>

<p><strong>Normal Flow:</strong></p>
<ol>
  <li>Main Menu displayed: Manage Student, Employee, Vehicles, Permits, Parking Lots/Spaces, Parking Events</li>
  <li>User selects entity to manage</li>
  <li>Sub-menu: Add / View / Update / Delete / Return</li>
  <li>User enters data; system validates input</li>
  <li>Database operation performed (INSERT/SELECT/UPDATE/DELETE)</li>
  <li>Data displayed in formatted table</li>
  <li>Repeat operations or exit application</li>
</ol>

<p><strong>Alternative Flows / Exceptions:</strong></p>
<ul>
  <li>Invalid menu option → shows “Invalid choice”</li>
  <li>No records found → shows “No record found!”</li>
  <li>Invalid input format → prompts user again</li>
  <li>Database errors / foreign key or duplicate key violation handled gracefully</li>
</ul>

<hr>

<h2>Constraints & Assumptions</h2>
<p><strong>Constraints:</strong> Active MySQL required; text-based menu; data must follow relationships</p>
<p><strong>Assumptions:</strong> Users have basic technical skills; database updated regularly; system scalable</p>

<hr>

<h2>Success Criteria</h2>
<ul>
  <li>Accurate storage and retrieval of parking data</li>
  <li>Referential integrity maintained</li>
  <li>Reduced manual effort for management</li>
  <li>Clear, readable output</li>
  <li>Supports future enhancements without redesign</li>
</ul>

<hr>

<h2>Future Vision</h2>
<ul>
  <li>Web or mobile front-end</li>
  <li>Real-time parking availability</li>
  <li>Digital permit assignment integrated with accounts</li>
  <li>Reporting dashboards and analytics</li>
  <li>Integration with security/access-control</li>
  <li>Automated violation detection and alerts</li>
</ul>

<hr>

<h2>Author</h2>
<p>GheorgheG</p>
