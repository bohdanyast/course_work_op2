package com.travcomp.util;

import com.travcomp.dao.InMemoryTripDao;
import com.travcomp.dao.InMemoryUserDao;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebAppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InMemoryUserDao userDao = new InMemoryUserDao();
        InMemoryTripDao tripDao = new InMemoryTripDao();

        TestDataBaseCreator initializer = new TestDataBaseCreator(userDao, tripDao);
        initializer.populate();

        sce.getServletContext().setAttribute("userDao", userDao);
        sce.getServletContext().setAttribute("tripDao", tripDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
