package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation   
	private int volume; // 0 ~ 100 rotation 제한
	private boolean power;
	
	
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public void volume(boolean up) {
		volume(this.volume+1);
		volume(volume + (up ? 1: -1));
		if (volume<0) {
		}
	}
	public void volume(int volume) {
		this.volume = volume;
		if (volume<0) {
		}
	}
	public void status() {
		System.out.println(
				"TV[channel ="+ channel+", "
						+ "volume = "+ volume +", "
								+ "power="+ (power? "on" : "off")+"]");
	}
}
