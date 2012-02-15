<g:form class="form-horizontal" action="save">
    <fieldset>
        <legend>Add a Department</legend>

        <div class="control-group">
            <label class="control-label" for="name">Department Name</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="name" name="name" value="${departmentInstance?.name}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Department</button>
            <button type="reset" class="btn">Cancel</button>
        </div>
    </fieldset>
</g:form>