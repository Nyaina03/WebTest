import etu001956.framework.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MyFrontServlet extends HttpServlet {
    
    private HashMap<String, Mapping> mappingUrls = new HashMap<String, Mapping>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); // récupérer un paramètre de requête nommé "name"
        String message = "Bonjour " + name + "!"; // construire un message de réponse
        response.setContentType("text/plain"); // définir le type de contenu de la réponse
        response.setCharacterEncoding("UTF-8"); // définir l'encodage de caractères de la réponse
        PrintWriter out = response.getWriter(); // obtenir un objet PrintWriter pour écrire la réponse
        out.println(message); // écrire le message dans la réponse
    }

    private boolean checkUserCredentials(String username, String password) {
        // vérifier les informations d'identification de l'utilisateur
        // renvoyer true si les informations sont valides, false sinon
        if (username.equals("admin") && password.equals("password123")) {
            return true;
        } else {
            return false;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer les paramètres de la requête
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // vérifier les informations d'identification de l'utilisateur
        boolean isValidUser = checkUserCredentials(username, password);

        // envoyer une réponse en fonction du résultat de la vérification
        if (isValidUser) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Bienvenue " + username + "!</h1>");

            // récupérer dynamiquement les données de la classe ModelView
            ModelView model = new ModelView();
            HashMap<String, Object> data = model.getData();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                out.println("<p>" + key + ": " + value.toString() + "</p>");
            }

            out.println("</body></html>");
        } else {
            response.sendRedirect("login.html");
        }

        // déclaration de retour
        return;
    }

    // bloc d'initialisation de classe pour ajouter l'URL de mapping
    {
        mappingUrls.put("/login", new Mapping("com.example.LoginServlet", "doGet"));
    }
}
