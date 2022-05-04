package test;

import java.sql.SQLException;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;

public class testDAO {
	public static void main(String[] args) {
		try {
			FilmVO fvo = FilmDAO.getInstance().findPostByNo("1");
			System.out.println(fvo.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
