package com.yjs3505.humanresources.model.entity;

/**
 * 
 * @author Bora SAYINER
 * @since Apr 7, 2018 4:12:15 PM
 * @version 1.0.0
 */
public abstract class AbstractEntity implements GenericEntity {

	private long id;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		AbstractEntity other = (AbstractEntity) obj;
		if (id != other.id) return false;
		return true;
	}

}
