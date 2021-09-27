package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Freeboard;
import mybatis.SqlSessionBean;

public class FreeboardDao {
	
	
		SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
		private static FreeboardDao dao = new FreeboardDao();
		private FreeboardDao() {
			
		}
		public static FreeboardDao getInstance() {
			return dao;
		}
		
		// getlist
		// map을 만들어주는 부분은 dao실행시킬떄 전달해주는 것으로 할 것.
		public List<Freeboard> getList(Map<String, Integer> map){	//key (변수명처럼 이해)String, value는 int
			List<Freeboard> list = null;
			SqlSession mapper = factory.openSession();
			list = mapper.selectList("getList",map);
			return list;
		}
		// getOne (idx로 행 한개 조회)
		public Freeboard getOne(int idx) {
			SqlSession mapper = factory.openSession();
			Freeboard dto = mapper.selectOne("selectByIdx",idx);
			mapper.close();
		 	return dto;
		}
		public int getCount() {
			SqlSession mapper = factory.openSession();
			int cnt = mapper.selectOne("getCount");
			mapper.close();
			return cnt;
		}
		// getcount
		
		
		
}
