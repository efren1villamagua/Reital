package reital.parquesamanes.rxtx.app;

import java.io.IOException;

public class PuertoSerialOUT extends PuertoSerial {

	public PuertoSerialOUT() {
		super(Tipo.OUT);
	}

	public void write(String text) throws IOException {
		if (text != null && getOutputStream() != null) {
			getOutputStream().write(text.getBytes());
			getOutputStream().flush();
		}
	}

	public void write(char c) throws IOException {
		if (getOutputStream() != null) {
			getOutputStream().write(c);
			getOutputStream().flush();
		}
	}

}
