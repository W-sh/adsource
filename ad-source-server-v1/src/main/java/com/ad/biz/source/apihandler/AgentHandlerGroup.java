package com.ad.biz.source.apihandler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AgentHandlerGroup {
	 static final Logger log = LoggerFactory.getLogger(AgentHandlerGroup.class);
	
public static Map<Integer, AgentBaseHandler>staAgentGroup=null;
public static Map<Integer, Object>subAgentGroup=null;

static {
try{
	regentStaticGroup();
}catch(Exception e){
	 log.error("static agentHandlerMap error", e);
}	
try{
	regentSubGroup();
}catch(Exception e){
	 log.error("sub agentHandlerMap error", e);
}	
}

public static void regentStaticGroup(){
	staAgentGroup=new HashMap<Integer, AgentBaseHandler>();
	staAgentGroup.put(0, null);
}
public static void regentSubGroup(){
	subAgentGroup=new HashMap<Integer, Object>();
	subAgentGroup.put(0, "");
}
}
