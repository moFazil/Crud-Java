package com.springbootwebapp.TodoApp.message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	
	@RequestMapping("message")
	@ResponseBody
	public String Message() {
		return "mr. azok... Hey hey do whad i zay";
	}
	
	@RequestMapping("messageHtml")
	@ResponseBody
	public String MessageHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Html Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>");
		sb.append("Illa illa... Irukku.... irukku irukku....");
		sb.append("<h1/>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	@RequestMapping("messageJsp")
	public String MessageJsp() {
		return "MessageJsp";
	}
}
