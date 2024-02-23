package util;

public class Common {

	// 일반게시판용
	public static class Board{
		public final static String VIEW_PATH = "/WEB-INF/views/board/";
				
		// 한 페이지에 보여줄 게시물 수
		public final static int BLOCKLIST = 10;
		
		// 한번에 보여질 페이지 메뉴 수
		public final static int BLOCKPAGE = 3;
	}
	
	// 회원용 경로
	public static class Member{
		public final static String VIEW_PATH = "/WEB-INF/views/member/";
	}
}
