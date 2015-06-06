<div class="content">
    <div class="content-header">
        Platforms
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_platform" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add platform</button>
        </p>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th width="85%">Name</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($platforms as $pf): ?>
                    <tr>
                        <td><?php echo $pf->name; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_platform" data-id="<?php echo $pf->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_platform" data-id="<?php echo $pf->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_platform_form">
    <div class="modal-header">
        <button class="close" data-dismiss="modal" id="modal_platform_close">&times;</button>
        <h3 id="platform_form_title"></h3>
    </div>
    <div class="modal-body">
        <form class="modal-form" id="platform_form">
            <input type="hidden" name="platform_id" id="platform_id" value="0">
            <label>Name*:</label>
            <div class="control-group">
                <input type="text" name="platform_name" id="platform_name"> <span class="error-span" id="error_platform_name"></span>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="btn_save_platform" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
    </div>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_platform_delete">
    <div class="modal-header">
        <button class="close modal_platform_delete_close" data-dismiss="modal">&times;</button>
        <h3 id="platform_delete_title">Delete platform</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="platform_id_delete" name="platform_id_delete" value="0">
        <p>Are you sure you want to delete the platform <b id="platform_name_delete"></b>?</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_platform" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_platform_delete_close" data-dismiss="modal">No</button>
    </div>
</div>