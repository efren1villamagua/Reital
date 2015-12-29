package efren.util;

import java.io.*;

/***
  * Class for redirecting StdErr and StdOut to both a screen and a log file.
  * Log file/stream may be supplied to constructor.  Log may be closed and
  * a new one started.  The default System.out & System.err are always 
  * available in SystemLog.sysout & SystemLog.syserr.
  * <b>Only one instance allowed.</b>
  *<p>
  *  Copyright (C) 1998 Steve Barrett
  *<p>
  *  This library is free software; you can redistribute it and/or
  *  modify it under the terms of the GNU Library General Public
  *  License as published by the Free Software Foundation; either
  *  version 2 of the License, or (at your option) any later version.
  *<p>
  *  This library is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  *  Library General Public License for more details.
  *<p>
  *  You should have received a copy of the GNU Library General Public
  *  License along with this library; if not, write to the Free
  *  Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
  *<p>  
  * <A HREF="http://www.geocities.com/Area51/Crater/3143/otherCode/SystemLog/SystemLog.zip">SystemLog.ZIP</A>
  * <A HREF="http://www.geocities.com/Area51/Crater/3143/otherCode/SystemLog/SystemLog.java">SystemLog.java</A>
  *<p>
  * <A HREF=mailto:stevejbarrett@geocities.com><I>stevejbarrett@geocities.com</I></A>
  * @author   Steve Barrett
  * @version  Version Beta 1.0
  * @see <a href=http://www.geocities.com/Area51/Crater/3143/index.html>VeryLateLayoutPanel</a>
 **/
public class SystemLog {
   private static SystemLog me = null;
   static String ERRSTR = "Cannot create another SystemLog";
								  
   /***
	 * Hold the default values for System.
	 * These are public so they can be used as follows:
	 *<PRE>
	 *   SystemLog syslog = new SystemLog("foo.txt");
	 *   syslog.syserr.println("I don't trust SystemLog()");
	 *</PRE>
	**/
   public static final PrintStream sysout = System.out,
								   syserr = System.err;
   
   OutputStream fos;
   Redirect redirect = null;
   boolean log = true, console = true;

   class Redirect extends FilterOutputStream {

	  	public Redirect (OutputStream os) { 
	  		super(os); 
	  	}
	  
			public void write(byte buf[]) {
			    try {
			        if (log) {
			            fos.write(buf);
			            fos.flush();
			        }
			        if (console) {
			            sysout.write(buf);
			            sysout.flush();
			        }
			    } catch (Exception any) {
			        syserr.println("err in write(byte []) " + any);
			    }
			    try {
			//        ConsoleDialog.singleton().addMessage(buf);
			    } catch (Throwable t2) {
			        t2.getMessage();
			    }
			}
	   
		  public void write(byte buf[], int off, int len) {
			 try {
				if (log) {
				   fos.write(buf, off, len);
				   fos.flush();
				}
				if (console) {
				   sysout.write(buf, off, len);
				   sysout.flush();
				}
			 } catch (Exception any) {
				syserr.println("err in write(byte[], int, int) " + any);
			 }
		  }
	
		  public void write (int b) {
			 try {
				if (log) {
				   fos.write(b);
				   fos.flush();
				}
				if (console) {
				   sysout.write(b);
				   sysout.flush();
				}
			 } catch (Exception any) {
				syserr.println("err in write(int b) " + any);
			 }
		  }
   }

   /***
	 ** unit test
	 **
   public static void main (String[] args) {
	  SystemLog sl = null;
	  try {
		 sl = new SystemLog("SystemLog.txt");
	  } catch (Exception any) {
		 // use of system default error out stream
		 System.out.println("Test SystemLog failed creating log file\n" + any);
		 System.exit(0);
	  }
	  System.out.println("Write to screen and file (SystemLog.txt)");
	  System.err.println("Simulate error to screen and file");
	  sl.setLogging(false);
	  System.out.println("Write to screen but not file");
	  System.err.println("Simulate error to screen but not file");
	  sl.setLogging(true);
	  sl.setConsole(false);
	  System.out.println("Write to file but not screen");
	  System.err.println("Simulate error to file but not screen");
	  sl.setConsole(true);
	  try {
		 sl.setLogStream(new FileOutputStream("SecondFile.txt"));
	  } catch (Exception any) {
		 // use of system default error out stream
		 sl.syserr.println("" + any);
		 System.exit(0);
	  }
	  System.out.println("Write to screen and file (SecondFile.txt)");
	  System.err.println("Simulate error to screen and file");
	  System.out.println("Test singleton code, should error when try " +
		 "to create 2nd SystemLog");
	  // should not work
	  try {
		 SystemLog sl2 = new SystemLog("ErrorLog.txt");
	  } catch (Exception any) { }
	  System.out.println("Test done.");
   }
   */
   /***
	* Creates a SystemLog() - cannot be used until setLogStream() is called.
	* Will throw a runtime error if more than one SystemLog() is instantiated.
	* Note: 
	*<PRE>
	*     Singletons (like this) can be made with private constructors.
	*     The disadvantage is the use of getInstance() is required and 
	*     then the Singleton class is not bean-able.  The advantage is 
	*     that getInstance() can prevent the creation more than one 
	*     instance of the class. Then there is no need to throw an error
	*     if a second class is instantiated.
	*</PRE>
	* @see #setLogStream
	**/
   public SystemLog () { 
	  if (me != null) throw new Error(ERRSTR);
	  me = this;
   }   
   /*** 
	 * Creates SystemLog and performs setLogStream(FileOutputStream)
	 * Will throw a runtime error if more than one SystemLog() is instantiated.
	 * @see #setLogStream
	**/
   public SystemLog (OutputStream fos) {
	  if (me != null) throw new Error(ERRSTR);
	  me = this;
	  if (fos != null) setLogStream(fos);
   }   
   /***
	 * Attempts to create a FileOutputStream using the String file.  Calls
	 * SystemLog(OutputStream fos);
	 * Will throw a runtime error if more than one SystemLog() is instantiated.
	**/
   public SystemLog (String file) throws IOException {
	  this(new FileOutputStream(file, true));
   }      
   /*** 
	 * Performs closeLogStream(true);
	**/
   public void closeLogStream() { closeLogStream(true); }   
   /*** 
	 * Closes the file output stream.  This is the opposite of setLogStream().
	 * Output can only go to console after this is executed until setLogStream()
	 * is called again.  The boolean backtosys determines whether or not
	 * System.out and Ststem.err are set back to their defaults.
	**/
   private void closeLogStream (boolean backtosys) {
	  if (backtosys) {
		 System.setErr(syserr);
		 System.setOut(sysout);
	  }
	  try {
	      if (redirect != null) {
	          redirect.flush();
	          redirect.close(); 
	          redirect = null;
	      }
	      if (fos != null) {
	          fos.flush();
	          fos.close();
	      }
	  } catch (Exception any) { syserr.println("" + any); }
   }   
   /***
	 * calls closeLogStream()
	 * @see #closeLogStream
	 * @exception Throwable See java.lang.Object.finalize which says [Need description!]
	**/
   protected void finalize() throws Throwable {
	  closeLogStream();
   }   
   public SystemLog getInstance() {
	  if (me == null) me = new SystemLog();
	  return me;
   }   
   public OutputStream getLogStream () { return fos; }   
   /***
	 * Returns whether or not writing to System.out & System.err
	**/ 
   public boolean isConsole () { return console; }   
   /***
	 * Returns whether or not output is supposed to be written to file
	 * if one is present.
	**/
   public boolean isLogging () { return log; }   
public void keepAnother() {
	me = null;
}
   /***
	 * Turn output to console (System.out & System.err) On/Off. 
	**/ 
   public void setConsole (boolean writeToConsole) { 
	  console = writeToConsole;
   }   
   /***
	 * If writeToLogfile == true then output to System.out and System.err 
	 * is written to the FileOutputStream set with setLogStream() or in the
	 * constructor.
	 * @see #setLogStream
	 * @see #SystemLog
	**/
   public void setLogging (boolean writeToLogfile) {  
	  log = writeToLogfile;
   }   
   /***
	 * Redirects System.err and System.out to both a FileOutputStream and
	 * the console.  Calls closeLog() first.  If logging was stopped with 
	 * close log, it is restarted.
	**/
   public void setLogStream (OutputStream os) {
	  if (redirect != null)
		 closeLogStream(false);
	  redirect = new Redirect(os);
	  System.setOut(new PrintStream(redirect));
	  System.setErr(new PrintStream(redirect));
	  fos = os;
	  log = true;
   }   
}
