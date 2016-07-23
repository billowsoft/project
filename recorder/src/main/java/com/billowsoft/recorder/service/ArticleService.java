package com.billowsoft.recorder.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.billowsoft.recorder.bean.Article;
import com.billowsoft.recorder.bean.Record;
import com.billowsoft.recorder.dao.RecorderDao;

@Component
public class ArticleService {
	
	private static Logger LOG = LoggerFactory.getLogger(ArticleService.class);

	@Autowired
	private RecorderDao recordDao;
	
	public List<Article> listArticles(String memberId){
		return null;
	}
	
	public void saveArticle(Article article){
		Record record = new Record();
		record.setCreatedAt(new Date());
		record.setData(article.getContent());
		record.setType(article.getType());
		record.setDataType("text");
		record.setMemberId(1);
		
		try {
			recordDao.saveRecord(record);
		} catch (SQLException e) {
			LOG.error("save article failed.", e);
		}
	}
	
	private Article constructFromRecord(Record record){
		Article article = new Article();
		article.setContent(record.getData());
		article.setType(record.getDataType());
		return article;
	}
}
