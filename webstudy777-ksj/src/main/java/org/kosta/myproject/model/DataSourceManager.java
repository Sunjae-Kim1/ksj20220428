package org.kosta.myproject.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/*
	DataSourceManager : apache tomcat 에 제공하는 DBCP 객체를 javax.sql.DataSource Interface 타입으로 생성해서 관리하는 클래스
	
	DBCP : DataBase Connection Pool , 커넥션 객체들을 미리 생성해 저장소 ( Pool ) 에 저장해놓고 커넥션 필요시
	생성 , 소멸 방식이 아니라 빌려주고 반납받는 방식으로 시스템 성능 향상을 위한 기술
	
	시스템에서 DBCP 는 하나만 존재하면 되니까 Singleton Design Pattern 을 적용한다.
*/
public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource datasource;
	private DataSourceManager() { // 단 한번 실행되는 생성자 영역에서 DBCP 를 생산
		BasicDataSource dbcp = new BasicDataSource();
		dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
		dbcp.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dbcp.setUsername("scott");
		dbcp.setPassword("tiger");
		
		// 자신의 서비스 환경에 맞게 아래와 같이 설정할 수 있다.
		dbcp.setInitialSize(5); // DBCP 생성 시점에 Connection Pool 에 connection 객체를 5개 생성한다.
		dbcp.setMaxTotal(25); // 최대 커넥션 개수를 설정할 수 있다.
		
		this.datasource = dbcp; // BasicDataSource 객체는 DataSource Interface 를 구현하고 있기에 할당이 가능 / 예시 - Player p = new CDPlayer();
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return datasource;
	}
}