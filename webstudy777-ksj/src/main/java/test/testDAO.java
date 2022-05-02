package test;

import java.sql.SQLException;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;

public class testDAO {
	public static void main(String[] args) {
		try {
			FilmVO fvo = FilmDAO.getInstance().filmDetail("1");
			System.out.println(fvo.toString());
			
			FilmVO fvo2 = FilmDAO.getInstance().findFilmByName("세 얼간이");
			System.out.println(fvo2.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
