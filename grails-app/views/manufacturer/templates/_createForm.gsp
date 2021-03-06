<g:form class="form-horizontal" action="save">
    <fieldset>
        <legend>Add a Manufacturer</legend>

        <div class="control-group">
            <label class="control-label" for="name">Manufacturer Name</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="name" name="name" value="${manufacturerInstance?.name}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="phoneNumber">Phone Number</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="phoneNumber" name="phoneNumber"
                       value="${manufacturerInstance?.phoneNumber}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="webSite">Web Site</label>

            <div class="controls">
                <input type="text" class="input-xlarge" id="webSite" name="webSite"
                       value="${manufacturerInstance?.webSite}">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="preferredVendor">Preferred Vendor?</label>

            <div class="controls">
                <label class="checkbox">
                    <g:checkBox id="preferredVendor" name="preferredVendor"
                                value="${manufacturerInstance?.preferredVendor}"/>
                    Check this box if you prefer to order product from this Vendor
                </label>
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Manufacturer</button>
            <a href="${createLink(action: 'list')}" class="btn">Return Home</a>
        </div>
    </fieldset>
</g:form>