/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryweb.dao;

import com.swcguild.dvdlibraryweb.model.DVD;
import com.swcguild.dvdlibraryweb.model.DvdSearchTerms;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DvdLibraryDbImpl implements Library {//implement the Interface

    private static final String SQL_INSERT_DVD = "INSERT INTO dvd (title, director, release_date, mpaa, rating, studio) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD = "DELETE FROM dvd WHERE id =?";
    private static final String SQL_UPDATE_DVD = "UPDATE dvd SET title =?, director = ?, release_date =?, mpaa =?, rating = ?, studio=? WHERE id = ?";
    private static final String SQL_SELECT_ALL_DVDS = "SELECT * FROM dvd";
    private static final String SQL_SELECT_DVD = "SELECT * FROM dvd WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Integer addDvd(DVD libraries) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                libraries.getTitle(),
                libraries.getDirector(),
                libraries.getReleaseDate(),
                libraries.getMpaa(),
                libraries.getRating(),
                libraries.getStudio());

        libraries.setId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return libraries.getId();
    }

    @Override
    public List<DVD> getAllTitles() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DVDMapper());
    }

    @Override
    public void updateLibrary(DVD libraries) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                libraries.getTitle(),
                libraries.getDirector(),
                libraries.getReleaseDate(),
                libraries.getMpaa(),
                libraries.getRating(),
                libraries.getStudio(),
                libraries.getId());
    }

    @Override
    public DVD getTitle(int Id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DVDMapper(), Id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public void removeTitle(int Id) {
        jdbcTemplate.update(SQL_DELETE_DVD, Id);
    }

    @Override
    public List<DVD> searchDvd(Map<DvdSearchTerms, String> criteriaMap) {
           if (criteriaMap == null || criteriaMap.size() == 0) {
            return getAllTitles();
        }
        StringBuilder query = new StringBuilder("SELECT * FROM dvd WHERE ");

        int numParams = criteriaMap.size();

        String[] paramVals = new String[numParams];

        Set<DvdSearchTerms> keyset = criteriaMap.keySet();
        Iterator<DvdSearchTerms> iter = keyset.iterator();

        while (iter.hasNext()) {
            DvdSearchTerms currentKey = iter.next();
            String currentValue = criteriaMap.get(currentKey);

            int paramPosition = 0;

            if (paramPosition > 0) {
                query.append(" and ");
            }

            query.append(currentKey);//SearchTerm parameter/key
            query.append(" =? ");

            paramVals[paramPosition] = currentValue;//String paramerter/value
            paramPosition++;
        }

        return jdbcTemplate.query(query.toString(), new DVDMapper(), paramVals);
    }

    private static final class DVDMapper implements ParameterizedRowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            
            dvd.setId(rs.getInt("id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setDirector(rs.getString("director"));
            dvd.setReleaseDate(rs.getString("release_date"));
            dvd.setMpaa(rs.getString("mpaa"));
            dvd.setRating(rs.getString("rating"));
            dvd.setStudio(rs.getString("studio"));

            return dvd;
        }
    }

}
