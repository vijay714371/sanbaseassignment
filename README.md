# SunbaseData-Assignment
<b>Title<b>: Customer Management Web Application
## Description:
This project involves the integration of a set of APIs to create a customer management web application. The application will allow users to authenticate, view, create, update, and delete customer records using API calls. The APIs use Bearer authentication for secure access.

## API Endpoints:

## Authentication API:
Path: https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp<br>
Method: POST<br>
Body: JSON object containing login credentials<br>
Response: Returns a bearer token for further API calls<br>
Create a New Customer API:<br>

## Path: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp<br>
Method: POST<br>
Parameters: cmd=create
Header: Authorization with Bearer token obtained from the Authentication API<br>
Body: JSON object containing customer details (first_name and last_name are mandatory)<br>
Response: Success (201) or Failure (400) with appropriate error messages<br>
Get Customer List API:<br>

## Path: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
Method: GET<br>
Parameters: cmd=get_customer_list<br>
Header: Authorization with Bearer token obtained from the Authentication API<br>
Response: Returns a list of customer objects in JSON format<br>
Delete a Customer API:<br>

## Path: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp<br>
Method: POST<br>
Parameters: cmd=delete and uuid of a specific customer<br>
Header: Authorization with Bearer token obtained from the Authentication API<br>
Response: Success (200) or Failure (500 or 400) with appropriate error messages<br>
Update a Customer API:<br>

## Path: https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp
Method: POST<br>
Parameters: cmd=update and uuid of a specific customer<br>
Header: Authorization with Bearer token obtained from the Authentication API<br>
Body: JSON object containing updated customer details<br>
Response: Success (200) or Failure (500 or 400) with appropriate error messages<br>
