package ihm;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection{
	private String ip;
	private int port;
	public Client(String ip,int port,Consumer<Serializable> onReceiveCallback) {
		super(onReceiveCallback);
		this.ip=ip;
		this.port=port;
	}

	@Override
	protected boolean isServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getIP() {
		// TODO Auto-generated method stub
		return ip;
	}

	@Override
	protected int getPort() {
		// TODO Auto-generated method stub
		return port;
	}

}

