<div class="content">
    <div class="content-header">
        Gametypes
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_gametype" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add gametype</button>
        </p>
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th width="85%">Name</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($gametypes as $gt): ?>
                    <tr>
                        <td><?php echo $gt->name; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_gametype" data-id="<?php echo $gt->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_gametype" data-id="<?php echo $gt->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_gametype_form">
    <div class="modal-header">
        <button class="close" data-dismiss="modal" id="modal_gametype_close">&times;</button>
        <h3 id="gametype_form_title"></h3>
    </div>
    <div class="modal-body">
        <form class="modal-form" id="gametype_form">
            <input type="hidden" name="gametype_id" id="gametype_id" value="0">
            <label>Name*:</label>
            <div class="control-group">
                <input type="text" name="gametype_name" id="gametype_name"> <span class="error-span" id="error_gametype_name"></span>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="btn_save_gametype" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
    </div>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_gametype_delete">
    <div class="modal-header">
        <div class="close modal_gametype_delete_close" data-dismiss="modal">&times;</div>
        <h3 id="gametype_delete_title">Delete gametype</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="gametype_id_delete" name="gametype_id_delete" value="0">
        <p>Are you sure you want to delete the gametype <b id="gametype_name_delete"></b>? All associations to games are being deleted aswell.</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_gametype" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_gametype_delete_close" data-dismiss="modal">No</button>
    </div>
</div>