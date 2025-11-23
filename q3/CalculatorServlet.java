import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");

        CalculatorBean calc = new CalculatorBean();
        calc.setNum1(num1);
        calc.setNum2(num2);

        switch(operation) {
            case "add": calc.add(); break;
            case "subtract": calc.subtract(); break;
            case "multiply": calc.multiply(); break;
            case "divide": calc.divide(); break;
        }

        // Store bean in request scope
        request.setAttribute("calcBean", calc);

        // Forward to JSP
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
