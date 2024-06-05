package com.travcomp.util;

import com.travcomp.dao.InMemoryUserDao;
import com.travcomp.dao.InMemoryTripDao;
import com.travcomp.model.User;
import com.travcomp.model.Trip;

public class TestDataBaseCreator {
    private InMemoryUserDao userDao;
    private InMemoryTripDao tripDao;

    public TestDataBaseCreator(InMemoryUserDao userDao, InMemoryTripDao tripDao) {
        this.userDao = userDao;
        this.tripDao = tripDao;
    }

    public void populate() {
        User user1 = new User("Василь", "Павлюк", "vasya_p@example.com", "ilovepc", "123-456-7890");
        User user2 = new User("Райан", "Гослінг", "imjustken@example.com", "imgreatatdoingstuff", "987-654-3210");
        User user3 = new User("Ель", "Прімо", "elprimo@example.com", "elmariarchi", "555-555-5555");

        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);

        Trip trip1 = new Trip(user1, "Київ", "Чоп", "2023-06-14 09:00", 101, 3, 459);
        Trip trip2 = new Trip(user2, "Хмельницький", "Нетішин", "2024-06-16 12:00", 102, 2, 324);
        Trip trip3 = new Trip(user3, "Полтава", "Миргород", "2024-06-17 15:00", 103, 4, 123);
        Trip trip4 = new Trip(user1, "Фастів", "Київ", "2024-06-17 18:00", 153, 24,655);
        Trip trip5 = new Trip(user1, "Чернігів", "Вільнюс", "2024-07-01 09:00", 104, 2, 500);
        Trip trip6 = new Trip(user2, "Сімферополь", "Київ", "2024-07-02 10:00", 105, 3, 300);
        Trip trip7 = new Trip(user3, "Запоріжжя", "Енергодар", "2024-07-03 11:00", 106, 1, 200);
        Trip trip8 = new Trip(user1, "Івано-Франківськ", "Тернопіль", "2024-07-04 12:00", 107, 4, 100);
        Trip trip9 = new Trip(user2, "Чернівці", "Ужгород", "2024-07-05 13:00", 108, 2, 150);
        Trip trip10 = new Trip(user3, "Кропивницький", "Херсон", "2024-07-06 14:00", 109, 3, 175);
        Trip trip11 = new Trip(user1, "Маріуполь", "Київ", "2024-07-07 15:00", 110, 4, 225);
        Trip trip12 = new Trip(user2, "Курахове", "Краматорськ", "2024-07-08 16:00", 111, 2, 275);
        Trip trip13 = new Trip(user3, "Миколаїв", "Кропивницький", "2024-07-09 17:00", 112, 1, 325);
        Trip trip14 = new Trip(user1, "Черкаси", "Рівне", "2024-07-10 18:00", 113, 3, 350);
        Trip trip15 = new Trip(user2, "Кременчук", "Дніпро", "2024-07-11 19:00", 114, 4, 375);
        Trip trip16 = new Trip(user3, "Мелітополь", "Бердянськ", "2024-07-12 20:00", 115, 2, 400);
        Trip trip17 = new Trip(user1, "Бровари", "Фастів", "2024-07-13 21:00", 116, 1, 425);
        Trip trip18 = new Trip(user2, "Краматорськ", "Слов'янськ", "2024-07-14 22:00", 117, 3, 450);
        Trip trip19 = new Trip(user3, "Нікополь", "Енергодар", "2024-07-15 23:00", 118, 4, 475);
        Trip trip20 = new Trip(user1, "Мукачево", "Ужгород", "2024-07-16 08:00", 119, 2, 500);
        Trip trip21 = new Trip(user1, "Мукачево", "Хуст", "2024-07-16 08:00", 119, 2, 501);

        tripDao.create(trip1);
        tripDao.create(trip2);
        tripDao.create(trip3);
        tripDao.create(trip4);
        tripDao.create(trip5);
        tripDao.create(trip6);
        tripDao.create(trip7);
        tripDao.create(trip8);
        tripDao.create(trip9);
        tripDao.create(trip10);
        tripDao.create(trip11);
        tripDao.create(trip12);
        tripDao.create(trip13);
        tripDao.create(trip14);
        tripDao.create(trip15);
        tripDao.create(trip16);
        tripDao.create(trip17);
        tripDao.create(trip18);
        tripDao.create(trip19);
        tripDao.create(trip20);
        tripDao.create(trip21);
    }
}
