<g:if test="${flash.message != null}">
    <div class="alert alert-success">
        <a data-dismiss="alert" class="close">×</a>
        ${flash.message}
    </div>
</g:if>
<g:form class="form-horizontal" action="update">
    <fieldset>
        <legend>Editing Department</legend>

        <div class="control-group">
            <label class="control-label" for="name">Department Name</label>

            <div class="controls">
                <input type="hidden" name="id" value="${departmentInstance?.id}"/>
                <input type="text" class="input-xlarge" id="name" name="name" value="${departmentInstance?.name}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Department</button>
            <button type="reset" class="btn">Cancel</button>
        </div>
    </fieldset>
</g:form>