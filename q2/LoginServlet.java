import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded credentials for demo purposes
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Display welcome page
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
            out.println("a { display: inline-block; margin-top: 20px; padding: 10px 20px; text-decoration: none; background: #007BFF; color: #fff; border-radius: 6px; transition: 0.3s; }");
            out.println("a:hover { background: #0056b3; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='card'>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<p>Your Session ID: <strong>" + session.getId() + "</strong></p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // Invalid login
            out.println("<script>alert('Invalid username or password!'); window.location='login.html';</script>");
        }
    }
}
