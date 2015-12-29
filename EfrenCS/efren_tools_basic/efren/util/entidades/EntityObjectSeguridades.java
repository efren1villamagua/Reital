package efren.util.entidades;

import java.io.Serializable;

public class EntityObjectSeguridades implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4387010970394274066L;
	private long oid;
	private java.sql.Timestamp timestamp;

	public EntityObjectSeguridades() {
		super();
	}

	public long getOid() {
		return oid;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setOid(long newOid) {
		oid = newOid;
	}

	public void setTimestamp(java.sql.Timestamp newTimestamp) {
		timestamp = newTimestamp;
	}
}