import annotation.*;
import etu001956.framework.servlet.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@MyAnnotation(Filename = "Saisie.txt",content="contenu",url="D:/S4/INF209-Mr Naina/Project/Sprint6/File")

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
        if (username.equals("admin") && mdp.equals("password123")) {
            return true;
        } else {
            return false;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer les paramètres de la requête
        String username = request.getParameter("nom",this.setAttributeValue(emp, emp.nom, emp.getNom()));
        String firstname = request.getParameter("prenom",this.setAttributeValue(emp, emp.prenom, emp.getPrenom()));
        String post = request.getParameter("poste",this.setAttributeValue(emp, emp.poste, emp.getPoste()));
        String salary = request.getParameter("salaire",this.setAttributeValue(emp, emp.salaire, emp.getSalaire()));
        String password = request.getParameter("mdp",this.setAttributeValue(emp,emp.mdp,emp.getmdp()));
        String dept = request.getParameter("dept",this.setAttributeValue(emp,emp.dept,emp.getDept()));
        
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

    // Appel de la fonction sauvegarder
	String contenu = "";
	for (Employee employee : (List<Employee>)request.getAttribute("employees")) {
		contenu += employee.getNom() + ";" + employee.getPrenom() + ";" + employee.getPoste() + ";" + employee.getSalaire() + "\n";
	}
	sauvegarder("employes.txt", contenu);

    //verification instance
    public void setAttributeValue(Emp emp, String attributeName, Object value) throws Exception {
    Class<? extends Emp> empClass = emp.getClass();
    try {
        Field field = empClass.getDeclaredField(attributeName);
        Method setMethod = empClass.getDeclaredMethod("set" + capitalize(attributeName), field.getType());
        setMethod.invoke(emp, value);
    } catch (NoSuchFieldException e) {
        throw new Exception("L'attribut " + attributeName + " n'existe pas dans la classe Emp.");
    } catch (NoSuchMethodException e) {
        throw new Exception("La méthode set" + capitalize(attributeName) + " n'existe pas dans la classe Emp.");
    } catch (IllegalAccessException | InvocationTargetException e) {
        throw new Exception("Impossible d'appeler la méthode set" + capitalize(attributeName) + " dans la classe Emp.");
    }
}

// Fonction utilitaire pour mettre la première lettre en majuscule
private String capitalize(String str) {
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
}

Emp emp = new Emp();
try {
    setAttributeValue(emp, emp.nom, emp.getNom());
} catch (Exception e) {
    e.printStackTrace();
}

}

