package com.nf.dao;

import java.sql.*;
import java.util.ArrayList;

public class News {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public list<FeedbackBean> getAll(){
		list<FeedbackBean> list=new ArrayList<FeedbackBean>();
		String sql = "select * from News where 1=1";
	}
}
