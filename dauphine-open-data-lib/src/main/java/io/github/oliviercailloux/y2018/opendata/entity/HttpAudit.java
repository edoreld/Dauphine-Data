package io.github.oliviercailloux.y2018.opendata.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class HttpAudit implements io.github.oliviercailloux.y2018.opendata.entity.Entity {

	private static final long serialVersionUID = -5324014585041077131L;

	public enum HttpMethod {
		GET, POST, PUT, DELETE;

		public static HttpMethod from(String method) {
			switch (method) {
			case "GET":
				return GET;
			case "POST":
				return POST;
			case "PYT":
				return PUT;
			case "DELETE":
				return DELETE;
			default:
				throw new IllegalArgumentException("usupported http method : " + method);
			}
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private Long id;

	@Column(nullable = false)
	@XmlElement
	@NonNull
	private Date date;

	@Column(nullable = false)
	@XmlElement
	@NonNull
	private String path;

	@Column(nullable = true)
	@XmlElement
	private String user;

	@Column(nullable = false)
	@XmlElement
	@Enumerated(EnumType.STRING)
	@NonNull
	private HttpMethod httpMethod;

	public Optional<String> getUser() {
		return Optional.ofNullable(user);
	}

}