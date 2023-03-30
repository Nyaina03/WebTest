import java.net.URL;
import java.lang.reflect.Method;

public class MyClass {
    
    private URL url;
    
    public MyClass(URL url) {
        this.url = url;
    }
    
    @MyAnnotation(path="/method1")
    public void method1() {
        displayUrl();
    }
    
    @MyAnnotation(path="/method2")
    public void method2() {
        displayUrl();
    }
    
    private void displayUrl() {
        System.out.println("Called from " + url.toString());
    }
    
    public void process() throws Exception {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
          
            if (annotation != null) {
                System.out.println("Method " + method.getName() + " is mapped to path " + annotation.path());
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/myapp");
        MyClass service = new MyClass(url);
        service.process();
    }
}

@interface MyAnnotation {
    String path();
}
