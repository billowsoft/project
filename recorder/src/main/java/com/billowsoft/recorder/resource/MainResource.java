package com.billowsoft.recorder.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.billowsoft.recorder.bean.WeixinMsg;
import com.billowsoft.recorder.bean.WeixinRecordResponse;
import com.billowsoft.recorder.service.WeixinMsgService;

@Path("msg")
@Component
public class MainResource {

	private static Logger LOG = LoggerFactory.getLogger(MainResource.class);
	
	@Autowired 
	private WeixinMsgService msgService;
	
	@POST
	@Path("/weixin")
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public WeixinRecordResponse receiveWeixinMsg(WeixinMsg msg) {
		
		LOG.debug("开始响应请求：{}", msg);
		String result = msgService.handleMsg(msg);
		WeixinRecordResponse response = new WeixinRecordResponse();
		response.setContent(result);
		response.setCreateTime(String.valueOf(System.currentTimeMillis()));
		response.setFromUserName(msg.getToUserName());
		response.setToUserName(msg.getFromUserName());
		response.setMsgType("text");

		LOG.debug("结束响应请求：{}", response);
		return response;
	}
	
	@GET
	@Path("/weixin")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getJSON(@QueryParam("echostr") String echostr) {

		LOG.info("接收到微信验证消息：" + echostr);
		return Response.status(200).entity(echostr).build();
		
	}	
		
}
