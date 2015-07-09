            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swcguild.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author warde
 */
public interface DvdLibraryDao {

    public void add(DVD dvd);

    public void remove(int id);

    public List<DVD> listAll();

    public DVD getById(int id);

    public List<DVD> getByTitle(String title);

    public List<DVD> getByRating(String rating);

    public List<DVD> getByStudio(String studio);
}
