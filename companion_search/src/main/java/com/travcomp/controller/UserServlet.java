package com.travcomp.controller;

import com.travcomp.dao.InMemoryTripDao;
import com.travcomp.dao.InMemoryUserDao;
import com.travcomp.model.Trip;
import com.travcomp.model.User;
import com.travcomp.util.TestDataBaseCreator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private InMemoryUserDao userDao;
    private InMemoryTripDao tripDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = (InMemoryUserDao) getServletContext().getAttribute("userDao");
        tripDao = (InMemoryTripDao) getServletContext().getAttribute("tripDao");
        if (userDao == null || tripDao == null) {
            userDao = new InMemoryUserDao();
            tripDao = new InMemoryTripDao();
            TestDataBaseCreator testDataBaseCreator = new TestDataBaseCreator(userDao, tripDao);
            testDataBaseCreator.populate();
            getServletContext().setAttribute("userDao", userDao);
            getServletContext().setAttribute("tripDao", tripDao);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("register".equals(action)) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");

            User user = new User(name, surname, email, password, phone);
            userDao.create(user);
            resp.sendRedirect("login.jsp");
        } else if ("login".equals(action)) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = userDao.validateUser(email, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/user");
            } else {
                resp.sendRedirect("login.jsp?error=Incorrect password or email");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        List<Trip> userTrips = tripDao.findTripsByUser(user);
        req.setAttribute("user", user);
        req.setAttribute("trips", userTrips);
        req.getRequestDispatcher("user.jsp").forward(req, resp);

    }
}
