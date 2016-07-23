package com.billowsoft.recorder.bean;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class WeixinMsgTest {

	@Test
	public void fromXmlTest() {

		try {
			File file = new File("/home/liubo/workspace/nodelab/sample-weixin-msg.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(WeixinMsg.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			WeixinMsg msg = (WeixinMsg) jaxbUnmarshaller.unmarshal(file);
			System.out.println(msg);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void toXmlTest() {
		try {
			WeixinMsg inmsg = new WeixinMsg();
			inmsg.setContent("content");
			inmsg.setCreateTime("createTime");
			inmsg.setFromUserName("fromUserName");
			inmsg.setMsgId("msgId");
			inmsg.setMsgType("msgType");
			File file1 = new File("/home/liubo/workspace/nodelab/sample-weixin-msg-test.xml");
			JAXBContext jaxbContext1 = JAXBContext.newInstance(WeixinMsg.class);
			Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(inmsg, file1);
			jaxbMarshaller.marshal(inmsg, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
