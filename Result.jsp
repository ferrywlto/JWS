<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCOMP5527JWSProxyid" scope="session" class="DefaultNamespace.COMP5527JWSProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCOMP5527JWSProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCOMP5527JWSProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCOMP5527JWSProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.COMP5527JWS getCOMP5527JWS10mtemp = sampleCOMP5527JWSProxyid.getCOMP5527JWS();
if(getCOMP5527JWS10mtemp == null){
%>
<%=getCOMP5527JWS10mtemp %>
<%
}else{
        if(getCOMP5527JWS10mtemp!= null){
        String tempreturnp11 = getCOMP5527JWS10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String uid_1id=  request.getParameter("uid16");
            java.lang.String uid_1idTemp = null;
        if(!uid_1id.equals("")){
         uid_1idTemp  = uid_1id;
        }
        String pw_2id=  request.getParameter("pw18");
            java.lang.String pw_2idTemp = null;
        if(!pw_2id.equals("")){
         pw_2idTemp  = pw_2id;
        }
        String loc_3id=  request.getParameter("loc20");
            java.lang.String loc_3idTemp = null;
        if(!loc_3id.equals("")){
         loc_3idTemp  = loc_3id;
        }
        java.lang.String getMessage13mtemp = sampleCOMP5527JWSProxyid.getMessage(uid_1idTemp,pw_2idTemp,loc_3idTemp);
if(getMessage13mtemp == null){
%>
<%=getMessage13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getMessage13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String uid_4id=  request.getParameter("uid25");
            java.lang.String uid_4idTemp = null;
        if(!uid_4id.equals("")){
         uid_4idTemp  = uid_4id;
        }
        String pw_5id=  request.getParameter("pw27");
            java.lang.String pw_5idTemp = null;
        if(!pw_5id.equals("")){
         pw_5idTemp  = pw_5id;
        }
        String loc_6id=  request.getParameter("loc29");
            java.lang.String loc_6idTemp = null;
        if(!loc_6id.equals("")){
         loc_6idTemp  = loc_6id;
        }
        String msg_7id=  request.getParameter("msg31");
            java.lang.String msg_7idTemp = null;
        if(!msg_7id.equals("")){
         msg_7idTemp  = msg_7id;
        }
        boolean postMessage22mtemp = sampleCOMP5527JWSProxyid.postMessage(uid_4idTemp,pw_5idTemp,loc_6idTemp,msg_7idTemp);
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(postMessage22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>