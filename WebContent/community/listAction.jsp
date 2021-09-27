<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dto.Freeboard"%>
<%@page import="java.util.List"%>
<%@page import="dao.FreeboardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 비지니스 로직을 처리하는 jsp 파일
FreeboardDao dao = FreeboardDao.getInstance();


int pageNo;
// page에 파라미터가 없을 때를 고려해서 if문 코딩
if(request.getParameter("page")==null) pageNo=1;
// 페이지 번호는 파라미터로 전달된다.
else pageNo = Integer.parseInt(request.getParameter("page"));

int pageSize = 15;
int startNo=(pageNo-1)*pageSize;

Map<String,Integer> map = new HashMap<>();
map.put("pageSize", pageSize);	// ""안에는 중요하고 뒤에껀 안중요함. 안에게 똑같아야 잘 찾아갈 수 있음
map.put("startNo", startNo);
List<Freeboard> list = dao.getList(map);

 //out.print(list);
	request.setAttribute("blists", list);
	pageContext.forward("listView.jsp");
%>