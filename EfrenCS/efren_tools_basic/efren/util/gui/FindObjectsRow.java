package efren.util.gui;

import efren.util.entidades.EntityObjectUtil;

/**
 * Insert the type's description here.
 * Creation date: (21/12/2003 16:54:30)
 * @author: Efrén Villamagua
 */
public class FindObjectsRow {
	
	private java.lang.String campo01;
	private java.lang.String campo02;
	private String oid;
	private java.sql.Timestamp utc;

	public String getOid() {
		return oid;
	}

	public java.sql.Timestamp getUtc() {
		return utc;
	}

	public void setOid(String newOid) {
		oid = newOid;
	}

	public void setUtc(java.sql.Timestamp newUtc) {
		utc = newUtc;
	}

	
	/**
	 * FindObjectsRow constructor comment.
	 */
	public FindObjectsRow() {
		super();
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21/12/2003 16:54:55)
	 * @return java.lang.String
	 */
	public java.lang.String getCampo01() {
		return campo01;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21/12/2003 16:55:08)
	 * @return java.lang.String
	 */
	public java.lang.String getCampo02() {
		return campo02;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21/12/2003 16:54:55)
	 * @param newCampo01 java.lang.String
	 */
	public void setCampo01(java.lang.String newCampo01) {
		campo01 = newCampo01;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (21/12/2003 16:55:08)
	 * @param newCampo02 java.lang.String
	 */
	public void setCampo02(java.lang.String newCampo02) {
		campo02 = newCampo02;
	}
}
