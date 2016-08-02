package niit.colloborations.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import niit.colloborations.model.Blog;
import niit.colloborations.model.BlogBody;
import niit.colloborations.model.Forum;

@Repository
@Transactional

public class ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void createNewForum(Forum f)
	{
		Session session=sessionFactory.openSession();
		session.save(f);
		session.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Blog> getBlogList(String user_name)
	{
		Session session=sessionFactory.openSession();
		Criteria c=session.createCriteria(Blog.class);
		c.add(Restrictions.eq("user_name", user_name));
		List <Blog> blog=c.list();
		return blog;
	}
	
	public void insertPost(BlogBody body)
	{
		Session session=sessionFactory.openSession();
		session.save(body);
		session.flush();
	}
	@SuppressWarnings("unchecked")
	public List<BlogBody> getBlogContent(String blogname)
	{
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(BlogBody.class);
		cr.add(Restrictions.eq("blogname", blogname));
		return cr.list();
		
	}

}
