<div class="row" style="padding-bottom: 25px;">
    <div class="span4 offset7">
        <table class="table table-bordered" style="float:right;">
            <tbody>
            <tr>
                <td>ID:</td>
                %{--<td>0000000001</td>--}%
                <td>${transaction.id}</td>
            </tr>
            <tr>
                <td>Date:</td>
                %{--<td>12/29/2012 @ 9:46pm</td>--}%
                <td>${formatDate(format: 'MM/dd/yyyy @ hh:mm aa', date: transaction.transactionDate)}</td>
            </tr>
            <tr>
                <td>Cashier:</td>
                <td>${transaction.cashier?.username}</td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>${transaction.status?.id}</td>
            </tr>
            <tr>
                <td>Customer:</td>
                <td><button type="button" class="btn btn-info">Add Customer</button></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="span11" style="text-align: center;">
        <g:form class="form-search" action="addItemToTransaction">
            <g:hiddenField name="id" value="${transaction.id}"/>
            <input id="queryItem" name="queryItem" type="text" class="input-xlarge search-query" style="height: 30px;"
                   placeholder="Enter SKU..."/>
            <g:select name="itemSize" id="itemSize" from="${[]}" noSelection="['': ' -Enter SKU Code- ']"/>
            <button type="submit" class="btn">Add...</button>
        </g:form>
    </div>
</div>

<div class="row">
    <div class="span11">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>SKU</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Size</th>
                <th>Quantity</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <g:if test="${transaction.lineItems && transaction.lineItems?.size() > 0}">
                <g:each in="${transaction.lineItems}" var="lineItem" status="i">
                    <tr>
                        <td>${lineItem.item.skuCode}</td>
                        <td>${lineItem.item.name}</td>
                        <td>${lineItem.item.description}</td>
                        <td>${lineItem.item.retailPrice}</td>
                        <td>${lineItem.size.name}</td>
                        <td>1</td>
                        <td>
                            <a href="${createLink(action: 'removeItemFromTransaction', id: lineItem.id, params: ['transactionId': transaction.id])}">
                                <i class="icon-remove"></i>
                            </a>
                        </td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="6" style="text-align: center;">No Items on Transaction</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</div>

<div class="row" style="text-align: right;">
    <div class="span11">
        <dl class="table-display">
            <dt>Subtotal</dt>
            <dd>$1100.00</dd>
            <dt>Tax</dt>
            <dd>$66.00</dd>
            <dt>Total</dt>
            <dd>$1166.00</dd>
        </dl>
    </div>
</div>

<div class="row" style="text-align: center;">
    <div class="span11">
        <div class="btn-toolbar">
            <div class="btn-group">
                <button type="button" class="btn btn-warning">Cancel Transaction</button>
                <button type="button" class="btn">Layaway Transaction</button>
                <button type="button" class="btn">Mark as Pending</button>
                <button type="button" class="btn">Add Transaction Discount</button>
                <button type="button" class="btn btn-success">Add Payment Entry</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" language="javascript">
    $(document).ready(function () {
        $("#queryItem").blur(function () {
            var skuCode = $('#queryItem').val();
            var jqxhr = $.get('/funtastik-pos-system/cashRegister/ajaxGetSizes', { skuCode: skuCode },
                    function (data) {
                        var options = '';

                        for (var i = 0; i < data.sizes.length; i++) {
                            options += '<option value="' + data.sizes[i].id + '">' + data.sizes[i].name + '</option>';
                        }
                        $('#itemSize').html(options);
                    }
            )
        });
    });
</script>