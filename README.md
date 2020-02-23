## myHealth Care
### Introduction
myHealth Care is an android application which signifies a patient management application that provides the patients all the facilities available in the hospital in their palm. This application enables patients to register or login to the system and view their reports and prescriptions that have been provided to them by the hospital. When a person visits a hospital, s/he is sure to receive some prescription or report. People are extremely busy these days and they are having hard time managing their schedule. So, this application helps patients to save their time as all of their reports and prescription will be stored in this application and can be viewed from wherever they like. They will not have to go to the hospital and wait in queue to receive their reports. Similarly, the patients can view the list of doctors that are working in the hospital along with their profile. Moreover, this application also enables patient to book an appointment by selecting the doctor according to their requirements and illness. This project will work as a result of time saving and management especially for those people who usually have a hectic schedule and also for those people who cannot manage time to visit the hospital.

### Features of the Project
* Login and Registration System
* View User Profile
* Push Notification
* Google Maps integration to show the location of the hospital
* Wearable module to display notification
* Shake device to open registration page from login page using ACCELEROMETER sensor
* Fingerprint sensor implementation to access Dashboard if user login credentials are saved
* CRUD Functions
* Edit User Profile
* Book and Cancel Doctor Appointment
* View Patient's Report and Prescription
* View Doctors and their Profile
* Implementation of WebView to load a website about Health Tips
* Animations added

### Youtube link of the Android Application
https://youtu.be/HTDAaPYaZxA

### Backend API Link
https://github.com/softwarica-github/t2-backend-api-krranjik.git

### REST Client
The term REST stands for REpresentational State Transfer. It is a method of communication between two systems i.e. REST Client and REST Server. Here, the Client makes the request whereas the Server responds to request.

Rest Client is a tool that is used to invoke a REST service API which is exposed for the means of communication by any service provider or system. It makes request to the server to modify or retrieve data from and on the server. A request generally consists of:
* an HTTP verb to define the type of operation to perform
* a header to allow clients to pass along the request information
* a path to a resource
* an optional message body which contains data

There are basically 4 types of HTTP verbs which is used to interact. They are:
* POST to create a new resource
* GET to retrieve a collection of resource or a specific resource (i.e. by id)
* PUT to update a specific resource (using id)
* DELETE to remove a specific resource (using id)

Retrofit is used as a REST Client for developing this project. It is usually used in java and android as it makes it easy to retrieve and upload JSON or other data via a REST web service. To work with Retrofit, three classes are required: Model, Interface and Retrofit.Builder class. Model is used as a JSON model, Interface is used to define the HTTP operations and Retrofit.Builder is an instance which uses the Builder API and interface which defines URL end point for the HTTP operations. For the Retrofit to work in an android project, certain dependencies have to be added in the build.gradle file. The dependencies are as follows:
* implementation 'com.squareup.retrofit2:retrofit:2.1.0'
* implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
