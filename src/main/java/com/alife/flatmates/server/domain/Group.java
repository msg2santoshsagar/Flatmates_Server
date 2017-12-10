package com.alife.flatmates.server.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Group.
 */
@Entity
@Table(name = "ft_group")
public class Group extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;


    @NotNull
    @Column(nullable = false)
    private boolean active = true;


    @OneToMany(mappedBy="group",orphanRemoval=true,fetch=FetchType.EAGER)
    private Set<GroupUser> groupUser = new HashSet<>();
    

	public Long getId() {
		return id;
	}


	public Group setId(Long id) {
		this.id = id;
		return this;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name != null){
			name = name.trim();
		}
		this.name = name;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Set<GroupUser> getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(Set<GroupUser> groupUser) {
		this.groupUser = groupUser;
	}


	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", active=" + active + ", groupUser=" + groupUser + "]";
	}

}