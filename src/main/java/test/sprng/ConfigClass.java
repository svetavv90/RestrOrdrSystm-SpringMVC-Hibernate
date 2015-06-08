package test.sprng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.*;

/**
 * Created by Svitlana on 29-May-15.
 */
@Configuration
@ComponentScan("test.sprng")
@EnableWebMvc
public class ConfigClass {
    //name our DB
    @Bean
    public EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Restaurant");
        return emf.createEntityManager();
    }
    @Bean
    public OrderDAO orderDAO() {
        return new OrderDaoImpl();
    }

    //path to file .jsp
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}
