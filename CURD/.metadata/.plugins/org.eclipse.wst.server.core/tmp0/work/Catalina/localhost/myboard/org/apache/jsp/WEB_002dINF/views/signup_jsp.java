/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.50
 * Generated at: 2021-08-25 08:09:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<h1>????????????</h1>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"signupres.do\" method=\"post\">\r\n");
      out.write("		<table>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>?????????</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"userid\" id=\"id\" onkeyup = \"checkId();\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\" align=\"center\" id=\"idChkres\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>????????????</th>\r\n");
      out.write("				<td><input type=\"password\" name=\"userpw\" id=\"pw\" placeholder=\"?????? + ?????? + ???????????? 7~16?????????????????????\" onkeyup=\"checkPwd1();\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\" align=\"center\" id=\"pwChkres\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>???????????? ??????</th>\r\n");
      out.write("				<td><input type=\"password\" id=\"pwChk\" placeholder=\"???????????? ??????\" onkeyup=\"checkPwd2();\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\" align=\"center\" id=\"pwChkres2\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>??????</th>\r\n");
      out.write("				<td><input type=\"text\" name=\"username\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>??????</th>\r\n");
      out.write("				<td>\r\n");
      out.write("					<input type=\"text\" id=\"address\" readonly=\"readonly\" placeholder=\"????????? ??????????????? ????????? ???????????????\" onclick=\"goPopup();\">\r\n");
      out.write("					<input type=\"hidden\" name=\"address_1\" id=\"addr_1\" readonly=\"readonly\">\r\n");
      out.write("					<input type=\"hidden\" name=\"address_2\" id=\"addr_2\" readonly=\"readonly\">\r\n");
      out.write("					<input type=\"hidden\" name=\"addno\" id=\"addrno\" readonly=\"readonly\">\r\n");
      out.write("					\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td colspan=\"2\" align=\"right\">\r\n");
      out.write("					<input type=\"submit\" value=\"????????????\">\r\n");
      out.write("					<input type=\"button\" value=\"??????\" onclick=\"history.back();\">\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</form>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("	$(\"#idChkres\").hide();\r\n");
      out.write("	$(\"#pwChkres\").hide();\r\n");
      out.write("	$(\"#pwChkres2\").hide();\r\n");
      out.write("});\r\n");
      out.write("	\r\n");
      out.write("	function checkId(){\r\n");
      out.write("		var id = $(\"#id\").val().trim();\r\n");
      out.write("		$(\"#id\").val(id.replace(/[^a-zA-Z0-9]/gi, ''));\r\n");
      out.write("		var userid = $(\"#id\").val().trim();\r\n");
      out.write("		if(userid == null || userid == \"\"){\r\n");
      out.write("			$(\"#idChkres\").show();\r\n");
      out.write("			$(\"#idChkres\").html('ID??? ????????? ?????????.');\r\n");
      out.write("			$(\"#idChkres\").css(\"color\", \"red\");\r\n");
      out.write("		} else {\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				type : \"post\",\r\n");
      out.write("				url : \"ajaxidChk.do?userid=\",\r\n");
      out.write("				data : userid,\r\n");
      out.write("				contentType : \"application/text\",\r\n");
      out.write("				dataType : \"text\",\r\n");
      out.write("				success : function(check) {\r\n");
      out.write("					$(\"#idChkres\").show();\r\n");
      out.write("					if (check == \"false\") {\r\n");
      out.write("						$(\"#idChkres\").html('?????? ????????? ID?????????.');\r\n");
      out.write("						$(\"#idChkres\").css(\"color\", \"blue\");\r\n");
      out.write("						console.log(userid)\r\n");
      out.write("						\r\n");
      out.write("					} else {\r\n");
      out.write("						$(\"#idChkres\").html('?????? ???????????? ID?????????.');\r\n");
      out.write("						$(\"#idChkres\").css(\"color\", \"red\");\r\n");
      out.write("						\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error : function(){\r\n");
      out.write("					alert(\"ID ?????? ??????\");\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function checkPwd1(){\r\n");
      out.write("		var pw = $(\"#pw\").val().trim();\r\n");
      out.write("		\r\n");
      out.write("		var pattern1 = /[0-9]/;\r\n");
      out.write("	\r\n");
      out.write("	    var pattern2 = /[a-zA-Z]/;\r\n");
      out.write("	\r\n");
      out.write("	    var pattern3 = /[~!@#$%<>^&*]/;\r\n");
      out.write("		\r\n");
      out.write("	    if(!pattern1.test(pw)||!pattern2.test(pw)||!pattern3.test(pw)||pw.length<7||pw.length>16){\r\n");
      out.write("	    	$(\"#pwChkres\").show();\r\n");
      out.write("			$(\"#pwChkres\").html('?????? + ?????? + ???????????? ????????? 7~ 16?????? ???????????????');\r\n");
      out.write("			$(\"#pwChkres\").css(\"color\", \"red\");\r\n");
      out.write("            return false;\r\n");
      out.write("\r\n");
      out.write("        } else {\r\n");
      out.write("        	$(\"#pwChkres\").hide();\r\n");
      out.write("        }        \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function checkPwd2(){\r\n");
      out.write("		var pw = $(\"#pw\").val().trim();\r\n");
      out.write("		var pwChk = $(\"#pwChk\").val().trim();\r\n");
      out.write("		\r\n");
      out.write("		if(pw != pwChk){\r\n");
      out.write("			$(\"#pwChkres2\").show();\r\n");
      out.write("			$(\"#pwChkres2\").html('??????????????? ??????????????????');\r\n");
      out.write("			$(\"#pwChkres2\").css(\"color\", \"red\");\r\n");
      out.write("		} else {\r\n");
      out.write("			$(\"#pwChkres2\").show();\r\n");
      out.write("			$(\"#pwChkres2\").html('??????????????? ???????????????');\r\n");
      out.write("			$(\"#pwChkres2\").css(\"color\", \"blue\");\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	function goPopup() {\r\n");
      out.write("		// ??????????????? ????????? ?????? ???????????? ???????????????.\r\n");
      out.write("		// ????????? ?????????(jusopopup.jsp)?????? ?????? ????????????URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)??? ???????????? ?????????.\r\n");
      out.write("		// scrollbars=yes ????????? ??? ?????? resizable=yes ????????? ?????? ?????? ?????? \r\n");
      out.write("		var pop = window.open(\"resources/jusoPopup.jsp\",\"pop\",\"width=570,height=420, scrollbars=yes, resizable=yes\"); \r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function jusoCallBack(roadFullAddr, roadAddrPart1, roadAddrPart2, zipNo, addrDetail, inputYn, admCd, rnMgtSn, bdMgtSn){\r\n");
      out.write("		// ????????????????????? ??????????????? ????????? ?????????, ??? ???????????? ????????? ???????????????.	\r\n");
      out.write("		document.getElementById(\"address\").value = roadFullAddr;\r\n");
      out.write("		document.getElementById(\"addr_1\").value = roadAddrPart1;\r\n");
      out.write("		document.getElementById(\"addr_2\").value = roadAddrPart2;\r\n");
      out.write("		document.getElementById(\"addrno\").value = admCd;\r\n");
      out.write("		console.log(roadFullAddr)\r\n");
      out.write("		console.log(\"?????????\",roadAddrPart1)\r\n");
      out.write("		console.log(\"?????????\",roadAddrPart2)\r\n");
      out.write("		console.log(\"??????\",zipNo)\r\n");
      out.write("		\r\n");
      out.write("		console.log(\"????????????\",admCd)\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
