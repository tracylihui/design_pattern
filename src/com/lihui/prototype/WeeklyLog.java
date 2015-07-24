package com.lihui.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;

public class WeeklyLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6590413587699472211L;
	private Attachment attachment;
	private String name;
	private String date;
	private String content;

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Attachment getAttachment() {
		return (this.attachment);
	}

	public String getName() {
		return (this.name);
	}

	public String getDate() {
		return (this.date);
	}

	public String getContent() {
		return (this.content);
	}

	// 使用序列化技术实现深克隆
	public WeeklyLog deepClone() throws IOException, ClassNotFoundException,
			OptionalDataException {
		// 将对象写入流中
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(this);
		// 将对象从流中取出
		ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (WeeklyLog) ois.readObject();
	}
}