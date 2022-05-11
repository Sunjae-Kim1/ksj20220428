package test;

import java.sql.SQLException;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;
import org.kosta.myproject.model.TimeTableDAO;

public class testDAO {
	public static void main(String[] args) {
		try {
			
			TimeTableDAO.getInstance().timeTableMinMax("7");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
