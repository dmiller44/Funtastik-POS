<!doctype html>
<html>
<head>
    <meta name="layout" content="funtastik-bootstap"/>
    <title>Funtastik | POS System</title>

</head>

<body>
<div class="span3">
    ${render(template: '/cashRegister/side-navigation')}
</div>

<div class="span9">
    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>Transaction ID</th>
            <th>Transaction Date</th>
            <th>Customer</th>
            <th>Cashier</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${transactions}" status="i" var="transaction">
            <tr>
                <td>${transaction.id}</td>
                <td>${formatDate(format: 'MM/dd/yyyy @ hh:mm aa', date: transaction.transactionDate)}</td>
                <td>${transaction.customer ? transaction.customer.lastName : 'No Customer'}</td>
                <td>${transaction.cashier.username}</td>
                <td>
                    <a class="btn btn-success"
                       href="${createLink(controller: 'cashRegister', action: 'index', id: transaction.id)}">Show</a>
                    <button class="btn btn-warning" onclick="showCancelModal('${transaction.id}');">Cancel</button>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>

<div id="markTransactionCancelledModal" class="modal hide fade" tabindex="-1" role="dialog">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>

        <h3 id="myModalLabel3">Are You Sure???</h3>
    </div>

    <div class="modal-body">
        <form id="inlineMarkTransactionCancelled" class="form-horizontal"
              action="${createLink(controller: 'cashRegister', action: 'markTransactionCancelled')}" method="POST">
            <g:hiddenField name="transactionId" value="-1"/>
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

<script type="text/javascript">
    function showCancelModal(transactionId) {
        $('#transactionId').val(transactionId);
        $('#markTransactionCancelledModal').modal('show');
    }
</script>

</body>
</html>
