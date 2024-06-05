package com.travcomp.controller;

import com.travcomp.dao.TripDao;
import com.travcomp.dao.InMemoryTripDao;
import com.travcomp.model.Trip;
import com.travcomp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/trip")
public class TripServlet extends HttpServlet {
    private TripDao tripDao;

    @Override
    public void init() throws ServletException {
        super.init();
        tripDao = (InMemoryTripDao) getServletContext().getAttribute("tripDao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User driver = (User) session.getAttribute("user");
        String startLocation = req.getParameter("startLocation");
        String endLocation = req.getParameter("endLocation");
        String dateTime = req.getParameter("dateTime").replace("T", " ");
        int carNumber = Integer.parseInt(req.getParameter("carNumber"));
        int availableSeats = Integer.parseInt(req.getParameter("availableSeats"));
        int cost = Integer.parseInt(req.getParameter("cost"));

        if ("create".equals(action)) {
            Trip trip = new Trip(driver, startLocation, endLocation, dateTime, carNumber, availableSeats, cost);
            tripDao.create(trip);
            resp.sendRedirect(req.getContextPath() + "/trip");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Trip trip = new Trip(id, driver, startLocation, endLocation, dateTime, carNumber, availableSeats, cost);
            tripDao.update(trip);
            resp.sendRedirect(req.getContextPath() + "/trip");
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            tripDao.deleteById(id);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startLocation = req.getParameter("startLocation");
        String endLocation = req.getParameter("endLocation");
        String action = req.getParameter("action");

        if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Trip trip = tripDao.findById(id);
            if (trip != null) {
                req.setAttribute("trip", trip);
                req.getRequestDispatcher("update_trip.jsp").forward(req, resp);
            }
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            tripDao.deleteById(id);
            resp.sendRedirect(req.getContextPath() + "/user");
        } else {
            Collection<Trip> trips = tripDao.findAll();
            if (startLocation != null || endLocation != null) {
                trips = tripDao.searchTrips(startLocation, endLocation);
            }

            req.setAttribute("trips", trips);
            req.getRequestDispatcher("list_trips.jsp").forward(req, resp);
        }


    }
}
