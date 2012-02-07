<ul class="nav nav-list">
  <li class="nav-header">
    Inventory Control
  </li>
  <li class="">
    <a href="#">
	<i class="icon-list"></i>
	Item List
	</a>
  </li>
  <li>
    <a href="#">
	<i class="icon-search"></i>
	Find an Item
	</a>
  </li>
	<li>
	    <a href="#">
		<i class="icon-plus-sign"></i>
		Add an Item
		</a>
	  </li>
</ul>
<ul class="nav nav-list">
  <li class="nav-header">
    Detail Administration
  </li>
  <li id="department">
    <a href="${createLink(controller: 'department', action: 'list')}">
	<i class="icon-folder-open"></i>
	Departments
	</a>
  </li>
  <li id="manufacturer">
    <a href="${createLink(controller: 'manufacturer', action: 'list')}">
	<i class="icon-barcode"></i>
	Manufacturers
	</a>
  </li>
	<li id="color">
	    <a href="${createLink(controller: 'color', action: 'list')}">
		<i class="icon-tint"></i>
		Colors
		</a>
	  </li>
	<li id="itemType">
	    <a href="${createLink(controller: 'itemType', action: 'list')}">
		<i class="icon-check"></i>
		Types/Sub-Types
		</a>
	  </li>
	<li id="size">
	    <a href="${createLink(controller: 'size', action: 'list')}">
		<i class="icon-signal"></i>
		Sizes
		</a>
	  </li>
</ul>