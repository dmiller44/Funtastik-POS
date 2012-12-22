<g:form class="form-horizontal" action="save">
    <fieldset>
        <legend>Add a Color</legend>

        <div class="control-group">
            <label class="control-label" for="name">Color Name</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="name" name="name" value="${colorInstance?.name}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Color</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>