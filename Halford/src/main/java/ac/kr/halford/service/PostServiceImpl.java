package ac.kr.halford.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ac.kr.halford.mapper.PostMapper;
import ac.kr.halford.model.PostModel;
import ac.kr.halford.util.Pager;

@Service("PostService")
@Transactional
public class PostServiceImpl implements PostService {
	
	private Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
	
	@Autowired
	private PostMapper postMapper;

	@Override
	public PostModel findCertainPost(PostModel post) {
		logger.info("PostService-findCertainPost");
		
		post = postMapper.findCertainPost(post);
		
		return post;
	}

	@Override
	public List<PostModel> findPosts(int current) {
		logger.info("PostService-findPosts");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("current", (current-1) * 10);
		
		return postMapper.findPosts(map);
	}

	@Override
	public void setPostModel(PostModel post) {
		logger.info("PostService-setPostModel");
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = dateFormat.format(date);
		
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		post.setMemberId(session.getAttribute("id").toString());
		post.setDate(currentTime);
		
	}

	@Override
	public void addPost(PostModel post) {
		logger.info("PostService-addPost");
		
		postMapper.addPost(post);
	}

	@Override
	public void updatePost(PostModel post) {
		logger.info("PostService-updatePost");
		
		postMapper.updateCertainPost(post);
	}

	@Override
	public void deletePost(PostModel post) {
		logger.info("PostService-deletePost");
		
		postMapper.deleteCertainPost(post);
		
	}

	@Override
	public void setPager(Pager pager) {
		int totalPostCount = postMapper.getPostCount();
		
		pager.setPager(totalPostCount);
	}

}