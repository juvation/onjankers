neutrino.provide ("NewjankersView");
neutrino.require ("neutrino.View");

NewjankersView = function ()
{
  neutrino.View.call (this);
}

neutrino.inherits (NewjankersView, neutrino.View);

// Custom Methods Below

// override
NewjankersView.prototype.onFormSubmission = function (inEvent)
{
	console.log ("NewjankersView.onFormSubmission()");
	
	var	formValid = neutrino.View.prototype.onFormSubmission.call (this, inEvent);

	// we handle the submission, don't let the browser do it
	inEvent.preventDefault ();
	
	if (formValid)
	{
		console.log ("form is valid");
		
		var	who = inEvent.target.elements.namedItem ("who").value;
		var	why = inEvent.target.elements.namedItem ("why").value;
		
		var	url = gApplication.nuServerHost + "/onjankers/jankers/create";
		var	data = "who=" + who + "&why=" + why;

		var	request = 
		{
			url: url,
			data: data,
			dataType: "json",
			async: false,
			type: "GET",
			success: function (inData, inTextStatus, inXHR)
			{
				inEvent.target.elements.namedItem ("who").value = "";
				inEvent.target.elements.namedItem ("why").value = "";
				
				gApplication.getView ("jankers").refresh ();
				console.log ("NewJankersView.onFormSubmission() showing confirmation view");
				gApplication.showView ("confirmation");
			},
			error: function (inXHR, inTextStatus, inError)
			{
				console.error ("load of " + url + " failed");
				console.error (inError);
				alert ("could not save new jankers, sorry...");
			}
		};
		
		neutrino.Utils.getURLContents (request);
	}
}

