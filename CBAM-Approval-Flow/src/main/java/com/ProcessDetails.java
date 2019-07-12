package com;

/**
 * This class was automatically generated by the data modeler tool.
 */

@javax.persistence.Entity
public class ProcessDetails
		implements
			java.io.Serializable,
			java.lang.Cloneable {

	static final long serialVersionUID = 1L;

	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "PROCESSDETAILS_ID_GENERATOR")
	@javax.persistence.Id
	@javax.persistence.SequenceGenerator(name = "PROCESSDETAILS_ID_GENERATOR", sequenceName = "PROCESSDETAILS_ID_SEQ")
	private java.lang.Long id;

	@org.kie.api.definition.type.Label("Role")
	private java.lang.String role;

	@org.kie.api.definition.type.Label("Start Date")
	private java.lang.String startDate;

	@org.kie.api.definition.type.Label("Approval Status")
	private java.lang.String approvalStatus;

	@org.kie.api.definition.type.Label("Reject Remarks")
	private java.lang.String rejectRemarks;

	@org.kie.api.definition.type.Label("Current Approver Active Flag")
	private java.lang.Boolean isCurrentApprover;

	public ProcessDetails() {
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getRole() {
		return this.role;
	}

	public void setRole(java.lang.String role) {
		this.role = role;
	}

	public java.lang.String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(java.lang.String startDate) {
		this.startDate = startDate;
	}

	public java.lang.String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(java.lang.String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public java.lang.String getRejectRemarks() {
		return this.rejectRemarks;
	}

	public void setRejectRemarks(java.lang.String rejectRemarks) {
		this.rejectRemarks = rejectRemarks;
	}

	public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
		return super.clone();
	}

	public java.lang.Boolean getIsCurrentApprover() {
		return this.isCurrentApprover;
	}

	public void setIsCurrentApprover(java.lang.Boolean isCurrentApprover) {
		this.isCurrentApprover = isCurrentApprover;
	}

	public ProcessDetails(java.lang.Long id, java.lang.String role,
			java.lang.String startDate, java.lang.String approvalStatus,
			java.lang.String rejectRemarks, java.lang.Boolean isCurrentApprover) {
		this.id = id;
		this.role = role;
		this.startDate = startDate;
		this.approvalStatus = approvalStatus;
		this.rejectRemarks = rejectRemarks;
		this.isCurrentApprover = isCurrentApprover;
	}

}