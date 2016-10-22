neutrino.provide ("ConfirmationView");
neutrino.require ("neutrino.View");

ConfirmationView = function ()
{
  neutrino.View.call (this);
}

neutrino.inherits (ConfirmationView, neutrino.View);

// override
ConfirmationView.prototype.onBeforeVisible = function (inRunDynamics)
{
	neutrino.View.prototype.onBeforeVisible.call (this, inRunDynamics);
	
	console.log ("ConfirmationView.onBeforeVisible()");

	if (this.hiderTask)
	{
		cancelTimeout (this.hiderTask);
		this.hiderTask = null;
	}
}

ConfirmationView.prototype.onVisible = function ()
{
	neutrino.View.prototype.onVisible.call (this);

	console.log ("ConfirmationView.onVisible() setting hider timeout with key: " + this.nuKey);

	var	self = this;
	
	this.hiderTask = setTimeout
	(
		function ()
		{
			gApplication.hideView (self.nuKey);
			self.hiderTask = null;
		},
		2000
	);
}

