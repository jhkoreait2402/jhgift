package util;

public class Page {
	
	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {
		int totalPage;
		int startPage;
		int endPage;
		
		boolean isPrevPage, isNextPage;
		StringBuffer sb;
		
		isPrevPage = isNextPage = false;
		
		totalPage = (int)(rowTotal / blockList);
		
		if(rowTotal % blockList != 0) {
			totalPage++;
		}
		
		// 留뚯빟 �옒紐삳맂 �뿰�궛怨� ��吏곸엫�쑝濡� �씤�븯�뿬 �쁽�옱 �럹�씠吏� �닔媛� �쟾泥� �럹�씠吏� �닔瑜� �꽆�쓣 寃쎌슦 媛뺤젣濡� �쁽�옱�럹�씠吏� 媛믪쓣 �쟾泥� �럹�씠吏� 媛믪쑝濡� 蹂�寃�
		if(nowPage > totalPage) {
			nowPage = totalPage;
		}
		
		// �떆�옉�럹�씠吏� 援ы븯湲�
		startPage = (int)((( nowPage - 1 ) / blockPage) * blockPage) + 1;
		
		// 醫낅즺�럹�씠吏� 援ы븯湲�
		endPage = startPage + blockPage - 1 ;
		
		// 留덉�留� �럹�씠吏� �닔媛� �쟾泥댄럹�씠吏� �닔 蹂대떎 �겕硫� 留덉�留� �럹�씠吏� 媛믪쓣 蹂�寃�
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		// 留덉�留됲럹�씠吏�媛� �쟾泥댄럹�씠吏�蹂대떎 �옉�쓣寃쎌슦 �떎�쓬 �럹�씠吏뺤씠 �쟻�슜�븷 �닔 �엳�룄濡�
		// boolean�삎 蹂��닔�쓽 媛믪쓣 �꽕�젙
		if(endPage < totalPage) {
			isNextPage = true;
		}
		
		// �떆�옉�럹�씠吏�媛� 1蹂대떎 �겕硫� �씠�쟾�럹�씠吏�濡� �씠�룞�븷 �닔 �엳�룄濡� 媛� �꽕�젙
		if(startPage > 1) {
			isPrevPage = true;
		}
		
		sb = new StringBuffer();
		
		// ---- 洹몃９ �럹�씠吏�泥섎━ �씠�쟾 ----
		if(isPrevPage) {
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(startPage - 1);
			sb.append("'><img src='resources/img/btn_prev.gif'></a>");
		}else {
			sb.append("<img src='resources/img/btn_prev.gif'>");
		}
		
		// ---- �럹�씠吏� 紐⑸줉 異쒕젰 ----
		
		for(int i = startPage; i <= endPage; i++) {
			if(i > totalPage) {
				break;
			}
			
			if(i == nowPage) {
				sb.append("&nbsp;<b><font color='ff0000'>");
				sb.append(i);
				sb.append("</font></b>");
			}else {
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		
		sb.append("  ");
		
		
		// ---- 洹몃９ �럹�씠吏�泥섎━ �떎�쓬 ----
		if(isNextPage) {
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(endPage + 1);
			sb.append("'><img src='resources/img/btn_next.gif'></a>");
		}else {
			sb.append("<img src='resources/img/btn_next.gif'>");
		}
		
		return sb.toString();
	}
	
}
