package com.billowsoft.recorder.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class WeixinMsg {

	private Long id;
	private String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	private String msgId;
	private String content;

	
	public String getToUserName() {
		return toUserName;
	}

	@XmlElement(name="ToUserName")
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}


	public String getFromUserName() {
		return fromUserName;
	}


	@XmlElement(name="FromUserName")
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}


	public String getCreateTime() {
		return createTime;
	}


	@XmlElement(name="CreateTime")
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getMsgType() {
		return msgType;
	}


	@XmlElement(name="MsgType")
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}


	public String getMsgId() {
		return msgId;
	}


	@XmlElement(name="MsgId")
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}


	public String getContent() {
		return content;
	}


	@XmlElement(name="Content")
	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeixinMsg [ToUserName=" + toUserName + ", FromUserName=" + fromUserName + ", CreateTime=" + createTime
				+ ", MsgType=" + msgType + ", MsgId=" + msgId + ", Content=" + content + "]";
	}

}
