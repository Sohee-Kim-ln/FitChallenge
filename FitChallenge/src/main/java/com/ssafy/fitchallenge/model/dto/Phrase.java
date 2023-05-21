package com.ssafy.fitchallenge.model.dto;

public class Phrase {
	private int phraseId;
	private String content;

	public Phrase() {
	}

	public Phrase(int phraseId, String content) {
		super();
		this.phraseId = phraseId;
		this.content = content;
	}

	public int getPhraseId() {
		return phraseId;
	}

	public void setPhraseId(int phraseId) {
		this.phraseId = phraseId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Phrase [phraseId=" + phraseId + ", content=" + content + "]";
	}
	
	

}
