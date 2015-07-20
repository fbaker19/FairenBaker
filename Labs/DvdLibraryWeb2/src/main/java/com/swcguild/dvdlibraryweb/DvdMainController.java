package com.swcguild.dvdlibraryweb;

import com.swcguild.dvdlibraryweb.model.LibraryLambda;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import swcguild.dvdlibraryweb.dao.Library;

@Controller
public class DvdMainController {
    private Library dao;
    
    @Inject //Spring goes thru and finds the bean that implements the interface that matches the interface below
    public DvdMainController(Library dao) {
        this.dao = dao;
    }
//      @RequestMapping(value={"/","/dvdHome"}, method=RequestMethod.GET)
//    public String displayHomePage() {
//        return "dvdHome";
//    }
    
    @RequestMapping(value="/displayDvdList", method=RequestMethod.GET)
    public String displayDvdList(Model model) {
        List<LibraryLambda> dvdList = dao.getAllTitles();
        model.addAttribute("dvdList", dvdList); //this is how we return input values back to the View
        return "displayDvdList";
    }
    
    @RequestMapping(value="/displayNewDvdForm", method=RequestMethod.GET)
    public String displayNewDvdForm() {
        return "newDvdForm";
    }
    
    @RequestMapping(value="/addNewDvd", method=RequestMethod.POST)
    public String addNewDvd(HttpServletRequest request) {
       
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String releaseDate = request.getParameter("releaseDate");
        String mpaa = request.getParameter("mpaa");
        String rating = request.getParameter("rating");
        String studio =request.getParameter("studio");
      
        
        LibraryLambda  ll = new LibraryLambda();    
        ll.setTitle(title);
        ll.setDirector(director);
        ll.setReleaseDate(releaseDate);
        ll.setMpaa(mpaa);
        ll.setRating(rating);
        ll.setStudio(studio);
       
        
        try {
            dao.addDvd(ll);
        } catch (IOException ex) {
            Logger.getLogger(DvdMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:displayDvdList";
    }
    
    @RequestMapping(value="/deleteDvd", method=RequestMethod.GET)
    public String deleteDvd(HttpServletRequest request) {
        int DvdId = Integer.parseInt(request.getParameter("DvdId"));
        dao.removeTitle(DvdId);
        return "redirect:displayDvdList";
    }
    
    @RequestMapping(value="/displayEditDvdForm", method=RequestMethod.GET)
    public String displayEditDvdForm(HttpServletRequest request, Model model) {
        int DvdId = Integer.parseInt(request.getParameter("DvdId"));
        LibraryLambda ll = dao.getTitle(DvdId);
        model.addAttribute("ll", ll);
        return "editDvdForm";
    }
    
    @RequestMapping(value="/editDvd", method=RequestMethod.POST)
    public String editDvd(@Valid @ModelAttribute("ll") LibraryLambda ll,
                                        BindingResult result)
    {
        if(result.hasErrors())
        {
            return "editDvdForm";
        }
        
        dao.updateLibrary(ll);
        return "redirect:displayDvdList";
    }
}