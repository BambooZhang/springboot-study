package bamboo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;



/**
 * Created by xialeme on 2017/11/30.
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"bamboo"})
@ComponentScan(basePackages="bamboo")
public class Application implements CommandLineRunner{

//    @Autowired
//    private NewsService NewsService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, "--debug");
    }
    @Override
    public void run(String... args) throws Exception {
        //NewsService.crawler("20030623", "20150722");
    }
}