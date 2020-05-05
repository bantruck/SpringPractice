package kr.dudu.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.dudu.spring.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private String msg ;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Autowired
	MemberService memberService;
	
	@RequestMapping(value= {"/main/home","/home.do"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "뷰 프레임워크 타일즈");
	    mv.addObject("setVersion", "컨트롤 프레임워크 스프링 프레임워크 : " + org.springframework.core.SpringVersion.getVersion());
	    mv.addObject("setDB", "모델 프레임워크 Mybatis + 구글 클라우드 플랫폼  MYSQL 5.1");
	    mv.addObject("testVO", memberService.getEmail("dudu"));
	    
	    setMsg("request END");
	    logger.info(getMsg());
	    return mv;
	}
	
}
