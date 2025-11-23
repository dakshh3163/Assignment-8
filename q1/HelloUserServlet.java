import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloUserServlet")
public class HelloUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get user input from the form
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Output HTML with modern styling
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Welcome</title>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("background: #f0f2f5; display: flex; justify-content: center; align-items: center;");
        out.println("height: 100vh; margin: 0; }");
        out.println(".card { background: #fff; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.15); text-align: center; }");
        out.println("h1 { color: #007BFF; margin-bottom: 20px; }");
        out.println("p { font-size: 18px; color: #333; }");
        out.println("a { display: inline-block; margin-top: 20px; padding: 10px 20px; text-decoration: none; background: #007BFF; color: #fff; border-radius: 6px; transition: 0.3s; }");
        out.println("a:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='card'>");
        out.println("<h1>Welcome, " + name + "!</h1>");
        out.println("<p>Your registered email is <strong>" + email + "</strong></p>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
