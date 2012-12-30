<div class="row" style="padding-bottom: 25px;">
    <div class="span4 offset7">
        <table class="table table-bordered" style="float:right;">
            <tbody>
            <tr>
                <td>Date:</td>
                <td>12/29/2012 @ 9:46pm</td>
            </tr>
            <tr>
                <td>Cashier:</td>
                <td>${sec.loggedInUserInfo(field: 'username')}</td>
            </tr>
            <tr>
                <td>Status:</td>
                <td>OPEN</td>
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
        <g:form class="form-search" action="addNewItem">
            <input name="queryItem" type="text" class="input-xlarge search-query" style="height: 30px;"
                   placeholder="Add Item..."/>
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
                <th>Quantity</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>55555</td>
                <td>Flying V</td>
                <td>Flying V Snowboard</td>
                <td>$550.00</td>
                <td>1</td>
                <td><i class="icon-remove"></i></td>
            </tr>
            <tr>
                <td>55555</td>
                <td>Flying V</td>
                <td>Flying V Snowboard</td>
                <td>$550.00</td>
                <td>1</td>
                <td><i class="icon-remove"></i></td>
            </tr>
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
                <button type="button" class="btn">Layaway Transaction</button>
                <button type="button" class="btn">Mark as Pending</button>
                <button type="button" class="btn">Add Transaction Discount</button>
                <button type="button" class="btn btn-success">Add Payment Entry</button>
            </div>
        </div>
    </div>
</div>