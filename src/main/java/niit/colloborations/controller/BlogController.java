package niit.colloborations.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import niit.colloborations.model.Blog;
import niit.colloborations.model.BlogBody;
import niit.colloborations.service.BlogService;
import com.google.gson.Gson;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogservice;
	
	
	
	@ModelAttribute("blogbody")
	public BlogBody BlogObject()
	{
		
		return new BlogBody();
	}
	
	@RequestMapping("/newblog")
	public String createBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("user");
		model.addAttribute("name",name);
		System.out.println("In Blog Controller");
		return "newblog";
	}
	
	
	@ModelAttribute("blog")
	public Blog returnObject()
	{
		return new Blog();
	}
	
	
	@RequestMapping("/create")
	public String createBlog(@ModelAttribute("blog") Blog blog,Model model)throws IOException
	{
		String name=blog.getUser_name();
		
		//char buff[]=new char[];
		
		/*String content=null;
			
		String url=blog.getBlog_name()+".jsp";
		url="D:/NewPrj2/colloboration/src/main/webapp/WEB-INF/views/"+url;
		System.out.println(url);
		BufferedReader fr=new BufferedReader(new FileReader("D:/NewPrj2/colloboration/src/main/webapp/WEB-INF/views/writeblog.jsp"));
		BufferedWriter fw=new BufferedWriter(new FileWriter(url));
		while((content=fr.readLine())!=null)
		{	
			fw.write(content);
			fw.newLine();
		}
		
		fr.close();
		fw.close();*/
		blogservice.createNewBlog(blog);
		
		ModelAndView mv=new ModelAndView();
		model.addAttribute("name",name);
		model.addAttribute("addBlog","Successfully blog got created");
		return "newblog";
	}
	
	@RequestMapping("/openblog")
	public String openNewBlog(HttpServletRequest request)
	{
		String bl=request.getParameter("blogname");
		return bl;
	}
	
	@RequestMapping("/blog")
	public String goToBlog(HttpServletRequest request,Model model)
	{
		String name=request.getParameter("user");
		model.addAttribute("name",name);
		List<Blog> blogList= blogservice.getBlogList(name);
		Gson gson=new Gson();
		String jsonstring=gson.toJson(blogList);
		model.addAttribute("jstring",jsonstring);
		for(Blog g:blogList)
		System.out.println(g.getBlog_name());
		System.out.println(jsonstring);
		return "blog";
	}
	@RequestMapping("/openb")
	public String openBlog(HttpServletRequest request,Model model)
	{
		String bln=request.getParameter("bln");
		String name=request.getParameter("user");
		model.addAttribute("blname", bln);
		model.addAttribute("name",name);
		return bln;
	}
	

	
	@RequestMapping("/insertPost")
	public String insertPost(@ModelAttribute("blogbody") BlogBody content)
	{
		blogservice.insertPost(content);
		System.out.println("Post inserted successfully");
		
		return null;
	}

}
