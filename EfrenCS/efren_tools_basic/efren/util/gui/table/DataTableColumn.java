package efren.util.gui.table;


public class DataTableColumn {
	//...
	private String headerName = null;
	private int width = -1;
	private String fieldName = null;
	private boolean editable = false;
	private String orderByAlias = "_NO_ALIAS";
	//...
	public DataTableColumn(String aHeaderName, int aWidth, String aFieldName, boolean isEditable, String anOrderByAlias) {
		super();
		setHeaderName(aHeaderName);
		setWidth(aWidth);
		setFieldName(aFieldName);
		setEditable(isEditable);
		setOrderByAlias(anOrderByAlias);
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getOrderByAlias() {
		return orderByAlias;
	}

	public void setOrderByAlias(String orderByAlias) {
		this.orderByAlias = orderByAlias;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
