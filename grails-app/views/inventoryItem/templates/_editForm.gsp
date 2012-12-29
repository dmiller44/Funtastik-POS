<%@ page import="com.angrygiant.funtastik.pos.domain.Manufacturer; com.angrygiant.funtastik.pos.domain.Color; com.angrygiant.funtastik.pos.domain.ItemType" %>
<g:if test="${flash.message != null}">
    <div class="alert alert-success">
        <a data-dismiss="alert" class="close">×</a>
        ${flash.message}
    </div>
</g:if>
<g:form class="form-horizontal" action="update">
    <fieldset>
        <legend>Editing ${inventoryItemInstance?.name}</legend>

        <div class="control-group">
            <label class="control-label" for="name">Item Name</label>

            <div class="controls">
                <input type="hidden" name="id" value="${inventoryItemInstance?.id}"/>
                <input type="text" class="input-xlarge" id="name" name="name" value="${inventoryItemInstance?.name}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="description">Item Description</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="description" name="description"
                       value="${inventoryItemInstance?.description}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="skuCode">Item SKU</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="skuCode" name="skuCode"
                       value="${inventoryItemInstance?.skuCode}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="itemType">Item Type</label>

            <div class="controls">
                <g:select id="itemType" name="itemType.id" from="${ItemType.list()}"
                          optionKey="id" value="${inventoryItemInstance?.itemType?.id}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="color">Color</label>

            <div class="controls">
                <g:select id="color" name="color.id" from="${Color.list()}"
                          optionKey="id" value="${inventoryItemInstance?.color?.id}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="manufacturer">Manufacturer</label>

            <div class="controls">
                <g:select id="manufacturer" name="manufacturer.id" from="${Manufacturer.list()}"
                          optionKey="id" value="${inventoryItemInstance?.manufacturer?.id}"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="taxable">Taxable?</label>

            <div class="controls">
                <label class="checkbox">
                    <g:checkBox id="taxable" name="taxable"
                                value="${inventoryItemInstance?.taxable}"/>
                    Check this box if this item is taxable
                </label>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="barcoded">Has Barcode?</label>

            <div class="controls">
                <label class="checkbox">
                    <g:checkBox id="barcoded" name="barcoded"
                                value="${inventoryItemInstance?.barcoded}"/>
                    Check this box if this item has a manufacturer's barcode
                </label>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="wholesalePrice">Wholesale Price</label>

            <div class="controls">
                $<input type="text" class="span1" id="wholesalePrice" name="wholesalePrice"
                        value="${formatNumber(number: inventoryItemInstance?.wholesalePrice, format: '0.00')}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="retailPrice">Retail Price</label>

            <div class="controls">
                $<input type="text" class="span1" id="retailPrice" name="retailPrice"
                        value="${formatNumber(number: inventoryItemInstance?.retailPrice, format: '0.00')}">
            </div>
        </div>

        <div class="control-group">
            <table class="table table-striped table-bordered table-condensed">
                <thead>
                <tr>
                    <td style="font-weight: bold">Size</td>
                    <td style="font-weight: bold">Quantity on Hand</td>
                    <td style="font-weight: bold">Price Quantifier</td>
                    <td style="font-weight: bold">&nbsp;</td>
                </tr>
                </thead>
                <tbody>
                <g:if test="${inventoryItemRecords.size() > 0}">
                    <g:each in="${inventoryItemRecords}" status="i" var="inventoryRecord">
                        <tr>
                            <td>${inventoryRecord?.size?.name}</td>
                            <td>${inventoryRecord?.qoh}</td>
                            <td>${inventoryRecord?.priceQuantifier}</td>
                            <sec:ifAllGranted roles="ROLE_ADMIN">
                                <td style="text-align: center;">
                                    <a href="${createLink(action: 'deleteSizeOnItem', id: inventoryRecord?.id)}"
                                       onclick="return confirm('Do you really wish to delete size ${inventoryRecord?.size?.name}?');">
                                        <i class="icon-remove"></i>
                                    </a>
                                </td>
                            </sec:ifAllGranted>
                        </tr>
                    </g:each>
                    <g:if test="${availableSizesCount > 0}">
                        <tr>
                            <td colspan="3">&nbsp;</td>
                            <td style="text-align: center">
                                <a href="${createLink(action: 'addSizeToItem', id: inventoryItemInstance?.id)}">
                                    <i class="icon-plus-sign"></i>
                                </a>
                            </td>
                        </tr>
                    </g:if>
                </g:if>
                <g:else>
                    <g:if test="${availableSizesCount > 0}">
                        <tr>
                            <td colspan="3" style="text-align: center;">No Sizes Available</td>
                            <td style="text-align: center">
                                <a href="${createLink(action: 'addSizeToItem', id: inventoryItemInstance?.id)}">
                                    <i class="icon-plus-sign"></i>
                                </a>
                            </td>
                        </tr>
                    </g:if>
                    <g:else>
                        <tr>
                            <td colspan="4"
                                style="text-align: center;">No available Sizes - Make sure Item Type's and Sizes are correctly set up.</td>
                        </tr>
                    </g:else>
                </g:else>
                </tbody>
            </table>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Update Item</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>