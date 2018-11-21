package com.example.todosintegration.domain;

import com.example.todosintegration.domain.converter.JsonToStringDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "xm_entity")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XmEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column(name = "version")
    private Long version;
    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "data", columnDefinition = "CLOB")
    @JsonDeserialize(using = JsonToStringDeserializer.class)
    @JsonRawValue
    private String data;
    @Column(name = "entity_key")
    private String key;
    @Column(name = "state_key")
    private String stateKey;
    @Column(name = "type_key")
    private String typeKey;
    @Column(name = "name")
    private String name;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "description", length = 2000)
    private String description;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JsonProperty("new")
    @Column(name = "new_entity")
    private boolean newEntity;
    @Column(name = "removed")
    private boolean removed;
}
