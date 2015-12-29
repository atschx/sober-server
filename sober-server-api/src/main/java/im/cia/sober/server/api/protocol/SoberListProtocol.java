package im.cia.sober.server.api.protocol;

/**
 * 列表相关的协议。
 */
public class SoberListProtocol extends SoberProtocol {

	private Byte more = 0;

	public Byte getMore() {
		return more;
	}

	public void setMore(Byte more) {
		this.more = more;
	}

}
