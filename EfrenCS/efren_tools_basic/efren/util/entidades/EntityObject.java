package efren.util.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public class EntityObject implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4064704159444835138L;
	private long oid;
	private Timestamp utc;
	private long secretId = -1;
	//private Class javaClass;
	//protected TableMap map = null;

	public EntityObject() {
		super();
		initialize();
	}
	
	private void initialize() {
//		this.map = new TableMap();
	}

	public long getOid() {
		return oid;
	}

	public Timestamp getUtc() {
		return utc;
	}

	public void setOid(long newOid) {
		oid = newOid;
	}

	public void setUtc(Timestamp newUtc) {
		utc = newUtc;
	}
	/**
	 * 
	 */
/*	
	protected Integer crear() {
		try {
			
			HttpSession session = ServiceSessionManager.getSession(map.getReq());
			
			Statement st = this.map.getCon().createStatement();
			
			map.getEntidad().setOid(ServicingOIDManager.newOid(map.getSchemaName()));
			
            String sql = "INSERT INTO "+map.getSchemaName()+"."+this.map.getTableName()+" (";
            
            Enumeration<String> camposJava = this.map.keys();
            String campoJava;
            String campoSQL;
            String separador1 = "";
            while (camposJava.hasMoreElements()) {
            	campoJava = camposJava.nextElement();
            	campoSQL = this.map.get(campoJava);
				sql = sql+separador1+campoSQL;
				separador1 = ",";
			}
            sql = sql+") VALUES (";
            camposJava = this.map.keys();
            Object valor;
            separador1 = "";
            Method metodo;
            String returnTypeClassName;
            String registroAudit = "";
            while (camposJava.hasMoreElements()) {
            	campoJava = camposJava.nextElement();
            	campoSQL = this.map.get(campoJava);
            	if (campoJava.equals("utc")) {
            		sql = sql+separador1+" CURRENT TIMESTAMP ";
            	} else {
	            	metodo = this.javaClass.getMethod("get"+campoJava.substring(0, 1).toUpperCase()+campoJava.substring(1));
	            	valor = metodo.invoke(map.getEntidad());
	            	returnTypeClassName = metodo.getReturnType().getName();
	            	if (returnTypeClassName.equals("java.lang.String") || returnTypeClassName.equals("java.lang.Character")) {
	            		sql = sql+separador1+"'"+valor+"'";	
	            	} else {
	            		sql = sql+separador1+valor;
	            	}
            		registroAudit = registroAudit+"&&"+campoSQL+"=>"+valor;
            	}
				separador1 = ",";
			}
            sql = sql+")";

            int afectados = st.executeUpdate(sql);
            
            int afectadosAudit = ServicingAuditoriaManager.audit(session, map.getReq(), st, 1, map.getEntidad().getOid(), map.getSecretId(),
            		this.map.getSchemaName()+"."+this.map.getTableName(), ServicingAuditoriaManager.ABM_NUEVO, registroAudit);
            
            st.close();
			
			return new Integer(afectados);
			
		} catch (Throwable exc) {
			ServicingSystemLogManager.error(exc.getMessage());
		}
		return new Integer(0);
	}
	protected Integer actualizar() {
		try {
			
			HttpSession session = ServiceSessionManager.getSession(map.getReq());
			
			Connection con = ServicingConn.connect(map.getReq(), session, map.getSecretId(), map.getSchemaName());

			Statement st = con.createStatement();
			
			String sql = "UPDATE "+map.getSchemaName()+"."+this.map.getTableName()+" SET ";
            
            Enumeration<String> camposJava = this.map.keys();
            String campoJava;
            String campoSQL;
            String separador1 = "";
            camposJava = this.map.keys();
            Object valor;
            separador1 = "";
            Method metodo;
            String returnTypeClassName;
            String registroAudit = "";
            while (camposJava.hasMoreElements()) {
            	campoJava = camposJava.nextElement();
            	campoSQL = this.map.get(campoJava);
            	if (campoSQL.toUpperCase().equals("OID")) {
            		continue;
            	}
            	if (campoJava.equals("utc")) {
            		sql = sql+separador1+campoSQL+"=CURRENT TIMESTAMP ";
            	} else {
	            	metodo = this.javaClass.getMethod("get"+campoJava.substring(0, 1).toUpperCase()+campoJava.substring(1));
	            	valor = metodo.invoke(map.getEntidad());
	            	returnTypeClassName = metodo.getReturnType().getName();
	            	if (returnTypeClassName.equals("java.lang.String") || returnTypeClassName.equals("java.lang.Character")) {
	            		sql = sql+separador1+campoSQL+"='"+valor+"'";	
	            	} else {
	            		sql = sql+separador1+campoSQL+"="+valor;
	            	}
            		registroAudit = registroAudit+"&&"+campoSQL+"=>"+valor;
            	}
				separador1 = ",";
			}
            sql = sql+" WHERE OID="+map.getEntidad().getOid()+" AND UTC={ ts '"+map.getEntidad().getUtc()+"' }";

            int afectados = st.executeUpdate(sql);
            
            int afectadosAudit = ServicingAuditoriaManager.audit(session, map.getReq(), st, 1, map.getEntidad().getOid(), map.getSecretId(),
            		this.map.getSchemaName()+"."+this.map.getTableName(), ServicingAuditoriaManager.ABM_MODIFICAR, registroAudit);
            
            st.close();
            con.close();
			
			return new Integer(afectados);
			
		} catch (Throwable exc) {
			ServicingSystemLogManager.error(exc.getMessage());
		}
		return new Integer(0);
	}
	protected Integer eliminar() {
		try {
			
			HttpSession session = ServiceSessionManager.getSession(map.getReq());
			
			Connection con = ServicingConn.connect(map.getReq(), session, map.getSecretId(), map.getSchemaName());

			Statement st = con.createStatement();
			
			String sql = "DELETE FROM "+map.getSchemaName()+"."+this.map.getTableName()
				+" WHERE OID="+map.getEntidad().getOid()+" AND UTC={ ts '"+map.getEntidad().getUtc()+"' }";
			
			String registroAudit = "OID=>"+map.getEntidad().getOid();

			int afectados = st.executeUpdate(sql);
            
            int afectadosAudit = ServicingAuditoriaManager.audit(session, map.getReq(), st, 1, map.getEntidad().getOid(), map.getSecretId(),
            		this.map.getSchemaName()+"."+this.map.getTableName(), ServicingAuditoriaManager.ABM_ELIMINAR, registroAudit);
            
            st.close();
            con.close();
			
			return new Integer(afectados);
			
		} catch (Throwable exc) {
			ServicingSystemLogManager.error(exc.getMessage());
		}
		return new Integer(0);
	}

	public Class getJavaClass() {
		return javaClass;
	}

	public void setJavaClass(Class clase) {
		this.javaClass = clase;
		Field campos[] = this.javaClass.getDeclaredFields();
		for (int i = 0; i < campos.length; i++) {
			if (!campos[i].getName().toUpperCase().equals("SERIALVERSIONUID")) {
				this.map.put(campos[i].getName(), campos[i].getName().toUpperCase());
			}
		}
		this.map.put("oid", "OID");
		this.map.put("utc", "UTC");
	}
*/
	public long getSecretId() {
		return secretId;
	}

	public void setSecretId(long secretId) {
		this.secretId = secretId;
	}
}