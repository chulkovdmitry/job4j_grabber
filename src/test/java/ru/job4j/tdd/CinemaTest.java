package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D(), new Session3D())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void buySameTicketByTwoAccounts() {
        Account account = new AccountCinema();
        Account account1 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 11, 10, 20, 00);
        Ticket ticket = cinema.buy(account, 11, 7, date);
        Ticket ticket1 = cinema.buy(account1, 11, 7, date);
    }

    @Ignore
    @Test(expected = IndexOutOfBoundsException.class)
    public void ticketRowOut() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 11, 10, 20, 00);
        Ticket ticket = cinema.buy(account, 142, 12, date);
    }

    @Ignore
    @Test(expected = DateTimeException.class)
    public void ticketNullDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = null;
        Ticket ticket = cinema.buy(account, 14, 2, date);
    }
}