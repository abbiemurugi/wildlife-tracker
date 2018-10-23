import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        //HEROKU
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        get("/About", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/About.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/About", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/About.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/addAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String ranger = request.queryParams("ranger");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String status = request.queryParams("status");
            Animal newAnimal = new Animal(name, ranger, age, location, health, status);
            newAnimal.save();
            response.redirect("/");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }

}
