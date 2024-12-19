//package mk.finki.ukim.mk.lab.web.servlet;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.EventServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = {"/EventBooking"})
//
//public class EventBookingServlet extends HttpServlet {
//    EventServiceImpl eventService;
//    SpringTemplateEngine templateEngine;
//
//    public EventBookingServlet(EventServiceImpl eventService, SpringTemplateEngine templateEngine) {
//        this.eventService = eventService;
//        this.templateEngine = templateEngine;
//
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(iWebExchange);
//
//        templateEngine.process("bookingConfirmation.html", context, resp.getWriter());
//
//    }
//}
