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
                <td>
                    <g:if test="${transaction.customer}">
                        ${transaction.customer?.fullName}<br/><br/><button type="button" class="btn btn-info"
                                                                           onclick="$('#addCustomerModal').modal('show');">Change Customer</button>
                    </g:if>
                    <g:else>
                        <button type="button" class="btn btn-info"
                                onclick="$('#addCustomerModal').modal('show');">Add Customer</button>
                    </g:else>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="span11" style="text-align: center;">
        <g:if test="${transaction.status != com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.COMPLETED}">
            <g:form class="form-search" action="addItemToTransaction">
                <g:hiddenField name="id" value="${transaction.id}"/>
                <input id="queryItem" name="queryItem" type="text" class="input-xlarge search-query"
                       style="height: 30px;"
                       placeholder="Enter SKU..."/>
                <g:select name="itemSize" id="itemSize" from="${[]}" noSelection="['': ' -Enter SKU Code- ']"/>
                <button type="submit" class="btn">Add...</button>
            </g:form>
        </g:if>
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
                        <td onclick="showPriceModal('${lineItem.id}', '${lineItem.price}');">${formatNumber(number: lineItem.price, type: 'currency')}</td>
                        <td>${lineItem.size.name}</td>
                        <td onclick="showQuantityModal('${lineItem.id}', '${lineItem.quantity}');">${lineItem.quantity}</td>
                        <td>
                            <g:if test="${transaction.status == com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.OPEN || transaction.status == com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.LAYAWAY}">
                                <a href="${createLink(action: 'removeItemFromTransaction', id: lineItem.id, params: ['transactionId': transaction.id])}">
                                    <i class="icon-remove"></i>
                                </a>
                            </g:if>
                        </td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="7" style="text-align: center;">No Items on Transaction</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</div>

<div class="row" style="text-align: right;">
    <div class="span11">
        <dl class="table-display">
            <g:if test="${transaction.transactionDiscount > 0}">
                <dt>Discount</dt>
                <dd>${formatNumber(number: transaction.transactionDiscount, type: 'percent')}</dd>
            </g:if>
            <dt>Subtotal</dt>
            <dd>${formatNumber(number: subtotal, type: 'currency')}</dd>
            <dt>Tax</dt>
            <dd>${formatNumber(number: salesTax, type: 'currency')}</dd>
            <dt>Total</dt>
            <dd>${formatNumber(number: (subtotal + salesTax), type: 'currency')}</dd>
            <g:if test="${totalDue > 0}">
                <dt style="color: red;">Total Due</dt>
                <dd style="color: red;">${formatNumber(number: totalDue, type: 'currency')}</dd>
            </g:if>
            <g:else>
                <dt style="color: green;">Change</dt>
                <dd style="color: green;">${formatNumber(number: totalDue * -1, type: 'currency')}</dd>
            </g:else>
        </dl>
    </div>
</div>

<div class="row" style="text-align: center;">
    <div class="span11">
        <div class="btn-toolbar">
            <div class="btn-group">
                <g:render template="templates/buttonGroup${transaction.status.id}"/>
            </div>
        </div>
    </div>
</div>

<div class="row" style="padding-top: 25px;">
    <div class="span11">
        <table class="table table-bordered table-striped">
            <caption
                    style="font-weight: bolder; font-size: 16px; margin-bottom: 10px;">Applied Payment Entries</caption>
            <thead>
            <tr>
                <th>Payment Date</th>
                <th>Amount</th>
                <th>Type</th>
                <th>Cashier</th>
                <th>Ref. Number</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <g:if test="${transaction.payments && transaction.payments?.size() > 0}">
                <g:each in="${transaction.payments}" var="payment" status="i">
                    <tr>
                        <td>${formatDate(format: 'MM/dd/yyyy @ hh:mm aa', date: payment.paymentDate)}</td>
                        <td>${formatNumber(number: payment.amount, type: 'currency')}</td>
                        <td>${payment.paymentMethod}</td>
                        <td>${payment.cashier?.username}</td>
                        <td>${payment.referenceNumber}</td>
                        <td>
                            <g:if test="${transaction.status == com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.OPEN || transaction.status == com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.LAYAWAY}">
                                <a href="${createLink(action: 'removePaymentEntryFromTransaction', id: payment.id, params: ['transactionId': transaction.id])}">
                                    <i class="icon-remove"></i>
                                </a>
                            </g:if>
                        </td>
                    </tr>
                </g:each>
            </g:if>
            <g:else>
                <tr>
                    <td colspan="6" style="text-align: center;">No Payments Entered</td>
                </tr>
            </g:else>
            </tbody>
        </table>
    </div>
</div>

<div class="row" style="text-align: center;">
    <div class="span11">
        <div class="btn-toolbar">
            <div class="btn-group">
                <g:if test="${transaction.status != com.angrygiant.funtastik.pos.domain.transaction.TransactionStatus.COMPLETED}">
                    <g:render template="templates/buttonGroupPayment"/>
                </g:if>
            </div>
        </div>
    </div>
</div>

<div id="transactionPaymentEntryModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="modalLabel">Add Payment Entry</h3>
    </div>

    <div class="modal-body">
        <form id="inlineTransactionPaymentEntry" class="form-horizontal"
              action="${createLink(action: 'addPaymentToTransaction')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <div class="control-group">
                <label class="control-label" for="paymentMethod">Method</label>

                <div class="controls">
                    <g:select name="paymentMethod" id="paymentMethod"
                              from="${com.angrygiant.funtastik.pos.domain.transaction.PaymentMethods.values()*.id}"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="paymentAmount">Amount</label>

                <div class="controls">
                    $<g:textField class="input-medium" id="paymentAmount" name="paymentAmount"
                                  value="0"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="paymentReferenceNumber">Reference #</label>

                <div class="controls">
                    <g:textField class="input-large" id="paymentReferenceNumber" name="paymentReferenceNumber"
                                 value=""/>
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary">Save Changes</button>
                <a href="#" onclick="$('#transactionPaymentEntryModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="transactionDiscountModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel">Set Transaction Discount</h3>
    </div>

    <div class="modal-body">
        <form id="inlineTransactionDiscount" class="form-horizontal"
              action="${createLink(action: 'addTransactionDiscount')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <div class="control-group">
                <label class="control-label" for="transactionDiscount">Discount</label>

                <div class="controls">
                    <g:textField class="input-mini" id="transactionDiscount" name="transactionDiscount"
                                 value="${formatNumber(number: transaction.transactionDiscount * 100)}"/>%
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary">Save Changes</button>
                <a href="#" onclick="$('#transactionDiscountModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="markTransactionOpenModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel2">Are You Sure???</h3>
    </div>

    <div class="modal-body">
        <form id="inlineMarkTransactionOpen" class="form-horizontal"
              action="${createLink(action: 'markTransactionOpen')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <p>
                Are you sure you want to reopen this transaction?
            </p>

            <div class="form-actions">
                <button class="btn btn-primary">Mark as OPEN</button>
                <a href="#" onclick="$('#markTransactionOpenModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="markTransactionPendingModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel1">Are You Sure???</h3>
    </div>

    <div class="modal-body">
        <form id="inlineMarkTransactionPending" class="form-horizontal"
              action="${createLink(action: 'markTransactionPending')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <p>
                Are you sure you want to put this transaction in a PENDING state?
            </p>

            <div class="form-actions">
                <button class="btn btn-primary">Mark as PENDING</button>
                <a href="#" onclick="$('#markTransactionPendingModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="markTransactionCancelledModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel3">Are You Sure???</h3>
    </div>

    <div class="modal-body">
        <form id="inlineMarkTransactionCancelled" class="form-horizontal"
              action="${createLink(action: 'markTransactionCancelled')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <p>
                Are you sure you want to cancel this transaction???
            </p>

            <div class="form-actions">
                <button class="btn btn-danger">Cancel Transaction</button>
                <a href="#" onclick="$('#markTransactionCancelledModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="markTransactionLayawayModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel4">Are You Sure???</h3>
    </div>

    <div class="modal-body">
        <form id="inlineMarkTransactionLayaway" class="form-horizontal"
              action="${createLink(action: 'markTransactionLayaway')}" method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <p>
                Are you sure you want to LAYAWAY this transaction???
            </p>

            <div class="form-actions">
                <button class="btn btn-primary">Layaway Transaction</button>
                <a href="#" onclick="$('#markTransactionLayawayModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="editQohModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel5">Edit Quantity</h3>
    </div>

    <div class="modal-body">
        <form id="inlineEditQoh" class="form-horizontal" action="${createLink(action: 'addQuantityToLineItem')}"
              method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <g:hiddenField name="lineItemId" value="-1"/>
            <div class="control-group">
                <label class="control-label" for="quantity">Quantity</label>

                <div class="controls">
                    <g:textField id="quantity" name="quantity" value="-1"/>
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary">Save Changes</button>
                <a href="#" onclick="$('#editQohModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="editLineItemPriceModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">?</button>

        <h3 id="myModalLabel6">Edit Price</h3>
    </div>

    <div class="modal-body">
        <form id="inlineEditLineItemPrice" class="form-horizontal" action="${createLink(action: 'editLineItemPrice')}"
              method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <g:hiddenField name="pricelineItemId" value="-1"/>
            <div class="control-group">
                <label class="control-label" for="price">Price</label>

                <div class="controls">
                    <g:textField id="price" name="price" value="-1"/>
                </div>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary">Save Changes</button>
                <a href="#" onclick="$('#editLineItemPriceModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<div id="addCustomerModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">X</button>

        <h3 id="customerModalLabel">Add Customer to Transaction</h3>
    </div>

    <div class="modal-body">
        <form id="inlineCustomerModal" class="form-horizontal"
              action="${createLink(action: 'addCustomerToTransaction')}"
              method="POST">
            <g:hiddenField name="transactionId" value="${transaction.id}"/>
            <g:hiddenField name="customerId" value=""/>
            <div class="control-group">
                <label class="control-label" for="customerName">Customer Name</label>

                <div class="controls">
                    <g:textField id="customerName" name="customerName" class="input-large"
                                 autocomplete="off"/>&nbsp;&nbsp;&nbsp;<a href="#"
                                                                          onclick="$('#createNewFields').show('show');">Create New...</a>
                </div>
            </div>

            <div class="control-group hide" id="createNewFields">
                <label class="control-label" for="phoneNumber">Phone Number</label>

                <div class="controls">
                    <g:textField id="phoneNumber" name="phoneNumber" value="" class="input-large"
                                 autocomplete="off"/>
                </div>
            </div>

            <div class="control-group" style="text-align: center;">
                <button class="btn btn-primary">Save Changes</button>
                <button onclick="$('#customerId').val('-1');" class="btn btn-warning">Clear Customer</button>
                <a href="#" onclick="$('#addCustomerModal').modal('hide');" class="btn">Close</a>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    function showQuantityModal(lineItemId, quantity) {
        $('#lineItemId').val(lineItemId);
        $('#quantity').val(quantity);
        $('#editQohModal').modal('show');
    }
</script>

<script type="text/javascript">
    function showPriceModal(lineItemId, price) {
        $('#pricelineItemId').val(lineItemId);
        $('#price').val(price);
        $('#editLineItemPriceModal').modal('show');
    }
</script>

<script type="text/javascript" language="javascript">
    var customerList;
    var customers;

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

        $("#customerName").typeahead({
            source: function (query, process) {
                $.post('${createLink(action: "ajaxGetCustomers")}', { q: query, limit: 8 }, function (data) {
                    customerList = [];
                    customers = {};

                    $.each(data, function (index, value) {
                        customerList.push(value.firstName + " " + value.lastName);
                        customers[value.firstName + " " + value.lastName] = value;
                    });
                    process(customerList);
                });
            },
            updater: function (item) {
                var fullName = customers[item].firstName + " " + customers[item].lastName;
                $("#customerId").val(customers[item].id);

                return fullName;
            }
        });

        <g:if test="${!transaction.customer && params.lastSku == 'GIFTCARD'}">
        $('#addCustomerModal').modal('show');
        </g:if>
    });
</script>