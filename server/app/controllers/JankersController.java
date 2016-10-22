// JankersController.java

// PACKAGE

package controllers;

// IMPORTS

import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.subatomicsystems.neutrino.server.NeutrinoController;
import com.subatomicsystems.neutrino.server.NeutrinoUtilities;
import com.subatomicsystems.neutrino.server.Record;
import com.subatomicsystems.neutrino.server.XNeutrinoServerMissingParameter;

import models.*;

// CLASS

/*
	JankersController
*/

public class JankersController
extends NeutrinoController
{
	// RECORDFACTORY
	
	public Record
	createRecord (String inRecordType)
	{
		Record	record = null;
		
		if (inRecordType.equals ("jankers"))
		{
			record = new Jankers ();
		}
		else
		{
			record = super.createRecord (inRecordType);
		}
		
		return record;
	}
	
	// ACTIONS
	
	public Object
	all ()
	throws Exception
	{
		return Jankers.getAll (this.connection, this);
	}

	public Object
	create ()
	throws Exception
	{
		Jankers	jankers = new Jankers ();
		jankers.put ("who", validateStringParameter ("who"));
		jankers.put ("why", validateStringParameter ("why"));
		jankers.insert (this.connection);
		
		return jankers;
	}
	
	public Object
	get ()
	throws Exception
	{
		return Jankers.getByID (this.connection, validateIntegerParameter ("id"), this);
	}
	
}

