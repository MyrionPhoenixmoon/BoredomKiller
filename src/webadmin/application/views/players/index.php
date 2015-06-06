<div class="content">
    <div class="content-header">
        Players
    </div>
    <div class="content-text">
        <p>
            <button id="btn_add_player" class="btn btn-inverse btn-small"><i class="icon-white icon-plus-sign"></i> Add player</button>
        </p>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th width="85%">Name</th>
                    <th width="15%">Actions</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($players as $p): ?>
                    <tr>
                        <td><?php echo $p->name; ?></td>
                        <td>
                            <button class="btn btn-mini btn-success btn_edit_player" data-id="<?php echo $p->id; ?>"><i class="icon-white icon-edit"></i> edit</button>
                            <button class="btn btn-mini btn-danger btn_delete_player" data-id="<?php echo $p->id; ?>"><i class="icon-white icon-remove"></i> delete</button>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>
<div class="modal" aria-hidden="true" style="display:none;" id="modal_player_form">
    <div class="modal-header">
        <button class="close" data-dismiss="modal" id="modal_player_close">&times;</button>
        <h3 id="player_form_title"></h3>
    </div>
    <div class="modal-body">
        <form class="modal-form" id="player_form">
            <input type="hidden" name="player_id" id="player_id" value="0">
            <label>Name*:</label>
            <div class="control-group">
                <input type="text" name="player_name" id="player_name"> <span class="error-span" id="error_player_name"></span>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <button id="btn_save_player" class="btn btn-primary"><i class="icon-white icon-ok"></i> Save</button>
    </div>
</div>

<div class="modal" aria-hidden="true" style="display:none;" id="modal_player_delete">
    <div class="modal-header">
        <div class="close modal_player_delete_close" data-dismiss="modal">&times;</div>
        <h3 id="player_delete_title">Delete player</h3>
    </div>
    <div class="modal-body">
        <input type="hidden" id="player_id_delete" name="player_id_delete" value="0">
        <p>Are you sure you want to delete the player <b id="player_name_delete"></b>?</p>
    </div>
    <div class="modal-footer">
        <button id="btn_delete_player" class="btn btn-danger">Yes</button>
        <button class="btn btn-primary modal_player_delete_close" data-dismiss="modal">No</button>
    </div>
</div>