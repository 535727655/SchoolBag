package com.nf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nf.entity.FeedbackBean;

public class Feedbackdao {
	public boolean addFeedback(FeedbackBean fd){
		boolean bl= false;
		String sql="insert into feedback(usId,fbTime,fbContent,fbImages,fblianxi) values(?,getdate(),?,?,?)";
			Connection conn= null;
			PreparedStatement ps= null;
			try {
				conn=DBUitl.getCon();
				ps=conn.prepareStatement(sql);
				ps.setString(1,fd.getUsId());
				ps.setString(2,fd.getFbContent());
				ps.setString(3,fd.getFbImages());
				ps.setString(4,fd.getFblianxi());
				int p=ps.executeUpdate();
				bl=p>0;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBUitl.closeAll(null,ps, conn);
			}
		
		return bl;
	}
}
