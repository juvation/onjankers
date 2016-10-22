// Application.js

neutrino.require ("neutrino.Application");
neutrino.provide ("Application");

var	Application = function ()
{
	neutrino.Application.call (this);
};
neutrino.inherits (Application, neutrino.Application);

Application.prototype.start = function ()
{
	var	jankersHost = "http://23.21.164.70:8080";
	this.nuServerHost = jankersHost;
	this.nuRootJanxContext.put ("application.serverhost", jankersHost);

	neutrino.Application.prototype.start.call (this);
}

