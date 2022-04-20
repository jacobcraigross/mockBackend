package dev.jakeross.jcr.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
notes...
the helloController is a @Component, but more specifically it is an @RestController and that means it has
a @ResponseBody added to it as well. (under the hood)

when we hit the endpoint of "/", we want the helloWorld() method to be served. for that we need @RequestMapping

to change which PORT the app is running on, 8080 by default, we can go to the application.properties file
and change that config to make it run on 8088 for example.
 */



// VIDEO AT 37:32 ------ WHAT WERE GONNA BE BUILDING ------------




@RestController // this is the 1st step --> so it is added to the Spring container upon start up.
public class helloController {

    // @RequestMapping(value = "/", method = RequestMethod.GET) --> can be re-factored below.
    @GetMapping("/")
    public String helloWorld() {
        return "Payload: NUKE DEPLOYED. EARTH SHUDDERS.";
    }
}
