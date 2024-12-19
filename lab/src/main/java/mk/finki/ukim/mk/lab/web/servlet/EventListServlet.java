//package mk.finki.ukim.mk.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.service.EventService;
//import mk.finki.ukim.mk.lab.service.EventServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Objects;
//
//@WebServlet(name = "EventListServlet", urlPatterns = {"/event"})
//
//public class EventListServlet  extends HttpServlet {
//    private final EventServiceImpl eventService;
//    private final SpringTemplateEngine templateEngine;
//
//    public EventListServlet(EventServiceImpl eventService, SpringTemplateEngine templateEngine) {
//        this.eventService = eventService;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Event> event= eventService.listAll();
//
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//        context.setVariable("events", event);
//        templateEngine.process("listEvents.html", context, resp.getWriter());
//
//        String data= req.getParameter("b1");
//    }
//
//}
