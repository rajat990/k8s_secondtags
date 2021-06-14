import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {

	@Value("${userBucket.path}")
	private String userBucketPath;

    @RequestMapping(value = "/property/Value", method = RequestMethod.GET)
    String propertyvalueMethod() {
    	
    	System.out.println(userBucketPath);
        return userBucketPath;
    }

    @RequestMapping(value = "/{msg}", method = RequestMethod.GET)
    String home(@PathVariable("msg") String msg) {
        return msg;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
