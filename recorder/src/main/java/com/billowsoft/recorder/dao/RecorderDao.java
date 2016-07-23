package com.billowsoft.recorder.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.billowsoft.recorder.bean.Member;
import com.billowsoft.recorder.bean.Record;
import com.billowsoft.recorder.bean.WeixinMsg;
import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class RecorderDao {

	private final static String SPACE_NAME = "recorder.";
	
	@Autowired
	private SqlMapClient sqlMap = null;

	public void setSqlMapClient(SqlMapClient sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	public List<Record> getRecordsByMemberId(int memberId) throws SQLException{
		return (List<Record>)sqlMap.queryForList(SPACE_NAME + "getRecordsByMemberId", memberId);
	}
	
	public int saveRecord(Record record) throws SQLException{

		Object id = sqlMap.insert(SPACE_NAME + "insertRecord", record);
		return (Integer)id;
	}
	
	public Member getMemberByName(String name) throws SQLException{
		return (Member)sqlMap.queryForObject(SPACE_NAME + "getMemberByName", name);
	}
	
	public int saveMember(Member member) throws SQLException{

		Object id = sqlMap.insert(SPACE_NAME + "insertMember", member);
		return (Integer)id;
	}
	
	public Record getLatestRecord(int memberId, String type) throws SQLException{
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		params.put("type", type);
		
		return (Record) sqlMap.queryForObject(SPACE_NAME + "getLatestRecord", params);
	}
	
	public List<Record> getAllRecords(int memberId) throws SQLException{
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		
		return (List<Record>) sqlMap.queryForList(SPACE_NAME + "gerAllRecords", params);
		
	}
}
