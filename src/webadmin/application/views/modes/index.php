<div class="content">
    <div class="content-header">
        Maluses
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_mode" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add mode</button>
        </p>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th width="43%">Name</th>
                    <th width="42%">Game</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($modes as $md): ?>
                    <tr>
                        <td><?php echo $md->name; ?></td>
                        <td><?php echo $mode_games[$md->id]->name; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_mode" data-id="<?php echo $md->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_mode" data-id="<?php echo $md->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_mode_form">
    <?php if (count($playstyles)): ?>
        <div class="modal-header">
            <button class="close" data-dismiss="modal" id="modal_mode_close">&times;</button>
            <h3 id="mode_form_title"></h3>
        </div>
        <div class="modal-body">
            <form class="modal-form" id="mode_form">
                <input type="hidden" name="mode_id" id="mode_id" value="0">
                <label>Name*:</label>
                <div class="control-group">
                    <input type="text" name="mode_name" id="mode_name"> <span class="error-span" id="error_mode_name"></span>
                </div>
                <label>Playstyle*:</label>
                <div class="control-group">
                    <select name="mode_playstyle[]" id="mode_playstyle" multiple>
                        <?php foreach ($playstyles as $ps): ?>
                            <option value="<?php echo $ps->id; ?>"><?php echo $ps->name; ?></option>
                        <?php endforeach; ?>
                    </select> <span class="error-span" id="error_mode_playstyle"></span>
                </div>
                <label>Game*:</label>
                <div class="control-group">
                    <select type="text" name="mode_game" id="mode_game">
                        <option value="">Please choose</option>
                        <option value="">---</option>
                        <?php foreach ($games as $gm): ?>
                            <option value="<?php echo $gm->id; ?>"><?php echo $gm->name; ?></option>
                        <?php endforeach; ?>
                    </select> <span class="error-span" id="error_mode_game"></span>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button id="btn_save_mode" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
        </div>
    <?php else: ?>
        <div class="modal-body">
            <button class="close" data-dismiss="modal">&times;</button>
            <p>You have not added any playstyles yet. Please do that first.</p>
        </div>
    <?php endif; ?>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_mode_delete">
    <div class="modal-header">
        <div class="close modal_mode_delete_close" data-dismiss="modal">&times;</div>
        <h3 id="gametype_delete_title">Delete mode</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="mode_id_delete" name="mode_id_delete" value="0">
        <p>Are you sure you want to delete the mode <b id="mode_name_delete"></b>?</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_mode" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_mode_delete_close" data-dismiss="modal">No</button>
    </div>
</div>