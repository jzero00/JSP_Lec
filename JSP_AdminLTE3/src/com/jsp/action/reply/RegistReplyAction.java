package com.jsp.action.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.request.PageMaker;
import com.jsp.request.ReplyRegistRequest;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

import sun.java2d.pipe.OutlineTextRenderer;

public class RegistReplyAction implements Action {

	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		ReplyRegistRequest replyReq = mapper.readValue(request.getReader(),ReplyRegistRequest.class);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			replyService.registReply(replyReq.toReplyVO());
			
			SearchCriteria cri = new SearchCriteria();
			Map<String,Object> dataMap = replyService.getReplyList(replyReq.toReplyVO().getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			out.print("SUCCESS,"+realEndPage);
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("FAIL,1");
		} finally {
			if(out != null) out.close();
		}
		
		return url;
	}

}
