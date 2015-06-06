<div class="content">
    <div class="content-header">
        Playstyles
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_playstyle" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add playstyles</button>
        </p>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th width="85%">Name</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($playstyles as $ps): ?>
                    <tr>
                        <td><?php echo $ps->name; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_playstyle" data-id="<?php echo $ps->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_playstyle" data-id="<?php echo $ps->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_playstyle_form">
    <div class="modal-header">
        <button class="close" data-dismiss="modal" id="modal_playstyle_close">&times;</button>
        <h3 id="playstyle_form_title"></h3>
    </div>
    <div class="modal-body">
        <form class="modal-form" id="playstyle_form">
            <input type="hidden" name="playstyle_id" id="playstyle_id" value="0">
            <label>Name*:</label>
            <div class="control-group">
                <input type="text" name="playstyle_name" id="playstyle_name"> <span class="error-span" id="error_playstyle_name"></span>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="btn_save_playstyle" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
    </div>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_playstyle_delete">
    <div class="modal-header">
        <div class="close modal_playstyle_delete_close" data-dismiss="modal">&times;</div>
        <h3 id="playstyle_delete_title">Delete playstyle</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="playstyle_id_delete" name="playstyle_id_delete" value="0">
        <p>Are you sure you want to delete the playstyle <b id="playstyle_name_delete"></b>? All associations to games will be deleted aswell.</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_playstyle" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_playstyle_delete_close" data-dismiss="modal">No</button>
    </div>
</div>