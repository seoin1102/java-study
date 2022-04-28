package tv;

public class TV {
	private int channel; // 0 ~ 255 rotation   
	private int volume; // 0 ~ 100 rotation 제한
	private boolean power;
	public TV() {
	}
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
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
	}
	public void volume(int volume) {
		if (volume > 100) {
			this.volume = volume % 100;
		} else if (volume < 0) {
			this.volume = 100 - Math.abs(volume);
		} else {
			this.volume = volume;
		}
	}
	public void status() {
		System.out.println(
				"TV[channel ="+ channel+", "
						+ "volume = "+ volume +", "
								+ "power="+ (power? "on" : "off")+"]");
	}
	public void power(boolean power) {
		this.power = power;
	}

	

	public void channel(int channel) {
		if (channel > 255) {
			this.channel = channel % 255;
		} else if (channel < 0) {
			this.channel = 255 - Math.abs(channel);
		} else {
			this.channel = channel;
		}
			
	}
	
	public void channel(boolean up) {
		channel(channel +=(up?1:-1));
	}

	
	
	

}
