package com.nf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nf.entity.FeedbackBean;

public class Feedbackbao {
	public List<FeedbackBean> selectFeedb(){
		List<FeedbackBean> list=new ArrayList<FeedbackBean>();
		String sql="select * from feedback";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUitl.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				FeedbackBean p= new FeedbackBean();
				p.setFbId(rs.getInt("fbId"));
				p.setUsId(rs.getString("usId"));
				p.setFbTime(rs.getDate("fbTime"));
				p.setFbContent(rs.getString("fbContent"));
				p.setFbImages(rs.getString("fbImages"));
				p.setFblianxi(rs.getString("fblianxi"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUitl.closeAll(rs, ps, conn);
		}
		
		return list;
	}
	

}
