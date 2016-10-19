class FileModel {
	startRetrieval(){
		// POST to start
	}

	retrieveFiles(){
		// GET to check status of HDD parsing
	}
}

// event listener interface
class Listener{
	listen(){
		throw new "Not implemented error";
	}
}

class AnalyzeButtonListener extends Listener {
	listen(){

	}
}

class HoverButtonListener extends Listener {
	constructor(buttonNames){
		super();
		this.btns = buttonNames;
	}

	listen(){
		$('.action-btn').click(function(e){
			for(var i in this.btns){
				var btn = this.btns[i];
				console.log(btn)
				$('.' + btn + "-btn").toggleClass(btn + "-btn-position");
			}
		}.bind(this));
	}
}