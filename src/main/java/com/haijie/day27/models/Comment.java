package com.haijie.day27.models;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String cId;
    private String user;
    private int rating;
    private String cText;
    private int gid;
    
    public Document toDocument() {
		Document doc = new Document();
		doc.put("c_id", getCId());
		doc.put("user", getUser());
		doc.put("rating", getRating());
		doc.put("c_text", getCText());
		return doc;
	}

    public static Comment create(MultiValueMap<String, String> form) {
        Comment comment = new Comment();
		comment.setGid(
			Integer.parseInt(form.getFirst("gid"))
		);
		comment.setUser(form.getFirst("user"));
		comment.setRating(
			Integer.parseInt(form.getFirst("rating"))
		);
		comment.setCText(form.getFirst("cText"));
		return comment;
    }
}
