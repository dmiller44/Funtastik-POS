<ul class="nav nav-list">
    <li class="nav-header">
        Cash Register
    </li>
    <li id="newTransaction">
        <a href="${createLink(controller: 'cashRegister')}">
            <i class="icon-shopping-cart"></i>
            New Transaction
        </a>
    </li>
    <li id="lookupPending">
        <a href="#">
            <i class="icon-time"></i>
            Lookup Pending
        </a>
    </li>
    <li id="lookupLayaway">
        <a href="#">
            <i class="icon-gift"></i>
            Lookup Layaway
        </a>
    </li>
    <li id="customerLookup">
        <a href="#">
            <i class="icon-user"></i>
            Customer Lookup
        </a>
    </li>
    <li id="itemLookup">
        <a href="${createLink(controller: 'search', action: 'inventorySearch', id: 'cashRegister')}">
            <i class="icon-barcode"></i>
            Item Lookup
        </a>
    </li>
</ul>