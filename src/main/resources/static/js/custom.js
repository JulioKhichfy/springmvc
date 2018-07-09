$('#myModal').on('shown.bs.modal', function(event) {
	var button = $(event.relatedTarget)
	var nomeFestinha = button.data('whatever')
	var modal = $(this)
	modal.find('.modal-title').text('Festaaaaa :) - ' + nomeFestinha)
	modal.find('#festinha').val(nomeFestinha)
	modal.find('.modal-title').text(nomeFestinha)
})