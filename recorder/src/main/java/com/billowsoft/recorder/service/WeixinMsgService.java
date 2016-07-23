package com.billowsoft.recorder.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.billowsoft.recorder.bean.Member;
import com.billowsoft.recorder.bean.Record;
import com.billowsoft.recorder.bean.WeixinMsg;
import com.billowsoft.recorder.dao.RecorderDao;

@Component
public class WeixinMsgService {

	private static Logger LOG = LoggerFactory.getLogger(WeixinMsgService.class);
	
	@Autowired
	private RecorderDao dao;
	
	public String handleMsg(WeixinMsg msg){
		
		if(msg.getContent().startsWith("message")){
			return getLatestMsg(msg);
		} else {
			return saveRecord(msg);
		}
	}
	
	private String getLatestMsg(WeixinMsg msg){
		try {
			Member member = dao.getMemberByName(msg.getToUserName());
			if(member == null){
				return "用户不存在";
			}
			
			Record latestRecord = dao.getLatestRecord(member.getId(), "message");
			if(latestRecord == null){
				return "没有创建过记录";
			} else {
				return latestRecord.getData();
			}
			
		} catch (SQLException e) {
			LOG.error("创建record失败", e);
			return "获取信息失败";
		}

	}
	
	private String saveRecord(WeixinMsg msg){
		try {
			// 检查用户是否存在
			Member member = dao.getMemberByName(msg.getToUserName());
			// 不存在则创建用户
			int memberId;
			if(member == null){
				member = new Member();
				member.setMemberId(UUID.randomUUID().toString());
				member.setName(msg.getToUserName());
				member.setCreatedAt(new Date());
				memberId = dao.saveMember(member);
			} else {
				memberId = member.getId();
			}

			// 保存记录信息
			Record record = new Record();
			record.setCreatedAt(new Date());
			record.setData(msg.getContent());
			record.setType("record");
			record.setDataType(msg.getMsgType());
			record.setMemberId(memberId);
			int recordId = dao.saveRecord(record);
			LOG.info("创建record成功，id：" + recordId);
			return "记录成功保存";
		} catch (SQLException e) {
			LOG.error("创建record失败", e);
			return "记录保存失败";
		}
	}
}
