package ge.shop.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfig {

    @Autowired
    private CorsConfigImpl corsConfigImpl;

    @Bean
    public CorsFilter corsFilter(){
        return  new CorsFilter(corsConfigImpl);
    }
}
