package database;

public class TechnicalData {

	private String videoResolution;
	private String fpsVideo;
	private int bitrateVideo;
	private String codecVideo;
	private int bitrateAudio;
	private double audioFrequency;
	private int audioChannels;
	private String codecAudio;
	private double size;
	private String container;
	private String technicalNotes;
	
	protected TechnicalData() {
		super();
	}
	
	public String getVideoResolution() {
		return videoResolution;
	}
	public void setVideoResolution(String videoResolution) {
		this.videoResolution = videoResolution;
	}
	public String getFpsVideo() {
		return fpsVideo;
	}
	public void setFpsVideo(String fpsVideo) {
		//TODO fare con float
		this.fpsVideo = fpsVideo;
	}
	public int getBitrateVideo() {
		return bitrateVideo;
	}
	public void setBitrateVideo(int bitrateVideo) {
		this.bitrateVideo = bitrateVideo;
		/*try {
			this.bitrateVideo = Integer.valueOf(bitrateVideo);
		} catch (Exception e) {
			catchErrors();
		}*/
	}
	public String getCodecVideo() {
		return codecVideo;
	}
	public void setCodecVideo(String codecVideo) {
		this.codecVideo = codecVideo;
	}
	public int getBitrateAudio() {
		return bitrateAudio;
	}
	public void setBitrateAudio(int bitrateAudio) {
		this.bitrateAudio = bitrateAudio;
		/*try {
			this.bitrateAudio = Integer.valueOf(bitrateAudio);
		} catch (Exception e) {
			catchErrors();
		}*/
	}
	public float getAudioFrequency() {
		return (float)audioFrequency;
	}
	public void setAudioFrequency(double audioFrequency) {
		this.audioFrequency = audioFrequency;
		/*try {
			this.audioFrequency = Float.valueOf(audioFrequency);
		} catch (Exception e) {
			catchErrors();
		}*/
	}
	public int getAudioChannels() {
		return audioChannels;
	}
	public void setAudioChannels(int audioChannels) {
		this.audioChannels = audioChannels;
		/*
		try {
			this.audioChannels = Integer.valueOf(audioChannels);
		} catch (Exception e) {
			catchErrors();
		}*/
	}
	public String getCodecAudio() {
		return codecAudio;
	}
	public void setCodecAudio(String codecAudio) {
		this.codecAudio = codecAudio;
	}
	public float getSize() {
		return (float)size;
	}
	public void setSize(double size) {
		this.size = size;
		/*try {
			this.size = Float.valueOf(size.replace(",", "."));
		} catch (Exception e) {
			catchErrors();
		}*/
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getTechnicalNotes() {
		return technicalNotes;
	}
	public void setTechnicalNotes(String technicalNotes) {
		this.technicalNotes = technicalNotes;
	}
	
	private void catchErrors() {
		// TODO Auto-generated method stub
	}
}
