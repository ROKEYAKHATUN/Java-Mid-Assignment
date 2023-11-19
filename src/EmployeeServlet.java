import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = new ArrayList<>();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String email = request.getParameter("email");
        LocalDate joiningDate = LocalDate.parse(request.getParameter("joiningDate"));
        EmployeeType employeeType = EmployeeType.valueOf(request.getParameter("employeeType"));

        Employee employee = new Employee(id, name, dateOfBirth, email, joiningDate, employeeType);
        employees.add(employee);

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
