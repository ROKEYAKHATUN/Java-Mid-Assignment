<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOC TYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Leave Result</title>
</head>
<body>
    <h2>Employee Leave Result</h2>

    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");

        for (Employee employee : employees) {
            int vacationLeave = LeaveCalculator.calculateVacationLeave(employee);
            int sickLeave = LeaveCalculator.calculateSickLeave(employee);
    %>

    <p>ID: <%= employee.getId() %></p>
    <p>Name: <%= employee.getName() %></p>
    <p>Date of Birth: <%= employee.getDateOfBirth() %></p>
    <p>Email: <%= employee.getEmail() %></p>
    <p>Joining Date: <%= employee.getJoiningDate() %></p>
    <p>Employee Type: <%= employee.getEmployeeType() %></p>
    <p>Vacation Leave: <%= vacationLeave %></p>
    <p>Sick Leave: <%= sickLeave %></p>
    <hr>

    <%
        }
    %>
</body>
</html>
