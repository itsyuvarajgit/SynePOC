{"id":"a295a966-5d43-4ecc-9a90-7f93138ed55a","name":"com_ApprovalDetails","model":{"source":"INTERNAL","className":"com.ApprovalDetails","name":"ApprovalDetails","properties":[{"name":"approvalStatus","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"Approval Status"},{"name":"field-placeHolder","value":"Approval Status"}]}},{"name":"remarks","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[{"name":"field-label","value":"Remarks"},{"name":"field-placeHolder","value":"Remarks"}]}}],"formModelType":"org.kie.workbench.common.forms.data.modeller.model.DataObjectFormModel"},"fields":[{"maxLength":100,"placeHolder":"Remarks","id":"field_3159685645762366E12","name":"remarks","label":"Remarks","required":false,"readOnly":false,"validateOnChange":true,"binding":"remarks","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"},{"options":[{"value":"APPROVED","text":"Approve"},{"value":"REJECTED","text":"Reject"}],"addEmptyOption":true,"dataProvider":"","id":"field_074320406506475E12","name":"approvalStatus","label":"Approval Status","required":false,"readOnly":false,"validateOnChange":true,"helpMessage":"","binding":"approvalStatus","standaloneClassName":"java.lang.String","code":"ListBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.selectors.listBox.definition.StringListBoxFieldDefinition"}],"layoutTemplate":{"version":3,"style":"FLUID","layoutProperties":{},"rows":[{"height":"12","properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_074320406506475E12","form_id":"a295a966-5d43-4ecc-9a90-7f93138ed55a"},"parts":[{"partId":"Field Label","cssProperties":{}},{"partId":"ListBox","cssProperties":{}}]}]}]},{"height":"12","properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_3159685645762366E12","form_id":"a295a966-5d43-4ecc-9a90-7f93138ed55a"},"parts":[{"partId":"TextBox","cssProperties":{}},{"partId":"Field Label","cssProperties":{}}]}]}]}]}}