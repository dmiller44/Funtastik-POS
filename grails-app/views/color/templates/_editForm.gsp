<form class="form-horizontal">
  <fieldset>
    <legend>Editing Color</legend>
    <div class="control-group">
      <label class="control-label" for="name">Color Name</label>
      <div class="controls">
        <input type="text" class="input-xlarge" id="name" name="name" value="${colorInstance?.name}">
      </div>
    </div>
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Save Color</button>
      <button type="reset" class="btn">Cancel</button>
    </div>
  </fieldset>
</form>