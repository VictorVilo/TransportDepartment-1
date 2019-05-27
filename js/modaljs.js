var rh = rh || {};
	rh.mq = rh.mq || {};
	
	rh.mq.editing = false;
	
	rh.mq.enableButtons = function() {
		
		$(".reject_application").click(function() {
			$("#reject_modal .modal-title").html("Really deleting  data??");
		});
	};
		