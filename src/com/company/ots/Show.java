package com.company.ots;

import java.util.*;

import static com.company.ots.Menu.listShowMenu;

class Show {
    private String title;
    private String description;
    private Date date;

    private Show(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    Date getDate() {
        return date;
    }

    private static List<Show> shows(){
        Show show1 = new Show("1) Harry Potter and the Cursed Child", "It turns out Harry Potter, now a grown man with a wife and kids, sucks at parenting", new Date(2020, Calendar.JUNE, 5));
        Show show2 = new Show("2) Aladdin", "Love is in the air when the paths of a beautiful princess and a charming thief cross", new Date(2020, Calendar.JUNE, 6));
        Show show3 = new Show("3) Alice in Wonderland", "A little girl gets lost in a wonderland", new Date(2020, Calendar.JUNE, 7));
        Show show4 = new Show("4) The Lion King", "Animals going about their business in the jungle", new Date(2020, Calendar.JUNE, 8));
        List<Show> shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        shows.add(show3);
        shows.add(show4);
        return shows;
    }

    static void listShows(Customer customer){
        List<Show> shows = shows();

        int listSize = 0;
        while (listSize < shows.size()){
            System.out.println(shows.get(listSize).getTitle());
            listSize++;
        }
        listShowMenu(customer, shows());
    }
}
