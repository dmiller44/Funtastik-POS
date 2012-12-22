<g:if test="${flash.message != null}">
    <div class="alert alert-success">
        <a data-dismiss="alert" class="close">×</a>
        ${flash.message}
    </div>
</g:if>
<g:form class="form-horizontal" action="update">
    <fieldset>
        <legend>Editing Item Type</legend>

        <div class="control-group">
            <label class="control-label" for="name">Item Type Name</label>

            <div class="controls">
                <input type="hidden" name="id" value="${itemTypeInstance?.id}"/>
                <input type="text" class="input-xlarge" id="name" name="name" value="${itemTypeInstance?.name}">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Item Type</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>