package am.ik.demo;

import java.io.Serializable;
import java.util.List;

public class TokenBean implements Serializable {
	private String surface;
	private int position;
	private String partOfSpeechLevel1;
	private String partOfSpeechLevel2;
	private String partOfSpeechLevel3;
	private String partOfSpeechLevel4;
	private String conjugationType;
	private String conjugationForm;
	private String baseForm;
	private String reading;
	private String pronunciation;

	public TokenBean() {
	}

	public TokenBean(String surface, int position, List<String> features,
			String partOfSpeechLevel1, String partOfSpeechLevel2,
			String partOfSpeechLevel3, String partOfSpeechLevel4, String conjugationType,
			String conjugationForm, String baseForm, String reading,
			String pronunciation) {
		this.surface = surface;
		this.position = position;
		this.partOfSpeechLevel1 = partOfSpeechLevel1;
		this.partOfSpeechLevel2 = partOfSpeechLevel2;
		this.partOfSpeechLevel3 = partOfSpeechLevel3;
		this.partOfSpeechLevel4 = partOfSpeechLevel4;
		this.conjugationType = conjugationType;
		this.conjugationForm = conjugationForm;
		this.baseForm = baseForm;
		this.reading = reading;
		this.pronunciation = pronunciation;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getPartOfSpeechLevel1() {
		return partOfSpeechLevel1;
	}

	public void setPartOfSpeechLevel1(String partOfSpeechLevel1) {
		this.partOfSpeechLevel1 = partOfSpeechLevel1;
	}

	public String getPartOfSpeechLevel2() {
		return partOfSpeechLevel2;
	}

	public void setPartOfSpeechLevel2(String partOfSpeechLevel2) {
		this.partOfSpeechLevel2 = partOfSpeechLevel2;
	}

	public String getPartOfSpeechLevel3() {
		return partOfSpeechLevel3;
	}

	public void setPartOfSpeechLevel3(String partOfSpeechLevel3) {
		this.partOfSpeechLevel3 = partOfSpeechLevel3;
	}

	public String getPartOfSpeechLevel4() {
		return partOfSpeechLevel4;
	}

	public void setPartOfSpeechLevel4(String partOfSpeechLevel4) {
		this.partOfSpeechLevel4 = partOfSpeechLevel4;
	}

	public String getConjugationType() {
		return conjugationType;
	}

	public void setConjugationType(String conjugationType) {
		this.conjugationType = conjugationType;
	}

	public String getConjugationForm() {
		return conjugationForm;
	}

	public void setConjugationForm(String conjugationForm) {
		this.conjugationForm = conjugationForm;
	}

	public String getBaseForm() {
		return baseForm;
	}

	public void setBaseForm(String baseForm) {
		this.baseForm = baseForm;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

	@Override
	public String toString() {
		return "TokenBean{" + "surface='" + surface + '\'' + ", position=" + position
				+ ", partOfSpeechLevel1='" + partOfSpeechLevel1 + '\''
				+ ", partOfSpeechLevel2='" + partOfSpeechLevel2 + '\''
				+ ", partOfSpeechLevel3='" + partOfSpeechLevel3 + '\''
				+ ", partOfSpeechLevel4='" + partOfSpeechLevel4 + '\''
				+ ", conjugationType='" + conjugationType + '\'' + ", conjugationForm='"
				+ conjugationForm + '\'' + ", baseForm='" + baseForm + '\''
				+ ", reading='" + reading + '\'' + ", pronunciation='" + pronunciation
				+ '\'' + '}';
	}
}
