package co.id.kconk.spring.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.register(ThymeleafConfiguration.class);
        ctx.register(FreemarkerConfiguration.class);
        ctx.register(GroovyConfiguration.class);
        ctx.register(JadeTemplateConfiguration.class);
        ctx.register(PushConfiguration.class);
        ctx.setServletContext(container);
        ctx.register(TilesApplicationConfiguration.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
