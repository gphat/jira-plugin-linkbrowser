package com.iinteractive.jira.plugins.tabpanels;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueAction;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.link.IssueLink;
import com.atlassian.jira.issue.link.IssueLinkManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.crowd.embedded.api.User;

import java.util.ArrayList;
import java.util.List;

public class LinkBrowserTabPanel extends AbstractIssueTabPanel implements IssueTabPanel
{
    private static final Logger log = LoggerFactory.getLogger(LinkBrowserTabPanel.class);

    public List<IssueAction> getActions(Issue issue, User remoteUser) {

    	IssueLinkManager ilm = ComponentAccessor.getIssueLinkManager();
    	List<IssueLink> links = ilm.getOutwardLinks(issue.getId());
    	
    	List<IssueAction> outs = new ArrayList<IssueAction>();
    	
    	for(IssueLink link : links) {
    		
    		LinkIssueAction act = new LinkIssueAction(descriptor, link);
    		
    		outs.add((IssueAction) act);
    	}
    	
    	return outs;
    }

    public boolean showPanel(Issue issue, User remoteUser)
    {
        return true;
    }
}
