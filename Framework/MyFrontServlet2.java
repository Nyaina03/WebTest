import etu001956.framework.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


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
        out.println("</body></html>");
    } else {
        response.sendRedirect("login.html");
    }

    // déclaration de retour
    return;
}

mappingUrls.put("/login", new Mapping("com.example.LoginServlet", "doGet"));



}