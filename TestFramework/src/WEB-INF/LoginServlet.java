import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Login Page</title></head>");
        out.println("<body><h1>Login</h1>");
        out.println("<form method=\"post\" action=\"login\">");
        out.println("Username: <input type=\"text\" name=\"username\"><br>");
        out.println("Password: <input type=\"password\" name=\"password\"><br>");
        out.println("<input type=\"submit\" value=\"Login\">");
        out.println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isValidUser = checkUserCredentials(username, password);

        if (isValidUser) {
            response.sendRedirect("dashboard");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Login Error</title></head>");
            out.println("<body><h1>Invalid username or password</h1>");
            out.println("<a href=\"login\">Back to Login Page</a></body></html>");
        }
    }

    private boolean checkUserCredentials(String username, String password) {
        // vérifier les informations d'identification de l'utilisateur
        // retourner true si les informations sont valides, false sinon
        return true; // remplacer cette ligne avec votre propre logique de vérification d'identification
    }
}
