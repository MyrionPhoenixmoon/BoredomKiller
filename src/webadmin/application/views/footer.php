</div>
    <div id="push"></div>
  </div>
  <footer id="footer">
    <div class="container">
      <div class="copyright">
          Made with <i class="icon-white icon-heart"></i> by Team Pajama
      </div>
      <div class="info">
        Version 0.1
      </div>
      <div class="info">
        Loaded in {elapsed_time} seconds
      </div>
      <div class="clear"></div>
    </div>
  </footer>

  <script type="text/javascript" src="<?php echo asset_url('js/'); ?>jquery-1.10.1.min.js"></script>
  <script type="text/javascript" src="<?php echo asset_url('js/'); ?>bootstrap.min.js"></script>
  <script type="text/javascript" src="<?php echo asset_url('js/'); ?>main.js"></script>
  <?php if (isset($js) && is_array($js)): ?>
    <?php foreach ($js as $path): ?>
  <script type="text/javascript" src="<?php echo asset_url('js/') . $path; ?>"></script>
    <?php endforeach; ?>
  <?php endif; ?>
</body>
</html>