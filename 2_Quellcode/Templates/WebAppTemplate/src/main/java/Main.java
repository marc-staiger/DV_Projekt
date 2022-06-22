import java.util.Date;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main 
{
    public static void main(String[] args)
    {
    	//--- set up web server ---//
    	int port = 5000;
        Javalin app = Javalin.create(config ->
        	config.addStaticFiles(staticFiles -> 
        	{
			    staticFiles.hostedPath = "/";					// change to host files on a subpath, like '/assets'
			    staticFiles.directory = "www";					// the directory where your files are located
			    staticFiles.location = Location.EXTERNAL;		// Location.CLASSPATH (jar) or Location.EXTERNAL (file system)
        	})
        ).start(port);
        
        //--- set up routes ---//
        app.get("/", ctx -> ctx.redirect("/index.html"));
        app.get("/hello", ctx -> ctx.result("Hello World"));
        
        app.get("/getdata", ctx -> 
        {
        	ctx.json(Map.ofEntries(
				Map.entry("value", "some data"), 
				Map.entry("timestamp", new Date())
        	));	
        });
        
        app.post("/postdata", ctx -> 
        {
        	String body = ctx.body();
        	Map data = (Map) JSON.parse(body);
        	System.out.println(data.get("value"));
        });
    }
}