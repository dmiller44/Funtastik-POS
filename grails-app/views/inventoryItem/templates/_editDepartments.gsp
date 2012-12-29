<g:if test="${flash.message != null}">
    <div class="alert alert-success">
        <a data-dismiss="alert" class="close">×</a>
        ${flash.message}
    </div>
</g:if>
<g:form class="form-horizontal" action="addDepartments">
    <fieldset>
        <legend>Adding Departments to ${inventoryItemInstance.name}</legend>

        <g:hiddenField name="id" value="${inventoryItemInstance.id}"/>
        <g:each in="${departments}" var="department" status="i">
            <div class="control-group">
                <label class="control-label" for="department${department.id}">${department.name}</label>

                <div class="controls">
                    <label class="checkbox">
                        <g:checkBox id="department${department.id}" name="checkedDepartments"
                                    value="${department.id}"
                                    checked="${inventoryItemInstance.departments?.contains(department)}"/>
                    </label>
                </div>
            </div>
        </g:each>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Add Departments</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>