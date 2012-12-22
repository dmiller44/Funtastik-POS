<%@ page import="com.angrygiant.funtastik.pos.domain.ItemType" %>
<g:form class="form-horizontal" action="save">
    <fieldset>
        <legend>Creating New Size</legend>

        <div class="control-group">
            <label class="control-label" for="name">Size Name</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="name" name="name" value="${sizeInstance?.name}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="itemType">Item Type</label>

            <div class="controls">
                <g:select id="itemType" name="itemType.id" from="${ItemType.list()}"
                          optionKey="id" value="${sizeInstance?.itemType?.id}"/>
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Size</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>