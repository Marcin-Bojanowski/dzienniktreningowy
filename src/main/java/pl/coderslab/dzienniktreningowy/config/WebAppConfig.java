package pl.coderslab.dzienniktreningowy.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.dzienniktreningowy.converters.LocalDateSerializeConverter;

import java.text.SimpleDateFormat;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("page/login");
        registry.addViewController("/403").setViewName("403");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
