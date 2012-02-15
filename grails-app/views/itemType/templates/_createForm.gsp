<g:form class="form-horizontal" action="save">
    <fieldset>
        <legend>Add a Item Type</legend>

        <div class="control-group">
            <label class="control-label" for="name">Item Type Name</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="name" name="name" value="${itemTypeInstance?.name}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Item Type</button>
            <button type="reset" class="btn">Cancel</button>
        </div>
    </fieldset>
</g:form>