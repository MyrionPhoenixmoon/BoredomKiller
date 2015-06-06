<div class="content">
    <div class="content-header">
        Maluses
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_malus" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add malus</button>
        </p>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th width="20%">Name</th>
                    <th width="50%">Description</th>
                    <th width="15">Rating</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($maluses as $ml): ?>
                    <tr>
                        <td><?php echo $ml->name; ?></td>
                        <td><?php echo $ml->description; ?></td>
                        <td><?php echo $ml->rating; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_malus" data-id="<?php echo $ml->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_malus" data-id="<?php echo $ml->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_malus_form">
    <div class="modal-header">
        <button class="close" data-dismiss="modal" id="modal_malus_close">&times;</button>
        <h3 id="malus_form_title"></h3>
    </div>
    <div class="modal-body">
        <form class="modal-form" id="malus_form">
            <input type="hidden" name="malus_id" id="malus_id" value="0">
            <label>Name*:</label>
            <div class="control-group">
                <input type="text" name="malus_name" id="malus_name"> <span class="error-span" id="error_malus_name"></span>
            </div>
            <label>Description*:</label>
            <div class="control-group">
                <textarea name="malus_description" id="malus_description"></textarea> <span class="error-span" id="error_malus_description"></span>
            </div>
            <label>Rating*:</label>
            <div class="control-group">
                <input type="text" name="malus_rating" id="malus_rating"> <span class="error-span" id="error_malus_rating"></span>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="btn_save_malus" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
    </div>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_malus_delete">
    <div class="modal-header">
        <div class="close modal_malus_delete_close" data-dismiss="modal">&times;</div>
        <h3 id="gametype_delete_title">Delete malus</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="malus_id_delete" name="malus_id_delete" value="0">
        <p>Are you sure you want to delete the malus <b id="malus_name_delete"></b>?</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_malus" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_malus_delete_close" data-dismiss="modal">No</button>
    </div>
</div>