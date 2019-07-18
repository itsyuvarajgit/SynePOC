package com;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class RuleValueStorage implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@javax.persistence.GeneratedValue(generator = "RULEVALUESTORAGE_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO)
	@javax.persistence.Id
	@javax.persistence.SequenceGenerator(name = "RULEVALUESTORAGE_ID_GENERATOR", sequenceName = "RULEVALUESTORAGE_ID_SEQ")
	private java.lang.Long id;

	@org.kie.api.definition.type.Label("Amount")
	private java.lang.Integer amount;

	@org.kie.api.definition.type.Label("Status")
	private java.lang.String status;

	@org.kie.api.definition.type.Label("Flow Variable")
	private java.lang.String flow;

	@org.kie.api.definition.type.Label("Reject Remarks")
	private java.lang.String rejectRemarks;

	@org.kie.api.definition.type.Label("valid")
	private String valid;

	public RuleValueStorage() {
	}

	public java.lang.Long getId() {
		return this.id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Integer getAmount() {
		return this.amount;
	}

	public void setAmount(java.lang.Integer amount) {
		this.amount = amount;
	}

	public java.lang.String getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getFlow() {
		return this.flow;
	}

	public void setFlow(java.lang.String flow) {
		this.flow = flow;
	}

	public java.lang.String getRejectRemarks() {
		return this.rejectRemarks;
	}

	public void setRejectRemarks(java.lang.String rejectRemarks) {
		this.rejectRemarks = rejectRemarks;
	}

	public java.lang.String getValid() {
		return this.valid;
	}

	public void setValid(java.lang.String valid) {
		this.valid = valid;
	}

	public RuleValueStorage(java.lang.Long id, java.lang.Integer amount,
			java.lang.String status, java.lang.String flow,
			java.lang.String rejectRemarks, java.lang.String valid) {
		this.id = id;
		this.amount = amount;
		this.status = status;
		this.flow = flow;
		this.rejectRemarks = rejectRemarks;
		this.valid = valid;
	}

}