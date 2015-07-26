/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.model;

import java.time.LocalDate;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {//stores Variables and Getters n' Setters

    private int id; //= 0;//initilized
    
    @NotEmpty(message = "You must supply a value for Title.")
    @Length(max = 50, message = "Title name must not be more than 50 characters in length")
    private String title;

    @NotEmpty(message = "You must supply a value for the Release date.")
    @Length(max = 10, message = "Release Date must not be more than 10 characters in length - MM/DD/YYYY(with slashes) or you may enter just the year of release")
    private String releaseDate;

    
    private String year;

    @NotEmpty(message = "You must supply a value for Director.")
    @Length(max = 30, message = "Director name must not be more than 30 characters in length")
    private String director;

    @NotEmpty(message = "You must supply a value for the MPAA.")
    @Length(max = 4, message = "MPAA name must not be more than 4 characters in length")
    private String mpaa;

    @NotEmpty(message = "You must supply a value for rating.")
    @Length(max = 3, message = "Rating  must not be more than 3 characters in length. ie 1-100 scale or 1-10 scale with decimals - 7.6")
    private String rating;

    @NotEmpty(message = "You must supply a value for Studio.")
    @Length(max = 30, message = "Studio name must not be more than 30 characters in length")
    private String studio;

    private String note;

    public DVD(int id) {
        this.id = id;
    }

    public DVD() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public DVD(String note) {
//       this.note = note;
//    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    DVD(String Id) {
//        id = Id; //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.releaseDate);
        hash = 97 * hash + Objects.hashCode(this.year);
        hash = 97 * hash + Objects.hashCode(this.director);
        hash = 97 * hash + Objects.hashCode(this.mpaa);
        hash = 97 * hash + Objects.hashCode(this.rating);
        hash = 97 * hash + Objects.hashCode(this.studio);
        hash = 97 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.mpaa, other.mpaa)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

}
