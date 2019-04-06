package io.github.oliviercailloux.y2018.opendata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Class used to convert  ICalendar entities to Planning objects
 *
 * @author Mohamed 
 *
 */

@Path("homi")
public class ParseIcsFile {

	private static final Logger LOG = Logger.getLogger(ParseIcsFile.class.getName());
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String KayHello() {
		
		parcoursICS("example.ics");
		return "Grrr"+new File(".").getAbsoluteFile();
	}
	
	/ **
	* browse an {@link ICalendar} into an object {@link VEvent}
	*
	* @param read the read path of  an ICalendarto encode, can not be null
	* /
	public void parcoursICS(String path) {
		
		
		  String ligne;
		  String date;
		  String cours;
		  String location;
		  String teacher;
		 
			try {

				BufferedReader planning = new BufferedReader(new  FileReader(path));
				ligne = planning.readLine();
				try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
				    while (true) {
				        String line = reader.readLine();
				        if (line == null) {
				           break;
				        }
				     
						if (ligne.substring(0,7).equalsIgnoreCase("DTSTART")) {
							
							date = ligne.substring(7,ligne.length()-1);
							
							LOG.info("date extraite  "+date);
						}
						else if (ligne.substring(0, 5).equalsIgnoreCase("DTEND")) {
						
						}
						else if (ligne.substring(0, 8).equalsIgnoreCase("LOCATION")) {
							
							location = ligne.substring(8,ligne.length());
							LOG.info("location  "+location);

						}
						else if (ligne.substring(0, 7).equalsIgnoreCase("DTSTAMP")) {
							
						}
						else if (ligne.substring(0, 11).equalsIgnoreCase("DESCRIPTION")) {
						
						}
						else if (ligne.substring(0, 7).equalsIgnoreCase("SUMMARY")) {
							
							cours = ligne.substring(7,ligne.length());
							LOG.info("cours   "+cours);

					     
						}
						else if (ligne.substring(0, 9).equalsIgnoreCase("ORGANIZER")) {
						     
							teacher = ligne.substring(9,ligne.length());
							LOG.info("teacher   "+teacher);

						}
				        
				    LOG.info("Information  "+ligne.substring(0,7));
				    }
				}
				
		            planning.close();
			}
			catch (FileNotFoundException e1) {
				
				LOG.info("Erreur : fichier ics inexistant");
			} catch (IOException e) {
				
				LOG.info("Erreur : problème de lecture du fichier ics");
			}
		}
	 
}