Task description:

You need to create a simple Spring MVC application, e.g., a telephone directory. The telephone directory must contain full names and sets of phone numbers. Each user may have several phone numbers, and each number belongs to a specific phone company.

Your application must include the following functionality:

Implement batch loading of users, phone number and phone company into the system. To do this, create a controller which accepts multipart file upload, parses it and stores it in the system. The format of the file (JSON, XML, ...) is up to you as long as you can implement the correct parsing procedure.
Implement a controller that will return a list of users as a PDF document. Map this controller to a specific value of Accept request header — Accept=application/pdf.
Implement a set of controllers that allow building a simple UI: links to get and upload files and a page with a list of all users. Pages must be implemented using Freemarker. Use FreeMarkerViewResolver to view resolving procedure.
Implement a generic exception handler that redirects all controller exceptions to a simple Freemarker view that just prints the exception message.
You need to configure Spring MVC application context and dispatcher servlet for this assignment. To store information, you must use any in-memory database (SQLite, H2, Derby...).

Explanations:

Endpoints:
  HTTP GET: localhost - batch load user files. Click the 'Choose Files' button, then click 'Upload files' button. This will load the data into the database.  
            Each user in separate file. May duplicate name, surname and patronymic. Don'd have id. 
            Examples in dir: resources/userExamples. Temporary uploaded data will be in 'uploadDir' dir. Every app launch will clear this directory!
  HTTP GET: localhost/getUsers - get all users info.
  HTTP GET: localhost/getUsersPdf - get all users info as PDF. Accept 'Accept=application/pdf' headers only!
  HTTP GET: localhost/h2 - for h2 database access(for check only). Database data not optimized(not required by task description)! Every app launch will clear the DB.
  
  Each error will be redirected to view exceptions with a description of this error