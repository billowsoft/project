package com.billowsoft.recorder.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.billowsoft.recorder.bean.Member;
import com.billowsoft.recorder.bean.Record;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RecorderDaoTest {

	@Autowired
	private RecorderDao dao;
	
	@Before
	public void init(){
		
	}
	
	@Test
	public void testInsertMember() throws SQLException{
		Member member = new Member();
		member.setName("name");
		member.setMemberId("memberID");
		member.setCreatedAt(new Date());
		int id = dao.saveMember(member);
		System.out.println(id);
	}

	@Test
	public void testInsertRecord() throws SQLException{
		Member member = new Member();
		member.setName("name");
		member.setMemberId("memberID");
		member.setCreatedAt(new Date());
		int id = dao.saveMember(member);
		
		Record record = new Record();
		record.setCreatedAt(new Date());
		record.setMemberId(id);
		record.setData("data");
		record.setDataType("dataType");
		int recordId = dao.saveRecord(record);
		System.out.println(recordId);
	}
	
	@Test
	public void testGetRecordsByMemberId() throws SQLException{
		// create one member
		Member member = new Member();
		member.setName("name");
		member.setMemberId("memberID");
		member.setCreatedAt(new Date());
		int memberId = dao.saveMember(member);
		
		// create three records for member
		for(int i=0; i<3; i++){
			Record record = new Record();
			record.setCreatedAt(new Date());
			record.setMemberId(memberId);
			record.setData("data" + i);
			record.setDataType("dataType" + i);
			dao.saveRecord(record);
		}
		
		// get records
		List<Record> records = dao.getRecordsByMemberId(memberId);
		System.out.println(records);
	}
}
