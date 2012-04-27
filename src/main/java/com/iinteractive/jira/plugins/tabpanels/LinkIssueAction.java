package com.iinteractive.jira.plugins.tabpanels;

import java.util.Date;
import java.util.Map;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.link.IssueLink;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueAction;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanelModuleDescriptor;

public class LinkIssueAction extends AbstractIssueAction {

	private IssueLink link;
	private Issue destinationIssue;
	
	public LinkIssueAction(IssueTabPanelModuleDescriptor descriptor, IssueLink link) {
		
		super(descriptor);
		this.link = link;
		this.destinationIssue = link.getDestinationObject();
	}
	
	@Override
	public Date getTimePerformed() {
		// TODO Auto-generated method stub
		return null;
	}

	/* Don't show up in the All. */
	public boolean isDisplayActionAllTab() { return false; }
	
	@Override
	protected void populateVelocityParams(Map params) {

		params.put("link", this);
	}
	
	public String getLinkType() {
		
		return link.getIssueLinkType().getName();
	}
	
	public String getIssueTypeUrl() {
		
		return destinationIssue.getIssueTypeObject().getIconUrlHtml();
	}

	public String getKey() {
		
		return destinationIssue.getKey();
	}
	
	public String getPriorityUrl() {
		
		return destinationIssue.getPriorityObject().getIconUrlHtml();
	}
	
	public String getStatusUrl() {
		
		return destinationIssue.getStatusObject().getIconUrlHtml();
	}
	
	public String getSummary() {
		
		return destinationIssue.getSummary();
	}
}
