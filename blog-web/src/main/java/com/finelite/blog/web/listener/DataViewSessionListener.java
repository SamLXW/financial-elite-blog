package com.finelite.blog.web.listener;


import com.finelite.blog.utils.jwt.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

@WebListener
public class DataViewSessionListener implements HttpSessionListener
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DataViewSessionListener.class);
	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		LOGGER.debug("Create session, sessionId=" + event.getSession().getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		Object value = event.getSession().getAttribute(SessionUtil.EXPORT_FILES);
		if (value instanceof Map) {
			Map<String, Object> values = (Map<String, Object>) value;
			values.clear();
		} else
			value = null;
		LOGGER.debug("Destory session, sessionId=" + event.getSession().getId());
	}

}
