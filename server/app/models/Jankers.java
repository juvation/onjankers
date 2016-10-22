// Jankers.java

// PACKAGE

package models;

// IMPORTS

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.subatomicsystems.neutrino.server.Database;
import com.subatomicsystems.neutrino.server.Record;
import com.subatomicsystems.neutrino.server.RecordFactory;

// CLASS

/*
	Jankers
*/

public class Jankers
extends Record
{
	// PUBLIC STATIC METHODS
	
	public static void
	deleteByID (Connection inConnection, int inID)
		throws Exception
	{
		Record.deleteByID (inConnection, "jankers", inID);
	}

	public static List<Record>
	getAll (Connection inConnection, RecordFactory inRecordFactory)
		throws Exception
	{
		return Record.getAll (inConnection, inRecordFactory, "jankers", "create_timestamp desc");
	}
	
	public static Jankers
	getByID (Connection inConnection, Integer inID, RecordFactory inRecordFactory)
	throws Exception
	{
		return (Jankers) Record.getByID (inConnection, inID, inRecordFactory, "jankers");
	}

	// PUBLIC CONSTRUCTOR
	
	public
	Jankers ()
	{
	}
	
	// RECORD IMPLEMENTATION
	
	public Map<String, Object>
	getColumnNames ()
	{
		return sColumnNames;
	}

	public String
	getTableName ()
	{
		return "jankers";
	}
	
	// RECORD OVERRIDES
	
	public void
	adorn ()
	{
	}
	
	// TODO!
	
	protected void
	validateForInsert (Connection inConnection)
	{
		System.err.println ("Jankers.validateForInsert() adding create_timestamp");
		put ("create_timestamp", System.currentTimeMillis () / 1000L);
	}
	
	protected void
	validateForUpdate (Connection inConnection)
	{
	}
	
	// STATIC PRIVATE DATA
	
	static Map<String, Object>
	sColumnNames = null;
	
	// STATIC 
	
	// this has to come after the declarations of static variables it uses
	static
	{
		sColumnNames = new HashMap<String, Object> ();
		sColumnNames.put ("id", "id");
		sColumnNames.put ("who", "who");
		sColumnNames.put ("why", "why");
		sColumnNames.put ("create_timestamp", "create_timestamp");
	}
	
}

