<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>BoredomKiller Webadmin</title>
        <link rel="stylesheet" type="text/css" href="<?php echo asset_url('css/'); ?>bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="<?php echo asset_url('css/'); ?>layout_extended.css">
    </head>
    <body>
        <div class="message-bar">
            <div class="container">
                <span id="alert_text"></span>
            </div>
        </div>
        <header class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <?php echo anchor(base_url(), 'BoredomKiller', array('class' => 'brand')); ?>
                    <nav class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="dropdown">
                                <?php echo anchor('#', 'Games <b class="caret"></b>', array('class' => 'dropdown-toggle', 'data-toggle' => 'dropdown')); ?>
                                <ul class="dropdown-menu">
                                    <li><?php echo anchor('#', 'Games'); ?></a></li>
                                    <li><?php echo anchor('gametypes', 'Game types (genre)'); ?></a></li>
                                    <li><?php echo anchor('#', 'Maps'); ?></a></li>
                                </ul>
                            </li>
                            <li><?php echo anchor('platforms', 'Platforms'); ?></a></li>
                            <li><?php echo anchor('playstyles', 'Playstyles'); ?></a></li>
                            <li><?php echo anchor('modes', 'Modes'); ?></a></li>
                            <li><?php echo anchor('#', 'Challenges'); ?></a></li>
                            <li><?php echo anchor('maluses', 'Maluses'); ?></a></li>
                            <li><?php echo anchor('players', 'Players'); ?></a></li>
                            <li><?php echo anchor('#', 'Stats'); ?></a></li>
                        </ul>
                    </nav><!--/.nav-collapse -->
                </div>
            </div>
        </header>
        <div id="wrap">
            <div class="container">