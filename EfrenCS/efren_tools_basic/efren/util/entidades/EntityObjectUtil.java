package efren.util.entidades;

public class EntityObjectUtil {
	private long oid;
	private java.sql.Timestamp utc;

	public EntityObjectUtil() {
		super();
	}

	public long getOid() {
		return oid;
	}

	public java.sql.Timestamp getUtc() {
		return utc;
	}

	public void setOid(long newOid) {
		oid = newOid;
	}

	public void setUtc(java.sql.Timestamp newUtc) {
		utc = newUtc;
	}
}