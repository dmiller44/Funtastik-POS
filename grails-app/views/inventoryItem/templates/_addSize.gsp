<g:form class="form-horizontal" action="saveSizeToItem">
    <fieldset>
        <legend>Adding Size To ${inventoryItemInstance?.name}</legend>

        <div class="control-group">
            <label class="control-label" for="size">Item Type</label>

            <div class="controls">
                <g:hiddenField name="inventoryItem" value="${inventoryItemInstance?.id}"/>
                <g:select id="size" name="size.id" from="${sizes}"
                          optionKey="id" value=""/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="qoh">Quantity</label>

            <div class="controls">
                <input type="text" class="span1" id="qoh" name="qoh"
                       value="0">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="priceQuantifier">Price Quantifier</label>

            <div class="controls">
                <input type="text" class="span1" id="priceQuantifier" name="priceQuantifier"
                       value="1.00">
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Size</button>
            <a href="${createLink(action: 'edit', id: inventoryItemInstance?.id)}" class="btn">Return To Item</a>
        </div>
    </fieldset>
</g:form>