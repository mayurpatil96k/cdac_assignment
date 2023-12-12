package tagpack;
import java.io.IOException;

import jakarta.servlet.jsp.JspContext;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
public class TagCode1 extends SimpleTagSupport
{
	public int first;
	public int second;
	public void doTag(int first,int second)throws JspException,IOException
	{
		getJspContext().getOut().print(first-second);
	}
}